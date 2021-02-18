/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Errors.*;
import Model.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
/**
 *
 * @author Marcelo Guzmán
 */
public class StackController {
    Question lastQuestion;
    Answer lastAnswer;
    Stack stack = new Stack();
    
    /**
     * Ingresa un nuevo usuario al ArrayList de usuarios del Stack
     * @param username nombre del usuario
     * @param password contrasena elegida
     * @return true si se agrega correctamente el usuario al stack
     */
    public boolean register(String username, char[] password) throws NoPasswordEnteredException, NoUsernameEnteredException, UsernameAlreadyExistsException{
        if(password.length==0){
            throw new NoPasswordEnteredException();
        }
        if(username.isEmpty()){
            throw new NoUsernameEnteredException();
        }
        if(stack.getUsers().isEmpty()){
            stack.getUsers().add(new User(username, password));
            return true;
        }else{
            if(!existsUser(username)){
                stack.getUsers().add(new User(username, password));  
                return true;
            }else{
                throw new UsernameAlreadyExistsException();
            }
        }
    }
    
    /**
     * Se setea el User en CurrentSesion del Stack y se cambia el tipo de sesion a activa (true).
     * @param username nombre del usuario
     * @param password contrasena elegida
     * @return true si se agrega correctamente el usuario al stack
     */
    public boolean login(String username, char[] password) throws IncorrectPasswException, InexistentUserException, NoPasswordEnteredException, NoUsernameEnteredException{
        if(password.length==0){
            throw new NoPasswordEnteredException();
        }
        if(username.isEmpty()){
            throw new NoUsernameEnteredException();
        }
        
        int credentialsChecker = validateCredentials(username, password);
        
        if(credentialsChecker==-1){
            throw new InexistentUserException();
        }else if(credentialsChecker==2){
            throw new IncorrectPasswException();
        }else{ 
            stack.getCurrentSession().setType(true); // sesion online
            stack.getCurrentSession().setOnlineUser(stack.getUser(username));
            return true;
        }
    }
    
    
    /**
     * Cambia la sesion a false, indicando que no estamos conectados
     * Se cambia el usuario a null
     */
    public void logOut() throws NoCurrentUserOnlineFoundException{
        if(stack.getCurrentSession().getType()){
            stack.getCurrentSession().setType(false);
            stack.getCurrentSession().setOnlineUser(null);
        }else{
           throw new NoCurrentUserOnlineFoundException();
        }    
   }
    
    
    /**
     * Ingresa una nueva pregunta al arreglo de preguntas
     * @param title titulo de la pregunta   
     * @param content contenido de la pregunta
     * @param labels lista de etiquetas de la pregunta
     * @return booleano indicando agregacion valida o no
     */
    public boolean ask(String title, String content, ArrayList<Label> labels){
        if(stack.getCurrentSession().getType()){
            User currentUser = stack.getCurrentSession().getOnlineUser();
            String username = currentUser.getUsername();
            LocalDateTime date = LocalDateTime.now();  
            
            Question question = new Question(date, username, title, content); // Creamos la Pregunta
            stack.getQuestions().add(question);
            currentUser.makeQuestion(Question.getTotalQuestions());
            if(labels!=null){
                question.setLabels(labels);
            }
            setLastQuestion(question);
            return true;
        }
        return false;
    }
    
    /**
     * Anade una nueva respuesta a una pregunta dentro de questions
     * @param selectedQuestion pregunta que se desea responder
     * @param content contenido de la respuesta
     * @return booleano que indica correcta agregacion de respuesta
     */
    public boolean answer(Question selectedQuestion, String content){
        if(selectedQuestion==null){
            return false;
        }else if(stack.getCurrentSession().getType()){ // getType debe ser True -online-
            String username = stack.getCurrentSession().getOnlineUsername();
            LocalDateTime date = LocalDateTime.now();
            Answer answer = new Answer(date, username, content, selectedQuestion.getAnswersCount()+1);
            selectedQuestion.addAnswer(answer);
            selectedQuestion.setUpdateDate(date);
            setLastAnswer(answer);
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Recompensa una pregunta para llamar atencion de usuarios y obtener mejores respuestas
     * @param rewardedQuestion pregunta a ser recompensada
     * @param amountReward la cantidad dispuesta como recompenas
     * @return booleano que indica si se logra recompensar o no la pregunta
     */
    public boolean reward(Question rewardedQuestion, int amountReward){
        User onlineUser = this.stack.getCurrentSession().getOnlineUser();
        int userReputation = onlineUser.getReputation();
        int calculateError = userReputation - amountReward;
        if(userReputation<=0){
            return false;
        }else if(calculateError<0){
            return false;
        }
        rewardedQuestion.setReward(amountReward);
        onlineUser.setReputation(-1*amountReward);
        return true;
    }
    
    /**
     * Verifica mediante el nombre de usuario si existe username o no, dentro de ArrayList users
     * @param username nombre de usuario
     * @return true cuando se encuentra; en cualquier otro caso retorna false
     */
    private boolean existsUser(String username){
        int length = stack.getUsers().size(), i;
        for(i=0; i < length; i++) {
            if(stack.getUsers().get(i).getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
    
    private int validateCredentials(String username, char[] password){
        int length = stack.getUsers().size(), i;
        User user;
        for (i=0; i < length; i++) {
            user = stack.getUsers().get(i);
            
            boolean equalUsernames = user.getUsername().equals(username);
            boolean equalPasswords =  matchesPassword(password, user.getPassword());
            
            if(equalUsernames && equalPasswords){
                return 1;
            }else if(equalUsernames && !equalPasswords){
                return 2;
            }
        }
        return -1;
    }
    
    
    
    private boolean matchesPassword(char[] password0, char[] password1){
        if(password0.length!=password1.length){
            return false;
        }
        
        for(int i=0; i<password0.length; i++){
            if(password0[i]!=password1[i]){
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Crea una etiqueta y la agrega a labels
     * @param name nombre de la etiqueta
     * @param description descripcion de la etiqueta
     */
    public void createLabel(String name, String description){
        Label label = new Label(name, description);
        stack.getLabels().add(label);
    }
    
    
     /**
     * Obtener una etiqueta particular desde ArrayList labels
     * @param labelName string nombre de la etiqueta
     * @return null si no se encuentra; devuelve la etiqueta si esta existe
     */
    public Label getLabel(String labelName){
        for(Label l : stack.getLabels()){
            if(l.getName().equals(labelName)){
                return l;
            }
        }
        return null;
    }
    
    /**
     * Recupera una pregunta del ArrayList questions a traves de su posicion en la lista
     * @param index Indice de la pregunta en el ArrayList. 
     * @return pregunta en el indice index
     */
    public Question getQuestion(int index){
        return stack.getQuestions().get(index);
    }
    
    /**
     * Obtener una pregunta desde ArrayList questions a traves del ID unico de cada pregunta
     * @param id numero de pregunta que se quiere obtener
     * @return pregunta que corresponde al id deseado. Retorna null si no  se encuentra.
     */
    public Question getQuestionByID(int id){
        for(int i=0; i<Question.getTotalQuestions(); i++){
            Question question = this.stack.getQuestions().get(i);
            if(question.getId()==id){
                return question;
            }
        }
        return null;
    }
    
    public String getOnlineUsername(){
        return stack.getCurrentSession().getOnlineUsername();
    }
    
    public boolean getSessionType(){
        return stack.getCurrentSession().getType();
    }
    
    public ArrayList<Label> getLabels(){
        return stack.getLabels();
    }
    
    public Question getLastQuestion(){
        return this.lastQuestion;
    }
    public Answer getLastAnswer(){
        return this.lastAnswer;
    }
    
    public static String setDateFormat(LocalDateTime date, String format){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return date.format(formatter);
    }
    
    private void setLastQuestion(Question q){
        this.lastQuestion = q;
    }
    private void setLastAnswer(Answer a){
        this.lastAnswer = a;
    }
}

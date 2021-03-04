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
import java.util.HashMap;
/**
 *
 * @author Marcelo Guzmán
 */
public class StackController {
    Stack stack;
    
    public StackController(Stack stack){
        this.stack = stack;
    }
    
    /**
     * Ingresa un nuevo usuario al ArrayList de usuarios del Stack
     * @param username nombre del usuario
     * @param password contrasena elegida
     * @return true si se agrega correctamente el usuario al stack
     */
    public boolean register(String username, char[] password) throws NoPasswordEnteredException, NoUsernameEnteredException, 
                                                                     UsernameAlreadyExistsException{
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
    public boolean login(String username, char[] password) throws IncorrectPasswException, InexistentUserException, 
                                                                  NoPasswordEnteredException, NoUsernameEnteredException{
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
            stack.getCurrentSession().setOnlineUser(getUser(username));
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
    public boolean ask(String title, String content, ArrayList<Label> labels) throws FieldEmptyException{
        
        if(title.isEmpty() || content.isEmpty()){
            throw new FieldEmptyException();
        }
        
        if(stack.getCurrentSession().getType()){
            User currentUser = getOnlineUser();
            String username = currentUser.getUsername();
            LocalDateTime date = LocalDateTime.now();  
            
            Question question = new Question(date, username, title, content); // Creamos la Pregunta
            
            /* Registramos las preguntas en los respectos ArrayLists */
            stack.getQuestions().add(question);
            getUser(username).getQuestions().add(Question.getTotalQuestions());
            
            if(labels!=null){
                question.setLabels(labels);
            }
            
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
    public boolean answer(Question selectedQuestion, String content) throws FieldEmptyException{
        if(content.isEmpty() || content.isBlank()){
            throw new FieldEmptyException();
        }
        if(selectedQuestion==null){
            return false;
        }else if(stack.getCurrentSession().getType()){ // getType debe ser True -online-
            String username = getOnlineUsername();
            LocalDateTime date = LocalDateTime.now();
            Answer answer = new Answer(date, username, content, selectedQuestion.getAnswersCount()+1);
            selectedQuestion.addAnswer(answer);
            selectedQuestion.setUpdateDate(date);
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
    public boolean reward(Question rewardedQuestion, int amountReward) throws InsufficientReputationException{
        User onlineUser = this.stack.getCurrentSession().getOnlineUser();
        int userReputation = onlineUser.getReputation();
        int calculateError = userReputation - amountReward;
        if(userReputation<=0 || calculateError<0){
            throw new InsufficientReputationException();
            
        }
        rewardedQuestion.setReward(amountReward);
        onlineUser.setReputation(-1*amountReward);
        return true;
    }
    
        /**
     * Cambia el estado de una pregunta a Cerrada, si existe algun monto en recompensa se le da al usuario\n
     * al cual le aceptan la respuesta
     * @param question pregunta de usuario online de donde se obtiene la respuesta
     * @param answer respuesta especifica aceptada
     * @return true cuando se acepta correctamente la respuesta, se cierra la pregunta
     */
    public boolean accept(Question question, Answer answer){
        User currentUser = getOnlineUser();
        User rewardedUser = getUser(answer.getAuthor());
        if(currentUser.haveQuestion(question.getId())){
            question.setState();
            answer.setState();
            int reward= question.getReward();
            if(reward>0){
                rewardedUser.setReputation(reward+15);
            }else{
                rewardedUser.setReputation(15);
            }
            currentUser.setReputation(2);
            
            return true;
        }
        return false;
        
    }
        
    
    /* Funcionalidad de vote */ 
    
    /** 
     * Emite un voto positivo del usuario activo hacia el bloque seleccionado.
     * @param selection Instancia de Pregunta/Respuesta que extiende de InteractiveBlock
     */
    public void submitVoteUp(InteractiveBlock selection){
        selection.getVotes().setVotesUp(true);
        selection.getSubmittedVotes().put(this.getOnlineUsername(), true);
        
        setUsersReputation(selection, true);
        System.out.println(selection.getVotes().toString());
        
    }
    
    /** 
     * Elimina el voto positivo que el usuario activo emitió al bloque seleccionado.
     * @param selection Instancia de Pregunta/Respuesta que extiende de InteractiveBlock
     */
    public void undoVoteUp(InteractiveBlock selection){
        setUsersReputation(selection);
        
        selection.getVotes().setVotesUp(false);
        selection.getSubmittedVotes().remove(this.getOnlineUsername());
        
        
        System.out.println(selection.getVotes().toString());
    }
    
    /** 
     * Emite un voto negativo del usuario activo hacia el bloque seleccionado.
     * @param selection Instancia de Pregunta/Respuesta que extiende de InteractiveBlock
     */
    public void submitVoteDown(InteractiveBlock selection){
        selection.getVotes().setVotesDown(true);
        selection.getSubmittedVotes().put(this.getOnlineUsername(), false);
        
        // damos la reputación que otorga un voto negativo
        setUsersReputation(selection, false);
        System.out.println(selection.getVotes().toString());
    }
    
    /** 
     * Elimina el voto negativo que el usuario activo emitió en el bloque seleccionado.
     * @param selection Instancia de Pregunta/Respuesta que extiende de InteractiveBlock
     */
    public void undoVoteDown(InteractiveBlock selection){
        // quitamos la reputación que otorgó un voto negativo
        setUsersReputation(selection);
        
        selection.getVotes().setVotesDown(false);
        selection.getSubmittedVotes().remove(this.getOnlineUsername());
        
        
        System.out.println(selection.getVotes().toString());
    }
    
    /**
     * Metodo utilizado para dar reputación a los usuarios involucrados en el voto
     * @param selection Bloque seleccionado (instancia de pregunta/respuesta).
     * @param voteType booleano que data el tipo de voto: true positivo, false negativo.
     */
    private void setUsersReputation(InteractiveBlock selection, boolean voteType){
        User whoVoted = getOnlineUser();
        User userVoted = getUser(selection.getAuthor());

        if(voteType){
            userVoted.setReputation(10);
        }else{
            userVoted.setReputation(-2);
            whoVoted.setReputation(-1);
        }
    }
    
    /**
     * Método utilizado para remover la reputación entregada si se retira el voto emitido al bloque.
     * @param selection Bloque seleccionado (instancia de pregunta/respuesta).
     */
    private void setUsersReputation(InteractiveBlock selection){
        User whoVoted = getOnlineUser();
        User userVoted = getUser(selection.getAuthor());
        HashMap<String, Boolean> submittedVotes = selection.getSubmittedVotes();
        Boolean submittedVote = submittedVotes.get(whoVoted.getUsername());
        
        if(submittedVote){
            userVoted.setReputation(-10);
        }else{
            userVoted.setReputation(2);
            whoVoted.setReputation(1);
        }
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
    
    /**
     * Metodo que ayuda a verificar la credencial password de un usuario.
     * @param password0 Contrasena a evaluar
     * @param password1 Contrasena real del usuario
     * @return true si la contrasena coincide; false en cualquier caso de que no coincidan.
     */
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
     * Obtiene la instancia del usuario registrado con el String username
     * @param username String representando al nombre del usuario
     * @return User Usuario con nombre de usuario username
     */
    public User getUser(String username){
        for(User u : stack.getUsers()){
            if(u.getUsername().equals(username)){
                return u;
            }
        }
        return null;
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
    
    public CurrentSession getCurrentSession(){
        return stack.getCurrentSession();
    }
    
    public User getOnlineUser(){
        return stack.getCurrentSession().getOnlineUser();
    }
    
    public String getOnlineUsername(){
        return getOnlineUser().getUsername();
    }
    
    public boolean getSessionType(){
        return stack.getCurrentSession().getType();
    }
    
    public ArrayList<Label> getLabels(){
        return stack.getLabels();
    }
    
    /**
     * Recupera desde el stack con el que se maneja, la última pregunta hecha.
     * @return Instancia de clase Question que representa a la ultima pregunta registrada en el stack principal.
     */
    public Question getLastQuestion(){
        ArrayList<Question> questions = stack.getQuestions();
        return questions.get(questions.size()-1);
    }
    
    /**
     * Recupera desde el stack con el que se trabaja, la ultima respuesta a una pregunta (parámetro).
     * @param question Pregunta de donde se quiere recuperar la ultima respuesta.
     * @return Ultima respuesta hecha en parámetro question.
     */
    public Answer getLastAnswer(Question question){
        ArrayList<Answer> answers = question.getAnswers();
        return answers.get(answers.size()-1);
    }
    
    public static String setDateFormat(LocalDateTime date, String format){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return date.format(formatter);
    }


}

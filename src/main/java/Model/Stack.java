package Model;
import java.util.ArrayList;

import java.time.LocalDateTime;  
/**
 * Clase Stack que contiene los atributos necesarios para representar un Sistema de
 * Preguntas y Respuestas.
 * @author Marcelo Guzman
 */
public class Stack{
    
    private CurrentSession currentSession;
    private ArrayList<User> users;
    private ArrayList<Question> questions;
    private ArrayList<Label> labels;
    
    /**
     * Constructor de Stack
     * Inicializa currentSession, users, questions y labels como ArrayList vacios
     */
    public Stack(){
        this.currentSession = new CurrentSession();
        this.users= new ArrayList<>();
        this.questions = new ArrayList<>();
        this.labels = new ArrayList<>();
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
        }else if(this.currentSession.getType()){ // getType debe ser True -online-
            String username = this.currentSession.getOnlineUsername();
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
    public boolean reward(Question rewardedQuestion, int amountReward){
        User onlineUser = this.currentSession.getOnlineUser();
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
     * Cambia el estado de una pregunta a Cerrada, si existe algun monto en recompensa se le da al usuario\n
     * al cual le aceptan la respuesta
     * @param question pregunta de usuario online de donde se obtiene la respuesta
     * @param answer respuesta especifica aceptada
     * @return true cuando se acepta correctamente la respuesta, se cierra la pregunta
     */
    public boolean accept(Question question, Answer answer){
        User currentUser = currentSession.getOnlineUser();
        User rewardedUser = getUserByName(answer.getAuthor());
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
    
    /**
     * 
     * @param selection Respuesta\Pregunta que se quiere votar 
     * @param voteType booleano, true es voto positivo y false voto negativo
     * @return true cuando se termina de votar
     */
    public boolean vote(InteractiveBlock selection, boolean voteType){
        User whoVoted = currentSession.getOnlineUser();
        User userVoted = getUserByName(selection.getAuthor());
        selection.votes.makeVote(voteType);
        
        if(voteType){
            userVoted.setReputation(10);
        }else{
            userVoted.setReputation(-2);
            whoVoted.setReputation(-1);
        }
        return true;
    }
    
    
    /**
     * Valida la existencia de una etiqueta ingresada
     * @param name nombre de la etiqueta
     * @return se devuelve la etiqueta si se logra encontrar, si no; null
     */
    public Label existsLabel(String name){
        Label label;
        for(int i=0; i<labels.size(); i++){
            label = labels.get(i);
            if(name.equals(label.getName())){
                return label;
            }
        }
        return null;
    }
    

    
    /**
     * Validar que un usuario realmente se encuentre registrado dentro de users
     * @param username nombre de usuario que deseamos validar
     * @param password contrasena de usuario que deseamos validar
     * @return cuando se encuentra, retorna la posicion que ocupa dentro del ArrayList; si no, devuelve -1
     */
    private int validateCredentials(String username, String password){
        int length = this.users.size(), i;
        for (i=0; i < length; i++) {
            User user = users.get(i);
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return i;
            }
        }
        return -1;
    }
    

    
    /**
     * Da formato de string a las instancias question dentro de questions
     * @return string equivalente a las Preguntas del Stack
     */
    public String questionsToString(){
        String questionsStr = "", question;
        for (int i=0; i<Question.getTotalQuestions(); i++){
            question = this.questions.get(i).toString();
            questionsStr = questionsStr + "\n\n" + question;
        }
        return questionsStr;
    }
    
    /** 
     * Da formato de string a las Preguntas ABIERTAS dentro del Stack
     * @return string equivalente a las preguntas que se encuentran abiertas dentro del Stack
     */
    public String openQuestionsToString(){
        String questionsStr = "";
        Question question;
        for(int i=0; i<Question.getTotalQuestions(); i++){
            question = this.questions.get(i);
            if(question.getState().equals("Abierta")){
                questionsStr = questionsStr + "\n\n" + question.toString();
            }
        }
        return questionsStr;
    }
    
    /**
     * Da formato de strings a las Preguntas hechas especificamente por un usuario
     * @param user usuario del cual queremos obtener las preguntas
     * @return String equivalente a las Preguntas hechas por el usuario user
     */
    public String userQuestionsToString(User user){
        String questionsStr = "", answersStr;
        Question question;
        for(int i=0; i<Question.getTotalQuestions(); i++){
            question = this.questions.get(i);
            if(user.getUsername().equals(question.getAuthor())){
                if(question.getState().equals("Abierta")){ // imprimimos las preguntas abiertas
                    answersStr = question.answersToString();
                    questionsStr = questionsStr + "\n\n" + question.toString() + "\n\t[Respuestas: ]\n" + answersStr + "-FIN RESPUESTAS-\n\n";
                }
            }
        }
        return questionsStr;
    }
    
    /**
     * Convierte preguntas y respuestas que NO pertenecen al usuario online, para que no se vote a si mismo
     * @return String equivalente a las P\R que no fueron hechas del usuario
     */
    public String blocksToString(){
        String blocks = "", answers;
        Question question;
        for(int i=1; i<=Question.getTotalQuestions(); i++){
            question = getQuestion(i);
            User onlineUser = currentSession.getOnlineUser();
            if(!question.getAuthor().equals(onlineUser.getUsername())){ // Comprobar que no sea el mismo que se vote
                answers = question.answersNotFromXtoString(onlineUser); // Imprimo solo respuestas que no son del usuario
                blocks = blocks + question.toString() + "\n\t[Respuestas: ]\n" + answers + "\n\t-FIN RESPUESTAS-\n\n";
            }
        }
        return blocks;
    }
    
    /**
     * @return String equivalente a las etiquetas registradas en el sistema
     */
    public String labelsToString(){
        String strLabels = "";
        for(int i=0; i<labels.size(); i++){
                strLabels += labels.get(i).toString() + "\n\n";
        }
        return strLabels;
    }
    
    /**
     * Convierte el Stack en un string equivalente que muestra la informacion actual
     * @return String equivalente con la informacion del Stack 
     */
    @Override
    public String toString(){
        String user = currentSession.getOnlineUser().toString();
        String blocks = "", answers;
        Question question;
        for(int i = 1; i <= Question.getTotalQuestions(); i++) {
            question = getQuestion(i);
            answers = question.answersToString();
            blocks += question.toString() + answers +"\n\n"; 
        }
        return user+"\n\n"+blocks;
    }   
    
    /**
     * Obtener una pregunta desde ArrayList questions
     * @param id numero de pregunta que se quiere obtener
     * @return pregunta con el numero de id deseado
     */
    public Question getQuestion(int id){
        for(int i=0; i<Question.getTotalQuestions(); i++){
            Question question = this.questions.get(i);
            if(question.getId()==id){
                return question;
            }
        }
        return null;
    }
    
    /**
     * Obtener una etiqueta particular desde ArrayList labels
     * @param labelName string nombre de la etiqueta
     * @return null si no se encuentra; devuelve la etiqueta si esta existe
     */
    public Label getLabel(String labelName){
        Label label;
        for(int i=0; i<labels.size(); i++){
            label = labels.get(i);
            if(label.getName().equals(labelName)){
                return label;
            }
        }
        return null;
    }
    
    /**
     * Obtener desde ArrayList users un usuario 
     * @param username string nombre de usuario
     * @return deuvelve al usuario si se encuentra; si no, null
     */
    public User getUserByName(String username){
        User user;
        for(int i=0; i<users.size(); i++){
            user = users.get(i);
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }
    
    /**
     * Obteniene la Sesion Activa del Stack
     * @return CurrentSession 
     */
    public CurrentSession getCurrentSession(){
        return currentSession;
    }
    
    /**
     * Obteniene los usuarios registrados en el Stack
     * @return ArrayList users 
     */
    public ArrayList<User> getUsers(){
        return users;
    }
    
    /**
     * Obteniene los usuarios registrados en el Stack
     * @param username Usuario que se requiere recuperar desde el stack
     * @return ArrayList users 
     */
    public User getUser(String username){
        for(User u : this.users){
            if(u.getUsername().equals(username)){
                return u;
            }
        }
        return null;
    }
    
    /**
     * @return devuelve la lista de las etiquetas creadas
     */
    public ArrayList<Label> getLabels(){
        return labels;
    }
    
    /**
     * @return Retorna las preguntas hechas en el stack.
     */
    public ArrayList<Question> getQuestions(){
        return questions;
    }
}

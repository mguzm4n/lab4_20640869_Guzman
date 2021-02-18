package Model;
import java.util.ArrayList;

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
     * Convierte el Stack en un string equivalente que muestra la informacion actual
     * @return String equivalente con la informacion del Stack 
     */
    @Override
    public String toString(){
        String user = currentSession.getOnlineUser().toString();
        String blocks = "", answers;
        Question question;
        for(int i = 0; i < Question.getTotalQuestions(); i++) {
            question = questions.get(i);
            answers = question.answersToString();
            blocks += question.toString() + answers +"\n\n"; 
        }
        return user+"\n\n"+blocks;
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

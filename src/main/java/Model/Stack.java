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
}

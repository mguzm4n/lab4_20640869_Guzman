package Model;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
import java.util.ArrayList;

/**
 * Clase que envuelve todo lo necesario para abstraer una entidad de Pregunta.
 * Posee una variable de clase llamada totalQuestions que cuenta todas las instancias
 * registradas de la clase Pregunta.
 * @author Marcelo Guzmán
 */
public class Question extends InteractiveBlock {
    private static int totalQuestions = 0;
    private LocalDateTime updateDate;
    private int answersCount;
    private String title;
    private int reward;
    private ArrayList<Label> labels;
    private ArrayList<Answer> answers;
    
    public Question(LocalDateTime date, String username, String title, String content){
        this.title = title;
        this.content = content;
        this.author = username;
        this.postDate = date;
        this.updateDate = postDate;
        Question.totalQuestions++;
        this.id = totalQuestions;
        this.answersCount = 0;
        this.state = "Abierta";
        this.reward = 0;
        this.answers = new ArrayList<>();
    }
    
    
    /**
     * Establecer las etiquetas deseadas
     * @param labels Etiquetas determinadas desde la clase Stack.
     */
    public void setLabels(ArrayList<Label> labels){
        this.labels = labels;
    }
    
   /**
    * Establece la fecha exacta capturada en el momento en el que se realiza una respuesta a la pregunta
    * @param update LocalDateTime que captura la fecha cuando se responde a this.question
    */
   public void setUpdateDate(LocalDateTime update){
        this.updateDate = update;
    }
   
   /**
    * Establece el estado de esta Pregunta. Es de un solo sentido ya que las preguntas
    * se inicializan como "Abierta".
    */
    public void setState(){
        this.state = "Cerrada";
    }
    
    /**
     * Adiciona una cantidad "amount" de reputacion como recompensa a la Pregunta.
     * @param amount Cantidad de recompensa que se quiere dar a la pregunta.
     */
    public void setReward(int amount){
        this.reward += amount;
    }
    
    /**
     * Obtiene el titulo de la pregunta
     * @return string equivalente al titulo de la pregunta
     */
    public String getTitle(){
        return title;
    }
    
    /**
     * Obtiene la Recompensa total a una pregunta.
     * @return entero representando al cantidad de recompensa.
     */
    public int getReward(){
        return reward;
    }
    
    /**
     * Obtiene la cuenta de las respuestas hechas a this.question
     * @return entero que representa la cantidad de respuestas hasta el momento
     */
    public int getAnswersCount(){
        return answersCount;
    }
    
    /**
     * Metodo estatico que permite obtener todas las instancias de Question realizadas
     * @return un entero.
     */
    public static int getTotalQuestions(){
        return totalQuestions;
    }
    
    /**
     * Recupera el ArrayList de respuestas hechas a la pregunta
     * @return ArrayList contenedor de Answer agregadas a la Pregunta
     */
    public ArrayList getAnswers(){
        return answers;
    }
    
    /**
     * Recupera una Respuesta de this.question 
     * @param id id de la Respuesta que se quiere obtener 
     * @return Si se encuentra, true; si no, null
     */
    public Answer getAnswer(int id){
        Answer answer;
        for(int i=0; i<this.answersCount; i++){
            answer = this.answers.get(i);
            if(answer.getId()==id){
                return answer;
            }
        }
        return null;
    }
    
    /**
     * Agrega una pregunta a la respuesta en cuestion y aumenta el contador de respuestas
     * @param answer Respuesta seleccionada 
     * @return boolean
     */
    public boolean addAnswer(Answer answer){
        if(this.answers!=null){
            this.answersCount++;
            this.answers.add(answer);
            return true;
        }
        return false;
    }
    
    /**
     * Da formato de String a las respuestas que posee una pregunta
     * @return String equivalente a las respuestas de this.question
     */
    public String answersToString(){
        String answersStr="";
        for(int i=0; i<answers.size(); i++){
            answersStr += answers.get(i).toString() + "\n";
        }
        return answersStr;
    }

    /**
     * Convierte a string las respuestas que no pertenecen al usuario x
     * @param x Usuario que queremos saltar al momento de convertir las respuestas a string
     * @return string
     */
    public String answersNotFromXtoString(User x){
        String answersStr="";
        Answer answer;
        for(int i=0; i<answers.size(); i++){
            answer = answers.get(i);
            if(!answer.getAuthor().equals(x.getUsername())){
                answersStr += answer.toString() + "\n";
            }
            
        }
        return answersStr;
    }
    
    
    /**
     * Da formato de un String a una instancia de Question
     * @return String equivalente en informacion a una instancia de clase Question
     */
    @Override
    public String toString(){
        String strLabels="";
        if(labels!=null){
            for(int i=0; i<labels.size(); i++){
                strLabels += labels.get(i).getName() + " ";
            }
        }else{
            strLabels = "Esta pregunta no tiene etiquetas";
        }
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy HH:mm:ss");
        String question = "N° de Pregunta: " + this.id + " --- "+ this.postDate.format(formatter) + "\n" + 
                "[ Última actualización: " + this.updateDate.format(formatter) + " ] \n" +
                "Título: " + this.title + ", " +
                "Autor: " + this.author + "\n" +
               "Etiquetas: " + strLabels + "\n" + 
                "\t >> '' " + this.content + " << ''" + "\n" +
                "Respuestas Totales: " + this.answersCount + "\n" +
                "Votos Positivos: " + this.votes.getVotesUp() + " || " +
                "Votos Negativos: " + this.votes.getVotesDown() + "\n" +
                "Esta pregunta se encuentra actualmente: " + this.state + "\n" +
                "RECOMPENSA: " + this.reward + "\n";
        return question;
    }
}


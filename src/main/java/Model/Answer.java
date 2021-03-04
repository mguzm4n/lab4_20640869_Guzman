package Model;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  

/**
 * Clase que representa a una Respuesta.
 * Posee una variable de clase que toma registro de todas las respuestas hechas en total.
 * El id de una Respuesta no es global; dos respuestas pueden tener id = 1 pero
 * estan en Preguntas distintas
 * totalAnswers, por otra parte, mantiene un registro de todas las respuestas generadas en el Sistema.
 * @author Marcelo Guzman
 */
public class Answer extends InteractiveBlock {
    private static int totalAnswers=0;
    
    public Answer(LocalDateTime date, String username, String content, int id){
        this.id = id;
        this.content = content;
        this.author = username;
        this.postDate = date;
        this.state = "No Aceptada";
        totalAnswers++;
        
    }
    
    /**
     * Cambia el estado de la Respuesta cuando esta es aceptada
     * Este método es void porque no existe forma (actualmente) de revertir una respuesta aceptada.
     */
    public void setState(){
        this.state = "Aceptada";
    }
    
    /**
     * Recupera el onteo total de respuestas hechas globalmente
     * Si se quiere recuperar el conteo de las respuestas respecto de una pregunta, utilizar el método 
     * getAnswersCount() de la clase Question.
     * @return int representando la cuenta de todas las respuestas hechas
     */
    public static int getTotalAnswers(){
        return totalAnswers;
    }
    
    
    /**
     * Convierte a String una instancia de la clase Answer
     * @return String equivalente en informacion a una instancia de la clase Answer
     */
    @Override
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy HH:mm:ss");
        String answer = 
                "\tNÂ° de Respuesta: " + this.id + " --- "+ this.postDate.format(formatter) + "\n" +
                "\tAutor: " + this.author + "\n" +
                "\t\t >> '' " + this.content + " << ''" + "\n" +
                "\tVotos Positivos: " + this.votes.getVotesUp() + " || " +
                "Votos Negativos: " + this.votes.getVotesDown() + "\n" +
                "\tEsta Respuesta se encuentra actualmente: " + this.state + "\n\n";
        return answer;
    }
}

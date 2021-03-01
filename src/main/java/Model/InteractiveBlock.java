package Model;
import java.time.LocalDateTime;
import java.util.HashMap;

/** Abstraccion de un bloque interactivo dentro del Sistema de Preguntas y Respuestas
 * La clase InteractiveBlock une atributos basicos que debe tener una Pregunta\Respuesta
 * @author Marcelo Guzman
 */
public abstract class InteractiveBlock {
    protected String author, content, state;
    protected int id;
    protected LocalDateTime postDate;
    protected Votes votes = new Votes();
    protected HashMap<String, Boolean> submittedVotes = new HashMap<>();
    
    /**
     * Recupera el autor asignado a una Pregunta/Respuesta
     * @return String contenedor del autor
     */
    public String getAuthor(){
        return author;
    }
    
    /**
     * Recupera el contenido del BloqueInteractivo
     * @return String con la respuesta/preguna respectiva
     */
    public String getContent(){
        return content;
    }
    
    /**
     * Recupera el estado de un BloqueInteractivo - Preguntas y Respuestas tienen diferentes estados.
     * @return String del estado del bloque al que se refiere el metodo.
     */
    public String getState(){
        return state;
    }
    
    /**
     * Recupera la fecha en la cual fue creada la pregunta\respuesta
     * @return Clase LocalDateTime con la fecha en la que se creo el bloque
     */
    public LocalDateTime getPostDate(){
        return postDate;
    }
    
    /**
     * Recupera el id CORRELATIVO segun el orden en el Sistema visible al Usuario 
     * en el que se muestran las preguntas/respuestas
     * @return int representando al ID
     */
    public int getId(){
        return id;
    }
    
     /**
     * Recupera la instancia particular de la clase Votes de cada Pregunta/Respuesta que extienden de InteractiveBlock
     * @return int representando al ID
     */
    public Votes getVotes(){
        return votes;
    }
    
    public HashMap<String, Boolean> getSubmittedVotes(){
        return submittedVotes;
    }
    
}
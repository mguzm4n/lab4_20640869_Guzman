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
     * Recupera la fecha como instancia de LocalDateTime, en la cual fue creada la pregunta\respuesta
     * @return Clase LocalDateTime con la fecha en la que se creo el bloque
     */
    public LocalDateTime getPostDate(){
        return postDate;
    }
    
    /**
     * Recupera el id correlativo segun el orden del contexto del bloque interactivo.
     * Para una instancia de clase Question, recupera el Id universal de la pregunta en el stack.
     * Para una instancia de la clase Answer, recupera el Id relativo a la Pregunta donde está contenida la respuesta.
     * @return int representando al ID de un objeto instanciado, que extiende de InteractiveBlock
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
    
    
    /**
     * Recupera los votos emitidos hacia una instancia de Pregunta/Respuesta que extienden de InteractiveBlock
     * @return HashMap cuya key es el autor (String) y el value (Boolean) el tipo de voto emitido al bloque interactivo
     */
    public HashMap<String, Boolean> getSubmittedVotes(){
        return submittedVotes;
    }
    
}
package Model;
import java.time.LocalDateTime;

/** Abstraccion de un bloque interactivo dentro del Sistema de Preguntas y Respuestas
 * La clase InteractiveBlock une atributos basicos que debe tener una Pregunta\Respuesta
 * @author Marcelo Guzmán
 */
public abstract class InteractiveBlock {
    protected String author, content, state;
    protected int id;
    protected LocalDateTime postDate;
    protected Votes votes = new Votes();
    
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
     * Recupera el id CORRELATIVO segun el orden en el Sistema visible al Usuario 
     * en el que se muestran las preguntas/respuestas
     * @return int representando al ID
     */
    public int getId(){
        return id;
    }
    
    
    
}
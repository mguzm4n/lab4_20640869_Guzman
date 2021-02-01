package Model;

/**
 * Clase que representa las Etiquetas propias de una Pregunta en un sistema de Preguntas y Respuestas
 * @author Marcelo Guzmán
 */
public class Label {
    private String name, description;
    
    /**
     * Constructor de etiqueta
     * @param name nombre de la etiqueta
     * @param description descripcion de la etiqueta
     */
    public Label(String name, String description){
        this.name = name;
        this.description = description;
    }
    
    /**
     * Renombrar una etiqueta 
     * @param name nombre deseado de la etiqueta
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * Re-describir la etiqueta
     * @param description descripcion deseado de la etiqueta
     */
    public void setDescription(String description){
        this.description = description;
    }
    
    /**
     * Obtener el ultimo nombre dado a una etiqueta
     * @return 
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Obtener la ultima descripcion dada a una etiqueta
     * @return 
     */
    public String getDescription(){
        return this.description;
    }
    
    /**
     * Transforma a string una etiqueta para visualizar sus atributos
     * @return String equivalente a una Etiqueta
     */
    @Override
    public String toString(){
        return "Nombre de etiqueta: "+this.name+"\n"+"Descripcion de etiqueta: "+this.description;
    }
}

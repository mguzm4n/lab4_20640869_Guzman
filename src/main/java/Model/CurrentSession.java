package Model;

/**
 * Clase CurrentSession es la encargada de llevar la informacion
 * del usuario que actualmente esta revisando el sistema de preguntas y respuestas
 * Ademas de alojar la referencia al usuario online, tiene un flag "type" que
 * si es true indica que la sesion esta activa; si es false, no hay ningun usuario activo
 * @author Marcelo Guzman
 */
public class CurrentSession{
    private boolean type;
    private User onlineUser;
    
    /**
     * Constructor de la clase CurrentSession
     * siempre partira desconectado
     * Este estado se cambia con el setter de type
     */
    public CurrentSession(){
        this.type = false;
    }
    
    /**
     * Setea el tipo de sesion. Se debe usar cuando se realice la accion de inicio o cierre de sesion.
     * @param type 
     */
    public void setType(boolean type){
        this.type = type;
    }
    
    /**
     * Si un usuario ha iniciado sesion en el controlador designado, se debe asignar el usuario con este metodo.
     * @param onlineUser Usuario recuperado el cual inicia sesion.
     */
    public void setOnlineUser(User onlineUser){
        this.onlineUser = onlineUser;
    }
    
    /**
     * Determina facilmente si hay usuario activo o no.
     * @return Tipo de sesion: true -> existe usuario con sesion iniciada
     * false -> existe una sesion offline 
     */
    public boolean getType(){
        return this.type;
    }
    
    /**
     * @return Recupera la instancia del usuario de clase User que inicia sesion. 
     * Tira una excepcion de puntero nulo si se accede cuando el atributo type es false ya que no existe el usuario online.
     */
    public User getOnlineUser(){
        return this.onlineUser;
    }
    
}

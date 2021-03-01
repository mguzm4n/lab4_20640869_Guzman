package Model;

/**
 * Clase CurrentSession es la encargada de llevar la informacion
 * del usuario que actualmente esta revisando el sistema de preguntas y respuestas
 * Ademas de alojar la referencia al usuario online, tiene un flag "type" que
 * si es true indica que la sesion esta activa; si es false, no hay ningun usuario activo
 * @author Marcelo Guzmán
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
    
    public void setType(boolean type){
        this.type = type;
    }
    
    public void setOnlineUser(User onlineUser){
        this.onlineUser = onlineUser;
    }
    
    public boolean getType(){
        return this.type;
    }
    
    public User getOnlineUser(){
        return this.onlineUser;
    }
    
}

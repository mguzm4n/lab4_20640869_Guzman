package Model;
import java.util.ArrayList;

/**
 * Clase User - Usuario
 * Representa a los usuarios que se registraran dentro de nuestro sistema de preguntas y respuestas
 * @author Marcelo Guzmán
 */
public class User {
    private int id;
    protected String username;
    protected char[] password;
    protected int reputation;
    protected ArrayList<Integer> questions;
    
    public User(String username, char[] password){
        this.username = username;
        this.password = password;
        this.reputation = 0;
        this.questions = new ArrayList<>();
    }
   
    
    public int getId(){
        return this.id;
    }
    
    /**
     * Obtiene el nombre de usuario de User
     * @return un String equivalente al nombre de usuario
     */
    public String getUsername(){
        return this.username;
    }
    
    /**
     * Obtiene la contrasenia de un Usuario
     * @return array de char. equivalente a la contrasenia de un Usuario
     */
    public char[] getPassword(){
        return this.password;
    }
    
    /**
     * Recupera la lista de preguntas hechas por el usuario
     * @return ArrayList de Integers representando los id de las preguntas
     */
    public ArrayList<Integer> getQuestions(){
        return this.questions;
    }
    
    /**
     * Recupera la reputacion total que ha ganado el usuario
     * @return int; representando la reputacion del usuario
     */
    public int getReputation(){
        return this.reputation;
    }
    
    /**
     * Determina la reputacion del usuario. La reputacion es sumativa. 
     * Al momento de usar este metodo no se reemplaza con X puntos ingresados
     * sino que se suma a la reputacion que se tenia de antes.
     * @param newReputation int; reputacion total sumada a la que tenia antes de usar el metodo
     */
    public void setReputation(int newReputation){
        this.reputation += newReputation;
    }
    
    /**
     * Determina la existencia de una pregunta hecha por el Usuario
     * @param questionId booleano; depende de si existe o no.
     * @return 
     */
    public boolean haveQuestion(int questionId){
        for(int i=0; i<questions.size(); i++){
            if(questionId == questions.get(i)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Transforma a String una instancia de la clase Usuario, NO incluye la PASSWORD
     * @return String equivalente a informacion de Usuario - sin password.
     */
    @Override
    public String toString(){
        return "Usuario: " + this.username + "\nReputación: " + this.reputation;
    }
}

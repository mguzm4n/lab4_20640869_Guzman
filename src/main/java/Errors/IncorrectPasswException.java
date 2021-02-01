package Errors;

/**
 *
 * @author Marcelo Guzmán
 */
public class IncorrectPasswException extends Exception{
    public IncorrectPasswException(){
        super("Contraseña ingresada incorrecta");
    }
}

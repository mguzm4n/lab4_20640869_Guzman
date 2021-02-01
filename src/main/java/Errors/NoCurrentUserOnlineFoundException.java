/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Errors;

/**
 *
 * @author Marcelo Guzmán
 */
public class NoCurrentUserOnlineFoundException extends Exception {
    /**
     * Constructs an instance of <code>NoCurrentUserOnlineFoundException</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public NoCurrentUserOnlineFoundException() {
        super("No hay ninguna sesión que cerrar.");
    }
}

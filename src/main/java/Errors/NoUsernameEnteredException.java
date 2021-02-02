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
public class NoUsernameEnteredException extends Exception {
    public NoUsernameEnteredException() {
        super("No puede dejar el campo de Nombre de Usuario vacío.");
    }
}

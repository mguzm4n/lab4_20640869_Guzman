/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Errors;

/**
 *
 * @author Marcelo Guzm�n
 */
public class NoPasswordEnteredException extends Exception {
    public NoPasswordEnteredException() {
        super("No puede dejar el campo de contrase�a vac�o.");
    }
}

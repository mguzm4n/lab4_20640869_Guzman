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
public class InsufficientReputationException extends Exception{

    public InsufficientReputationException() {
        super("La reputaci�n del usuario es insuficiente para enviar la recompensa.");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Errors.*;
import Model.*;
/**
 *
 * @author Marcelo Guzm�n
 */
public class StackController {
    Stack stack = new Stack();
    
    /**
     * Ingresa un nuevo usuario al ArrayList de usuarios del Stack
     * @param username nombre del usuario
     * @param password contrasena elegida
     * @return true si se agrega correctamente el usuario al stack
     */
    public boolean register(String username, char[] password){
        if(stack.getUsers().isEmpty()){
            stack.getUsers().add(new User(username, password));
            return true;
        }else{
            if(!existsUser(username)){
                stack.getUsers().add(new User(username, password));  
                return true;
            }else{
                return false;
            }
        }
    }
    
    /**
     * Se setea el User en CurrentSesion del Stack y se cambia el tipo de sesion a activa (true).
     * @param username nombre del usuario
     * @param password contrasena elegida
     * @return true si se agrega correctamente el usuario al stack
     */
    public boolean login(String username, char[] password) throws IncorrectPasswException, InexistentUserException{
        int credentialsChecker = validateCredentials(username, password);
        
        if(credentialsChecker==-1){
            throw new InexistentUserException();
        }else if(credentialsChecker==2){
            throw new IncorrectPasswException();
        }else{
            stack.getCurrentSession().setType(true); // sesion online
            stack.getCurrentSession().setOnlineUser(stack.getUser(username));
            return true;
        }
    }
    
    /**
     * Cambia la sesion a false, indicando que no estamos conectados
     * Se cambia el usuario a null
     */
    public void logOut() throws NoCurrentUserOnlineFoundException{
        if(stack.getCurrentSession().getType()){
            stack.getCurrentSession().setType(false);
            stack.getCurrentSession().setOnlineUser(null);
        }else{
           throw new NoCurrentUserOnlineFoundException();
        }    
   }
    
    
    /**
     * Verifica mediante el nombre de usuario si existe username o no, dentro de ArrayList users
     * @param username nombre de usuario
     * @return true cuando se encuentra; en cualquier otro caso retorna false
     */
    public boolean existsUser(String username){
        int length = stack.getUsers().size(), i;
        for(i=0; i < length; i++) {
            if(stack.getUsers().get(i).getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
    
    private int validateCredentials(String username, char[] password){
        int length = stack.getUsers().size(), i;
        User user;
        for (i=0; i < length; i++) {
            user = stack.getUsers().get(i);
            
            boolean equalUsernames = user.getUsername().equals(username);
            boolean equalPasswords =  matchesPassword(password, user.getPassword());
            
            if(equalUsernames && equalPasswords){
                return 1;
            }else if(equalUsernames && !equalPasswords){
                return 2;
            }
        }
        return -1;
    }
    
    private boolean matchesPassword(char[] password0, char[] password1){
        if(password0.length!=password1.length){
            return false;
        }
        
        for(int i=0; i<password0.length; i++){
            if(password0[i]!=password1[i]){
                return false;
            }
        }
        
        return true;
    }
    
    public String getOnlineUsername(){
        return stack.getCurrentSession().getOnlineUsername();
    }
}

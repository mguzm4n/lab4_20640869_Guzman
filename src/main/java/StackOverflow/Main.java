/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StackOverflow;
import View.StartFrame;
import Controller.StackController;
/**
 *
 * @author Marcelo Guzm�n
 */
public class Main {
    public static void main(String[] args){
        
        StackController stackController = new StackController();
        stackController.createLabel("Java", "Java es el nombre de un entorno o plataforma de computaci�n originaria de Sun Microsystems, capaz de ejecutar aplicaciones "
                + "                 desarrolladas usando el lenguaje de programaci�n Java u otros lenguajes que compilen a bytecode y un conjunto de herramientas "
                + "                 de desarrollo.");
        stackController.createLabel("Python", "Lenguaje de programaci�n interpretado.Multiparadigma, ya que soporta parcialmente la orientaci�n a objetos, "
                + "                 programaci�n imperativa y, en menor medida, programaci�n funcional.");
        stackController.createLabel("Kotlin", "Kotlin es un lenguaje de programaci�n de tipado est�tico que corre sobre la m�quina virtual de Java y que "
                + "                 tambi�n puede ser compilado a c�digo fuente de JavaScript.");
        stackController.createLabel("C++", "C++ es un lenguaje de programaci�n que proviene de la extensi�n del lenguaje C para que pudiese manipular objetos.");
        stackController.createLabel("TypeScript", "Superconjunto de JavaScript, que esencialmente a�ade tipos est�ticos y objetos basados en clases.");
        StartFrame startingView = new StartFrame(stackController);
        startingView.run();
    }
}

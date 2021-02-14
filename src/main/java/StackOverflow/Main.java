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
 * @author Marcelo Guzmán
 */
public class Main {
    public static void main(String[] args){
        
        StackController stackController = new StackController();
        stackController.createLabel("Java", "Java es el nombre de un entorno o plataforma de computación originaria de Sun Microsystems, capaz de ejecutar aplicaciones "
                + "                 desarrolladas usando el lenguaje de programación Java u otros lenguajes que compilen a bytecode y un conjunto de herramientas "
                + "                 de desarrollo.");
        stackController.createLabel("Python", "Lenguaje de programación interpretado.Multiparadigma, ya que soporta parcialmente la orientación a objetos, "
                + "                 programación imperativa y, en menor medida, programación funcional.");
        stackController.createLabel("Kotlin", "Kotlin es un lenguaje de programación de tipado estático que corre sobre la máquina virtual de Java y que "
                + "                 también puede ser compilado a código fuente de JavaScript.");
        stackController.createLabel("C++", "C++ es un lenguaje de programación que proviene de la extensión del lenguaje C para que pudiese manipular objetos.");
        stackController.createLabel("TypeScript", "Superconjunto de JavaScript, que esencialmente añade tipos estáticos y objetos basados en clases.");
        StartFrame startingView = new StartFrame(stackController);
        startingView.run();
    }
}

/*
 * Clase Main para iniciar una Aplicacion como StackOverflow.
 * La clase StackController y el Package View utilizan los modelos.
 */
package StackOverflow;
import Model.Stack;
import Controller.StackController;
import View.StartFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args){
        Stack stack = new Stack();
        StackController stackController = new StackController(stack);
        
        stackController.createLabel("Java", "Java es el nombre de un entorno o plataforma de computación originaria de Sun Microsystems, capaz de ejecutar aplicaciones "
                + "desarrolladas usando el lenguaje de programación Java u otros lenguajes que compilen a bytecode y un conjunto de herramientas "
                + "de desarrollo.");
        stackController.createLabel("Python", "Lenguaje de programación interpretado.Multiparadigma, ya que soporta parcialmente la orientación a objetos, "
                + "programación imperativa y, en menor medida, programación funcional.");
        stackController.createLabel("Kotlin", "Kotlin es un lenguaje de programación de tipado estático que corre sobre la máquina virtual de Java y que "
                + "también puede ser compilado a código fuente de JavaScript.");
        stackController.createLabel("C++", "C++ es un lenguaje de programación que proviene de la extensión del lenguaje C para que pudiese manipular objetos.");
        stackController.createLabel("TypeScript", "Superconjunto de JavaScript, que esencialmente añade tipos estáticos y objetos basados en clases.");
        
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                StartFrame startingView = new StartFrame(stackController);
                startingView.run();
            }
            
        }
        );
    }
}

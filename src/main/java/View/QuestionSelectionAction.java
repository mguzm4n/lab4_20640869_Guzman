/*
 * Esta clase determina el comportamiento de las tablas que poseen preguntas cuando se cliquea sobre ellas
 */
package View;

import Controller.StackController;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Marcelo Guzmán
 */
public class QuestionSelectionAction extends MouseAdapter{
    private StackController stackController;
    private JTable questionsTable;
    private StartFrame parent;
    
    public QuestionSelectionAction(StartFrame parent, JTable questionsTable){
        this.parent = parent;
        this.stackController = parent.getStackController();
        this.questionsTable = questionsTable;
    }
    
    /**
     * 
     * @param evt 
     */
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        
        int selectedQuestion = -1;
        String questionsTableVisibleName = "";
        JScrollPane  visibleQuestionTable;
        
        for(Component c : parent.getContainer2().getComponents()){
            if(c.isVisible()){
                visibleQuestionTable = (JScrollPane) c;
                questionsTableVisibleName = visibleQuestionTable.getName();
            }
        }
        // Buscamos el ID que corresponda a la pregunta seleccionada
        if(questionsTableVisibleName.equals(StartFrame.ALL_QUESTIONS_TABLE)){
            selectedQuestion = questionsTable.getSelectedRow() + 1;
        }else{
            ArrayList<Integer> userQuestions = stackController.getCurrentSession().getOnlineUser().getQuestions();
            selectedQuestion = userQuestions.get(questionsTable.getSelectedRow());
        }
        
        
        QuestionView questionView;
        
        try { // Esta excepción es por el uso de íconos
            questionView = new QuestionView(parent, true, 
                    stackController.getQuestionByID(selectedQuestion));
            questionView.addWindowListener(new java.awt.event.WindowAdapter(){
                @Override
                public void windowClosed(WindowEvent e) {
                    questionsTable.clearSelection();
                }

            });
            questionView.run();
        } catch (IOException ex) {
            Logger.getLogger(QuestionSelectionAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }
    
}

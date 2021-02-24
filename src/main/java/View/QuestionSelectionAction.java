/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.StackController;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
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
    
    public QuestionSelectionAction(JTable questionsTable, StackController stackController, StartFrame parent){
        this.parent = parent;
        this.stackController = stackController;
        this.questionsTable = questionsTable;
    }
    
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        
        int selectedQuestion = -1;
        String questionsTableVisibleName = "";
        JScrollPane  questionsTableVisible;
        
        for(Component c : parent.getContainer2().getComponents()){
            if(c.isVisible()){
                questionsTableVisible = (JScrollPane) c;
                questionsTableVisibleName = questionsTableVisible.getName();
            }
        }
        // Buscamos el ID que corresponda a la pregunta seleccionada
        if(questionsTableVisibleName.equals(StartFrame.ALL_QUESTIONS_TABLE)){
            selectedQuestion = questionsTable.getSelectedRow() + 1;
        }else{
            ArrayList<Integer> userQuestions = stackController.getCurrentSession().getOnlineUser().getQuestions();
            selectedQuestion = userQuestions.get(questionsTable.getSelectedRow());
        }
        
        System.out.println("\n");
        QuestionView questionView =new QuestionView(parent, true, stackController, 
                                                    stackController.getQuestionByID(selectedQuestion));
        
        
        questionView.addWindowListener(new java.awt.event.WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e) {
                questionsTable.clearSelection();
            }

        });
        questionView.run();
        
        
    }
    
}

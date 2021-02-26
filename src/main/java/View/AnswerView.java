package View;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AnswerView extends javax.swing.JPanel{
    JLabel stateLbl, authorLbl, datePostedLbl;
    JTextArea contentTxtArea;
    
    
    public AnswerView(Model.Answer ans) throws IOException{
        initComponents();
        GridBagConstraints constraints;
        
        VotesView votesView = new VotesView();
        
        JScrollPane contentScrollPane = new JScrollPane();
        contentTxtArea = new JTextArea();
        datePostedLbl = new JLabel("dd/mm/yyyy", JLabel.CENTER);
        datePostedLbl.setPreferredSize(new Dimension(20,20));
        authorLbl = new JLabel("Author", JLabel.CENTER);
        stateLbl = new JLabel("State", JLabel.CENTER);
        
        contentTxtArea.setMargin(new Insets(3,7,3,7));
        contentScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        contentTxtArea.setEditable(true);
        contentTxtArea.setColumns(20);
        contentTxtArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        contentTxtArea.setLineWrap(true);
        contentTxtArea.setRows(4);
        contentTxtArea.setText("Contenido");
        contentScrollPane.setViewportView(contentTxtArea);
        
        /* anadimos los votos */
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0;
        add(votesView, constraints);

        /* contenido de la pregunta */
        constraints = new GridBagConstraints();
        constraints.insets = new Insets(0,0,0,5);
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 1; // el texto de la respuesta tiene mas espacio en el panel
        add(contentScrollPane, constraints);
        
        /* anadir la informacion de la pregunta */ 
        
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.BOTH;
        
        JPanel answerInfoPane = new JPanel();
        answerInfoPane.setLayout(new GridLayout(1, 3, 0, 0));
        answerInfoPane.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        answerInfoPane.add(datePostedLbl);
        answerInfoPane.add(authorLbl);
        answerInfoPane.add(stateLbl);
        
        add(answerInfoPane, constraints);
        
        // (int top, int left, int bottom, int right)
        setAnswerInfo(ans);
    }

    private void setAnswerInfo(Model.Answer ans){
        authorLbl.setText(ans.getAuthor());
        contentTxtArea.setText(ans.getContent());
        contentTxtArea.setMargin(new Insets(2,5,2,5));
        datePostedLbl.setText(Controller.StackController.setDateFormat(ans.getPostDate(), "dd/MM/yyyy"));
        stateLbl.setText(ans.getState());
    }
    
    /**
     * Solo setear el Layout.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.GridBagLayout());
    }// </editor-fold>//GEN-END:initComponents

    public javax.swing.JLabel getStateLbl(){
        return stateLbl;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}

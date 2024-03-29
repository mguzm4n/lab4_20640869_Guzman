/*
 * Vista del formulario para enviar una pregunta.
 */
package View;

import Controller.StackController;
import Errors.FieldEmptyException;
import java.awt.Insets;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcelo Guzm�n
 */
public class AnswerForm extends javax.swing.JDialog {
    Model.Question question;
    StackController stackController;
    boolean firstFocused;
    QuestionView parent;

    public AnswerForm(QuestionView parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.parent = parent;
        this.stackController = parent.getStackController();
        this.question = parent.getQuestion();
        answerContentTextArea.setMargin(new Insets(2,5,2,5));
    }

    /**
     * Este metodo dispone en el area del JDialog los componentes de la forma para responder a una pregunta.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        answerContentPanel = new javax.swing.JScrollPane();
        answerContentTextArea = new javax.swing.JTextArea();
        sendAnswerBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        answerContentPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        answerContentTextArea.setColumns(20);
        answerContentTextArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        answerContentTextArea.setLineWrap(true);
        answerContentTextArea.setRows(5);
        answerContentTextArea.setText("Escriba su respuesta aqui...");
        answerContentTextArea.setToolTipText("");
        answerContentTextArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                answerContentTextAreaFocusGained(evt);
            }
        });
        answerContentPanel.setViewportView(answerContentTextArea);

        sendAnswerBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sendAnswerBtn.setText("Enviar Respuesta");
        sendAnswerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendAnswerBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(answerContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sendAnswerBtn)
                .addGap(82, 82, 82))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(answerContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(sendAnswerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Llamada a stackController.answer() y realiza la respuesta.
     * @param evt 
     */
    private void sendAnswerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendAnswerBtnActionPerformed
        
        try {
            stackController.answer(question, 
                                   answerContentTextArea.getText().equals("Escriba su respuesta aqui...")? "" : answerContentTextArea.getText());
            try {
                parent.addNewAnswer();
                JOptionPane.showMessageDialog(this, "Respuesta enviada correctamente");
                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(AnswerForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FieldEmptyException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
    }//GEN-LAST:event_sendAnswerBtnActionPerformed

    
    private void answerContentTextAreaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_answerContentTextAreaFocusGained
        if(firstFocused){
            answerContentTextArea.setText("");
            firstFocused = false;
        }
    }//GEN-LAST:event_answerContentTextAreaFocusGained

    
    
    public void run(){
        firstFocused = true;
        sendAnswerBtn.requestFocus();
        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane answerContentPanel;
    private javax.swing.JTextArea answerContentTextArea;
    private javax.swing.JButton sendAnswerBtn;
    // End of variables declaration//GEN-END:variables
}

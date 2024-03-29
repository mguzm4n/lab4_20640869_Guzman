/*
 * Vista de la ventana para realizar una Pregunta. Extiende de JDialog.
 */
package View;

import Controller.StackController;
import Errors.FieldEmptyException;
import Model.Label;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marcelo Guzm�n
 */
public class QuestionForm extends javax.swing.JDialog {
    StackController stackController;
    ArrayList<Label> labels = new ArrayList<>();
    boolean labelsDisplayed;
    StartFrame parent;
    

    public QuestionForm(StartFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        labelsDisplayed = false;
        this.parent = parent;
        this.stackController = parent.getStackController();
        qContentTxtArea.setMargin(new Insets(2,5,2,5));
    }

    /**
     * Metodo que dispone en el JDialog sus componentes, ajustando sus dimensiones y layouts.
     */ 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        successDialog = new javax.swing.JDialog();
        javax.swing.JLabel successLbl = new javax.swing.JLabel();
        javax.swing.JButton backToStartBtn = new javax.swing.JButton();
        formPanel = new javax.swing.JPanel();
        firstFormPanel = new javax.swing.JPanel();
        javax.swing.JLabel formTitle1Lbl = new javax.swing.JLabel();
        titleField = new javax.swing.JTextField();
        javax.swing.JLabel titleLbl = new javax.swing.JLabel();
        javax.swing.JLabel questionLbl = new javax.swing.JLabel();
        javax.swing.JScrollPane qContentScrollPane = new javax.swing.JScrollPane();
        qContentTxtArea = new javax.swing.JTextArea();
        javax.swing.JButton continueBtn = new javax.swing.JButton();
        addLabelsCheckBtn = new javax.swing.JRadioButton();
        javax.swing.JButton getBackBtn = new javax.swing.JButton();
        labelsFormPanel = new javax.swing.JPanel();
        javax.swing.JLabel formTitle2Lbl = new javax.swing.JLabel();
        javax.swing.JButton backBtn = new javax.swing.JButton();
        javax.swing.JScrollPane lblsListScrollPane = new javax.swing.JScrollPane();
        labelsContainer = new javax.swing.JPanel();
        javax.swing.JScrollPane lblsDescriptionScrollPane = new javax.swing.JScrollPane();
        labelDescriptionTxtArea = new javax.swing.JTextArea();
        postBtn = new javax.swing.JButton();

        successDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        successDialog.setTitle("StackOverflow");
        successDialog.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);

        successLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        successLbl.setText("Pregunta registrada con exito");

        backToStartBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        backToStartBtn.setText("Volver");
        backToStartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToStartBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout successDialogLayout = new javax.swing.GroupLayout(successDialog.getContentPane());
        successDialog.getContentPane().setLayout(successDialogLayout);
        successDialogLayout.setHorizontalGroup(
            successDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, successDialogLayout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(successLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(successDialogLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(backToStartBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        successDialogLayout.setVerticalGroup(
            successDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(successDialogLayout.createSequentialGroup()
                .addComponent(successLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backToStartBtn)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("StackOverflow");

        formPanel.setLayout(new java.awt.CardLayout());

        firstFormPanel.setPreferredSize(new java.awt.Dimension(397, 302));

        formTitle1Lbl.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        formTitle1Lbl.setText("Crear una pregunta");

        titleField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        titleLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        titleLbl.setText("Titulo");

        questionLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        questionLbl.setText("Pregunta");

        qContentTxtArea.setColumns(20);
        qContentTxtArea.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        qContentTxtArea.setLineWrap(true);
        qContentTxtArea.setRows(5);
        qContentScrollPane.setViewportView(qContentTxtArea);

        continueBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        continueBtn.setText("Continuar");
        continueBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continueBtnActionPerformed(evt);
            }
        });

        addLabelsCheckBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addLabelsCheckBtn.setText("Agregar Etiquetas");
        addLabelsCheckBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLabelsCheckBtnActionPerformed(evt);
            }
        });

        getBackBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getBackBtn.setText("Volver");
        getBackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getBackBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout firstFormPanelLayout = new javax.swing.GroupLayout(firstFormPanel);
        firstFormPanel.setLayout(firstFormPanelLayout);
        firstFormPanelLayout.setHorizontalGroup(
            firstFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(firstFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(firstFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(firstFormPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(firstFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(firstFormPanelLayout.createSequentialGroup()
                                .addComponent(addLabelsCheckBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                                .addComponent(continueBtn))
                            .addGroup(firstFormPanelLayout.createSequentialGroup()
                                .addGroup(firstFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(titleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(questionLbl))
                                .addGap(20, 20, 20)
                                .addGroup(firstFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(qContentScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                                    .addComponent(titleField)))))
                    .addGroup(firstFormPanelLayout.createSequentialGroup()
                        .addComponent(formTitle1Lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(getBackBtn)))
                .addGap(18, 18, 18))
        );
        firstFormPanelLayout.setVerticalGroup(
            firstFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(firstFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(firstFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formTitle1Lbl)
                    .addComponent(getBackBtn))
                .addGap(18, 18, 18)
                .addGroup(firstFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLbl)
                    .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(firstFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(questionLbl)
                    .addComponent(qContentScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(firstFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(continueBtn)
                    .addComponent(addLabelsCheckBtn))
                .addGap(18, 18, 18))
        );

        formPanel.add(firstFormPanel, "card1");

        formTitle2Lbl.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        formTitle2Lbl.setText("Elegir Etiquetas");

        backBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backBtn.setText("Volver");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        labelsContainer.setLayout(new java.awt.GridLayout(0, 1));
        lblsListScrollPane.setViewportView(labelsContainer);

        labelDescriptionTxtArea.setColumns(20);
        labelDescriptionTxtArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelDescriptionTxtArea.setLineWrap(true);
        labelDescriptionTxtArea.setRows(5);
        lblsDescriptionScrollPane.setViewportView(labelDescriptionTxtArea);

        postBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        postBtn.setText("Publicar Pregunta");
        postBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout labelsFormPanelLayout = new javax.swing.GroupLayout(labelsFormPanel);
        labelsFormPanel.setLayout(labelsFormPanelLayout);
        labelsFormPanelLayout.setHorizontalGroup(
            labelsFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(labelsFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(labelsFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblsListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(labelsFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(formTitle2Lbl)
                        .addComponent(backBtn)))
                .addGroup(labelsFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(labelsFormPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(lblsDescriptionScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addGroup(labelsFormPanelLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(postBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        labelsFormPanelLayout.setVerticalGroup(
            labelsFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(labelsFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(formTitle2Lbl)
                .addGap(18, 18, 18)
                .addGroup(labelsFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(labelsFormPanelLayout.createSequentialGroup()
                        .addComponent(lblsListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(labelsFormPanelLayout.createSequentialGroup()
                        .addComponent(lblsDescriptionScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(postBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(backBtn)
                .addContainerGap())
        );

        formPanel.add(labelsFormPanel, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(formPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(formPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Boton que permite pasar a la vista para elegir etiquetas.
     * @param evt 
     */
    private void continueBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continueBtnActionPerformed
        if(addLabelsCheckBtn.isSelected()){
            
            java.awt.CardLayout cl = (java.awt.CardLayout) formPanel.getLayout();
            cl.show(formPanel, "card2");
           
            if(!labelsDisplayed){
                labelsDisplayed = true; 
                ArrayList<Label> stackLabels = stackController.getLabels();
                for(Label l : stackLabels){
                    JRadioButton labelSelectBtn = new JRadioButton(l.getName());
                    labelSelectBtn.setFont(new java.awt.Font("Tahoma", 0, 14));
                    labelSelectBtn.addActionListener(new java.awt.event.ActionListener() {
                            @Override
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                labelSelectedActionPerformed(evt, labelSelectBtn);
                            }
                        });
                    labelsContainer.add(labelSelectBtn);
                }
            }
            
        }
        else{
            makeQuestion();
        }
    }//GEN-LAST:event_continueBtnActionPerformed

    /**
     * Boton para devolverse a ver los campos de la pregunta a realizar.
     * @param evt 
     */
    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        java.awt.CardLayout cl = (java.awt.CardLayout) formPanel.getLayout();
        cl.show(formPanel, "card1");
    }//GEN-LAST:event_backBtnActionPerformed


    private void addLabelsCheckBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLabelsCheckBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addLabelsCheckBtnActionPerformed

    /**
     * Ejecuta la accion de volver al inicio de StartFrame una vez hecha la pregunta.
     * @param evt 
     */
    private void backToStartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToStartBtnActionPerformed
        successDialog.dispose();
        this.dispose();
    }//GEN-LAST:event_backToStartBtnActionPerformed
       
    /**
     * Realiza
     * @param evt 
     */
    private void postBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postBtnActionPerformed
        
        for(Component c : labelsContainer.getComponents()){
            JRadioButton labelBtn = (JRadioButton) c;
            if(labelBtn.isSelected()){
                labels.add(stackController.getLabel(labelBtn.getText()));
            }
        }
        
        if(labels.isEmpty()){
            JOptionPane.showMessageDialog(parent, "Debe seleccionar al menos una etiqueta!");
            
        }else{
            makeQuestion();
        }
    }//GEN-LAST:event_postBtnActionPerformed

    /**
     * metodo para volver al startFrame principal.
     * @param evt 
     */
    private void getBackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getBackBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_getBackBtnActionPerformed

    /**
     * Metodo para mostrar el contenido de una etiqueta
     * @param evt
     * @param btnSelected JRadioButton que fue seleccionado
     */
    private void labelSelectedActionPerformed(java.awt.event.ActionEvent evt, JRadioButton btnSelected){
        labelDescriptionTxtArea.setText(stackController.getLabel(btnSelected.getText()).getDescription());
    }
    
    
    /**
     * Metodo que realiza el llamado a stackController.ask()
     */
    private void makeQuestion(){
        
        DefaultTableModel model = (DefaultTableModel) parent.getQuestionsTable().getModel();
            
         if(model.getRowCount()==0){
             CardLayout cl = (CardLayout) parent.getContainer2().getLayout();
             cl.show(parent.getContainer2(), StartFrame.ALL_QUESTIONS_TABLE);
         }
            
        try {
            stackController.ask(titleField.getText(), qContentTxtArea.getText(), labels.isEmpty()? null : labels);
            parent.getUserQuestionsBtn().setEnabled(true);
                
            successDialog.pack();
            successDialog.setLocationRelativeTo(null);

            Model.Question question = stackController.getLastQuestion();

            String date = StackController.setDateFormat(question.getPostDate(), "dd/MM/yyyy");
            String answersCount = question.getAnswersCount()==0? "Sin respuestas aun" : (Integer.valueOf(question.getAnswersCount())).toString();
            Object[] newRow = {question.getTitle(), question.getAuthor(), answersCount, date};
            model.addRow(newRow);

            // Hacemos visible el mensaje informando que la pregunta se registra correctamente
            successDialog.setVisible(true);
        } catch (FieldEmptyException ex) {
            JOptionPane.showMessageDialog(parent, ex.getMessage());
            labels.clear();
            
        }
        
    }
    

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton addLabelsCheckBtn;
    private javax.swing.JPanel firstFormPanel;
    private javax.swing.JPanel formPanel;
    private javax.swing.JTextArea labelDescriptionTxtArea;
    private javax.swing.JPanel labelsContainer;
    private javax.swing.JPanel labelsFormPanel;
    private javax.swing.JButton postBtn;
    private javax.swing.JTextArea qContentTxtArea;
    private javax.swing.JDialog successDialog;
    private javax.swing.JTextField titleField;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.StackController;
import javax.swing.DefaultListModel;

/**
 *
 * @author Marcelo Guzmán
 */
public class QuestionView extends javax.swing.JDialog {
    Model.Question question;
    StackController stackController;
    
    /**
     * Creates new form QuestionView
     */
    public QuestionView(java.awt.Frame parent, boolean modal, StackController stackController, int questionId) {
        super(parent, modal);
        initComponents();
        this.stackController= stackController;
        question = stackController.getQuestion(questionId);
        
        
        java.awt.CardLayout cl = (java.awt.CardLayout) labelsPanel.getLayout();
        if(question.getLabels()!=null){
            
            DefaultListModel<String> listModel = new DefaultListModel<>();
            for(Model.Label l : question.getLabels()){
                listModel.addElement(l.getName());
            }
            
            labelsList.setModel(listModel);
            cl.show(labelsPanel, "labels");
        }else{
            cl.show(labelsPanel, "nolabels");
        }
        
        
        questionTitleLbl.setText(question.getTitle());
        questionContentText.setText(question.getContent());
        qAuthorTextLbl.setText(question.getAuthor());
        postedTextLbl.setText(stackController.setDateFormat(question.getPostDate(), "dd/MM/yyyy"));
    }

    /**
     * Metodo que se encarga de disponer elementos de la vista de una Pregunta en la pantalla, definir sus dimensiones y layouts de paneles creados.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelsPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        labelsList = new javax.swing.JList<>();
        noLabelsLbl = new javax.swing.JLabel();
        questionTitleLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        questionContentText = new javax.swing.JTextArea();
        postedLbl = new javax.swing.JLabel();
        qAuthorLbl = new javax.swing.JLabel();
        qAuthorTextLbl = new javax.swing.JLabel();
        postedTextLbl = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        answerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("StackOverflow");
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);

        labelsPanel.setLayout(new java.awt.CardLayout());

        labelsList.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        labelsList.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        labelsList.setVisibleRowCount(-1);
        jScrollPane2.setViewportView(labelsList);

        labelsPanel.add(jScrollPane2, "labels");

        noLabelsLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        noLabelsLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        noLabelsLbl.setText("No hay etiquetas");
        labelsPanel.add(noLabelsLbl, "nolabels");

        questionTitleLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        questionContentText.setEditable(false);
        questionContentText.setColumns(20);
        questionContentText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        questionContentText.setLineWrap(true);
        questionContentText.setRows(5);
        jScrollPane1.setViewportView(questionContentText);

        postedLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        postedLbl.setText("Preguntado el");

        qAuthorLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        qAuthorLbl.setText("Autor:");

        qAuthorTextLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        qAuthorTextLbl.setPreferredSize(new java.awt.Dimension(39, 17));

        postedTextLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        postedTextLbl.setPreferredSize(new java.awt.Dimension(39, 17));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(postedLbl)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(postedTextLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(labelsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(qAuthorLbl)))
                                .addGap(12, 12, 12)
                                .addComponent(qAuthorTextLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(questionTitleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(questionTitleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(qAuthorTextLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(qAuthorLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(postedLbl)
                    .addComponent(postedTextLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        backBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        backBtn.setText("Volver");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 201, Short.MAX_VALUE)
        );

        answerButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        answerButton.setText("Responder esta Pregunta");
        answerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backBtn)
                .addGap(128, 128, 128)
                .addComponent(answerButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backBtn)
                    .addComponent(answerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void answerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerButtonActionPerformed
        AnswerView answerView = new AnswerView(this, true, stackController, question);
    }//GEN-LAST:event_answerButtonActionPerformed


    
    public void run(){
        if(stackController.getSessionType()){
            if(question.getAuthor().equals(stackController.getOnlineUsername())){
                answerButton.setEnabled(false);
            }
            answerButton.setVisible(true);
        }else{
            answerButton.setVisible(false);
        }
        
        this.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton answerButton;
    private javax.swing.JButton backBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> labelsList;
    private javax.swing.JPanel labelsPanel;
    private javax.swing.JLabel noLabelsLbl;
    private javax.swing.JLabel postedLbl;
    private javax.swing.JLabel postedTextLbl;
    private javax.swing.JLabel qAuthorLbl;
    private javax.swing.JLabel qAuthorTextLbl;
    private javax.swing.JTextArea questionContentText;
    private javax.swing.JLabel questionTitleLbl;
    // End of variables declaration//GEN-END:variables
}

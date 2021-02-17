/*
 * Vista de una pregunta en base a su ID, desde la cual podremos responderla, cerrarla, votarla, etc.
 */
package View;

import Controller.StackController;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;


public class QuestionView extends javax.swing.JDialog {
    Model.Question question;
    StackController stackController;
    StartFrame parent;
    
    /**
     * Creates new form QuestionView
     * @param parent JFrame padre, en este exclusivo caso se refiere a StartFrame
     * @param modal Determinar el acceso/ no acceso a elementos de JFrame parent mientras se abre el JDialog
     * @param stackController Controlador de la logica interna de StackOverflow
     * @param selectedRow Entero que indica cual es la fila seleccionada. Cada fila se corresponde con un id de pregunta (fila+1 == id de Pregunta) 
     */
    public QuestionView(java.awt.Frame parent, boolean modal, StackController stackController, int selectedRow) {
        super(parent, modal);
        initComponents();
        this.stackController= stackController;
        this.parent = (StartFrame) parent;
        question = stackController.getQuestion(selectedRow); // Obtenemos la pregunta en dicha fila
       
        questionContentText.setMargin(new Insets(2,5,2,5));
        
        java.awt.CardLayout cl = (java.awt.CardLayout) labelsPanel.getLayout();
        if(question.getLabels()!=null){
            // Anadimos las etiquetas al JList
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
        postedTextLbl.setText(StackController.setDateFormat(question.getPostDate(), "dd/MM/yyyy"));
        
        fillAnswersPanel(); 
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        optionsPanel = new javax.swing.JPanel();
        answerButton = new javax.swing.JButton();
        notLoggedMsgLbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        answersSuperPanel = new javax.swing.JPanel();
        answersScrollPane = new javax.swing.JScrollPane();
        answersPanel = new javax.swing.JPanel();
        noAnswersMsgLbl = new javax.swing.JLabel();

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
        questionTitleLbl.setText("Titulo de la pregunta");

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
        qAuthorTextLbl.setText("Nombre Autor");
        qAuthorTextLbl.setPreferredSize(new java.awt.Dimension(39, 17));

        postedTextLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        postedTextLbl.setText("dd/MM/yyyy");
        postedTextLbl.setPreferredSize(new java.awt.Dimension(39, 17));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Recompensa:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Sin recompensa");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Recompensar");
        jLabel4.setToolTipText("Agrega una recompensa a esta pregunta");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(qAuthorLbl)
                                .addGap(12, 12, 12)
                                .addComponent(qAuthorTextLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(postedLbl)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(postedTextLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel4))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(questionTitleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(questionTitleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(qAuthorTextLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(qAuthorLbl)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(postedLbl)
                    .addComponent(postedTextLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        backBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        backBtn.setText("Volver");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        optionsPanel.setLayout(new java.awt.CardLayout());

        answerButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        answerButton.setText("Responder esta Pregunta");
        answerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerButtonActionPerformed(evt);
            }
        });
        optionsPanel.add(answerButton, "answerBtn");

        notLoggedMsgLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        notLoggedMsgLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        notLoggedMsgLbl.setText("Inicie sesion para responder");
        optionsPanel.add(notLoggedMsgLbl, "notLoggedMsg");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Pregunta cerrada");
        optionsPanel.add(jLabel3, "card4");

        answersSuperPanel.setLayout(new java.awt.CardLayout());

        answersPanel.setLayout(new java.awt.GridLayout(0, 1, 0, 5));
        answersScrollPane.setViewportView(answersPanel);

        answersSuperPanel.add(answersScrollPane, "answersPanel");

        noAnswersMsgLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        noAnswersMsgLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        noAnswersMsgLbl.setText("No hay respuestas aun. Sea el primero en responder.");
        answersSuperPanel.add(noAnswersMsgLbl, "noAnswersMsg");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backBtn)
                .addGap(114, 114, 114)
                .addComponent(optionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(answersSuperPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(answersSuperPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backBtn)
                    .addComponent(optionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void answerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerButtonActionPerformed
        AnswerForm answerView = new AnswerForm(this, true, stackController, question);
        answerView.run();
    }//GEN-LAST:event_answerButtonActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        RewardQuestionForm rewardForm = new RewardQuestionForm(this, true, stackController);
        rewardForm.run();
    }//GEN-LAST:event_jLabel4MouseClicked
    
    private void fillAnswersPanel(){
        for(Model.Answer ans: question.getAnswers()){
            AnswerView answer = new AnswerView(ans);
            answer.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(219, 219, 219)));
            answersPanel.add(answer);
        }
    }
    
    public void addNewAnswer(){
        if(question.getAnswersCount()==1){
            CardLayout clAnswers = (CardLayout) answersSuperPanel.getLayout();
            clAnswers.show(answersSuperPanel, "answersPanel");
        }
        
        
        AnswerView answerView = new AnswerView(stackController.getLastAnswer());
        answerView.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(219, 219, 219)));
        answersPanel.add(answerView);
        answersPanel.revalidate();
        answersPanel.repaint();
        
        // Como las filas se enumeran desde el 0 y los ID comienzan desde el 1 restamos 1 al ID.
        parent.getQuestionsTable().getModel().setValueAt(question.getAnswersCount(), question.getId() - 1, StartFrame.QANSWERSCOUNT_COLUMN);
    }

    public void run(){
        setLocationRelativeTo(null);
        CardLayout clOptions = (CardLayout) optionsPanel.getLayout(), clAnswers = (CardLayout) answersSuperPanel.getLayout();
        
        if(question.getAnswersCount()==0){
            clAnswers.show(answersSuperPanel, "noAnswersMsg");
        }else{
            clAnswers.show(answersSuperPanel, "answersPanel");
        }
        
        if(stackController.getSessionType()){
            if(question.getAuthor().equals(stackController.getOnlineUsername())){
                answerButton.setEnabled(false);
            }
            answerButton.setVisible(true);
            clOptions.show(optionsPanel, "answerBtn");
        }else{
            answerButton.setVisible(false);
            clOptions.show(optionsPanel, "notLoggedMsg");
        }
        
        
        
        this.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton answerButton;
    private javax.swing.JPanel answersPanel;
    private javax.swing.JScrollPane answersScrollPane;
    private javax.swing.JPanel answersSuperPanel;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> labelsList;
    private javax.swing.JPanel labelsPanel;
    private javax.swing.JLabel noAnswersMsgLbl;
    private javax.swing.JLabel noLabelsLbl;
    private javax.swing.JLabel notLoggedMsgLbl;
    private javax.swing.JPanel optionsPanel;
    private javax.swing.JLabel postedLbl;
    private javax.swing.JLabel postedTextLbl;
    private javax.swing.JLabel qAuthorLbl;
    private javax.swing.JLabel qAuthorTextLbl;
    private javax.swing.JTextArea questionContentText;
    private javax.swing.JLabel questionTitleLbl;
    // End of variables declaration//GEN-END:variables
}

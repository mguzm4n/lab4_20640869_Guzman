/*
 * Vista de una pregunta en base a su ID, desde la cual podremos responderla, cerrarla, votarla, etc.
 */
package View;

import Controller.StackController;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class QuestionView extends javax.swing.JDialog {
    Model.Question question;
    StackController stackController;
    StartFrame parent;
    
    /**
     * Creates new form QuestionView
     * @param parent JFrame padre, en este exclusivo caso se refiere a StartFrame
     * @param modal Determinar el acceso/ no acceso a elementos de JFrame parent mientras se abre el JDialog
     */
    public QuestionView(StartFrame parent, boolean modal, Model.Question question) throws IOException{
        super(parent, modal);
        initComponents();
        this.stackController= parent.getStackController();
        this.parent = parent;
        this.question = question;
        questionContentText.setMargin(new Insets(2,5,2,5)); // ajuste inicial, como no se puede editar initComponents()
        
        addQuestionVotesView();
        addQuestionLabels();
        setQuestionAttributes();

        
        fillAnswersPanel(); 
    }

    /**
     * Metodo que se encarga de disponer elementos de la vista de una Pregunta en la pantalla, definir sus dimensiones y layouts de paneles creados.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        javax.swing.JPanel superiorPanel = new javax.swing.JPanel();
        labelsPanel = new javax.swing.JPanel();
        javax.swing.JScrollPane labelsScrollPane = new javax.swing.JScrollPane();
        labelsList = new javax.swing.JList<>();
        javax.swing.JLabel noLabelsLbl = new javax.swing.JLabel();
        questionTitleLbl = new javax.swing.JLabel();
        javax.swing.JLabel postedLbl = new javax.swing.JLabel();
        javax.swing.JLabel qAuthorLbl = new javax.swing.JLabel();
        qAuthorTextLbl = new javax.swing.JLabel();
        postedTextLbl = new javax.swing.JLabel();
        javax.swing.JLabel rewardMsgLbl = new javax.swing.JLabel();
        rewardAmountLbl = new javax.swing.JLabel();
        rewardLbl = new javax.swing.JLabel();
        questionStateLbl = new javax.swing.JLabel();
        javax.swing.JPanel questionContentPanel = new javax.swing.JPanel();
        javax.swing.JScrollPane qcontentScrollPane = new javax.swing.JScrollPane();
        questionContentText = new javax.swing.JTextArea();
        votesContainerPanel = new javax.swing.JPanel();
        javax.swing.JButton backBtn = new javax.swing.JButton();
        optionsPanel = new javax.swing.JPanel();
        answerButton = new javax.swing.JButton();
        javax.swing.JLabel notLoggedMsgLbl = new javax.swing.JLabel();
        javax.swing.JLabel closedQuestionLbl = new javax.swing.JLabel();
        answersSuperPanel = new javax.swing.JPanel();
        javax.swing.JScrollPane answersScrollPane = new javax.swing.JScrollPane();
        answersPanel = new javax.swing.JPanel();
        javax.swing.JLabel noAnswersMsgLbl = new javax.swing.JLabel();

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
        labelsScrollPane.setViewportView(labelsList);

        labelsPanel.add(labelsScrollPane, "labels");

        noLabelsLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        noLabelsLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        noLabelsLbl.setText("No hay etiquetas");
        labelsPanel.add(noLabelsLbl, "nolabels");

        questionTitleLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        questionTitleLbl.setText("Titulo de la pregunta");

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

        rewardMsgLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rewardMsgLbl.setText("Recompensa:");

        rewardAmountLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rewardAmountLbl.setText("Sin recompensa");

        rewardLbl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rewardLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rewardLbl.setText("Recompensar");
        rewardLbl.setToolTipText("Agrega una recompensa a esta pregunta");
        rewardLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rewardLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rewardLblMouseClicked(evt);
            }
        });

        questionStateLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        questionStateLbl.setText("Respondida");

        questionContentPanel.setLayout(new java.awt.GridBagLayout());

        qcontentScrollPane.setBorder(null);
        qcontentScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        questionContentText.setEditable(false);
        questionContentText.setColumns(20);
        questionContentText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        questionContentText.setLineWrap(true);
        questionContentText.setRows(5);
        qcontentScrollPane.setViewportView(questionContentText);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        questionContentPanel.add(qcontentScrollPane, gridBagConstraints);

        votesContainerPanel.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        questionContentPanel.add(votesContainerPanel, gridBagConstraints);

        javax.swing.GroupLayout superiorPanelLayout = new javax.swing.GroupLayout(superiorPanel);
        superiorPanel.setLayout(superiorPanelLayout);
        superiorPanelLayout.setHorizontalGroup(
            superiorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(superiorPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(superiorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(superiorPanelLayout.createSequentialGroup()
                        .addGroup(superiorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(superiorPanelLayout.createSequentialGroup()
                                .addComponent(postedLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(postedTextLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rewardMsgLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rewardAmountLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rewardLbl))
                            .addGroup(superiorPanelLayout.createSequentialGroup()
                                .addComponent(labelsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(qAuthorLbl)
                                .addGap(12, 12, 12)
                                .addComponent(qAuthorTextLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(questionContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(superiorPanelLayout.createSequentialGroup()
                        .addComponent(questionTitleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(questionStateLbl)
                        .addGap(48, 48, 48))))
        );
        superiorPanelLayout.setVerticalGroup(
            superiorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(superiorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(superiorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(questionTitleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(questionStateLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(questionContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(superiorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(superiorPanelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(superiorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(qAuthorTextLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qAuthorLbl, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(superiorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(postedLbl)
                    .addComponent(postedTextLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rewardMsgLbl)
                    .addComponent(rewardAmountLbl)
                    .addComponent(rewardLbl))
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

        closedQuestionLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        closedQuestionLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        closedQuestionLbl.setText("Pregunta cerrada");
        optionsPanel.add(closedQuestionLbl, "card4");

        answersSuperPanel.setLayout(new java.awt.CardLayout());

        answersPanel.setLayout(new java.awt.GridLayout(0, 1, 0, 10));
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
            .addComponent(superiorPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(answersSuperPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(superiorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(answersSuperPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
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
        AnswerForm answerForm = new AnswerForm(this, true);
        answerForm.run();
    }//GEN-LAST:event_answerButtonActionPerformed

    /** 
     * Crea una nueva ventana para dar recompensa a la pregunta en cuestion.
     * @param evt 
     */
    private void rewardLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rewardLblMouseClicked
        RewardQuestionForm rewardForm = new RewardQuestionForm(this, true, stackController);
        rewardForm.setVisible(true);
    }//GEN-LAST:event_rewardLblMouseClicked
    
    /**
     * Llena de respuestas la pregunta.
     * @throws IOException 
     */
    private void fillAnswersPanel() throws IOException{
        boolean makeBtn = stackController.getSessionType() &&
                          stackController.getOnlineUsername().equals(question.getAuthor()) && 
                          question.getState().equals("Abierta");

        for(Model.Answer ans: question.getAnswers()){
            AnswerView answerView = new AnswerView(this, ans);  
            if(makeBtn){
                javax.swing.JLabel acceptLbl = answerView.getStateLbl();
                acceptLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                acceptLbl.setText("Aceptar Respuesta");
                acceptLbl.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt){
                        try {
                            acceptLblMouseClicked(evt, ans);
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                });
            }
            
            
            answerView.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(219, 219, 219)));
            answersPanel.add(answerView);
        }
    }
    
    /**
     * anadir las etiquetas, si existen, en la QuestionView
     */
    private void addQuestionLabels(){
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
    }
    
    /**
     * Mapear los atributos que posee la pregunta con los objetos de Swing.
     */
    private void setQuestionAttributes(){
        questionTitleLbl.setText(question.getTitle());
        questionContentText.setText(question.getContent());
        qAuthorTextLbl.setText(question.getAuthor());
        postedTextLbl.setText(StackController.setDateFormat(question.getPostDate(), "dd/MM/yyyy"));
        rewardAmountLbl.setText(question.getReward()==0? "Sin recompensa" : Integer.toString(question.getReward()));
        questionStateLbl.setText(question.getState());
    }
    
    /**
     * Accion que debe ejecutarse cuando se haga clic en el boton de acceptLbl
     * @param evt
     * @param ans La respuesta aceptada.
     */
    private void acceptLblMouseClicked(MouseEvent evt, Model.Answer ans) throws IOException{
       int selectedOption = JOptionPane.showConfirmDialog(this, "�Est� seguro que desea aceptar esta pregunta?");
       if(selectedOption == JOptionPane.YES_OPTION){
           
           //javax.swing.JLabel acceptLblBtn = (javax.swing.JLabel) evt.getComponent();
           //acceptLblBtn.setText("Aceptada");
           
           stackController.accept(question, ans);
           parent.getReputationLbl().setText(Integer.toString(stackController.getOnlineUser().getReputation()));
           questionStateLbl.setText(question.getState());
           rewardLbl.setEnabled(false);
           rewardLbl.setText("Respondida");
           
           answersPanel.removeAll();
           fillAnswersPanel();
           answersPanel.revalidate();
           answersPanel.repaint();
           
           JOptionPane.showMessageDialog(this, "Respuesta Aceptada Correctamente");
       }
    }
    
    /**
     * Anadir la vista de los votos a la pregunta
     * @throws IOException 
     */
    private void addQuestionVotesView() throws IOException{
        votesContainerPanel.add(new VotesView(this, question), BorderLayout.PAGE_START);
        JPanel whiteSpacePanel = new JPanel();
        whiteSpacePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        votesContainerPanel.add(whiteSpacePanel, BorderLayout.PAGE_END);
    }
    
    /**
     * Anadir una nueva vista de respuesta al panel de respuestas
     * @throws IOException 
     */
    public void addNewAnswer() throws IOException{
        if(question.getAnswersCount()==1){
            CardLayout clAnswers = (CardLayout) answersSuperPanel.getLayout();
            clAnswers.show(answersSuperPanel, "answersPanel");
        }
        
        
        AnswerView answerView = new AnswerView(this, stackController.getLastAnswer(question));
        answerView.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(219, 219, 219)));
        answersPanel.add(answerView);
        answersPanel.revalidate();
        answersPanel.repaint();
        
        // Como las filas se enumeran desde el 0 y los ID comienzan desde el 1 restamos 1 al ID.
        // 2 es el n�mero de la columna que posee las respuestas
        parent.getQuestionsTable().getModel().setValueAt(question.getAnswersCount(), question.getId() - 1, 2);
    }

    /**
     * inicializar la vista QuestionView segun los datos del usuario online
     */
    public void run(){
        setLocationRelativeTo(null);
        CardLayout clOptions = (CardLayout) optionsPanel.getLayout(), clAnswers = (CardLayout) answersSuperPanel.getLayout();
        
        if(question.getAnswersCount()==0){
            clAnswers.show(answersSuperPanel, "noAnswersMsg");
        }else{
            clAnswers.show(answersSuperPanel, "answersPanel");
        }
        
        if(stackController.getSessionType()){
            if(question.getAuthor().equals(stackController.getOnlineUsername()) || question.getState().equals("Cerrada")){
                answerButton.setEnabled(false);
            }
            answerButton.setVisible(true);
            
            if(question.getState().equals("Cerrada")){
                rewardLbl.setEnabled(false);
                rewardLbl.setText("Respondida");
            }
            clOptions.show(optionsPanel, "answerBtn");
        }else{
            rewardLbl.setText(question.getState().equals("Cerrada")? "Respondida" : "Sin Respuesta");
            rewardLbl.setEnabled(false);
            answerButton.setVisible(false);
            clOptions.show(optionsPanel, "notLoggedMsg");
        }
        
        
        this.setVisible(true);
    }
    public StartFrame getParent(){
        return parent;
    }
    
    public StackController getStackController(){
        return stackController;
    }
    
    public Model.Question getQuestion(){
        return question;
    }
    public javax.swing.JLabel getRewardAmountLbl(){
        return rewardAmountLbl;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton answerButton;
    private javax.swing.JPanel answersPanel;
    private javax.swing.JPanel answersSuperPanel;
    private javax.swing.JList<String> labelsList;
    private javax.swing.JPanel labelsPanel;
    private javax.swing.JPanel optionsPanel;
    private javax.swing.JLabel postedTextLbl;
    private javax.swing.JLabel qAuthorTextLbl;
    private javax.swing.JTextArea questionContentText;
    private javax.swing.JLabel questionStateLbl;
    private javax.swing.JLabel questionTitleLbl;
    private javax.swing.JLabel rewardAmountLbl;
    private javax.swing.JLabel rewardLbl;
    private javax.swing.JPanel votesContainerPanel;
    // End of variables declaration//GEN-END:variables
}
































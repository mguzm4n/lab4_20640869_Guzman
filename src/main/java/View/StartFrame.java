/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.StackController;
import Errors.NoCurrentUserOnlineFoundException;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marcelo Guzmán
 */
public class StartFrame extends javax.swing.JFrame {
    static final int QAUTHOR_COLUMN = 0, QTITLE_COLUMN = 1, QANSWERSCOUNT_COLUMN = 2, QDATE_COLUMN = 3;
    static final String ALL_QUESTIONS_TABLE = "allQuestionsTable", ONLINE_USER_QUESTIONS = "onlineUserQuestions";

    boolean firstCreated = true; 
    StackController stackController;

    /**
     * Creates new form NewJFrame
     * @param stackController
     */
    public StartFrame(StackController stackController) {
        this.stackController = stackController;
        initComponents();
        
        questionsScrollPane.setName(ALL_QUESTIONS_TABLE);
        userQuestionsScrollPane.setName(ONLINE_USER_QUESTIONS);
        
        questionsTable.setDefaultEditor(Object.class, null); // deshabilitamos la opcion de editar las filas de la tabla de preguntas
        userQuestionsTable.setDefaultEditor(Object.class, null);
    
        questionsTable.addMouseListener(new QuestionSelectionAction(questionsTable, stackController, this));
        userQuestionsTable.addMouseListener(new QuestionSelectionAction(userQuestionsTable, stackController, this));
        
      }

    /**
     * Inicializa la ventana.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container1 = new javax.swing.JPanel();
        logRegisterPanel = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        registerButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        loggedPanel = new javax.swing.JPanel();
        welcomeMsgLbl = new javax.swing.JLabel();
        usernameDisplay = new javax.swing.JLabel();
        logOutBtn = new javax.swing.JButton();
        reputationMsgLbl = new javax.swing.JLabel();
        makeQuestionBtn = new javax.swing.JButton();
        container2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        questionsScrollPane = new javax.swing.JScrollPane();
        questionsTable = new javax.swing.JTable();
        userQuestionsScrollPane = new javax.swing.JScrollPane();
        userQuestionsTable = new javax.swing.JTable();
        userQuestionsBtn = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        container1.setLayout(new java.awt.CardLayout());

        logRegisterPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        logRegisterPanel.setPreferredSize(new java.awt.Dimension(563, 116));
        logRegisterPanel.setRequestFocusEnabled(false);

        welcomeLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        welcomeLabel.setText("Bienvenido a StackOverflow");

        registerButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        registerButton.setText("Registrarse");
        registerButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        loginButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loginButton.setText("Iniciar Sesion");
        loginButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout logRegisterPanelLayout = new javax.swing.GroupLayout(logRegisterPanel);
        logRegisterPanel.setLayout(logRegisterPanelLayout);
        logRegisterPanelLayout.setHorizontalGroup(
            logRegisterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logRegisterPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(logRegisterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(logRegisterPanelLayout.createSequentialGroup()
                        .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        logRegisterPanelLayout.setVerticalGroup(
            logRegisterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logRegisterPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(logRegisterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        container1.add(logRegisterPanel, "card1");

        loggedPanel.setPreferredSize(new java.awt.Dimension(563, 116));

        welcomeMsgLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        welcomeMsgLbl.setText("Bienvenido,");

        usernameDisplay.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        logOutBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        logOutBtn.setText("Cerrar Sesion");
        logOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutBtnActionPerformed(evt);
            }
        });

        reputationMsgLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        reputationMsgLbl.setText("Reputación:");

        makeQuestionBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        makeQuestionBtn.setText("Realizar una Pregunta");
        makeQuestionBtn.setPreferredSize(new java.awt.Dimension(169, 22));
        makeQuestionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeQuestionBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loggedPanelLayout = new javax.swing.GroupLayout(loggedPanel);
        loggedPanel.setLayout(loggedPanelLayout);
        loggedPanelLayout.setHorizontalGroup(
            loggedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loggedPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(loggedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(loggedPanelLayout.createSequentialGroup()
                        .addComponent(welcomeMsgLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usernameDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(makeQuestionBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(loggedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reputationMsgLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
        loggedPanelLayout.setVerticalGroup(
            loggedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loggedPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(loggedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loggedPanelLayout.createSequentialGroup()
                        .addComponent(logOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reputationMsgLbl))
                    .addGroup(loggedPanelLayout.createSequentialGroup()
                        .addGroup(loggedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(welcomeMsgLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(makeQuestionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        container1.add(loggedPanel, "card2");

        container2.setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(247, 247, 247));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("No hay preguntas que mostrar actualmente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel2)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel2)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        container2.add(jPanel1, "card2");

        questionsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titulo", "Autor", "Respuestas", "Fecha"
            }
        ));
        questionsTable.getTableHeader().setReorderingAllowed(false);
        questionsScrollPane.setViewportView(questionsTable);

        container2.add(questionsScrollPane, "allQuestionsTable");

        userQuestionsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titulo de Pregunta", "Respuestas", "Fecha"
            }
        ));
        userQuestionsTable.getTableHeader().setReorderingAllowed(false);
        userQuestionsScrollPane.setViewportView(userQuestionsTable);

        container2.add(userQuestionsScrollPane, "onlineUserQuestions");

        userQuestionsBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        userQuestionsBtn.setText("Ver mis Preguntas");
        userQuestionsBtn.setToolTipText("Ayuda a encontrar sus preguntas hechas y aceptar respuestas utiles");
        userQuestionsBtn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                userQuestionsBtnItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(container1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(container2, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(userQuestionsBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(container1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(container2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(userQuestionsBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        LoginDialog loginDialog = new LoginDialog(this, true, stackController);
        runJDialog(loginDialog);
    }//GEN-LAST:event_loginButtonActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        RegisterDialog registerDialog = new RegisterDialog(this, true, stackController);
        runJDialog(registerDialog);
    }//GEN-LAST:event_registerButtonActionPerformed

    private void logOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutBtnActionPerformed
        try {
            stackController.logOut();
            java.awt.CardLayout clContainer1 = (java.awt.CardLayout) container1.getLayout(), clContainer2 = (java.awt.CardLayout) container2.getLayout();
            JOptionPane.showMessageDialog(this, "Sesion cerrada correctamente.");
            clContainer1.show(container1, "card1"); // card1 es el panel de la vista que un usuario sin iniciar sesion observa
            clContainer2.show(container2, ALL_QUESTIONS_TABLE);
            userQuestionsBtn.setVisible(false);
            userQuestionsBtn.setSelected(false);
        } catch (NoCurrentUserOnlineFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_logOutBtnActionPerformed

    private void makeQuestionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeQuestionBtnActionPerformed
        QuestionForm questionForm = new QuestionForm(this, true, stackController);
        runJDialog(questionForm);
    }//GEN-LAST:event_makeQuestionBtnActionPerformed

    private void userQuestionsBtnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_userQuestionsBtnItemStateChanged
        java.awt.CardLayout cl = (java.awt.CardLayout) container2.getLayout();
        int estado = evt.getStateChange();
        if(estado==ItemEvent.SELECTED){
            makeQuestionBtn.setEnabled(false);
            userQuestionsBtn.setText("Mostrar todas las Preguntas");
            Model.Question question;
            DefaultTableModel model = (DefaultTableModel) userQuestionsTable.getModel();
            model.setRowCount(0); // Limpiamos cualquier dato que haya quedado en la tabla por seguridad.
            
            // Rellenamos la tabla con las preguntas del usuario
            for(Integer i: stackController.getCurrentSession().getOnlineUser().getQuestions()){
                question = stackController.getQuestionByID(i);
                String date = StackController.setDateFormat(question.getPostDate(), "dd/MM/yyyy");
                String answersCount = question.getAnswersCount()==0? "Sin respuestas aun" : (Integer.valueOf(question.getAnswersCount())).toString();
                Object[] newRow = {question.getTitle(), answersCount, date};
                model.addRow(newRow);
            }
            
            
            cl.show(container2, ONLINE_USER_QUESTIONS);
        }else{
            makeQuestionBtn.setEnabled(true);
            userQuestionsBtn.setText("Ver mis Preguntas");
           
            cl.show(container2, ALL_QUESTIONS_TABLE);
            
        }
    }//GEN-LAST:event_userQuestionsBtnItemStateChanged

    public void runJDialog(javax.swing.JDialog dialog){
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
    
    public void run() {
       setTitle("StackOverflow");
        
        // Editamos el tamano de la font de los titulos de la tabla. 
        questionsTable.getTableHeader().setFont(new java.awt.Font("Tahoma", 0 , 14));
        userQuestionsBtn.setVisible(false);
        
        setLocationRelativeTo(null); // Seteamos la posición del frame StartFrame en el centro de la pantalla
        setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel container1;
    private javax.swing.JPanel container2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JPanel logRegisterPanel;
    private javax.swing.JPanel loggedPanel;
    private javax.swing.JButton loginButton;
    private javax.swing.JButton makeQuestionBtn;
    private javax.swing.JScrollPane questionsScrollPane;
    private javax.swing.JTable questionsTable;
    private javax.swing.JButton registerButton;
    private javax.swing.JLabel reputationMsgLbl;
    private javax.swing.JToggleButton userQuestionsBtn;
    private javax.swing.JScrollPane userQuestionsScrollPane;
    private javax.swing.JTable userQuestionsTable;
    private javax.swing.JLabel usernameDisplay;
    private javax.swing.JLabel welcomeLabel;
    private javax.swing.JLabel welcomeMsgLbl;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JPanel getContainer1(){
        return container1;
    }
    public javax.swing.JPanel getContainer2(){
        return container2;
    }
    public javax.swing.JPanel getLoggedPanel(){
        return loggedPanel;
    }
    public javax.swing.JLabel getUsernameDisplay(){
        return usernameDisplay;
    }
    public javax.swing.JToggleButton getUserQuestionsBtn(){
        return userQuestionsBtn;
    }
    public javax.swing.JTable getQuestionsTable(){
        return questionsTable;
    }
    public javax.swing.JScrollPane getQuestionsScrollPane(){
        return questionsScrollPane;
    }
            
}

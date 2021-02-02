/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.StackController;
import Errors.NoCurrentUserOnlineFoundException;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JWindow;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marcelo Guzm�n
 */
public class StartFrame extends javax.swing.JFrame {
    StackController stackController;
    //DefaultTableModel dtm;
    /**
     * Creates new form NewJFrame
     * @param stackController
     */
    public StartFrame(StackController stackController) {
        this.stackController = stackController;
        initComponents();
        
      }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container1 = new javax.swing.JLayeredPane();
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
        questionsScrollPane = new javax.swing.JScrollPane();
        questionsTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        container1.setLayout(new java.awt.CardLayout());

        logRegisterPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

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
                .addGap(30, 30, 30)
                .addGroup(logRegisterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(welcomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(logRegisterPanelLayout.createSequentialGroup()
                        .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(359, Short.MAX_VALUE))
        );
        logRegisterPanelLayout.setVerticalGroup(
            logRegisterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logRegisterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(logRegisterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(registerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addContainerGap())
        );

        container1.add(logRegisterPanel, "card3");

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
        reputationMsgLbl.setText("Reputaci�n:");

        makeQuestionBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        makeQuestionBtn.setText("Realizar una Pregunta");
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addGroup(loggedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reputationMsgLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(makeQuestionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        container1.add(loggedPanel, "card2");

        questionsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titulo", "Autor", "Respuestas", "Fecha"
            }
        ));
        questionsTable.getTableHeader().setReorderingAllowed(false);
        questionsScrollPane.setViewportView(questionsTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container1)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(questionsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(container1)
                .addGap(37, 37, 37)
                .addComponent(questionsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
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
            container1.removeAll();
            container1.add(logRegisterPanel);
            container1.repaint();
            container1.revalidate();
            
        } catch (NoCurrentUserOnlineFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_logOutBtnActionPerformed

    private void makeQuestionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeQuestionBtnActionPerformed
        QuestionForm questionForm = new QuestionForm(this, true, stackController);
        runJDialog(questionForm);
        
    }//GEN-LAST:event_makeQuestionBtnActionPerformed


    public void runJDialog(javax.swing.JDialog dialog){
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
    
    public void run() {
        setTitle("StackOverflow");
        setLocationRelativeTo(null); // Seteamos la posici�n del JFrame StartFrame en el centro del monitor
        setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane container1;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JPanel logRegisterPanel;
    private javax.swing.JPanel loggedPanel;
    private javax.swing.JButton loginButton;
    private javax.swing.JButton makeQuestionBtn;
    private javax.swing.JScrollPane questionsScrollPane;
    private javax.swing.JTable questionsTable;
    private javax.swing.JButton registerButton;
    private javax.swing.JLabel reputationMsgLbl;
    private javax.swing.JLabel usernameDisplay;
    private javax.swing.JLabel welcomeLabel;
    private javax.swing.JLabel welcomeMsgLbl;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JLayeredPane getContainer1(){
        return container1;
    }
    public javax.swing.JPanel getLoggedPanel(){
        return loggedPanel;
    }
    public javax.swing.JLabel getUsernameDisplay(){
        return usernameDisplay;
    }
            
}

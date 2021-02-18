/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.StackController;
import Errors.NoPasswordEnteredException;
import Errors.NoUsernameEnteredException;
import Errors.UsernameAlreadyExistsException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Marcelo Guzmán
 */
public class RegisterDialog extends javax.swing.JDialog {
    StackController stackController;
    
    
    /**
     * Creates new form registerDialog
     */
    public RegisterDialog(java.awt.Frame parent, boolean modal, StackController stackController) {
        super(parent, modal);
        initComponents();
        
        
        this.stackController = stackController;
        List<JTextField> list = new ArrayList<>(List.of(passwField, usernameField)); // Crear lista de campos de texto de contrasena y usuario
        
        registerBtn.setEnabled(false);
        // Controlamos que, a menos que llene los campos el boton de registro no este disponible
        DocumentListener listener = new DocumentListener() {
        @Override
        public void removeUpdate(DocumentEvent e){ changedUpdate(e); }
        @Override
        public void insertUpdate(DocumentEvent e){ changedUpdate(e); }
        @Override
            public void changedUpdate(DocumentEvent e) {
                boolean canEnable = true;
                for (JTextField textField : list) {
                    if (textField.getText().isEmpty()) {
                        canEnable = false;
                    }
                }
                
                registerBtn.setEnabled(canEnable);
            }
        };
        
        for(JTextField textField : list){
            textField.getDocument().addDocumentListener(listener);
        }
        
        this.getRootPane().setDefaultButton(registerBtn);
        
    }

    /**
     * Metodo para disponer en la pantalla los componentes del JDialog Register y el layout del mismo
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        successDialog = new javax.swing.JDialog();
        sucessLbl = new javax.swing.JLabel();
        backToStart = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        usernameField = new javax.swing.JTextField();
        passwField = new javax.swing.JPasswordField();
        usernameLbl = new javax.swing.JLabel();
        passwLbl = new javax.swing.JLabel();
        registerLbl = new javax.swing.JLabel();
        registerBtn = new javax.swing.JButton();

        successDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        successDialog.setTitle("StackOverflow");
        successDialog.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);

        sucessLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sucessLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sucessLbl.setText("Se ha registrado correctamente!");

        backToStart.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        backToStart.setText("Volver a la ventana principal");
        backToStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToStartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout successDialogLayout = new javax.swing.GroupLayout(successDialog.getContentPane());
        successDialog.getContentPane().setLayout(successDialogLayout);
        successDialogLayout.setHorizontalGroup(
            successDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(successDialogLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(successDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sucessLbl)
                    .addComponent(backToStart))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        successDialogLayout.setVerticalGroup(
            successDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, successDialogLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(sucessLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backToStart, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("StackOverflow");
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setResizable(false);

        backBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        backBtn.setText("Volver");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        usernameField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });

        passwField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        usernameLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        usernameLbl.setText("Nombre de Usuario");

        passwLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        passwLbl.setText("Contraseña");

        registerLbl.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        registerLbl.setText("Registrarse");

        registerBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        registerBtn.setText("Registrarse");
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(registerLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(registerBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameLbl)
                            .addComponent(passwLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(registerLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLbl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwLbl))
                .addGap(36, 36, 36)
                .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backBtn)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    /**
     * Al pulsar el botón back cerraremos sólo el diálogo de registro
     * @param evt 
     */
    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    /**
     * Al pulsar botón backToStart cerraremos la ventana que denota el éxito en la operación de registro y el mismo diálogo de registro
     * @param evt 
     */
    private void backToStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToStartActionPerformed
        successDialog.dispose();
        this.dispose();
    }//GEN-LAST:event_backToStartActionPerformed

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        try {
            registerAction();
        } catch (NoPasswordEnteredException | UsernameAlreadyExistsException | NoUsernameEnteredException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_registerBtnActionPerformed

    private void registerAction() throws NoPasswordEnteredException, UsernameAlreadyExistsException, NoUsernameEnteredException{
        if(stackController.register(usernameField.getText(), passwField.getPassword())){
            successDialog.pack(); // Metodo para que el componente JDialog adopte la "preferedSize" 
            successDialog.setLocationRelativeTo(null);
            successDialog.setVisible(true);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton backToStart;
    private javax.swing.JPasswordField passwField;
    private javax.swing.JLabel passwLbl;
    private javax.swing.JButton registerBtn;
    private javax.swing.JLabel registerLbl;
    private javax.swing.JDialog successDialog;
    private javax.swing.JLabel sucessLbl;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLbl;
    // End of variables declaration//GEN-END:variables

}

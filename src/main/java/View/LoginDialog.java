/**
 * Vista de la ventana para loggearnos en el Stack y hereda de JDialog.
 * @author Marcelo Guzmán
 */
package View;

import Controller.StackController;
import Errors.IncorrectPasswException;
import Errors.InexistentUserException;
import Errors.NoPasswordEnteredException;
import Errors.NoUsernameEnteredException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class LoginDialog extends javax.swing.JDialog {
    StackController stackController;
    StartFrame parentFrame;
    
    /**  
     * Creates new form LoginDialog
     */
    public LoginDialog(java.awt.Frame parent, boolean modal, StackController stackController) {
        super(parent, modal);
        initComponents();
        this.stackController = stackController;
        parentFrame = (StartFrame) parent; 
        
        List<JTextField> list = new ArrayList<>(List.of(passwField, usernameField));
        loginBtn.setEnabled(false);
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
                loginBtn.setEnabled(canEnable);
            }
        };
        
        for(JTextField textField : list){
            textField.getDocument().addDocumentListener(listener);
        }
        this.getRootPane().setDefaultButton(loginBtn);
    }

    /**
     * Metodo para inicializar la posicion inicial y construccion de componentes de la ventana LoginDialog.
     * Este codigo es auto-generado constantemente segun los cambios de posicion de los componentes de la interfaz, por lo que no se debe editar.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        passwordLbl = new javax.swing.JLabel();
        usernameLbl = new javax.swing.JLabel();
        loginLbl = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        passwField = new javax.swing.JPasswordField();
        loginBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("StackOverflow");
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);

        passwordLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        passwordLbl.setText("Contraseña");

        usernameLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        usernameLbl.setText("Nombre de Usuario");

        loginLbl.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        loginLbl.setText("Iniciar Sesión");

        loginBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        loginBtn.setText("Entrar");
        loginBtn.setEnabled(false);
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loginLbl)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usernameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passwordLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passwField, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(loginBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(loginBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        backBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        backBtn.setText("Volver");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backBtn)
                .addContainerGap(238, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(backBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Quita el formulario de log in de la ventana.
     * @param evt 
     */
    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    /**
     * Implementa metodo loginAction() que a su vez utiliza el controlador del stack para loggearnos a la aplicacion.
     * Notar que en este caso que el evento accionado es un clic.
     * @param evt 
     */
    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        try {
            loginAction();
            
        } catch (IncorrectPasswException | InexistentUserException | NoPasswordEnteredException | NoUsernameEnteredException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_loginBtnActionPerformed

        
    private void loginAction() throws IncorrectPasswException, InexistentUserException, NoPasswordEnteredException, NoUsernameEnteredException{
        if(stackController.login(usernameField.getText(), passwField.getPassword())){
            JPanel container1 = parentFrame.getContainer1();
            //JPanel panel = parentFrame.getLoggedPanel();
            parentFrame.getUsernameDisplay().setText(stackController.getOnlineUsername());
            if(stackController.getOnlineUser().getQuestions().isEmpty()){
                parentFrame.getUserQuestionsBtn().setEnabled(false);
            }
            parentFrame.getUserQuestionsBtn().setVisible(true);
            parentFrame.getRewardLbl().setText(Integer.toString(stackController.getOnlineUser().getReputation()));
            java.awt.CardLayout cl = (java.awt.CardLayout) container1.getLayout();
            cl.show(container1, "card2"); // card2 es el identificador del panel con opciones de inicio de sesion
            // Cerramos la ventana de inicio de sesion
            this.dispose();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginBtn;
    private javax.swing.JLabel loginLbl;
    private javax.swing.JPasswordField passwField;
    private javax.swing.JLabel passwordLbl;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLbl;
    // End of variables declaration//GEN-END:variables
}

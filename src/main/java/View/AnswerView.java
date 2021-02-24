package View;


import Controller.StackController;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.BorderFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marcelo Guzmán
 */
public class AnswerView extends javax.swing.JPanel {

    public AnswerView(Model.Answer ans) {
        initComponents();
        authorLbl.setText(ans.getAuthor());
        contentTxtArea.setText(ans.getContent());
        contentTxtArea.setMargin(new Insets(2,5,2,5));
        dateLbl.setText(Controller.StackController.setDateFormat(ans.getPostDate(), "dd/MM/yyyy"));
        acceptLbl.setText(ans.getState());
        
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

        jScrollPane1 = new javax.swing.JScrollPane();
        contentTxtArea = new javax.swing.JTextArea();
        authorLbl = new javax.swing.JLabel();
        dateLbl = new javax.swing.JLabel();
        votesPanel = new javax.swing.JPanel();
        votesUpBtn = new javax.swing.JButton();
        votesDownBtn = new javax.swing.JButton();
        acceptLbl = new javax.swing.JLabel();

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        contentTxtArea.setEditable(false);
        contentTxtArea.setColumns(20);
        contentTxtArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        contentTxtArea.setLineWrap(true);
        contentTxtArea.setRows(4);
        contentTxtArea.setText("Contenido");
        jScrollPane1.setViewportView(contentTxtArea);

        authorLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        authorLbl.setText("Autor");

        dateLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dateLbl.setText("dd/mm/aaaa");

        votesPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        votesUpBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        votesUpBtn.setForeground(new java.awt.Color(51, 153, 0));
        votesUpBtn.setText("0");
        votesUpBtn.setToolTipText("Dar voto positivo");
        votesUpBtn.setBorder(null);
        votesUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                votesUpBtnActionPerformed(evt);
            }
        });

        votesDownBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        votesDownBtn.setForeground(new java.awt.Color(204, 0, 51));
        votesDownBtn.setText("0");
        votesDownBtn.setToolTipText("Dar voto negativo");
        votesDownBtn.setBorder(null);
        votesDownBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                votesDownBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout votesPanelLayout = new javax.swing.GroupLayout(votesPanel);
        votesPanel.setLayout(votesPanelLayout);
        votesPanelLayout.setHorizontalGroup(
            votesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(votesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(votesUpBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(votesDownBtn)
                .addContainerGap())
        );
        votesPanelLayout.setVerticalGroup(
            votesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, votesPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(votesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(votesUpBtn)
                    .addComponent(votesDownBtn))
                .addContainerGap())
        );

        acceptLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        acceptLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        acceptLbl.setText("No Aceptada");
        acceptLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(votesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dateLbl)
                        .addGap(18, 18, 18)
                        .addComponent(authorLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(acceptLbl)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dateLbl)
                            .addComponent(authorLbl)
                            .addComponent(acceptLbl)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(votesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void votesUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_votesUpBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_votesUpBtnActionPerformed

    private void votesDownBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_votesDownBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_votesDownBtnActionPerformed

    public javax.swing.JLabel getAcceptLbl(){
        return acceptLbl;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel acceptLbl;
    private javax.swing.JLabel authorLbl;
    private javax.swing.JTextArea contentTxtArea;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton votesDownBtn;
    private javax.swing.JPanel votesPanel;
    private javax.swing.JButton votesUpBtn;
    // End of variables declaration//GEN-END:variables

}

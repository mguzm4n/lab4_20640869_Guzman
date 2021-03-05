/*
 * Vista de los votos. Extiende de JPanel.
 */
package View;

import Controller.StackController;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import Model.InteractiveBlock;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import javax.swing.JOptionPane;


public class VotesView extends javax.swing.JPanel {
    private QuestionView parent;
    private StackController stackController;
    private InteractiveBlock interactiveBlock;
    private JToggleButton voteUpBtn, voteDownBtn;
    private JLabel totalVotesLbl;
    private Boolean hasVoted;

    
    public VotesView(QuestionView parent, InteractiveBlock interactiveBlock) throws IOException{
        this.stackController = parent.getStackController();
        this.parent = parent;
        this.interactiveBlock = interactiveBlock;
        setLayout(new java.awt.GridLayout(3, 1, 0, 2));
        voteUpBtn = new JToggleButton();
        voteDownBtn = new JToggleButton();
        
        Image imageIcon1, imageIcon2, imageSelected1, imageSelected2;
        
        ArrayList<JToggleButton> btnlist = new ArrayList<>();
        btnlist.add(voteUpBtn); btnlist.add(voteDownBtn);
        totalVotesLbl = new JLabel("0", JLabel.CENTER);
        
        for(JToggleButton btn : btnlist){
            btn.setBorderPainted(false);
            btn.setContentAreaFilled(false);
        }
        
        
        try {
            
            imageIcon1 = ImageIO.read(getClass().getResource("/up-arrow-medium.png"));
            imageIcon2 = ImageIO.read(getClass().getResource("/down-arrow-medium.png"));
            
            imageSelected1 = ImageIO.read(getClass().getResource("/up-arrow-medium-selected.png"));
            imageSelected2 = ImageIO.read(getClass().getResource("/down-arrow-medium-selected.png"));

            voteUpBtn.setIcon(new ImageIcon(imageIcon1.getScaledInstance(27, 27, Image.SCALE_SMOOTH)));
            voteDownBtn.setIcon(new ImageIcon(imageIcon2.getScaledInstance(27, 27, Image.SCALE_SMOOTH)));
            
            voteUpBtn.setSelectedIcon(new ImageIcon(imageSelected1.getScaledInstance(27, 27, Image.SCALE_SMOOTH)));
            voteDownBtn.setSelectedIcon(new ImageIcon(imageSelected2.getScaledInstance(27, 27, Image.SCALE_SMOOTH)));
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        
        hasVoted = false;
        
        initVotes();
        initButtonsEvents(btnlist);
        
        
        add(voteUpBtn);
        add(totalVotesLbl);
        add(voteDownBtn);
        
    }
    
    /**
     * Determina los estados iniciales de los votos segun el usuario activo
     */
    private void initVotes(){
        
        Integer totalVotes = interactiveBlock.getVotes().getTotalVotes();
        
        if(stackController.getSessionType()){
        
        String user = stackController.getOnlineUsername();
        HashMap<String, Boolean> submittedVotes = interactiveBlock.getSubmittedVotes();
        hasVoted = submittedVotes.containsKey(user);
        if(hasVoted){
            Boolean voteType = submittedVotes.get(user);
            if(voteType){
                voteUpBtn.setSelected(true);
            }else{
                voteDownBtn.setSelected(true);
            }
        }
        }
        
        totalVotesLbl.setText(totalVotes.toString());
        
        
    }
    
    /**
     * Agrega los eventos correspondientes a los botones
     * @param btnlist 
     */
    private void initButtonsEvents(ArrayList<JToggleButton> btnlist){
        if(stackController.getSessionType()){
            if(!stackController.getOnlineUsername().equals(interactiveBlock.getAuthor())){
                voteUpBtn.addItemListener(new java.awt.event.ItemListener() {
                    @Override
                    public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        voteUpButtonClicked(evt);
                    }
                });

                voteDownBtn.addItemListener(new java.awt.event.ItemListener() {
                    @Override
                    public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        voteDownButtonClicked(evt);
                    }
                }); 
            }else{
                for(JToggleButton btn : btnlist){
                btn.setSelected(false);
               
                btn.addActionListener(new java.awt.event.ActionListener() {
                    @Override

                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null, "Usted no puede emitir votos a su propio contenido.");
                    }
                });
            }
            }
            
        }else{
            for(JToggleButton btn : btnlist){
                btn.setSelected(false);
               
                btn.addActionListener(new java.awt.event.ActionListener() {
                    @Override

                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null, "Usuarios sin sesión iniciada no pueden emitir votos");
                    }
                });
            }
        }
    }
    
    /**
     * accion que se realiza cuando demos un voto positivo.
     * @param evt 
     */
    private void voteUpButtonClicked(ItemEvent evt){
       
        if(evt.getStateChange()==ItemEvent.DESELECTED){
            stackController.undoVoteUp(interactiveBlock);
        }else{
            if(voteDownBtn.isSelected()){
                voteDownBtn.setSelected(false);
            }
            stackController.submitVoteUp(interactiveBlock);
        }
        Integer totalVotes = interactiveBlock.getVotes().getTotalVotes();
        totalVotesLbl.setText(totalVotes.toString());
        parent.getParent().getReputationLbl().setText(Integer.toString(stackController.getOnlineUser().getReputation()));
    }
    
    /**
     * Accion que se realiza cuando demos un voto negativo.
     * @param evt 
     */
    private void voteDownButtonClicked(ItemEvent evt){
        
        if(evt.getStateChange()==ItemEvent.DESELECTED){
            stackController.undoVoteDown(interactiveBlock);
        }else{
            if(voteUpBtn.isSelected()){
                voteUpBtn.setSelected(false);
            }
            stackController.submitVoteDown(interactiveBlock);
        }
        Integer totalVotes = interactiveBlock.getVotes().getTotalVotes();
        totalVotesLbl.setText(totalVotes.toString());
    }
    
    public JToggleButton getVoteUpBtn(){
        return voteUpBtn;
    }
    
    public JToggleButton getVoteDownBtn(){
        return voteDownBtn;
    }

                
}
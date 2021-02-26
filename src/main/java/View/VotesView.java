package View;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


public class VotesView extends javax.swing.JPanel {

    /**
     * Creates new form VotesView
     */
    public VotesView() throws IOException{
        setLayout(new java.awt.GridLayout(3, 1, 0, 2));
        
        Image image1, image2;
        JButton button1 = new JButton(), button2 = new JButton();
        ArrayList<JButton> btnlist = new ArrayList<>();
        btnlist.add(button1); btnlist.add(button2);
        JLabel votesLabel = new JLabel("0", JLabel.CENTER);
        
        for(JButton btn : btnlist){
            btn.setSize(25, 20);
            btn.setBorderPainted(false);
            btn.setContentAreaFilled(false);
        }
        
        
        try {
            image1 = ImageIO.read(getClass().getResource("/up-arrow.png"));
            image2 = ImageIO.read(getClass().getResource("/down-arrow.png"));

            button1.setIcon(new ImageIcon(image1.getScaledInstance(button1.getWidth(), button1.getHeight(), Image.SCALE_SMOOTH)));
            button2.setIcon(new ImageIcon(image2.getScaledInstance(button1.getWidth(), button1.getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        
        add(button1);
        add(votesLabel);
        add(button2);
        
    }
                
}
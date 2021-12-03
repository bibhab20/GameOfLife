package View;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


public class AboutPanel extends JPanel {

    public AboutPanel() {

        JLabel background;
        this.setPreferredSize(new Dimension(800,600));
        this.setBackground(Color.darkGray);

   /*     ImageIcon img = new ImageIcon("rules.png");
        background = new JLabel("",img,JLabel.CENTER);
        background.setBounds(0, 0, 800, 600);
        this.add(background);
*/

        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("GOL/src/View/rules.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert myPicture != null;
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));

        add(picLabel);
        setVisible(true);
    }

}
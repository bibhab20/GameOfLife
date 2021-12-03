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



        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("GOL"+File.separator+"src"+File.separator+"rules.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert myPicture != null;
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));

        add(picLabel);
        setVisible(true);
    }

}
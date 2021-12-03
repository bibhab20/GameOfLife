package View;


import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


public class AboutPanel extends JPanel {

    public AboutPanel() {

        JLabel background;
        this.setSize(new Dimension(600,600));
        setLayout(null);
        ImageIcon img = new ImageIcon("rules.png");
        background = new JLabel("",img,JLabel.CENTER);
        background.setBounds(0, 0, 600, 600);
        this.add(background);
        setVisible(true);

        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("GOL/src/View/rules.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert myPicture != null;
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        add(picLabel);

    }

}
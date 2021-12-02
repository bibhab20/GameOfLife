package View;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
    private JButton nextButton = new JButton("Next");
    public ControlPanel(){
        this.setBackground(Color.cyan);
        this.setPreferredSize(new Dimension(600,50));
        this.add(this.nextButton);

    }

    public void addActionListener(ActionListener actionListener){
        this.nextButton.addActionListener(actionListener);
    }
}

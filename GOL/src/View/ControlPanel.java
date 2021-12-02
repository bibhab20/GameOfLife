package View;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
    private final JButton nextButton = new JButton("Next");
    private final JButton startButton = new JButton("Start");
    private final JButton stopButton = new JButton("Stop");
    public ControlPanel(){
        this.setBackground(Color.cyan);
        this.setPreferredSize(new Dimension(600,50));
        this.add(this.nextButton);
        this.add(this.startButton);
        this.add(this.stopButton);

    }

    public void addActionListener(ActionListener actionListener){
        this.nextButton.addActionListener(actionListener);
        this.startButton.addActionListener(actionListener);
        this.stopButton.addActionListener(actionListener);
    }
}

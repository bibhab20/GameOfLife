package View;


import Model.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class ControlPanel extends JPanel implements Observer {
    private final JButton nextButton = new JButton("Next");
    private final JButton startButton = new JButton("Start");
    private final JButton stopButton = new JButton("Stop");
    private final JLabel generationLabel = new JLabel("");
    private final JButton resetButton = new JButton("Reset");
    private final JButton zoomInButton = new JButton("Zoom In");
    private final JButton zoomOutButton = new JButton("Zoom Out");
    public ControlPanel(){
        this.setBackground(Color.cyan);
        this.setPreferredSize(new Dimension(600,100));
        this.add(this.nextButton);
        this.add(this.startButton);
        this.add(this.stopButton);
        this.add(this.resetButton);
        this.add(this.zoomInButton);
        this.add(this.zoomOutButton);
        this.add(new JLabel("Generation: "));
        this.add(generationLabel);
    }

    public void addActionListener(ActionListener actionListener){
        this.nextButton.addActionListener(actionListener);
        this.startButton.addActionListener(actionListener);
        this.stopButton.addActionListener(actionListener);
        this.resetButton.addActionListener(actionListener);
        this.zoomInButton.addActionListener(actionListener);
        this.zoomOutButton.addActionListener(actionListener);
    }

    @Override
    public void update(Observable o, Object arg) {
        generationLabel.setText(String.valueOf(((Game)o).getGeneration()));
    }
}

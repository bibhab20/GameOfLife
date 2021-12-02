package View;

import Controller.Controller;
import Model.Game;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main(){

    }
    public static void main(String[] args) {

        Main main = new Main();
        main.createGUI();
    }

    public void createGUI(){
        this.setSize(new Dimension(600,800));
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridPanel gridPanel = new GridPanel();
        AboutPanel aboutPanel = new AboutPanel();
        JTabbedPane tabbedPane = new JTabbedPane();
        ControlPanel controlPanel = new ControlPanel();
        Game game = new Game(5,5);

        tabbedPane.add("Grid", gridPanel);
        tabbedPane.add("About", aboutPanel);
        this.add(tabbedPane, BorderLayout.CENTER);
        this.add(controlPanel, BorderLayout.SOUTH);
        this.setVisible(true);
        game.addObserver(gridPanel);
        game.flip(1,3);
        Controller controller = new Controller(gridPanel,game);
        controlPanel.addActionListener(controller);
        gridPanel.addMouseListener(controller.getMouseListener());

    }
}

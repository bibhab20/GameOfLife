package Controller;

import Model.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller implements ActionListener {
    JPanel panel;
    Game game;
    MouseListener mouseListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int panelHeight = panel.getHeight();
            int panelWidth = panel.getWidth();

            int x = e.getX();
            int y = e.getY();

            int rows = game.getGrid().size();
            int cols = game.getGrid().get(0).size();

            int row = x*rows/panelWidth;
            int col = y*cols/panelWidth;

            game.flip(row,col);
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    };

    public Controller(JPanel mousePanel, Game game){
        this.panel = mousePanel;
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Next")){
            System.out.println("inside controller next button action");
            this.game.simulateNextGeneration();
        }
    }

    public MouseListener getMouseListener(){
        return this.mouseListener;
    }
}
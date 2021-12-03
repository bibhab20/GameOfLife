package Controller;

import Model.Game;
import View.GridPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller implements ActionListener {
    GridPanel panel;
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

            int row = y*rows/panelWidth;
            int col = x*cols/panelHeight;
            int[] location = panel.getRowCol(x,y);
            game.flip(location[0],location[1]);
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

    public Controller(GridPanel mousePanel, Game game){
        this.panel = mousePanel;
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Next")){
            System.out.println("inside controller next button action");
            this.game.simulateNextGeneration();
        }
        if(e.getActionCommand().equals("Start")){
            try {
                this.game.start();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }

        if (e.getActionCommand().equals("Stop")){
            this.game.stop();
        }

        if(e.getActionCommand().equals("Reset")){
            this.game.reset();
        }
        if(e.getActionCommand().equals("Zoom In")){
            this.panel.zoomIn();
        }
        if(e.getActionCommand().equals("Zoom Out")){
            this.panel.zoomOut();
        }
    }

    public MouseListener getMouseListener(){
        return this.mouseListener;
    }
}
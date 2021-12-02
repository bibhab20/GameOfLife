package View;

import Model.Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class GridPanel extends JPanel implements Observer {
    private List<List<Boolean>> grid;


    public GridPanel(){
        this.setSize(new Dimension(600,600));
        this.setBackground(Color.blue);
        grid = new ArrayList<>();


    }
    @Override
    public void update(Observable o, Object arg) {
        Game game = (Game) o;
        this.grid = game.getGrid();
        repaint();;

    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.yellow);
        if(this.grid.size() == 0)
            return;
        int rows = this.grid.size();
        int cols = this.grid.get(0).size();
        int length = Math.min(this.getHeight(), this.getWidth());
        int height = length/rows;
        int width = length/cols;
        for (int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid.get(i).get(j)){
                    g.setColor(Color.yellow);
                }
                else{
                    g.setColor(Color.green);
                }

                g.fillRect(i*width,j*height,width,height);
                g.setColor(Color.gray);
                g.drawRect(i*width,j*height,width,height);
            }
        }
    }
}

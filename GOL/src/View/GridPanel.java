package View;

import Model.Game;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class GridPanel extends JPanel implements Observer {
    private List<List<Boolean>> grid;
    private int noOfRowsDisplayed;
    private int zoomFactor;
    private static final int MIN_ROW_SIZE = 2;

    public GridPanel(){
        this.setSize(new Dimension(800,600));
        this.setBackground(Color.gray);
        grid = new ArrayList<>();
        this.noOfRowsDisplayed =2;
        this.zoomFactor =100;
    }



    public void zoomIn(){
        this.zoomFactor +=10;
        this.zoomFactor = Math.min(500, zoomFactor);
        repaint();
    }

    public void zoomOut(){
        this.zoomFactor = Math.max(100,this.zoomFactor-10);
        repaint();
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
        /*int rows = this.grid.size();
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
        }*/
        Map<Point, Boolean> rectangles = getRectangles();
        int side = this.getSquareSize();
        System.out.println("side: "+side);
       for(Point point : rectangles.keySet()){
            if(rectangles.get(point)){
                g.setColor(Color.yellow);
            }
            else
                g.setColor(Color.gray);
            g.fillRect(point.x, point.y,side, side);
            g.setColor(Color.black);
            g.drawRect(point.x, point.y,side, side);
        }
    }

    private Map<Point, Boolean> getRectangles(){
        int noOfRows = this.grid.size();
        int noOfCols = this.grid.get(0).size();
        int nr =  noOfRows*100/zoomFactor;
        nr = Math.min(noOfRows, nr);
        nr = Math.max(MIN_ROW_SIZE,nr);
        int nc = this.getWidth()*nr/this.getHeight();
        int rowIndex = (noOfRows -nr)/2;
        int colStart = (noOfCols-nc)/2;
        int colIndex = colStart;
        System.out.println("zoom factor "+zoomFactor);
        System.out.println("nr "+nr+" nc "+nc);
        int side = this.getSquareSize();
        Map<Point, Boolean> map = new HashMap<>();
        for(int i=0; i<nr; i++){
            colIndex = colStart;
            for(int j=0; j<nc; j++){
                map.put(new Point(j*side,i*side),this.grid.get(rowIndex).get(colIndex));

                colIndex++;
            }
            rowIndex++;
        }
        System.out.println(map.size());
        return map;

    }

    private int getSquareSize(){
        int nr=  this.grid.size()*100/zoomFactor;
        return this.getHeight()/nr;
    }

    public int[] getRowCol(int x, int y){
        int noOfRows = this.grid.size();
        int noOfCols = this.grid.get(0).size();
        int nr =  noOfRows*100/zoomFactor;
        nr = Math.min(noOfRows, nr);
        nr = Math.max(MIN_ROW_SIZE,nr);
        int nc = this.getWidth()*nr/this.getHeight();
        int rowStart = (noOfRows -nr)/2;
        int colStart = (noOfCols-nc)/2;
        int[] ans = new int[2];
        int side = this.getSquareSize();
        ans[0] = rowStart + y/side;
        ans[1] = colStart + x/side;
        ans[0] = Math.min(ans[0],noOfRows);
        ans[1] = Math.min(ans[1],noOfCols);
        return ans;
    }
}

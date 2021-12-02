package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.TimeUnit;

public class Game extends Observable {
    private List<List<Boolean>> grid;
    private GameState state;
    Thread runningThread;
    private static final int LIMIT = 100;

    public Game(int noOfRows, int noOfCols){
        grid = new ArrayList<>();
        this.state = GameState.IDLE;
        for(int i=0; i<noOfRows; i++){
            List<Boolean> row = new ArrayList<>();
            for(int j=0; j<noOfCols; j++){
                row.add(false);
            }
            this.grid.add(row);
        }


    }

    public void flip(int row, int col){
        if(state==GameState.RUNNING)
            return;
        this.grid.get(row).set(col, !this.grid.get(row).get(col));
        setChanged();
        notifyObservers();
    }

    public void start() throws InterruptedException {
        System.out.println("inside start");
        runningThread = new Thread(new Runnable() {
            @Override
            public void run() {
                state = GameState.RUNNING;
                int count =0;
                while(state == GameState.RUNNING && count<LIMIT){
                    System.out.println("inside while loop");
                    simulateNextGeneration();
                    count++;
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        runningThread.start();



    }

    public void stop(){
        this.state = GameState.IDLE;
        runningThread.stop();
    }

    public void simulateNextGeneration(){
        int rows = this.grid.size();
        int cols = this.grid.get(0).size();
        System.out.println("inside game simulateGeneration method");
        List<List<Boolean>> newGrid = new ArrayList<>();
        for(int i=0; i<rows; i++){
            List<Boolean> row = new ArrayList<>();
            for (int j=0; j<cols; j++){
                int aliveNeighbors = countLiveNeighbors(i,j);
                Boolean state = this.grid.get(i).get(j);
                if(!state && aliveNeighbors>2)
                    state = Boolean.TRUE;
                else{
                    if(aliveNeighbors<2 || aliveNeighbors>3){
                        state = false;
                    }
                }
                row.add(state);
            }
            newGrid.add(row);
        }
        this.grid = newGrid;
        setChanged();notifyObservers();


    }

    public void scaleUp(){

    }

    private int countLiveNeighbors(int row, int col){
        int[][] directions = new int[][]{{1,-1},{1,0},{1,-1},{-1,-1},{-1,0},{-1,1},{0,-1},{0,1}};
        int count = 0;
        int rows = this.grid.size();
        int cols = this.grid.get(0).size();
        for(int[] dir: directions){
            int x = row+dir[0];
            int y = row+dir[1];
            if(x>=0 && y>=0 && x<rows && y<cols && grid.get(x).get(y)){
                count++;
            }
        }
        System.out.println(count);
        return count;
    }

    public List<List<Boolean>> getGrid(){
        return this.grid;
    }


}

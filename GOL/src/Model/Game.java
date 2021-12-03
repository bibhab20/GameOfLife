package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.TimeUnit;

public class Game extends Observable {
    private List<List<Boolean>> grid;
    private GameState state;
    private int[] size;
    private int generation;
    Thread runningThread;
    private static final int LIMIT = 100;

    public Game(int noOfRows, int noOfCols){
        grid = new ArrayList<>();
        this.state = GameState.IDLE;
        this.size = new int[2];
        this.size[0] = noOfRows;
        this.size[1] = noOfCols;
        reset();


    }


    public void flip(int row, int col){
        if(state==GameState.RUNNING)
            return;
        this.grid.get(row).set(col, !this.grid.get(row).get(col));
        setChanged();
        notifyObservers();
    }

    public void start() throws InterruptedException {
        runningThread = new Thread(new Runnable() {
            @Override
            public void run() {
                state = GameState.RUNNING;
                int count =0;
                while(state == GameState.RUNNING && count<LIMIT){
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
        if(this.state==GameState.IDLE)
            return;
        this.state = GameState.IDLE;
        runningThread.stop();
    }

    public void simulateNextGeneration(){
        generation++;
        int rows = this.grid.size();
        int cols = this.grid.get(0).size();
        List<List<Boolean>> newGrid = new ArrayList<>();
        for(int i=0; i<rows; i++){
            List<Boolean> row = new ArrayList<>();
            for (int j=0; j<cols; j++){
                int aliveNeighbors = countLiveNeighbors(i,j);
                boolean state = this.grid.get(i).get(j);
                if(!state && aliveNeighbors>2) {
                    state = Boolean.TRUE;
                }
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
        int[][] directions = new int[][]{{1,-1},{1,0},{1,1},{-1,-1},{-1,0},{-1,1},{0,-1},{0,1}};
        int count = 0;
        int rows = this.grid.size();
        int cols = this.grid.get(0).size();
        for(int[] dir: directions){
            int x = row+dir[0];
            int y = col+dir[1];
            if(x>=0 && y>=0 && x<rows && y<cols && grid.get(x).get(y)){
                count++;
            }
        }
        //System.out.println(count);
        return count;
    }

    public List<List<Boolean>> getGrid(){
        return this.grid;
    }

    public int getGeneration(){
        return this.generation;
    }

    public void reset(){
        this.generation =0;
        this.grid = new ArrayList<>();
        for(int i=0; i<this.size[0]; i++){
            List<Boolean> row = new ArrayList<>();
            for(int j=0; j<this.size[1]; j++){
                row.add(false);
            }
            this.grid.add(row);
        }

        setChanged();
        notifyObservers();
    }


}

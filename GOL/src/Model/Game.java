package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Game extends Observable {
    private List<List<Boolean>> board;
    private GameState state;

    public Game(int noOfRows, int noOfCols){
        board = new ArrayList<>();

    }

    public void flip(int row, int col){

    }

    public void start(){

    }

    public void stop(){

    }

    public void simulateNextGeneration(){

    }

    public void scaleUp(){

    }


}

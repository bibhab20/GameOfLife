package View;



import javax.swing.*;


public class AboutPanel extends JPanel {

    public AboutPanel() {



        JLabel label = new JLabel("<html><yourTagHere><yourOtherTagHere>The universe of the Game of Life is an infinite, two-dimensional orthogonal grid of square cells, "
                + "<br>each of which is in one of two possible states, live or dead, (or populated and unpopulated, respectively).<br> Every cell interacts with its eight neighbours, which are the cells that are horizontally, vertically, or diagonally adjacent. At each step in time, the following transitions occur:" +
                "\n" +
                " <br> <br> 1) Any live cell with fewer than two live neighbours dies, as if by underpopulation.\n" +
                " <br>2) Any live cell with two or three live neighbours lives on to the next generation.\n" +
                " <br>3) Any live cell with more than three live neighbours dies, as if by overpopulation.\n" +
                " <br>4) Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.\n" +
                " <br> <br>These rules, which compare the behavior of the automaton to real life, can be condensed into the following:\n" +
                "\n" +
                " <br>1) Any live cell with two or three live neighbours survives.\n" +
                " <br>2) Any dead cell with three live neighbours becomes a live cell.\n" +
                " <br>3) All other live cells die in the next generation. Similarly, all other dead cells stay dead.\n" +
                " <br><br>The initial pattern constitutes the seed of the system.The first generation is created by applying the above rules simultaneously to every cell in the seed, live or dead"
                + "<br> births and deaths occur simultaneously, and the discrete moment at which this happens is sometimes called a tick Each generation is a pure function of the preceding one."
                + "<br> The rules continue to be applied repeatedly to create further generations.</yourOtherTagHere></yourTagHere></html>");
        label.setText(label.getText()+"something");
        this.add(label);
        setVisible(true);




    }

}
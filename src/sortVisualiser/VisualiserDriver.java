package sortVisualiser;

import javax.swing.*;

public class VisualiserDriver {

    private final JFrame frame;
    private final SVPanel svPanel;

    public static int WINDOW_X = 1200;
    public static int WINDOW_Y = 800;

    public static void main(String[] args){
        VisualiserDriver vd = new VisualiserDriver();
        vd.run();
    }

    public VisualiserDriver(){
        frame = new JFrame("Sort Visualiser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500,800);


        svPanel = new SVPanel();
        frame.add(svPanel);
        frame.setVisible(true);

    }

    public void run(){
        InsertionSort iSort = new InsertionSort();
        iSort.sort(svPanel);
        svPanel.arrayRandom();
        iSort.sort(svPanel);
    }

}

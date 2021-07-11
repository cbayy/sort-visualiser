package sortVisualiser;

import javax.swing.*;

public class visualiserDriver {

    JFrame frame;
    SVPanel svPanel;

    public static int WINDOW_X = 1200;
    public static int WINDOW_Y = 800;

    public static void main(String[] args){
        visualiserDriver vd = new visualiserDriver();
    }

    public visualiserDriver(){
        frame = new JFrame("Sort Visualiser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200,800);
        frame.setVisible(true);

        svPanel = new SVPanel();
        frame.add(svPanel);
        frame.repaint();
    }
}

package sortVisualiser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VisualiserDriver extends Thread {

    static VisualiserDriver vd;
    private final JFrame frame;
    private final SVPanel svPanel;
    private final JPanel conPanel;

    //The control buttons(left of screen) start each sorting algorithm
    static JButton btnMergeSort;
    static JButton btnQuickSort;
    static JButton btnInsertionSort;

    //Text which appears about the current sort
    private JLabel runTimeLabel;

    public static int WINDOW_X = 1200;
    public static int WINDOW_Y = 800;

    //Current three types of sorts


    public static void main(String[] args){
        vd = new VisualiserDriver();
    }

    //Sets up the frame
    public VisualiserDriver(){
        //Sets basic frame information
        frame = new JFrame("Sort Visualiser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500,800);
        frame.setLayout(new BorderLayout());

        svPanel = new SVPanel();
        conPanel = new ControlPanel(svPanel);

        frame.add(svPanel, BorderLayout.CENTER);
        frame.add(conPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}

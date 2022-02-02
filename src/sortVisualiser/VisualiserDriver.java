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
    private SortType currentSort;

    public static int WINDOW_X = 1200;
    public static int WINDOW_Y = 800;

    //Current three types of sorts
    public enum SortType{MS, QS, IS}

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
        conPanel = new JPanel();
        setUpConPanel();

        frame.add(svPanel, BorderLayout.CENTER);
        frame.add(conPanel, BorderLayout.EAST);
        frame.setVisible(true);
    }

    //Sets up the control panel located on the right
    public void setUpConPanel(){
        btnMergeSort = new JButton("Merge Sort");
        btnQuickSort = new JButton("Quick Sort");
        btnInsertionSort = new JButton("Insertion Sort");

        btnQuickSort.addActionListener(this::actionPerformed);
        btnMergeSort.addActionListener(this::actionPerformed);
        btnInsertionSort.addActionListener(this::actionPerformed);

        conPanel.setLayout(new BoxLayout(conPanel, BoxLayout.PAGE_AXIS));

        runTimeLabel = new JLabel("Time elapsed: ");

        conPanel.add(btnMergeSort);
        conPanel.add(btnQuickSort);
        conPanel.add(btnInsertionSort);
    }

    // Handles request when any of the control buttons are pressed
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == btnMergeSort) {
            currentSort = SortType.MS;
        }
        if(e.getSource() == btnQuickSort) {
            currentSort = SortType.QS;
        }
        if(e.getSource() == btnInsertionSort) {
            currentSort = SortType.IS;
        }

        SortThread t = new SortThread(currentSort, svPanel);
        System.out.println("Start");
        new Thread(t).start();
    }

    //Deactivates buttons during sort/ reactivate afterwards
    public static void activateButtons(Boolean active){
        btnMergeSort.setEnabled(active);
        btnQuickSort.setEnabled(active);
        btnInsertionSort.setEnabled(active);
    }
}

package sortVisualiser;

import javax.swing.*;
import javax.sound.midi.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VisualiserDriver extends Thread {

    private final JFrame frame;
    private final SVPanel svPanel;
    private final JPanel conPanel;

    static JButton btnMergeSort;
    static JButton btnQuickSort;
    static JButton btnInsertionSort;

    private JLabel runTimeLabel;
    private SortType currentSort;
    static VisualiserDriver vd;

    public static int WINDOW_X = 1200;
    public static int WINDOW_Y = 800;

    public enum SortType{MS, QS, IS}

    public static void main(String[] args){
        vd = new VisualiserDriver();
    }

    public VisualiserDriver(){
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

    public static void activateButtons(Boolean active){
        btnMergeSort.setEnabled(active);
        btnQuickSort.setEnabled(active);
        btnInsertionSort.setEnabled(active);
    }

}

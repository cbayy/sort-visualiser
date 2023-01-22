package sortVisualiser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class ControlPanel extends JPanel {

    public enum SortType{Merge_sort, Quicksort, Insertion_sort}

    private SortType currentSort;

    private static ArrayList<JButton> buttons = new ArrayList<>();

    SVPanel svPanel;
    ControlPanel(SVPanel svPanel){
        this.svPanel = svPanel;
        this.setLayout(new GridLayout(1,3));
        Arrays.asList(SortType.values())
                .forEach(sort -> addButton(sort));
    }

    private void addButton(SortType sort){
        JButton button = new JButton(sort.toString());
        button.addActionListener(this::actionPerformed);
        buttons.add(button);
        this.add(button);
    }

    public static void activateButtons(Boolean active){
        buttons.forEach(button -> button.setEnabled(active));
    }

    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        JButton pressed  = null;
        String pressedText = "";

        if(o instanceof JButton) pressed = (JButton)o;
        if(pressed != null){
            pressedText = pressed.getText();

            switch (pressedText){
                case "Merge_sort":
                    currentSort = SortType.Merge_sort;
                    break;
                case "Quicksort":
                    currentSort = SortType.Quicksort;
                    break;
                case "Insertion_sort":
                    currentSort = SortType.Insertion_sort;
                    break;
            }

        }

        SortThread t = new SortThread(currentSort, svPanel);
        new Thread(t).start();
    }



}

package sortVisualiser;

import javax.naming.ldap.Control;

//Sort thread runs whenever a new sort is started, to prevent the GUI from freezing while the algorithm runs
public class SortThread implements Runnable{

    private ControlPanel.SortType currentSort;
    private SVPanel svPanel;

    //Will return the time taken after thread ends
    public long elapsedTime;

    public SortThread(ControlPanel.SortType currentSort, SVPanel svPanel) {
        this.currentSort = currentSort;
        this.svPanel = svPanel;
    }

    public void run(){
        //Randomises the array before a new sort is ran
        svPanel.arrayRandom();

        //Prepares GUI for sort
        svPanel.setElapsedTime("N/A");
        ControlPanel.activateButtons(false);

        //Runs a specific sort depending on currentSort(button pressed)
        long startTime = System.nanoTime();
        switch (currentSort) {
            case Quicksort:
                QuickSort qSort = new QuickSort();
                qSort.sort(svPanel);
                break;
            case Merge_sort:
                MergeSort mSort = new MergeSort();
                mSort.sort(svPanel);
                break;
            case Insertion_sort:
                InsertionSort iSort = new InsertionSort();
                iSort.sort(svPanel);
                break;
        }
        //Calculates and returns time
        elapsedTime = System.nanoTime() - startTime;
        svPanel.setElapsedTime(String.valueOf(elapsedTime/1000000000));
        ControlPanel.activateButtons(true);
    }
}

package sortVisualiser;

//Sort thread runs whenever a new sort is started, to prevent the GUI from freezing while the algorithm runs
public class SortThread implements Runnable{

    private VisualiserDriver.SortType currentSort;
    private SVPanel svPanel;

    //Will return the time taken after thread ends
    public long elapsedTime;

    public SortThread(VisualiserDriver.SortType currentSort, SVPanel svPanel) {
        this.currentSort = currentSort;
        this.svPanel = svPanel;
    }

    public void run(){
        //Randomises the array before a new sort is ran
        svPanel.arrayRandom();

        //Prepares GUI for sort
        svPanel.setElapsedTime("N/A");
        VisualiserDriver.activateButtons(false);

        //Runs a specific sort depending on currentSort(button pressed)
        long startTime = System.nanoTime();
        switch (currentSort) {
            case QS:
                QuickSort qSort = new QuickSort();
                qSort.sort(svPanel);
                break;
            case MS:
                MergeSort mSort = new MergeSort();
                mSort.sort(svPanel);
                break;
            case IS:
                InsertionSort iSort = new InsertionSort();
                iSort.sort(svPanel);
                break;
        }
        //Calculates and returns time
        elapsedTime = System.nanoTime() - startTime;
        svPanel.setElapsedTime(String.valueOf(elapsedTime/1000000000));
        VisualiserDriver.activateButtons(true);
    }
}

package sortVisualiser;

public class QuickSort {

    SVPanel sv;

    public void sort(SVPanel sv) {
        sv.setSortString("Quicksort");
        this.sv = sv;
        quickSort(0, sv.getLength()-1);
    }

    void quickSort(int left, int right){
        if(left > right){
            return;
        }
        int pivot = partition(left, right);
        quickSort(left, pivot-1);
        quickSort(pivot+1, right);
    }

    int partition(int lowIndex, int highIndex){

        int pivotValue = sv.get(highIndex);
        int i = lowIndex - 1;
        for (int j = lowIndex; j <= highIndex - 1; j++) {
            if (sv.get(j) <= pivotValue) {
                i++;
                swap(i, j, 30);
            }
        }
        swap(i + 1, highIndex, 30);
        return i + 1;
    }

    public void swap(int firstIndex, int secondIndex, long milliSecDelay) {
        int temp = sv.get(firstIndex);
        sv.set(firstIndex, sv.get(secondIndex));
        sv.set(secondIndex, temp);

        sv.update(firstIndex, sv.get(firstIndex));
        sv.update(secondIndex, sv.get(secondIndex));
    }



}

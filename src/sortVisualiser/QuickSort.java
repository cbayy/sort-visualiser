package sortVisualiser;

public class QuickSort {

    SVPanel sv;

    public void sort(SVPanel sv) {
        this.sv = sv;
    }

    void quickSort(int left, int right){
        if(left > right){
            return;
        }
        int pivot = partition(left, right);
        quickSort(left, pivot);
        quickSort(pivot+1, right);
    }

    int partition(int left, int right){
        int pivot = sv.get(right);
        //Add parition code below

        return pivot;
    }

}

package sortVisualiser;

public class InsertionSort {

    public void sort(int[] arr){
        int i = 1;
        while(i < arr.length){
            int j = i;
            while (j > 0 && arr[j-1] > arr[j]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
            i++;
        }
    }
}

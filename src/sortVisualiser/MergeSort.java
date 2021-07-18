package sortVisualiser;

public class MergeSort {
    public void sort(SVPanel sv) {
        sv.setSortString("Merge Sort");
        mergeSort(sv, 0 , sv.getLength()-1 );
    }

    void mergeSort(SVPanel sv, int left, int right){
        if(right <= left){
            return;
        }
        int middle = left + (right-left)/2;
        mergeSort(sv, left, middle);
        mergeSort(sv, middle+1, right);
        merge(sv, left, right, middle);
    }

    void merge(SVPanel sv, int left, int right, int middle){
        int leftPartition[] = new int[middle-left+1];
        int rightPartition[] = new int[right-middle];

        for (int i = 0; i < leftPartition.length; i++) {
            leftPartition[i] = sv.get(left + i);
        }

        for (int i = 0; i < rightPartition.length; i++){
            rightPartition[i] = sv.get(middle+1+i);
        }

        int i = 0;
        int j = 0;
        int target = left;
        while (i < leftPartition.length && j < rightPartition.length) {
            if (leftPartition[i] < rightPartition[j]) {
                sv.update(target++, leftPartition[i++]);
            }
            else {
                sv.update(target++, rightPartition[j++]);
            }
        }

        while (i < leftPartition.length) {
            sv.update(target++, leftPartition[i++]);
        }
        while (j < rightPartition.length) {
            sv.update(target++, rightPartition[j++]);
        }
    }
}

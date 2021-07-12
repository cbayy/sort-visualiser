package sortVisualiser;

public class InsertionSort {

    public void sort(SVPanel sv) {
        for (int i = 0; i < sv.getLength(); i++) {
            int curr = sv.get(i);
            int j = i - 1;
            while (j >= 0 && sv.get(j) > curr) {
                sv.update(j + 1, sv.get(j));
                j--;
            }
            sv.update(j + 1, curr);
        }

    }

}

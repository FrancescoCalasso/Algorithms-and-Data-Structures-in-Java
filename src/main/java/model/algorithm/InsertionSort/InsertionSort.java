package model.algorithm.InsertionSort;

public class InsertionSort {

    public void sort(int[] arr) {

        for (int i = 1; i <= arr.length - 1; i++) {

            int j = i - 1;
            int key = arr[i];

            while (j >= 0 && arr[j] > key) {

                arr[j + 1] = arr[j];
                j--;

            }

            arr[j + 1] = key;

        }

    }

}

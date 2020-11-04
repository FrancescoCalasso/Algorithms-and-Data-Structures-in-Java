package model.algorithm.InsertionSort;

/**
 * Questa classe rappresenta l'algoritmo di ordinamento Insertion sort
 */
public class InsertionSort {

    /**
     * Funzione che effettua l'ordinamento dell'array in input
     *
     * @param arr array da ordinare
     */
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

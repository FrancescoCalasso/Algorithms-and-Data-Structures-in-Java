package model.algorithm.Heapsort;

/**
 * Questa classe rappresenta l'algoritmo di ordinamento Heapsort
 */
public class HeapSort {

    /**
     * Funzione che effettua l'ordinamento dell'array in input
     *
     * @param arr array da ordinare
     */
    public void sort(int arr[]) {
        int n = arr.length;

        /* Costruisce l'heap */
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        /* Estrai uno ad uno gli elementi dall'heap */
        for (int i = n - 1; i > 0; i--) {
            /* Sposta l'attuale radice alla fine */
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            /* Esegue heapify sulla nuova radice */
            heapify(arr, i, 0);
        }
    }

    /**
     * Funzione che controlla e ripara eventuali proprietà violate del max-heap
     *
     * @param arr array che rappresenta heap
     * @param n dimensione dell'heap
     * @param i posizione su cui eseguire heapify (radice)
     */
    public void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            /* Heapify ricorsivamente il sottoalbero */
            heapify(arr, n, largest);
        }
    }
}
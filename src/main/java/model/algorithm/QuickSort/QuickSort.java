package model.algorithm.QuickSort;

/**
 * Questa classe rappresenta l'algoritmo di ordinamento Quicksort
 */
public class QuickSort {

    /**
     * Questa funzione prende l'ultimo elemento come "pivot",
     * lo posiziona nella sua posizione corretta nell'array ordinato
     * e posiziona tutti gli elementi più piccoli di pivot alla sua sx,
     * quelli più grandi alla sua destra
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;

    }

    /**
     * Funzione che effettua l'ordinamento dell'array in input usando partition()
     *
     * @param arr array da ordinare
     * @param low posizione iniziale
     * @param high posizione finale
     */
    public void quickSort(int[] arr, int low, int high) {

        if (low < high) {
            /* pi è l'indice di partizionamento,
            ora arr[pi] è nella posizione corretta */
            int pi = partition(arr, low, high);

            /* Ordina ricorsivamente gli elementi prima dell'indice di partizionamento
               e dopo l'indice di partizionamento */
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }

    }
}
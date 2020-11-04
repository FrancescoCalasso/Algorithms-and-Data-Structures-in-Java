package model.algorithm.Mergesort;

/**
 * Questa classe rappresenta l'algoritmo di ordinamento Merge sort
 */
public class MergeSort {

    /**
     * Funzione che "fonde" due subarray:
     * - Primo subarray è arr[l..m]
     * - Secondo subarray è arr[m+1..r]
     *
     * @param arr array da ordinare
     * @param l posizione iniziale
     * @param m posizione mediana
     * @param r posizione finale
     */
    public void merge(int arr[], int l, int m, int r) {
        /* Trova le estremità dei due subarray */
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Creazione degli array temporanei */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /* Copia i dati nei temporanei */
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Fonde gli array temporanei */

        /* Indici iniziali del primo e secondo subarray */
        int i = 0, j = 0;

        /* Indice iniziale dell'array risultante dalla fusione */
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copia, se ci sono, i restanti elementi di L[] */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copia, se ci sono, i restanti elementi di R[] */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    /**
     * Funzione che effettua l'ordinamento dell'array in input usando merge()
     *
     * @param arr array da ordinare
     * @param l posizione iniziale
     * @param r posizione finale
     */
    public void mergeSort(int[] arr, int l, int r) {

        if (l < r) {

            /* Trova il punto medio */
            int m = (l + r) / 2;

            /* Ordina le prime e seconde metà */
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            /* Fondi le metà ordinate */
            merge(arr, l, m, r);

        }

    }

}
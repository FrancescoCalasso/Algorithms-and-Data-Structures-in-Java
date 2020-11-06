package model.algorithm.RicercaBinaria;

/**
 * Questa classe rappresenta l'algoritmo ricorsivo di Ricerca binaria
 */
public class RicercaBinaria {

    /**
     * Funzione che svolge la ricerca del valore "i" nell'array ordinato
     * @param arr array ordinato in maniera crescente
     * @param l posizione iniziale array
     * @param r posizione finale array
     * @param i valore da cercare
     */
    public void find(int[] arr, int l, int r, int i) {

        int m = (arr.length / 2) - 1;

        if(i == arr[m]) {

            return;

        } else if(i > arr[m]) {

            find(arr, m + 1, arr.length - 1, i);

        } else {

            find(arr, 0, m, i);

        }

    }

}
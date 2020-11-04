package model.algorithm.CountingSort;

/**
 * Questa classe rappresenta l'algoritmo di ordinamento Counting Sort
 */
public class CountingSort {

    /**
     * Funzione che effettua l'ordinamento dell'array in input
     *
     * @param arr array da ordinare
     */
    public void sort(char arr[]) {

        int n = arr.length;

        /* L'array output di caratteri che conterrà l'array arr[] ordinato */
        char output[] = new char[n];

        /* Creazione dell'array count per memorizzare il conteggio dei singoli caratteri */
        int count[] = new int[256];
        for (int i = 0; i < 256; ++i)
            count[i] = 0;

        /* Memorizza il conteggio dei singoli caratteri */
        for (int i = 0; i < n; ++i)
            ++count[arr[i]];

        /* Cambia count[i] in modo che contenga l'attuale posizione di questo carattere nell'array output */
        for (int i = 1; i <= 255; ++i)
            count[i] += count[i - 1];

        /* Costruisce l'array output
           Per renderlo stabile, stiamo operando in senso inverso */
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            --count[arr[i]];
        }

        /* Copia l'array output in arr, in modo che ora arr contenga i caratteri ordinati */
        for (int i = 0; i < n; ++i)
            arr[i] = output[i];

    }
}

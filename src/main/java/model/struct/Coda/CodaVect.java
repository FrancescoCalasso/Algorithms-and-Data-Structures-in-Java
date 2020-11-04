package model.struct.Coda;

/**
 * Questa classe rappresenta una coda mediante un vettore: inserimento solo in coda (marcata da "tail")
 * e cancellazione solo in testa (marcata da "head")
 */
public class CodaVect {

    private int head, tail;
    private int maxsize;
    private int[] coda;

    /**
     * Costruttore che inizializza una coda vuota di dimensione "max"
     *
     * @param max dimensione della coda
     */
    public CodaVect(int max) {

        head = 0;
        tail = 0;
        this.maxsize = max;
        coda = new int[max];

    }

    /**
     * Inserisce un nodo in coda
     *
     * @param numero valore del nodo da inserire
     */
    public void enqueue(int numero) {

        if (tail == maxsize) return;

        coda[tail++] = numero;

    }

    /**
     * Estrae il nodo in testa
     *
     * @return valore del nodo estratto
     */
    public int dequeue() {

        if (IsEmpty()) return 0;

        return coda[--head];

    }

    /**
     * Controlla se la coda è vuota
     *
     * @return true se la coda è vuota, false altrimenti
     */
    public boolean IsEmpty() {

        return (head == tail);

    }

}


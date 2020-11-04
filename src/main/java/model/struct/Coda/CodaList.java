package model.struct.Coda;

/**
 * Questa classe rappresenta una coda mediante una lista: inserimento solo in coda (marcata da "tail")
 * e cancellazione solo in testa (marcata da "head")
 */
public class CodaList {

    private Nodo head, tail;

    /**
     * Inserisce un nodo in coda
     *
     * @param nodo nodo da inserire
     */
    public void enqueue(Nodo nodo) {

        tail.next = nodo;

    }

    /**
     * Estrae il nodo in testa
     *
     * @return valore del nodo estratto
     */
    public Nodo dequeue() {

        Nodo temp = head;
        head = head.next;
        return temp;

    }

    /**
     * Controlla se la coda è vuota
     *
     * @return true se la coda è vuota, false altrimenti
     */
    public boolean isEmpty() {

        return head == tail;

    }

}

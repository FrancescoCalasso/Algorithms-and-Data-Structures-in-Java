package model.struct.Pila;

/**
 * Questa classe rappresenta una pila mediante una lista: inserimento e cancellazione solo in testa
 */
public class PilaList {

    private Nodo top;

    /**
     * Inserisce un nodo in testa
     *
     * @param nodo nodo da inserire
     */
    public void push(Nodo nodo) {

        nodo.next = top;
        top = nodo;

    }

    /**
     * Estrae e rimuove in nodo in testa
     *
     * @return nodo estratto
     */
    public Nodo pop() {

        Nodo temp = top;
        top = top.next;
        return temp;

    }

    /**
     * Controlla se la pila è vuota
     *
     * @return true se la pila è vuota, false altrimenti
     */
    public boolean isEmpty() {

        return top == null;

    }

}

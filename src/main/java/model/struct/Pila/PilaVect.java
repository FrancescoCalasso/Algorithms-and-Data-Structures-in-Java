package model.struct.Pila;

/**
 * Questa classe rappresenta una pila mediante un vettore: inserimento e cancellazione
 * solo in prima posizione (marcata da "top")
 */
public class PilaVect {

    private int top;
    private int maxsize;
    private int[] pila;

    /**
     * Costruttore che inizializza una pila vuota di dimensione "max"
     *
     * @param max dimensione della pila
     */
    public PilaVect(int max) {

        top = 0;
        this.maxsize = max;
        pila = new int[max];

    }

    /**
     * Inserisce un nodo in testa
     *
     * @param val valore del nodo da inserire
     */
    public void push(int val) {

        if (top == maxsize) return;

        pila[top++] = val;

    }

    /**
     * Estrae e rimuove in nodo in testa
     *
     * @return valore del nodo estratto
     */
    public int pop() {

        if (IsEmpty()) return 0;

        return pila[--top];

    }

    /**
     * Controlla se la pila è vuota
     *
     * @return true se la pila è vuota, false altrimenti
     */
    public boolean IsEmpty() {

        return (top == 0);

    }

}
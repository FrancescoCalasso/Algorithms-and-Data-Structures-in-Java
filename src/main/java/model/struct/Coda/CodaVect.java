package model.struct.Coda;

public class CodaVect {

    private int head, tail;
    private int maxsize;
    private int[] coda;

    public CodaVect(int max) {

        head = 0;
        tail = 0;
        this.maxsize = max;
        coda = new int[max];

    }

    // Aggiungi numero alla fine del vettore
    public void enqueue(int numero) {

        if (tail == maxsize) return;

        coda[tail++] = numero;

    }

    // Estrai numero all'inizio del vettore
    public int dequeue() {

        if (IsEmpty()) return 0;

        return coda[--head];

    }

    public boolean IsEmpty() {

        return (head == tail);

    }

}


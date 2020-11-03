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

    public void push(int numero) {

        if (tail == maxsize) return;

        coda[tail++] = numero;

    }

    public int pop() {

        if (IsEmpty()) return 0;

        return coda[--head];

    }

    public boolean IsEmpty() {

        return (head == tail);

    }

}


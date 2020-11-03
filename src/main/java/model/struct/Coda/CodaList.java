package model.struct.Coda;

public class CodaList {

    private Nodo head, tail;

    // Aggiungi nodo in coda alla lista
    public void enqueue(Nodo nodo) {

        tail.next = nodo;

    }

    // Estrai nodo in testa alla lista
    public Nodo dequeue() {

        Nodo temp = head;
        head = head.next;
        return temp;

    }

    public boolean isEmpty() {

        return head == tail;

    }

}

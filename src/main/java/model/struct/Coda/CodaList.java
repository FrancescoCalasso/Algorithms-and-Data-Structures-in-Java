package model.struct.Coda;

public class CodaList {

    private Nodo head, tail;

    public void push(Nodo nodo) {

        tail.next = nodo;

    }

    public Nodo pop() {

        Nodo temp = head;
        head = head.next;
        return temp;

    }

    public boolean isEmpty() {

        return head == tail;

    }

}

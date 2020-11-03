package model.struct.Pila;

public class PilaList {

    private Nodo top;

    public void push(Nodo nodo) {

        nodo.next = top;
        top = nodo;

    }

    public Nodo pop() {

        Nodo temp = top;
        top = top.next;
        return temp;

    }

    public boolean isEmpty() {

        return top == null;

    }

}

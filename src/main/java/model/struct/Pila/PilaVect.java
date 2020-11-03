package model.struct.Pila;

public class PilaVect {

    private int top;
    private int maxsize;
    private int[] pila;

    public PilaVect(int max) {

        top = 0;
        this.maxsize = max;
        pila = new int[max];

    }

    public void push(int val) {

        if (top == maxsize) return;

        pila[top++] = val;

    }

    public int pop() {

        if (IsEmpty()) return 0;

        return pila[--top];

    }

    public boolean IsEmpty() {

        return (top == 0);

    }

}
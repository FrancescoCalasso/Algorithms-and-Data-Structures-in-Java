package model.struct.Coda;

import java.util.ArrayList;

public class CodaList {

    private int head, tail;
    private ArrayList<Integer> coda = new ArrayList<>();

    public void push(int num) {

        coda.add(num);

    }

    public int pop() {

        return coda.get(++head);

    }

    public boolean isEmpty() {

        return coda.size() == 0;

    }
}

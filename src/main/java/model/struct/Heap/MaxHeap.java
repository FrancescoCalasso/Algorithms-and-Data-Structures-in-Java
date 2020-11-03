package model.struct.Heap;// Java program to implement Max Heap

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MaxHeap {

    private int[] Heap;
    private int size;
    private int maxsize;

    // Constructor to initialize an
    // empty max heap with given maximum
    // capacity.

    public MaxHeap()
    {
        Heap[0] = Integer.MAX_VALUE;
    }

    // Returns position of parent

    private int parent(int pos)
    {
        return pos / 2;
    }

    // Below two functions return left and
    // right children.

    private int leftChild(int pos)
    {
        return (2 * pos);
    }

    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }

    // Returns true of given node is leaf

    private boolean isLeaf(int pos)
    {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos)
    {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    // A recursive function to max heapify the given
    // subtree. This function assumes that the left and
    // right subtrees are already heapified, we only need
    // to fix the root.

    private void maxHeapify(int pos) {

        if (isLeaf(pos))
            return;

        int l = leftChild(pos);
        int r = rightChild(pos);
        int max;

        if (l <= size && Heap[l] > Heap[pos]) {

            max = l;

        } else {

            max = pos;

        }

        if(r <= size && Heap[r] > Heap[max]) {
            max = r;
        }

        if(max != pos) {

            swap(pos, max);
            maxHeapify(max);

        }

    }

    // Inserts a new element to max heap

    public void buildHeap(int[] array)
    {

        Heap = new int[array.length + 1];
        this.maxsize = array.length;
        Heap[0] = Integer.MAX_VALUE;

        for(int i = 1; i <= array.length; i ++) {

            Heap[i] = array[i - 1];

        }

        // Traverse up and fix violated property

        for(int i = 1; i < maxsize; i ++) {

            while (Heap[i] > Heap[parent(i)]) {
                swap(i, parent(i));
                i = parent(i);
            }
        }

    }

    public void printRelationships()
    {
        System.out.println();
        for (int i = 1; i <= size / 2; i++) {
            System.out.print("PADRE: " + Heap[i] + "FIGLIO SINISTRO: " +
                    Heap[2 * i] + "FIGLIO DESTRO: " + Heap[2 * i + 1]);
            System.out.println();
        }

        System.out.println();
        System.out.println("Rappresentazione con array: ");
        System.out.println();

        for (int i = 1; i <= size; i++) {
            System.out.println(Heap[i]);
        }

    }

    // Remove an element from max heap

    public int extractMax()
    {
        int popped = Heap[1];
        Heap[1] = Heap[size--];
        maxHeapify(1);
        return popped;
    }


    public int[] sort(int[] array) {

        buildHeap(array);

        for(int i = maxsize; i >= 2; i--) {
            swap(1, i);
            size --;
            maxHeapify(1);
        }

        printRelationships();

        return Heap;

    }

}

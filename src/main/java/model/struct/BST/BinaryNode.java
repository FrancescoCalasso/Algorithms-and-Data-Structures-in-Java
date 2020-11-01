package model.struct.BST;

import view.TreePrinter;

public class BinaryNode implements TreePrinter.PrintableNode {

    String color;
    int key;
    BinaryNode p;
    BinaryNode left;
    BinaryNode right;

    public BinaryNode(int key) {

        this.key = key;

    }

    public BinaryNode(String color, int key) {

        this.color = color;
        this.key = key;

    }


    @Override
    public BinaryNode getLeft() {

        return this.left;

    }

    @Override
    public BinaryNode getRight() {

        return this.right;

    }

    @Override
    public int getKey() {

        return this.key;

    }
}

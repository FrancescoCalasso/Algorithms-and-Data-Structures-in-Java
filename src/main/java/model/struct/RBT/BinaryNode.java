package model.struct.RBT;

import view.TreePrinter;

public class BinaryNode implements TreePrinter.PrintableNode {

    int key;
    String color;
    BinaryNode p;
    BinaryNode left;
    BinaryNode right;

    public BinaryNode(int key, String color) {

        this.key = key;
        this.color = color;

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

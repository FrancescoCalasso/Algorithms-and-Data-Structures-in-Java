package model.struct;

import model.struct.BST.BinaryNode;

public interface Struct {

    BinaryNode search(BinaryNode t);

    void insert(BinaryNode t);

    BinaryNode max(BinaryNode t);

    BinaryNode min(BinaryNode t);

    void cancella(BinaryNode t);

    BinaryNode successore(BinaryNode t);

    void free(BinaryNode t);
}

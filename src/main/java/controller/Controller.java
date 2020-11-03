package controller;

import model.struct.Grafo.Arco;
import model.struct.BST.BST;
import model.struct.BST.Nodo;
import model.struct.Grafo.Grafo;
import view.CLI;
import view.ViewInterface;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    Algorithm algorithm;
    Grafo graph;
    ViewInterface view;
    BST tree;

    public static void main(String[] argv) throws IOException {

        Controller controller = new Controller();
        CLI view = new CLI(controller);

        controller.setView(view);
        view.onStart();

    }

    public void onError(Exception e){
        view.onError(e);
    }

    public void setView(ViewInterface view) {
        this.view = view;
    }

    public int[] useAlgorithm(Algorithm algorithm, int[] array) {

        this.algorithm = algorithm;

        return algorithm.sort(array);

    }

    public void showHistory(Algorithm algorithm) throws IOException {

        algorithm.showHistory();

    }

    public Grafo createGraph() {

        Arco a = new Arco();
        graph = new Grafo();

        graph.add("a", "b", 1);
        graph.add("a", "c", 1);
        graph.add("a", "e", 3);
        graph.add("c", "d", 4);
        graph.add("c", "e", 2);
        graph.add("b", "d", 3);

        return graph;

    }

    public void removeGraphNode(Object a) {

        graph.remove(a);

    }

    public void addGraphArch(Object x, Object y, Object value) {

        graph.add(x, y, value);

    }

    public BST createBST() {

        tree = new BST();
        Nodo radice = new Nodo(4);
        tree.setRoot(radice);
        tree.put(2);
        tree.put(3);
        tree.put(6);
        tree.put(5);
        tree.put(7);


        return tree;

    }


    public void visitaBSTAmpiezza() {

        tree.traversal("BREADTH");

    }

    public void visitaBSTOrdine() {

        tree.traversal("INORDER");

    }

    public void visitaBSTPostOrdine() {

        tree.traversal("POSTORDER");

    }

    public void visitaBSTPreOrdine() {

        tree.traversal("PREORDER");

    }

    public void visitaGraphAmpiezza() {

        graph.visitaBFS("b");

    }

    public void visitaGraphProfondita() {

        graph.visitaDFS("b");

    }

    public ArrayList<Integer> getVisit() {

        return tree.getVisits();

    }

    public void showGraphHistory() throws IOException {

        graph.showHistory();


    }


}

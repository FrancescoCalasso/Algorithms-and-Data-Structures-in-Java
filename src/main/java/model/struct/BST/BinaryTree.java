package model.struct.BST;

import java.util.ArrayList;

/**
 * Questa classe rappresenta un albero binario di ricerca: ogni figlio sx
 * ha chiave minore del padre, ogni figlio dx ha chiave maggiore del padre.
 */
public class BinaryTree {

    ArrayList<Nodo> nodi;
    Nodo root;
    int size;

    /**
     * Costruttore che inizializza un albero binario di ricerca con la sola radice
     */
    public BinaryTree() {

        nodi = new ArrayList<>();
        root = new Nodo();
        root.key = 1;
        nodi.add(root);
        size = 1;

    }

    /**
     * Ricerca di un nodo
     *
     * Se la radice è uguale al nodo da cercare, restituisci radice, altrimenti:
     * - radice minore del nodo, search sul nodo destro
     * - radice maggiore del nodo, search sul nodo sinistro
     *
     * @param t nodo da cercare
     * @return nodo ricercato
     */
    public Nodo search(Nodo t) {

        if(root.key == t.key) {
            return root;
        }

        if(root.key < t.key) {
            return search(root.right);
        } else {
            return search(t.left);
        }

    }

    /**
     * Inserimento di un nodo
     *
     * Usa due nodi ausiliari, precedente (padre) e corrente (figlio) per scorrere l'albero;
     * a seconda che il nodo da inserire sia:
     * - minore del nodo corrente, scendi da sx
     * - maggiore del nodo corrente, scendi da dx
     *
     * @param t nodo da inserire
     */
    public void insert(Nodo t) {

        Nodo prev = null;
        Nodo curr = root;

        while(curr != null) {

            prev = curr;

            if(t.key < curr.key) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }

        }

        t.p = prev;

        if(prev == null) {
            root = t;
        } else if(t.key < prev.key) {
            prev.left = t;
        } else {
            prev.right = t;
        }

    }

    /**
     * Restituisce il nodo con chiave massima del sottoalbero del nodo "t". Ovviamente, il nodo più a dx.
     *
     * @param t nodo padre del sottoalbero
     * @return nodo con chiave massima
     */
    public Nodo max(Nodo t) {

        Nodo curr = t;

        while(curr != null) {

            curr = curr.right;

        }

        return curr;

    }

    /**
     * Restituisce il nodo con chiave minima del sottoalbero del nodo "t". Ovviamente, il nodo più a sx.
     *
     * @param t nodo padre del sottoalbero
     * @return nodo con chiave minima
     */
    public Nodo min(Nodo t) {

        Nodo curr = t;

        while (curr != null) {
            curr = curr.left;
        }

        return curr;

    }

    /**
     * Restituisce il nodo successore del nodo "t"
     *
     * Due possibili casi:
     * - Sottoalbero dx non vuoto, il successore è il minimo del sottoalbero dx
     * - Sottoalbero dx vuoto, il successore è il progenitore (padre, nonno,..) più vicino che contiene il nodo
     *   nel suo sottoalbero sx
     *
     * @param t nodo di cui si vuole trovare il successore
     * @return nodo successore
     */
    public Nodo successore(Nodo t) {

        if(t.right != null) {
            return min(t.right);
        }

        Nodo curr = t.p;

        while(curr != null && curr.right == t) {

            t = curr;
            curr = curr.p;

        }

        return curr;

    }

    /**
     * Cancella il nodo "t"
     *
     * Dipende dal numero di figli del nodo da cancellare:
     * - Nodo non ha figli, elimina nodo aggiornando con free()
     * - Nodo ha un figlio, elemento sosituito dal figlio nel suo ruolo nell'albero
     * - Nodo ha due figli, copio il valore del successore su di esso ed elimino il successore
     *
     * @param t nodo da cancellare
     */
    public void cancella(Nodo t) {

        Nodo del;
        Nodo prev;

        if (t.left == null || t.right == null) {
            del = t;
        } else {
            del = successore(t);
        }

        if (del.left != null) {

            prev = del.left;

        } else {

            prev = del.right;

        }

        if(prev != null) {
            prev.p = del.p;
        }

        if(del.p == null) {

            root = prev;

        } else if(del == del.p.left) {
            del.p.left = prev;
        } else {
            del.p.right = prev;
        }

        if(del != t) {
            t.key = del.key;
            free(t);
        }
    }

    /**
     * Libera il nodo dall'albero
     */
    public void free(Nodo t) {

        if(t.p.right == t) {
            t.p.right = null;
        }

        if(t.p.left == t) {
            t.p.left = null;
        }

        t.p = null;

    }

    /**
     * Visita post-ordine del nodo "node"
     *
     * @param node nodo di partenza
     */
    private void postOrdine(Nodo node) {
        if(node!=null){
            postOrdine(node.left);
            postOrdine(node.right);
            System.out.println(node.key);
        }
    }

    /**
     * Visita pre-ordine del nodo "node"
     *
     * @param node nodo di partenza
     */
    private void preOrdine(Nodo node) {
        if(node!=null){
            System.out.println(node.key);
            preOrdine(node.left);
            preOrdine(node.right);
        }

    }

    /**
     * Visita in-ordine del nodo "node"
     *
     * @param node nodo di partenza
     */
    private void inOrdine(Nodo node) {
        if(node!=null){
            inOrdine(node.left);
            System.out.println(node.key);
            inOrdine(node.right);
        }
    }

}

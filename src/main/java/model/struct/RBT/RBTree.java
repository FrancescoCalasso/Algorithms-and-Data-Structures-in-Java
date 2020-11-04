package model.struct.RBT;
import java.util.ArrayList;

/**
 * Questa classe rappresenta un albero rosso e nero:
 * 1. Ogni nodo è rosso o nero
 * 2. La radice è nera
 * 3. Le foglie sono nere
 * 4. I figli di un nodo rosso sono entrambi neri
 * 5. Per ogni nodo dell'albero, tutti i cammini dai suoi discendenti
 *    alle foglie contenute nei suoi sottoalberi hanno lo stesso numero di nodi neri
 */
public class RBTree {

    ArrayList<BinaryNode> nodi;
    BinaryNode root;
    int size;

    /**
     * Costruttore che inizializza un RBT con la sola radice nera
     */
    public RBTree() {

        nodi = new ArrayList<>();
        root.color = "black";
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
    public BinaryNode search(BinaryNode t) {

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
     * Restituisce il nodo con chiave massima del sottoalbero del nodo "t". Ovviamente, il nodo più a dx.
     *
     * @param t nodo padre del sottoalbero
     * @return nodo con chiave massima
     */
    public BinaryNode max(BinaryNode t) {

        BinaryNode curr = t;

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
    public BinaryNode min(BinaryNode t) {

        BinaryNode curr = t;

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
    public BinaryNode successore(BinaryNode t) {

        if(t.right != null) {
            return min(t.right);
        }

        BinaryNode curr = t.p;

        while(curr != null && curr.right == t) {

            t = curr;
            curr = curr.p;

        }

        return curr;

    }

    /**
     * Rotazione a sinistra sul nodo "t"
     *
     * @param t nodo su cui effettuare rotazione
     */
    public void leftRotate(BinaryNode t) {

        BinaryNode temp = t.right;
        t.right = temp.left;
        
        if(temp.left != null) {
            temp.left.p = t;
        }

        t.p = temp.p;

        if(t.p == null) {

            root = temp;

        } else if(t == t.p.left) {

            t.p.left = temp;

        } else {

            t.p.right = temp;

        }

        temp.left = t;
        t.p = temp;

    }

    /**
     * Rotazione a destra sul nodo "t"
     *
     * @param t nodo su cui effettuare rotazione
     */
    public void rightRotate(BinaryNode t) {

        BinaryNode temp = t.left;
        t.left = temp.right;

        if(temp.right != null) {
            temp.right.p = t;
        }

        t.p = temp.p;

        if(t.p == null) {

            root = temp;

        } else if(t == t.p.right) {

            t.p.right = temp;

        } else {

            t.p.left = temp;

        }

        temp.right = t;
        t.p = temp;

    }

    /**
     * Inserimento di un nodo
     *
     * Usa due nodi ausiliari, precedente (padre) e corrente (figlio) per scorrere l'albero;
     * a seconda che il nodo da inserire sia:
     * - minore del nodo corrente, scendi da sx
     * - maggiore del nodo corrente, scendi da dx
     *
     * A differenza di BST, in seguito a possibili proprietà violate, invoca la riparazione
     *
     * @param t nodo da inserire
     */
    public void insert(BinaryNode t) {

        BinaryNode prev = null;
        BinaryNode curr = root;

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

        riparaRBInserisci(t);

    }

    /**
     * Ripara possibili proprietà violate in seguito a un inserimento,
     * partendo dal nodo inserito
     *
     * @param z nodo inserito e da cui parte la riparazione
     */
    public void riparaRBInserisci(BinaryNode z) {

        while(z.p.color.equals("red")) {
            if(z.p == z.p.left) {
                BinaryNode y = z.p.p.right;
                if(y.color.equals("red")) {  /* CASO 1 */
                    z.p.color = "black";
                    y.color = "black";
                    z.p.p.color = "red";
                    z = z.p.p;
                } else if(z == z.p.right) {  /* CASO 2, ruotare z */
                    z = z.p;
                    leftRotate(z);
                } else {

                    z.p.color = "black";    /* CASO 3 */
                    z.p.p.color = "red";

                    rightRotate(z.p.p);

                }

            } else {

                BinaryNode y = z.p.p.left;
                if(y.color.equals("red")) {  /* CASO 1 */
                    z.p.color = "black";
                    y.color = "black";
                    z.p.p.color = "red";
                    z = z.p.p;
                } else if(z == z.p.left) {  /* CASO 2, ruotare z */
                    z = z.p;
                    leftRotate(z);
                } else {

                    z.p.color = "black";    /* CASO 3 */
                    z.p.p.color = "red";

                    leftRotate(z.p.p);

                }

            }
        }

        root.color = "black";

    }

    /**
     * Cancella il nodo "t"
     *
     * Dipende dal numero di figli del nodo da cancellare:
     * - Nodo non ha figli, elimina nodo aggiornando con free()
     * - Nodo ha un figlio, elemento sosituito dal figlio nel suo ruolo nell'albero
     * - Nodo ha due figli, copio il valore del successore su di esso ed elimino il successore
     *
     * A differenza di BST, in seguito a possibili proprietà violate, invoca la riparazione
     *
     * @param t nodo da cancellare
     */
    public void cancella(BinaryNode t) {

        BinaryNode del;
        BinaryNode prev;

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
            free(del);
        }

        riparaRBCancella(t);

    }

    /**
     * Ripara possibili proprietà violate in seguito a una cancellazione,
     * partendo dal nodo che ha sostituito il nodo cancellato
     *
     * @param t nodo sostituto e da cui parte la riparazione
     */
    public void riparaRBCancella(BinaryNode t) {

        if(t.color.equals("red")) {
            t.color = "black";
        }

        if(t.color.equals("black") && t.p.right.color.equals("red")) {

            t.p.right.color = "black";
            t.p.color = "red";
            leftRotate(t.p);

        }

    }

    /**
     * Libera il nodo dall'albero
     */
    public void free(BinaryNode t) {

        if(t.p.right == t) {
            t.p.right = null;
        }

        if(t.p.left == t) {
            t.p.left = null;
        }

        t.p = null;

    }
}

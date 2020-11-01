package model.struct;

import java.util.ArrayList;

public class RBTree implements Struct{

    ArrayList<BinaryNode> nodi;
    BinaryNode root;
    int size;

    public RBTree() {

        nodi = new ArrayList<>();
        //root = new BinaryNode("black");
        root.key = 1;
        nodi.add(root);
        size = 1;

    }

    /*
    RICERCA: Se la radice è uguale al nodo da cercare, restituisci radice, altrimenti:
    - radice minore del nodo, search sul nodo destro
    - radice maggiore del nodo, search sul nodo sinistro
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

    /*
    MAX: Restituisce il nodo con chiave massima dell'albero. Ovviamente, il nodo più a dx.
     */
    public BinaryNode max(BinaryNode t) {

        BinaryNode curr = t;

        while(curr != null) {

            curr = curr.right;

        }

        return curr;

    }

    /*
    MIN: Restituisce il nodo con chiave minima dell'albero. Ovviamente, il nodo più a sx.
     */
    public BinaryNode min(BinaryNode t) {

        BinaryNode curr = t;

        while (curr != null) {
            curr = curr.left;
        }

        return curr;

    }

    /*
    SUCCESSORE: Due possibili casi:
    - Sottoalbero dx non vuoto, il successore è il minimo del sottoalbero dx
    - Sottoalbero dx vuoto, il successore è il progenitore (padre, nonno,..) più vicino che contiene il nodo
      nel suo sottoalbero sx
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

    /*
    LEFTROTATE:
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

    /*
    LEFTROTATE:
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

    /*
    INSERISCI: Usa due nodi ausiliari, precedente (padre) e corrente (figlio) per scorrere l'albero; a seconda che il
    nodo da inserire sia:
    - minore del nodo corrente, scendi da sx
    - maggiore del nodo corrente, scendi da dx
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

    public void riparaRBInserisci(BinaryNode z) {

        while(z.p.color.equals("red")) {
            if(z.p == z.p.left) {
                BinaryNode y = z.p.p.right;
                if(y.color.equals("red")) {  //CASO 1
                    z.p.color = "black";
                    y.color = "black";
                    z.p.p.color = "red";
                    z = z.p.p;
                } else if(z == z.p.right) {  //CASO 2, ruotare z
                    z = z.p;
                    leftRotate(z);
                } else {

                    z.p.color = "black";
                    z.p.p.color = "red";

                    rightRotate(z.p.p);

                }

            } else {

                BinaryNode y = z.p.p.left;
                if(y.color.equals("red")) {  //CASO 1
                    z.p.color = "black";
                    y.color = "black";
                    z.p.p.color = "red";
                    z = z.p.p;
                } else if(z == z.p.left) {  //CASO 2
                    z = z.p;
                    leftRotate(z);
                } else {

                    z.p.color = "black";
                    z.p.p.color = "red";

                    leftRotate(z.p.p);

                }

            }
        }

        root.color = "black";

    }

    /*
    CANCELLA: Dipende dal numero di figli del nodo da cancellare:
    - f.Nodo non ha figli, elimina nodo aggiornando con free()
    - f.Nodo ha un figlio, elemento sosituito dal figlio nel suo ruolo nell'albero
    - f.Nodo ha due figli, copio il valore del successore su di esso ed elimino il successore
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
            free(t);
        }
    }

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

    /*
    FREE: Libera il nodo dalla lista
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

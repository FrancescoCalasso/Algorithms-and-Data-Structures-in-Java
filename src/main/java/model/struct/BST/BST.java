package model.struct.BST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Implementa l'interfaccia BST
 *
 */
public class BST {

    private BinaryNode root;
    private ArrayList<Integer> visits;

    public BST() {

        visits = new ArrayList<>();

    }

    /**
     * vero se l'albero e' vuoto
     *
     * @return vero se la radice e' nulla
     */
    public boolean isEmpty() {
        return (root==null);
    }


    public BinaryNode getRoot() {
        return root;
    }

    /** Cerca item nell'albero.
     * @param item elemento da cercare
     * @return il nodo che contiene item se esiste,
     * null altrimenti.
     * @throws NullPointerException if item is null
     */
    public BinaryNode get(int item ) {
        System.out.println("metodo da implementare");
        return null;
    }


    /** Cerca item nell'albero.
     * @param item elemento da cercare
     * @return il nodo che contiene item se esiste,
     * null altrimenti.
     * @throws NullPointerException if item is null
     */
    public BinaryNode getRicorsivo(int item ) {
        return recGet(root,item);
    }

    private BinaryNode recGet(BinaryNode node, Integer item) {
        if(node!=null){
            int result = item.compareTo(node.key);
            if (result<0){
                return recGet(node.left,item);
            }
            if (result==0){
                return node;
            }
            return recGet(node.right, item);
        }
        return null;
    }

    /** Inserisce item nel nodo corretto di questo albero.
     * L'albero viene mantenuto ordinato secondo l'ordine
     * naturale della classe di item.
     *
     * @param item oggetto da inserire nell'albero .
     * @throws NullPointerException if item is null
     */
    public void put(Integer item) {
        if ( item == null ) throw new NullPointerException();
        root = putStartingFrom (item , root , null );
    }

    /** Inserisce item se non e' gia' presente in questo albero
     * a partire da nodo mantenendo l'ordine dell'albero.
     * @param item elemento da aggiungere.
     * @param nodo punto di partenza.
     * @param padre padre di nodo.
     * @return nodo se diverso da null, nuova root
     * albero che contiene item altrimenti .
     */
    private BinaryNode putStartingFrom ( Integer item , BinaryNode nodo , BinaryNode padre ){
        int result ;
        if ( nodo == null ) { // definisco un nuovo nodo
            BinaryNode n = new BinaryNode( item );
            n.p = padre ;
            return n;
        }
        if (( result = item.compareTo (nodo.key )) <0)
        {
            nodo.left = 	putStartingFrom(item,nodo.left,nodo );
            return nodo ;
        }
        if ( result == 0) {
            return nodo ;
        }
        nodo.right = putStartingFrom(item, nodo.right, nodo) ;
        return nodo ;
    }


    /**
     * Cancella <code>item</ code> se esiste.
     *
     * @param item elemento da cancellare .
     * @throws NullPointerException if item is null
     */
    public void remove ( Integer item ) {
        BinaryNode daCancellare = get( item );
        System.out.println("da cancellare = "+daCancellare);
        if ( daCancellare != null ){
            deleteNode ( daCancellare );
        }
    }


    /** Cancella il nodo daCancellare mantenendo
     * l'ordine dell'albero.
     * @param daCancellare nodo da cancellare.
     */
    private void deleteNode ( BinaryNode daCancellare ) {
        BinaryNode temp; // mantiene il riferimento al nodo
        // che andra' a sostituire il nodo daCancellare
        if (daCancellare.left == null){ // non c'e' sx
            temp = daCancellare.right ; // prendo il dx
        } else {
            if (daCancellare.right == null){ // non c'e' dx
                temp = daCancellare.left;// prendo il sx
            }
            else { // ci sono entrambi i figli...
                if ( daCancellare.left.right == null ) {
                    // se il leftSon ha solo leftSon
                    temp = daCancellare.left ;
                    temp.right = daCancellare.right;
                    temp.right.p = temp;
                } else {
                    //cerco nodo preced. nella sequenza di visita in ordine
                    temp = inOrderPrec(daCancellare);
                    // scambio gli elementi
                    daCancellare.key = temp.key;
                    deleteNode ( temp );
                    temp = daCancellare ; // allineo daCancellare
                }
            }
        }
        // ora si puo' fare la sostituzione di daCancellare con temp
        System.out.println("temp =  "+temp);
        if ( daCancellare == root ) {
            // se e' root, aggiusta il padre a null
            root = temp ;
            if ( root != null ) root.p = null ;
        } else {
            if ( daCancellare.p.left == daCancellare ){
                // daCancellare e' figlio sx
                daCancellare.p.left = temp ;
            } else {
                daCancellare.p.right = temp ;
            }
            if ( temp != null ){
                temp.p = daCancellare.p ;
            }
        }
    }
    /**
     * Restituisce il nodo il nodo piu' a dx del sottoalbero sx.
     *
     * @param node radice del sottoalbero corrente
     * @return nodo piu' a dx del sottoalbero sx di node.
     */
    private BinaryNode inOrderPrec(BinaryNode node) {
        if (node == null){
            return null;
        }
        node = node.left;
        if (node != null){
            while (node.right != null){
                node = node.right;
            }
        }
        return node;
    }


    public void setRoot(BinaryNode n) {
        root = n;

    }

    public void traversal(String type) {
        switch ( type ) {
            case "INORDER" :
                inOrdine(root);
                break;
            case "PREORDER" :
                preOrdine(root);
                break ;
            case "POSTORDER" :
                postOrdine(root);
                break;
            case "BREADTH" :
                ampiezza();
            default :
                break;
        }
    }

    private void ampiezza() {

        if(!isEmpty()){
            Queue<BinaryNode> q = new LinkedList<BinaryNode>();
            q.add(root);
            while(!q.isEmpty()){
                BinaryNode n = q.poll();
                visits.add(n.getKey());
                if (n.left!=null){
                    q.add(n.left);
                }
                if (n.right!=null){
                    q.add(n.right);
                }
            }
        }

    }

    private void postOrdine(BinaryNode node) {
        if(node!=null){
            postOrdine(node.left);
            postOrdine(node.right);
            visits.add(node.getKey());
        }
    }

    private void preOrdine(BinaryNode node) {
        if(node!=null){
            visits.add(node.getKey());
            preOrdine(node.left);
            preOrdine(node.right);
        }

    }

    private void inOrdine(BinaryNode node) {
        if(node!=null){
            inOrdine(node.left);
            visits.add(node.getKey());
            inOrdine(node.right);
        }
    }

    public ArrayList<Integer> getVisits() {

        return this.visits;

    }

}
package model.struct.Heap;

/**
 * Questa classe rappresenta un max-heap:
 * - la lista dei nodi e' rappresentata da un array;
 * - per evitare confusione con i diversi pseudocodici rilevabili in rete,
 *   la prima posizione utile dell'array è la 1
 */
public class MaxHeap {
    
    private int[] heap;
    private int actualSize;
    private int maxsize;

    /**
     * Costruttore che inizializza un max-heap vuoto di dimensione maxsize
     *
     * @param maxsize dimensione dell'heap
     */
    public MaxHeap(int maxsize) {
        this.maxsize = maxsize;
        this.actualSize = 0;
        heap = new int[this.maxsize + 1];
        heap[0] = Integer.MAX_VALUE;
    }

    /**
     * Restituisce il padre di un nodo
     *
     * @param pos posizione del nodo figlio
     * @return posizione del padre
     */
    private int parent(int pos) {
        return pos / 2;
    }

    /**
     * Restituisce il figlio sinistro di un nodo
     *
     * @param pos posizione del nodo padre
     * @return posizione del figlio sinistro
     */
    private int leftChild(int pos) {
        return (2 * pos);
    }

    /**
     * Restituisce il figlio destro di un nodo
     *
     * @param pos posizione del nodo padre
     * @return posizione del figlio destro
     */
    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    /**
     * Controlla se il nodo in posizione "pos" è una foglia
     *
     * @param pos posizione del nodo padre
     * @return true se il nodo in questione è una foglia, false altrimenti
     */
    private boolean isLeaf(int pos) {
        if (pos >= (actualSize / 2) && pos <= actualSize) {
            return true;
        }
        return false;
    }

    /**
     * Scambia di posizione due nodi
     *
     * @param first posizione del primo nodo
     * @param second posizione del secondo nodo
     */
    private void swap(int first, int second) {
        int tmp;
        tmp = heap[first];
        heap[first] = heap[second];
        heap[second] = tmp;
    }

    /**
     * Controlla che le proprietà del max-heap vengano
     * rispettate a partire dal nodo in posizione pos
     *
     * @param pos posizione del nodo iniziale
     */
    private void maxHeapify(int pos) {
        if (isLeaf(pos))
            return;

        if (heap[pos] < heap[leftChild(pos)] ||
                heap[pos] < heap[rightChild(pos)]) {

            if (heap[leftChild(pos)] > heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            } else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    /**
     * Inserisce il nodo con valore "element" nell'heap
     *
     * @param element valore del nodo da inserire
     */
    public void insert(int element) {
        heap[++actualSize] = element;

        /* Fa slittare il nodo finchè non è minore del padre */
        int current = actualSize;
        while (heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    /**
     * Stampa le relazioni che intercorrono tra i vari nodi
     */
    public void print() {
        for (int i = 1; i <= actualSize / 2; i++) {
            System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : " +
                    heap[2 * i] + " RIGHT CHILD :" + heap[2 * i + 1]);
            System.out.println();
        }
    }

    /**
     * Costruisce il max-heap a partire da un array
     */
    public void buildMaxHeap()
    {
        for (int pos = (actualSize / 2); pos >= 1; pos--) {
            maxHeapify(pos);
        }
    }

    /**
     * Estrae e rimuove l'elemento con valore maggiore (radice)
     *
     * @return valore del nodo maggiore
     */
    public int extractMax() {
        int popped = heap[1];
        heap[1] = heap[actualSize--];
        maxHeapify(1);
        return popped;
    }

    /**
     * Restituisce, ma non rimuove, l'elemento con valore maggiore (radice)
     *
     * @return valore del nodo maggiore
     */
    public int max() {

        return heap[1];

    }
    
}
# Heap
Un mucchio (*heap*) è una struttura dati ad albero in cui ***la chiave del nodo padre è sempre maggiore (max-heap) di quella dei figli***, mentre nessuna relazione sussiste tra le chiavi di due fratelli.
E' possibile definirne una variante in cui la chiave del padre è sempre minore di quella dei figli (*min-heap*).
Consideriamo l'heap come un albero quasi-completo (BST è a tutti gli effetti anche un heap), se l’albero è binario, parliamo di mucchi binari (*binary heaps*).

Questa struttura dati viene generalmente utilizzata per implementare una coda con priorità (la priorità è data dalla chiave) o per ordinare un vettore, attraverso l'algoritmo di ordinamento *heapsort*.

## Funzioni base

* *[MAX](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/035dec8f8486b636e90ccd11c80a867e925dbd96/src/main/java/model/struct/Heap/MaxHeap.java#L145)*: esamina l'elemento con chiave massima (nel caso di max-heap, la radice)
* *INSERISCI*: inserisce un elemento nell'heap
* *CANCELLA-MAX*: estrae l'elemento con chiave massima
* *[COSTRUISCI-MAX-HEAP](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/035dec8f8486b636e90ccd11c80a867e925dbd96/src/main/java/model/struct/Heap/MaxHeap.java#L99)*: dato un array, ne costruisce il max-heap
* *[MAX-HEAPIFY](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/035dec8f8486b636e90ccd11c80a867e925dbd96/src/main/java/model/struct/Heap/MaxHeap.java#L65)*: funzione ausiliare che garantisce che vengano rispettate le proprietà dell'heap

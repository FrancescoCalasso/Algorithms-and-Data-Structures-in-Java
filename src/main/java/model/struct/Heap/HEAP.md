# Heap
Un mucchio (*heap*) è una struttura dati ad albero binario completo o semi-completo in cui sussiste una relazione tra padre e figli (mentre nessuna relazione sussiste tra le chiavi di due fratelli):

* Parliamo di *[max-heap](src/main/java/model/struct/Heap/MaxHeap.java)* quando *padre.key > figlio.key* (la radice è nodo con chiave massima)
* Parliamo di *[min-heap](src/main/java/model/struct/Heap/MinHeap.java)* quando *padre.key < figlio.key* (la radice è nodo con chiave minima)

Questa struttura dati viene generalmente utilizzata per implementare una coda con priorità (la priorità è data dalla chiave) o per ordinare un vettore, attraverso l'algoritmo di ordinamento *heapsort*.

## Funzioni base di un max-heap

* *[MAX](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/035dec8f8486b636e90ccd11c80a867e925dbd96/src/main/java/model/struct/Heap/MaxHeap.java#L107)*: esamina l'elemento con chiave massima (nel caso di max-heap, la radice)
* *[INSERISCI](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/4ddd8860ccca565bfd4bb3dbf8c2fb17cd6d4a4d/src/main/java/model/struct/Heap/MaxHeap.java#L70)*: inserisce un elemento nell'heap
* *[ESTRAI-MAX](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/4ddd8860ccca565bfd4bb3dbf8c2fb17cd6d4a4d/src/main/java/model/struct/Heap/MaxHeap.java#L99)*: estrae l'elemento con chiave massima
* *[COSTRUISCI-MAX-HEAP](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/4ddd8860ccca565bfd4bb3dbf8c2fb17cd6d4a4d/src/main/java/model/struct/Heap/MaxHeap.java#L90)*: dato un array, ne costruisce il max-heap
* *[MAX-HEAPIFY](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/4ddd8860ccca565bfd4bb3dbf8c2fb17cd6d4a4d/src/main/java/model/struct/Heap/MaxHeap.java#L49)*: funzione ausiliare che garantisce che vengano rispettate le proprietà dell'heap

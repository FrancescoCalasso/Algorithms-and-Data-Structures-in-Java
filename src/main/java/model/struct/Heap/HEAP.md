# Heap
Un mucchio (*heap*) è una struttura dati ad albero binario completo o semi-completo in cui sussiste una relazione tra padre e figli (mentre nessuna relazione sussiste tra le chiavi di due fratelli):

* Parliamo di *[max-heap](/src/main/java/model/struct/Heap/MaxHeap.java)* quando *padre.key > figlio.key* (la radice è nodo con chiave massima)
* Parliamo di *[min-heap](/src/main/java/model/struct/Heap/MinHeap.java)* quando *padre.key < figlio.key* (la radice è nodo con chiave minima)

Questa struttura dati viene generalmente utilizzata per implementare una coda con priorità (la priorità è data dalla chiave) o per ordinare un vettore, attraverso l'algoritmo di ordinamento *heapsort*.

## Funzioni base di un max-heap

* *[MAX](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/53de218e15e7cdc62631e40081a98f586509c0a2/src/main/java/model/struct/Heap/MaxHeap.java#L155)*: esamina l'elemento con chiave massima (nel caso di max-heap, la radice)
  * *Complessità temporale* O(1)
* *[INSERISCI](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/53de218e15e7cdc62631e40081a98f586509c0a2/src/main/java/model/struct/Heap/MaxHeap.java#L106)*: inserisce un elemento nell'heap
  * *Complessità temporale* O(logn)
* *[ESTRAI-MAX](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/53de218e15e7cdc62631e40081a98f586509c0a2/src/main/java/model/struct/Heap/MaxHeap.java#L143)*: estrae l'elemento con chiave massima
* *[COSTRUISCI-MAX-HEAP](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/53de218e15e7cdc62631e40081a98f586509c0a2/src/main/java/model/struct/Heap/MaxHeap.java#L133)*: dato un array, ne costruisce il max-heap
  * *Complessità temporale* O(n)
* *[MAX-HEAPIFY](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/53de218e15e7cdc62631e40081a98f586509c0a2/src/main/java/model/struct/Heap/MaxHeap.java#L83)*: funzione ausiliare che garantisce che vengano rispettate le proprietà dell'heap
  * *Complessità temporale* O(logn)

## Funzioni base di un min-heap

* *[MIN](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/53de218e15e7cdc62631e40081a98f586509c0a2/src/main/java/model/struct/Heap/MinHeap.java#L173)*: esamina l'elemento con chiave minima (nel caso di max-heap, la radice)
  * *Complessità temporale* O(1)
* *[INSERISCI](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/53de218e15e7cdc62631e40081a98f586509c0a2/src/main/java/model/struct/Heap/MinHeap.java#L118)*: inserisce un elemento nell'heap
  * *Complessità temporale* O(logn)
* *[ESTRAI-MIN](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/53de218e15e7cdc62631e40081a98f586509c0a2/src/main/java/model/struct/Heap/MinHeap.java#L160)*: estrae l'elemento con chiave minima
* *[COSTRUISCI-MIN-HEAP](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/53de218e15e7cdc62631e40081a98f586509c0a2/src/main/java/model/struct/Heap/MinHeap.java#L150)*: dato un array, ne costruisce il min-heap
  * *Complessità temporale* O(n)
* *[MIN-HEAPIFY](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/53de218e15e7cdc62631e40081a98f586509c0a2/src/main/java/model/struct/Heap/MinHeap.java#L88)*: funzione ausiliare che garantisce che vengano rispettate le proprietà dell'heap
  * *Complessità temporale* O(logn)

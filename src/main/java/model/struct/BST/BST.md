# Albero binario di ricerca

Un albero è una struttura dati costituita da un insieme di nodi e uno di archi che li collegano (*V, E*).
Ogni nodo può avere al più un arco entrante, ma un numero arbitrario di archi uscenti.

Gli [alberi binari di ricerca](/src/main/java/model/struct/BST/BinaryTree.java) sono particolari tipi di alberi che devono il loro nome al fatto che ogni nodo può avere solo due archi uscenti (un figlio sinistro e un figlio destro).
La caratteristica principale, che le operazioni di inserimento e cancellazione devono preservare, è che, dato un nodo *x*:

* Se *y* è contenuto nel sottoalbero sinistro di x, *y.key ≤ x.key*
* Se *y* è contenuto nel sottoalbero destro di x, *y.key ≥ x.key*

## Visita di un albero

L'operazione caratteristica è la cosiddetta *visita* per enumerare le chiavi contenute.
La definizione naturale degli algoritmi è ricorsiva e il fattore determinante tra le diverse strategie è l'ordine in cui i nodi vengono visitati:

### Visita in-ordine

Nella [visita in ordine](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/b3f8bb80a6ebe58c1a78b07896d8f86f70dddcf3/src/main/java/model/struct/BST/BinaryTree.java#L254), si visita prima il sottoalbero sinistro, quindi la radice e, infine, il sottoalbero destro.
Nel caso di BST, stampa le chiavi in ordine.

### Visita anticipata (pre-ordine)

Nella [visita pre-ordine](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/b3f8bb80a6ebe58c1a78b07896d8f86f70dddcf3/src/main/java/model/struct/BST/BinaryTree.java#L240), si visita prima la radice, quindi il sottoalbero sinistro, infine il sottoalbero destro.

### Visita posticipata (post-ordine)

Nella [visita post-ordine](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/b3f8bb80a6ebe58c1a78b07896d8f86f70dddcf3/src/main/java/model/struct/BST/BinaryTree.java#L227), si visita prima il sottoalbero sinistro, poi il sottoalbero destro e infine la radice.

## Successore di un nodo

Per determinare il [successore di un nodo](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/b3f8bb80a6ebe58c1a78b07896d8f86f70dddcf3/src/main/java/model/struct/BST/BinaryTree.java#L129), ci sono due possibili casi:

* *Sottoalbero destro non vuoto*, il successore è il minimo del sottoalbero destro
* *Sottoalbero destro vuoto*, il successore è il progenitore (padre, nonno,..) più vicino che contiene il nodo nel suo sottoalbero sinistro

## Cancellazione di un nodo

L'operazione di [cancellazione](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/b3f8bb80a6ebe58c1a78b07896d8f86f70dddcf3/src/main/java/model/struct/BST/BinaryTree.java#L159) dipende dal numero di figli del nodo da cancellare:

* Nodo non ha figli, elimina nodo aggiornando con free()
* Nodo ha un figlio, elemento sosituito dal figlio nel suo ruolo nell'albero
* Nodo ha due figli, copio il valore del successore su di esso ed elimino il successore

## Funzioni base:

* [Inserisci nodo nell'albero](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/b3f8bb80a6ebe58c1a78b07896d8f86f70dddcf3/src/main/java/model/struct/BST/BinaryTree.java#L52)
* [Ricerca del nodo con chiave minima](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/b3f8bb80a6ebe58c1a78b07896d8f86f70dddcf3/src/main/java/model/struct/BST/BinaryTree.java#L111)
* [Ricerca del nodo con chiave massima](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/b3f8bb80a6ebe58c1a78b07896d8f86f70dddcf3/src/main/java/model/struct/BST/BinaryTree.java#L91)
* [Ricerca di un nodo](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/b3f8bb80a6ebe58c1a78b07896d8f86f70dddcf3/src/main/java/model/struct/BST/BinaryTree.java#L28)
* [Libera il nodo dall'albero](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/b3f8bb80a6ebe58c1a78b07896d8f86f70dddcf3/src/main/java/model/struct/BST/BinaryTree.java#L210)

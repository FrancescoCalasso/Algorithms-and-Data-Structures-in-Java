# Albero rosso-nero

Un *[albero rosso-nero](/src/main/java/model/struct/RBT/RBTree.java)* è un BST i cui nodi sono dotati di un attributo aggiuntivo, detto *colore* (rosso o nero), e soddisfacente le seguenti 5 proprietà:
1. Ogni nodo è rosso o nero
2. La radice è nera
3. Le foglie sono nere
4. I figli di un nodo rosso sono entrambi neri
5. Per ogni nodo dell'albero, ***tutti i cammini dai suoi discendenti alle foglie contenute nei suoi sottoalberi hanno lo stesso numero di nodi neri***

I dati sono mantenuti unicamente nei nodi interni, le foglie sono tutte NIL e fisicamente rappresentate da un singolo nodo.

## Funzioni base

Tutte le operazioni che non vanno a modificare la struttura dell'albero sono identiche ai BST:

* [Ricerca del nodo con chiave minima](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/db74bdf93010440881fbc04c6c9e6ee251fe3287/src/main/java/model/struct/RBT/RBTree.java#L76)
* [Ricerca del nodo con chiave massima](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/db74bdf93010440881fbc04c6c9e6ee251fe3287/src/main/java/model/struct/RBT/RBTree.java#L56)
* [Successore di un nodo](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/db74bdf93010440881fbc04c6c9e6ee251fe3287/src/main/java/model/struct/RBT/RBTree.java#L94)
* [Ricerca di un nodo](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/db74bdf93010440881fbc04c6c9e6ee251fe3287/src/main/java/model/struct/RBT/RBTree.java#L32)
* [Libera il nodo dall'albero](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/db74bdf93010440881fbc04c6c9e6ee251fe3287/src/main/java/model/struct/RBT/RBTree.java#L370)

Le operazioni di inserimento e cancellazione hanno necessità di mantenere le proprietà degli alberi rosso-neri.

## [Inserisci un nodo nell'albero](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/db74bdf93010440881fbc04c6c9e6ee251fe3287/src/main/java/model/struct/RBT/RBTree.java#L194)

L'inserimento procede ad inserire il nuovo elemento come se l'albero fosse un semplice BST, salvo:
* Assegnare il valore dei sottoalberi del nodo a T.nil al posto di NIL se viene inserito come una foglia
* Assegnare il valore del genitore del nodo a T.nil al posto di NIL se il nodo è inserito come radice
* Colorare il nodo appena inserito di rosso

In questo procedimento, possono essere violate le proprietà 4 e 2, per questo è necessario l'utilizzo di una funzione ausiliaria *[RiparaRBInserisci()](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/db74bdf93010440881fbc04c6c9e6ee251fe3287/src/main/java/model/struct/RBT/RBTree.java#L237)* che ripristini le proprietà dell'RBT; vi possono essere 3 casi a seconda delle relazioni tra i nodi e dei loro colori:

1. "Zio" rosso → cambio di colore per nonno, padre e zio (se il nonno è radice, si può ricolorare di nero senza problemi)

2. "Zio" nero e nodo da inserire figlio *destro* del padre → *LeftRotate(padre)* e chiamata ricorsiva di riparazione sul nodo da inserire

3. "Zio" nero e nodo da inserire figlio *sinistro* del padre → cambio di colori per padre e nonno e *RighRotate(nonno)*

L'inserimento, comprensivo di riparazione, ha *complessità temporale* pari a O(logn).

## [Cancellazione di un nodo dall'albero](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/db74bdf93010440881fbc04c6c9e6ee251fe3287/src/main/java/model/struct/RBT/RBTree.java#L292)

Anche la cancellazione procede nello stesso modo del BST, con alcune differenze dovute a possibili proprietà violate e il conseguente ausilio della funzione *[RiparaRBCancella()](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/db74bdf93010440881fbc04c6c9e6ee251fe3287/src/main/java/model/struct/RBT/RBTree.java#L348)*. Nello specifico, è possibile distinguere 5 casi a seconda delle relazioni tra i nodi e i loro colori:

* Caso 0: *x è rosso* → viene colorato di nero
* Caso 1: *x è nero con fratello rosso* → cambio di colore per fratello e padre, *LeftRotate(padre)*: ci si trova ora in uno tra i casi 2, 3, 4
* Caso 2: *x è nero con fratello nero e nipoti neri* → cambio di colore per fratello e chiamata ricorsiva di riparazione sul padre
* Caso 3: *x è nero con fratello nero e nipote destro nero* → cambio di colore per fratello e nipote sinistro, *RightRotate(fratello)*: ci si trova ora nel caso 4
* Caso 4: *x è nero con fratello nero e nipote destro rosso* → fratello prende colore del padre, nipote destro diventa nero, *LeftRotate(padre)*

La procedura complessiva di cancellazione ha *complessità temporale* pasi a O(logn).

## Rotazione

La rotazione è un'operazione locale a due nodi che cambia il livello a cui sono situati due nodi senza violare le proprietà. Abbiamo due diversi tipi di rotazione, una a *[destra](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/db74bdf93010440881fbc04c6c9e6ee251fe3287/src/main/java/model/struct/RBT/RBTree.java#L159)* e una a *[sinistra](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/db74bdf93010440881fbc04c6c9e6ee251fe3287/src/main/java/model/struct/RBT/RBTree.java#L124)*.

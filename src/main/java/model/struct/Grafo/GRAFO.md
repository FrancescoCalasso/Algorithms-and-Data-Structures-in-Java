# Grafo

Il *[grafo](src/main/java/model/struct/Grafo/Grafo.java)* è la struttura dati più naturale per rappresentare un insieme di oggetti legati da una generica relazione tra di loro.
La relazione tra gli oggetti è rappresentata da un insieme di coppie di oggetti (ordinate o meno), legate tra loro da un *arco*: questo, a sua volta, può avere un verso (grafo diretto) o meno.

Esempio, una mappa stradale: nodi → città, relazione → le città sono collegate da una strada

## Rappresentazione di un grafo

### Lista di adiacenza

Il grafo è rappresentato da un *vettore di liste lungo |V|*, indicizzato dai nomi dei nodi: ogni lista contiene i nodi adiacenti all’indice della sua testa.

La **complessità spaziale**, definito |E| come il numero di archi del grafo, è data da Θ(|V| + |E|).

La **complessità temporale** per vedere se una coppia (v<sub>1</sub>, v<sub>2</sub>) appartiene al grafo è Θ(|V|) (si deve controllare, nel caso pessimo, ogni lista).

### Matrice di adiacenza

Una *matrice di valori booleani |V| × |V|*, con righe e colonne indicizzate dai nomi dei nodi: la cella alla riga i, colonna j contiene 1 se l’arco (v<sub>i</sub>,v<sub>j</sub>) è presente nel grafo (0 altrimenti).

La **complessità spaziale** è data da Θ(|V|<sup>2</sup>), mentre la **complessità temporale** per vedere se una coppia (v<sub>1</sub>, v<sub>2</sub>) appartiene al grafo è Θ(1) (è sufficiente controllare se la cella (v<sub>1</sub>, v<sub>2</sub>).

## Visite di un grafo

Un grafo può essere visitato in *ampiezza* o *profondità*:

### Visita in ampiezza

La strategia di **[visita in ampiezza](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures/blob/a3c66c95fc49dda63f33791e671dfa250db2bb13/src/main/java/model/struct/Grafo.java#L210)** visita tutti i nodi di un grafo *G* a partire da uno nodo sorgente *s*.

Vengono visitati tutti i nodi con un cammino tra loro e *s* lungo *n* passi, prima di visitare quelli con un cammino lungo *n + 1*.
La visita di un grafo è più problematica di quella di un albero: possono essere presenti cicli, quindi evitiamo di iterare all’infinito colorando i nodi mentre li visitiamo:
* *Nodo bianco*: deve essere ancora visitato
* *Nodo grigio*: il nodo è stato visitato, devono essere visitati quelli adiacenti ad esso
* *Nodo nero*: sono stati visitati sia il nodo che quelli adiacenti

### Visita in profondità

Diversamente dalla visita in ampiezza, **[in profondità](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures/blob/a3c66c95fc49dda63f33791e671dfa250db2bb13/src/main/java/model/struct/Grafo.java#L256)** visitiamo prima i nodi adiacenti a quello dato, poi il nodo stesso: segue i cammini “fino in fondo” sul grafo prima di visitare i vicini del nodo di partenza.

Il codice è identico a quello della visita in ampiezza sostituendo la coda con una pila (condivide quindi anche le complessità).

#### Algoritmo di visita 

1. Memorizziamo in una coda i nodi ancora da visitare
2. La coda è inizializzata con la sola sorgente
3. Estraiamo un nodo dalla coda e:
   * Visitiamo i vicini bianchi
   * Li coloriamo di grigio e calcoliamo la loro distanza 
   * Li accodiamo affinchè siano visitati a loro volta
4. Marchiamo quindi il nodo estratto come nero e riprendiamo estraendo il successivo

Complessità totale: Θ(|V| + |E|)

## Cammino minimo (Algoritmo di Dijkstra)

Trova, dato un grafo orientato e un suo nodo *s*, i percorsi più brevi da un nodo a qualunque altro.
Funziona sia su di un grafo classico, che su di un grafo pesato ovvero con archi dotati di un valore intero.

### Principio di funzionamento
1. Inserisco ogni v ∈ V \ {s} in un insieme Q dopo aver impostato il suo attributo distanza a ∞ ed il v.pred a NIL 
2. Inserisco s in Q dopo aver impostato s.dist ← 0, s.pred ← NIL
3. Fin quando Q non è vuoto, estraggo il nodo c con dist minima e controllo per ogni adiacente a se hanno distanza minore di c.dist + peso(c, a)
   * Se questo accade imposto a.pred ← c, a.dist ← c.dist + peso(c, a)
   
L’algoritmo effettua nel caso pessimo (grafo completamente connesso) O(|V|) accessi ad ogni controllo per le distanze, viene effettuato un controllo per ogni nodo del grafo, quindi **complessità temporale**: O(|V|<sup>2</sup>).

## Rilevazione di cicli (Algoritmo di Floyd)

## Funzioni base

* [Aggiungi nodo al grafo](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures/blob/57310f9d08ed7bcf7f80ccb2cbec725e309b1e17/src/main/java/model/struct/Grafo.java#L53)

* [Aggiungi arco tra due nodi al grafo](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures/blob/57310f9d08ed7bcf7f80ccb2cbec725e309b1e17/src/main/java/model/struct/Grafo.java#L89)

* [Rimuovi un arco dal grafo](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures/blob/57310f9d08ed7bcf7f80ccb2cbec725e309b1e17/src/main/java/model/struct/Grafo.java#L124)

* [Ricerca di un nodo nel grafo](/src/main/java/model/struct/Grafo.java)

* [Estrai il nodo con valore massimo](/src/main/java/model/struct/Grafo.java)

* [Cancella un nodo dal grafo](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures/blob/57310f9d08ed7bcf7f80ccb2cbec725e309b1e17/src/main/java/model/struct/Grafo.java#L67)

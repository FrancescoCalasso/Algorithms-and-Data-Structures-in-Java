# Grafo

Il *grafo* è la struttura dati più naturale per rappresentare un insieme di oggetti legati da una generica relazione tra di loro.
La relazione tra gli oggetti è rappresentata da un insieme di coppie di oggetti (ordinate o meno), legate tra loro da un *arco*: questo, a sua volta, può avere un verso (grafo diretto) o meno.

Esempio: Una mappa stradale: nodi → città, relazione → le città sono collegate da una strada

## Rappresentazione di un grafo

### Lista di adiacenza

Il grafo è rappresentato da un *vettore di liste lungo |V|*, indicizzato dai nomi dei nodi: ogni lista contiene i nodi adiacenti all’indice della sua testa.

La **complessità spaziale**, definito |E| come il numero di archi del grafo, è data da teta(|V| + |E|).

La **complessità temporale** per vedere se una coppia (v1, v2) appartiene al grafo è teta(|V|) (si deve controllare, nel caso pessimo, ogni lista).

### Matrice di adiacenza

Una *matrice di valori booleani |V| × |V|*, con righe e colonne indicizzate dai nomi dei nodi: la cella alla riga i, colonna j contiene 1 se l’arco (vi,vj) è presente nel grafo (0 altrimenti).

La **complessità spaziale** è data da teta(|V|^2), mentre la **complessità temporale** per vedere se una coppia (v1, v2) appartiene al grafo è teta(1) (è sufficiente controllare se la cella (v1, v2).

## Visite di un grafo

Un grafo può essere visitato in *ampiezza* o *profondità*:

### Visita in ampiezza

La strategia di **[visita in ampiezza](/src/main/java/model/struct/Grafo.java)** visita tutti i nodi di un grafo G a partire da uno nodo sorgente s.

#### Algoritmo di visita: 

Vengono visitati tutti i nodi con un cammino tra loro e s lungo n passi, prima di visitare quelli con un cammino lungo n + 1.
La visita di un grafo è più problematica di quella di un albero: possono essere presenti cicli, quindi evitiamo di iterare all’infinito colorando i nodi mentre li visitiamo:
   * Nodo bianco: deve essere ancora visitato
   * Nodo grigio: il nodo è stato visitato, devono essere visitati quelli adiacenti ad esso
   * Nodo nero: sono stati visitati sia il nodo che quelli adiacenti
 
* Memorizziamo in una coda i nodi ancora da visitare
* La coda è inizializzata con la sola sorgente
* Estraiamo un nodo dalla coda e:
  * Visitiamo i vicini bianchi
  * Li coloriamo di grigio e calcoliamo la loro distanza 
  * Li accodiamo affinchè siano visitati a loro volta
* Marchiamo quindi il nodo estratto come nero e riprendiamo estraendo il successivo

Complessità totale: O(|V| + |E|)

### Visita in profondità

Diversamente dalla visita in ampiezza, visitiamo prima i nodi adiacenti a quello dato, poi il nodo stesso: segue i cammini “fino in fondo” sul grafo prima di visitare i vicini del nodo di partenza.

Il codice è identico a quello della visita in ampiezza sostituendo la coda con una pila (condivide quindi anche le complessità).

## Cammino minimo (Algoritmo di Dijkstra)

## Rilevazione di cicli (Algoritmo di Floyd)

## Funzioni base

* [Aggiungi nodo al grafo](/src/main/java/model/struct/Grafo.java)

* [Aggiungi arco al grafo](/src/main/java/model/struct/Grafo.java)

* [Ricerca di un nodo nel grafo](/src/main/java/model/struct/Grafo.java)

* [Estrai il nodo con valore massimo](/src/main/java/model/struct/Grafo.java)

* [Cancella un nodo dal grafo](/src/main/java/model/struct/Grafo.java)

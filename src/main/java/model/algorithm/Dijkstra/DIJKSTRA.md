# Cammino minimo (*[Algoritmo di Dijkstra](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/ea92f7e81c8009ff0483131e6b91c0081f3200e1/src/main/java/model/struct/Grafo/GrafoList.java#L228)*)

L'*[algoritmo di Dijkstra](/src/main/java/model/algorithm/Dijkstra/Dijkstra.java)* trova, dato un grafo orientato e un suo nodo *s*, i percorsi più brevi da un nodo a qualunque altro.
Funziona sia su di un grafo classico, che su di un grafo pesato ovvero con archi dotati di un valore intero.

## Principio di funzionamento
1. Inserisco ogni v ∈ V \ {s} in un insieme Q dopo aver impostato il suo attributo distanza a ∞ ed il v.pred a NIL 
2. Inserisco s in Q dopo aver impostato s.dist ← 0, s.pred ← NIL
3. Fin quando Q non è vuoto, estraggo il nodo c con dist minima e controllo per ogni adiacente a se hanno distanza minore di c.dist + peso(c, a)
   * Se questo accade imposto a.pred ← c, a.dist ← c.dist + peso(c, a)
   
L’algoritmo effettua nel caso pessimo (grafo completamente connesso) O(|V|) accessi ad ogni controllo per le distanze, viene effettuato un controllo per ogni nodo del grafo, quindi **complessità temporale**: O(|V|<sup>2</sup>).

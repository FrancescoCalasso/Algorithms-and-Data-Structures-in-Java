# Pila

Una *[pila](src/main/java/model/struct/Pila/Pila.java)* è una struttura dati con le seguenti operazioni: 
* **Push(S,e)**: aggiunge l’elemento in cima alla pila
* **Pop(S,e)**: restituisce l’elemento in cima alla pila cancellandolo 
* **Empty(S)**: restituisce *true* se la pila è vuota

## Rappresentazione

Questa struttura dati astratta può essere realizzata usando una *lista semplicemente connessa* o un *vettore*.

### Realizzazione con lista

Lo stoccaggio dati è nella lista, le operazioni diventano: 
* **Push(S,e)**: inserisci in testa alla lista
* **Pop(S,e)**: restituisci il primo elemento della lista, cancellandolo dalla stessa
* **Empty(S)**: controlla se il successore della testa è NIL

### Realizzazione con vettore

Lo stoccaggio dati è nella celle del vettore, viene mantenuto l’indice della cima della pila (Top of Stack, ToS)

* **Push(S,e)**: se cè spazio, incrementa ToS, salva e in A[ToS]; se manca spazio rifiuta o rialloca
* **Pop(S)**: restituisci A[ToS] corrente, decrementa ToS
* **Empty(S)**: Restituisci ToS = 0 ?

### Complessità delle operazioni

La **complessità temporale** di ogni operazione è O(1) se utilizziamo una lista semplicemente connessa o un vettore con stoccaggio finito.

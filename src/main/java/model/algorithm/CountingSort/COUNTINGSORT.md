# Counting sort

*[Counting sort](src/main/java/model/algorithm/CountingSort/CountingSort.java)* è un algoritmo di ordinamento per valori numerici interi con complessità lineare O(n+m), dove *n* è la lunghezza dell'array e *m* è pari a *max(A) - min(A) + 1* (max(A) e min(A) sono rispettivamente l'elemento più grande e l'elemento più piccolo dell'array) ovvero è il range dei valori contenuti nell'array. Non è basato su confronti e scambi e conviene utilizzarlo quando il valore di m è piccolo rispetto a n, altrimenti risulterebbero più veloci altri algoritmi.

L'algoritmo è semplice ed intuitivo: 
* Si calcolano i valori max(A) e min (A)
* Si prepara un array *C* di dimensione pari all'intervallo dei valori con C[i] che rappresenta la frequenza dell'elemento *i + min(A)* nell'array di partenza *A*
* Si visita l'array A aumentando l'elemento di C corrispondente
* Dopo si visita l'array C in ordine e si scrivono su A *C[i]* copie del valore *i + min(A)*.

## Esempio

![Alt Text](https://www.codesdope.com/staticroot/images/algorithm/count1.gif)

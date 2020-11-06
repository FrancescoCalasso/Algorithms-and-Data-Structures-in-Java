# Ricerca binaria

La *[ricerca binaria](/src/main/java/model/algorithm/RicercaBinaria/RicercaBinaria.java)* è un algoritmo di ricerca *ricorsivo* che opera su un array **ordinato**.

Il principio di funzionamento è il seguente:
* Di volta in volta, viene individuato il punto medio dell'array:
  * Se il valore da cercare è uguale al valore mediano, l'elemento è stato trovato
  * Se il valore da cercare è maggiore del valore mediano, chiamata ricorsiva sulla metà destra dell'array
  * Alrimenti, chiamata ricorsiva sulla metà sinistra dell'array
  
La **complessità temporale**, intuitivamente, è pari a O(logn).

![Alt Text](https://upload.wikimedia.org/wikipedia/commons/6/64/Binary_search_into_array_-_example.svg)

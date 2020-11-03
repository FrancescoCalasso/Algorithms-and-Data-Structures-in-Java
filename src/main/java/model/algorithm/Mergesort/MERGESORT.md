# Merge sort

*[Mergesort](src/main/java/model/algorithm/Mergesort/MergeSort.java)* è un algoritmo di ordinamento conforme al metodo “divide et impera” e impiega un tempo circa pari a nlogn:

- Divide la sequenza degli n elementi da ordinare in due sottosequenze di n/2 elementi;

- Ordina le due sottosequenze in modo ricorsivo utilizzando l’algoritmo *[mergesort](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/e24523e7728c51a2709b062477a9d5ca95035de8/src/main/java/model/algorithm/Mergesort/MergeSort.java#L63)*;

- Fonde (*[merge](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/e24523e7728c51a2709b062477a9d5ca95035de8/src/main/java/model/algorithm/Mergesort/MergeSort.java#L10)*) le due sottosequenze ordinate per generare la sequenza ordinata.

Il modo di operare dell’algoritmo è simile a quanto segue: 

* Abbiamo due mazzi scoperti e ordinati su un tavolo
* Di volta in volta prendiamo la carta minore tra i due mazzi e la impiliamo su un nuovo mazzo 
* Andando avanti fino ad esaurimento carte, otterremo il nuovo mazzo “fusione” ordinato.

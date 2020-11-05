# Quick sort

*[Quicksort](/src/main/java/model/algorithm/QuickSort/QuickSort.java)* è un algoritmo di ordinamento ricorsivo *in-place* *instabile*. 

Tale procedura ricorsiva viene comunemente detta *[partition](https://github.com/FrancescoCalasso/Algorithms-and-Data-Structures-in-Java/blob/e5ea1ce4535bc35f759eabb4c1cffaa0c2a476a5/src/main/java/model/algorithm/QuickSort/QuickSort.java#L8)*: 
* Preso un elemento chiamato "*pivot*" da una struttura dati (es. array) si pongono gli elementi minori a sinistra rispetto al pivot e gli elementi maggiori a destra 
* L'operazione viene quindi reiterata sui due insiemi risultanti fino al completo ordinamento della struttura.

Quicksort è l'algoritmo di ordinamento che ha, nel caso medio, prestazioni migliori tra quelli basati su confronto.

![Alt Text](https://upload.wikimedia.org/wikipedia/commons/6/6a/Sorting_quicksort_anim.gif)

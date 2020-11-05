# Heap sort

*[Heap sort](/src/main/java/model/algorithm/Heapsort/HeapSort.java)* è un algoritmo di ordinamento *instabile* che si basa sull'heap e che possiede *complessità temporale* pari a O(*nlogn*) (nel caso pessimo, la migliore possibile).

Concettualmente, funziona come il Selection sort: di volta in volta viene individuato l'elemento maggiore e spostato alla fine, quindi si ripete il procedimento sulla parte disordinata.

Il modo di operare dell'algoritmo è quanto segue:
* Si costruisce un *max-heap* dall'array da ordinare
* Si sposta la radice in ultima posizione
* Si congela l'ultima posizione e si esegue *max-heapify* sulla nuova radice
* Si sposta la nuova radice alla fine e si ripete

![Alt Text](https://upload.wikimedia.org/wikipedia/commons/4/4d/Heapsort-example.gif)

# Insertion sort

"Insertion sort" è un algoritmo di ordinamento *stabile* che possiede *complessità spaziale* pari a \theta(1) e *complessità temporale* pari a \theta(n^2).

Questo algoritmo opera nello stesso modo in cui alcune persone ordinano le carte da gioco in mano: partendo dalla seconda carta, la si confronta con le precedenti (le carte alla sua sinistra) e la si fa slittare finché non si trova nella posizione corretta (ovvero, fino a quando la carta precedente non è minore della carta in questione).

## Pseudocodice

function insertionSort(array A)
     for i ← 1 to length[A] 
            value ← A[i]
            j ← i-1
        while j >= 0 and A[j] > value 
            A[j + 1] ← A[j]
            j ← j-1
        A[j+1] ← value;

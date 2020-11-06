package model.struct.Grafo;

import java.util.ArrayList;

/**
 * Questa classe rappresenta un grafo mediante matrice di adiacenze:
 * - Ogni nodo è rappresentato da una riga e da una colonna
 * - La casella (i,j) è pari a 1 (o al peso dell'arco) se esiste un arco che congiunge
 *   i e j (nel caso di grafo diretto, se esiste un arco che parte da i e arriva in j)
 */
public class GrafoMatrix {

    int[][] grafo;
    ArrayList<Nodo> nodi = new ArrayList<>();

    public GrafoMatrix(int n) {

        grafo = new int[n][n];

        for(int i = 0; i < n; i++) {

            grafo[i][i] = 0;

        }

    }

    /**
     * Ricerca un nodo nel grafo
     *
     * @param node nodo da cercare
     * @return true se il nodo è stato trovato, false altrimenti
     */
    public boolean searchNode(int node) {

        for(int i = 0; i < grafo.length; i++) {

            if(grafo[i][0] == node) return true;

        }

        return false;

    }

    /**
     * Ricerca un arco tra due nodi nel grafo
     *
     * @param first primo nodo dell'arco
     * @param second secondo nodo dell'arco
     * @return true se l'arco è presente, false altrimenti
     */
    public boolean searchEdge(int first, int second) {

        if(grafo[first-1][second-1] > 0) return true;

        return false;

    }

}

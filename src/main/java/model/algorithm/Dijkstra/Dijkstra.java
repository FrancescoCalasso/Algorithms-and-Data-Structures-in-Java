package model.algorithm.Dijkstra;

import model.struct.Grafo.Arco;
import model.struct.Grafo.GrafoList;

import java.util.Iterator;

/**
 * Questa classe rappresenta l'algoritmo di Dijkstra
 */
public class Dijkstra {

    GrafoList grafo;

    /**
     * Funzione che calcola attraverso l'algoritmo di Dijkstra tutte le distanze minime da un nodo iniziale
     * ai restanti nodi del grafo
     *
     * @param startingNode indice del nodo iniziale
     * @return distanze da tutti i restanti nodi
     */
    public double[] dijkstra(int startingNode) {

        double[] dist = new double[grafo.nodi.size()];
        boolean[] reach = new boolean[grafo.nodi.size()];

        for (int i = 0; i < grafo.nodi.size(); i++) {
            dist[i] = Double.POSITIVE_INFINITY;
            reach[i] = false;
        }

        dist[startingNode] = 0.0;
        int current = startingNode;

        while (current != -1) {
            reach[current] = true;
            Iterator<Arco> itAd = grafo.nodi.get(current).iterator();

            while (itAd.hasNext()) {

                Arco a = itAd.next();
                if (!reach[a.endingNode.indice]) {
                    double nuovaDist = dist[current] + a.weight;
                    if (nuovaDist < dist[a.endingNode.indice])
                        dist[a.endingNode.indice] = nuovaDist;
                }

            }

            current = -1;
            double minPeso = Double.POSITIVE_INFINITY;

            for (int i = 0; i < grafo.nodi.size() ; i++)
                if (!reach[i] && dist[i] < minPeso) {
                    current = i;
                    minPeso = dist[i];
                }
        }

        return dist;

    }
}

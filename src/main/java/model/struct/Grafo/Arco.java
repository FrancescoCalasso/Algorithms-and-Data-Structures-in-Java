package model.struct.Grafo;

/**
  * Questa classe rappresenta un arco del grafo
  */

public class Arco {

  public Nodo startingNode, endingNode;
  public int weight;

  /**
   * Costruttore con tre parametri
   *
   * @param start nodo iniziale
   * @param end nodo finale
   * @param w peso dell'acro
   */
  public Arco(Nodo start, Nodo end, int w) {
    startingNode = start;
    endingNode = end;
    weight = w;
  }

}

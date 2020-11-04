package model.struct.Grafo;

/**
  * Questa classe rappresenta un arco del grafo
  */

public class Arco {

  public Object startingNode, endingNode;
  public Object weight;

  /**
   * Costruttore con tre parametri
   *
   * @param start nodo iniziale
   * @param end nodo finale
   * @param w peso dell'acro
   */
  public Arco(Object start, Object end, Object w) {
    startingNode = start;
    endingNode = end;
    weight = w;
  }

}

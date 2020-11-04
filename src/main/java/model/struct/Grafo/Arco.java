package model.struct.Grafo;

/**
  * La classe arco serve per rappresentare un arco del grafo
  */

public class Arco {

  public Object startingNode, endingNode;
  public Object value;

  /**
   * Costruttore con tre argomenti
   *
   * @param x1 primo nodo
   * @param y1 secondo nodo
   * @param v valore
   */
  public Arco(Object x1, Object y1, Object v) {
    startingNode = x1;
    endingNode = y1;
    value = v;
  }

}

package model.struct.Grafo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
  * La classe Grafo rappresenta un grafo mediante liste di adiacenza.
  * In particolare si e' voluto dare un'implementazione che utilizzasse classi
  * standard di java.util.
  * Di conseguenza:
  * 1. la lista dei nodi e' rappresentata da una HashMap per poter accedere al
  * nodo node1 in tempo costante
  * 2. la lista dei nodi adiacenti e' rappresentata da un HashSet di archi, in
  * modo tale da poter verificare/accedere al nodo adiacente in tempo costante.
  * Anziche' rappresentare il nodo adiacente e il peso dell'arco si e' preferito
  * rappresentare l'arco completo.
  *
  */
public class Grafo {
  HashMap<Object,Set<Arco>> nodi;
  int nArchi;

  /**
   * Costruttore senza argomenti
   */
  public Grafo() {
    nodi = new HashMap<Object,Set<Arco>>();
    nArchi = 0;
  }

  /**
   * restituisce il numero di nodi 
   * 
   * @return il numero di nodi
   */
  public int nodesNumber() {
    return nodi.size();
  }

  /**
   * Restituisce il numero di archi
   * 
   * @return il numero di archi
   */
  public int edgesNumber() {
    return nArchi;
  }

  
  /**
   * aggiunge un nodo al grafo con valore x se x non e' presente nel grafo, nulla altrimenti
   * L'aggiunta di un nodo significa aggiungere la coppia (x, lista) nella HashMap
   * dove lista e' una HashSet vuota.
   * 
   * @param x il nodo da aggiungere
   */
  public void add(Object x) {
    if (!nodi.containsKey(x)) {
      Set<Arco> lista = new HashSet<Arco>();
      nodi.put(x,lista);
    }
  }

  /**
   * rimuove il nodo x dal grafo se x e' presente nel grafo, 
   * altrimenti non modifica il grafo.
   * 
   * @param x il nodo da rimuovere
   */
  public void remove(Object x) {
    if (nodi.containsKey(x)) {
      Iterator<Arco> arcoIncidenteI = ( (HashSet<Arco>) nodi.get(x) ).iterator();
      Arco a;
      Object y;
      while (arcoIncidenteI.hasNext()) {
        a = arcoIncidenteI.next();
        y = ( a.getNode1().equals(x) ) ? a.getNode2() : a.getNode1();
        if ( ((HashSet) nodi.get(y)).remove(a) )
          nArchi--;
      }
      nodi.remove(x);
    }
  }


  /**
   * aggiunge un arco tra i nodi x e y se tale arco non e' gia' presente e restituisce true, 
   * altrimenti non modifica il grafo e restituisce false. 
   * 
   * @param x primo nodo dell'arco
   * @param y secondo nodo dell'arvo
   * @param value valore dell'arco
   * @return vero se l'arco e' stato rimosso false altrimenti
   */
  public boolean add(Object x, Object y, Object value) {
    boolean flag = false, flag1 = false;
    if (!nodi.containsKey(x))
      add(x);
    if (!nodi.containsKey(y))
      add(y);
    Arco a = new Arco(x,y,value);
    flag = (nodi.get(x) ).add(a);
    flag1 =(nodi.get(y) ).add(a);
    flag = flag && flag1;
    if (flag)
      nArchi++;
    return flag;
  }

  /**
   * Aggiunge l'arco a al grafo se l'arco non e' presente e restituisce true,
   * altrimenti non modifica il grafo e restituisce false
   * 
   * @param a l'arco da aggiungere
   * @return true se l'arco e' stato aggiunto, false altrimenti
   */
  public boolean add(Arco a) {
    return add(a.getNode1(),a.getNode2(),a.getValue());
  }

  /**
   * Rimuove l'arco tra i nodi x e y se tale arco e' presente e restituisce true, 
   * altrimenti non modifica il grafo e restituisce false. 
   * 
   * @param x primo nodo dell'arco
   * @param y secondo nodo dell'arvo
   * @param value valore dell'arco
   * @return vero se l'arco e' stato rimosso false altrimenti
   */
  public boolean remove(Object x, Object y, Object value) {
    Arco a = new Arco(x,y,value);
    return remove(a);
  }

  /**
   * Rimuove l'arco a dal grafo se l'arco e' presente e restituisce true,
   * altrimenti non modifica il grafo e restituisce false
   * 
   * @param a l'arco da aggiungere
   * @return true se l'arco e' stato rimosso, false altrimenti
   */
  public boolean remove(Arco a) {
    boolean flag = false,  flag1 = false;
    if (nodi.containsKey(a.getNode1()) && nodi.containsKey(a.getNode2())) {
      flag = ( (HashSet) nodi.get(a.getNode1()) ).remove(a);
      flag1 = ( (HashSet) nodi.get(a.getNode2()) ).remove(a);
    }
    return flag || flag1;
  }

  /**
   * Restituisce l'insieme degli archi presenti nel grafo
   * 
   * @return l'insieme di archi presenti nel grafo
   */
  public Set<Arco> getEdgeSet() {
    Set<Arco> setArchi = new HashSet<Arco>();
    Iterator<Set<Arco>> hashSetI = nodi.values().iterator();
    while (hashSetI.hasNext())
      setArchi.addAll(hashSetI.next());
    return setArchi;
  }

  /**
   * Restituisce l'insieme di archi incidenti sul nodo nodo,
   * se nodo e' presente nel grafo, null altrimenti 
   * 
   * @param nodo nodo di cui si vuole conoscere l'insieme di archi incidenti
   * @return l'insieme di archi incidenti sul nodo nodo, 
   * se nodo e' presente nel grafo null altrimenti
   */
  public Set<Arco> getEdgeSet(Object nodo) {
    if (nodi.containsKey(nodo)) //se il nodo e' presente nel grafo
      return nodi.get(nodo);
    else
      return null;
  }

  /**
   * Restituisce l'insieme di nodi del grafo
   * 
   * @return l'insieme di nodi del grafo
   */
  public Set<Object> getNodeSet() {
    return nodi.keySet();
  }

  public String toString() {
    StringBuffer out = new StringBuffer();
    Object nodo;
    Arco a;
    Iterator<Arco> arcoI;
    Iterator<Object> nodoI = nodi.keySet().iterator();
    while (nodoI.hasNext()) {
      arcoI = nodi.get( nodo = nodoI.next() ).iterator();
      out.append("Nodo " + nodo.toString() + ": ");
      while (arcoI.hasNext()) {
        a = arcoI.next();
        //out.append( ((a.x == nodo ) ? a.y.toString() : a.x.toString()) + "("+a.value.toString()+"), ");
        out.append(a.toString()+", ");
      }
      out.append("\n");
    }
    return out.toString();
  }

  /**
   * Visita il grafo g in ampieza partendo dal nodo startingNode,
   * visita anche componenti non connesse del grafo
   *
   * @param startingNode nodo da cui iniziare la visita
   */
  public void visitaBFS(Object startingNode) {
    Queue<Object> q = new LinkedList<Object>();
    Set<Object> nodes = new HashSet<Object>(this.getNodeSet());

    q.add(startingNode);
    nodes.remove(startingNode);

    for (Iterator<Object> itm = this.getNodeSet().iterator(); itm.hasNext();) {

      while(!q.isEmpty()){
        Object node = q.poll();
        visit(node);
        Set<Arco> adjEdges = this.getEdgeSet(node);
        for (Iterator<Arco> iterator = adjEdges.iterator(); iterator
                .hasNext();) {
          Arco a = iterator.next();
          if (nodes.contains(a.getNode1())){
            q.add(a.getNode1());
            nodes.remove(a.getNode1());
          }
          if (nodes.contains(a.getNode2())){
            q.add(a.getNode2());
            nodes.remove(a.getNode2());
          }
        }
      }

      Object nextStartingNode = itm.next();
      if(nodes.contains(nextStartingNode)){
        startingNode = nextStartingNode;
        nodes.remove(startingNode);
        q.add(startingNode);
      }


    }


  }

  /**
   * Visita il grafo g in profondita' iniziando dal nodo startingNode,
   * visita anche componenti non connesse del grafo
   *
   * @param startingNode nodo da cui inizia la visita
   */
  public void visitaDFS(Object startingNode) {
    Set<Object> nodes = new HashSet<Object>(this.getNodeSet());
    Object node = startingNode;
    dfs(node,nodes);
    while(!nodes.isEmpty()){
      node = nodes.iterator().next();
      dfs(node,nodes);
    }
  }

  /**
   * Esegue una visita ricorsiva del grafo g partendo dal nodo next
   * ed utilizzando come marcatura nodes
   *
   * @param next nodo da cui iniziare la visita ricorsiva
   * @param nodes marcatura
   */
  private void dfs(Object next, Set nodes) {
    visit(next);
    nodes.remove(next);
    Set<Arco> adjEdges = this.getEdgeSet(next);
    Iterator<Arco> it = adjEdges.iterator();
    while(it.hasNext()){
      Arco a = it.next();
      if (nodes.contains(a.getNode1())){
        dfs(a.getNode1(),nodes);
      }
      if (nodes.contains(a.getNode2())){
        dfs(a.getNode2(),nodes);
      }
    }
  }

  /**
   * visita il nodo node, la visita esegue la stampa del nodo
   *
   * @param node nodo da visitare
   */
  private static void visit(Object node) {
    System.out.println(node);
  }

  public void showHistory() throws IOException {

    FileReader f;
    f = new FileReader("src/main/resources/dijkstrafloyd.txt");

    BufferedReader b;
    b = new BufferedReader(f);

    String s;

    while (true) {

      s = b.readLine();
      if (s == null)
        break;
      System.out.println(s);

    }

  }


}

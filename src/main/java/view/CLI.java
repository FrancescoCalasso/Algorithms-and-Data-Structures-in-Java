package view;

import controller.Controller;
import model.algorithm.InsertionSort.InsertionSort;
import model.struct.Heap.MaxHeap;
import model.algorithm.Mergesort.MergeSort;
import model.algorithm.QuickSort.QuickSort;
import model.struct.Grafo.Grafo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CLI implements ViewInterface {

    private Scanner in = new Scanner(System.in);

    private int[] array;
    private Grafo graph;

    Controller controller;

    public CLI(Controller controller) {

        this.controller = controller;

    }

    public void onStart() throws IOException {

        System.out.println("    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("    ┃                BENVENUTO               ┃");
        System.out.println("    ┠────────────────────────────────────────┨");
        System.out.println("    ┃  Cosa vuoi fare?                       ┃");
        System.out.println("    ┃  1 - ALGORITMI DI ORDINAMENTO          ┃");
        System.out.println("    ┃  2 - STRUTTURE DATI                    ┃");
        System.out.println("    ┃  3 - USA UN ALGORITMO                  ┃");
        System.out.println("    ┃  4 - ESCI                              ┃");
        System.out.println("    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.println();

        switch(in.nextInt()) {

            case 1:
                onAlgoOrd();
                break;
            case 2:
                onStruct();
                break;
            case 3:
                onAlgoUse();
                break;
            case 4:
                break;

        }

    }

    public void onAlgoUse() throws IOException {

        System.out.println("\nPer favore inserisci la dimensione dell'array che vuoi ordinare:\n");

        int size = in.nextInt();

        System.out.println("\nOk, il tuo array sarà di " + size + " elementi.\n");

        array = new int[size];

        for(int i = 0; i < size; i++) {

            System.out.print("Inserisci il " + (i + 1) + "o numero:  ");
            array[i] = in.nextInt();

        }

        printArray(array);
        onAlgoChoice();

    }

    public void onStruct() throws IOException {

        System.out.println("    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("    ┃             STRUTTURE DATI             ┃");
        System.out.println("    ┠────────────────────────────────────────┨");
        System.out.println("    ┃                                        ┃");
        System.out.println("    ┃  1 - Albero di ricerca binario         ┃");
        System.out.println("    ┃  2 - Albero Rosso - Nero               ┃");
        System.out.println("    ┃  3 - Grafo                             ┃");
        System.out.println("    ┃  4 - Tabella di hash                   ┃");
        System.out.println("    ┃                                        ┃");
        System.out.println("    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.println();

        switch(in.nextInt()) {

            case 1:
                TreePrinter.print(controller.createBST().getRoot());
                onVisitBST();
                onRestart();
                break;
            case 2:
                controller.showHistory(new MaxHeap());
                onRestart();
                break;
            case 3:
                printGraph(controller.createGraph());
                controller.showGraphHistory();
                onVisitGraph();
                onRestart();
                break;
            case 4:
                controller.showHistory(new MergeSort());
                onRestart();
                break;

        }

    }

    public void onAlgoOrd() throws IOException {

        System.out.println("    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("    ┃        ALGORITMI DI ORDINAMENTO        ┃");
        System.out.println("    ┠────────────────────────────────────────┨");
        System.out.println("    ┃                                        ┃");
        System.out.println("    ┃  1 - Insertion sort                    ┃");
        System.out.println("    ┃  2 - Heapsort                          ┃");
        System.out.println("    ┃  3 - Quicksort                         ┃");
        System.out.println("    ┃  4 - Mergesort                         ┃");
        System.out.println("    ┃                                        ┃");
        System.out.println("    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.println();

        switch(in.nextInt()) {

            case 1:
                controller.showHistory(new InsertionSort());
                onRestart();
                break;
            case 2:
                controller.showHistory(new MaxHeap());
                onRestart();
                break;
            case 3:
                controller.showHistory(new QuickSort());
                onRestart();
                break;
            case 4:
                controller.showHistory(new MergeSort());
                onRestart();
                break;

        }

    }

    public void onAlgoChoice() throws IOException {

        System.out.println("    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("    ┃        ALGORITMI DI ORDINAMENTO        ┃");
        System.out.println("    ┠────────────────────────────────────────┨");
        System.out.println("    ┃                                        ┃");
        System.out.println("    ┃  Quale vuoi usare?                     ┃");
        System.out.println("    ┃  1 - Insertion sort                    ┃");
        System.out.println("    ┃  2 - Heapsort                          ┃");
        System.out.println("    ┃  3 - Quicksort                         ┃");
        System.out.println("    ┃  4 - Mergesort                         ┃");
        System.out.println("    ┃                                        ┃");
        System.out.println("    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.println();

        int choice = in.nextInt();

        switch (choice) {

            case 1:
                printArray(controller.useAlgorithm(new InsertionSort(), array));
                onRestart();
                break;
            case 2:
                printArray(controller.useAlgorithm(new MaxHeap(), array));
                onRestart();
                break;
            case 3:
                printArray(controller.useAlgorithm(new QuickSort(), array));
                onRestart();
                break;
            case 4:
                printArray(controller.useAlgorithm(new MergeSort(), array));
                onRestart();
                break;

        }

    }

    public void onError(Exception e) {
        System.out.println("    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("    ┃                ERRORE               ┃");
        System.out.println("    ┠─────────────────────────────────────┨");
        System.out.println("    ┃  Si è  verificato  un  errore.      ┃");
        System.out.println("    ┃  L'applicazione  si spegnerà.       ┃");
        System.out.println("    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.println();
    }

    public void printArray(int[] arr) {

        System.out.println("\nL'array è:");
        System.out.println();

        for(int i = 0; i < arr.length; i++) {

            if(array[i] < 10) {

                System.out.println("    ┏━━━┓ ");
                System.out.println("    ┃ " + array[i] + " ┃ ");
                System.out.println("    ┗━━━┛ ");

            } else {

                System.out.println("    ┏━━━┓ ");
                System.out.println("    ┃" + array[i] + " ┃ ");
                System.out.println("    ┗━━━┛ ");

            }
        }

    }

    public void onRestart() throws IOException {

        System.out.println();
        System.out.println("    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("    ┃  Desideri altro?                    ┃");
        System.out.println("    ┃                                     ┃");
        System.out.println("    ┃  1. Torna alla home                 ┃");
        System.out.println("    ┃  2. Esci                            ┃");
        System.out.println("    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        switch(in.nextInt()) {

            case 1:
                onStart();
                break;
            case 2:
                break;
        }

    }

    public void printGraph(Grafo g) {

        System.out.println("Utilizziamo un grafo di esempio:\n" + g);
        System.out.println("L'insieme degli archi e': " + g.getEdgeSet());


        System.out.println("Rimuoviamo il nodo 'a' dal grafo");
        controller.removeGraphNode("a");
        System.out.println("Il grafo (nodo 'a' rimosso) e':\n" + g);

        System.out.println("Aggiungiamo l'arco <e,k> al grafo\n");
        controller.addGraphArch("e","k",0);
        System.out.println("Il grafo (arco <e,k> aggiunto) e':\n" + g);

    }

    public void onVisitBST() {

        System.out.println();
        System.out.println("    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("    ┃  VISITE - BST                       ┃");
        System.out.println("    ┃                                     ┃");
        System.out.println("    ┃  1. AMPIEZZA                        ┃");
        System.out.println("    ┃  2. ORDINE                          ┃");
        System.out.println("    ┃  3. PREORDINE                       ┃");
        System.out.println("    ┃  4. POSTORDINE                      ┃");
        System.out.println("    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.println();

        switch(in.nextInt()) {

            case 1:
                controller.visitaBSTAmpiezza();
                printVisit(controller.getVisit());
                break;
            case 2:
                controller.visitaBSTOrdine();
                printVisit(controller.getVisit());
                break;
            case 3:
                controller.visitaBSTPreOrdine();
                printVisit(controller.getVisit());
                break;
            case 4:
                controller.visitaBSTPostOrdine();
                printVisit(controller.getVisit());
                break;

        }

    }

    public void onVisitGraph() {

        System.out.println();
        System.out.println();
        System.out.println("    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("    ┃  Vuoi visitare il grafo?            ┃");
        System.out.println("    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        if(in.next().equals("yes") || in.next().equals("Yes") || in.next().equals("YES")) {

            System.out.println("    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("    ┃  VISITE - GRAPH                     ┃");
            System.out.println("    ┃                                     ┃");
            System.out.println("    ┃  1. AMPIEZZA                        ┃");
            System.out.println("    ┃  2. PROFONDITA'                     ┃");
            System.out.println("    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

            switch (in.nextInt()) {

                case 1:
                    controller.visitaGraphAmpiezza();
                    break;
                case 2:
                    controller.visitaGraphProfondita();
                    break;

            }

        }

    }

    public void printVisit(ArrayList<Integer> visits) {

        System.out.println("\nLa visita è:");
        System.out.println();

        for(int i = 0; i < visits.size(); i++) {

            if(visits.get(i) < 10) {

                System.out.println("    ┏━━━┓ ");
                System.out.println("    ┃ " + visits.get(i) + " ┃ ");
                System.out.println("    ┗━━━┛ ");

            } else {

                System.out.println("    ┏━━━┓ ");
                System.out.println("    ┃" + visits.get(i) + " ┃ ");
                System.out.println("    ┗━━━┛ ");

            }
        }

    }

}

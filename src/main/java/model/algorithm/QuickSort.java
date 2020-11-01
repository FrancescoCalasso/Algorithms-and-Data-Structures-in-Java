package model.algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Java program for implementation of QuickSort
public class QuickSort implements Algorithm {

    int[] sortedArray;
    private long totalTime;
    TimeAnalysis timeAnalysis;

    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;

    }


    /* The main function that implements MergeSort.QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    public void quickSort(int[] arr, int low, int high) {

        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }

        sortedArray = arr.clone();

    }

    // Adapter for quickSort
    @Override
    public int[] sort(int[] arr) {

        int l = 0;
        int r = arr.length - 1;
        quickSort(arr, l, r);

        return sortedArray;

    }

    @Override
    public void showHistory() throws IOException {

        FileReader f;
        f = new FileReader("src/main/resources/quicksort.txt");

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

    @Override
    public void setTotalTime(long totalTime) {
        this.totalTime = totalTime;
    }

    @Override
    public long getTotalTime(int[] array) {

        long time = System.nanoTime();
        sort(array);
        time = System.nanoTime() - time;

        setTotalTime(time);
        return totalTime;

    }


}
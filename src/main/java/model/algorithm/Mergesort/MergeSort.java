package model.algorithm.Mergesort;

import model.algorithm.Algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* Java program for Merge Sort */
public class MergeSort implements Algorithm {

    private int[] sortedArray;
    private long totalTime;

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    public void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    public void mergeSort(int[] arr, int l, int r) {

        if (l < r) {

            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);

        }

        sortedArray = arr.clone();

    }

    // Adapter for mergeSort
    @Override
    public int[] sort(int[] arr) {

        int l = 0;
        int r = arr.length - 1;
        mergeSort(arr, l, r);

        return sortedArray;

    }

    @Override
    public void showHistory() throws IOException {

        FileReader f;
        f = new FileReader("src/main/resources/mergesort.txt");

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
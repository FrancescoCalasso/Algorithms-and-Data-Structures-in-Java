package model.algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InsertionSort implements Algorithm {

    private long totalTime;

    @Override
    public int[] sort(int[] arr) {

        for (int i = 1; i <= arr.length - 1; i++) {

            int j = i - 1;
            int key = arr[i];

            while (j >= 0 && arr[j] > key) {

                arr[j + 1] = arr[j];
                j--;

            }

            arr[j + 1] = key;

        }

        return arr.clone();

    }

    @Override
    public void showHistory() throws IOException {

        FileReader f;
        f = new FileReader("src/main/resources/insertionsort.txt");

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
    public void setTotalTime(long time) {

        this.totalTime = time;

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

package model.algorithm;

import java.io.IOException;

public interface Algorithm {

    int[] sort(int[] array);

    void showHistory() throws IOException;

    void setTotalTime(long time);

    long getTotalTime(int[] array);

}

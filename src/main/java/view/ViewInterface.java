package view;

import java.io.IOException;

public interface ViewInterface {

    void onStart() throws IOException;

    void onAlgoUse() throws IOException;

    void onStruct() throws IOException;

    void onAlgoOrd() throws IOException;

    void onAlgoChoice() throws IOException;

    void onError(Exception e);

    void printArray(int[] arr);

    void onRestart() throws IOException;

}

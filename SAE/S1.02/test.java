import java.io.*;
import java.util.*;
class NomDeVotreProgramme extends Data {
void triSelection2D(int[][] t) {
    for (int i = 0; i < t.length; i++) { // pour chaque ligne
        for (int j = 0; j < t[i].length - 1; j++) {

            int minIndex = j;

            for (int k = j + 1; k < t[i].length; k++) {
                if (t[i][k] < t[i][minIndex]) {
                    minIndex = k;
                }
            }

            int tmp = t[i][j];
            t[i][j] = t[i][minIndex];
            t[i][minIndex] = tmp;
        }
    }
}
    for(int i = 0,)
    public static void main(String[] args) {
        new NomDuProgramme().run();
    }
}

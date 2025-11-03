import java.io.*;
import java.util.*;

class NomDuProgramme {
    Scanner in = new Scanner(System.in);
    
    void run() {
        /*int N = 4;
        int [] tab = new int[N];
        int tmp;
        for (int i = 0; i < tab.length ; i ++){
            for (int j = 0; j<tab[i];j++){
                if (tab[j]>tab[j+1]){
                    tmp = tab[j];
                    tab[j] = tab[j+1];
                    tab[j+1] = tmp;
                }
            }
        }*/

        int[] tab = {5, 2, 4, 1, 3};
        int tmp;

        for (int i = 0; i<tab.length -1;i++){
            for (int j = 0; j< tab.length;j++) {
                if (tab[i]>tab[j+1]){
                    tmp = tab[i];
                    tab[i] = tab[j+1];
                    tab[j+1] = tmp;
                }
            }
            System.out.print("Après le passage " + (i + 1) + " : ");
            for (int p = 0; p < tab.length; p++) {
                System.out.print(tab[p] + " ");
            }
            System.out.println();
        }
        







    }

    public static void main(String[] args) {  
        new NomDuProgramme().run();
    }
}
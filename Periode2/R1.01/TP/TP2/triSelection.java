import java.io.*;
import java.util.*;


    class TriSelection{
        int rechercheIndex(int[]tab, int v){
            if (v == tab.length) {
                return -1;
            }
            int indiceMIN=v;
            for (int i=v+1; i<tab.length; i++){
                if (tab[i]<tab[indiceMIN]){
                    indiceMIN=i;
                }
            }
        return indiceMIN;
    }

    void permuter (int[]tab, int i1, int i2){
        int tmp=tab[i1];
        tab[i1]=tab[i2];
        tab[i2]=tmp;
    }

    void triParSelection (int[]tab) {
        for (int i=0; i<tab.length; i++){
            int IndexMIN=rechercheIndex(tab, i);
            permuter(tab, i, IndexMIN);
        }
        System.out.print("{");
        for (int i=0; i<tab.length; i++) {
            System.out.print(tab[i]+",");
        }
        System.out.println("}");
    }

    void run() {

        int[]tab={5,-1,4,-9,2,5,7,0};
        triParSelection(tab);

}

            public static void main(String[] args) {  
        new TriSelection().run();
    }
}
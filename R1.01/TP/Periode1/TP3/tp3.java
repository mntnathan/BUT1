import java.io.*;
import java.util.*;

class NomDuProgramme {
    Scanner in = new Scanner(System.in);
    
    void run() {
        //Exercice 1
        
        /*int[] tab = {4, 7, 3, 8, 2, 8};
        for(int i = 0; i < tab.length;i ++) {
            System.out.print(tab[i]);
            if(i<tab.length -1) {
                System.out.print(", ");
            }
        }*/

        //Exercice 2

        /*int N = 10;
        int [] tab = new int[N];
        for (int i = 0; i < N;i++) {
            System.out.println("Entrez un entier");
            tab[i]=in.nextInt(); 
        }*/

        //Exercice 3

        /*int N = 7;
        double [] tab = new double[N];
        double avg = 0;
        for (int i = 0; i < N;i++) {
            System.out.println("Entrez un entier");
            tab[i]=in.nextDouble();
            avg += tab[i]; 
        }
        System.out.println("Le moyenne est de : " + avg/tab.length);*/

        //Exercice 4

        /*int N = 10;
        int [] tab = new int[N];
        int [] tab1 = new int[N];
        for (int i = 0; i < N;i++) {
            System.out.println("Entrez un entier");
            tab[i]=in.nextInt();
            tab1[N-1-i] = tab[i];
        }
        for(int i = 0; i < tab.length;i ++) {
            System.out.print(tab[i]);
            if(i<tab.length -1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        for(int o = 0; o < tab1.length;o ++) {
            System.out.print(tab1[o]);
            if(o<tab1.length -1) {
                System.out.print(", ");
            }
        }
        System.out.println();*/

        //Exerice 5

        /*final int N = 7;
        int v = 1;  
        int[] tab = new int[N];

        for (int i = 0; i < N; i++) {
            System.out.println("Entrez un entier");
            tab[i] = in.nextInt();
        }

        int compteur = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == v) {
                compteur++;
            }
        }

        System.out.println("Le nombre d'occurrences de " + v + " est : " + compteur);*/

        //Exercice 6

        /*final int N = 7; 
        int[] tab = new int[N];
        for (int i = 0; i < N; i++) {
            System.out.println("Entrez un entier");
            tab[i] = in.nextInt();
        }
        int min = tab[0];
        int indice = 0;

        for(int i =0; i< tab.length;i++) {
            if(tab[i]<min){
                min=tab[i];
                indice = i;
            }
        }
        System.out.println("Le nombre le plus petit est : " + min + " et son indice est : "+indice);*/

        //Exercice 7

        /*final int N = 4; 
        int[] tab = new int[N];
        int tmp,min,indice ;
        for (int i = 0; i < N; i++) {
            System.out.println("Entrez un entier");
            tab[i] = in.nextInt();
        }

        for (int j = 0; j< N ;j ++){
            min = tab[j];
            indice = j;
            for(int i = j; i< tab.length;i++) {
                if(tab[i]<min){
                    min=tab[i];
                    indice = i;
                }
            }
            tmp = tab[j];
            tab[j] = tab[indice];
            tab[indice] = tmp;
        }

        for(int i = 0; i < tab.length;i ++) {
            System.out.print(tab[i]);
            if(i<tab.length -1) {
                System.out.print(", ");
            }
        }*/

        //Exercice 8

        /*final int N = 10; 
        int[] tab = new int[N];

        tab[0] = 20;
        tab[1] = 15;
        tab[2] = 12;
        tab[3] = 10;
        int t = 4; 

        System.out.print("Entrez l'entier à insérer : ");
        int e = in.nextInt();
        int i = t - 1;
        while (i >= 0 && tab[i] < e) {
            tab[i + 1] = tab[i];
            i--;
        }
        tab[i + 1] = e;
        t++;
        
        System.out.print("Tableau après insertion : ");
        for (int j = 0; j < t; j++) {
            System.out.print(tab[j] + " ");
        }*/
        
        

        //L'EXERCICE 9 

        /*final int N = 4; 
        int[] tab = new int[N];
        int tmp ;
        for (int i = 0; i < N ; i++) {
            System.out.println("Entrez un entier");
            tab[i] = in.nextInt();
        }
        for (int i = 0 ; i < tab.length; i++) {
        int pos = 0;
        while (pos < i && tab[pos] < tab[i]) {
        pos = pos + 1; 
        }
        tmp = tab[i];
        for (int j = i-1; j >= pos; j--) {
        tab[j+1] = tab[j];
        }
        tab[pos] = tmp;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(tab[i]);
            if (i < N - 1) {
                System.out.print(", ");
            }
        }*/


        //Exercice 10

        /*final int N = 10; 
        int[] tab = new int[N];
        for (int i = 0; i < N - 2; i++) {
            System.out.println("Entrez un entier");
            tab[i] = in.nextInt();
        }

        boolean estTrie ;
        int tmp ;

        do{
            estTrie = true;
            for (int i = 0; i < tab.length - 1;i ++ ) {
                if (tab[i]<tab[i+1]) {
                    estTrie = false;
        t2[o] = t[i - 1 - o];
                    tmp = tab[i];
                    tab[i] = tab[i+1];
                    tab[i+1] = tmp;
                }
            }
        }while(!estTrie);

        System.out.println("Tableau trié en ordre décroissant :");
        for (int i = 0; i < N - 2; i++) {
            System.out.print(tab[i] + " ");
        }*/

        //Exercice 13

        /*final int N = 10;
        int b = 2;
        int n = 150;
        int r ;
        int i =0;
        int [] t = new int[N];
        int [] t2 = new int[N];

        do {
            r = n%b;
            n=n/b;
            t[i] = r;
            i+=1;
        
        }while(n!=0);
        for (int o = 0; o < i; o++) {
            System.out.print(t[o] + " ");
        }

        for (int o = 0; o < i; o++) {
        t2[o] = t[i - 1 - o];
        }

        System.out.println();

        for (int o = 0; o < i; o++) {
            System.out.print(t2[o] + " ");
        }*/

        //Exercice 14

        /*final int N = 16; 
        int b = 2;
        int somme = 0;
        int n;
        int[] t = new int[N];
        for (int i = 0; i < N ; i++) {
            System.out.println("Entrez un entier (0,1)");
            t[i] = in.nextInt();
        }

        for(int i = 0; i < t.length;i ++) {
            System.out.print(t[i]);
            if(i<t.length -1) {
                System.out.print(" ");
            }
        }
        for (int i = 0; i < t.length; i++) {
            int o = N - 1 - i;  
            somme += t[i] * (int) Math.pow(b, o);
        }
        n = somme ; 

        System.out.println();

        System.out.println("le resultat est : " + n);

        System.out.println();*/

        //Exercice 15

        /*final int N = 4;
        int[] x = new int[N];
        int[] y = new int[N];
        int[] r = new int[2 * N];  
        int sommeX = 0;
        int sommeY = 0;
        int base;

        for (int i = 0; i < N; i++) {
            System.out.print("Entrez bit x (0 ou 1): ");
            x[i] = in.nextInt();
            while (x[i] != 0 && x[i] != 1) {
                System.out.print("Erreur, entrez 0 ou 1: ");
                x[i] = in.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print("Entrez bit y (0 ou 1): ");
            y[i] = in.nextInt();
            while (y[i] != 0 && y[i] != 1) {
                System.out.print("Erreur, entrez 0 ou 1: ");
                y[i] = in.nextInt();
            }
        }

        System.out.print("Entrez la base (exemple 2 pour binaire): ");
        base = in.nextInt();

        for (int i = 0; i < N; i++) {
            int exposant = N - 1 - i;
            sommeX += x[i] * (int) Math.pow(base, exposant);
            sommeY += y[i] * (int) Math.pow(base, exposant);
        }

        int somme = sommeX + sommeY;
        System.out.println("Somme décimale: " + somme);

        int q = 0;
        if (somme == 0) {
            r[q++] = 0;
        } else {
            int temp = somme;
            while (temp > 0) {
                r[q++] = temp % base;
                temp /= base;
            }
        }

        for (int i = 0; i < q / 2; i++) {
            int tmp = r[i];
            r[i] = r[q - 1 - i];
            r[q - 1 - i] = tmp;
        }

        System.out.print("Somme en base " + base + ": ");
        for (int i = 0; i < q; i++) {
            System.out.print(r[i]);
        }
        System.out.println();  */
        
        
        //Exercice 16

        /*final int N = 4;
        int[] x = new int[N];
        int[] y = new int[N];
        int[] r = new int[2 * N];  
        int sommeX = 0;
        int sommeY = 0;
        int base;

        for (int i = 0; i < N; i++) {
            System.out.print("Entrez bit x (0 ou 1): ");
            x[i] = in.nextInt();
            while (x[i] != 0 && x[i] != 1) {
                System.out.print("Erreur, entrez 0 ou 1: ");
                x[i] = in.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print("Entrez bit y (0 ou 1): ");
            y[i] = in.nextInt();
            while (y[i] != 0 && y[i] != 1) {
                System.out.print("Erreur, entrez 0 ou 1: ");
                y[i] = in.nextInt();
            }
        }

        System.out.print("Entrez la base (exemple 2 pour binaire): ");
        base = in.nextInt();

        for (int i = 0; i < N; i++) {
            int exposant = N - 1 - i;
            sommeX += x[i] * (int) Math.pow(base, exposant);
            sommeY += y[i] * (int) Math.pow(base, exposant);
        }

        int somme = sommeX * sommeY;
        System.out.println("Somme décimale: " + somme);

        int q = 0;
        if (somme == 0) {
            r[q++] = 0;
        } else {
            int temp = somme;
            while (temp > 0) {
                r[q++] = temp % base;
                temp /= base;
            }
        }

        for (int i = 0; i < q / 2; i++) {
            int tmp = r[i];
            r[i] = r[q - 1 - i];
            r[q - 1 - i] = tmp;
        }

        System.out.print("Somme en base " + base + ": ");
        for (int i = 0; i < q; i++) {
            System.out.print(r[i]);
        }
        System.out.println();*/

        //Exercice 17

        /*final int N = 5;
        int[] tab = {3, 0, 1, -5, 0, 0};
        int[] tab1 = {3, 0, 1, -5, 8, 0};
        int[] tab2 = new int[tab.length]; 

        for (int i = 0; i < tab.length; i++) {
            if (tab[i] != 0) {
                if (i == 0) {
                    System.out.print(tab[i] + " ");
                } else {
                    if (tab[i] > 0) {
                        System.out.print("+ " + tab[i] + "*x^" + i + " ");
                    } else {
                        System.out.print(tab[i] + "*x^" + i + " ");
                    }
                }
            }
        }*/

        //Exercice 18

        /*final int N = 5;
        int[] tab = {3, 0, 1, -5, 0, 0};
        int[] tab1 = {3, 0, 1, -5, 8, 0};
        int[] tab2 = new int[tab.length]; 

        for (int i = 0; i < tab.length; i++) {
            if (tab[i] != 0) {
                if (i == 0) {
                    System.out.print(tab[i] + " ");
                } else {
                    if (tab[i] > 0) {
                        System.out.print("+ " + tab[i] + "*x^" + i + " ");
                    } else {
                        System.out.print(tab[i] + "*x^" + i + " ");
                    }
                }
            }
        }

        System.out.println();

        for (int i = 0; i < tab1.length; i++) {
            if (tab1[i] != 0) {
                if (i == 0) {
                    System.out.print(tab1[i] + " ");
                } else {
                    if (tab1[i] > 0) {
                        System.out.print("+ " + tab1[i] + "*x^" + i + " ");
                    } else {
                        System.out.print(tab1[i] + "*x^" + i + " ");
                    }
                }
            }
        }

        System.out.println();

        for (int i = 0; i < tab.length; i++) { 
            tab2[i] = tab[i] + tab1[i];
        }

        for (int i = 0; i < tab2.length; i++) {
            if (tab2[i] != 0) {
                if (i == 0) {
                    System.out.print(tab2[i] + " ");
                } else {
                    if (tab2[i] > 0) {
                        System.out.print("+ " + tab2[i] + "*x^" + i + " ");
                    } else {
                        System.out.print(tab2[i] + "*x^" + i + " ");
                    }
                }
            }
        }*/

        //Exercice 19
        
        /*Scanner in = new Scanner(System.in);
        System.out.println("Quel est la valeur de x :");
        int x = in.nextInt();

        double somme = 0; 
        int[] tab = {3, 0, 1, -5, 0, 0};

        for (int i = 0; i < tab.length; i++) {
            somme += tab[i] * Math.pow(x, i);
        }
        
        System.out.println(somme);*/

        //Exercice 20

        /*int[] tab = {3, 0, 1, -5, 0, 0};
        int[] tabD = new int[tab.length]; 

        for (int i = 0; i < tab.length; i++) {
            tabD[i] = i * tab[i];
        }

        for (int i = 1; i < tab.length; i++) { 
            if (tabD[i] != 0) {
                if (i == 0) {
                    System.out.print(tabD[i] + " "); 
                } else if (tabD[i] > 0) {
                    System.out.print("+ " + tabD[i] + "*x^" + (i - 1) + " ");
                } else {
                    System.out.print(tabD[i] + "*x^" + (i - 1) + " ");
                }
            }
        }*/

        //Exercice 21

        int[] tab = {3, 0, 1, -5, 0, 0};
        double[] tabPr = new double[tab.length + 1];

        for (int i = 0; i < tab.length; i++) {
            tabPr[i + 1] = tab[i] / (double)(i + 1);
        }

        System.out.print("F(x) = ");
        for (int i = 0; i < tabPr.length; i++) {
            if (tabPr[i] != 0) {
                if (i == 0) {
                    System.out.print(tabPr[i] + " "); 
                } else if (tabPr[i] > 0 && i != 0) {
                    System.out.print("+ " + tabPr[i] + "*x^" + i + " ");
                } else {
                    System.out.print(tabPr[i] + "*x^" + i + " ");
                }
            }
        }


        























    }

    public static void main(String[] args) {  
        new NomDuProgramme().run();
    }
}
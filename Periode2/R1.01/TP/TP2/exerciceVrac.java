import java.io.*;
import java.util.*;

class ExerciceVrac{
    int rechercheDico(int[] tab, int x) {
    int debut = 0;
    int fin = tab.length - 1;

    while (debut <= fin) {
        int milieu = debut + (fin - debut) / 2;

        if (tab[milieu] == x) {
            return milieu;
        } else if (tab[milieu] < x) {
            debut = milieu + 1;
        } else {
            fin = milieu - 1;
        }
    }
    return -1;
}

    void afficherTableau(int[] tab, int deb, int fin, int inc) {
    for (int i = deb; i <= fin; i += inc) {
        System.out.print(tab[i] + " "); 
    }
}

    float determinant (int a, int b, int c) {
        return (b*b)-(4*a*c);
    }

    void SolutionPoly(int a, int b, int c) {
        float d = determinant(a, b, c);

        if (d < 0) {
            System.out.println("Pas de solutions");
        } else if (d == 0) {
            float solution = -b / (2.0f * a);
            System.out.println("La solution est : " + solution);
        } else {
            float solution1 = (-b + (float)Math.sqrt(d)) / (2 * a);
            float solution2 = (-b - (float)Math.sqrt(d)) / (2 * a);
            System.out.println("La première solution est : " + solution1);
            System.out.println("La deuxième solution est : " + solution2);
        }
}
 

    int[] fusion(int[] t1, int[] t2) {
        int i = 0, j = 0, k = 0;
        int[] t3 = new int[t1.length + t2.length];

        while (i < t1.length && j < t2.length) {
            if (t1[i] < t2[j]) {
                t3[k++] = t1[i++];
            } else {
                t3[k++] = t2[j++];
            }
        }

        while (i < t1.length) t3[k++] = t1[i++];
        while (j < t2.length) t3[k++] = t2[j++];

        return t3;
    }
    
    int baseToDecimal(int n, int baseDepart) {
        int decimal = 0;
        int puissance = 1;
        while (n > 0) {
            decimal += (n % 10) * puissance;
            n /= 10;
            puissance *= baseDepart;
        }
        return decimal;
    }

    int decimalToBase(int n, int baseArrivee) {
        int res = 0;
        int puissance = 1;
        while (n > 0) {
            res += (n % baseArrivee) * puissance;
            n /= baseArrivee;
            puissance *= 10;
        }
        return res;
    }

    int base1ToBase2(int n, int baseDepart, int baseArrivee) {
        return decimalToBase(baseToDecimal(n, baseDepart), baseArrivee);
    }




    void run (){
        int [] t = {2,5,9,11,15,16,19,20};
        System.out.println(rechercheDico(t,2));
        afficherTableau(t, 2, 5, 1);
        System.out.println();
        int [] t1 = {2,8,9,11,48,16,7,20};
        int [] t2 = {12,5,1,15,6,19,10};
        Arrays.sort(t1);  
        Arrays.sort(t2);
        int [] t3 = fusion(t1, t2);
        afficherTableau(t3, 0, t3.length - 1, 1);
        System.out.println();
        System.out.println(base1ToBase2(11111111, 2, 10));
        System.out.println(determinant(4, 8, 3));
        SolutionPoly(4, 8, 3);
    }   

public static void main(String[] args) {  
        new ExerciceVrac().run();
}
}
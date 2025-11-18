import java.io.*;
import java.util.*;

class tp {
    Scanner in = new Scanner(System.in);
    
    /* void decompte(int n ){
        for (int i = n ; i>=1; i--){
            System.out.println(i);
        }
    } */

    void afficherLigneTirets(int c){
            for(int j =0; j<c; j++){
                    System.out.print("--");
                }
                System.out.println("-");
        }
    
    void afficherLigneBarres(int c){
        
            for(int j = 0; j<c; j++){
                System.out.print("| ");

            }
            System.out.println("|");
    }

    void afficherDamier(int c, int l) {
        for(int i = 0; i<l; i++){
            afficherLigneTirets(c);
            afficherLigneBarres(c);

        }
        afficherLigneTirets(c);
    
    }

    double carre(double x) {
        return x*x;
    }

    int fact(int nb) {
        int result = 1;
        for(int i = 2; i<=nb; i ++){
            result *= i;
        }
        return result;
        }
        



    




    void run() {
    /* /decompte(10); */
        afficherDamier(5, 5);
        System.out.println(carre(5));
        System.out.println(fact(5));
        
    /* int l = 3;
    int c = 3;

    for(int i = 0; i<l; i++){
        for(int j =0; j<c; j++){
            System.out.print("--");
        }
        System.out.print("-");
        System.out.println();
        System.out.print("|");
        for(int k = 0; k<l; k++){
            System.out.print(" |");

        }
        System.out.println();

    }
    for(int j =0; j<c; j++){
            System.out.print("--");
        }
        System.out.print("-"); */




    }

    public static void main(String[] args) {  
        new tp().run();
    }
}
import java.util.*;

class Statistique {
    Scanner in = new Scanner(System.in);
    int somme(int[] tab){
        int res = 0;      
        for(int i = 0; i < tab.length; i ++) {
            res += tab[i];
        }
        return res; 
    }

    double moyenne(int [] tab) {
        if (tab.length == 0) {
            return 0.0; 
        }
        
        int sommeTotale = somme(tab);
        return (double) sommeTotale / tab.length;
    }
    double variance(int[] tab) {
        double m = moyenne(tab);
        double sommeEcartsCarre = 0.0;
        for (int element : tab) {
            double ecart = element - m; 
            sommeEcartsCarre += Math.pow(ecart, 2); 
        }
        return sommeEcartsCarre / tab.length;
    }
    void run() {
        int[] t = {15, 12, 18, 10, 15};
        int somme = somme(t);
        System.out.println(somme);
        double moyenne = moyenne(t);
        System.out.println(moyenne);
        double variance = variance(t);
        System.out.println(variance);
    }

    public static void main(String[] args) {  
        new Statistique().run();
    }
}
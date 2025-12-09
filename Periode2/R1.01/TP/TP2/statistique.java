import java.util.*;

class Statistique {
    Scanner in = new Scanner(System.in);
    float somme(int[] tab){
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
        
        float sommeTotale = somme(tab);
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

    double ecartType (int[]tab) {
        double ecart = 0;
        ecart = Math.sqrt(variance(tab));
        return ecart;
    }

    void run() {
        int[] t = {2, 4,6,8,10 };
        float somme = somme(t);
        System.out.println(somme);
        double moyenne = moyenne(t);
        System.out.println(moyenne);
        double variance = variance(t);
        System.out.println(variance);
        double ecartType = ecartType(t);
        System.out.println(ecartType);

    }


    public static void main(String[] args) {  
        new Statistique().run();
    }
}
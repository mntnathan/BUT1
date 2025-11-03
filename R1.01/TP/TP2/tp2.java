import java.util.*;
import java.io.*;

class NomDuProgramme {

    void run() {
        Scanner sc = new Scanner(System.in);
        /*
        //Exercice 1    
        double coefM1 = 3.0;
        double coefM2 = 2.5;
        double coefM3 = 6.0;

        System.out.print("Entrez la note de M1 : ");
        double m1 = sc.nextDouble();
        System.out.print("Entrez la note de M2 : ");
        double m2 = sc.nextDouble();
        System.out.print("Entrez la note de M3 : ");
        double m3 = sc.nextDouble();

        double moyenne = (m1 * coefM1 + m2 * coefM2 + m3 * coefM3) / (coefM1 + coefM2 + coefM3);
        System.out.println("La moyenne est : " + (moyenne));
    */
        //Exercice 2
        /*
        final double CM_PAR_INCH = 2.54;
        final int INCHES_PAR_FOOT = 12;
        final int FEET_PAR_YARD = 3;
        final int YARDS_PAR_MILE = 1760;

        System.out.print("Entrez une distance en pouces (inches) : ");
        int totalInches = sc.nextInt();

        int miles = totalInches / (YARDS_PAR_MILE * FEET_PAR_YARD * INCHES_PAR_FOOT);
        int reste = totalInches % (YARDS_PAR_MILE * FEET_PAR_YARD * INCHES_PAR_FOOT);

        int yards = reste / (FEET_PAR_YARD * INCHES_PAR_FOOT);
        reste %= FEET_PAR_YARD * INCHES_PAR_FOOT;

        int feet = reste / INCHES_PAR_FOOT;
        int inches = reste % INCHES_PAR_FOOT;

        if (miles <= 1) {
            System.out.println(miles + " mile");
        } else {
            System.out.println(miles + " miles");
        }
        
        if (yards <= 1) {
            System.out.println(yards + " yard");
        } else {
            System.out.println(yards + " yards");
        }
        
        if (feet <= 1) {
            System.out.println(feet + " foot");
        } else {
            System.out.println(feet + " feet");
        }
        
        if (inches <= 1) {
            System.out.println(inches + " inch");
        } else {
            System.out.println(inches + " inches");
        }
        

        double metres = totalInches * CM_PAR_INCH / 100;
        System.out.println("Soit " + (metres) + " mètres");
        */
        //Exercice 3
        /*        final double FRF_PAR_EURO = 6.55957;
        final double FL_PAR_EURO = 2.20371;
        final double IRL_PAR_EURO = 0.787564;
        final double ESC_PAR_EURO = 200.482;
        final double PTA_PAR_EURO = 166.386;
        final double LIT_PAR_EURO = 1936.27;
        final double DR_PAR_EURO = 340.750;
        final double SCH_PAR_EURO = 13.7603;
        final double FLUX_PAR_EURO = 40.3399;
        final double DM_PAR_EURO = 1.95583;
        final double FB_PAR_EURO = 40.3399;
        final double MF_PAR_EURO = 5.94573;

        System.out.print("Entrez une somme en francs français : ");
        double francs = sc.nextDouble();

        double euros = francs / FRF_PAR_EURO;
        System.out.println("Somme en euros : " + String.format("%.2f" , euros) + " €");

        System.out.println("Pays-Bas : " + String.format("%.2f", euros * FL_PAR_EURO) + " FL");
        System.out.println("Irlande : " + String.format("%.2f",euros * IRL_PAR_EURO) + " £IR");
        System.out.println("Portugal : " + String.format("%.2f",euros * ESC_PAR_EURO) + " ESC");
        System.out.println("Espagne : " + String.format("%.2f",euros * PTA_PAR_EURO) + " PTA");
        System.out.println("Italie : " + String.format("%.2f",euros * LIT_PAR_EURO) + " LIT");
        System.out.println("Grèce : " + String.format("%.2f",euros * DR_PAR_EURO) + " DR");
        System.out.println("Autriche : " + String.format("%.2f",euros * SCH_PAR_EURO) + " SCH");
        System.out.println("Luxembourg : " + String.format("%.2f",euros * FLUX_PAR_EURO) + " FLUX");
        System.out.println("Allemagne : " + String.format("%.2f",euros * DM_PAR_EURO) + " DM");
        System.out.println("Belgique : " + String.format("%.2f",euros * FB_PAR_EURO) + " FB");
        System.out.println("Finlande : " + String.format("%.2f",euros * MF_PAR_EURO) + " MF");
        */
        //Exercice 4
        /*
        System.out.print("Montant à payer (€) : ");
        double aPayer = sc.nextDouble();

        System.out.print("Somme versée (€) : ");
        double verse = sc.nextDouble();

        double r = verse - aPayer;
        if (r < 0) {
            System.out.println("Le client n'a pas donné assez d'argent !");
            return;
        }

        System.out.println("Monnaie à rendre : " + String.format("%.2f",r) + " €");

        double[] valeurs = {500, 200, 100, 50, 20, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01};

        for (double valeur : valeurs) {
            int nombre = (int) (r / valeur);
            if (nombre > 0) {
                System.out.println(nombre + " x " + String.format("%.2f",valeur) + " €");
                r -= nombre * valeur;
            }
        }*/

        //Exercice 5
        /*
        int a= 0;
        int b= 0;
        int c= 0;
        double delta = 0.0;
        double x = 0;
        double x1 = 0;
        double x2 = 0;

        System.out.print("Valeur de a : ");
        a = sc.nextInt();

        System.out.print("Valeur de b : ");
        b = sc.nextInt();

        System.out.print("Valeur de c : ");
        c = sc.nextInt();

        delta=((b*b)-4*a*c);
        if (delta>0) {
            x1 = (-b - Math.sqrt(delta)) / (2 * a);
            x2 = (-b + Math.sqrt(delta)) / (2 * a);
            System.out.println("Les solutions sont : x1 = " + x1 + " et x2 = " + x2);

        }
        else{
            if(delta==0){
                x = -b/2*a;
                System.out.println("Il y a une solution x :" +x);
            }
            else{
                System.out.println("Il n'y a pas de solution dans R");
            }
            
        }*/

        //Exercice 6
        /*
        double nombreU = 0.0;
        System.out.println("Entrez un nombre :");
        nombreU = sc.nextDouble();
        int r=(int)Math.sqrt(nombreU);
        System.out.println(((r*r)==nombreU)||((r+1)*(r+1))==nombreU);
        */

        //Exercice 7
        /*/
        double nombre = 0.0;

        System.out.print("Bonne moi un prix (max : 9999,99€) : ");
        nombre  = sc.nextDouble();*/

        //Exercice 9
        
        /*int W,H,xmax,ymax;
        W = 1920;
        H = 1024;
        double pW = W/2;
        double pH = H/2;
        do {
            System.out.println("Entrez une valeur de x :");
            xmax = sc.nextInt();

            System.out.println("Entrez une valeur de y :");
            ymax = sc.nextInt();

            pW =(pW + xmax)%W;
            pH =(pH + ymax)%H;

            if(pW<0){
                pW+=W;
            }
            if (pH<0) {
                pH+=H;
            }

            System.err.println("Nouvelle position est de x :" + pW + " y :" + pH);
        
            
        }
        while(true);
        */

        //Exercice 11
        /*
        int a = 10;
        int b = 5;
        while (a!=b) {
            if (a>b){
                a -= b; 
            }
            else{
                b -= a;
            }
        }
        System.out.println("Le PGCD est: " + a);
        */

        //Exercice 12
        /*
        int r;
        int b = 25;
        int a = 12;
        while(b!=0){
            r = a%b;
            a = b;
            b = r;
            System.out.println("Le PGCD : " + a);
        }*/

        //Exercice 13
        /*int r;
        int a;
        int b;
        int d;
        int n;
        System.out.println("Entrez une valeur de x :");
        a = sc.nextInt();
        int a1=a;

        System.out.println("Entrez une valeur de x :");
        b = sc.nextInt();
        int b1=b;

        while(b != 0){
            r = a % b;
            a = b;
            b = r;
            System.out.println("Le PGCD : " + a);
        }

        n = a1 / a;
        d = b1 / a;

        System.err.println("La simplification est : " +n + "/" +d);
    }*/
        //Exercice 14
        int a;
        int b;
        int c;
        int d;
        int m;
        int n;
        do{
            System.out.println("Entrez une valeur de a :");
            a = sc.nextInt();
            System.out.println("Entrez une valeur de b :");
            b = sc.nextInt();
            System.out.println("Entrez une valeur de c :");
            c = sc.nextInt();
            System.out.println("Entrez une valeur de d :");
            d = sc.nextInt();
            
        }
        while (b==0 || d==0);
            m = (a*d)+(c*d);
            n = b*d;
            System.err.println("La simplification est : " +m + "/" +n);

    }


    public static void main(String[] args) {  
        new NomDuProgramme().run();
    }
}

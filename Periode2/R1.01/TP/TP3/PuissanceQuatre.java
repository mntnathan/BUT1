import java.io.*;
import java.util.*;

class PuissanceQuatre {
    private static final String RESET = "\u001B[0m";
    private static final String ROUGE = "\u001B[31m";
    private static final String JAUNE = "\u001B[33m";

    char[][] grille = new char[6][7];
    Scanner sc = new Scanner(System.in);
    char joueurActuel = 'X';

    void afficherGrille() {
        System.out.println("\n  0   1   2   3   4   5   6 "); 
        
        System.out.print("+");
        for (int j = 0; j < grille[0].length; j++) {
            System.out.print("---+");
        }
        System.out.println();

        for (int i = 0; i < grille.length; i++) {
            System.out.print("|"); 
            for (int j = 0; j < grille[i].length; j++) {
                char jeton = grille[i][j];
                String couleur;
                char jetonAffiche;
                
                if (jeton == 'X') {
                    couleur = ROUGE;
                    jetonAffiche = 'O';
                } else if (jeton == 'O') {
                    couleur = JAUNE;
                    jetonAffiche = 'O';
                } else {
                    couleur = RESET;
                    jetonAffiche = ' ';
                }
                
                System.out.print(couleur + " " + jetonAffiche + " " + RESET + "|"); 
            }
            System.out.println();
            
            System.out.print("+");
            for (int j = 0; j < grille[0].length; j++) {
                System.out.print("---+");
            }
            System.out.println();
        }
    }

    void initialiserGrille() {
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                grille[i][j] = ' ';
            }
        }
    }

    void placerJeton(int col, char joueur) {
        for (int i = grille.length - 1; i >= 0; i--) {
            if (grille[i][col] == ' ') { 
                grille[i][col] = joueur;
                break;
            }
        }
    }

    boolean estColonnePleine(int col) {
        return grille[0][col] != ' ';
    }

    boolean estGrillePleine() {
        for (int j = 0; j < grille[0].length; j++) {
            if (grille[0][j] == ' ') {
                return false;
            }
        }
        return true;
    }

    boolean aGagne(char joueur) {
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j <= grille[0].length - 4; j++) {
                if (grille[i][j] == joueur &&
                    grille[i][j+1] == joueur &&
                    grille[i][j+2] == joueur &&
                    grille[i][j+3] == joueur) {
                    return true;
                }
            }
        }

        for (int i = 0; i <= grille.length - 4; i++) {
            for (int j = 0; j < grille[0].length; j++) {
                if (grille[i][j] == joueur &&
                    grille[i+1][j] == joueur &&
                    grille[i+2][j] == joueur &&
                    grille[i+3][j] == joueur) {
                    return true;
                }
            }
        }

        for (int i = 0; i <= grille.length - 4; i++) {
            for (int j = 0; j <= grille[0].length - 4; j++) {
                if (grille[i][j] == joueur &&
                    grille[i+1][j+1] == joueur &&
                    grille[i+2][j+2] == joueur &&
                    grille[i+3][j+3] == joueur) {
                    return true;
                }
            }
        }

        for (int i = 3; i < grille.length; i++) {
            for (int j = 0; j <= grille[0].length - 4; j++) {
                if (grille[i][j] == joueur &&
                    grille[i-1][j+1] == joueur &&
                    grille[i-2][j+2] == joueur &&
                    grille[i-3][j+3] == joueur) {
                    return true;
                }
            }
        }
        return false;
    }

    void run() {
        System.out.println("🎉 Bienvenue au Puissance 4 !");
        initialiserGrille();
        afficherGrille();

        while (true) {
            String couleurJoueur = (joueurActuel == 'X') ? ROUGE : JAUNE;
            System.out.println("\nC'est au tour du joueur " + couleurJoueur + joueurActuel + RESET + ".");
            
            int col = -1;
            boolean colonneValide = false;

            if (estGrillePleine()) {
                System.out.println("Match nul ! La grille est pleine.");
                break;
            }

            while (!colonneValide) {
                System.out.print("Entrez la colonne où vous voulez jouer (0-" + (grille[0].length - 1) + ") : ");
                
                if (sc.hasNextInt()) {
                    col = sc.nextInt();
                    
                    if (col < 0 || col >= grille[0].length) {
                        System.out.println("❌ Colonne invalide. Veuillez choisir une colonne entre 0 et " + (grille[0].length - 1) + ".");
                    } else if (estColonnePleine(col)) {
                        System.out.println("⚠️ Cette colonne est pleine.");
                    } else {
                        colonneValide = true; 
                        placerJeton(col, joueurActuel);
                    }
                } else {
                    System.out.println("❌ Saisie invalide. Veuillez entrer un nombre entier.");
                    sc.next();
                }
            }
            
            afficherGrille();

            if (aGagne(joueurActuel)) {
                System.out.println("Le joueur " + couleurJoueur + joueurActuel + RESET + " a gagné ! Félicitations !");
                break;
            }

            if (joueurActuel == 'X') {
                joueurActuel = 'O';
            } else {
                joueurActuel = 'X';
            }
        }
        sc.close();
    }

    public static void main(String[] args) {
        new PuissanceQuatre().run();
    }
}
import java.util.*;

public class NomDuProgramme {
    Scanner in = new Scanner(System.in);
    Random randomNumbers = new Random();

    final int KM_VOYAGE = 300; 
    final int KM_NORM_MIN = 10, KM_NORM_MAX = 15;
    final int KM_RAP_MIN = 20, KM_RAP_MAX = 25;

    final int AVANTAGE_VOYAGEUR = 20;
    final int GOURDE_PLEINE = 12;
    final int MORT_SOIF = 4;
    final int MORT_FATIGUE = 4;
    final int DIF_AIDE = 3;

    int kmVoyageur;
    int kmNatifs;
    int gourde;
    int soif ;
    int fatigue ;
    boolean fini ;
    boolean tempete;
    int toursTempete;
    
    void run() {
        int j;
        do {
            jouerUnePartie();

            System.out.println("Fin de la partie !");
            System.out.println("Voulez vous rejouer ? (1 pour rejouer, 0 pour arreter) ");
            j = in.nextInt();
        } while (j == 1);
        
        System.out.println("Merci d'avoir joué !");
    }
    void initialisationConstante () {
        final int KM_VOYAGE = 300; 
        final int KM_NORM_MIN = 10, KM_NORM_MAX = 15;
        final int KM_RAP_MIN = 20, KM_RAP_MAX = 25;

        final int AVANTAGE_VOYAGEUR = 20;
        final int GOURDE_PLEINE = 12;
        final int MORT_SOIF = 4;
        final int MORT_FATIGUE = 4;
        final int DIF_AIDE = 3;
    }
        
    void afficherTitre() {
        System.out.println("=== LE JEU DU CHAMEAU ===");
        System.out.println("Vous avez volé un chameau pour traverser le désert !");
        System.out.println("Les natifs vous poursuivent. Survivez à la traversée de 300 km !");
        System.out.println();
    }

    void jouerUnePartie() {
        initialiserPartie();
        afficherTitre();

        while (!fini) {
            gererTempete();
            afficherMenu();
            int choix = obtenirChoixUtilisateur();
            gererChoix(choix);

            if (fini) {
                break;
            }
            if (choix != 1) {
                soif++;
            }
            avanceNatif();
            conditionFin(); 

            if (!fini) {
                afficherStatus();
            }
        }
    }

    void initialiserPartie() {
        kmVoyageur = 0;
        kmNatifs = kmVoyageur - AVANTAGE_VOYAGEUR;
        gourde = GOURDE_PLEINE / 2;
        soif = 0;
        fatigue = 0;
        fini = false;
        tempete = false;
        toursTempete = 0;
    }
        
    void afficherMenu () {
        System.out.println("O P T I O N S :");
        System.out.println("1. Boire");
        System.out.println("2. Avancer normalement");
        System.out.println("3. Avancer à toute vitesse");
        System.out.println("4. Repos");
        System.out.println("5. Espérer de l'aide");
        System.out.println("0. Quitter");
    } 

    int obtenirChoixUtilisateur() {
        System.out.print("Qu'allez-vous faire ? ");
        return in.nextInt();
    }

    void gererTempete() {
            if (!tempete && nombreAleatoire(0, 9) == 0) { 
                tempete = true;
                toursTempete = nombreAleatoire(2, 4); 
                System.out.println(" Une tempête de sable se lève ! Elle durera environ " + toursTempete + " tours !");
            }
            if (tempete) {
                    System.out.println(" La tempête fait rage ! Vos déplacements sont réduits !");
                    toursTempete--;
                    if (toursTempete <= 0) {
                        tempete = false;
                        System.out.println(" La tempête s'est calmée !");
                    }
                }
        }
            
    void boire() {
        if (gourde == 0) {
            System.out.println("La gourde est vide !");
        } else {
            gourde--;
            soif = 0;
            System.out.println("Vous buvez. Gorgées restantes : " + gourde);
        }
    }
    
    void avanceNormal () {
        int distNorm = randomNumbers.nextInt(KM_NORM_MAX - KM_NORM_MIN + 1) + KM_NORM_MIN;
        if (tempete) distNorm /= 2; 
        kmVoyageur += distNorm;
        fatigue++;
        System.out.println("Vous avancez normalement de " + distNorm + " km.");
    }

    void avanceRapide () {
        int distRap = randomNumbers.nextInt(KM_RAP_MAX - KM_RAP_MIN + 1) + KM_RAP_MIN;
        if (tempete) distRap /= 2; 
        kmVoyageur += distRap;
        fatigue += 2;
        System.out.println("Vous avancez à toute vitesse de " + distRap + " km !");
    }

    void fatigue() { 
        fatigue = 0;
        System.out.println("Votre chameau se repose bien.");
    }

    void demanderAide() {
        int chance = randomNumbers.nextInt(DIF_AIDE);
        if (chance == 0) {
            System.out.println("Vous trouvez un camp de nomades !");
            int ajout = randomNumbers.nextInt(3 + 1); 
            gourde += ajout;
            if (gourde > GOURDE_PLEINE) gourde = GOURDE_PLEINE;
        } else {
            System.out.println("Aucune aide trouvée...");
        }
        fatigue++;
        
    }

    void quitter(){
        System.out.println("Vous abandonnez la traversée.");
        fini = true;
    }

    void gererChoix(int choix) {
        switch (choix) {
            case 1: boire(); break;
            case 2: avanceNormal(); break;
            case 3: avanceRapide(); break;
            case 4: fatigue(); break; 
            case 5: demanderAide(); break;
            case 0: quitter(); break;
            default:
                System.out.println("Option invalide !");
                break;
        }
    }

    void avanceNatif () {
        int randomNatif = nombreAleatoire(0, 2);
        switch (randomNatif) {
            case 0:
                kmNatifs += nombreAleatoire(KM_RAP_MIN, KM_RAP_MAX);
                break;
            case 1:
                kmNatifs += nombreAleatoire(KM_NORM_MIN, KM_NORM_MAX);
                break;
            case 2:
                break;
        }
    }

    void conditionFin () {
        if (soif >= MORT_SOIF) {
            System.out.println("Vous êtes mort(e) de soif !");
            fini = true;
        } else if (fatigue >= MORT_FATIGUE) {
            System.out.println("Votre chameau meurt de fatigue !");
            fini = true;
        } else if (kmNatifs >= kmVoyageur) {
            System.out.println("Les natifs vous ont rattrapé !");
            fini = true;
        } else if (kmVoyageur >= KM_VOYAGE) {
            System.out.println("Vous avez traversé le désert ! Vous avez gagné !");
            fini = true;
        }
    }

    void afficherStatus() {
        System.out.println("----- État -----");
        System.out.println("Distance parcourue : " + kmVoyageur + " km");
        System.out.println("Distance des natifs : " + (kmVoyageur - kmNatifs) + " km derrière");
        System.out.println("Soif : " + soif );
        System.out.println("Fatigue : " + fatigue);
        System.out.println("Gourde : " + gourde);
        System.out.println("------------");
    }

    int nombreAleatoire(int min, int max) {
        return randomNumbers.nextInt(max - min + 1) + min;
    }


        
        
    public static void main(String[] args) {
        new NomDuProgramme().run();
    }
}
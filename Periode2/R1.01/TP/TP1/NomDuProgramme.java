import java.util.*;


public class NomDuProgramme {
    Scanner in = new Scanner(System.in);
    Random randomNumbers = new Random();

    void run() {
    
    int j;
    do{
        final int KM_VOYAGE = 300; 
        final int KM_NORM_MIN = 10, KM_NORM_MAX = 15;
        final int KM_RAP_MIN = 20, KM_RAP_MAX = 25;

        final int AVANTAGE_VOYAGEUR = 20;
        final int GOURDE_PLEINE = 12;
        final int MORT_SOIF = 4;
        final int MORT_FATIGUE = 4;
        final int DIF_AIDE = 3;
        final int AVANCE_NATIFS = 4;

        System.out.println("=== LE JEU DU CHAMEAU ===");
        System.out.println("Vous avez volé un chameau pour traverser le désert !");
        System.out.println("Les natifs vous poursuivent. Survivez à la traversée de 300 km !");
        System.out.println();

        int kmVoyageur = 0;
        int kmNatifs = kmVoyageur - AVANTAGE_VOYAGEUR;
        int gourde = GOURDE_PLEINE / 2;
        int soif = 0;
        int fatigue = 0;
        boolean fini = false;

        boolean tempete = false;
        int toursTempete = 0;

        while (!fini) {

            if (!tempete && randomNumbers.nextInt(10) == 0) { 
                tempete = true;
                toursTempete = randomNumbers.nextInt(3) + 2; 
                System.out.println("⚡ Une tempête de sable se lève ! Elle durera environ " + toursTempete + " tours !");
            }

            if (tempete) {
                System.out.println("🌪️ La tempête fait rage ! Vos déplacements sont réduits !");
                toursTempete--;
                if (toursTempete <= 0) {
                    tempete = false;
                    System.out.println("🌤️ La tempête s'est calmée !");
                }
            }

            System.out.println("O P T I O N S :");
            System.out.println("1. Boire");
            System.out.println("2. Avancer normalement");
            System.out.println("3. Avancer à toute vitesse");
            System.out.println("4. Repos");
            System.out.println("5. Espérer de l'aide");
            System.out.println("0. Quitter");
            System.out.print("Qu'allez-vous faire ? ");
            int choix = in.nextInt();

            switch (choix) {
                case 1:
                    if (gourde == 0) {
                        System.out.println("La gourde est vide !");
                    } else {
                        gourde--;
                        soif = 0;
                        System.out.println("Vous buvez. Gorgées restantes : " + gourde);
                    }
                    break;

                case 2:
                    int distNorm = randomNumbers.nextInt(KM_NORM_MAX - KM_NORM_MIN + 1) + KM_NORM_MIN;
                    if (tempete) distNorm /= 2; 
                    kmVoyageur += distNorm;
                    fatigue++;
                    soif++;
                    System.out.println("Vous avancez normalement de " + distNorm + " km.");
                    break;

                case 3:
                    int distRap = randomNumbers.nextInt(KM_RAP_MAX - KM_RAP_MIN + 1) + KM_RAP_MIN;
                    if (tempete) distRap /= 2; 
                    kmVoyageur += distRap;
                    fatigue += 2;
                    soif++;
                    System.out.println("Vous avancez à toute vitesse de " + distRap + " km !");
                    break;

                case 4:
                    fatigue = 0;
                    System.out.println("Votre chameau se repose bien.");
                    break;

                case 5:
                    int chance = randomNumbers.nextInt(DIF_AIDE);
                    if (chance == 0) {
                        System.out.println("Vous trouvez un camp de nomades !");
                        int ajout = randomNumbers.nextInt(3 + 1); 
                        gourde += ajout;
                        if (gourde > GOURDE_PLEINE) gourde = GOURDE_PLEINE;
                    } else {
                        System.out.println("Aucune aide trouvée...");
                    }
                    break;

                case 0:
                    System.out.println("Vous abandonnez la traversée.");
                    fini = true;
                    break;

                default:
                    System.out.println("Option invalide !");
                    break;
            }

            int randomNatif = randomNumbers.nextInt(3); 
            switch (randomNatif) {
                case 0:
                    kmNatifs += randomNumbers.nextInt(KM_RAP_MAX - KM_RAP_MIN + 1) + KM_RAP_MIN;
                    break;
                case 1:
                    kmNatifs += randomNumbers.nextInt(KM_NORM_MAX - KM_NORM_MIN + 1) + KM_NORM_MIN;
                    break;
                case 2:
                    
                    break;
            }

            if (soif >= MORT_SOIF) {
                System.out.println("Vous êtes mort(e) de soif !");
                fini = true;
            }

            if (fatigue >= MORT_FATIGUE) {
                System.out.println("Votre chameau meurt de fatigue !");
                fini = true;
            }

            if (kmNatifs >= kmVoyageur) {
                System.out.println("Les natifs vous ont rattrapé !");
                fini = true;
            }

            if (kmVoyageur >= KM_VOYAGE) {
                System.out.println("Vous avez traversé le désert ! Vous avez gagné !");
                fini = true;
            }

            if (!fini) {
                System.out.println("État :");
                System.out.println("Distance parcourue : " + kmVoyageur + " km");
                System.out.println("Distance des natifs : " + (kmVoyageur - kmNatifs) + " km derrière");
                System.out.println("Soif : " + soif);
                System.out.println("Fatigue : " + fatigue);
                System.out.println("Gourde : " + gourde);
            }
        }


        
        System.out.println("Fin de la partie !");
        System.out.println("Voulez vous rejouer ? (1 pour rejouer, 0 pour arreter) ");
        j = in.nextInt();
    }while(j==1);
    
}
    public static void main(String[] args) {
        new NomDuProgramme().run();
    }
}

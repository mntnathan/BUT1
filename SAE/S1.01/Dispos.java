import java.util.*;
import navigator.*;

class Dispos {
    Navigator nav = new Navigator();

    void run() {
        nav.allowDownload("style.css");

        while (true) {
            nav.beginPage();

            // Page formulaire initiale
            if (nav.getPath().equals("/")) {
                nav.println("""
                <html>
                <head>
                    <title>Gestion des disponibilités</title>
                    <style>
                        body { font-family: Arial, sans-serif; margin: 20px; }
                        table { border-collapse: collapse; width: 80%; }
                        th, td { border: 1px solid #333; padding: 5px; text-align: center; }
                        th { background-color: #555; color: white; }
                        .oui { background-color: #90ee90; } /* vert clair */
                        .non { background-color: #f08080; } /* rouge clair */
                        .si { background-color: #ffff99; }  /* jaune clair */
                    </style>
                </head>
                <body>
                <h1>Paramètres des créneaux horaires</h1>
                <form method="POST" action="/disponibilites">
                    Nombre de jours : <input type="text" name="jours"><br><br>
                    Heure de début (ex: 8 pour 8h00, 8.5 pour 8h30) : <input type="text" name="debut"><br><br>
                    Heure de fin (ex: 17 pour 17h00, 17.5 pour 17h30) : <input type="text" name="fin"><br><br>
                    Durée d'un créneau (minutes) : <input type="text" name="duree"><br><br>
                    <input type="submit" value="Valider">
                </form>
                </body>
                </html>
                """);
            } 
            // Page formulaire de disponibilités
            else if (nav.getPath().equals("/disponibilites")) {
                if (nav.containsKey("jours") && nav.containsKey("debut") &&
                    nav.containsKey("fin") && nav.containsKey("duree")) {

                    int jours = nav.getInt("jours");
                    double debut = nav.getDouble("debut");
                    double fin = nav.getDouble("fin");
                    int duree = nav.getInt("duree");

                    int debutMinutes = (int)(debut * 60);
                    int finMinutes = (int)(fin * 60);

                    nav.println("<html><head><title>Saisir disponibilités</title></head><body>");
                    nav.println("<h1>Saisir vos disponibilités</h1>");
                    nav.println("<form method='POST' action='/recap'>");
                    nav.println("<table><tr><th>Heure</th>");
                    for (int j = 1; j <= jours; j++) {
                        nav.println("<th>Jour " + j + "</th>");
                    }
                    nav.println("</tr>");

                    for (int h = debutMinutes; h < finMinutes; h += duree) {
                        int heures = h / 60;
                        int minutes = h % 60;
                        String timeStr = String.format("%02d:%02d", heures, minutes);

                        nav.println("<tr><td>" + timeStr + "</td>");
                        for (int j = 1; j <= jours; j++) {
                            nav.println("<td><select name='dispo_" + j + "_" + h + "'>");
                            nav.println("<option value='oui'>Oui</option>");
                            nav.println("<option value='non'>Non</option>");
                            nav.println("<option value='si'>Si nécessaire</option>");
                            nav.println("</select></td>");
                        }
                        nav.println("</tr>");
                    }
                    nav.println("</table>");
                    nav.println("<input type='hidden' name='jours' value='" + jours + "'>");
                    nav.println("<input type='hidden' name='debut' value='" + debut + "'>");
                    nav.println("<input type='hidden' name='fin' value='" + fin + "'>");
                    nav.println("<input type='hidden' name='duree' value='" + duree + "'>");
                    nav.println("<br><input type='submit' value='Valider'>");
                    nav.println("</form>");
                    nav.println("</body></html>");
                } else {
                    nav.println("<html><body><p>Erreur : champs manquants</p><a href='/'>Retour</a></body></html>");
                }
            } 
            // Page récapitulative
            else if (nav.getPath().equals("/recap")) {
                int jours = nav.getInt("jours");
                double debut = nav.getDouble("debut");
                double fin = nav.getDouble("fin");
                int duree = nav.getInt("duree");

                int debutMinutes = (int)(debut * 60);
                int finMinutes = (int)(fin * 60);

                int totalOui = 0, totalNon = 0, totalSi = 0;
                int[] ouiParJour = new int[jours];
                int[] nonParJour = new int[jours];
                int[] siParJour = new int[jours];

                nav.println("""
                <html>
                <head>
                    <title>Récapitulatif des disponibilités</title>
                    <style>
                        body { font-family: Arial, sans-serif; margin: 20px; }
                        table { border-collapse: collapse; width: 80%; }
                        th, td { border: 1px solid #333; padding: 5px; text-align: center; }
                        th { background-color: #555; color: white; }
                        .oui { background-color: #90ee90; } 
                        .non { background-color: #f08080; } 
                        .si { background-color: #ffff99; } 
                    </style>
                </head>
                <body>
                <h1>Récapitulatif des disponibilités</h1>
                <table><tr><th>Heure</th>
                """);
                for (int j = 1; j <= jours; j++) nav.println("<th>Jour " + j + "</th>");
                nav.println("</tr>");

                for (int h = debutMinutes; h < finMinutes; h += duree) {
                    int heures = h / 60;
                    int minutes = h % 60;
                    String timeStr = String.format("%02d:%02d", heures, minutes);

                    nav.println("<tr><td>" + timeStr + "</td>");
                    for (int j = 1; j <= jours; j++) {
                        String key = "dispo_" + j + "_" + h;
                        String val = nav.get(key);
                        String cls = "";
                        if ("oui".equals(val)) { cls = "oui"; totalOui++; ouiParJour[j-1]++; }
                        else if ("non".equals(val)) { cls = "non"; totalNon++; nonParJour[j-1]++; }
                        else if ("si".equals(val)) { cls = "si"; totalSi++; siParJour[j-1]++; }
                        nav.println("<td class='" + cls + "'>" + val + "</td>");
                    }
                    nav.println("</tr>");
                }
                nav.println("</table>");

                // Résumé global
                nav.println("<h2>Résumé global</h2>");
                nav.println("<p>Total Oui: " + totalOui + "</p>");
                nav.println("<p>Total Non: " + totalNon + "</p>");
                nav.println("<p>Total Si nécessaire: " + totalSi + "</p>");

                // Résumé par jour
                nav.println("<h2>Résumé par jour</h2><table><tr><th>Jour</th><th>Oui</th><th>Non</th><th>Si nécessaire</th></tr>");
                for (int j = 0; j < jours; j++) {
                    nav.println("<tr><td>Jour " + (j+1) + "</td><td>" + ouiParJour[j] + "</td><td>" + nonParJour[j] + "</td><td>" + siParJour[j] + "</td></tr>");
                }
                nav.println("</table>");

                nav.println("<br><a href='/'>Recommencer</a>");
                nav.println("</body></html>");
            } 
            else {
                nav.println("<html><body><p>Page non trouvée</p><a href='/'>Accueil</a></body></html>");
            }

            nav.endPage();
        }
    }

    public static void main(String[] args) {
        new Dispos().run();
    }
}

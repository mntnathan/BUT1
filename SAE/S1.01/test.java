import java.io.*;
import java.util.*;
import navigator.*;
class test {
// la variable nav représente le dialogue avec le navigateur
    Navigator nav = new Navigator(); 
    void run() {
    // début d’une page web et attente d’une connexion du navigateur
        nav.beginPage();
        // envoi du code HTML (très simplifié sur cet exemple)
        nav.println("<html>");
        nav.println("<header><title>Test</title></header>");
        nav.println("<body>Ceci est un test</body>");
        nav.println("</html>");
        // fin de la page web
        nav.endPage();
        // fin des échanges avec le navigateur
        nav.close();
    }
    public static void main(String[] args) {
        new test().run();
}
}

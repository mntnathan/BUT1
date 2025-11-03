import java.io.*;
import java.lang.foreign.ValueLayout;

import javax.print.DocFlavor.STRING;

import cartes.*;

class Carte extends Cartes {

    void run() {
    rapide();
    /* 
	initExercice("2.4");
    int tas=1;
    for(int compt=0 ; compt <=5;compt ++) {
        deplacer(1,tas);
        tas ++;
    }
    */
    /*initExercice("2.5");
    while (tasVide(1)==false) {
        deplacer(1,2);
    }
        */

    /*initExercice("2.6");
    while (tasVide(1)==false) {
        deplacer(1,3);
    }
    while (tasVide(3)==false) {
        deplacer(3,2);
    }
        */
    /*initExercice("3.1");
    while (tasVide(1)==false) {
        if (sommetCarreau(1)) {
            deplacer(1,3);
        }
        else {
            deplacer(1,2);
        }        
    }
    while (tasVide(3)==false) {
        deplacer(3,1);
        
    }*/
    /*/
    initExercice("3.2");
    int nb = 0;
    while (tasVide(1)== false) {
        deplacer(1,2);
        nb ++;
        if (nb==3){
            nb = 0;
        }
    }
    while (nb>0) {
        deplacer(2,1);
        nb--;
        
    }
    */
    /*initExercice("3.3");
    while (tasVide(1)==false) {
        deplacer(1,2);
        
    }
    if (sommetCoeur(2)==true){
        deplacer(2,1);
        finir();

    }
    else{
        while (tasVide(2)==false) {
            deplacer(2,1);
        }
    }*/

    /*initExercice("3.4");
    while (tasVide(1)==false) {
        if ((sommetCarreau(1)==true) || (sommetCoeur(1)== true || valeurSommet(1)==roi)){
            deplacer(1,2);
    }
    else{
        deplacer(1,3);

    }
    }
    while (tasVide(3)==false) {
        deplacer(3,1);
    }*/



    /*initExercice("3.5");
    while (tasVide(1)==false) {
        deplacer(1,2);
        deplacer(1,3);
        
    }*/
    
    /*initExercice("3.6");
    while (tasVide(1)==false) {
        deplacer(1,2);
        deplacer(1,3);
        deplacer(1,4);
    }*/

    /*initExercice("3.7");
    while (tasVide(1)==false) {
        deplacer(1,2);
        
    }
    while (tasVide(2)==false) {
        deplacer(2,3);
        
    }
    while (tasVide(3)==false) {
        deplacer(3,1);
        
    }*/

    /*initExercice("3.8");
    do {
        if (tasVide(1)){
        System.out.println("Tas 2 est plus grand que tas 1");
        break;

    }
    else{
        deplacer(1,3);
    }
    if (tasVide(2)) {
        System.out.println("Tas 1 est plus grand que tas 2");
        break;
    }
    else{
        deplacer(2,4);
    }

}   
    while(tasVide(1)==false || tasVide(2)==false);

    if (tasVide(1)==true && tasVide(2)==true) {
        System.out.println("Tas 1 est le meme que tas 2");
    }*/

    /*initExercice("3.9");
    for(int compt=0;compt<=10;compt++){
        while (tasVide(1)==false) {
            if (tasVide(1)==false){
                deplacer(1,2);
                
            }
            if (tasVide(1)==false){
                deplacer(1,3);
            }
            
        }
        while (tasVide(2)==false) {
            deplacer(2,1);
            
        }
        while (tasVide(3)==false) {
            deplacer(3,1);
            
        }
    }*/

    /*initExercice("4.1");
    int vsommmet=0;

    
    vsommmet = valeurSommet(1);
    deplacer(1,2);
    while (tasVide(1)==false) {
        if (vsommmet<valeurSommet(1)){
            vsommmet=valeurSommet(1);
            deplacer(2,3);
            deplacer(1,2);
        }
        else{
            deplacer(1,3);
        }
    }*/
    
    /*initExercice("4.2");
    int vsommmet=0;
    int vSommmet=0;

    while (true) {
        vsommmet = valeurSommet(1);
        deplacer(1,2);
        if (tasVide(1)==false) {
        while (tasVide(1)==false) {
            if (vsommmet<valeurSommet(1)){
                vsommmet=valeurSommet(1);
                deplacer(2,3);
                deplacer(1,2);
            }
            else{
                deplacer(1,3);
            }

        }
        }
        else {
            break;
        }
        vSommmet = valeurSommet(3);
        deplacer(3,2);
        if (tasVide(3)==false){
        while (tasVide(3)==false) {
            if (vSommmet<valeurSommet(3)) {
                vSommmet=valeurSommet(3);
                deplacer(2,1);
                deplacer(3,2);
                
            }
            else{
                deplacer(3,1);
            }
        }
        }
        else {
            break;
        }
        }*/




// initExercice("4.3");
// if (tasVide(1)==false){
//     String couleur1="";
//     String couleur3="";
//     while (tasVide(1)==false) {    
//         if (sommetCarreau(1)==true){
//             couleur1 = "Carreau";
//         }
//         if (sommetCoeur(1)==true){
//             couleur1 = "Coeur";
//         }
//         if (sommetTrefle(1)==true){
//             couleur1 = "Trefle";
//         }
//         if (sommetPique(1)==true){
//             couleur1 = "Pique";
//         }
//         if (sommetCarreau(3)==true){
//             couleur3 = "Carreau";
//         }
//         if (sommetCoeur(3)==true){
//             couleur3 = "Coeur";
//         }
//         if (sommetTrefle(3)==true){
//             couleur3 = "Trefle";
//         }
//         if (sommetPique(3)==true){
//             couleur3 = "Pique";
//         }
        
//         if (valeurSommet(3)==valeurSommet(1) && couleur1==couleur3){
//             deplacer(3,2);
//             deplacer(1,5);
//             while (tasVide(4)==false) {
//                 deplacer(4,3);
//             }

//         }
//         else{
//             deplacer(3,4);
//         }
        
//     }
// }
//     else{
//             System.out.println("Le tas 1 est vide");
//         }
//     while (tasVide(5)==false) {
//         deplacer(5,1);
//     }
//     while (tasVide(2)==false) {
//         deplacer(2,5);
//     }
//     while (tasVide(5)==false) {
//         deplacer(5,4);
//     }
//     while (tasVide(4)== false) {
//         deplacer(4,2);
//     }
/*
initExercice("4.4");
    String couleur1="";
    String couleur3="";
    if (sommetCarreau(1)==true){
            couleur1 = "Carreau";
        }
        if (sommetCoeur(1)==true){
            couleur1 = "Coeur";
        }
        if (sommetTrefle(1)==true){
            couleur1 = "Trefle";
        }
        if (sommetPique(1)==true){
            couleur1 = "Pique";
        }
    deplacer(1,2);
    while (tasVide(1)==false) {  
        if (sommetCarreau(1)==true){
            couleur3 = "Carreau";
        }
        if (sommetCoeur(1)==true){
            couleur3 = "Coeur";
        }
        if (sommetTrefle(1)==true){
            couleur3 = "Trefle";
        }
        if (sommetPique(1)==true){
            couleur3 = "Pique";
        }
        if ((couleur1==couleur3)) {
            deplacer(1,2);
        }
        else{
            deplacer(1,3);
        }
    }
    while (tasVide(2)==false) {
        deplacer(2,1);
    }
    while (tasVide(3)==false) {
        deplacer(3,1);
    }*/
/* 
initExercice("4.5");
    while (tasVide(1)==false) {
        if (sommetCarreau(1)==true){
            deplacer(1,3);
        }
        if (sommetCoeur(1)==true){
            deplacer(1,2);
        }
        if (sommetTrefle(1)==true){
            deplacer(1,4);
        }
        else{
            deplacer(1,5);
        }
    }
    while (tasVide(5)==false) {
        deplacer(2,1);
        deplacer(3,1);
        deplacer(4,1);
        deplacer(5,1);
        
    }
*/
/*
initExercice("4.6");
int nbCarreau = 0;
int nbCoeur = 0;
int nbTrefle =0;
int nbPique = 0;
while (tasVide(1)==false) {
        if (sommetCarreau(1)==true){
            deplacer(1,3);
            nbCarreau ++;
        }
        else{
            if (sommetCoeur(1)==true){
                deplacer(1,2);
                nbCoeur ++;
            }
            else{
                if (sommetPique(1)==true){
                    deplacer(1,5);
                    nbPique ++ ;
                }
                else{
                    if (sommetTrefle(1)==true){
                        deplacer(1,4);
                        nbTrefle ++;
        }
    }}}
}

while (nbCoeur>4 && nbCarreau>3 && nbTrefle>2 && nbPique>1) {
    deplacer(2,1);
    deplacer(2,1);
    deplacer(2,1);
    deplacer(2,1);
    nbCoeur-=4;

    deplacer(3,1);
    deplacer(3,1);
    deplacer(3,1);
    nbCarreau-=3;

    deplacer(4,1);
    deplacer(4,1);
    nbTrefle-=2;

    deplacer(5,1);
    nbPique-=1;
    
    
}*/

initExercice("4.7");
deplacer(1, 2);
deplacer(1, 3);
deplacer(1, 4);
deplacer(1, 5);

String couleur2 = "";
String couleur3 = "";
String couleur4 = "";
String couleur5 = "";

while (tasVide(1) == false) {
    if (tasVide(2) == false) {
        if (sommetCarreau(2) == true) {
            couleur2 = "Carreau";
        }
        if (sommetCoeur(2) == true) {
            couleur2 = "Coeur";
        }
        if (sommetTrefle(2) == true) {
            couleur2 = "Trefle";
        }
        if (sommetPique(2) == true) {
            couleur2 = "Pique";
        }
    } else {
        couleur2 = "";
    }

    if (tasVide(3) == false) {
        if (sommetCarreau(3) == true) {
            couleur3 = "Carreau";
        }
        if (sommetCoeur(3) == true) {
            couleur3 = "Coeur";
        }
        if (sommetTrefle(3) == true) {
            couleur3 = "Trefle";
        }
        if (sommetPique(3) == true) {
            couleur3 = "Pique";
        }
    } else {
        couleur3 = "";
    }

    if (tasVide(4) == false) {
        if (sommetCarreau(4) == true) {
            couleur4 = "Carreau";
        }
        if (sommetCoeur(4) == true) {
            couleur4 = "Coeur";
        }
        if (sommetTrefle(4) == true) {
            couleur4 = "Trefle";
        }
        if (sommetPique(4) == true) {
            couleur4 = "Pique";
        }
    } else {
        couleur4 = "";
    }

    if (tasVide(5) == false) {
        if (sommetCarreau(5) == true) {
            couleur5 = "Carreau";
        }
        if (sommetCoeur(5) == true) {
            couleur5 = "Coeur";
        }
        if (sommetTrefle(5) == true) {
            couleur5 = "Trefle";
        }
        if (sommetPique(5) == true) {
            couleur5 = "Pique";
        }
    } else {
        couleur5 = "";
    }

    if (couleur2 == couleur3 && couleur2 != "") {
        deplacer(2, 6);
        deplacer(3, 6);
        if (tasVide(1)==false) {
            deplacer(1,2);
            deplacer(1,3);
        }
    } else {
        if (couleur2 == couleur4 && couleur2 != "") {
            deplacer(2, 6);
            deplacer(4, 6);
            if (tasVide(1)==false) {
                deplacer(1,2);
                deplacer(1,4);
            }
        } else {
            if (couleur2 == couleur5 && couleur2 != "") {
                deplacer(2, 6);
                deplacer(5, 6);
                if (tasVide(1)==false) {
                    deplacer(1,2);
                    deplacer(1,5);
        }
            } else {
                if (couleur3 == couleur4 && couleur3 != "") {
                    deplacer(3, 6);
                    deplacer(4, 6);
                    if (tasVide(1)==false) {
                        deplacer(1,3);
                        deplacer(1,4);
        }
                } else {
                    if (couleur3 == couleur5 && couleur3 != "") {
                        deplacer(3, 6);
                        deplacer(5, 6);
                        if (tasVide(1)==false) {
                            deplacer(1,3);
                            deplacer(1,5);
        }
                    } else {
                        if (couleur4 == couleur5 && couleur4 != "") {
                            deplacer(4, 6);
                            deplacer(5, 6);
                            if (tasVide(1)==false) {
                                deplacer(1,4);
                                deplacer(1,5);
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }
}




	finir();
}

    public static void main(String[] args) {  
        new Carte().run();
    }
}

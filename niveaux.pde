
void niveaux() {
  
  numJeu=0;//jeu numéro 0
  fondecran_niveaux = loadImage("background_niveaux.png");
  background(fondecran_niveaux);
  /*ferme = loadImage("ferme.png");
   enclos = loadImage("enclos.png");
   mouton3 =loadImage("mouton3.png");*/

  textSize(40);
  fill(0);
  textAlign(CORNER, CORNER);
  text("Niveau : "+ (niveaudebloque+1), width-250,50);
  
  //update_score_general();
  //image (enclos, 50, 30, 3006/6, 1292/6);// enclos départ
  //image(mouton3, 60, 20, 150, 200);//mouton
  //image (ferme, width-250, height-180, 650/3, 526/3); //ferme arrivée

  //affichage des étoiles
  for (int iniveau=0; iniveau<x_cercle_niveaux.length; iniveau++) {
    //étoiles
    imageMode(CENTER);
    etoile_niveaux = loadImage("etoile_"+score_general[iniveau]+".png");
    image(etoile_niveaux, x_cercle_niveaux[iniveau], y_cercle_niveaux[iniveau]+rayon_cercle_niveaux[iniveau]/2+yetoile[score_general[iniveau]]/(2)-(iniveau+1), (xetoile[score_general[iniveau]])/(iniveau+2)*5, yetoile[score_general[iniveau]]/(iniveau+2)*5);
    imageMode(CORNER);
  }
  
  
  //action de la souris
  /*for (int ii=0; ii<x_cercle_niveaux.length; ii++) {
    if(dist(mouseX, mouseY, x_cercle_niveaux[ii], y_cercle_niveaux[ii]) < rayon_cercle_niveaux[ii]/2){
      fill(255,255,255,80);
      ellipse(x_cercle_niveaux[ii], y_cercle_niveaux[ii], rayon_cercle_niveaux[ii], rayon_cercle_niveaux[ii]); // niveaux
      // Affiche une main
      cursor(HAND);
      if (mousePressed == true) {
        jouer();
      }
    }
    else {
      // Affiche une flèche
      cursor(ARROW);
    }
  }*/
}




void update_score_general(){
      score_general[0]=score1;
  score_general[1]=score2;
  score_general[2]=score3;
  score_general[3]=score4;
  score_general[4]=score5;
  score_general[5]=score6;
  score_general[6]=score7;
  score_general[7]=score8;
  score_general[8]=score9;
  score_general[9]=score10;
}

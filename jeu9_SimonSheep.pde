

void SimonSheep() {
  numJeu=9;//jeu numéro 9
  background(107, 183, 77);
  strokeWeight(3);
  stroke(0);
  if (flag == 0) {
    compteur_9 += 1;
    if (compteur_9 < 30*nbSheep) {
      fill(107, 183, 77);
      rect(0, 0, width, height);
      println(compteur_9);
      for (int i = 0; i<nbSheep; i++) {
        if (listeCouleur[i] == 1) {
          image(red, i*1400/nbSheep, height/2-(1400/nbSheep)/2, 1400/nbSheep, 1400/nbSheep);
        } else if (listeCouleur[i] == 2) {
          image(green, i*1400/nbSheep, height/2-(1400/nbSheep)/2, 1400/nbSheep, 1400/nbSheep);
        } else if (listeCouleur[i] == 3) {
          image(blue, i*1400/nbSheep, height/2-(1400/nbSheep)/2, 1400/nbSheep, 1400/nbSheep);
        } else if (listeCouleur[i] == 4) {
          image(yellow, i*1400/nbSheep, height/2-(1400/nbSheep)/2, 1400/nbSheep, 1400/nbSheep);
        } else if (listeCouleur[i] == 5) {
          image(purple, i*1400/nbSheep, height/2-(1400/nbSheep)/2, 1400/nbSheep, 1400/nbSheep);
        }
      }
      
    }
    if (compteur_9>60*nbSheep)
      flag = 1;
  } else if (flag == 1) {
    fill(107, 183, 77);
    rect(0, 0, width, height);
    strokeWeight(2);

    for (int i = 0; i<nbSheep; i++) {
      strokeWeight(3);
      rect(i*1400/nbSheep, height/2-(1400/nbSheep)/2, 1400/nbSheep, 1400/nbSheep);
    }


    noFill();
    for (int i = 0; i<5; i++) {
      if (i == 0) {
        image(red, ((width/2)-120-120-80-60)+(i*160), 660, 120, 120);
      } else if (i == 1) {
        image(green, ((width/2)-120-120-80-60)+(i*160), 660, 120, 120);
      } else if (i == 2) {
        image(blue, ((width/2)-120-120-80-60)+(i*160), 660, 120, 120);
      } else if (i == 3) {
        image(yellow, ((width/2)-120-120-80-60)+(i*160), 660, 120, 120);
      } else if (i == 4) {
        image(purple, ((width/2)-120-120-80-60)+(i*160), 660, 120, 120);
      }
    }

    for (int i = 0; i<5; i++) {
      strokeWeight(3);
      ellipse(((width/2)-120-120-80-60)+(i*160)+60, 660+62, 130, 130);
    }

    for (int i = 0; i<5; i++) {
      strokeWeight(3);
      if (dist(mouseX, mouseY, ((width/2)-120-120-80-60)+(i*160)+60, 660+62) < 65) {
        fill(255, 80);
        strokeWeight(3);
        ellipse(((width/2)-120-120-80-60)+(i*160)+60, 660+62, 130, 130);
      }
    }

    for (int i = 0; i<nbSheep; i++) {
      if (listeReponse[i] == 1)image(red, i*1400/nbSheep, height/2-(1400/nbSheep)/2, 1400/nbSheep, 1400/nbSheep);
      else if (listeReponse[i] == 2)image(green, i*1400/nbSheep, height/2-(1400/nbSheep)/2, 1400/nbSheep, 1400/nbSheep);
      else if (listeReponse[i] == 3)image(blue, i*1400/nbSheep, height/2-(1400/nbSheep)/2, 1400/nbSheep, 1400/nbSheep);
      else if (listeReponse[i] == 4)image(yellow, i*1400/nbSheep, height/2-(1400/nbSheep)/2, 1400/nbSheep, 1400/nbSheep);
      else if (listeReponse[i] == 5)image(purple, i*1400/nbSheep, height/2-(1400/nbSheep)/2, 1400/nbSheep, 1400/nbSheep);
    }



    if (click == nbSheep) {
      for (int i = 0; i<nbSheep; i++) {
        if (listeCouleur[i] == listeReponse[i]) {
          nbValeurVraie=i+1;
        }
      }
      if(nbValeurVraie == nbSheep){
         score_general[8] = 3;
         /*fill(0,95);
         rect(0,0,width, height);
         
         fill(255);
         textSize(50);
         textAlign(CENTER,CENTER);
         text("YOU WIN\nscore : "+str(score12), 0,0,width, height);*/
         suivant=true;
         jeu9=false;
      }
      else{
         score_general[8] = 0;
         /*fill(0,95);
         rect(0,0,width, height);
         
         fill(255);
         textSize(50);
         textAlign(CENTER,CENTER);
         text("YOU LOSE\nscore : "+str(score12), 0,0,width, height);*/
         suivant=true;
         jeu9=false;
      }
    }

    /*for (int i = 0; i<nbSheep; i++) {
      print(listeCouleur[i], " ", listeReponse[i], " ", indexListeReponse, " ", nbSheep, " ", click, " ", nbValeurVraie, "\n");
    }
    println("");*/
  }
}





void flappy_bird() {
  //colorMode(RGB,100);
  numJeu=7;//jeu numéro 7

  //textFont(fontflappy);
  textAlign(CENTER, CENTER);  //alignement du texte au centre
  noStroke();  //pas de contours pour les formes


  background(0);
  translate(width/2-250, height/2-375);
  if (!over) { //tant que la partie n'est pas perdu
    fill(130, 210, 230);  //couleur du ciel
    rect(0, 0, 500, 750);  //ciel

    ySpeed -= accel; //variation de la valeurs de la vitesse de l'oiseau
    y_7 -= ySpeed;  //variation de la position de l'oiseau

    image(bird, x_7, y_7, 60, 50); //affichage de l'oiseau



    for (int j = 0; j<2; j++) {  //boucle qu passe dans tout les tubes
      image(tube, tab_tubeX[j], tab_tubeY[j], 78, 1500);  //affichage des tubes
      tab_tubeX[j] = tab_tubeX[j] - move_tube;  //variation de la position en X des tubes
      if (tab_tubeX[j]<-75) {  //si un tubes arrive a gauche, elle repart a droite
        tab_tubeX[j] = tab_tubeX[j]+570;
        tab_tubeY[j] = int(random(-550, -350));  //lorsque un tube apparait a droite, il change de hauteur
        a_7++;//le score augmente de 1
      }
    }


    fill(130, 210, 230);
    rect(-(width/2-250), height-150, width, 75);
    rect(-(width/2-250), -75, width/2-250, height);
    rect(500, -75, width/2-250, height);
    rect(-(width/2-250), -75, width, 75);



    fill(50, 140, 75);  //couleur de l'herbe
    //rect(0, 600, 500, 150);  //herbe verte
    rect(-(width/2-250), 600, width, 300);


    noFill();
    stroke(0);
    strokeWeight(2);
    //0, 0, 500, 750 ciel
    //0, 600, 500, 150 terre
    rect(0, 0, 500, 750);
    noStroke();



    for (int j = 0; j<2; j++) {  //test collisions avec les tubes
      if (((x_7+55 > tab_tubeX[j]) && (y_7+2 < tab_tubeY[j] + 642) && (x_7<tab_tubeX[j] + 78)) || ((x_7+58 > tab_tubeX[j]) && (y_7+48 > tab_tubeY[j]+843) && (x_7<tab_tubeX[j]+78))) {
        over = true;  //si l'oiseau touche un tube, c'est perdu
      }
    }
    if (y_7+50>600 ||y_7<0) {  //test collisions avec haut et bas
      over = true;  //si l'oiseau touche la bordure haute ou basse
    }

    fill(255);  //blanc
    textSize(50);  //taille du texte pour afficher le score
    text(a_7, 250, 55);  //score final
  } else { //si la partie est perdu
    if (a_7<5)score7=0;
    if (a_7<10 && a_7>5)score7=1;
    if (a_7<15 && a_7>10)score7=2;
    if (a_7>15)score7=3;
    score_general[6]=score7;
    print(score7);
    jeu7=false;
    suivant=true;
    /*noLoop();  //on stoppe la boucle du programme
     fill(0, 200); //couleur noir en transparence
     rect(0, 0, 500, 750);
     fill(255);
     
     text("Score", 255, 255 );
     text(score_7, 255, 370);  //affichage du score
     textSize(30);
     text("ESPACE pour recommencer", 250, 530);*/
  }
}

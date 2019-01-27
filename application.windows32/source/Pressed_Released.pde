void keyPressed() {
  //----------------------------pour jeu 0 (menu des niveaux)-------------------------------
  if (numJeu==0) {
  }
  //------------------------pour jeu 1------------------------------------------
  if (numJeu==1) {
    if (keyCode == UP)sheep.up = true;
    if (keyCode == DOWN)sheep.down = true;
    if (keyCode == RIGHT)sheep.right = true;
    if (keyCode == LEFT)sheep.left = true;
  }

  //------------------------pour jeu 2-----------------------------------------
  if (numJeu==2) {
    if ( mur1!= pixelmurs && mur5!=pixelmurs) {
      if (key == 'z' )
      {
        y2=y2-2;
        //ellipse(x2, y2, 60, 60);
        a2=a2-2;
        //ellipse(z2, a2, 60, 60);
        mur1=get(x2, y2-5);
      }
    }
    if ( mur2!= pixelmurs && mur6!= pixelmurs ) {
      if (key == 's')
      {
        y2=y2+2;
        //ellipse(x2, y2, 60, 60);
        a2=a2+2;
        //ellipse(z2, a2, 60, 60);
      }
    }
    if (mur4!= pixelmurs ) {
      if (key == 'q')
      {
        x2=x2-2;
        //ellipse(x2, y2, 60, 60);
      }
    }
    if ( mur3!= pixelmurs ) {
      if (key == 'd')
      {
        x2=x2+2;
        //ellipse(x2, y2, 60, 60);
      }
    }
    if ( mur8!= pixelmurs ) {
      if (key == 'i')
      {
        z2=z2-2;
        //ellipse(z2, a2, 60, 60);
      }
    }
    if ( mur7!= pixelmurs ) {
      if (key == 'p')
      {
        z2=z2+2;
        //ellipse(z2, a2, 60, 60);
      }
    }
  }
  //--------------------------------pour jeu 3-------------------------------------
  if (numJeu==3) {
    if (key == ' ')
    {
      duree_3+=1;
      x1_3=100;
      x_3=-800;
      if (duree_3%60==0)
      {
        x_3=100;
        x1_3=-800;
        fill(204, 250, 255);
        rect(100, 340, 200, 200);
        image(mouton1, x_3, 500, 200, 200);      
        duree_3=0;
      }
    }
    if (key == 'a')
    {
      a_3=false;
    }
    
  }
  //--------------------------pour jeu 4----------------------------------
  if (numJeu==4) {
    if (keyCode == UP)up = true;
    if (keyCode == DOWN)down = true;
    if (keyCode == LEFT)left = true;
    if (keyCode == RIGHT)right = true;
  }
  //----------------------------pour jeu 5-------------------------------
  if (numJeu==5) {
  }
  //----------------------------pour jeu 6--------------------------------
  if (numJeu==6) {
  }
  //------------------------------pour jeu 7--------------------------------
  if (numJeu==7) {
   
    if (key == ' ' && over == false) {  //test si la barre espace est pressée ET que la partie n'est pas perdu
      ySpeed = speed * sin(radians(angle));  //loi de Newton pour la variation en y de l'oiseau
      accel = 0.6;
      move_tube = 2;  //deplacement des tubes
    }
    if (key == ' ' && over == true) {  //test si la barre espace est pressée ET que la partie est perdu
      loop();  //on recommence a boucler le programme
      x_7=75;  //on réinitialise les valeurs
      y_7 = 2*(600/3);  //on réinitialise les valeurs
      ySpeed = 0;  //on réinitialise les valeurs
      accel = 0;  //on réinitialise les valeurs
      move_tube = 0;  //on réinitialise les valeurs
      score_7 = 0;  //on réinitialise les valeurs
      over = false;  //on réinitialise les valeurs
      for (int i = 0; i<2; i++) {//initialisation des deux premiers tubes
        tab_tubeX[i] = i*575/2 + 300;  //on réinitialise les valeurs
        tab_tubeY[i] = int(random(-550, -350));  //on réinitialise les valeurs
      }
    }
  
  }
  //-------------------------------pour jeu 8--------------------------------
  if (numJeu==8) {
  }
  //----------------------------------pour jeu 9----------------------------
  if (numJeu==9) {
  }
  //---------------------------------pour jeu 10------------------------------
  if (numJeu==10) {
  }
}

void keyReleased() {
  //----------------------------pour jeu 1------------------------------------
  if (numJeu==1) {
    if (keyCode == UP)sheep.up = false;
    if (keyCode == DOWN)sheep.down = false;
    if (keyCode == RIGHT)sheep.right = false;
    if (keyCode == LEFT)sheep.left = false;
  }
  //--------------------------pour jeu 2----------------------------------------
  if (numJeu==2) {
  }
  //---------------------------pour jeu 3---------------------------------------
  if (numJeu==3) {
    x_3=100;
    x1_3=-800;
    duree_3=0;
  }
  //--------------------------pour jeu 4-----------------------------------------
  if (numJeu==4) {
    if (keyCode == UP)up = false;
    if (keyCode == DOWN)down = false;
    if (keyCode == LEFT)left = false;
    if (keyCode == RIGHT)right = false;
  }
  //-----------------------pour jeu 5----------------------------------------
  if (numJeu==5) {
  }
  //----------------------------pour jeu 6-------------------------------------
  if (numJeu==6) {
  }
  //------------------------pour jeu 7---------------------------------------
  if (numJeu==7) {
  }
  //--------------------------pour jeu 8----------------------------------
  if (numJeu==8) {
  }
  //------------------------pour jeu 9-------------------------------------
  if (numJeu==9) {
  }
  //---------------------pour jeu 10--------------------------------------
  if (numJeu==10) {
  }
}

//---------------------------------------------------------------------------------
// Déclaration de variables globales
//---------------------------------------------------------------------------------





//---------------------------------------------------------------------------------
// setup : initialisations
//---------------------------------------------------------------------------------
void setup()
{
  //taille fenêtre
  size(1400, 800);
  smooth();
  orientation (LANDSCAPE);
  for (int iniveau=0; iniveau<x_cercle_niveaux.length; iniveau++) {
    rayon_cercle_niveaux[iniveau]-=50;
  }

  maze = loadImage("maze.png");

  //-----------------------------------jeu3-----------------------------------------
  //mouton1=loadImage("mouton.png");
  //mouton2=loadImage("mouton2.png"); 
  //mouton3=loadImage("mouton3.png");

  //------------------------------------creation du fond d'écran des niveaux-----------------
  /*fondecran_niv = loadImage("niveaux.jpg");
   background(fondecran_niv);
   decallage=5;//decalage relief
   for (int iniveau=0;iniveau<x_cercle_niveaux.length;iniveau++){
   decallage=5/(iniveau+1);//decalage relief
   //rayon_cercle_niveaux[iniveau]-=20;
   //relief
   fill(0,0,0,80);//noir
   ellipse(x_cercle_niveaux[iniveau]+decallage, y_cercle_niveaux[iniveau]+decallage, rayon_cercle_niveaux[iniveau], rayon_cercle_niveaux[iniveau]); // niveaux
   //cercles niveaux
   fill(211, 15, 25);//rouge ferme
   ellipse(x_cercle_niveaux[iniveau], y_cercle_niveaux[iniveau], rayon_cercle_niveaux[iniveau], rayon_cercle_niveaux[iniveau]); // niveaux
   //num niveaux
   fill(0);
   textSize(rayon_cercle_niveaux[iniveau]/2);
   textAlign(CENTER, CENTER);
   text(iniveau+1, x_cercle_niveaux[iniveau], y_cercle_niveaux[iniveau]-5/(iniveau+1));// niveaux
   
   // Sauvegarde de la fenêtre
   save("data/background_niveaux.png");
   }*/
  //------------------------------------------------------------------------------------------

  //-------------------------------------------jeu6---------------------------------------
  a_6 = random(-PI/3, PI/3);
  ballSpeed.x = cos(a_6)*10;
  if (random(2) < 1) ballSpeed.x *= -1;
  ballSpeed.y = sin(a_6)*10; 
  textFont(createFont("Arial", 40));


  //------------------------------------------jeu7-----------------------------------------------------
  //fontflappy = createFont("Montserrat", 50);                                                 // demander à robin....


  angle = 90;  //angle du jump
  speed = 9;  //vitesse de l'oiseau pendant les sauts

  bird = loadImage("bird.png");  //importation de l'image de l'oiseau
  tube = loadImage("tube.png");  //importation de l'image de tube

  for (int i = 0; i<2; i++) {//initialisation des deux premiers tubes
    tab_tubeX[i] = i*575/2 + 300;  //initialisation des valeurs en X des tubes
    tab_tubeY[i] = int(random(-550, -350));  //initialisation des valeurs en Y des tubes
  }

  //----------------------------------------jeu8---------------------------------------------------------
  x_8 = int(random(width-taille_8));
  y_8 = int(random(height-taille_8)); 

  taille2_8 = (int)((Math.random()*30)+50);

  mouton_black = loadImage("mouton_black.png"); 
  mouton_black_eyes = loadImage("mouton_black_eyes.png"); 


  //------------------------------jeu9-------------------------------------------------------------------
  listeCouleur = new int[nbSheep];
  listeReponse = new int[nbSheep];

  red = loadImage("red.png");//1
  green = loadImage("green.png");//2
  blue = loadImage("blue.png");//3
  yellow = loadImage("yellow.png");//4
  purple = loadImage("purple.png");//5


  for (int i = 0; i<nbSheep; i++) {
    listeCouleur[i] = (int)((Math.random()*10)%5)+1;
  }

  //-------------------------------------------------jeu10-------------------------------------------------
  background1 = loadImage("background1.jpg");
  background2 = loadImage("background2.png");
  background3 = loadImage("background3.jpg");


  //-----------------------------initialisiation-------------------------------------------------------
  accueil=true;
  niveaux=false;
  niveaudebloque=0;
}
//---------------------------------------------------------------------------------
// draw : instructions exécutées 60 fois par seconde
//---------------------------------------------------------------------------------
void draw()
{

  background(255);
  if (fin==false) {
    if (accueil==true) {
      afficher_accueil();
    } else {
      if (niveaux==true) {
        //jouer();
        niveaux();
      } else if (niveaux==false) {
        if (suivant==true) {
          retour_niveaux();
        } else {
          if (jeu1==true) {
            mouton_loups();
            niveaudebloque=1;
          } else if (jeu2==true) {
            deplacement_separe();
            niveaudebloque=2;
          } else if (jeu3==true) {
            regles();
            niveaudebloque=3;
          } else if (jeu4==true) {
            labyrinthe();
            niveaudebloque=4;
          } else if (jeu5==true) {
            afficher_accueil_chemin();
            niveaudebloque=5;
          } else if (jeu6==true) {
            ping_pong();
            niveaudebloque=6;
          } else if (jeu7==true) {
            flappy_bird();
            niveaudebloque=7;
          } else if (jeu8==true) {
            find_shauwn();
            niveaudebloque=8;
          } else if (jeu9==true) {
            SimonSheep();
            niveaudebloque=9;
          } else if (jeu10==true) {
            quiVeutGagnerDesMoutons();
            niveaudebloque=10;
            
          }
        }
      }
    }
  } else 
  Final();
}


//---------------------------------------------------------------------------------
// souris
//---------------------------------------------------------------------------------
void mousePressed() {
  if (niveaux==true) {
    jouer();
  } else if (accueil==true) {
    if (mousePressed)
    {
      accueil=false;
      niveaux=true;
    }
  }
  if (jeu9==true) {

    if (flag == 1) {

      for (int i = 0; i<5; i++) {
        if (dist(mouseX, mouseY, ((width/2)-120-120-80-60)+(i*160)+60, 660+62) < 65) {

          if (i == 0 && mousePressed && mouseButton == LEFT) {

            try {
              listeReponse[click] = 1;
              if (click<=nbSheep-1)click++;
            } 
            catch(ArrayIndexOutOfBoundsException e) {
              println("test");
            }
          } else if (i == 1 && mousePressed && mouseButton == LEFT) {
            try {
              listeReponse[click] = 2;
              if (click<=nbSheep-1)click++;
            } 
            catch(ArrayIndexOutOfBoundsException e) {
              println("test");
            }
          } else if (i == 2 && mousePressed && mouseButton == LEFT) {

            try {
              listeReponse[click] = 3;
              if (click<=nbSheep-1)click++;
            } 
            catch(ArrayIndexOutOfBoundsException e) {
              println("test");
            }
          } else if (i == 3 && mousePressed && mouseButton == LEFT) {

            try {
              listeReponse[click] = 4;
              if (click<=nbSheep-1)click++;
            } 
            catch(ArrayIndexOutOfBoundsException e) {
              println("test");
            }
          } else if (i == 4 && mousePressed && mouseButton == LEFT) {

            try {
              listeReponse[click] = 5;
              if (click<=nbSheep-1)click++;
            } 
            catch(ArrayIndexOutOfBoundsException e) {
              println("test");
            }
          }
        }
      }
    }
  }
  if (jeu10==true) {
    if (numQuestion < 3) {
      if (dist(mouseX, mouseY, (1400/2)-200, 500)<100 && mousePressed && mouseButton == LEFT && numQuestion == 0) { 
        numQuestion++;
      } else if (dist(mouseX, mouseY, (1400/2)+200, 500)<100 && mousePressed && mouseButton == LEFT && numQuestion == 0) { 
        score10++;
        numQuestion++;
      } else if (dist(mouseX, mouseY, (1400/2)-200, 500)<100 && mousePressed && mouseButton == LEFT && numQuestion == 1) {

        score10++;
        numQuestion++;
      } else if (dist(mouseX, mouseY, (1400/2)+200, 500)<100 && mousePressed && mouseButton == LEFT && numQuestion == 1) {


        numQuestion++;
      } else if (dist(mouseX, mouseY, (1400/2)-200, 500)<100 && mousePressed && mouseButton == LEFT && numQuestion == 2) {
        numQuestion++;
      } else if (dist(mouseX, mouseY, (1400/2)+200, 500)<100 && mousePressed && mouseButton == LEFT && numQuestion == 2) { 

        score10++;
        numQuestion++;
      }
    }
  }
}

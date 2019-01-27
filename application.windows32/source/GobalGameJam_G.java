import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import javax.swing.JOptionPane; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class GobalGameJam_G extends PApplet {

//---------------------------------------------------------------------------------
// Déclaration de variables globales
//---------------------------------------------------------------------------------





//---------------------------------------------------------------------------------
// setup : initialisations
//---------------------------------------------------------------------------------
public void setup()
{
  //taille fenêtre
  
  
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
    tab_tubeY[i] = PApplet.parseInt(random(-550, -350));  //initialisation des valeurs en Y des tubes
  }

  //----------------------------------------jeu8---------------------------------------------------------
  x_8 = PApplet.parseInt(random(width-taille_8));
  y_8 = PApplet.parseInt(random(height-taille_8)); 

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
public void draw()
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
public void mousePressed() {
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
PImage Final;
int total_tmp=0;
public void Final(){
  Final=loadImage("niveaux.jpg");
  background(Final);
  textAlign(CENTER, CENTER);
  
  total_tmp=score_general[0]+score_general[1]+score_general[2]+score_general[3]+score_general[4]+score_general[5]+score_general[6]+score_general[7]+score_general[8]+score_general[9];

  println(total_tmp);
  textSize(50);
  text("Shaun le Mouton a réussi à rejoindre son troupeau\n\n\nVotre score est de : "+total_tmp,0,0,width,height);
  
  stroke(0);
  fill(255);
  rect(width/2-100, height-100, 200, 60,10);
  fill(0);
  textSize(30);
  text("QUITTER",width/2, height-100+30);
  if (mouseX>=width/2-100 && mouseX<=width/2+100 && mouseY>=height-100 && mouseY<=height-100+60){
    if (mousePressed==true)
      exit();
  }
  textAlign(CORNER, CORNER);
}
public void keyPressed() {
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
      accel = 0.6f;
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
        tab_tubeY[i] = PApplet.parseInt(random(-550, -350));  //on réinitialise les valeurs
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

public void keyReleased() {
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

public void afficher_accueil()
{
  //affichage nom et ecran d'acceuil
  background(0); 
  fondecran = loadImage("Fond.jpg");
  image(fondecran, 0, 0, 1400, 800);
  fill(0);
  textAlign(CENTER);
  textSize(100);
  text("Sheep'Game", 700, 450);
  
}
//---------------------------------------------------------------------------------
// Déclaration de variables globales
//---------------------------------------------------------------------------------
boolean suivant=false;
//---------------------------------------------------------------------------------
//                                   acceuil
//---------------------------------------------------------------------------------
PImage fondecran;
boolean fin=false;
//---------------------------------------------------------------------------------
//                                   menu
//---------------------------------------------------------------------------------


//---------------------------------------------------------------------------------
//                                   niveaux
//---------------------------------------------------------------------------------
int numJeu=0;

int diametreCercle=100;
PImage ferme, enclos,fondecran_niveaux,fondecran_niv;
int decallage;
int []xetoile={1094/10, 1100/10, 1103/10, 1108/10};//coordonée x de chaque images etoiles
int []yetoile={428/10, 428/10, 431/10, 428/10};//coordonée y de chaque images etoiles
//moi
/*int []x_cercle_niveaux = {150,200,330,490,580,700,850,1020,1150,1230};//coordonée x de chaque centre des cercles rouges
int []y_cercle_niveaux = {330,490,600,530,360,220,130,200,340,510};//coordonée y de chaque centre des cercles rouges
int []diametre_cercle_niveaux={100,100,100,100,100,100,100,100,100,100};//diametre de chaque cercle*/

//justine
int []x_cercle_niveaux = {962,664,400,200,275,410,525,615,685,750};//coordonée x de chaque centre des cercles rouges
//int []y_cercle_niveaux = {645,651,614,526,398,325,315,305,294,285};//coordonée y de chaque centre des cercles rouges
int []y_cercle_niveaux = {600,620,610,520,350,330,315,310,300,295};//coordonée y de chaque centre des cercles rouges
int []rayon_cercle_niveaux={278,270,241,206,160,132,118,95,87,80};//diametre de chaque cercle

int []score_general=new int[10];//tous les scores sont rentréss dans ce tableau

PImage etoile_niveaux;

  int score1=0;
  int score2=0;
  int score3=0;
  int score4=0;
  int score5=0;
  int score6=0;
  int score7=0;
  int score8=0;
  int score9=0;
  int score10=0;

//---------------------------------------------------------------------------------
//                                   jeu1
//---------------------------------------------------------------------------------
Loup loup1 = new Loup(1000, 100, "right");
Loup loup2 = new Loup(900, 500, "down");
Loup loup3 = new Loup(700, 100, "left");
Loup loup4 = new Loup(200, 400, "up");
Loup loup5 = new Loup(900, 400, "right");
Loup loup6 = new Loup(800, 100, "down");
Loup loup7 = new Loup(1300, 600, "left");
Loup loup8 = new Loup(200, 300, "right");
Loup loup9 = new Loup(100, 100, "down");

Sheep sheep = new Sheep(1350, 750);

int moveX_1 = 2;
int moveY_1 = 0;

int moveX_2 = 0;
int moveY_2 = 1;

int moveX_3 = -2;
int moveY_3 = 0;

int moveX_4 = 0;
int moveY_4 = -1;

int moveX_5 = 1;
int moveY_5 = 0;

int moveX_6 = 0;
int moveY_6 = 1;

int moveX_7 = -1;
int moveY_7 = 0;

int moveX_8 = 1;
int moveY_8 = 0;

int moveX_9 = 0;
int moveY_9 = 1;

int scoreFinal, scoreFinalFinal;



//---------------------------------------------------------------------------------
//                                   jeu2
//---------------------------------------------------------------------------------
PImage mirroir;
int x2=345;
int y2=770;
int z2=1045;
int a2=770;
int mur1, mur3, mur4;
int mur2, mur5, mur6, mur7, mur8;
float compteur=0;
boolean test=false;
int pixelmurs=-4621737;


//---------------------------------------------------------------------------------
//                                   jeu3
//---------------------------------------------------------------------------------
PImage mouton1;
PImage mouton2;
PImage mouton3;
PImage etoile_vide;
PImage etoile;

int x_3=100, x1_3=-800;

float vitesse_3=0;
float posmouton_3=1410;
float posmouton2_3=2000;

int score_3=0;
int duree_3=0;
int temps_3=0;

boolean a_3=true;

//---------------------------------------------------------------------------------
//                                   jeu4
//---------------------------------------------------------------------------------
PImage maze;
int x4 = 700;//position initiale en x
int y4 = 758; // position initiale en y
int vie = 3;

boolean up = false;
boolean down = false;
boolean right = false;
boolean left = false;

int c;
PImage troll;

//---------------------------------------------------------------------------------
//                                   jeu5
//---------------------------------------------------------------------------------
PImage fondecran_5;
boolean test_5=false;

//chemin1
PImage grotte1;
boolean test1_5=false;
int a_5,b_5,c_5=0;
//chemin2
boolean test2_5=false;
//chemin3
boolean test3_5=false;
//end
//PImage etoile;

//---------------------------------------------------------------------------------
//                                   jeu6
//---------------------------------------------------------------------------------
float a_6;

double PlayerPos = 360;
double PlayerSpeed = 0;
int PlayerPoints = 0;
double OpponentPos = 360;
double OpponentSpeed = 0;
 
PVector ball = new PVector(640, 360);
PVector ballSpeed = new PVector(0, 0);

PImage mouton1_6;
PImage mouton2_6;
 
 
int c_6 = 0;

//---------------------------------------------------------------------------------
//                                   jeu7
//---------------------------------------------------------------------------------

int a_7=0;
float x_7=75;  //position initial en X de l'oiseau
float y_7 = 2*(600/3);  //position initial en Y de l'oiseau
float speed;  //vitesse de l'oiseau a chaque saut
float angle;  //angle par rapport a l'horizontal vers lequel l'oiseau saute 



float ySpeed;  //vitesse en y de l'oiseau (Newton)
float accel = 0;  //acceleration de l'oiseau pour simuler la gravite (Newton)

PImage bird;  //declaration de l'image de l'oiseau
PImage tube;  //declaration de l'image des tubes

int[] tab_tubeX = new int[2];  //tableau comportant les positions en X des tubes
int[] tab_tubeY = new int[2];  //tableau comportant les positions en Y des tubes

int move_tube = 0;  //vitesse des tubes en X
int score_7 = 0;  //variable utile pour les scores

boolean over = false;  //variable pour la fin de partie

//PFont fontflappy;

//---------------------------------------------------------------------------------
//                                   jeu8
//---------------------------------------------------------------------------------

int x_8, y_8;
int taille_8 = 80;
int taille2_8;

PImage mouton_black, mouton_black_eyes;


int tmp_8 = 0;


//---------------------------------------------------------------------------------
//                                   jeu9
//---------------------------------------------------------------------------------
int nbSheep = 8;
int compteur_9 = 0;
int indexListeReponse = 0;
int click = 0;

int flag = 0;

PImage red, green, blue, yellow, purple;

int[] listeCouleur;
int[] listeReponse;

int nbValeurVraie = 0;

int score12 = 0;

//---------------------------------------------------------------------------------
//                                   jeu10
//---------------------------------------------------------------------------------
int numQuestion = 0; // de 0 a 2 pour les questions et >2 pour l'affichage de fin

String[] listeQuestion = {"La fourrure du mouton ne grandi pas indéfiniment", "Le champ de vision du mouton est de 360 degrés", "Les moutons ont un odorat très peu développé"};

PImage background1, background2, background3;


//---------------------------------------------------------------------------------
//                                   retour menu
//---------------------------------------------------------------------------------
int i=0;
PImage fond0, fond1, fond2, fond3;
PImage bouton;





public void quiVeutGagnerDesMoutons() {
  numJeu=10;//jeu numéro 10
  
  if (numQuestion == 0) {
    image(background1, 0, 0, width, height);
    fill(255, 90);
    noStroke();
    rect(50, 50, width - 100, height - 100, 50);
    textAlign(CENTER, CENTER);
    textSize(50);
    fill(0);
    text(listeQuestion[numQuestion], 50, 100, width - 100, height - 500);

    strokeWeight(20);

    if (dist(mouseX, mouseY, (1400/2)-200, 500)<100) {
      fill(0xff64DB6C);
      stroke(0xff5C9B60);
      
    } else {
      fill(0xff31C43C);
      stroke(0xff12811A);
    }
    ellipse((1400/2)-200, 500, 200, 200);
    fill(0);
    text("Vrai", (1400/2)-300, 393, 200, 200);

    

    if (dist(mouseX, mouseY, (1400/2)+200, 500)<100) {
      fill(0xffEA5A5A);
      stroke(0xffAD3434);
    } else {
      fill(0xffFC2626);
      stroke(0xff6F1515);
    }
    ellipse((1400/2)+200, 500, 200, 200);
    fill(0);
    text("Faux", (1400/2)+100, 393, 200, 200);
    
  }
  else if (numQuestion == 1) {
    image(background2, 0, 0, width, height);
    fill(255, 90);
    noStroke();
    rect(50, 50, width - 100, height - 100, 50);
    textAlign(CENTER, CENTER);
    textSize(50);
    fill(0);
    text(listeQuestion[numQuestion], 50, 100, width - 100, height - 500);

    strokeWeight(20);

    if (dist(mouseX, mouseY, (1400/2)-200, 500)<100) {
      fill(0xff64DB6C);
      stroke(0xff5C9B60);
      
    } else {
      fill(0xff31C43C);
      stroke(0xff12811A);
    }
    ellipse((1400/2)-200, 500, 200, 200);
    fill(0);
    text("Vrai", (1400/2)-300, 393, 200, 200);

    

    if (dist(mouseX, mouseY, (1400/2)+200, 500)<100) {
      fill(0xffEA5A5A);
      stroke(0xffAD3434);
      
    } else {
      fill(0xffFC2626);
      stroke(0xff6F1515);
    }
    ellipse((1400/2)+200, 500, 200, 200);
    fill(0);
    text("Faux", (1400/2)+100, 393, 200, 200);
    
    
  } 
  else if (numQuestion == 2) {
    
    image(background3, 0, 0, width, height);
    fill(255, 90);
    noStroke();
    rect(50, 50, width - 100, height - 100, 50);
    textAlign(CENTER, CENTER);
    textSize(50);
    fill(0);
    text(listeQuestion[numQuestion], 50, 100, width - 100, height - 500);

    strokeWeight(20);

    if (dist(mouseX, mouseY, (1400/2)-200, 500)<100) {
      fill(0xff64DB6C);
      stroke(0xff5C9B60);
      
    } else {
      fill(0xff31C43C);
      stroke(0xff12811A);
    }
    ellipse((1400/2)-200, 500, 200, 200);
    fill(0);
    text("Vrai", (1400/2)-300, 393, 200, 200);

    

    if (dist(mouseX, mouseY, (1400/2)+200, 500)<100) {
      fill(0xffEA5A5A);
      stroke(0xffAD3434);
      
    } else {
      fill(0xffFC2626);
      stroke(0xff6F1515);
    }
    ellipse((1400/2)+200, 500, 200, 200);
    fill(0);
    text("Faux", (1400/2)+100, 393, 200, 200);
    
  }
  
  else if(numQuestion > 2){
    //mettre l'image de la fin en fonction du score
    //score est stocké dans la variable score10
    
    score_general[9] = score10;
    suivant=true;
    jeu10=false;
    strokeWeight(1);
    
  }
}
class Loup {
  int x; //position en x
  int y; // position en y
  String look; // orientation du loup (up, down, left, right)


  Loup(int x, int y, String orientation) {
    this.x = x;
    this.y = y;
    this.look = orientation;
  }

  public void display() {
    stroke(59, 61, 56); //couleur du contour
    strokeWeight(5); //taille du coutonr
    fill(118, 117, 106); //couleur du loup
    ellipse(this.x, this.y, 80, 80); //objet loup
  }

  public void champVision() {
    if (this.look == "up") {
      noStroke();
      fill(107, 183, 77);
      triangle(this.x-100, this.y-200, this.x, this.y, this.x+100, this.y-200); 
      arc(this.x, this.y-101, 280, 280, 5*PI/4, 7*PI/4);
      stroke(0);
      fill(255);
    } else if (this.look == "right") {
      noStroke();
      fill(107, 183, 77);
      triangle(this.x+200, this.y-100, this.x, this.y, this.x+200, this.y+100); 
      arc(this.x+101, this.y, 280, 280, -1*PI/4, 1*PI/4);
      stroke(0);
      fill(255);
    } else if (this.look == "down") {
      noStroke();
      fill(107, 183, 77);
      triangle(this.x+100, this.y+200, this.x, this.y, this.x-100, this.y+200); 
      arc(this.x, this.y+101, 280, 280, 1*PI/4, 3*PI/4);
      stroke(0);
      fill(255);
    } else if (this.look == "left") {
      noStroke();
      fill(107, 183, 77);
      triangle(this.x-200, this.y-100, this.x, this.y, this.x-200, this.y+100); 
      arc(this.x-101, this.y, 280, 280, 3*PI/4, 5*PI/4);
      stroke(0);
      fill(255);
    }
  }
}
class Sheep {
  int x; //position en x du mouton
  int y; // position en y du mouton
  boolean up = false;
  boolean right = false;
  boolean left = false;
  boolean down = false;


  Sheep(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void display() {
    fill(248, 235, 198);
    strokeWeight(5);
    stroke(188, 168, 135);
    ellipse(this.x, this.y, 50, 50);
  }

  public void move() {
    if (this.up == true && sheep.y > 0)this.y-=2;
    if (this.down == true && sheep.y < height)this.y+=2;
    if (this.left == true && sheep.x > 0)this.x-=2;
    if (this.right == true && sheep.x < width)this.x+=2;
  }

  public void collision() {
    for (int i = 0; i<12; i++) {
      int c = get(PApplet.parseInt(this.x+(cos(i*PI/6))*26), PApplet.parseInt(this.y+(sin(i*PI/6))*26));//je récupère la couleur sur le contour du mouton
      if (red(c) == 107 && green(c) == 183 && blue(c) == 77) { // si la couleur est egale a celle du champ de vision du loup on stop
        //stop();
        score_general[0]=0;
        suivant=true;
        jeu1=false;
      }
    }
  }
}
public void mouton_loups() {
  numJeu=1;//jeu numéro 1

  score1++;

  background(75, 93, 59);

  fill(0xffB45B16);
  noStroke();
  rect(0, 0, 100, 100);

  loup1.champVision();
  loup2.champVision();
  loup3.champVision();
  loup4.champVision();
  loup5.champVision();
  loup6.champVision();
  loup7.champVision();
  loup8.champVision();
  loup9.champVision();

  loup1.display();
  loup2.display();
  loup3.display();
  loup4.display();
  loup5.display();
  loup6.display();
  loup7.display();
  loup8.display();
  loup9.display();

  sheep.display();
  sheep.move();
  sheep.collision();

  if (sheep.x < 100 && sheep.x > 0 && sheep.y < 100 && sheep.y > 0) {
    fill(0, 0, 0, 25);
    rect(0, 0, width, height);
    textSize(100);
    textAlign(CENTER, CENTER);
    fill(255);

    scoreFinal = floor(score1/1200);
    if (scoreFinal > 3)scoreFinalFinal = 1;
    else scoreFinalFinal = 3-scoreFinal;
    score1 = scoreFinalFinal;
    //text("YOU WIN\nScore : "+score1, 0, 0, width, height);
    score_general[0]=score1;
    //stop();
    
    suivant=true;
    jeu1=false;
  }

  //ajout de move pour déplacement
  loup1.x+=moveX_1;
  loup1.y+=moveY_1;

  loup2.x+=moveX_2;
  loup2.y+=moveY_2;

  loup3.x+=moveX_3;
  loup3.y+=moveY_3;

  loup4.x+=moveX_4;
  loup4.y+=moveY_4;

  loup5.x+=moveX_5;
  loup5.y+=moveY_5;

  loup6.x+=moveX_6;
  loup6.y+=moveY_6;

  loup7.x+=moveX_7;
  loup7.y+=moveY_7;

  loup8.x+=moveX_8;
  loup8.y+=moveY_8;

  loup9.x+=moveX_9;
  loup9.y+=moveY_9;

  /////////////////////////////////////////////////////////////

  //1er loup
  if (loup1.x  == 1300 && loup1.y == 100) {
    moveX_1 = 0;
    moveY_1 = 2;
    loup1.look = "down";
  } else if (loup1.x  == 1300 && loup1.y == 700) {
    moveX_1 = -2;
    moveY_1 = 0;
    loup1.look = "left";
  } else if (loup1.x  == 1000 && loup1.y == 700) {
    moveX_1 = 0;
    moveY_1 = -2;
    loup1.look = "up";
  } else if (loup1.x  == 1000 && loup1.y == 100) {
    moveX_1 = 2;
    moveY_1 = 0;
    loup1.look = "right";
  }

  /////////////////////////////////////////////////////////////

  //2eme loups
  if (loup2.x  == 900 && loup2.y == 700) {
    moveX_2 = -1;
    moveY_2 = 0;
    loup2.look = "left";
  } else if (loup2.x  == 100 && loup2.y == 700) {
    moveX_2 = 0;
    moveY_2 = -1;
    loup2.look = "up";
  } else if (loup2.x  == 100 && loup2.y == 500) {
    moveX_2 = 1;
    moveY_2 = 0;
    loup2.look = "right";
  } else if (loup2.x  == 900 && loup2.y == 500) {
    moveX_2 = 0;
    moveY_2 = 1;
    loup2.look = "down";
  }

  /////////////////////////////////////////////////////////////

  //3eme loups
  if (loup3.x  == 300 && loup3.y == 100) {
    moveX_3 = 0;
    moveY_3 = 2;
    loup3.look = "down";
  } else if (loup3.x  == 300 && loup3.y == 700) {
    moveX_3 = 2;
    moveY_3 = 0;
    loup3.look = "right";
  } else if (loup3.x  == 700 && loup3.y == 700) {
    moveX_3 = 0;
    moveY_3 = -2;
    loup3.look = "up";
  } else if (loup3.x  == 700 && loup3.y == 100) {
    moveX_3 = -2;
    moveY_3 = 0;
    loup3.look = "left";
  }

  /////////////////////////////////////////////////////////////

  //4eme loups
  if (loup4.x  == 200 && loup4.y == 200) {
    moveX_4 = 1;
    moveY_4 = 0;
    loup4.look = "right";
  } else if (loup4.x  == 1100 && loup4.y == 200) {
    moveX_4 = 0;
    moveY_4 = 1;
    loup4.look = "down";
  } else if (loup4.x  == 1100 && loup4.y == 400) {
    moveX_4 = -1;
    moveY_4 = 0;
    loup4.look = "left";
  } else if (loup4.x  == 200 && loup4.y == 400) {
    moveX_4 = 0;
    moveY_4 = -1;
    loup4.look = "up";
  }

  /////////////////////////////////////////////////////////////

  //5eme loups  // line(900, 400, 1200, 400);
  if (loup5.x  == 1200 && loup5.y == 400) {
    moveX_5 = -1;
    loup5.look = "left";
  } else if (loup5.x  == 900 && loup5.y == 400) {
    moveX_5 = 1;
    loup5.look = "right";
  }

  /////////////////////////////////////////////////////////////

  //6eme loups  //   line(800, 100, 800, 700);
  if (loup6.x  == 800 && loup6.y == 700) {
    moveY_6 = -1;
    loup6.look = "up";
  } else if (loup6.x  == 800 && loup6.y == 100) {
    moveY_6 = 1;
    loup6.look = "down";
  }

  /////////////////////////////////////////////////////////////

  //7eme loups  //   line(100, 600, 1300, 600);
  if (loup7.x  == 100 && loup7.y == 600) {
    moveX_7 = 1;
    loup7.look = "right";
  } else if (loup7.x  == 1300 && loup7.y == 600) {
    moveX_7 = -1;
    loup7.look = "left";
  }

  /////////////////////////////////////////////////////////////

  //8eme loups  //   line(200, 300, 1200, 300);
  if (loup8.x  == 1200 && loup8.y == 300) {
    moveX_8 = -1;
    loup8.look = "left";
  } else if (loup8.x  == 200 && loup8.y == 300) {
    moveX_8 = 1;
    loup8.look = "right";
  }

  /////////////////////////////////////////////////////////////

  //9eme loups  //   line(100, 100, 100, 700);
  if (loup9.x  == 100 && loup9.y == 700) {
    moveY_9 = -1;
    loup9.look = "up";
  } else if (loup9.x  == 100 && loup9.y == 100) {
    moveY_9 = 1;
    loup9.look = "down";
  }
}
public void deplacement_separe()
{

  numJeu=2;//jeu numéro 2

  if (test!=true) {
    background(185,122,87);
    fill(0);
    textAlign(CENTER);
    textSize(100);
    text("Règles du jeu :", 700, 100);
    textSize(40);
    text("Vous déplacez vers le haut et le bas les 2 moutons avec Z et S", 700, 200);
    textSize(40);
    text("Vous déplacez vers la droite et la gauche le mouton de gauche Q et D", 700, 300);
    textSize(40);
    text("Vous déplacez vers la droite et la gauche le mouton de droite I et P", 700, 400);

    textSize(70);
    text("Appuyez sur espace pour commencer", 700, 600);
  }

  if (key== ' ') {
    test=true;
  }
  if (test==true) {
    compteur=compteur+0.16f;
    //affichage labyrinthe fond
    mirroir=loadImage("mirroir.png");
    image(mirroir, 0, 0, 1400, 800);
    fill(248, 235, 198);
    ellipse(x2, y2, 60, 60);
    ellipse(z2, a2, 60, 60);

    //definition des impacts au mur pour mouton gauche
    mur1=get(x2, y2-35);
    mur2=get(x2, y2+35);
    mur3=get(x2+35, y2);
    mur4=get(x2-35, y2);

    //definition des impacts au mur pour mouton droite
    mur5=get(z2, a2-35);
    mur6=get(z2, a2+35);
    mur7=get(z2+35, y2);
    mur8=get(z2-35, y2);


    if (y2<=30)
    {
      
      if (compteur<120)
      {
        score2=3;
      }
      if (compteur>120 && compteur<150)
      {
        score2=2;
      }
      if (compteur>150)
      {
        score2=1;

      }
      score_general[1]=score2;
      jeu2=false;
      suivant=true;
      
    }
  }
}
public void regles()
{

  numJeu=3;//jeu numéro 3
  textAlign(CORNER);



  if (a_3==true) {
    cursor(HAND);
    background(0);
    fill(150, 150, 150);
    rect(305, 490, 810, 210, 50);
    if (x1_3==100)
    {
      fill(0); 
      rect(305, 490, 815, 215, 50);
    }
    fill(176, 178, 175);
    noStroke();
    rect(300, 500, 800, 200, 40);
    fill(255);
    textSize(150);
    text("espace", 450, 630);
    mouton1=loadImage("mouton.png");
    mouton2=loadImage("mouton2.png"); 
    image(mouton1, x_3+500, 290, 200, 200);
    image(mouton2, x1_3+500, 200, 200, 200);


    fill(150);
    ellipse(1210, 310, 200, 200);
    fill(255);
    noStroke();
    ellipse (1200, 300, 200, 200);
    fill(0);
    textSize(30);
    text("cliquer sur a", 1112, 300);
  } 

  if (a_3==false)
  {
    saute_mouton();
  }
}


public void saute_mouton()
{ 


  fill(204, 250, 255);
  rect(0, 0, width, 700);
  fill(49, 119, 92);
  rect(0, 700, width, height);

  affichage_etoile();
  deplacement_mouton();


  line(0, 700, 1400, 700);
  image(mouton1, x_3, 500, 200, 200);
  image(mouton2, x1_3, 340, 200, 200);

  if (x_3==100 && posmouton_3<=300 && posmouton_3+150>=100 )
  {
    jeu3=false;
    suivant=true;
  }
  if (x_3==100 && posmouton2_3<=300 && posmouton2_3+150>=100 )
  {
    jeu3=false;
    suivant=true;
  }
}

public void deplacement_mouton()
{
  vitesse_3=vitesse_3+0.8f;
  posmouton_3=posmouton_3-18-vitesse_3;
  posmouton2_3=posmouton2_3-18-vitesse_3;
  mouton3=loadImage("mouton3.png");
  image(mouton3, posmouton_3, 553, 150, 150); 
  image(mouton3, posmouton2_3, 553, 150, 150);
  if (posmouton_3<=-100)
  {
    posmouton_3=posmouton2_3+1900-random(100, 1000);
  }

  if (posmouton2_3<=-100)
  {
    posmouton2_3=posmouton_3+1900-random(100, 1000);
  }
}

public void affichage_etoile()
{
  score_3=score_3+1;
  textSize(50);
  text(score_3, 1300, 110);
  etoile_vide=loadImage("etoile_vide.png");
  etoile=loadImage("etoile.png");
  if (score_3<150)
  {
    image(etoile_vide, 1200, 10, 50, 50);
    image(etoile_vide, 1260, 10, 50, 50);
    image(etoile_vide, 1320, 10, 50, 50);
    score_general[2]=0;
  } 
  if (score_3<300 && score_3>150)
  {
    image(etoile, 1200, 10, 50, 50);
    image(etoile_vide, 1260, 10, 50, 50);
    image(etoile_vide, 1320, 10, 50, 50);
    score_general[2]=1;
  }
  if (score_3<600 && score_3>300)
  {
    image(etoile, 1200, 10, 50, 50);
    image(etoile, 1260, 10, 50, 50);
    image(etoile_vide, 1320, 10, 50, 50);
    score_general[2]=2;
  } 
  if (score_3>600) {
    image(etoile, 1200, 10, 50, 50);
    image(etoile, 1260, 10, 50, 50);
    image(etoile, 1320, 10, 50, 50);
    score_general[2]=3;
  }
}
public void labyrinthe(){
  
  numJeu=4;//jeu numéro 4
  
  surface.setTitle("Nombre de vie : "+str(vie));
  
  image(maze, 0,0,1400, 800);
  noStroke();
  fill(145, 83, 28);
  rect(1327, 730, 54, 53);
  
  /*
  //triche----------------------------------------------------------------------
  fill(107,183,77);
  rect(700, 730, 1327-700, 100);
  //------------------------------------------------------------------------------
  */
  
  fill(248, 235, 198);
  strokeWeight(3);
  stroke(188, 168, 135);
  ellipse(x4,y4, 30, 30);
  
  if(up == true)y4-=4;
  if(down == true)y4+=4;
  if(left == true)x4-=4;
  if(right == true)x4+=4;
  
  for(int i = 0; i<4; i++){
    c = get(PApplet.parseInt(x4+cos(i*PI/2)*15),PApplet.parseInt(y4+sin(i*PI/2)*15)); 
    if(red(c) == 83 && green(c) == 33 && blue(c) == 0){
      if(i == 0 && vie != 0){
        attendre();
        x4-=10;
        surface.setTitle("Nombre de vie : "+str(vie));
      }
      
      else if(i == 1 && vie != 0){
        attendre();
        y4-=10;
        surface.setTitle("Nombre de vie : "+str(vie));
      }
      
      else if(i == 2 && vie != 0){
        attendre();
        x4+=10;
        surface.setTitle("Nombre de vie : "+str(vie));
      }
      
      else if(i == 3 && vie != 0){
        attendre();
        y4+=10;
        surface.setTitle("Nombre de vie : "+str(vie));
      }
      
      else{
        attendre();
        vie = 3;
        surface.setTitle("Nombre de vie : "+str(vie));
        x4 = 700;
        y4 = 758;
      }
      
    }
  }
  if(x4>1308 && x4<1379 && y4>20 && y4<70)
  {
    lancer_secret();
    score_general[3] =0;
    suivant=true;
    jeu4=false;
    
  }
  //145, 83, 28
  if(red(get(x4, y4+16)) == 145 && green(get(x4, y4+16)) == 83 && blue(get(x4, y4+16)) == 28){
    //stop();
    score_general[3] = vie;
    /*fill(0,0,0,80);
    rect(0,0, width, height);
    fill(255);
    textAlign(CENTER, CENTER);
    textSize(50);
    text("YOU WIN\nscore : "+str(score4), 0,0,width, height);*/
    suivant=true;
    jeu4=false;
    
  }
}

public void attendre(){
  //textAlign(CENTER, CENTER);
  vie--;
  surface.setTitle("3... ");
  //javax.swing.JOptionPane.showMessageDialog(null,"3... ");
  //text("3... ",width/2,height/2);
  delay(1000);
  surface.setTitle("3... 2...");
  //javax.swing.JOptionPane.showMessageDialog(null,"3... 2...");
  //text("3... 2...",width/2,height/2);
  delay(1000);
  surface.setTitle("3... 2... 1...");
  //javax.swing.JOptionPane.showMessageDialog(null,"3... 2... 1...");
  //text("3... 2... 1...",width/2,height/2);
  delay(1000); 
  //textAlign(CORNER, CORNER);
}




public void lancer_secret()
{
  troll=loadImage("shaun.png");
  background(0);
  image(troll,700,350,171,352);
  fill(255);
  textSize(50);
  text("It was a prank !!!",600,100);
  
  
  
}



public void afficher_accueil_chemin()
{
  numJeu=5;//jeu numéro 5
  //affichage nom et ecran d'acceuil
  if(test_5==false){
    fondecran_5 = loadImage("Fond.jpg");
 background(fondecran_5); 
 
 fill(0);
 textAlign(CENTER);
 textSize(100);
 text("Sheep'Game", 700,450);
   fill(0);
   textAlign(CENTER);
   textSize(50);
   text("Pour commencer appuyer sur s", 700,550);
  }
  
  if(key=='s')
  {
   test_5=true;
   
  }
  if(test_5==true)
  choisir_chemin1();
}
 
 
 //------------------------------choisir chemin 1-----------------------
 public void choisir_chemin1()
{
  grotte1=loadImage("grotte1.jpg");
  image(grotte1,0,0,1400,800);
  if(mouseX>712 && mouseX<830 && mouseY<800 && mouseY>682 && mouseButton==LEFT)
  {
    test1_5=true;
  }
  if(((mouseX>320 && mouseX<434 && mouseY<636 && mouseY>522)||(mouseX>1118 && mouseX<1234 && mouseY<800 && mouseY>684))&& mouseButton==LEFT)
  {
    a_5=1;
    test1_5=true;
    print(a_5);
  }
  if(test1_5==true)
  {
    choisir_chemin2();
  }
 
}

 //------------------------------choisir chemin 2-----------------------
public void choisir_chemin2()
{
  grotte1=loadImage("grotte2.jpg");
  image(grotte1,0,0,1400,800);
  if(mouseX>931 && mouseX<1015 && mouseY<800 && mouseY>716 && mouseButton==LEFT)
  {
    test2_5=true;
  }
  if(((mouseX>378 && mouseX<462 && mouseY<800 && mouseY>716)||(mouseX>660 && mouseX<740 && mouseY<800 && mouseY>716))&& mouseButton==LEFT)
  {
    b_5=1;
    test2_5=true;
    print(b_5);
  }
  if(test2_5==true)
  {
    choisir_chemin3();
  }
}



 //------------------------------choisir chemin 3-----------------------
public void choisir_chemin3()
{
  grotte1=loadImage("grotte3.jpg");
  image(grotte1,0,0,1400,800);
  if(mouseX>531 && mouseX<650 && mouseY<465 && mouseY>352 && mouseButton==LEFT)
  {
    test3_5=true;
  }
  if(((mouseX>309 && mouseX<428 && mouseY<630 && mouseY>514)||(mouseX>1230 && mouseX<1345 && mouseY<635 && mouseY>519))&& mouseButton==LEFT)
  {
    c_5=1;
    test3_5=true;
    print(c_5);
  }
  if(test3_5==true)
  {
    end();
  }
}


//----------------------------end------------------------------------------
public void end()
{
  
  score5=3-(a_5+b_5+c_5);
  score_general[4]=score5;
  suivant=true;
  jeu5=false;

}

 
public void ping_pong() {
  
  numJeu=6;//jeu numéro 6
  textAlign(CENTER, CENTER);
  mouton1_6=loadImage("moutonping1.png");
  mouton2_6=loadImage("moutonping2.png");
  noStroke();
  colorMode(RGB);
  fill(0, 500);
  rect(0, 0, width, height);
  colorMode(HSB);
  fill(c_6, 1000, 1000);
  image(mouton1_6,23, (int)(PlayerPos-70), 65, 140);
  image(mouton2_6,1312,(int)(OpponentPos-70), 65, 140);
  ellipse(ball.x, ball.y, 30, 30);
  stroke(c_6, 1000, 1000);
  strokeWeight(3);
  line(700, 20, 700, 780);
  text(score6, 660, 50);
  text(PlayerPoints, 740, 50);
  colorMode(RGB);
  noFill();
  rect(20, 20, 1360, 760);
  c_6++;
  if (c_6 > 1000) c_6 = 0;
 
  boolean k = false;
 
  if (dist((float)OpponentPos, 0, ball.y, 0) > 50) {
    if (ball.y < OpponentPos) {
      k = true;
      OpponentSpeed-=0.1f;
    }
    if (ball.y > OpponentPos) {
      k = true;
      OpponentSpeed+=0.8f;
    }
    OpponentSpeed = (double)constrain((float)OpponentSpeed, -12, 12);
  }
  if (!k) OpponentSpeed*=0.95f;
  OpponentPos+=OpponentSpeed;
  if (OpponentPos > 700) {
    OpponentPos = 700;
    OpponentSpeed = -OpponentSpeed*0.6f;
  }
  if (OpponentPos < 100) {
    OpponentPos = 100;
    OpponentSpeed = -OpponentSpeed*0.6f;
  }
 
  k = false;
 
  if (keyPressed) {
    if (keyCode == UP) {
      k = true;
      PlayerSpeed-=0.6f;
    }
    if (keyCode == DOWN) {
      k = true;
      PlayerSpeed+=0.6f;
    }
    PlayerSpeed = (double)constrain((float)PlayerSpeed, -12, 12);
  }
  if (!k) PlayerSpeed*=0.95f;
  PlayerPos+=PlayerSpeed;
  if (PlayerPos > 700) {
    PlayerPos = 700;
    PlayerSpeed = -PlayerSpeed*0.6f;
  }
  if (PlayerPos < 100) {
    PlayerPos = 100;
    PlayerSpeed = -PlayerSpeed*0.6f;
  }
 
  ball.add(ballSpeed);
  if (ball.y > 770) {
    ball.y = 770;
    ballSpeed.y *= -1;
  }
  if (ball.y < 30) {
    ball.y = 30;
    ballSpeed.y *= -1;
  }
  if (ball.x < 65 && ball.x > 35 && ball.y > PlayerPos-85 && ball.y < PlayerPos+85) {
    ball.x = 65;
    float a = map((float)ball.y, (float)(PlayerPos-85), (float)(PlayerPos+85), -PI/3, PI/3);
    ballSpeed.x = cos(a)*10;
    ballSpeed.y = sin(a)*10;
  }
  if (ball.x > 1340 && ball.x < 1350 && ball.y > OpponentPos-85 && ball.y < OpponentPos+85) {
    ball.x = 1340;
    float a = map((float)ball.y, (float)(OpponentPos-85), (float)(OpponentPos+85), -PI/3, PI/3);
    ballSpeed.x = -cos(a)*10;
    ballSpeed.y = sin(a)*10;
  }
  if (ball.x < -15) {
    PlayerPoints++;
    ball = new PVector(640, 360);
    float a = random(-PI/3, PI/3);
    ballSpeed.x = cos(a)*10;
    if (random(2) < 1) ballSpeed.x *= -1;
    ballSpeed.y = sin(a)*10;
  }
  if (ball.x > 1395) {
    
    score6++;
    ball = new PVector(640, 360);
    float a = random(-PI/3, PI/3);
    ballSpeed.x = cos(a)*10;
    if (random(2) < 1) ballSpeed.x *= -1;
    ballSpeed.y = sin(a)*10;
  }
  
  if(score6==3 || PlayerPoints == 3)
  {
    score_general[5]=score6;
    jeu6=false;
    suivant=true;
  }
}




public void flappy_bird() {
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
        tab_tubeY[j] = PApplet.parseInt(random(-550, -350));  //lorsque un tube apparait a droite, il change de hauteur
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

public void find_shauwn() {
  
  
  numJeu=8;//jeu numéro 8
  
  background(0);
  
  
  
  if(tmp_8 <= 1800){
  
    for (int i = 0; i<10; i++) {
      fill(255, 255, 100, (-i*25.5f)+229.5f);
      ellipse(mouseX, mouseY, (i*taille_8/2)+taille_8/2, (i*taille_8/2)+taille_8/2);
    }
    
    
    if(dist(x_8+(taille2_8/2), y_8+(taille2_8/2), mouseX, mouseY) < taille2_8/2){
      image(mouton_black_eyes, x_8, y_8, taille2_8, taille2_8);
    }
    else{
      image(mouton_black, x_8, y_8, taille2_8, taille2_8);
    }
      
    
    if(dist(x_8+(taille2_8/2), y_8+(taille2_8/2), mouseX, mouseY) < taille2_8/2 && mousePressed && mouseButton == LEFT){
      x_8 = PApplet.parseInt(random(width-taille2_8));
      y_8 = PApplet.parseInt(random(height-taille2_8));
      taille_8 = taille_8-(taille_8/20);
      taille2_8 = (int)((Math.random()*50)+80);
      if(taille_8 < 30)taille_8 = 30;
      score8++;
    }
    
    textAlign(0, CENTER);
    textSize(22);
    fill(255);
    text("Scores : "+score8,20,20);
    text("Temps : " + floor(tmp_8/60), 20, 80);
    
    tmp_8++;
  }
  
  else{
     fill(255);
     rect(0,0,width, height);
     fill(0);
     textAlign(CENTER,CENTER);
     text("Score : "+str(round(score8/11*3)), 0,0,width, height);
  }
  
  if(tmp_8==1800)
  {
     score_general[7]=(int)(round(score8/11*3));
     jeu8=false;
     suivant=true;
  }
  

}


public void SimonSheep() {
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
int niveaudebloque;
boolean jeu1, jeu2, jeu3, jeu4, jeu5, jeu6, jeu7, jeu8, jeu9, jeu10, niveaux, accueil;


public void jouer() {

  //niveau 1
  if (dist(mouseX, mouseY, x_cercle_niveaux[0], y_cercle_niveaux[0]) < rayon_cercle_niveaux[0]/2) {
    fill(255, 255, 255, 80);
    ellipse(x_cercle_niveaux[0], y_cercle_niveaux[0], rayon_cercle_niveaux[0], rayon_cercle_niveaux[0]); // niveaux
    // Affiche une main
    cursor(HAND);
    if (mousePressed == true && niveaudebloque==0) {
      jeu1=true;
      niveaux=false;
    } else if (mousePressed == true && niveaudebloque!=0) {
      javax.swing.JOptionPane.showMessageDialog(null,"veuillez choisir le bon niveau");
      println("Veyez faire le niveau précédent");
      //jeu1=false;
    }
  }
  //niveau 2
  else if (dist(mouseX, mouseY, x_cercle_niveaux[1], y_cercle_niveaux[1]) < rayon_cercle_niveaux[1]/2) {
    fill(255, 255, 255, 80);
    ellipse(x_cercle_niveaux[1], y_cercle_niveaux[1], rayon_cercle_niveaux[1], rayon_cercle_niveaux[1]); // niveaux
    // Affiche une main
    cursor(HAND);
    if (mousePressed == true && niveaudebloque==1) {
      jeu2=true;
      niveaux=false;
    } else if (mousePressed == true && niveaudebloque!=1) {
      javax.swing.JOptionPane.showMessageDialog(null,"veuillez choisir le bon niveau");
      println("Veyez faire le niveau précédent");
      //jeu2=false;
    }
  }
  //niveau 3
  else if (dist(mouseX, mouseY, x_cercle_niveaux[2], y_cercle_niveaux[2]) < rayon_cercle_niveaux[2]/2) {
    fill(255, 255, 255, 80);
    ellipse(x_cercle_niveaux[2], y_cercle_niveaux[2], rayon_cercle_niveaux[2], rayon_cercle_niveaux[2]); // niveaux
    // Affiche une main
    cursor(HAND);
    if (mousePressed == true && niveaudebloque==2) {
      jeu3=true;
      niveaux=false;
    } else  if (mousePressed == true && niveaudebloque!=2){
      javax.swing.JOptionPane.showMessageDialog(null,"veuillez choisir le bon niveau");
      println("Veyez faire le niveau précédent");
      //jeu3=false;
    }
  }
  //niveau 4
  else if (dist(mouseX, mouseY, x_cercle_niveaux[3], y_cercle_niveaux[3]) < rayon_cercle_niveaux[3]/2) {
    fill(255, 255, 255, 80);
    ellipse(x_cercle_niveaux[3], y_cercle_niveaux[3], rayon_cercle_niveaux[3], rayon_cercle_niveaux[3]); // niveaux
    // Affiche une main
    cursor(HAND);
    if (mousePressed == true && niveaudebloque==3) {
      jeu4=true;
      niveaux=false;
    } else  if (mousePressed == true && niveaudebloque!=3){
      javax.swing.JOptionPane.showMessageDialog(null,"veuillez choisir le bon niveau");
      println("Veyez faire le niveau précédent");
      //jeu4=false;
    }
  }
  //niveau 5
  else if (dist(mouseX, mouseY, x_cercle_niveaux[4], y_cercle_niveaux[4]) < rayon_cercle_niveaux[4]/2) {
    fill(255, 255, 255, 80);
    ellipse(x_cercle_niveaux[4], y_cercle_niveaux[4], rayon_cercle_niveaux[4], rayon_cercle_niveaux[4]); // niveaux
    // Affiche une main
    cursor(HAND);
    if (mousePressed == true && niveaudebloque==4) {
      jeu5=true;
      niveaux=false;
    } else  if (mousePressed == true && niveaudebloque!=4){
      javax.swing.JOptionPane.showMessageDialog(null,"veuillez choisir le bon niveau");
      println("Veyez faire le niveau précédent");
      //jeu5=false;
    }
  }
  //niveau 6
  else if (dist(mouseX, mouseY, x_cercle_niveaux[5], y_cercle_niveaux[5]) < rayon_cercle_niveaux[5]/2) {
    fill(255, 255, 255, 80);
    ellipse(x_cercle_niveaux[5], y_cercle_niveaux[5], rayon_cercle_niveaux[5], rayon_cercle_niveaux[5]); // niveaux
    // Affiche une main
    cursor(HAND);
    if (mousePressed == true && niveaudebloque==5) {
      jeu6=true;
      niveaux=false;
    } else  if (mousePressed == true && niveaudebloque!=5){
      javax.swing.JOptionPane.showMessageDialog(null,"veuillez choisir le bon niveau");
      println("Veyez faire le niveau précédent");
      //jeu6=false;
    }
  }
  //niveau 7
  else if (dist(mouseX, mouseY, x_cercle_niveaux[6], y_cercle_niveaux[6]) < rayon_cercle_niveaux[6]/2) {
    fill(255, 255, 255, 80);
    ellipse(x_cercle_niveaux[6], y_cercle_niveaux[6], rayon_cercle_niveaux[6], rayon_cercle_niveaux[6]); // niveaux
    // Affiche une main
    cursor(HAND);
    if (mousePressed == true && niveaudebloque==6) {
      jeu7=true;
      niveaux=false;
    } else  if (mousePressed == true && niveaudebloque!=6){
      javax.swing.JOptionPane.showMessageDialog(null,"veuillez choisir le bon niveau");
      println("Veyez faire le niveau précédent");
      //jeu7=false;
    }
  }
  //niveau 8
  else if (dist(mouseX, mouseY, x_cercle_niveaux[7], y_cercle_niveaux[7]) < rayon_cercle_niveaux[7]/2) {
    fill(255, 255, 255, 80);
    ellipse(x_cercle_niveaux[7], y_cercle_niveaux[7], rayon_cercle_niveaux[7], rayon_cercle_niveaux[7]); // niveaux
    // Affiche une main
    cursor(HAND);
    if (mousePressed == true && niveaudebloque==7) {
      jeu8=true;
      niveaux=false;
    } else  if (mousePressed == true && niveaudebloque!=7){
      javax.swing.JOptionPane.showMessageDialog(null,"veuillez choisir le bon niveau");
      println("Veyez faire le niveau précédent");
      //jeu8=false;
    }
  }
  //niveau 9
  else if (dist(mouseX, mouseY, x_cercle_niveaux[8], y_cercle_niveaux[8]) < rayon_cercle_niveaux[8]/2) {
    fill(255, 255, 255, 80);
    ellipse(x_cercle_niveaux[8], y_cercle_niveaux[8], rayon_cercle_niveaux[8], rayon_cercle_niveaux[8]); // niveaux
    // Affiche une main
    cursor(HAND);
    if (mousePressed == true && niveaudebloque==8) {
      jeu9=true;
      niveaux=false;
    } else  if (mousePressed == true && niveaudebloque!=8){
      javax.swing.JOptionPane.showMessageDialog(null,"veuillez choisir le bon niveau");
      println("Veyez faire le niveau précédent");
      //jeu9=false;
    }
  }
  //niveau 10
  else if (dist(mouseX, mouseY, x_cercle_niveaux[9], y_cercle_niveaux[9]) < rayon_cercle_niveaux[9]/2) {
    fill(255, 255, 255, 80);
    ellipse(x_cercle_niveaux[9], y_cercle_niveaux[9], rayon_cercle_niveaux[9], rayon_cercle_niveaux[9]); // niveaux
    // Affiche une main
    cursor(HAND);
    if (mousePressed == true && niveaudebloque==9) {
      jeu10=true;
      niveaux=false;
    } else  if (mousePressed == true && niveaudebloque!=9){
      javax.swing.JOptionPane.showMessageDialog(null,"veuillez choisir le bon niveau");
      println("Veyez faire le niveau précédent");
      //jeu10=false;
    }
  } else {
    cursor(ARROW);
    noFill();
  }
}

public void niveaux() {
  
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




public void update_score_general(){
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
public void retour_niveaux()
{
    PImage[] image ={loadImage("fond0.jpg"),loadImage("fond1.jpg"),loadImage("fond2.jpg"),loadImage("fond3.jpg")};

    background(image[score_general[niveaudebloque-1]]);

    bouton=loadImage("bouton2.png");

    if(mouseY<770 && mouseY>620 && mouseX<1366 && mouseX>1200)
    {
      image(bouton,0,0,1400,800);
      if(mouseButton==LEFT)
      {
        suivant=false;
        niveaux=true;
        if (niveaudebloque==10)
          fin=true;
      }
    } 

}
  public void settings() {  size(1400, 800);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "GobalGameJam_G" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

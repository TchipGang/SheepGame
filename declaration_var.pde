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
color mur1, mur3, mur4;
color mur2, mur5, mur6, mur7, mur8;
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

color c;
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

void regles()
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


void saute_mouton()
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

void deplacement_mouton()
{
  vitesse_3=vitesse_3+0.8;
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

void affichage_etoile()
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

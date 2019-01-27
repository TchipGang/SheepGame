void deplacement_separe()
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
    compteur=compteur+0.16;
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

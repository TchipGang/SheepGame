
void afficher_accueil()
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

void retour_niveaux()
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

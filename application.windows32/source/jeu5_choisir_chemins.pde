


void afficher_accueil_chemin()
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
 void choisir_chemin1()
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
void choisir_chemin2()
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
void choisir_chemin3()
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
void end()
{
  
  score5=3-(a_5+b_5+c_5);
  score_general[4]=score5;
  suivant=true;
  jeu5=false;

}

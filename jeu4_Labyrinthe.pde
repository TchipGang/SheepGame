void labyrinthe(){
  
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
    c = get(int(x4+cos(i*PI/2)*15),int(y4+sin(i*PI/2)*15)); 
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

void attendre(){
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




void lancer_secret()
{
  troll=loadImage("shaun.png");
  background(0);
  image(troll,700,350,171,352);
  fill(255);
  textSize(50);
  text("It was a prank !!!",600,100);
  
  
  
}

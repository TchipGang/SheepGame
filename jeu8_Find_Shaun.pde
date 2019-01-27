
void find_shauwn() {
  
  
  numJeu=8;//jeu numéro 8
  
  background(0);
  
  
  
  if(tmp_8 <= 1800){
  
    for (int i = 0; i<10; i++) {
      fill(255, 255, 100, (-i*25.5)+229.5);
      ellipse(mouseX, mouseY, (i*taille_8/2)+taille_8/2, (i*taille_8/2)+taille_8/2);
    }
    
    
    if(dist(x_8+(taille2_8/2), y_8+(taille2_8/2), mouseX, mouseY) < taille2_8/2){
      image(mouton_black_eyes, x_8, y_8, taille2_8, taille2_8);
    }
    else{
      image(mouton_black, x_8, y_8, taille2_8, taille2_8);
    }
      
    
    if(dist(x_8+(taille2_8/2), y_8+(taille2_8/2), mouseX, mouseY) < taille2_8/2 && mousePressed && mouseButton == LEFT){
      x_8 = int(random(width-taille2_8));
      y_8 = int(random(height-taille2_8));
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

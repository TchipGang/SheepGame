PImage Final;
int total_tmp=0;
void Final(){
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

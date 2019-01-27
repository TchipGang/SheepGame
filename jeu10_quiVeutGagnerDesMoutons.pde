




void quiVeutGagnerDesMoutons() {
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
      fill(#64DB6C);
      stroke(#5C9B60);
      
    } else {
      fill(#31C43C);
      stroke(#12811A);
    }
    ellipse((1400/2)-200, 500, 200, 200);
    fill(0);
    text("Vrai", (1400/2)-300, 393, 200, 200);

    

    if (dist(mouseX, mouseY, (1400/2)+200, 500)<100) {
      fill(#EA5A5A);
      stroke(#AD3434);
    } else {
      fill(#FC2626);
      stroke(#6F1515);
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
      fill(#64DB6C);
      stroke(#5C9B60);
      
    } else {
      fill(#31C43C);
      stroke(#12811A);
    }
    ellipse((1400/2)-200, 500, 200, 200);
    fill(0);
    text("Vrai", (1400/2)-300, 393, 200, 200);

    

    if (dist(mouseX, mouseY, (1400/2)+200, 500)<100) {
      fill(#EA5A5A);
      stroke(#AD3434);
      
    } else {
      fill(#FC2626);
      stroke(#6F1515);
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
      fill(#64DB6C);
      stroke(#5C9B60);
      
    } else {
      fill(#31C43C);
      stroke(#12811A);
    }
    ellipse((1400/2)-200, 500, 200, 200);
    fill(0);
    text("Vrai", (1400/2)-300, 393, 200, 200);

    

    if (dist(mouseX, mouseY, (1400/2)+200, 500)<100) {
      fill(#EA5A5A);
      stroke(#AD3434);
      
    } else {
      fill(#FC2626);
      stroke(#6F1515);
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

int niveaudebloque;
boolean jeu1, jeu2, jeu3, jeu4, jeu5, jeu6, jeu7, jeu8, jeu9, jeu10, niveaux, accueil;
import javax.swing.JOptionPane;

void jouer() {

  //niveau 1
  if (dist(mouseX, mouseY, x_cercle_niveaux[0], y_cercle_niveaux[0]) < rayon_cercle_niveaux[0]/2) {
    fill(255, 255, 255, 80);
    ellipse(x_cercle_niveaux[0], y_cercle_niveaux[0], rayon_cercle_niveaux[0], rayon_cercle_niveaux[0]); // niveaux
    // Affiche une main
    cursor(HAND);
    if (mousePressed == true && niveaudebloque==0) {
      jeu1=true;
      niveaux=false;
    } else if (mousePressed == true && niveaudebloque!=0) {
      javax.swing.JOptionPane.showMessageDialog(null,"veuillez choisir le bon niveau");
      println("Veyez faire le niveau précédent");
      //jeu1=false;
    }
  }
  //niveau 2
  else if (dist(mouseX, mouseY, x_cercle_niveaux[1], y_cercle_niveaux[1]) < rayon_cercle_niveaux[1]/2) {
    fill(255, 255, 255, 80);
    ellipse(x_cercle_niveaux[1], y_cercle_niveaux[1], rayon_cercle_niveaux[1], rayon_cercle_niveaux[1]); // niveaux
    // Affiche une main
    cursor(HAND);
    if (mousePressed == true && niveaudebloque==1) {
      jeu2=true;
      niveaux=false;
    } else if (mousePressed == true && niveaudebloque!=1) {
      javax.swing.JOptionPane.showMessageDialog(null,"veuillez choisir le bon niveau");
      println("Veyez faire le niveau précédent");
      //jeu2=false;
    }
  }
  //niveau 3
  else if (dist(mouseX, mouseY, x_cercle_niveaux[2], y_cercle_niveaux[2]) < rayon_cercle_niveaux[2]/2) {
    fill(255, 255, 255, 80);
    ellipse(x_cercle_niveaux[2], y_cercle_niveaux[2], rayon_cercle_niveaux[2], rayon_cercle_niveaux[2]); // niveaux
    // Affiche une main
    cursor(HAND);
    if (mousePressed == true && niveaudebloque==2) {
      jeu3=true;
      niveaux=false;
    } else  if (mousePressed == true && niveaudebloque!=2){
      javax.swing.JOptionPane.showMessageDialog(null,"veuillez choisir le bon niveau");
      println("Veyez faire le niveau précédent");
      //jeu3=false;
    }
  }
  //niveau 4
  else if (dist(mouseX, mouseY, x_cercle_niveaux[3], y_cercle_niveaux[3]) < rayon_cercle_niveaux[3]/2) {
    fill(255, 255, 255, 80);
    ellipse(x_cercle_niveaux[3], y_cercle_niveaux[3], rayon_cercle_niveaux[3], rayon_cercle_niveaux[3]); // niveaux
    // Affiche une main
    cursor(HAND);
    if (mousePressed == true && niveaudebloque==3) {
      jeu4=true;
      niveaux=false;
    } else  if (mousePressed == true && niveaudebloque!=3){
      javax.swing.JOptionPane.showMessageDialog(null,"veuillez choisir le bon niveau");
      println("Veyez faire le niveau précédent");
      //jeu4=false;
    }
  }
  //niveau 5
  else if (dist(mouseX, mouseY, x_cercle_niveaux[4], y_cercle_niveaux[4]) < rayon_cercle_niveaux[4]/2) {
    fill(255, 255, 255, 80);
    ellipse(x_cercle_niveaux[4], y_cercle_niveaux[4], rayon_cercle_niveaux[4], rayon_cercle_niveaux[4]); // niveaux
    // Affiche une main
    cursor(HAND);
    if (mousePressed == true && niveaudebloque==4) {
      jeu5=true;
      niveaux=false;
    } else  if (mousePressed == true && niveaudebloque!=4){
      javax.swing.JOptionPane.showMessageDialog(null,"veuillez choisir le bon niveau");
      println("Veyez faire le niveau précédent");
      //jeu5=false;
    }
  }
  //niveau 6
  else if (dist(mouseX, mouseY, x_cercle_niveaux[5], y_cercle_niveaux[5]) < rayon_cercle_niveaux[5]/2) {
    fill(255, 255, 255, 80);
    ellipse(x_cercle_niveaux[5], y_cercle_niveaux[5], rayon_cercle_niveaux[5], rayon_cercle_niveaux[5]); // niveaux
    // Affiche une main
    cursor(HAND);
    if (mousePressed == true && niveaudebloque==5) {
      jeu6=true;
      niveaux=false;
    } else  if (mousePressed == true && niveaudebloque!=5){
      javax.swing.JOptionPane.showMessageDialog(null,"veuillez choisir le bon niveau");
      println("Veyez faire le niveau précédent");
      //jeu6=false;
    }
  }
  //niveau 7
  else if (dist(mouseX, mouseY, x_cercle_niveaux[6], y_cercle_niveaux[6]) < rayon_cercle_niveaux[6]/2) {
    fill(255, 255, 255, 80);
    ellipse(x_cercle_niveaux[6], y_cercle_niveaux[6], rayon_cercle_niveaux[6], rayon_cercle_niveaux[6]); // niveaux
    // Affiche une main
    cursor(HAND);
    if (mousePressed == true && niveaudebloque==6) {
      jeu7=true;
      niveaux=false;
    } else  if (mousePressed == true && niveaudebloque!=6){
      javax.swing.JOptionPane.showMessageDialog(null,"veuillez choisir le bon niveau");
      println("Veyez faire le niveau précédent");
      //jeu7=false;
    }
  }
  //niveau 8
  else if (dist(mouseX, mouseY, x_cercle_niveaux[7], y_cercle_niveaux[7]) < rayon_cercle_niveaux[7]/2) {
    fill(255, 255, 255, 80);
    ellipse(x_cercle_niveaux[7], y_cercle_niveaux[7], rayon_cercle_niveaux[7], rayon_cercle_niveaux[7]); // niveaux
    // Affiche une main
    cursor(HAND);
    if (mousePressed == true && niveaudebloque==7) {
      jeu8=true;
      niveaux=false;
    } else  if (mousePressed == true && niveaudebloque!=7){
      javax.swing.JOptionPane.showMessageDialog(null,"veuillez choisir le bon niveau");
      println("Veyez faire le niveau précédent");
      //jeu8=false;
    }
  }
  //niveau 9
  else if (dist(mouseX, mouseY, x_cercle_niveaux[8], y_cercle_niveaux[8]) < rayon_cercle_niveaux[8]/2) {
    fill(255, 255, 255, 80);
    ellipse(x_cercle_niveaux[8], y_cercle_niveaux[8], rayon_cercle_niveaux[8], rayon_cercle_niveaux[8]); // niveaux
    // Affiche une main
    cursor(HAND);
    if (mousePressed == true && niveaudebloque==8) {
      jeu9=true;
      niveaux=false;
    } else  if (mousePressed == true && niveaudebloque!=8){
      javax.swing.JOptionPane.showMessageDialog(null,"veuillez choisir le bon niveau");
      println("Veyez faire le niveau précédent");
      //jeu9=false;
    }
  }
  //niveau 10
  else if (dist(mouseX, mouseY, x_cercle_niveaux[9], y_cercle_niveaux[9]) < rayon_cercle_niveaux[9]/2) {
    fill(255, 255, 255, 80);
    ellipse(x_cercle_niveaux[9], y_cercle_niveaux[9], rayon_cercle_niveaux[9], rayon_cercle_niveaux[9]); // niveaux
    // Affiche une main
    cursor(HAND);
    if (mousePressed == true && niveaudebloque==9) {
      jeu10=true;
      niveaux=false;
    } else  if (mousePressed == true && niveaudebloque!=9){
      javax.swing.JOptionPane.showMessageDialog(null,"veuillez choisir le bon niveau");
      println("Veyez faire le niveau précédent");
      //jeu10=false;
    }
  } else {
    cursor(ARROW);
    noFill();
  }
}

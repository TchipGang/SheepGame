class Loup {
  int x; //position en x
  int y; // position en y
  String look; // orientation du loup (up, down, left, right)


  Loup(int x, int y, String orientation) {
    this.x = x;
    this.y = y;
    this.look = orientation;
  }

  void display() {
    stroke(59, 61, 56); //couleur du contour
    strokeWeight(5); //taille du coutonr
    fill(118, 117, 106); //couleur du loup
    ellipse(this.x, this.y, 80, 80); //objet loup
  }

  void champVision() {
    if (this.look == "up") {
      noStroke();
      fill(107, 183, 77);
      triangle(this.x-100, this.y-200, this.x, this.y, this.x+100, this.y-200); 
      arc(this.x, this.y-101, 280, 280, 5*PI/4, 7*PI/4);
      stroke(0);
      fill(255);
    } else if (this.look == "right") {
      noStroke();
      fill(107, 183, 77);
      triangle(this.x+200, this.y-100, this.x, this.y, this.x+200, this.y+100); 
      arc(this.x+101, this.y, 280, 280, -1*PI/4, 1*PI/4);
      stroke(0);
      fill(255);
    } else if (this.look == "down") {
      noStroke();
      fill(107, 183, 77);
      triangle(this.x+100, this.y+200, this.x, this.y, this.x-100, this.y+200); 
      arc(this.x, this.y+101, 280, 280, 1*PI/4, 3*PI/4);
      stroke(0);
      fill(255);
    } else if (this.look == "left") {
      noStroke();
      fill(107, 183, 77);
      triangle(this.x-200, this.y-100, this.x, this.y, this.x-200, this.y+100); 
      arc(this.x-101, this.y, 280, 280, 3*PI/4, 5*PI/4);
      stroke(0);
      fill(255);
    }
  }
}

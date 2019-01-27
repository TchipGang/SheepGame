class Sheep {
  int x; //position en x du mouton
  int y; // position en y du mouton
  boolean up = false;
  boolean right = false;
  boolean left = false;
  boolean down = false;


  Sheep(int x, int y) {
    this.x = x;
    this.y = y;
  }

  void display() {
    fill(248, 235, 198);
    strokeWeight(5);
    stroke(188, 168, 135);
    ellipse(this.x, this.y, 50, 50);
  }

  void move() {
    if (this.up == true && sheep.y > 0)this.y-=2;
    if (this.down == true && sheep.y < height)this.y+=2;
    if (this.left == true && sheep.x > 0)this.x-=2;
    if (this.right == true && sheep.x < width)this.x+=2;
  }

  void collision() {
    for (int i = 0; i<12; i++) {
      color c = get(int(this.x+(cos(i*PI/6))*26), int(this.y+(sin(i*PI/6))*26));//je récupère la couleur sur le contour du mouton
      if (red(c) == 107 && green(c) == 183 && blue(c) == 77) { // si la couleur est egale a celle du champ de vision du loup on stop
        //stop();
        score_general[0]=0;
        suivant=true;
        jeu1=false;
      }
    }
  }
}

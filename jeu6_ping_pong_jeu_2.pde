
 
void ping_pong() {
  
  numJeu=6;//jeu numéro 6
  textAlign(CENTER, CENTER);
  mouton1_6=loadImage("moutonping1.png");
  mouton2_6=loadImage("moutonping2.png");
  noStroke();
  colorMode(RGB);
  fill(0, 500);
  rect(0, 0, width, height);
  colorMode(HSB);
  fill(c_6, 1000, 1000);
  image(mouton1_6,23, (int)(PlayerPos-70), 65, 140);
  image(mouton2_6,1312,(int)(OpponentPos-70), 65, 140);
  ellipse(ball.x, ball.y, 30, 30);
  stroke(c_6, 1000, 1000);
  strokeWeight(3);
  line(700, 20, 700, 780);
  text(score6, 660, 50);
  text(PlayerPoints, 740, 50);
  colorMode(RGB);
  noFill();
  rect(20, 20, 1360, 760);
  c_6++;
  if (c_6 > 1000) c_6 = 0;
 
  boolean k = false;
 
  if (dist((float)OpponentPos, 0, ball.y, 0) > 50) {
    if (ball.y < OpponentPos) {
      k = true;
      OpponentSpeed-=0.1;
    }
    if (ball.y > OpponentPos) {
      k = true;
      OpponentSpeed+=0.8;
    }
    OpponentSpeed = (double)constrain((float)OpponentSpeed, -12, 12);
  }
  if (!k) OpponentSpeed*=0.95;
  OpponentPos+=OpponentSpeed;
  if (OpponentPos > 700) {
    OpponentPos = 700;
    OpponentSpeed = -OpponentSpeed*0.6;
  }
  if (OpponentPos < 100) {
    OpponentPos = 100;
    OpponentSpeed = -OpponentSpeed*0.6;
  }
 
  k = false;
 
  if (keyPressed) {
    if (keyCode == UP) {
      k = true;
      PlayerSpeed-=0.6;
    }
    if (keyCode == DOWN) {
      k = true;
      PlayerSpeed+=0.6;
    }
    PlayerSpeed = (double)constrain((float)PlayerSpeed, -12, 12);
  }
  if (!k) PlayerSpeed*=0.95;
  PlayerPos+=PlayerSpeed;
  if (PlayerPos > 700) {
    PlayerPos = 700;
    PlayerSpeed = -PlayerSpeed*0.6;
  }
  if (PlayerPos < 100) {
    PlayerPos = 100;
    PlayerSpeed = -PlayerSpeed*0.6;
  }
 
  ball.add(ballSpeed);
  if (ball.y > 770) {
    ball.y = 770;
    ballSpeed.y *= -1;
  }
  if (ball.y < 30) {
    ball.y = 30;
    ballSpeed.y *= -1;
  }
  if (ball.x < 65 && ball.x > 35 && ball.y > PlayerPos-85 && ball.y < PlayerPos+85) {
    ball.x = 65;
    float a = map((float)ball.y, (float)(PlayerPos-85), (float)(PlayerPos+85), -PI/3, PI/3);
    ballSpeed.x = cos(a)*10;
    ballSpeed.y = sin(a)*10;
  }
  if (ball.x > 1340 && ball.x < 1350 && ball.y > OpponentPos-85 && ball.y < OpponentPos+85) {
    ball.x = 1340;
    float a = map((float)ball.y, (float)(OpponentPos-85), (float)(OpponentPos+85), -PI/3, PI/3);
    ballSpeed.x = -cos(a)*10;
    ballSpeed.y = sin(a)*10;
  }
  if (ball.x < -15) {
    PlayerPoints++;
    ball = new PVector(640, 360);
    float a = random(-PI/3, PI/3);
    ballSpeed.x = cos(a)*10;
    if (random(2) < 1) ballSpeed.x *= -1;
    ballSpeed.y = sin(a)*10;
  }
  if (ball.x > 1395) {
    
    score6++;
    ball = new PVector(640, 360);
    float a = random(-PI/3, PI/3);
    ballSpeed.x = cos(a)*10;
    if (random(2) < 1) ballSpeed.x *= -1;
    ballSpeed.y = sin(a)*10;
  }
  
  if(score6==3 || PlayerPoints == 3)
  {
    score_general[5]=score6;
    jeu6=false;
    suivant=true;
  }
}

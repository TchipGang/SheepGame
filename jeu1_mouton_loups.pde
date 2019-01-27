void mouton_loups() {
  numJeu=1;//jeu numéro 1

  score1++;

  background(75, 93, 59);

  fill(#B45B16);
  noStroke();
  rect(0, 0, 100, 100);

  loup1.champVision();
  loup2.champVision();
  loup3.champVision();
  loup4.champVision();
  loup5.champVision();
  loup6.champVision();
  loup7.champVision();
  loup8.champVision();
  loup9.champVision();

  loup1.display();
  loup2.display();
  loup3.display();
  loup4.display();
  loup5.display();
  loup6.display();
  loup7.display();
  loup8.display();
  loup9.display();

  sheep.display();
  sheep.move();
  sheep.collision();

  if (sheep.x < 100 && sheep.x > 0 && sheep.y < 100 && sheep.y > 0) {
    fill(0, 0, 0, 25);
    rect(0, 0, width, height);
    textSize(100);
    textAlign(CENTER, CENTER);
    fill(255);

    scoreFinal = floor(score1/1200);
    if (scoreFinal > 3)scoreFinalFinal = 1;
    else scoreFinalFinal = 3-scoreFinal;
    score1 = scoreFinalFinal;
    //text("YOU WIN\nScore : "+score1, 0, 0, width, height);
    score_general[0]=score1;
    //stop();
    
    suivant=true;
    jeu1=false;
  }

  //ajout de move pour déplacement
  loup1.x+=moveX_1;
  loup1.y+=moveY_1;

  loup2.x+=moveX_2;
  loup2.y+=moveY_2;

  loup3.x+=moveX_3;
  loup3.y+=moveY_3;

  loup4.x+=moveX_4;
  loup4.y+=moveY_4;

  loup5.x+=moveX_5;
  loup5.y+=moveY_5;

  loup6.x+=moveX_6;
  loup6.y+=moveY_6;

  loup7.x+=moveX_7;
  loup7.y+=moveY_7;

  loup8.x+=moveX_8;
  loup8.y+=moveY_8;

  loup9.x+=moveX_9;
  loup9.y+=moveY_9;

  /////////////////////////////////////////////////////////////

  //1er loup
  if (loup1.x  == 1300 && loup1.y == 100) {
    moveX_1 = 0;
    moveY_1 = 2;
    loup1.look = "down";
  } else if (loup1.x  == 1300 && loup1.y == 700) {
    moveX_1 = -2;
    moveY_1 = 0;
    loup1.look = "left";
  } else if (loup1.x  == 1000 && loup1.y == 700) {
    moveX_1 = 0;
    moveY_1 = -2;
    loup1.look = "up";
  } else if (loup1.x  == 1000 && loup1.y == 100) {
    moveX_1 = 2;
    moveY_1 = 0;
    loup1.look = "right";
  }

  /////////////////////////////////////////////////////////////

  //2eme loups
  if (loup2.x  == 900 && loup2.y == 700) {
    moveX_2 = -1;
    moveY_2 = 0;
    loup2.look = "left";
  } else if (loup2.x  == 100 && loup2.y == 700) {
    moveX_2 = 0;
    moveY_2 = -1;
    loup2.look = "up";
  } else if (loup2.x  == 100 && loup2.y == 500) {
    moveX_2 = 1;
    moveY_2 = 0;
    loup2.look = "right";
  } else if (loup2.x  == 900 && loup2.y == 500) {
    moveX_2 = 0;
    moveY_2 = 1;
    loup2.look = "down";
  }

  /////////////////////////////////////////////////////////////

  //3eme loups
  if (loup3.x  == 300 && loup3.y == 100) {
    moveX_3 = 0;
    moveY_3 = 2;
    loup3.look = "down";
  } else if (loup3.x  == 300 && loup3.y == 700) {
    moveX_3 = 2;
    moveY_3 = 0;
    loup3.look = "right";
  } else if (loup3.x  == 700 && loup3.y == 700) {
    moveX_3 = 0;
    moveY_3 = -2;
    loup3.look = "up";
  } else if (loup3.x  == 700 && loup3.y == 100) {
    moveX_3 = -2;
    moveY_3 = 0;
    loup3.look = "left";
  }

  /////////////////////////////////////////////////////////////

  //4eme loups
  if (loup4.x  == 200 && loup4.y == 200) {
    moveX_4 = 1;
    moveY_4 = 0;
    loup4.look = "right";
  } else if (loup4.x  == 1100 && loup4.y == 200) {
    moveX_4 = 0;
    moveY_4 = 1;
    loup4.look = "down";
  } else if (loup4.x  == 1100 && loup4.y == 400) {
    moveX_4 = -1;
    moveY_4 = 0;
    loup4.look = "left";
  } else if (loup4.x  == 200 && loup4.y == 400) {
    moveX_4 = 0;
    moveY_4 = -1;
    loup4.look = "up";
  }

  /////////////////////////////////////////////////////////////

  //5eme loups  // line(900, 400, 1200, 400);
  if (loup5.x  == 1200 && loup5.y == 400) {
    moveX_5 = -1;
    loup5.look = "left";
  } else if (loup5.x  == 900 && loup5.y == 400) {
    moveX_5 = 1;
    loup5.look = "right";
  }

  /////////////////////////////////////////////////////////////

  //6eme loups  //   line(800, 100, 800, 700);
  if (loup6.x  == 800 && loup6.y == 700) {
    moveY_6 = -1;
    loup6.look = "up";
  } else if (loup6.x  == 800 && loup6.y == 100) {
    moveY_6 = 1;
    loup6.look = "down";
  }

  /////////////////////////////////////////////////////////////

  //7eme loups  //   line(100, 600, 1300, 600);
  if (loup7.x  == 100 && loup7.y == 600) {
    moveX_7 = 1;
    loup7.look = "right";
  } else if (loup7.x  == 1300 && loup7.y == 600) {
    moveX_7 = -1;
    loup7.look = "left";
  }

  /////////////////////////////////////////////////////////////

  //8eme loups  //   line(200, 300, 1200, 300);
  if (loup8.x  == 1200 && loup8.y == 300) {
    moveX_8 = -1;
    loup8.look = "left";
  } else if (loup8.x  == 200 && loup8.y == 300) {
    moveX_8 = 1;
    loup8.look = "right";
  }

  /////////////////////////////////////////////////////////////

  //9eme loups  //   line(100, 100, 100, 700);
  if (loup9.x  == 100 && loup9.y == 700) {
    moveY_9 = -1;
    loup9.look = "up";
  } else if (loup9.x  == 100 && loup9.y == 100) {
    moveY_9 = 1;
    loup9.look = "down";
  }
}

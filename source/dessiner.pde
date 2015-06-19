void dessiner(){
    x=mouseX;
    y=height-90;
    beginShape(); //debut de la forme libre
   // stroke(mouseY,mouseX,mouseX-mouseY);
   // fill(random(255),random(255),random(255)); //Quand on est invincible
  vertex(x, y);//1 on definit les segments pour qu'ils se relient ensuite
  vertex(x+12.5, y); //1.1
  vertex(x+12.5, y-20); //1.2
  vertex(x+17.5, y-10); //1.3
  vertex(x+17.5, y); //1.4
  vertex(x+30, y);//2
  vertex(x+45, y+10); //3
  vertex(x+45, y+20); //4
  //debut de la partie droite
  vertex(x+60, y+20); //5
  vertex(x+60, y-100); //6
  vertex(x+80, y-80); //7
  vertex(x+80, y+30); //8
  vertex(x+85, y+30); //9
  vertex(x+85, y+45); //10
  vertex(x+80, y+80); //11
  vertex(x+60, y+80); //12
  vertex(x+60, y+40); //13
  //fin de la partie droite
  vertex(x+40, y+40); //14
  vertex(x+40, y+45); //15
  vertex(x+30, y+70); //16
  vertex(x+15, y+70); //17
  vertex(x+15, y+80); //18
  vertex(x+25, y+80); //19
  vertex(x+25, y+90); //20
  vertex(x-25, y+90); //21
  vertex(x-25, y+80); //22
  vertex(x-15, y+80); //23
  vertex(x-15, y+70); //24
  vertex(x-30, y+70); //25
  vertex(x-40, y+45); //26
  vertex(x-40, y+40); //27
  //debut de la partie gauche
  vertex(x-60, y+40); //28
  vertex(x-60, y+80); //29
  vertex(x-80, y+80); //30
  vertex(x-85, y+45); //31
  vertex(x-85, y+30); //32
  vertex(x-80, y+30); //33
  vertex(x-80, y-80); //34
  vertex(x-60, y-100); //35
  vertex(x-60, y+20); //36
  //fin de la partie gauche
  vertex(x-45, y+20); //37
  vertex(x-45, y+10); //38
  vertex(x-30, y); //39
  vertex(x-17.5, y); //39.1
  vertex(x-17.5, y-10); //39.2
  vertex(x-12.5, y-20); //39.3
  vertex(x-12.5, y); //39.4  
  endShape(CLOSE);
}



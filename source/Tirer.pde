void tirer(){
    stroke(255);
    line(x+12.5,y-20,x+12.5,0);//cela tir un trait verticale de la pointe du vaisseau jusqu'au bout du cadre
    line(x-12.5,y-20,x-12.5,0);
}

    void tireSpecial(){
      if(compteurTire>0){
    //dessin des tirs "puissants" on fait le clic droit et c'est limité 
    beginShape();
    vertex(x+60, y-100);
    vertex(x+60, 0);
    vertex(x+80, 0);
    vertex(x+80, y-80);
    endShape(CLOSE);
    beginShape();
    vertex(x-60, y-100);
    vertex(x-60, 0);
    vertex(x-80, 0);
    vertex(x-80, y-80);
    endShape(CLOSE);
      }
      if(compteurTire<=0){
        compteurTire = 0;
      }
  }



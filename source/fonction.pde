void quitter(){
  exit();
}

void recommencer(){
  nbreAsteroidVisible=2;//nombre d'asteroid initial
LimiteNbreAsteroid=10;// limite du nombre de pop total d'asteroid
t= millis();//le temps ecouler
float asteroidX;
asteroidY=20;
  remplissage=color(255);
compteurTire=20;//compteur pour savoir quelle vaisseau on utilise
compteurAsteroid=0; //Score
existe = true;//les asteroides existes
boolean bonus;
float distance; // distance pour la collision entre vaisseau asteroïde
int x,y;
float vitesse = 2;

setup();

background(0);
  dessiner();
  fill(255);
  text("Vous avez detruit"+" "+compteurAsteroid+" Asteroids", (width+20) - (width), (width+20) - (width));
  text("Vous avez encore"+" "+compteurTire+" tirs speciaux", (width+300) - (width), (width+20) - (width));
  for(int i=0;i<nbreAsteroidVisible;i++){
      asteroids[i].bougeAsteroid();// les void vont s'éxecuter suivant la boucle defini
      asteroids[i].display();
  }
  
  Collision();
}

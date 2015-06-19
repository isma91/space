class Asteroid{ //Creation de la classe asteroid pour les dupliquer ensuite
  boolean existe;
  boolean bonus;
  float asteroidX;
  float asteroidY;
  int tailleAsteroid;
  float vitesse;//initialisation des parametre Ã  prendre en compte
  
  Asteroid (boolean existeX, boolean bonusX, float XasteroidX, float YasteroidY ,int XtailleAsteroid){ // Consrtucteur de l'asteroid avec differente position et different taille
    existe = existeX;
    bonus = bonusX;
    asteroidX = XasteroidX;
    asteroidY = YasteroidY;
    tailleAsteroid=XtailleAsteroid;
    
    vitesse=2;
  }
  
  void display(){
    if(existe==true && bonus==false){
    fill(color(255));   
    ellipse(asteroidX,asteroidY,tailleAsteroid,tailleAsteroid);//affichage des asteroids
  }
  if(existe==true && bonus==true){
    fill(color(255,0,0));
    ellipse(asteroidX,asteroidY,tailleAsteroid,tailleAsteroid);//affichage des asteroids
    fill(color(255));
  }
}
    
  void bougeAsteroid(){
      asteroidY=asteroidY+vitesse;//les asteroid descende jusqu'en bas
      }
}
Asteroid[] asteroids = new Asteroid[LimiteNbreAsteroid];

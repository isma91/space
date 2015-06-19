int nbreAsteroidVisible=2;//nombre d'asteroid initial
int LimiteNbreAsteroid=10;// limite du nombre de pop total d'asteroid
int t= millis();//le temps ecouler
float asteroidX;
float asteroidY=20;
int tailleAsteroid;
color remplissage=color(255);
int compteurTire=20;//compteur pour savoir quelle vaisseau on utilise
int compteurAsteroid=0; //Score
boolean existe = true;//les asteroides existes
boolean bonus;
float distance; // distance pour la collision entre vaisseau asteroïde
int x,y;

void setup(){
    size(500,500);
    noCursor();
        for(int i=0;i<LimiteNbreAsteroid;i++){
          
          float hasard = random(99);// 0 à 99 = 100 nombres    
                  if ( hasard < 10 ) { // 10 chances sur 100, donc 10%
                      asteroids[i] = new Asteroid(true,true, int(random(20,480)),0,int(random(20,40)));//creation d'asteroid à partir de 0 jusqu'à limiteNbre
                      //avec existe=true et bonus=true
                      if(asteroids[i].existe==false){
                        compteurTire = compteurTire+10;
                      }          }
            
                  else{
                      asteroids[i] = new Asteroid(true,false, int(random(20,480)),0,int(random(20,40)));//creation d'asteroid à partir de 0 jusqu'à limiteNbre
        }         //avec existe=true et bonus=false
      }
}

void draw(){
  background(0);
  dessiner();
  fill(255);
  println(nbreAsteroidVisible+" "+LimiteNbreAsteroid);
  
  text("Vous avez detruit"+" "+compteurAsteroid+" Asteroids", (width+20) - (width), (width+20) - (width));
  text("Vous avez encore"+" "+compteurTire+" tirs speciaux", (width+300) - (width), (width+20) - (width));
  for(int i=0;i<nbreAsteroidVisible;i++){
      asteroids[i].bougeAsteroid();// les void vont s'éxecuter suivant la boucle defini
      asteroids[i].display();
  }
   
  if(nbreAsteroidVisible<LimiteNbreAsteroid-1){// tant que le nombre d'asteroid afficher ne depasse pas la limite du tableau
      if(millis()-t>1000){
          asteroids[nbreAsteroidVisible].existe=true; 
          nbreAsteroidVisible=nbreAsteroidVisible+1;// Toute les secondes on cree un nouvel asteroid aleatoirement
          t=millis();
            }
      }
      
   Collision();
    
    if(nbreAsteroidVisible == LimiteNbreAsteroid-1){
      if(compteurAsteroid == nbreAsteroidVisible ){
        fill(255,0,0);
        text("Vous avez GAGNE !!! Appuyer Q pour quitter ou R pour recommencer",width/8, height/2);
        textSize(10);
      
      if(key == 'q'){
        quitter();
      }
      
      if(key == 'r'){
        recommencer();
      }
    }
  }
  if(nbreAsteroidVisible<LimiteNbreAsteroid-1){//à tout moment on peut recommencer ou quitter
      
      if(key == 'q'){
        quitter();
      }
      
      if(key == 'r'){
        recommencer();
      }
  }
}

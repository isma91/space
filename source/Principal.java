import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Principal extends PApplet {

int nbreAsteroidVisible=2;//nombre d'asteroid initial
int LimiteNbreAsteroid=10;// limite du nombre de pop total d'asteroid
int t= millis();//le temps ecouler
float asteroidX;
float asteroidY=20;
int tailleAsteroid;
int remplissage=color(255);
int compteurTire=20;//compteur pour savoir quelle vaisseau on utilise
int compteurAsteroid=0; //Score
boolean existe = true;//les asteroides existes
boolean bonus;
float distance; // distance pour la collision entre vaisseau astero\u00efde
int x,y;

public void setup(){
    size(500,500);
    noCursor();
        for(int i=0;i<LimiteNbreAsteroid;i++){
          
          float hasard = random(99);// 0 \u00e0 99 = 100 nombres    
                  if ( hasard < 10 ) { // 10 chances sur 100, donc 10%
                      asteroids[i] = new Asteroid(true,true, PApplet.parseInt(random(20,480)),0,PApplet.parseInt(random(20,40)));//creation d'asteroid \u00e0 partir de 0 jusqu'\u00e0 limiteNbre
                      //avec existe=true et bonus=true
                      if(asteroids[i].existe==false){
                        compteurTire = compteurTire+10;
                      }          }
            
                  else{
                      asteroids[i] = new Asteroid(true,false, PApplet.parseInt(random(20,480)),0,PApplet.parseInt(random(20,40)));//creation d'asteroid \u00e0 partir de 0 jusqu'\u00e0 limiteNbre
        }         //avec existe=true et bonus=false
      }
}

public void draw(){
  background(0);
  dessiner();
  fill(255);
  println(nbreAsteroidVisible+" "+LimiteNbreAsteroid);
  
  text("Vous avez detruit"+" "+compteurAsteroid+" Asteroids", (width+20) - (width), (width+20) - (width));
  text("Vous avez encore"+" "+compteurTire+" tirs speciaux", (width+300) - (width), (width+20) - (width));
  for(int i=0;i<nbreAsteroidVisible;i++){
      asteroids[i].bougeAsteroid();// les void vont s'\u00e9xecuter suivant la boucle defini
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
  if(nbreAsteroidVisible<LimiteNbreAsteroid-1){//\u00e0 tout moment on peut recommencer ou quitter
      
      if(key == 'q'){
        quitter();
      }
      
      if(key == 'r'){
        recommencer();
      }
  }
}
class Asteroid{ //Creation de la classe asteroid pour les dupliquer ensuite
  boolean existe;
  boolean bonus;
  float asteroidX;
  float asteroidY;
  int tailleAsteroid;
  float vitesse;//initialisation des parametre \u00c3  prendre en compte
  
  Asteroid (boolean existeX, boolean bonusX, float XasteroidX, float YasteroidY ,int XtailleAsteroid){ // Consrtucteur de l'asteroid avec differente position et different taille
    existe = existeX;
    bonus = bonusX;
    asteroidX = XasteroidX;
    asteroidY = YasteroidY;
    tailleAsteroid=XtailleAsteroid;
    
    vitesse=2;
  }
  
  public void display(){
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
    
  public void bougeAsteroid(){
      asteroidY=asteroidY+vitesse;//les asteroid descende jusqu'en bas
      }
}
Asteroid[] asteroids = new Asteroid[LimiteNbreAsteroid];
 public void mousePressed(){
  if(mouseButton == LEFT){
    tirer();
    
  int victim=-1;//on met -1 car si on met 0 l'asteroid 0 ne pourra mourrir
  float distvictime = height;//la distance de la premiere cible peut etre jusqu'\u00e0 l'autre bout de l'\u00e9cran
  for(int i=0;i<nbreAsteroidVisible;i++){
     if (abs(mouseX-asteroids[i].asteroidX)<asteroids[i].tailleAsteroid && asteroids[i].existe==true){//Si notre souris, lorsqu'on tire, est pres de l'asteroide
                  if (abs(mouseY - asteroids[i].asteroidY) < distvictime){//si la distance vaisseau<>asteroid est plus petit que la distance initialiser
                    distvictime = abs(mouseY - asteroids[i].asteroidY);//la distance de la premiere cible vaut la distance vaisseau<>asteroid
                    victim = i;//victim vaut ce nombre d'asteroid
                  }     
                }
  }
     if (victim != -1){//Si la victime a \u00e9t\u00e9 modifier
            asteroids[victim].existe=false;//la victime n'existe plus car on l'a touch\u00e9
               compteurAsteroid = compteurAsteroid+1;
     }    
  }
  
  if(mouseButton == RIGHT){
    compteurTire = compteurTire-1;
    tireSpecial();
    
    if(compteurTire>0){
    int victim=-1;//on met -1 car si on met 0 l'asteroid 0 ne pourra mourrir
  float distvictime = height;//la distance de la premiere cible peut etre jusqu'\u00e0 l'autre bout de l'\u00e9cran
    
    for(int i=0;i<nbreAsteroidVisible;i++){
     if (abs(mouseX+70-asteroids[i].asteroidX)<asteroids[i].tailleAsteroid && asteroids[i].existe==true){//Si notre souris, lorsqu'on tire, est pres de l'asteroide
                  if (abs(mouseY - asteroids[i].asteroidY) < distvictime){//si la distance vaisseau<>asteroid est plus petit que la distance initialiser
                    distvictime = abs(mouseY - asteroids[i].asteroidY);//la distance de la premiere cible vaut la distance vaisseau<>asteroid
                    victim = i;//victim vaut ce nombre d'asteroid
                  }     
                }
  }
  
  for(int i=0;i<nbreAsteroidVisible;i++){
     if (abs(mouseX-70-asteroids[i].asteroidX)<asteroids[i].tailleAsteroid && asteroids[i].existe==true){//Si notre souris, lorsqu'on tire, est pres de l'asteroide
                  if (abs(mouseY - asteroids[i].asteroidY) < distvictime){//si la distance vaisseau<>asteroid est plus petit que la distance initialiser
                    distvictime = abs(mouseY - asteroids[i].asteroidY);//la distance de la premiere cible vaut la distance vaisseau<>asteroid
                    victim = i;//victim vaut ce nombre d'asteroid
                  }     
                }
  }
  
  
     if (victim != -1){//Si la victime a \u00e9t\u00e9 modifier
            asteroids[victim].existe=false;//la victime n'existe plus car on l'a touch\u00e9   
            compteurAsteroid = compteurAsteroid+1;
     }      
  } 
 }
}

public void Collision(){
     for(int i=0;i<LimiteNbreAsteroid;i++){
       if(asteroids[i].existe == true){ // si les asteroids existe car un asteroid detruit ne peut toucher le vaisseau
  float distance1 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x,y);//1
  float distance2 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x+12.5f, y); //1.1
  float distance3 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x+12.5f, y-20); //1.2
  float distance4 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x+17.5f, y-10); //1.3
  float distance5 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x+17.5f, y); //1.4
  float distance6 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x+30, y);//2
  float distance7 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x+45, y+10); //3
  float distance8 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x+45, y+20); //4
  float distance9 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x+60, y+20); //5
  float distance10 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x+60, y-100); //6
  float distance11 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x+80, y-80); //7
  float distance12 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x+80, y+30); //8
  float distance13 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x+85, y+30); //9
  float distance14 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x+85, y+45); //10
  float distance15 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x+80, y+80); //11
  float distance34 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x-80, y+80); //30
  float distance35 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x-85, y+45); //31
  float distance36 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x-85, y+30); //32
  float distance37 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x-80, y+30); //33
  float distance38 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x-80, y-80); //34
  float distance39 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x-60, y-100); //35
  float distance40 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x-60, y+20); //36
  float distance41 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x-45, y+20); //37
  float distance42 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x-45, y+10); //38
  float distance43 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x-30, y); //39
  float distance44 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x-17.5f, y); //39.1
  float distance45 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x-17.5f, y-10); //39.2
  float distance46 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x-12.5f, y-20); //39.3
  float distance47 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x-12.5f, y); //39.4 
       
  
  if(distance1<10 || distance2<10 || distance3<10 || distance4<10 || distance5<10 || distance6<10 || distance7<10 || distance8<10 || distance9<10 || distance10<10){
    for( i=0;i<LimiteNbreAsteroid;i++){
      asteroids[i].vitesse=0;
    }
    text("GAME OVER appuyer sur Q pour quitter ou R pour recommencer", width/8, height/2);
    if(key == 'q'){
        quitter();
      }
      
      if(key == 'r'){
        recommencer();
      }
     }
     
     if(distance11<10 || distance12<10 || distance13<10 || distance14<10 || distance15<10){
       for( i=0;i<LimiteNbreAsteroid;i++){
      asteroids[i].vitesse=0;
    }
    text("GAME OVER appuyer sur Q pour quitter ou R pour recommencer", width/8, height/2);
    if(key == 'q'){
        quitter();
      }
      
      if(key == 'r'){
        recommencer();
      }
     }
     
       if(distance34<10 || distance35<10 || distance36<10 || distance37<10 || distance38<10 || distance39<10){
         for( i=0;i<LimiteNbreAsteroid;i++){
      asteroids[i].vitesse=0;
    }
         text("GAME OVER appuyer sur Q pour quitter ou R pour recommencer", width/8, height/2);
    if(key == 'q'){
        quitter();
      }
      
      if(key == 'r'){
        recommencer();
      }
     }
     
     if(distance1<40 || distance41<10 || distance42<10 || distance43<10 || distance44<10 || distance45<10 || distance46<10 || distance47<10){
       for( i=0;i<LimiteNbreAsteroid;i++){
      asteroids[i].vitesse=0;
    }
    text("GAME OVER appuyer sur Q pour quitter ou R pour recommencer", width/8, height/2);
    if(key == 'q'){
        quitter();
      }
      
      if(key == 'r'){
        recommencer();
      }
       }  
     }
   }
 }
public void tirer(){
    stroke(255);
    line(x+12.5f,y-20,x+12.5f,0);//cela tir un trait verticale de la pointe du vaisseau jusqu'au bout du cadre
    line(x-12.5f,y-20,x-12.5f,0);
}

    public void tireSpecial(){
      if(compteurTire>0){
    //dessin des tirs "puissants" on fait le clic droit et c'est limit\u00e9 
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


public void dessiner(){
    x=mouseX;
    y=height-90;
    beginShape(); //debut de la forme libre
   // stroke(mouseY,mouseX,mouseX-mouseY);
   // fill(random(255),random(255),random(255)); //Quand on est invincible
  vertex(x, y);//1 on definit les segments pour qu'ils se relient ensuite
  vertex(x+12.5f, y); //1.1
  vertex(x+12.5f, y-20); //1.2
  vertex(x+17.5f, y-10); //1.3
  vertex(x+17.5f, y); //1.4
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
  vertex(x-17.5f, y); //39.1
  vertex(x-17.5f, y-10); //39.2
  vertex(x-12.5f, y-20); //39.3
  vertex(x-12.5f, y); //39.4  
  endShape(CLOSE);
}


public void quitter(){
  exit();
}

public void recommencer(){
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
float distance; // distance pour la collision entre vaisseau astero\u00efde
int x,y;
float vitesse = 2;

setup();

background(0);
  dessiner();
  fill(255);
  text("Vous avez detruit"+" "+compteurAsteroid+" Asteroids", (width+20) - (width), (width+20) - (width));
  text("Vous avez encore"+" "+compteurTire+" tirs speciaux", (width+300) - (width), (width+20) - (width));
  for(int i=0;i<nbreAsteroidVisible;i++){
      asteroids[i].bougeAsteroid();// les void vont s'\u00e9xecuter suivant la boucle defini
      asteroids[i].display();
  }
  
  Collision();
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--full-screen", "--bgcolor=#666666", "--stop-color=#cccccc", "Principal" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

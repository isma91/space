 void mousePressed(){
  if(mouseButton == LEFT){
    tirer();
    
  int victim=-1;//on met -1 car si on met 0 l'asteroid 0 ne pourra mourrir
  float distvictime = height;//la distance de la premiere cible peut etre jusqu'à l'autre bout de l'écran
  for(int i=0;i<nbreAsteroidVisible;i++){
     if (abs(mouseX-asteroids[i].asteroidX)<asteroids[i].tailleAsteroid && asteroids[i].existe==true){//Si notre souris, lorsqu'on tire, est pres de l'asteroide
                  if (abs(mouseY - asteroids[i].asteroidY) < distvictime){//si la distance vaisseau<>asteroid est plus petit que la distance initialiser
                    distvictime = abs(mouseY - asteroids[i].asteroidY);//la distance de la premiere cible vaut la distance vaisseau<>asteroid
                    victim = i;//victim vaut ce nombre d'asteroid
                  }     
                }
  }
     if (victim != -1){//Si la victime a été modifier
            asteroids[victim].existe=false;//la victime n'existe plus car on l'a touché
               compteurAsteroid = compteurAsteroid+1;
     }    
  }
  
  if(mouseButton == RIGHT){
    compteurTire = compteurTire-1;
    tireSpecial();
    
    if(compteurTire>0){
    int victim=-1;//on met -1 car si on met 0 l'asteroid 0 ne pourra mourrir
  float distvictime = height;//la distance de la premiere cible peut etre jusqu'à l'autre bout de l'écran
    
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
  
  
     if (victim != -1){//Si la victime a été modifier
            asteroids[victim].existe=false;//la victime n'existe plus car on l'a touché   
            compteurAsteroid = compteurAsteroid+1;
     }      
  } 
 }
}

void Collision(){
     for(int i=0;i<LimiteNbreAsteroid;i++){
       if(asteroids[i].existe == true){ // si les asteroids existe car un asteroid detruit ne peut toucher le vaisseau
  float distance1 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x,y);//1
  float distance2 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x+12.5, y); //1.1
  float distance3 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x+12.5, y-20); //1.2
  float distance4 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x+17.5, y-10); //1.3
  float distance5 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x+17.5, y); //1.4
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
  float distance44 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x-17.5, y); //39.1
  float distance45 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x-17.5, y-10); //39.2
  float distance46 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x-12.5, y-20); //39.3
  float distance47 = dist(asteroids[i].asteroidX,asteroids[i].asteroidY,x-12.5, y); //39.4 
       
  
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

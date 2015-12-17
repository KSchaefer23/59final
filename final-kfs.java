//// Kevin Schaefer
//// CST 112 Eve -- FINAL

//// Declare and initialize
int many=5;
// Boat array and names
Boat fleet[]= new Boat[many];
String boatNames[]= {
  "Jenny", "Penny", "XPenny", "Minnow", "Mimi"
};
// Squid array and names
Squid school[]=  new Squid[many];
String names[]= { 
  "One", "Two", "Red", "Blue", "Fish"
};
// Lobster array and names
Lobster kfs[]= new Lobster[many];
String lobsterNames[]= {
  "Larry", "Lex", "Leo", "Liz", "Lou"
};

float spacing;
float surface;
float moonX=0, moonY=100;
int score=0;
boolean mouseClicked = false;

//// Size & reset
void setup() {
  size( 800, 600 );
  spacing=  width/(many+1);  
  reset();
}

//// Reset function
void reset() {
  score=0;
  surface=  random(  height/4, height/2 );
  moonY=  surface/3;
  moonY=  random( 200, surface+200 );

  float x=  spacing;
  for (int i=0; i<many; i++ ) {
    school[i]=  new Squid( names[i], x );      // creates new squids
    x += spacing;                              // spaces squids evenly
  }
  for (int i=0; i<many; i++ ) {
    fleet[i]=  new Boat( boatNames[i]);        // creates new boats
  }
  for (int i=0; i<many; i++ ) {
    kfs[i]=  new Lobster( lobsterNames[i]);    // creates new lobsters
  }
}

//// Display "HI/LO" button for function
void showButton( float x, float y, float w, float h ) {
  fill(255, 175, 0);
  rectMode( CORNER );
  rect ( x, y, w, h, 7 );
  fill(0);
  text ("HI/LO", x+30, y+20);
}

//// Iterate and sort value functions for Boat
// Sorts the boats by X positions
void sortBoatX(Boat[] a, int many) {         
  for (int m = many; m > 1; m--) {
    int k = 0;
    for (int j = 1; j<m; j++) {
      if (a[j].x > a[k].x) k = j;
    }
    swapBoat(a, m-1, k);
  }
}
// Sorts the boats by DX values
void sortBoatDX(Boat[] a, int many) {
  for (int m = many; m > 1; m--) {
    int k = 0;
    for (int j = 1; j<m; j++) {
      if (a[j].dx < a[k].dx) k = j;
    }
    swapBoat(a, m-1, k);
  }
}
// Sorts the boats by cargo amount
void sortBoatCargo(Boat[] a, int many) {
  for (int m = many; m > 1; m--) {
    int k = 0;
    for (int j = 1; j<m; j++) {
      if (a[j].cargo < a[k].cargo) k = j;
    }
    swapBoat(a, m-1, k);
  }
}

//// Iterate and sort value functions for Squid
// Sorts the squids by X positions
void sortSquidX(Squid[] a, int many) {
  for (int m = many; m > 1; m--) {
    int k = 0;
    for (int j = 1; j<m; j++) {
      if (a[j].x > a[k].x) k = j;
    }
    swapSquid(a, m-1, k);
  }
}
// Sorts the squids by Y positions
void sortSquidY(Squid[] a, int many) {
  for (int m = many; m > 1; m--) {
    int k = 0;
    for (int j = 1; j<m; j++) {
      if (a[j].y > a[k].y) k = j;
    }
    swapSquid(a, m-1, k);
  }
}
// Sorts the squids by DY values
void sortSquidDY(Squid[] a, int many) {
  for (int m = many; m > 1; m--) {
    int k = 0;
    for (int j = 1; j<m; j++) {
      if (a[j].dy > a[k].dy) k = j;
    } 
    swapSquid(a, m-1, k);
  }
}
// Sorts the squids by leg number
void sortSquidL(Squid[] a, int many) {
  for (int m = many; m > 1; m--) {
    int k = 0;
    for (int j = 1; j<m; j++) {
      if (a[j].legs > a[k].legs) k = j;
    }
    swapSquid(a, m-1, k);
  }
}

//// Iterate and sort value functions for Lobster
// Sorts the lobsters by X positions
void sortLobsterX(Lobster[] a, int many) {
  for (int m = many; m > 1; m--) {
    int k = 0;
    for (int j = 1; j<m; j++) {
      if (a[j].x > a[k].x) k = j;
    }
    swapLobster(a, m-1, k);
  }
}
// Sorts the lobsters by Y positions
void sortLobsterY(Lobster[] a, int many) {
  for (int m = many; m > 1; m--) {
    int k = 0;
    for (int j = 1; j<m; j++) {
      if (a[j].y > a[k].y) k = j;
    }
    swapLobster(a, m-1, k);
  }
}

//// Function to swap boat properties
// Swaps the values inputted
void swapBoat(Boat[] a, int k, int j) {
  float tmpX;
  float tmpDX;
  int tmpC;
  String tmpN;

  tmpX = a[k].x;            // x swap
  a[k].x = a[j].x;
  a[j].x = tmpX;

  tmpDX = a[k].dx;          // dx swap
  a[k].dx = a[j].dx;
  a[j].dx = tmpDX;

  tmpC = a[k].cargo;        // cargo swap
  a[k].cargo = a[j].cargo;
  a[j].cargo = tmpC;

  tmpN = a[k].name;         // name swap
  a[k].name = a[j].name;
  a[j].name = tmpN;
}

//// Function to swap squid properties
// Swaps the values inputted
void swapSquid(Squid[] a, int k, int j) {
  float tmpX;
  float tmpY;
  float tmpDY;
  int tmpL;
  String tmpN;

  tmpX = a[k].x;          // x swap
  a[k].x = a[j].x;
  a[j].x = tmpX;

  tmpY = a[k].y;          // y swap
  a[k].y = a[j].y;
  a[j].y = tmpY;

  tmpDY = a[k].dy;        // dy swap
  a[k].dy = a[j].dy;
  a[j].dy = tmpDY;

  tmpL = a[k].legs;       // legs swap
  a[k].legs = a[j].legs;
  a[j].legs = tmpL;

  tmpN = a[k].name;       // name swap
  a[k].name = a[j].name;
  a[j].name = tmpN;
}

//// Function to swap lobster properties
// Swaps the values inputted
void swapLobster(Lobster[] a, int k, int j) {
  float tmpX;
  float tmpY;
  String tmpN;

  tmpX = a[k].x;          // x swap
  a[k].x = a[j].x;
  a[j].x = tmpX;

  tmpY = a[k].y;          // y swap
  a[k].y = a[j].y;
  a[j].y = tmpY;

  tmpN = a[k].name;       // name swap
  a[k].name = a[j].name;
  a[j].name = tmpN;
}

//// DRAW:  scene, show, action, messages, report
void draw() {
  scene();
  show();
  showButton(width-125, 15, 100, 30);
  // Shows (x,y) values when click button or '$' pressed
  if ( (key == '$') || (mouseClicked == true) ) {
    fill(255, 200, 200, 210);    
    rect(width/3, height/80, 300, 100);
    fill(255, 255, 255);
    text("(Release $ key or click anywhere on screen to resume.)", width/3.5, height/2);
    fill(0);

    sortLobsterY(kfs, kfs.length);   // Run the sort by Y function to get HI/LO

    // HIGHEST LOBSTER (lowest Y value)
    text( "Highest Lobster Coordinates:", width/3+20, height/80+20);  
    text("X:", width/3+30, height/80+40);
    text( kfs[0].x, width/3+40, height/80+40);
    text("Y:", width/3+110, height/80+40);    
    text( kfs[0].y, width/3+120, height/80+40);
    text( kfs[0].name, width/3+220, height/80+40);
    
    // LOWEST LOBSTER (highest Y value)
    text( "Lowest Lobster Coordinates:", width/3+20, height/80+70);
    text("X:", width/3+30, height/80+90);    
    text( kfs[4].x, width/3+40, height/80+90);
    text("Y:", width/3+110, height/80+90);        
    text( kfs[4].y, width/3+120, height/80+90);
    text( kfs[4].name, width/3+220, height/80+90);
  }
  // Shows report if any caps key pressed
  else if (key >= 'A' && key <= 'Z') {
    boatReport(120, fleet, fleet.length);
    squidReport(220, school, school.length);
    lobsterReport(320, kfs, kfs.length);
    messages();
  }
  // Only runs action if prior conditions not met  
  else {
    action();
    messages();
  }
}

//// Display instructions, title, and score
void messages() {
  fill(255, 255, 255);
  textSize( 20 );
  text( "Gone Fishin'", width/2.5, 20 );  // Title
  textSize(16);
  text( "Kevin Schaefer", 15, height-10); // Name
  textSize(13);

  // Boat Report Key Instructions
  text( "Hold B key to show boats in position order", 30, 40 );
  text( "Hold D key to show boats in speed order (from + to -)", 30, 55 );
  text( "Hold F key to show boats in cargo order", 30, 70 );
  // Squid Report Key Instructions
  text( "Hold X key to show squid in position order", width/2, 55 );
  text( "Hold Y key to show squid in height order", width/2, 70 );
  text( "Hold S key to show squid in speed order (from - to +)", width/2, 85 );
  text( "Hold L key to show squid in leg number order", width/2, 100 );
  // Lobster Report Key Instructions
  text( "Hold $ key to show highest and lowest lobster positions", 30, 100);

  // Display score (when not zero)
  if (score>0) text( "SCORE:  "+score, width*0.6, 20 );
  fill(0);
}

//// METHODS TO MOVE & DRAW.
void scene() {
  background( 50, 150, 200 );  // Dark sky
  if (moonX > width+100) {     // Moon
    moonX=  -100;
    moonY=  random( 100, surface+50 );
  }
  moonX += 1;
  fill( 200, 150, 50 );
  ellipse( moonX, moonY-150*sin( PI * moonX/width ), 40, 40 );
  // Dark water
  fill( 0, 100, 50 );
  noStroke();
  rect( 0, surface, width, height-surface );
  
  // Draws evenly spaced red triangles along the side under water
  for (float i=surface+20; i<height-41; i+=100 ) {
    fill(255, 0, 0);
    triangle(width-5, i, width-5, i+40, width-25, i+20);
  }
}

//// Moves the squids/boats/lobsters
void action() {
  for (int i=0; i<many; i++ ) {    // Squids
    school[i].move();
  }
  for (int i=0; i<many; i++ ) {    // Boats
    fleet[i].move();
  }
  for (int i=0; i<many; i++ ) {    // Lobsters
    kfs[i].move();
  }
}

//// Show the squids/boats/lobsters
void show() {
  float x=  spacing;
  for (int i=0; i<many; i++ ) {    // Squids
    school[i].x=  x;
    x += spacing;
    school[i].show();
  }
  for (int i=0; i<many; i++ ) {    // Boats
    fleet[i].show();
  }
  for (int i=0; i<many; i++ ) {    // Lobsters
    kfs[i].show();
  }
}

//// Creates the report of boat properties
void boatReport( float top, Boat[] a, int many ) {
  fill(255, 200, 200, 210);
  rect( 50, top, width-100, 20*many );
  float x=70, y=top+20;
  // Labels
  fill(150, 0, 0);
  text( "Boat", x+20, y );
  text( "Cargo", x+70, y );
  text( "X", x+125, y );
  text( "DX", x+285, y );
  fill(0);
  // Iterates through boat index to display
  for (int i=0; i<many; i++) {
    y += 15;    // Creates next line
    text( i, x, y );
    text( a[i].name, x+20, y );
    text( a[i].cargo, x+70, y );
    text( a[i].x, x+125, y );
    text( a[i].dx, x+285, y );
  }
}

//// Creates the report of squid properties
void squidReport( float top, Squid[] b, int many ) {
  fill(255, 255, 200, 200);
  rect( 50, top, width-100, 20*many );
  float x=70, y=top+20;
  // Labels
  fill(150, 0, 0);
  text( "Squid", x+20, y );
  text( "Legs", x+70, y );
  text( "X", x+125, y );
  text( "Y", x+205, y );
  text( "DY", x+365, y );
  fill(0);
  // Iterates through squid index to display
  for (int i=0; i<many; i++) {    
    y += 15;    // Creates next line
    text( i, x, y );
    text( b[i].name, x+20, y );
    text( b[i].legs, x+70, y );
    text( b[i].x, x+125, y );
    text( b[i].y, x+205, y );
    text( b[i].dy, x+365, y );
  }
}

//// Creates the report of lobster properties
void lobsterReport( float top, Lobster[] c, int many ) {
  fill(0, 255, 255, 210);
  rect( 50, top, width-100, 20*many );
  float x=70, y=top+20;
  // Labels
  fill(150, 0, 0);
  text( "Lobster", x+20, y );
  text( "X", x+125, y );
  text( "Y", x+205, y );
  text( "DX", x+285, y );
  text( "DY", x+365, y );  
  fill(0);
  // // Iterates through Lobster index to display
  for (int i=0; i<many; i++) {
    y += 15;    // Creates next line
    text( i, x, y );
    text( c[i].name, x+20, y );
    text( c[i].x, x+125, y );
    text( c[i].y, x+205, y );
    text( c[i].dx, x+285, y );
    text( c[i].dy, x+365, y );
  }
}    

//// EVENT HANDLERS: keys & clicks 
void keyPressed() {
  // Boat report buttons
  if (key == 'B') {
    sortBoatX(fleet, fleet.length);         // Sort position (x)
  }
  if (key == 'D') {
    sortBoatDX(fleet, fleet.length );       // Sort speed (dx)
  }
  if (key == 'F') {
    sortBoatCargo(fleet, fleet.length );    // Sort # cargo
  }
  // Squid report buttons
  if (key == 'X') {
    sortSquidX(school, school.length);      // Sort position (x)
  }
  if (key == 'Y') {
    sortSquidY(school, school.length);      // Sort height (y)
  }
  if (key == 'S') {
    sortSquidDY(school, school.length);     // Sort speed (dy)
  }
  if (key == 'L') {
    sortSquidL(school, school.length);      // Sort # legs
  }
  // Reset key
  if (key == 'r') reset();
  // Sends numbered squid to the bottom
  if (key == '0') school[0].bottom(); 
  if (key == '1') school[1].bottom(); 
  if (key == '2') school[2].bottom(); 
  if (key == '3') school[3].bottom(); 
  if (key == '4') school[4].bottom();  
  // Send highest to bottom.
  if (key == 'h') {
    int k=0;
    for (int i=1; i<many; i++ ) {
      if (school[i].y < school[k].y) k=i;    // k is index of highest.
    }
    school[k].bottom();
  }
  // Send all squids to the bottom
  if (key == 'b') {
    for (int k=0; k<many; k++ ) {
      school[k].bottom();
    }
  }
  // Send all squids to the top
  if (key == 't') {
    for (int k=0; k<many; k++ ) {
      school[k].y=  surface+10;
      school[k].dy=  -0.1  ;
    }
  }
}

//// Determines if the button is clicked
void mouseClicked() {
  if ((mouseX) > (width-125) && (mouseX) < ((width-125)+100) &&
    (mouseY) > (15) && (mouseY) < (45)) {
    mouseClicked= true;
  } else {
    mouseClicked= false;
  }
}

//// OBJECTS ////
class Squid {
  float x, y;        // Coordinates
  float dx=0, dy=0;  // Speed
  float w=40, h=40;  // Width & height
  int legs=10;       // Number of legs
  String name="";
  float r, g, b;     // Color
  int count=0;
  //// CONSTRUCTORS ////
  Squid( String s, float x ) {
    this.name=  s;
    this.x=x;
    bottom();
    // Purplish color
    r=  random(100, 255);
    g=  random(0, 100);
    b=  random(100, 250);
  }
  //// Start again at bottom  (Random speed)
  void bottom() {
    y=  height - h;                // bottom position
    dy= -random( 0.1, 0.9 );       // upward speed
    legs= int( random(1, 10.9) );  // number of legs
  }
  //// METHODS: move & show ////
  void move() {
    x += dx;
    y += dy;
    if (y>height) {          // moves back up when returns to bottom
      bottom();
      count++;
    } else if (y<surface) { 
      dy=  -3 * dy;          // Descend fast if hit surface
    }
  }
  //// Display the squid
  void show() {
    fill(r, g, b);                 // squid color
    stroke(r, g, b);
    ellipse( x, y, w, h );         // round top
    rect( x-w/2, y, w, h/2 );      // flat bottom
    // Legs
    fill(r, g, b);
    float legX=  x-w/2, foot=0;
    foot=  dy>=0 ? 0 : (y%47 > 23) ? 5 : -5;
    strokeWeight(3);
    for (int i=0; i<legs; i++) {
      line( legX, y+h/2, legX+foot, 20+y+h/2 );
      legX += w / (legs-1);
    }
    strokeWeight(3);
    fill(200, 200, 0);
    text( name, x-w/2, y-10+h/2 );
    fill(0);
    text( legs, x+2-w/2, y+h/2 );
    fill(255);
    if (count>0) text( count, x, y+h/2 );
  }
  // Return true if near
  boolean hit( float xx, float yy ) {
    return dist( xx, yy, x, y ) < h;
  }
}

//// BOAT CLASS ////
class Boat {
  String name="";
  float x, y=surface, dx=2; // initial properties
  int cargo=0, caught=0;
  // Assign name, random x and dx
  Boat(String s) {
    this.name=  s;
    x = random(0, width);
    dx = random(-3, 3);
  }  
  // Creates movement, determines cargo, speed & direction
  void move() {
    int caught=0;
    x += dx;    
    // Checks for a hit, adds to caught, sends squid to bottom
    for (int i=0; i<many; i++ ) {
      if (school[i].hit( x, surface )) {
        caught += school[i].legs;
        school[i].bottom();
      }
    }  
    cargo += caught;             // Squid legs caught in cargo         
    if (caught>0) x += 2*dx;     // Jump after catch
    if (x<0) {
      score += cargo;            // Add cargo to global score
      cargo=0;
      dx = random( 1, 3 );       // Boat moves right after hitting left boundary
    }    
    if (x>width) {
      dx = -random( 0.5, 3 );    // Boat moves left after hitting right boundary
    }
  }  

  // Draw & show boat
  void show() {
    fill(255, 130, 0);
    noStroke();
    rect( x, surface-20, 50, 20 );         // Boat body
    // When boat facing right direction
    if (dx>0) { 
      triangle( x+50, surface, x+50, surface-20, x+70, surface-20 );
    }
    // When boat facing left direction
    else {      
      triangle( x, surface, x, surface-20, x-20, surface-20 );
    }
    rect( x+12, surface-30, 25, 10 );      // Cabin
    fill(0);
    rect( x+20, surface-40, 10, 10 );      // Smokestack
    // Display name & cargo
    fill(255);
    text( name, x+5, surface-10 );
    fill(0);
    text( cargo, x+20, surface );
  }
}

//// LOBSTER CLASS ////
class Lobster {
  String name="";
  float x, dx=2; // initial properties
  float y, dy=2;
  int cargo=0, caught=0;
  int counter=0;
  // Assign name, random x and dx
  Lobster(String s) {
    this.name=  s;
    x = 0;                                    // Start on left side
    y = random((surface+height)/2, height);   // Start in lower half of water
    dx = random(0, 3);                        // Moving in right direction
    dy = random(-3, 0);                       // Moving upward direction
  }  
  // Controls lobster movement, boundaries, and if hit squid
  void move() {
    x += dx;  
    y += dy;
    counter += 1;
    // Sends squid to the bottom if lobster hits
    for (int i=0; i<many; i++ ) {
      if (school[i].hit( x, y )) {
        caught += school[i].legs;
        school[i].bottom();
      }
    }    
    // Reverse horizontal direction if hit boundaries
    if ( (x<0) || (x>width) ) {
      dx *= -1;
    }
    // Reverse vertical direction if hit boundaries
    if ( (y<surface+30) || (y>height) ) { 
      dy *= -1;
    }
  }  

  // Draw & show lobster
  void show() {
    fill(255, 0, 0);
    noStroke();
    ellipse( x, y, 80, 20 ); // Body
    // LOBSTER FACING RIGHT DIRECTION
    // Moving claws
    if (dx>0) {
      if (counter/30 % 2 == 0) {
        arc(x+20, y-21, 15, 30, 0, PI+QUARTER_PI, PIE);              // Top claw open
        arc(x+20, y+21, 15, 30, HALF_PI+QUARTER_PI, TWO_PI, PIE);    // Bottom claw open
      } else {
        arc(x+20, y-21, 15, 30, 0-QUARTER_PI, PI+HALF_PI, PIE);      // Top claw closed
        arc(x+20, y+21, 15, 30, HALF_PI, TWO_PI+QUARTER_PI, PIE);    // Bottom claw closed
      }
      triangle(x-25, y, x-45, y-12, x-45, y+12);                     // Tail
      fill(0);
      ellipse(x+28, y-3, 3, 3);                                      // Eyes
      ellipse(x+28, y+3, 3, 3);
    }
    // LOBSTER FACING LEFT DIRECTION
    // Moving claws
    else {
      if (counter/30 % 2 == 0) {
        arc(x-20, y-21, 15, 30, 0-QUARTER_PI, PI, PIE);              // Top claw open
        arc(x-20, y+21, 15, 30, PI, TWO_PI+QUARTER_PI, PIE);         // Bottom claw open
      } else {
        arc(x-20, y-21, 15, 30, 0-HALF_PI, PI+QUARTER_PI, PIE);      // Top claw closed
        arc(x-20, y+21, 15, 30, PI-QUARTER_PI, TWO_PI+HALF_PI, PIE); // Bottom claw closed
      }
      triangle(x+25, y, x+45, y-12, x+45, y+12);                     // Tail      
      fill(0);
      ellipse(x-28, y-3, 3, 3);                                      // Eyes
      ellipse(x-28, y+3, 3, 3);
    }
    fill(255);
    text( name, x-15, y+3 );
    fill(0);
  }    
  // Return true if near
  boolean hit( float xx, float yy ) {
    return dist( xx, yy, x, y ) < 25;
  }
}

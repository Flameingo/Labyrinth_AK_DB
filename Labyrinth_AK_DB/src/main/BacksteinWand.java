package main;

import static org.lwjgl.opengl.GL11.*;

import basics.*;

public class BacksteinWand extends Wand
{
<<<<<<< HEAD
//Dies wird die karge BacksteinWand, es gibt einen Konstruktor ohne Biegung fuer eine gerade Wand
//und einen Konstruktor mit Biegung fï¿½r eine gebogene Wand. 
// Ferner enthï¿½lt jeder Konstruktor Laenge sowie
//Koordinaten und Rotationswerte.
 
=======
  // Dies wird die karge BacksteinWand, es gibt einen Konstruktor ohne Biegung
  // fï¿½r eine gerade Wand
  // und einen Konstruktor mit Biegung fï¿½r eine gebogene Wand.
  // Ferner enthï¿½lt jeder Konstruktor Laenge sowie
  // Koordinaten und Rotationswerte.
>>>>>>> branch 'master' of https://github.com/Flameingo/Labyrinth_AK_DB.git
  
  // Private Variablen
  private static float dicke = 0.2f;
  private static float hoehe = 0.5f;
  
  BacksteinWand(Point pos, float alpha, float beta, float gamma, float laenge)
  {
    this.pos = pos;
    this.alpha = alpha;
    this.beta = beta;
    this.gamma = gamma;
    this.laenge = laenge;
    this.biegung = 0;
  }
  
  BacksteinWand(Point pos, float alpha, float beta, float gamma, float laenge, float biegung)
  {
    this(pos, alpha, beta, gamma, laenge);
    this.biegung = biegung;
  }
  
  @Override
  public void step()
  {
    // TODO Auto-generated method stub
  }
  
  @Override
  public void collision()
  {
    // TODO Auto-generated method stub
    
  }
  
  @Override
  public void draw()
  {
    glPushMatrix();
<<<<<<< HEAD
    
      glTranslatef(this.x,this.y,this.z); //Verschiebung auf die übergebene Position
      glRotatef(1,alpha, beta, gamma); //Drehung mit den übergebenen Winkeln
      this.draw();
=======
    {
      glTranslatef(pos.x, pos.y, pos.z);
      // TODO drehen mit alpha, beta, gamma
      glColor3f(0.5f, 0.5f, 0.5f);
>>>>>>> branch 'master' of https://github.com/Flameingo/Labyrinth_AK_DB.git
      
      glBegin(GL_POLYGON); // Die Vorderseite.
      glVertex3f(-this.laenge / 2, -hoehe / 2, -dicke / 2);
      glVertex3f(this.laenge / 2, -hoehe / 2, -dicke / 2);
      glVertex3f(this.laenge / 2, hoehe / 2, -dicke / 2);
      glVertex3f(-this.laenge / 2, hoehe / 2, -dicke / 2);
      glEnd();
      
      glBegin(GL_POLYGON); // Die linke Seite.
      glVertex3f(-this.laenge / 2, -hoehe / 2, -dicke / 2);
      glVertex3f(-this.laenge / 2, hoehe / 2, -dicke / 2);
      glVertex3f(-this.laenge / 2, hoehe / 2, dicke / 2);
      glVertex3f(-this.laenge / 2, -hoehe / 2, dicke / 2);
      glEnd();
      
      glBegin(GL_POLYGON); // Die untere Seite.
      glVertex3f(-this.laenge / 2, -hoehe / 2, -dicke / 2);
      glVertex3f(-this.laenge / 2, -hoehe / 2, dicke / 2);
      glVertex3f(this.laenge / 2, -hoehe / 2, dicke / 2);
      glVertex3f(this.laenge / 2, -hoehe / 2, -dicke / 2);
      glEnd();
      
      glBegin(GL_POLYGON); // Die rechte Seite.
      glVertex3f(this.laenge / 2, -hoehe / 2, -dicke / 2);
      glVertex3f(this.laenge / 2, -hoehe / 2, dicke / 2);
      glVertex3f(this.laenge / 2, hoehe / 2, dicke / 2);
      glVertex3f(this.laenge / 2, hoehe / 2, -dicke / 2);
      glEnd();
      
      glBegin(GL_POLYGON); // Die Hinterseite.
      glVertex3f(-this.laenge / 2, -hoehe / 2, dicke / 2);
      glVertex3f(-this.laenge / 2, hoehe / 2, dicke / 2);
      glVertex3f(this.laenge / 2, hoehe / 2, dicke / 2);
      glVertex3f(this.laenge / 2, -hoehe / 2, dicke / 2);
      glEnd();
      
      glBegin(GL_POLYGON); // Die obere Seite.
      glVertex3f(-this.laenge / 2, hoehe / 2, -dicke / 2);
      glVertex3f(this.laenge / 2, hoehe / 2, -dicke / 2);
      glVertex3f(this.laenge / 2, hoehe / 2, dicke / 2);
      glVertex3f(-this.laenge / 2, hoehe / 2, dicke / 2);
      glEnd();
    }
    glPopMatrix();
    
  }
  
  @Override
<<<<<<< HEAD
  void draw()
  {
    //Erschafft ein Wandstück mit den Werten 1, 0.5, 0.2.
    
    glColor3f(0.5f,0.5f,0.5f); //aktuelle Farbe: grau, noch zu überarbeiten
    
    glBegin(GL_POLYGON); //Die Vorderseite.
      glVertex3f(-this.laenge/2,-hoehe/2,-dicke/2);
      glVertex3f(this.laenge/2,-hoehe/2,-dicke/2);
      glVertex3f(this.laenge/2,hoehe/2,-dicke/2);
      glVertex3f(-this.laenge/2,hoehe/2,-dicke/2);
    glEnd();
     
    glBegin(GL_POLYGON); //Die linke Seite.
       glVertex3f(-this.laenge/2,-hoehe/2,-dicke/2);
       glVertex3f(-this.laenge/2,hoehe/2,-dicke/2);
       glVertex3f(-this.laenge/2,hoehe/2,dicke/2);
       glVertex3f(-this.laenge/2,-hoehe/2,dicke/2);
    glEnd();
    
    glBegin(GL_POLYGON); //Die untere Seite.
      glVertex3f(-this.laenge/2,-hoehe/2,-dicke/2);
      glVertex3f(-this.laenge/2,-hoehe/2,dicke/2);
      glVertex3f(this.laenge/2,-hoehe/2,dicke/2);
      glVertex3f(this.laenge/2,-hoehe/2,-dicke/2);
    glEnd();
    
    glBegin(GL_POLYGON); //Die rechte Seite.
      glVertex3f(this.laenge/2,-hoehe/2,-dicke/2);
      glVertex3f(this.laenge/2,-hoehe/2,dicke/2);
      glVertex3f(this.laenge/2,hoehe/2,dicke/2);
      glVertex3f(this.laenge/2,hoehe/2,-dicke/2);
    glEnd();
     
    glBegin(GL_POLYGON); //Die Hinterseite.
      glVertex3f(-this.laenge/2,-hoehe/2,dicke/2);
      glVertex3f(-this.laenge/2,hoehe/2,dicke/2);
      glVertex3f(this.laenge/2,hoehe/2,dicke/2);
      glVertex3f(this.laenge/2,-hoehe/2, dicke/2);
    glEnd();
    
    glBegin(GL_POLYGON); //Die obere Seite.
      glVertex3f(-this.laenge/2,hoehe/2,-dicke/2);
      glVertex3f(this.laenge/2,hoehe/2,-dicke/2);
      glVertex3f(this.laenge/2,hoehe/2,dicke/2);
      glVertex3f(-this.laenge/2,hoehe/2,dicke/2);
    glEnd();
    
    
    
    
    
    
    
    
    
    
  }

  @Override
  void drawGUI()
=======
  public void drawGUI()
>>>>>>> branch 'master' of https://github.com/Flameingo/Labyrinth_AK_DB.git
  {
    // TODO Auto-generated method stub
    
  }
  
}

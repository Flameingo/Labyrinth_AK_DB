package models3D;

import static org.lwjgl.opengl.GL11.*;

import basics.*;

public class BacksteinWand extends Wand
{
  // Dies wird die karge BacksteinWand, es gibt einen Konstruktor ohne Biegung
  // f�r eine gerade Wand
  // und einen Konstruktor mit Biegung f�r eine gebogene Wand.
  // Ferner enth�lt jeder Konstruktor Laenge sowie
  // Koordinaten und Rotationswerte.
  
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
    {
      glTranslatef(pos.x, pos.y, pos.z);
      // TODO drehen mit alpha, beta, gamma
      glColor3f(0.5f, 0.5f, 0.5f);
      
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
  public void drawGUI()
  {
    // TODO Auto-generated method stub
    
  }
  
}

import static org.lwjgl.opengl.GL11.*;


public class BacksteinWand extends Wand
{
//Dies wird die karge BacksteinWand, es gibt einen Konstruktor ohne Biegung für eine gerade Wand
//und einen Konstruktor mit Biegung für eine gebogene Wand. 
// Ferner enthält jeder Konstruktor Laenge sowie
//Koordinaten und Rotationswerte.
 
  
  //Private Variablen
  private static float dicke = 0.2f;
  private static float hoehe = 0.5f;
  
  
  
  BacksteinWand(float x, float y, float z, float alpha, float beta, float gamma, float laenge)
  {
    this.x=x;
    this.y=y;
    this.z=z;
    this.alpha=alpha;
    this.beta=beta;
    this.gamma=gamma;
    this.laenge=laenge;
    
  }
  
  
  @Override
  void step()
  {
    glPushMatrix();
    
      glTranslatef(this.x,this.y,this.z);
      glRotatef(1,alpha, beta, gamma);
      this.draw();
      
    glPopMatrix();
    
   
    
  }

  @Override
  void draw()
  {
    glColor3f(0.5f,0.5f,0.5f);
    
    glBegin(GL_POLYGON); //Die Vorderseite.
      glVertex3f(0,0,0);
      glVertex3f(this.laenge,0,0);
      glVertex3f(this.laenge,hoehe,0);
      glVertex3f(0,hoehe,0);
    glEnd();
     
    glBegin(GL_POLYGON); //Die linke Seite.
       glVertex3f(0,0,0);
       glVertex3f(0,hoehe,0);
       glVertex3f(0,hoehe,dicke);
       glVertex3f(0,0,dicke);
    glEnd();
    
    glBegin(GL_POLYGON); //Die untere Seite.
      glVertex3f(0,0,0);
      glVertex3f(0,0,dicke);
      glVertex3f(this.laenge,0,dicke);
      glVertex3f(this.laenge,0,0);
    glEnd();
    
    glBegin(GL_POLYGON); //Die rechte Seite.
      glVertex3f(this.laenge,0,0);
      glVertex3f(this.laenge,0,dicke);
      glVertex3f(this.laenge,hoehe,dicke);
      glVertex3f(this.laenge,hoehe,0);
    glEnd();
     
    glBegin(GL_POLYGON); //Die Hinterseite.
      glVertex3f(0,0,dicke);
      glVertex3f(0,hoehe,dicke);
      glVertex3f(this.laenge,hoehe,dicke);
      glVertex3f(this.laenge,0, dicke);
    glEnd();
    
    glBegin(GL_POLYGON); //Die obere Seite.
      glVertex3f(0,hoehe,0);
      glVertex3f(this.laenge,hoehe,0);
      glVertex3f(this.laenge,hoehe,dicke);
      glVertex3f(0,hoehe,dicke);
    glEnd();
  }

  @Override
  void drawGUI()
  {
    // TODO Auto-generated method stub
    
  }
  
}

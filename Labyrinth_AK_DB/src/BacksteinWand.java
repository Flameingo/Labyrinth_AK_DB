import static org.lwjgl.opengl.GL11.*;


public class BacksteinWand extends Wand
{
//Dies wird die karge BacksteinWand, es gibt einen Konstruktor ohne Biegung für eine gerade Wand
//und einen Konstruktor mit Biegung für eine gebogene Wand. 
// Ferner enthält jeder Konstruktor Laenge sowie
//Koordinaten und Rotationswerte.
 
  
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
      draw();
      
    glPopMatrix();
    
   
    
  }

  @Override
  void draw()
  {
    glColor3f(0.5f,0.5f,0.5f);
    
    glBegin(GL_POLYGON); //Die Vorderseite.
      glVertex3f(0,0,0);
      glVertex3f(this.x,0,0);
      glVertex3f(this.x,this.y,0);
      glVertex3f(0,this.y,0);
    glEnd();
     
    glBegin(GL_POLYGON); //Die linke Seite.
       glVertex3f(0,0,0);
       glVertex3f(0,this.y,0);
       glVertex3f(0,this.y,this.z);
       glVertex3f(0,0,this.z);
    glEnd();
    
    glBegin(GL_POLYGON); //Die untere Seite.
      glVertex3f(0,0,0);
      glVertex3f(0,0,this.z);
      glVertex3f(this.x,0,this.z);
      glVertex3f(this.x,0,0);
    glEnd();
    
    glBegin(GL_POLYGON); //Die rechte Seite.
      glVertex3f(this.x,0,0);
      glVertex3f(this.x,0,this.z);
      glVertex3f(this.x,this.y,this.z);
      glVertex3f(this.x,this.y,0);
    glEnd();
     
    glBegin(GL_POLYGON); //Die Hinterseite.
      glVertex3f(0,0,this.z);
      glVertex3f(0,this.y,this.z);
      glVertex3f(this.x,this.y,this.z);
      glVertex3f(this.x,0, this.z);
    glEnd();
    
    glBegin(GL_POLYGON); //Die obere Seite.
      glVertex3f(0,this.y,0);
      glVertex3f(this.x,this.y,0);
      glVertex3f(this.x,this.y,this.z);
      glVertex3f(0,this.y,this.z);
    glEnd();
  }

  @Override
  void drawGUI()
  {
    // TODO Auto-generated method stub
    
  }
  
}

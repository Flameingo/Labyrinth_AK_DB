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
      
      
    glPopMatrix();
    
   
    
  }

  @Override
  void draw()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  void drawGUI()
  {
    // TODO Auto-generated method stub
    
  }
  
}

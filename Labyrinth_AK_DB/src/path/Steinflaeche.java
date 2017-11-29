package path;

import params.*;
import main.Labyrinth;
import main.Objekt;

import static org.lwjgl.opengl.GL11.*;

import basics.Level;
import basics.Point;

public class Steinflaeche extends Objekt
{
  protected Shape myShape = new Shape();
  protected Shape putz = new Shape();
  
  public Steinflaeche(float x, float y, float z, float alpha, float beta, float gamma)
  {
    this.x = x;
    this.y = y;
    this.z = z;
    this.alpha = alpha;
    this.beta = beta;
    this.gamma = gamma;
    
    putz.addParam(new Quader("Mitte",1.4f,1.4f,0.05f),new Point(0.75f,0.75f,0));
    
    for(int vor = 0; vor < 10; vor++)
    {
      for(int r = 0; r < 5; r++)
      {
        myShape.addParam(new Quader("Mitte", 0.192f,0.292f,0.1f), new Point(0.1f+vor*0.15f,0.15f+r*0.30f));
      }
    }
    
        
    
    putz.translate(new Point(x, y, z)); // Verantwortlich fuer die Verschiebung des gesamtes Putz.
    putz.rotate(new float[] { alpha, beta, gamma }); // Verantwortlich fuer die Drehung des gesamtes Putz.
    
    myShape.translate(new Point(x, y, z)); // Verantwortlich fuer die Verschiebung des restlichen Objektes.
    myShape.rotate(new float[] { alpha, beta, gamma }); // Verantwortlich fuer die Drehung des restlichen Objektes. 
  }
  
  public Steinflaeche(Level lev)
  {
    this(lev.x1,lev.y1,0,0,0,0);
  }
  public Steinflaeche(Level lev, Etage e)
  {
    this.x = lev.x1;
    this.y = lev.y1;
    this.z = e.wert()*2.1f;
    
      putz.addParam(new Quader("Mitte",1.4f,1.4f,0.05f),new Point(0.75f,0.75f,0));
    
      for(int vor = 0; vor < 10; vor++)
      {
        for(int r = 0; r < 5; r++)
        {
          myShape.addParam(new Quader("Mitte", 0.192f,0.292f,0.1f), new Point(0.1f+vor*0.15f,0.15f+r*0.30f,0));
        }
      }
    
        
    
    putz.translate(new Point(x, y, z)); // Verantwortlich fuer die Verschiebung des gesamtes Putz.
    putz.rotate(new float[] { alpha, beta, gamma }); // Verantwortlich fuer die Drehung des gesamtes Putz.
    
    myShape.translate(new Point(x, y, z)); // Verantwortlich fuer die Verschiebung des restlichen Objektes.
    myShape.rotate(new float[] { alpha, beta, gamma }); // Verantwortlich fuer die Drehung des restlichen   
   
    
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
    Material.BACKSTEIN.use();
    myShape.draw();
    Material.COPPER.use();
    putz.draw();
  }
  
  @Override
  public void drawGUI()
  {
    // TODO Auto-generated method stub
    
  }
  
}

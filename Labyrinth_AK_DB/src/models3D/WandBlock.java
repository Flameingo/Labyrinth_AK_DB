package models3D;

import params.Quader;
import main.Objekt;
import params.Shape;
import static org.lwjgl.opengl.GL11.*;

import basics.Point;

public class WandBlock extends Objekt
{
  
  private int wdlaenge = 11;
  private int wdhoehe = 25;
  
  private Shape myShape = new Shape();
  
  public WandBlock()
  {
    for (int k = 0; k<wdhoehe; k++)
    {
      if (k%2 == 0)
      {
        
      for (int i = 0; i<wdlaenge; i++)
      {
         
            myShape.addParam(new Quader("Ecke", 0.25f, 0.1f, 0.05f), new Point(i*0.26f,0,k*0.06f));
            
         }
      }
         else
         {
           for (int i = 0; i<wdlaenge-1;i++)
           {
             myShape.addParam(new Quader("Ecke", 0.125f,0.1f, 0.05f), new Point(0,0,k*0.06f));
             myShape.addParam(new Quader("Ecke", 0.125f,0.1f,0.05f), new Point((wdlaenge-1)*0.26f+0.13f,0,k*0.06f));
             myShape.addParam(new Quader("Ecke", 0.25f,0.1f,0.05f), new Point (i*0.26f+0.13f,0,k*0.06f));
           }
      
         }
      }
  }
  public void draw()
  {
    myShape.draw();
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
  public void drawGUI()
  {
    // TODO Auto-generated method stub
    
  }
}

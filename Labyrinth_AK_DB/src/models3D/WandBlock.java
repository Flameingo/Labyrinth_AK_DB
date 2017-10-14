package models3D;

import params.Quader;
import main.Objekt;
import params.Shape;
import static org.lwjgl.opengl.GL11.*;

import basics.Point;

public class WandBlock extends Objekt
{
  
  private Shape myShape = new Shape();
  
  public WandBlock()
  {
    for (int k = 0; k<25; k++)
    {
      
        
        for (int i = 0; i<11; i++)
        {
         
            myShape.addParam(new Quader("Mitte", 0.25f, 0.1f, 0.05f), new Point(i*0.26f,0,k*0.06f));
           
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

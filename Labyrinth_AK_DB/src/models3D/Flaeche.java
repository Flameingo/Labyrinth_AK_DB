package models3D;

import basics.Point;
import main.Objekt;
import main.Spawner;
import params.Material;
import params.Quader;
import params.Shape;
import params.ZAKompliment;

public class Flaeche extends Objekt
{
  protected Shape myShape = new Shape();
  
  public Flaeche()
  {
  myShape.addParam(new Quader("Ecke",-(3/2)*Spawner.wandFeld,3.4f,0.3f), new Point (-(3/2)*Spawner.wandFeld-1.7f,3.4f,3.45f), new float[]{180,0,0});
     
    
  myShape.addParam(new ZAKompliment(1.7f,1.7f,0.3f), new Point(0,1.7f,3.15f), new float[]{90,0,0});
  myShape.addParam(new ZAKompliment(1.7f,1.7f,0.3f), new Point(0,1.7f,3.15f), new float[]{180,0,0});
  
    
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
    // TODO Auto-generated method stub
    
  }

  @Override
  public void drawGUI()
  {
    // TODO Auto-generated method stub
    
  }
  
}

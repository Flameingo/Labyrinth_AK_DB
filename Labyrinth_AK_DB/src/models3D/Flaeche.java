package models3D;

import basics.Point;
import main.Objekt;
import main.Spawner;
import params.Material;
import params.Quader;
import params.Shape;
import params.ZAKomplement;

public class Flaeche extends Objekt
{
  protected Shape myShape = new Shape();
  
  public Flaeche()
  {
  myShape.addParam(new Quader("Mitte",0.24f,0.13f,0.1f), new Point (-1.22f,2.7f,3.625f), new float[]{50,0,0});  
  myShape.addParam(new Quader("Mitte",0.24f,0.13f,0.1f), new Point (-1.37f,2.47f,3.625f), new float []{60,0,0});
    
  myShape.addParam(new Quader("Ecke",(1 + 9/40f)*wandFeld,3.4f,0.3f), new Point (-1.7f,3.4f,3.45f), new float[]{180,0,0});
     
    
  myShape.addParam(new ZAKomplement(1.7f,1.7f,0.3f), new Point(0,1.7f,3.45f), new float[]{90,0,0});
  myShape.addParam(new ZAKomplement(1.7f,1.7f,0.3f), new Point(0,1.7f,3.45f), new float[]{180,0,0});
  
    
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

package models3D;

import basics.*;
import main.Objekt;
import params.*;

public class TestfigurAlex extends Objekt
{
  
  private Shape myShape = new Shape();
  
  public TestfigurAlex()
  {
    myShape.addParam(new ZylinderTest(1,1,6,180));
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
    // TODO Auto-generated method stub
    myShape.draw();
  }

  @Override
  public void drawGUI()
  {
    // TODO Auto-generated method stub
    
  }
}
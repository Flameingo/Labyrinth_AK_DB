package models3D;

import main.Labyrinth;
import main.Objekt;
import params.Shape;

public class Turm extends Objekt
{

  protected Shape myShape = new Shape();
  protected float x,y,z;
  
  public Turm(float x, float y, float z){
    this.x = x;
    this.y = y;
    this.z = z;
    
    for (int r = 0; r< 4; r++)
    {
      Labyrinth.addObject(new WandTest(0,1.7f,r*1.5f,0,0,0,90));
      Labyrinth.addObject(new WandTest(0,1.7f,r*1.5f,90,0,0,90));
      Labyrinth.addObject(new WandTest(0,1.7f,r*1.5f,180,0,0,90));
      Labyrinth.addObject(new WandTest(0,1.7f,r*1.5f,270,0,0,90));
    }
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

package models3D;

import java.util.ArrayList;
import static org.lwjgl.opengl.GL11.*;

import main.Objekt;

public class DisplayList extends Objekt
{
  
  private ArrayList<Objekt> myObjekts = new ArrayList<Objekt>();
  private int               myList    = -1;
  
  private void init()
  {
    myList = glGenLists(1);
    
    glNewList(myList, GL_COMPILE_AND_EXECUTE);
    
    for (Objekt o : myObjekts)
    {
      o.draw();
    }
    
    glEndList();
    
    myObjekts.clear();
  }
  
  public void addObjekt(Objekt o)
  {
    myObjekts.add(o);
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
    if (myList != -1)
      glCallList(myList);
    else init();
  }
  
  @Override
  public void drawGUI()
  {
    // TODO Auto-generated method stub
    
  }
  
}

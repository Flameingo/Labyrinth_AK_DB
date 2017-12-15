package models3D;

import java.util.ArrayList;
import static org.lwjgl.opengl.GL11.*;

import main.Objekt;

public class DisplayList extends Objekt
{
  
  private ArrayList<DisplayList_Objekt> myObjekts = new ArrayList<DisplayList_Objekt>();
  private int                           myList    = -1;
  
  private void init()
  {
    if (myList != -1) glDeleteLists(myList, 1);
    myList = glGenLists(1);
    
    glNewList(myList, GL_COMPILE_AND_EXECUTE);
    
    for (DisplayList_Objekt o : myObjekts)
      o.draw();
    
    glEndList();
  }
  
  public void addObjekt(Objekt o)
  {
    myObjekts.add(new DisplayList_Objekt(o));
  }
  
  @Override
  public void step()
  {
    for (DisplayList_Objekt o : myObjekts)
      o.step();
  }
  
  @Override
  public void collision()
  {
    for (DisplayList_Objekt o : myObjekts)
      o.collision();
  }
  
  @Override
  public void draw()
  {
    if (myList != -1)
    {
      for (DisplayList_Objekt o : myObjekts)
        if (o.hasChanged())
        {
          for (DisplayList_Objekt obj : myObjekts)
            obj.setWasHiddenRight();
          init();
          return;
        }
      glCallList(myList);
    } else init();
  }
  
  @Override
  public void drawGUI()
  {
    for (DisplayList_Objekt o : myObjekts)
      o.drawGUI();
  }
  
}

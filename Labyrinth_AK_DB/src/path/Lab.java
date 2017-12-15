package path;

import java.util.LinkedList;

import main.*;
import models3D.DisplayList;
import params.Material;

public class Lab extends Objekt
{
  private DisplayList        myList       = new DisplayList();
  private LinkedList<Objekt> myListMoving = new LinkedList<Objekt>();
  
  private final static int   sichtweite   = 4;
  
  public void step()
  {
    hidden = false;
    int lowx = Kompass.getLvlX() - sichtweite;
    int nowx = getA();
    int highx = lowx + 2 * sichtweite;
    if (lowx >= nowx || nowx >= highx) hidden = true;
    int lowy = Kompass.getLvlY() - sichtweite;
    int nowy = getB();
    int highy = lowy + 2 * sichtweite;
    if (lowy >= nowy || nowy >= highy) hidden = true;
    if (!hidden)
    {
      myList.step();
      for (Objekt o : myListMoving)
        o.step();
    }
  }
  
  protected void add(Objekt o)
  {
    myList.addObjekt(o);
  }
  
  protected void addMoving(Objekt o)
  {
    myListMoving.add(o);
  }
  
  public void collision()
  {
    if (!hidden)
    {
      myList.collision();
      for (Objekt o : myListMoving)
        o.collision();
    }
  }
  
  public void draw()
  {
    Material.BACKSTEIN.use();
    if (!hidden)
    {
      myList.draw();
      for (Objekt o : myListMoving)
        o.draw();
    }
  }
  
  public void drawGUI()
  {
    if (!hidden)
    {
      myList.drawGUI();
      for (Objekt o : myListMoving)
        o.drawGUI();
    }
  }
  
}

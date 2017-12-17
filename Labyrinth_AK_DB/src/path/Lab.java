package path;

import java.util.LinkedList;

import basics.Point;
import main.*;
import models3D.DekoKreuz;
import models3D.DisplayList;
import params.Kugel;
import params.Material;
import params.Shape;
import unused.Testfigur;

public class Lab extends Objekt
{
  private DisplayList          myList       = new DisplayList();
  private LinkedList<Objekt>   myListMoving = new LinkedList<Objekt>();
  
  protected LinkedList<String> hitbox       = new LinkedList<String>();
  
  private final static int     sichtweite   = 4;
  
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
      for (String s : hitbox)
      {
        Point ecke = new Point(getA() * 1.5f, -getB() * 1.5f);
        Point p1 = new Point(ecke);
        Point p2 = new Point(ecke);
        switch (s)
        {
        case "U":
          p1.add(0, 0, 1);
          p2.add(-1.5f, 0, 1);
          break;
        case "O":
          p1.add(-1.5f, 1.5f, 1);
          p2.add(0f, 1.5f, 1);
          break;
        case "L":
          p1.add(-1.5f, 1.5f, 1);
          p2.add(-1.5f, 0f, 1);
          break;
        case "R":
          p1.add(0, 0, 1);
          p2.add(0, 1.5f, 1);
          break;
        }
        for (int i = 0; i <= 50; i++)
        {
          Point p = Point.lip(p1, p2, i / 50f);
          if (Labyrinth.player.hitbox(p))
          {
            int dir;
            switch (s)
            {
            case "U":
            case "O":
              if (Labyrinth.player.pos.y > p.y)
                dir = 1;
              else dir = -1;
              do
              {
                Labyrinth.player.pos.add(0, dir * PUSH, 0);
              } while (Labyrinth.player.hitbox(p));
              break;
            case "L":
            case "R":
              if (Labyrinth.player.pos.x > p.x)
                dir = 1;
              else dir = -1;
              do
              {
                Labyrinth.player.pos.add(dir * PUSH, 0, 0);
              } while (Labyrinth.player.hitbox(p));
              break;
            }
          }
        }
      }
      for (Objekt o : myListMoving)
        o.collision();
    }
  }
  
  private static final float PUSH = 0.01f;
  
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

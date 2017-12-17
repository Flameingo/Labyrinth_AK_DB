package path;

import java.util.LinkedList;

import basics.Point;
import main.*;
import models3D.DekoKreuz;
import models3D.DisplayList;
import models3D.Tuer;
import params.Kugel;
import params.Material;
import params.Shape;
import unused.Testfigur;

import static path.Etage.*;

public class Lab extends Objekt
{
  private DisplayList          myList       = new DisplayList();
  private LinkedList<Objekt>   myListMoving = new LinkedList<Objekt>();
  
  protected LinkedList<String> hitbox       = new LinkedList<String>();
  protected Etage              e            = NORMAL;
  
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
        int start = 0, end = 50;
        if (s.startsWith("T_"))
        {
          Tuer tuer = (Tuer) myListMoving.getFirst();
          if (tuer.getStatus()) continue;
          start = 18;
          end = 32;
        }
        Point ecke = new Point(getA() * 1.5f, -getB() * 1.5f, 1 + e.wert() * 2.1f);
        Point p1 = new Point(ecke);
        Point p2 = new Point(ecke);
        switch (s)
        {
        case "U":
        case "Rahmen_U":
        case "T_U":
          p1.add(0, 0, 0);
          p2.add(-1.5f, 0, 0);
          break;
        case "O":
        case "Rahmen_O":
        case "T_O":
          p1.add(-1.5f, 1.5f, 0);
          p2.add(0f, 1.5f, 0);
          break;
        case "L":
        case "Rahmen_L":
        case "T_L":
          p1.add(-1.5f, 1.5f, 0);
          p2.add(-1.5f, 0f, 0);
          break;
        case "R":
        case "Rahmen_R":
        case "T_R":
          p1.add(0, 0, 0);
          p2.add(0, 1.5f, 0);
          break;
        }
        for (int i = start; i <= end; i++)
        {
          if (s.startsWith("Rahmen_") && i > 17 && i < 33) continue;
          
          Point p = Point.lip(p1, p2, i / 50f);
          if (Labyrinth.player.hitbox(p))
          {
            int dir;
            switch (s)
            {
            case "U":
            case "O":
            case "Rahmen_O":
            case "Rahmen_U":
            case "T_O":
            case "T_U":
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
            case "Rahmen_R":
            case "Rahmen_L":
            case "T_R":
            case "T_L":
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

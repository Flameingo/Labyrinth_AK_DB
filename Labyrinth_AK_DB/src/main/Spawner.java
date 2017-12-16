package main;

import basics.Level;
import models3D.*;
import path.*;
import section.*;
import unused.AbschnittA;
import unused.AbschnittB;
import unused.AbschnittBB;
import unused.AbschnittBC;
import unused.AbschnittC;
import unused.Turm;

public class Spawner extends Objekt
{
  
  public static boolean     makeStatic = false;
  
  public static AbschnittA  abschnittA;
  public static AbschnittB  abschnittB;
  public static AbschnittBB abschnittBB;
  public static AbschnittBC abschnittBC;
  public static AbschnittC  abschnittC;
  public static AbschnittD  abschnittD;
  public static DD1 dD1;
  public static DD2 dD2;
  public static Turm turm;
  /**
   * created once at the start of the game and places all objects that should be in the game at the start.
   */
  public Spawner()
  {
    // Hier werden die Objekte ins Spiel gesetzt:
    
    DisplayList boden = new DisplayList(); // Vollstaendiger Boden mit 60 x60 und Ursprung als Mittelpunkt.
    boden.addObjekt(new Boden());
    Labyrinth.addObject(boden);
    // boden.hidden = true;

//    turm = new Turm("z",0,-20,0,0,0,0);
//    Labyrinth.addObject(turm);
    abschnittD = new AbschnittD();
    Labyrinth.addObject(abschnittD);
    
    dD1 = new DD1();
    Labyrinth.addObject(dD1);
    
    dD2 = new DD2();
    Labyrinth.addObject(dD2);
    dD2.hidden = true;
    

    
  }
  
  @Override
  public void step()
  {
    // TODO Auto-generated method stub
    
  }
  
  @Override
  public void draw()
  {
    // TODO Auto-generated method stub
    
  }
  
  @Override
  public void drawGUI()
  {
    // TODO Auto-generated method stub
    
  }
  
  @Override
  public void collision()
  {
    // TODO Auto-generated method stub
    
  }
  
}

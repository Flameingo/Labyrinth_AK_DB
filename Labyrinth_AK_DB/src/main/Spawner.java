package main;

import basics.Level;
import models3D.*;
import path.*;
import section.*;
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
    
    // Schalter
    // Labyrinth.addObject(new SchalterFeld("BB", new Level(8,3)));
    // Labyrinth.addObject (new SchalterFeld("B_BB", new Level(3,6))); //Existiert in ABschnitt B und Abschnitt BB
    // Labyrinth.addObject (new SchalterFeld("BB_BC", new Level(0,13))); //Existiert in Abschnitt BB und Abschnitt BC.
    // Labyrinth.addObject (new SchalterFeld("BC_C", new Level(0,-8))); //Existiert in Abschnitt BC und Abschnitt C.
    
    // Tueren
    
    // Labyrinth.addObject (new Tuer_L("01", new Level(3,6)));
    // Labyrinth.addObject (new Tuer_R("02", new Level(3,6)));
    // Labyrinth.addObject(new Tuer_R("03", new Level(6,6)));
    //
    // Schalter (Abschnitt D)
    Labyrinth.addObject(new SchalterFeld("D1", new Level(6, 26)));
    Labyrinth.addObject(new SchalterFeld("D2", new Level(12, 9)));
    Labyrinth.addObject(new SchalterFeld("D3", new Level(0, 22)));
    Labyrinth.addObject(new SchalterFeld("D4", new Level(0, 23)));
    Labyrinth.addObject(new SchalterFeld("D5", new Level(19, 22)));
    
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

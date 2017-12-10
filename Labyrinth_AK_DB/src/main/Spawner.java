package main;

import static org.lwjgl.opengl.GL11.*;

import basics.Level;
import models3D.*;
import params.*;
import path.*;
import section.*;

public class Spawner extends Objekt
{

  public static boolean makeStatic = false;


  public static DisplayList abschnittB;
  public static DisplayList abschnittBB;
  public static DisplayList abschnittBC;
  public static DisplayList abschnittC;
  public static DisplayList abschnittD;
  public static DisplayList boden;
  /**
   * created once at the start of the game and places all objects that should be
   * in the game at the start.
   */
  public Spawner()
  {
    // Hier werden die Objekte ins Spiel gesetzt:

    makeStatic = true;
    boden = new DisplayList(); //Vollstaendiger Boden mit 60 x60 und Ursprung als Mittelpunkt.
    boden.addObjekt(new Boden());
    Labyrinth.addObject(boden);
//    boden.hidden = true;
    
//    DisplayList bodenBC = new DisplayList(); //40x40 mit Ursprung als Mittelpunkt. Boden fuer Abschnitt B, Abschnitt C und Abschnitt BC.
//    bodenBC.addObjekt(new BodenBC());
//    Labyrinth.addObject(bodenBC);   
//    bodenBC.hidden = true;
//    
//    abschnittB = new DisplayList(); //Aufruf von AbschnittB, AbschnittB benoetigt "BodenBC"
//    abschnittB.addObjekt(new AbschnittB());
//    Labyrinth.addObject(abschnittB);
//    abschnittB.hidden = true;
//    
//    abschnittBB = new DisplayList(); //Aufruf von AbschnittBB
//    abschnittBB.addObjekt(new AbschnittBB());
//    Labyrinth.addObject(abschnittBB);
//    abschnittBB.hidden = true;
//    
//    abschnittBC = new DisplayList(); //Aufruf von Abschnitt BC
//    abschnittBC.addObjekt(new AbschnittBC());
//    Labyrinth.addObject(abschnittBC);
//    abschnittBC.hidden = true;
//
//    abschnittC = new DisplayList(); //Aufruf von AbschnittC, AbschnittB benoetigt "BodenBC"
//    abschnittC.addObjekt(new AbschnittC());
//    Labyrinth.addObject(abschnittC);
//    abschnittC.hidden = true;
    
    abschnittD = new DisplayList();
    abschnittD.addObjekt(new AbschnittD());
    Labyrinth.addObject(abschnittD);
    
    //Schalter
//    Labyrinth.addObject(new SchalterFeld("BB", new Level(8,3)));
//    Labyrinth.addObject (new SchalterFeld("B_BB", new Level(3,6))); //Existiert in ABschnitt B und Abschnitt BB
//    Labyrinth.addObject (new SchalterFeld("BB_BC", new Level(0,13))); //Existiert in Abschnitt BB und Abschnitt BC.
//    Labyrinth.addObject (new SchalterFeld("BC_C", new Level(0,-8))); //Existiert in Abschnitt BC und Abschnitt C.
    
    //Tueren
    
//    Labyrinth.addObject (new Tuer_L("01", new Level(3,6)));
//    Labyrinth.addObject (new Tuer_R("02", new Level(3,6)));
//    Labyrinth.addObject(new Tuer_R("03", new Level(6,6)));
//    



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

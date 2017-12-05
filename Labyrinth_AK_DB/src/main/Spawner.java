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
  public static DisplayList abschnittBC;
  public static DisplayList abschnittC;
  /**
   * created once at the start of the game and places all objects that should be
   * in the game at the start.
   */
  public Spawner()
  {
    // Hier werden die Objekte ins Spiel gesetzt:

//    makeStatic = true;
//    DisplayList boden = new DisplayList(); //Vollstaendiger Boden mit 40 x 40 und Ursprung als Mittelpunkt.
//    boden.addObjekt(new Boden());
//    Labyrinth.addObject(boden);
    
    DisplayList bodenBC = new DisplayList(); //Boden fuer Abschnitt B, Abschnitt C und Abschnitt BC.
    bodenBC.addObjekt(new BodenBC());
    Labyrinth.addObject(bodenBC);    
    
    DisplayList abschnittB = new DisplayList(); //Aufruf von AbschnittB, AbschnittB benoetigt "BodenBC"
    abschnittB.addObjekt(new AbschnittB());
    Labyrinth.addObject(abschnittB);
    abschnittB.hidden = true;

    DisplayList abschnittBC = new DisplayList(); //Aufruf von Abschnitt BC, AbschnittBC benoetigt "Boden" oder "BodenBC"
    abschnittBC.addObjekt(new AbschnittBC());
    Labyrinth.addObject(abschnittBC);
    abschnittBC.hidden = true;

    DisplayList abschnittC = new DisplayList(); //Aufruf von AbschnittC, AbschnittB benoetigt "BodenBC"
    abschnittC.addObjekt(new AbschnittC());
    Labyrinth.addObject(abschnittC);
    abschnittC.hidden = true;
    //Schalter
    
    Labyrinth.addObject (new SchalterFeld("B_BC", new Level(0,13))); //Existiert in Abschnitt B und Abschnitt BC.
    Labyrinth.addObject (new SchalterFeld("BC_C", new Level(0,-8))); //Existiert in Abschnitt BC und Abschnitt C.
    



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

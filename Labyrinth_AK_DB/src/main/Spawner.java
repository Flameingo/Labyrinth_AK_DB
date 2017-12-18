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
  
  public static AbschnittA  abschnittA;        // Statische Aufrufe, die fuer den Wahrheitswert hidden noetig sind.
  public static AbschnittB  abschnittB;        // Dieser macht eine bestimmte Displaylist vollstaendig ingame
                                               // unsichtbar, falls wahr gesetzt.
  public static AbschnittBB abschnittBB;       // Kann aber ebenso jede ingame erscheinen lassen (noetig fuer
                                               // Funktionen.levelup()).
  public static AbschnittBC abschnittBC;
  public static AbschnittC  abschnittC;
  public static AbschnittD  abschnittD;
  public static AbschnittE  abschnittE;
  public static DD1         dD1;
  public static DD2         dD2;
  public static Boden       boden;
  public static BodenBC     bodenBC;
  
  /**
   * created once at the start of the game and places all objects that should be in the game at the start.
   */
  public Spawner()
  {
    // Hier werden die Objekte ins Spiel gesetzt:
    
    // Vollstaendiger Boden mit 60 x60 und Ursprung als Mittelpunkt.
    boden = new Boden();
    Labyrinth.addObject(boden);
    boden.hidden = false;
    
     abschnittD = new AbschnittD(); //Alle Objekte aus Abschnitt D mit dD1/dD2.
     Labyrinth.addObject(abschnittD);
  
    
    abschnittE = new AbschnittE();
    Labyrinth.addObject(abschnittE);
    abschnittE.hidden = true;
    
    bodenBC = new BodenBC(); // Boden mit Loechern fuer den Untergrundbereich
    Labyrinth.addObject(bodenBC);
    bodenBC.hidden = true;
    
    dD1 = new DD1();			//Aktiv fuer erster Schalter "D1" in Ausgangsstellung. Produziert auf Level(7,12) zwei parallele Waende
    Labyrinth.addObject(dD1);	
    
    dD2 = new DD2();           //Erster Schalter umgelegt. Szenario aus DD1 um 90 grad gedreht.
    Labyrinth.addObject(dD2);
    dD2.hidden = true;
    
  }
  
  @Override
  public void step()
  {
  }
  
  @Override
  public void draw()
  {
  }
  
  @Override
  public void drawGUI()
  {
  }
  
  @Override
  public void collision()
  {
  }
  
}

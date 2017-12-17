package section;

import static path.Etage.KELLER;
import static path.Etage.KELLERD;

import java.util.LinkedList;

import basics.Level;
import basics.Point;
import basics.Text;
import main.Kompass;
import main.Labyrinth;
import main.Objekt;
import models3D.DekoKreuz;
import models3D.DekoSchild;
import models3D.RundeTreppe;
import models3D.Tuer;
import path.*;

public class AbschnittE extends Objekt
{
  protected LinkedList<Objekt> waende = new LinkedList<Objekt>(); //Objekte die eine oder mehrere Waende des Spiels beinhalten
  
  protected LinkedList<Objekt> steine = new LinkedList<Objekt>(); //Objekte wie Ecksteine, Bodenplatten oder Dekoartikel, die keinen direkten Einfluss haben
  
  protected LinkedList<Objekt> tueren = new LinkedList<Objekt>(); //Ausschliesslich Tueren, Tuerrahmen sind in der List der Waende.
  
  protected LinkedList<Objekt> schalter = new LinkedList<Objekt>(); //Ausschliesslich Schalter
  
  public AbschnittE() //Underground - Abschnitt aus dem zweiten Level | Braucht "BodenBC" anstatt "Boden". 
  {
	    // Underground
	  
	    waende.add(new RundeTreppe(13.5f, -6, -2.1f, 180, 0, 0, 360, 10));
	    waende.add(new LabEck_lo(new Level(10, 5), KELLER, true, 2.1f));
	    waende.add(new LabEck_ro(new Level(9, 5), KELLER, true, 2.1f));
	    waende.add(new LabEck_lu(new Level(10, 4), KELLER, true, 2f));
	    waende.add(new LabWeg_L(KELLER, new Level(9, 4)));
	    waende.add(new LabWeg_o_u(KELLER, new Level(9, 3)));
	    waende.add(new LabTuer_O(KELLER, new Level(9, 4)));
	    waende.add(new LabWeg_o_u(KELLER, new Level(9,2)));
	    waende.add(new LabWeg_r_l(KELLER, new Level(10,1)));
	    waende.add(new LabWeg_r_l(KELLER,new Level(11,1)));
	    waende.add(new LabWeg_r_l(KELLER, new Level(12,1)));
	    waende.add(new LabEck_lo(new Level(13,1),KELLER,true,2));
	    waende.add(new LabWeg_o_u(KELLER,new Level(13,0)));
	    waende.add(new LabWeg_o_u(KELLER,new Level(13,-1)));
	    waende.add(new LabWeg_O(KELLER,new Level(13,-1)));
	    
	    waende.add(new LabWeg_O(KELLER,new Level(9,1)));
	    waende.add(new LabWeg_r_l(KELLER, new Level(8,1)));
	    waende.add(new LabEck_ro(new Level(7,1),KELLER,true,2));
	    waende.add(new LabWeg_o_u(KELLER, new Level(7,2)));
	    waende.add(new LabEck_lo(new Level(7,3),KELLER,false,2));
	    waende.add(new LabEck_ro(new Level(6,3),KELLER,false,2));
	    waende.add(new LabWeg_r_l(KELLER,new Level(6,2)));
	    waende.add(new LabWeg_r_l(KELLER, new Level(6,1)));
	    waende.add(new LabEck_ru(new Level(6,0),KELLER,true,2));
	    waende.add(new LabWeg_r_l(KELLER,new Level(7,0)));
	    waende.add(new LabWeg_r_l(KELLER,new Level(8,0)));
	    waende.add(new LabEck_lo(new Level(9,0),KELLER,false,2));
	    waende.add(new LabWeg_O(KELLER,new Level(9,-1)));
	    waende.add(new LabWeg_r_l(KELLER, new Level(8,-1)));
	    waende.add(new LabWeg_r_l(KELLER, new Level(7,-1)));
	    waende.add(new LabWeg_r_l(KELLER, new Level(6,-1)));
	    waende.add(new LabEck_ro(new Level(5,-1),KELLER,false,2));
	    waende.add(new LabWeg_o_u(KELLER,new Level(5,-2)));
	    waende.add(new LabWeg_o_u(KELLER,new Level(5,-3)));
	    waende.add(new LabWeg_O(KELLER,new Level(5,-3)));
	    
	    // Overground
	    
	    waende.add(new LabEck_lo(new Level(10,5),true));
	    waende.add(new LabEck_ro(new Level(9,5),true));
	    waende.add(new LabEck_lu(new Level(10,4)));
	    waende.add(new LabWeg_L(new Level(9,4)));
	    waende.add(new LabEck_lu(new Level(9,3)));
	    waende.add(new LabWeg_r_l(new Level(8,3)));
	    
	    //Boden und Deckenplatten + die Treppen
	    
	   steine.add(new Steinflaeche(new Level(9, 4), KELLER));
	   steine.add(new Steinflaeche(new Level(9, 3), KELLER));
	   steine.add(new Steinflaeche(new Level(9, 4), KELLERD));
	   steine.add(new Steinflaeche(new Level(9, 3), KELLERD));
	   steine.add(new Steinflaeche(new Level(9, 5), KELLER));
	   steine.add(new Steinflaeche(new Level(10, 4), KELLER));
	   steine.add(new Steinflaeche(new Level(10, 5), KELLER));
	   steine.add(new Steinflaeche(new Level(10, 4), KELLERD));
	   steine.add(new Steinflaeche(new Level(9,2), KELLER));
	   steine.add(new Steinflaeche(new Level(9,2), KELLERD));
	   steine.add(new Steinflaeche(new Level(9,1), KELLER));
	   steine.add(new Steinflaeche(new Level(9,1),KELLERD));
	   steine.add(new Steinflaeche(new Level(10,1),KELLER));
	   steine.add(new Steinflaeche(new Level(10,1),KELLERD));
	   steine.add(new Steinflaeche(new Level(11,1),KELLER));
	   steine.add(new Steinflaeche(new Level(11,1),KELLERD));
	   steine.add(new Steinflaeche(new Level(12,1),KELLER));
	   steine.add(new Steinflaeche(new Level(12,1),KELLERD));
	   steine.add(new Steinflaeche(new Level(13,1),KELLER));
	   steine.add(new Steinflaeche(new Level(13,1),KELLERD));
	   steine.add(new Steinflaeche(new Level(13,0),KELLER));
	   steine.add(new Steinflaeche(new Level(13,0),KELLERD));
	   steine.add(new Steinflaeche(new Level(13,-1),KELLER));
	   steine.add(new Steinflaeche(new Level(13,-1),KELLERD));
	   
	   //Ecksteine
	   
	   steine.add(new Eckstein(KELLER,new Level(10,2)));
	   steine.add(new Eckstein(KELLER,new Level(9,2)));
	   steine.add(new Eckstein(KELLER,new Level(13,1)));
	   
  }
  
  @Override
  public void step()
  {
    
    for (Objekt wand : waende)
      wand.step();
    for (Objekt stein : steine)
      stein.step();
    for (Objekt tuer : tueren)
      tuer.step();
    for (Objekt schalt : schalter)
    {
      schalt.step();
    }
  }
  
  @Override
  public void collision()
  {
    
    for (Objekt wand : waende)
      wand.collision();
    for (Objekt stein : steine)
      stein.collision();
    for (Objekt tuer : tueren)
      tuer.collision();
    for (Objekt schalt : schalter)
      schalt.collision();
  }
  
  @Override
  public void draw()
  {
    
    for (Objekt wand : waende)
      wand.draw();
    for (Objekt stein : steine)
      stein.draw();
    for (Objekt tuer : tueren)
      tuer.draw();
    for (Objekt schalt : schalter)
      schalt.draw();
  }
  
  @Override
  public void drawGUI()
  {
    for (Objekt wand : waende)
      wand.drawGUI();
    for (Objekt stein : steine)
      stein.drawGUI();
    for (Objekt tuer : tueren)
      tuer.drawGUI();
    for (Objekt schalt : schalter)
      schalt.drawGUI();
    
  }
}

package unused;

import basics.Level;
import main.Objekt;

import models3D.RundeTreppe;
import params.Material;
import path.*;
import static path.Etage.*;

import java.util.LinkedList;

public class AbschnittB extends Objekt
{
  public static Objekt[] waende = new Objekt[50];
  protected Objekt[]     steine = new Objekt[22];
  
  protected LinkedList<Objekt> tueren = new LinkedList<Objekt>(); //Ausschliesslich Tueren, Tuerrahmen sind in der List der Waende.
  
  protected LinkedList<Objekt> schalter = new LinkedList<Objekt>(); //Ausschliesslich Schalter
  
  public AbschnittB()
  {
    
    waende[0] = new Sackgasse(new Level(1, 1),"r");
    waende[1] = new LabWeg_L(new Level(1, 2));
    waende[2] = new LabWeg_o_u(new Level(2, 3));
    waende[3] = new LabWeg_o_u(new Level(2, 4));
    waende[4] = new LabWeg_r_l(new Level(6, 1));
    waende[5] = new LabWeg_O(new Level(2, 1));
    waende[6] = new LabWeg_r_l(new Level(3, 1));
    waende[7] = new LabWeg_r_l(new Level(4, 1));
    waende[8] = new LabWeg_O(new Level(5, 1));
    waende[9] = new LabWeg_o_u(new Level(5, 2));
    waende[10] = new LabEck_lo(new Level(5, 3), true);
    waende[11] = new LabWeg_r_l(new Level(4, 3));
    waende[12] = new LabDmgWeg_O(new Level(3, 3));
    waende[13] = new LabWeg_U(new Level(3, 4));
    waende[14] = new LabWeg_U(new Level(4, 4));
    waende[15] = new LabWeg_U(new Level(5, 4));
    waende[16] = new LabEck_ro(new Level(2, 5), true);
    waende[17] = new LabWeg_U(new Level(3, 5));
    waende[18] = new LabWeg_U(new Level(4, 5));
    waende[19] = new LabEck_lo(new Level(5, 5));
    waende[20] = new LabWeg_O(new Level(6, 6));
    waende[21] = new LabWeg_O(new Level(7, 6));
    waende[22] = new LabWeg_O(new Level(8, 6));
    waende[23] = new LabEck_ro(new Level(9, 5), true);
    waende[24] = new LabEck_lu(new Level(10, 4));
    waende[25] = new LabWeg_o_u(new Level(9, 3));
    waende[26] = new LabWeg_o_u(new Level(9, 2));
    waende[27] = new LabWeg_r_l(new Level(7, 1));
    waende[28] = new LabWeg_r_l(new Level(8, 1));
    waende[29] = new LabWeg_L(new Level(1, 3));
    waende[30] = new LabWeg_L(new Level(1, 4));
    waende[31] = new LabWeg_L(new Level(1, 5));
    waende[32] = new LabWeg_L(new Level(1, 6));
    waende[33] = new LabWeg_U(new Level(2, 6));
    waende[34] = new LabWeg_U(new Level(3, 6));
    waende[35] = new LabTuer_L(new Level(3, 6));
    waende[36] = new LabTuer_R(new Level(3, 6));
    waende[37] = new LabEck_lu(new Level(9, 1), true);
    waende[38] = new LabEck_lo(new Level(10, 5), true);
    waende[39] = new RundeTreppe(13.5f, -6, -2.1f, 180, 0, 0, 360, 10);
    waende[40] = new LabWeg_L(new Level(9, 4));
    
    waende[47] = new LabWeg_o_u(new Level(1, 7));
    waende[48] = new LabEck_ro(new Level(1, 8), true);
    waende[49] = new Sackgasse(new Level(2, 8), "l");
    
    // Underground
    
    waende[41] = new LabEck_lo(new Level(10, 5), KELLER, true, 2.1f);
    waende[42] = new LabEck_ro(new Level(9, 5), KELLER, true, 2.1f);
    waende[43] = new LabEck_lu(new Level(10, 4), KELLER, true, 2f);
    waende[44] = new LabWeg_L(KELLER, new Level(9, 4));
    waende[45] = new LabWeg_o_u(KELLER, new Level(9, 3));
    waende[46] = new LabTuer_O(KELLER, new Level(9, 4));
    
    // Ecksteine werden in der linken oberen Ecke des Feldes platziert
    
    steine[0] = new Eckstein(new Level(2, 1));
    steine[1] = new Eckstein(new Level(2, 2));
    steine[2] = new Eckstein(new Level(2, 3));
    steine[3] = new Eckstein(new Level(3, 5));
    steine[4] = new Eckstein(new Level(6, 2));
    steine[5] = new Eckstein(new Level(6, 6));
    steine[6] = new Eckstein(new Level(9, 6));
    steine[7] = new Eckstein(new Level(9, 2));
    steine[8] = new Eckstein(new Level(6, 5));
    steine[9] = new Eckstein(new Level(6, 4));
    steine[10] = new Eckstein(new Level(2, 7));
    steine[11] = new Eckstein(new Level(2, 8));
    steine[12] = new Eckstein(new Level(4, 7));
    steine[13] = new Eckstein(new Level(10, 4));
    steine[14] = new Steinflaeche(new Level(9, 4), KELLER);
    steine[15] = new Steinflaeche(new Level(9, 3), KELLER);
    steine[16] = new Steinflaeche(new Level(9, 4), KELLERD);
    steine[17] = new Steinflaeche(new Level(9, 3), KELLERD);
    steine[18] = new Steinflaeche(new Level(9, 5), KELLER);
    steine[19] = new Steinflaeche(new Level(10, 4), KELLER);
    steine[20] = new Steinflaeche(new Level(10, 5), KELLER);
    steine[21] = new Steinflaeche(new Level(10, 4), KELLERD);
    
    
    // Schalter
     schalter.add(new SchalterFeld("BB", new Level(8,3)));
     schalter.add(new SchalterFeld("B_BB", new Level(3,6))); //Existiert in ABschnitt B und Abschnitt BB
     schalter.add(new SchalterFeld("BB_BC", new Level(0,13))); //Existiert in Abschnitt BB und Abschnitt BC.
     schalter.add(new SchalterFeld("BC_C", new Level(0,-8))); //Existiert in Abschnitt BC und Abschnitt C.
    
    // Tueren
    
     tueren.add(new Tuer_L("01", new Level(3,6)));
     tueren.add(new Tuer_R("02", new Level(3,6)));
     tueren.add(new Tuer_R("03", new Level(6,6)));
    
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
        schalt.step();
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

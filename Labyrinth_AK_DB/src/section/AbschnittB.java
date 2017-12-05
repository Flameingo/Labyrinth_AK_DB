package section;

import basics.Level;
import main.Objekt;
import models3D.RundeTreppe;
import params.Material;
import path.*;

public class AbschnittB extends Objekt
{
  protected Objekt[] waende = new Objekt[76];
  protected Objekt[] steine = new Objekt[22];
  
  public AbschnittB()
  {
    
    waende[0] = new LabWeg_r_l(new Level(1, 1));
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
    waende[12] = new LabWeg_O(new Level(3, 3));
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
    waende[35] = new LabWeg_o_u(new Level(1, 7));
    waende[36] = new LabWeg_o_u(new Level(4, 7));
    waende[37] = new LabEck_ro(new Level(1, 8), true);
    waende[38] = new Sackgasse(new Level(2, 8), "l");
    waende[39] = new LabWeg_U(new Level(3, 8));
    waende[40] = new LabWeg_R(new Level(4, 8));
    waende[41] = new LabTuer_R(new Level(3, 6));
    waende[42] = new LabEck_lu(new Level(9, 1), true);
    waende[43] = new LabEck_lo(new Level(10, 5), true);
    waende[44] = new RundeTreppe(13.5f, -6, -2.1f, 180, 0, 0, 360, 10);
    waende[45] = new LabWeg_L(new Level(9, 4));
    
    waende[52] = new LabWeg_o_u(new Level(4,9));
    waende[53] = new LabWeg_U(new Level(4,10));
    waende[54] = new LabWeg_r_l(new Level(3,10));
    waende[55] = new LabWeg_U(new Level(2,10));
    waende[56] = new LabEck_lu(new Level(1,9));
    waende[57] = new LabEck_ru(new Level(0,9));
    waende[58] = new LabWeg_o_u(new Level(0,10));
    waende[59] = new Sackgasse(new Level(0,11),"o");
    waende[60] = new LabWeg_L(new Level(1,11));
    waende[61] = new LabEck_ru(new Level(2,9));
    waende[62] = new LabWeg_O(new Level(3,9));
    waende[63] = new LabWeg_U(new Level(1,12));
    waende[64] = new LabWeg_U(new Level(0,12));
    waende[65] = new LabEck_ro(new Level(-1,12),true);
    waende[66] = new LabWeg_L(new Level(-1,11));
    waende[67] = new LabWeg_L(new Level(-1,10));
    waende[68] = new LabWeg_O(new Level(-1,9));
    waende[69] = new LabEck_ru(new Level(-2,9));
    waende[70] = new LabWeg_L(new Level(-2,10));
    waende[71] = new LabWeg_L(new Level(-2,11));
    waende[72] = new LabWeg_L(new Level(-2,12));
    waende[73] = new LabEck_ro(new Level(-2,13));
    waende[74] = new LabWeg_r_l(new Level(-1,13));
    waende[75] = new Sackgasse(new Level(0,13),"l");
    
    // Underground
    
    waende[46] = new LabEck_lo(new Level(10, 5), Etage.KELLER, true, 2.1f);
    waende[47] = new LabEck_ro(new Level(9, 5), Etage.KELLER, true, 2.1f);
    waende[48] = new LabEck_lu(new Level(10, 4), Etage.KELLER, true, 2f);
    waende[49] = new LabWeg_L(Etage.KELLER, new Level(9, 4));
    waende[50] = new LabWeg_o_u(Etage.KELLER, new Level(9, 3));
    waende[51] = new LabTuer_O(Etage.KELLER, new Level(9, 4));
    
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
    steine[14] = new Steinflaeche(new Level(9, 4), Etage.KELLER);
    steine[15] = new Steinflaeche(new Level(9, 3), Etage.KELLER);
    steine[16] = new Steinflaeche(new Level(9, 4), Etage.KELLERD);
    steine[17] = new Steinflaeche(new Level(9, 3), Etage.KELLERD);
    steine[18] = new Steinflaeche(new Level(9, 5), Etage.KELLER);
    steine[19] = new Steinflaeche(new Level(10, 4), Etage.KELLER);
    steine[20] = new Steinflaeche(new Level(10, 5), Etage.KELLER);
    steine[21] = new Steinflaeche(new Level(10, 4), Etage.KELLERD);
    
  }
  
  @Override
  public void step()
  {
    for (Objekt wand : waende)
      wand.step();
    for (Objekt stein : steine)
      stein.step();
  }
  
  @Override
  public void collision()
  {
    for (Objekt wand : waende)
      wand.collision();
    for (Objekt stein : steine)
      stein.collision();
  }
  
  @Override
  public void draw()
  {
    for (Objekt wand : waende)
      wand.draw();
    for (Objekt stein : steine)
      stein.draw();
  }
  
  @Override
  public void drawGUI()
  {
    for (Objekt wand : waende)
      wand.drawGUI();
    for (Objekt stein : steine)
      stein.drawGUI();
  }
}

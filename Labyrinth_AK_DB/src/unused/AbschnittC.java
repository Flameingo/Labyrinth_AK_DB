package unused;

import basics.Level;
import main.Objekt;
import models3D.RundeTreppe;

import path.*;


public class AbschnittC extends Objekt
{
  protected Objekt [] waende = new Objekt[103];
  protected Objekt [] steine = new Objekt[24];
 
  
  public AbschnittC()
  {
    waende[0] = new LabEck_ru(new Level(9,2),Etage.KELLER, true, 2);
    waende[1] = new LabEck_lo(new Level(10,2),Etage.KELLER, true, 2 );
    waende[2] = new LabWeg_o_u(Etage.KELLER, new Level(10,1));
    waende[3] = new LabWeg_o_u(Etage.KELLER, new Level(10,0));
    waende[4] = new LabWeg_o_u(Etage.KELLER, new Level(10,-1));
    waende[5] = new LabWeg_o_u(Etage.KELLER, new Level(10,-2));
    waende[6] = new LabWeg_o_u(new Level(10,-2));
    waende[7] = new LabWeg_U(new Level(10,-1));
    waende[8] = new LabWeg_r_l(new Level(11,-1));
    waende[9] = new LabWeg_R(new Level(12,-1));
    waende[10] = new LabEck_lu(new Level(12,-2), true);
    waende[11] = new LabEck_lo(new Level(12,0), true);
    waende[12] = new LabEck_ro(new Level(11,0));
    waende[13] = new LabEck_ru(new Level(11,-2));
    waende[14] = new LabWeg_r_l(new Level(9,-1));
    waende[15] = new LabWeg_U(new Level(8,-1));
    waende[16] = new LabEck_ru(new Level(7,-1));
    waende[17] = new LabEck_ro(new Level(7,0),true);
    waende[18] = new LabWeg_U(new Level(8,0));
    waende[19] = new LabWeg_U(new Level(9,0));
    waende[20] = new LabWeg_U(new Level (10,0));
    waende[21] = new LabEck_lu(new Level(8,-2));
    waende[22] = new LabEck_ro(new Level(7,-2));
    waende[23] = new LabEck_ru(new Level(7,-3));
    waende[24] = new LabEck_lo(new Level(8,-3));
    waende[25] = new LabWeg_R(new Level(8,-4));
    waende[26] = new LabWeg_O(new Level(7,-4));
    waende[27] = new LabWeg_O(new Level(8,-5));
    waende[28] = new LabEck_ru(new Level(7,-5));
    waende[29] = new LabWeg_O(new Level(9,-5));
    waende[30] = new LabWeg_O(new Level(10,-5));
    waende[31] = new LabWeg_O(new Level(11,-5));
    waende[32] = new LabEck_lu(new Level(12,-5));
    waende[33] = new LabWeg_R(new Level(12,-4));
    waende[34] = new LabWeg_R(new Level(12,-3));
    waende[35] = new LabWeg_O(new Level(6,-4));
    waende[36] = new LabEck_ru(new Level(5,-4),true);
    waende[37] = new LabWeg_o_u(new Level(5,-3));
    waende[38] = new LabWeg_o_u(new Level(5,-2));
    waende[39] = new LabEck_lo(new Level(5,-1),true);
    waende[40] = new LabWeg_r_l(new Level(4,-1));
    waende[41] = new LabWeg_r_l(new Level(3,-1));
    waende[42] = new LabEck_ro(new Level(2,-1),true);
    waende[43] = new LabWeg_o_u(new Level(2,-2));
    waende[44] = new LabEck_lu(new Level(2,-3));
    waende[45] = new LabEck_ru(new Level(1,-3));
    waende[46] = new LabWeg_o_u(new Level(1,-2));
    waende[47] = new LabEck_lo(new Level(1,-1),true);
    waende[48] = new LabWeg_r_l(new Level(0,-1));
    waende[49] = new LabWeg_r_l(new Level(-1,-1));
    waende[50] = new LabEck_ro(new Level(-2,-1),true);
    waende[51] = new LabWeg_L(new Level(-2,-2));
    waende[52] = new LabEck_ru(new Level(-2,-3),true);
    waende[53] = new Sackgasse(new Level(-1,-3),"l");
    waende[54] = new LabWeg_O(new Level(4,-5));
    waende[55] = new LabWeg_O(new Level(0,-4));
    waende[56] = new LabWeg_O(new Level(-1,-4));
    waende[57] = new LabEck_ro(new Level(-2,-4));
    waende[58] = new LabEck_ru(new Level(-2,-5));
    waende[59] = new LabWeg_O(new Level(-1,-5));
    waende[60] = new LabEck_lu(new Level(0,-5));
    waende[61] = new LabWeg_O(new Level(1,-4));
    waende[62] = new LabWeg_O(new Level(2,-4));
    waende[63] = new LabWeg_r_l(new Level(3,-4));
    waende[64] = new LabWeg_R(new Level(3,-3));
    waende[65] = new LabWeg_O(new Level(5,-5));
    waende[66] = new LabWeg_O(new Level(6,-5));
    waende[67] = new LabWeg_O(new Level(3,-5));
    waende[68] = new LabWeg_O(new Level(2,-5));
    waende[69] = new LabWeg_O(new Level(1,-6));
    waende[70] = new LabWeg_O(new Level(2,-6));
    waende[71] = new LabWeg_O(new Level(3,-6));
    waende[72] = new LabWeg_O(new Level(4,-6));
    waende[73] = new LabWeg_R(new Level(5,-6));
    waende[74] = new Sackgasse(new Level(5,-7),"u");
    waende[75] = new LabWeg_O(new Level(0,-6));
    waende[76] = new LabWeg_O(new Level(-1,-6));
    waende[77] = new LabWeg_O(new Level(-2,-6));
    waende[78] = new LabWeg_L(new Level(-3,-6));
    waende[79] = new LabEck_ro(new Level(-3,-4));
    waende[80] = new LabWeg_L(new Level(-3,-3));
    waende[81] = new LabWeg_L(new Level(-3,-2));
    waende[82] = new LabWeg_L(new Level(-3,-1));
    waende[83] = new LabEck_ro(new Level(-3,0),true);
    waende[84] = new LabWeg_U(new Level(-2,0));
    waende[85] = new LabWeg_U(new Level(-1,0));
    waende[86] = new LabWeg_U(new Level(0,0));
    waende[87] = new LabWeg_U(new Level(1,0));
    waende[88] = new LabWeg_U(new Level(2,0));
    waende[89] = new LabWeg_U(new Level(3,0));
    waende[90] = new LabWeg_U(new Level(4,0));
    waende[91] = new LabWeg_U(new Level(5,0));
    waende[92] = new LabWeg_U(new Level(6,0));
    
    waende[97] = new LabWeg_L(new Level(-3,-5));
    waende[98] = new LabWeg_o_u(new Level(-3,-7));
    waende[99] = new LabEck_ru(new Level(-3,-8));
    waende[100] = new LabWeg_r_l(new Level(-2,-8));
    waende[101] = new LabWeg_r_l(new Level(-1,-8));
    waende[102] = new Sackgasse(new Level(0,-8),"l");
    
    //Untergrund Uebergang
    
    waende[93] = new LabEck_ru(new Level(10,-4),true);
    waende[94] = new LabEck_lu(new Level(11,-4),true);
    waende[95] = new LabEck_lo(new Level(11,-3));
    waende[96] = new LabWeg_L(new Level(10,-3));
   
    
        
        
        
    //Ecksteine und Steinboden
    steine[0] = new Eckstein(new Level(10,-1));
    steine[1] = new Eckstein(new Level(11,-1));
    steine[2] = new Eckstein(new Level(9,-1));
    steine[3] = new Eckstein(new Level(3,-1));
    steine[4] = new Eckstein(new Level(1,-1));
    steine[5] = new Eckstein(new Level(5,-6));
    steine[6] = new Eckstein(new Level(-2,-6));
    steine[7] = new Eckstein(new Level(-2,-7));
    
    steine[8] = new Steinflaeche(new Level(9,2),Etage.KELLER);
    steine[9] = new Steinflaeche(new Level(10,2),Etage.KELLER);
    steine[10] = new Steinflaeche(new Level(10,1),Etage.KELLER);
    steine[11] = new Steinflaeche(new Level (10,0),Etage.KELLER);
    steine[12] = new Steinflaeche(new Level (10,-1),Etage.KELLER);
    steine[13] = new Steinflaeche(new Level (10, -2),Etage.KELLER);
    steine[14] = new Steinflaeche(new Level (10, -3),Etage.KELLER);
    steine[15] = new Steinflaeche(new Level (10, -4), Etage.KELLER);
    steine[16] = new Steinflaeche(new Level (11, -4),Etage.KELLER);
    steine[17] = new Steinflaeche(new Level (11, -3), Etage.KELLER);
    
    steine[18] = new Steinflaeche(new Level (9,2),Etage.KELLERD);
    steine[19] = new Steinflaeche(new Level (10,2),Etage.KELLERD);
    steine[20] = new Steinflaeche(new Level (10,1),Etage.KELLERD);
    steine[21] = new Steinflaeche(new Level (10,0),Etage.KELLERD);
    steine[22] = new Steinflaeche(new Level (10,-1),Etage.KELLERD);
    steine[23] = new Steinflaeche(new Level (10,-2),Etage.KELLERD);
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
  
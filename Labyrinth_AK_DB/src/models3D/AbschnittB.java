package models3D;

import basics.Level;
import main.Objekt;
import params.Material;
import path.*;


public class AbschnittB extends Objekt
{
  protected Objekt [] waende = new Objekt[29];
  protected Objekt [] steine = new Objekt[10];
 
  public int n = 0;
  
  public AbschnittB()
  {
	  waende[0] = new LabWeg_r_l(new Level(1,1));
	  waende[1] = new Sackgasse(new Level(1,2),"r");
	  waende[2] = new LabWeg_o_u(new Level (2,3));
	  waende[3] = new LabWeg_o_u(new Level(2,4));
	  waende[4] = new LabWeg_r_l(new Level(6,1));
	  waende[5] = new LabWeg_O(new Level(2,1));
	  waende[6] = new LabWeg_r_l(new Level(3,1));
	  waende[7] = new LabWeg_r_l(new Level(4,1));
	  waende[8] = new LabWeg_O(new Level(5,1));
	  waende[9] = new LabWeg_o_u(new Level(5,2));
	  waende[10] = new LabEck_lo(new Level(5,3),true);
	  waende[11] = new LabWeg_r_l(new Level(4,3));
	  waende[12] = new LabWeg_O(new Level(3,3));
	  waende[13] = new LabWeg_U(new Level(3,4));
	  waende[14] = new LabWeg_U(new Level(4,4));
	  waende[15] = new LabWeg_U(new Level(5,4));
	  waende[16] = new LabEck_ro(new Level(2,5),true);
	  waende[17] = new LabWeg_U(new Level(3,5));
	  waende[18] = new LabWeg_U(new Level(4,5));
	  waende[19] = new LabEck_lo(new Level(5,5),false);
	  waende[20] = new LabWeg_O(new Level(6,6));
	  waende[21] = new LabWeg_O(new Level(7,6));
	  waende[22] = new LabWeg_O(new Level(8,6));
	  
	  waende[23] = new LabWeg_L(new Level(9,5));
	  waende[24] = new LabWeg_L(new Level(9,4));
	  waende[25] = new LabWeg_L(new Level(9,3));
	  waende[26] = new LabWeg_L(new Level(9,2));
	  waende[27] = new LabWeg_r_l(new Level(7,1));
	  waende[28] = new LabWeg_r_l(new Level(8,1));
	  
	  
	//Ecksteine werden in der linken oberen Ecke des Feldes platziert
	  
	  steine[0] = new Eckstein(new Level(2,1));
	  steine[1] = new Eckstein(new Level(2,2));
	  steine[2] = new Eckstein(new Level(2,3));
	  steine[3] = new Eckstein(new Level(3,5));
	  steine[4] = new Eckstein(new Level(6,2));
	  steine[5] = new Eckstein(new Level(6,6));
	  steine[6] = new Eckstein(new Level(9,6));
	  steine[7] = new Eckstein(new Level(9,2));
	  steine[8] = new Eckstein(new Level(6,5));
	  steine[9] = new Eckstein(new Level(6,4));
  }
 
  @Override
  public void step()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void collision()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void draw()
  {
    
    for (Objekt wand : waende)
    {
      wand.draw();
    }
 
    for (Objekt stein : steine)
    {
      stein.draw();
    }
  }

  @Override
  public void drawGUI()
  {
    // TODO Auto-generated method stub
    
  }
}
//waende[13] = new LabWeg_l(-4.5f,-5.5f,-3,-4,2,false);
//waende[12] = new LabWeg_r(-3,3,0f,4.2f,2,false); //Ordnung durch Angabe von zuerst allen waagrechten Waenden 
//waende[3] = new LabWeg_r(-1.5f,1.5f,6,3,2,false);// (angenommmen y waere die Hoehe)
//waende[4] = new LabWeg_l(-1.5f,-5.5f,6,-4,2,false); //von links nach rechts
//
//waende[18] = new PrototypWand(1.8f,4.1f,0,0,0,0,20);
//
//waende[0] = new LabWeg_r_l(0,0,6,1.5f,2, false);
//waende[5] = new LabWeg_r(0,-5.5f,4.5f,-4,2,false);
//waende[9] = new LabWeg_l(1.5f,-1.5f,4.5f,0,2,false);
//
//waende[14] = new LabWeg_l(-4.5f,-5.5f,-3,-1,2,true);
//waende[11] = new LabWeg_r(-4.5f,-4,-3,7.5f,2,true); //Anschliessend die senkrechten Waende.
//waende[2] = new LabWeg_l(-1.6f,1.5f,0,3,2,true);
//waende[1] = new LabWeg_r_l(-1.5f,-4,0,0,2, true);
//
//waende[6] = new LabWeg_l(-1.5f,-5.5f,0,-4,2,true);
//
//waende[7] = new LabWeg_r("BWR",4.5f,-5.5f,6,0,2,true);
//waende[8] = new LabWeg_l(4.5f,-4,6,-1.5f,2,true);
//
//waende[10] = new LabWeg_r(4.5f,1.5f,6,3,2,true);
//waende[15] = new Wand("egal",3f,4.62f,boden,270,0,0,90,2);
//waende[16] = new Wand("e",3f,4.62f,boden,0,0,0,90,2);
//waende[17] = new Wand("",3f,4.62f,boden,90,0,0,90,2);
//
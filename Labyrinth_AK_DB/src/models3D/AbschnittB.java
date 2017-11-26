package models3D;

import main.Objekt;
import params.Material;

import path.LabWeg_r_l;

public class AbschnittB extends Objekt
{
  protected Objekt [] waende = new Objekt[19];
  
  public AbschnittB()
  {
//    waende[13] = new LabWeg_l(-4.5f,-5.5f,-3,-4,2,false);
//    waende[12] = new LabWeg_r(-3,3,0f,4.2f,2,false); //Ordnung durch Angabe von zuerst allen waagrechten Waenden 
//    waende[3] = new LabWeg_r(-1.5f,1.5f,6,3,2,false);// (angenommmen y waere die Hoehe)
//    waende[4] = new LabWeg_l(-1.5f,-5.5f,6,-4,2,false); //von links nach rechts
//    
//    waende[18] = new PrototypWand(1.8f,4.1f,0,0,0,0,20);
//    
//    waende[0] = new LabWeg_r_l(0,0,6,1.5f,2, false);
//    waende[5] = new LabWeg_r(0,-5.5f,4.5f,-4,2,false);
//    waende[9] = new LabWeg_l(1.5f,-1.5f,4.5f,0,2,false);
//    
//    waende[14] = new LabWeg_l(-4.5f,-5.5f,-3,-1,2,true);
//    waende[11] = new LabWeg_r(-4.5f,-4,-3,7.5f,2,true); //Anschliessend die senkrechten Waende.
//    waende[2] = new LabWeg_l(-1.6f,1.5f,0,3,2,true);
//    waende[1] = new LabWeg_r_l(-1.5f,-4,0,0,2, true);
//   
//    waende[6] = new LabWeg_l(-1.5f,-5.5f,0,-4,2,true);
//    
//    waende[7] = new LabWeg_r("BWR",4.5f,-5.5f,6,0,2,true);
//    waende[8] = new LabWeg_l(4.5f,-4,6,-1.5f,2,true);
//   
//    waende[10] = new LabWeg_r(4.5f,1.5f,6,3,2,true);
//    waende[15] = new Wand("egal",3f,4.62f,boden,270,0,0,90,2);
//    waende[16] = new Wand("e",3f,4.62f,boden,0,0,0,90,2);
//    waende[17] = new Wand("",3f,4.62f,boden,90,0,0,90,2);
//    
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
    Material.BACKSTEIN.use();
    for (Objekt wand : waende)
    {
      wand.draw();
    }
  }

  @Override
  public void drawGUI()
  {
    // TODO Auto-generated method stub
    
  }
}

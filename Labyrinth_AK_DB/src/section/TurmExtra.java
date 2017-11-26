package section;

import main.Labyrinth;
import main.Objekt;
import models3D.Flaeche;
import models3D.Wand;
import models3D.WandHalbeH;
import models3D.Zinne;
import params.Material;


public class TurmExtra
  extends Objekt
{
  public Objekt[] items = new Objekt[18]; //Waende und Waende halber Hoehe enthalten
  public Objekt[] zinnen = new Objekt[6];
  


  public TurmExtra()
  {
    Labyrinth.addObject(new Turm("T", 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
    


    for (int hoch = 0; hoch < 2; hoch++)
    {
      for (int hinten = 0; hinten < 2; hinten++)
      {
        for (int links = 0; links < 3; links++)
        {
          items[(6 * hoch + hinten * 3 + links)] = new Wand(links * (-wandFeld / 2.0F), 3.4F * hinten, 1.5F * hoch, 0.0F, 0.0F, 0.0F);
        }
      }
    }
    

    for (int hinten = 0; hinten < 2; hinten++)
    {
      for (int links = 0; links < 3; links++)
      {
        zinnen[(3 * hinten + links)] = new Zinne(-wandFeld / 2.0F * links, hinten * 3.4F, 3.72F, 0.0F, 0.0F, 0.0F);
      }
    }
    
    for (int i = 0; i < 2; i++)
    {
      for (int j = 0; j < 3; j++)
      {
        items[(12 + 3 * i + j)] = new WandHalbeH(-wandFeld / 2.0F * j, i * 3.4F, 3.0F, 0.0F, 0.0F, 0.0F);
      }
    }
    Labyrinth.addObject(new Flaeche());
  }
  





  public void step() {}
  




  public void collision() {}
  




  public void draw()
  {
    Material.BACKSTEIN.use();
    for (Objekt item : items)
    {
      item.draw();
    }
    
    for (Objekt zin : zinnen)
    {
      zin.draw();
    }
    
  }
  
  public void drawGUI() {}
}
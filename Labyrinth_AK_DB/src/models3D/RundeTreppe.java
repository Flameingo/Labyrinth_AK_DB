package models3D;

import basics.Point;
import params.*;

public class RundeTreppe  extends Treppe 
{
  /**
   * String "S" als ersten Parameter, um eine Saeule (Objekt: Zylinder) in Mitte der Treppe einzubauen
   * @param x
   * @param y
   * @param z
   * @param alpha
   * @param beta
   * @param gamma
   * @param bogen
   * @param treppenlaenge
   */
  public RundeTreppe(float x, float y, float z, float alpha, float beta, float gamma,float bogen, int treppenlaenge)
  {
    super(x, y, z, alpha, beta, gamma);
    
    this.bogen = bogen;
    
    this.treppenlaenge = treppenlaenge;
    
    for (int stufe = 0; stufe < this.treppenlaenge; stufe++)
    {
      for(int lang = 0; lang<4; lang++)
        {
        for(int breit = 0; breit<10; breit++)
          {
          for(int hoch = 0; hoch <5; hoch++)
          {
          myShape.addParam(new Quader("Mitte",0.1f,0.15f,0.0397f), //Parametrisierung der Stufen - Angabe der Groesse der Steine
                  new Point(
                      (0.6f+breit*0.105f)*(float)Math.cos(Math.PI*stufe*bogen/3600)+0.153f*lang*(float)-Math.sin(Math.PI*stufe*bogen/3600), // x - Lenght
                      (0.6f+breit*0.105f)*(float)Math.sin(Math.PI*stufe*bogen/3600)+0.153f*lang*(float)Math.cos(Math.PI*stufe*bogen/3600),  // y - Width
                      stufe*0.2f+0.04f*hoch                                                                                                 // z - Height
                      ),
                  new float[]{stufe*18,0,0}); //Rotation der Objekte um die Mitte der Treppe
            }
          }
        }
      }
   
  }
  
  /**
   * 
   * @param S Hat nur einen Effekt, wenn der String "S" enspricht.
   * @param x
   * @param y
   * @param z
   * @param alpha Drehung um die z-Achse
   * @param beta Drehung um die y-Achse
   * @param gamma Drehung um die z-Achse
   * 
   * 
   * 
   * 
   * 
   * 
   * 
   * @param bogen Drehung in Gradmaß je 20 Treppenstufen (treppenlaenge)  
   *        beispielsweise entspricht bogen 360 und treppenlaenge 40 hier 2 vollständigen Umdrehungen um die Treppenmitte
   *        
   * @param treppenlaenge Eine Stufe ist um 0.2f hoeher als die Vorherige
   */
  public RundeTreppe(String S,float x, float y, float z, float alpha, float beta, float gamma, float bogen, int treppenlaenge)
    {                                                                                                    
                                                                                                                  // Das "S" steht für Saeule
    this(x,y,z,alpha,beta, gamma, bogen, treppenlaenge);
    
    if ( S == "S")                                                                                               //if-Abfrage eventuell in einen Switch-Case umbauen.   
      
      myShape.addParam(new Zylinder(0.545f,0.545f,5.9f), new Point(0,0,-0.05f)); //Erschafft eine Säule in der Mitte
      
    
  
  
  
  }  

  
}
  


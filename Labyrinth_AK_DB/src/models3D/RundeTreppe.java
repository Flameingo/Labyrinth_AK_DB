package models3D;

import basics.Point;
import main.Labyrinth;
import params.*;

import static org.lwjgl.opengl.GL11.*;

public class RundeTreppe extends Treppe
{
  /**
   * speichert die oberen Punkte der Treppenstufen, um Kollisionsabfragen zu ermoeglichen.
   */
  Point[][] hitbox = {};
  
  /**
   * String "S" als ersten Parameter, um eine Saeule (Objekt: Zylinder) in Mitte der Treppe einzubauen
   * 
   * @param x
   * @param y
   * @param z
   * @param alpha
   *          Drehung um die z-Achse
   * @param beta
   *          Drehung um die y-Achse
   * @param gamma
   *          Drehung um die z-Achse
   * 
   * @param bogen
   *          Drehung in Gradma� je 20 Treppenstufen (treppenlaenge) beispielsweise entspricht bogen 360 und
   *          treppenlaenge 40 hier 2 vollst�ndigen Umdrehungen um die Treppenmitte
   * 
   * @param treppenlaenge
   *          Eine Stufe ist um 0.2f hoeher als die Vorherige
   */
  public RundeTreppe(float x, float y, float z, float alpha, float beta, float gamma, float bogen, int treppenlaenge)
  {
    super(x, y, z, alpha, beta, gamma);
    
    this.bogen = bogen;
    
    this.treppenlaenge = treppenlaenge;
    
    hitbox = new Point[treppenlaenge][3];
    
    for (int stufe = 0; stufe < this.treppenlaenge; stufe++)
    {
      for (int lang = 0; lang < 4; lang++)
      {
        for (int breit = 0; breit < 10; breit++)
        {
          for (int hoch = 0; hoch < 5; hoch++)
          {
            myShape.addParam(new Quader("Mitte", 0.1f, 0.15f, 0.0397f), // Parametrisierung
                                                                        // der
                                                                        // Stufen
                                                                        // -
                                                                        // Angabe
                                                                        // der
                                                                        // Groesse
                                                                        // der
                                                                        // Steine
                new Point(xcalc(stufe, lang, breit, bogen), // x
                                                            // -
                                                            // Length
                    ycalc(stufe, lang, breit, bogen), // y
                                                      // -
                                                      // Width
                    stufe * 0.2f + 0.04f * hoch // z - Height
                ), new float[] { stufe * 18, 0, 0 }); // Rotation der Objekte um
                                                      // die Mitte der Treppe
          }
        }
      }
      
      float h = stufe * 0.2f + 0.04f * 5.5f;
      hitbox[stufe][0] = new Point(xcalc(stufe, -.5f, -.5f, bogen) + x, ycalc(stufe, -.5f, -.5f, bogen) + y, h + z)
          .rotateZ(alpha, new Point(x, y));
      hitbox[stufe][1] = new Point(xcalc(stufe, -.5f, 10.5f, bogen) + x, ycalc(stufe, -.5f, 10.5f, bogen) + y, h + z)
          .rotateZ(alpha, new Point(x, y));
      hitbox[stufe][2] = new Point(xcalc(stufe, 4.5f, -.5f, bogen) + x, ycalc(stufe, 4.5f, -.5f, bogen) + y, h + z)
          .rotateZ(alpha, new Point(x, y));
    }
  }
  
  float xcalc(float stufe, float lang, float breit, float bogen)
  {
    return (0.6f + breit * 0.105f) * (float) Math.cos(Math.PI * stufe * bogen / 3600)
        + 0.153f * lang * (float) -Math.sin(Math.PI * stufe * bogen / 3600);
  }
  
  float ycalc(float stufe, float lang, float breit, float bogen)
  {
    return (0.6f + breit * 0.105f) * (float) Math.sin(Math.PI * stufe * bogen / 3600)
        + 0.153f * lang * (float) Math.cos(Math.PI * stufe * bogen / 3600);
  }
  
  /**
   * 
   * @param S
   *          Hat nur einen Effekt, wenn der String "S" enspricht.
   * @param x
   * @param y
   * @param z
   * @param alpha
   *          Drehung um die z-Achse
   * @param beta
   *          Drehung um die y-Achse
   * @param gamma
   *          Drehung um die z-Achse
   * 
   * @param bogen
   *          Drehung in Gradma� je 20 Treppenstufen (treppenlaenge) beispielsweise entspricht bogen 360 und
   *          treppenlaenge 40 hier 2 vollst�ndigen Umdrehungen um die Treppenmitte
   * 
   * @param treppenlaenge
   *          Eine Stufe ist um 0.2f hoeher als die Vorherige
   */
  public RundeTreppe(String S, float x, float y, float z, float alpha, float beta, float gamma, float bogen,
      int treppenlaenge)
  {
    // Das "S" steht f�r Saeule
    this(x, y, z, alpha, beta, gamma, bogen, treppenlaenge);
    
    if (S == "S") // if-Abfrage eventuell in einen Switch-Case umbauen.
      
      myShape.addParam(new Zylinder(0.545f, 0.545f, 5.9f), new Point(0, 0, -0.05f)); // Erschafft
                                                                                     // eine
                                                                                     // S�ule
                                                                                     // in
                                                                                     // der
                                                                                     // Mitte
    
  }
  
  @Override
  public void collision()
  {
    for (Point[] stufe : hitbox)
    {
      int res = 10;
      for (int i = 0; i < res; i++)
        for (int j = 0; j < res; j++)
        {
          Point p = lip(stufe, (float) i / res, (float) j / res);
          while (Labyrinth.player.hitbox(p))
            Labyrinth.player.pos.z += .1f;
        }
    }
  }
  
  Point lip(Point[] p, float ratio1, float ratio2)
  {
    Point erg = new Point(p[0].x, p[0].y, p[0].z);
    float dist1_x = p[1].x - p[0].x;
    float dist1_y = p[1].y - p[0].y;
    float dist2_x = p[2].x - p[0].x;
    float dist2_y = p[2].y - p[0].y;
    erg.add(dist1_x * ratio1, dist1_y * ratio1, 0);
    erg.add(dist2_x * ratio2, dist2_y * ratio2, 0);
    return erg;
  }
}

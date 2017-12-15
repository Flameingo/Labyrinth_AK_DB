package params;

import basics.Point;

public class Quader extends Param 
{
  
  Param[] seiten    = { null, null, null, null, null, null };
  Point[] oberseite = {};
  
  /**
   * Konstruktor eines Quaders ohne Materialspezifikation
   * 
   * @param kind
   *          String "Mitte" erstellt das Objekt so, dass der Ursprung
   *          Mittelpunkt des Objektes ist. String "Ecke" erstellt das Objekt
   *          so, dass der Ursprung in der ersten Ecke liegt.
   * 
   * @param length
   *          Laenge des Quaders
   * 
   * @param width
   *          Breite des Quaders
   * 
   * @param height
   *          Hoehe des Quaders
   */
  public Quader(String kind, float length, float width, float height)
  {
    super();
    Point p1 = new Point(0, 0, 0);
    switch (kind)
    {
    case "Ecke":
      break;
    default:
      p1.x = -length / 2;
      p1.y = -width / 2;
      p1.z = -height / 2;
    }
    // seiten erstellen
    Point p2, p3, p4, p5, p6, p7, p8;
    p2 = Point.add(p1, length, 0, 0);
    p3 = Point.add(p1, 0, width, 0);
    p4 = Point.add(p1, length, width, 0);
    p5 = Point.add(p1, 0, 0, height);
    p6 = Point.add(p2, 0, 0, height);
    p7 = Point.add(p3, 0, 0, height);
    p8 = Point.add(p4, 0, 0, height);
    
    seiten[0] = new Viereck(p1, p3, p2, p4); //Setzt das Objekt aus 6 Vierecken zusammen, dabei muss darauf geachtet werden, dass die Vorderseite stets aussen liegt.
    seiten[1] = new Viereck(p1, p2, p5, p6);
    seiten[2] = new Viereck(p1, p5, p3, p7);
    seiten[3] = new Viereck(p2, p4, p6, p8);
    seiten[4] = new Viereck(p3, p7, p4, p8);
    seiten[5] = new Viereck(p5, p6, p7, p8);
    
    oberseite = new Point[] { p5, p6, p7, p8 };
  }
  
  /**
   * Konstruktor eines Quaders mit Materialspezifikation
   * 
   * @param kind
   *          String "Mitte" erstellt das Objekt so, dass der Ursprung
   *          Mittelpunkt des Objektes ist. String "Ecke" erstellt das Objekt
   *          so, dass der Ursprung in der ersten Ecke liegt.
   * 
   * @param length
   *          Laenge des Quaders
   * 
   * @param width
   *          Breite des Quaders
   * 
   * @param height
   *          Hoehe des Quaders
   * @param mat
   *          Material des Quaders
   */
  public Quader(String kind, float length, float width, float height, Material mat) //Konstruktor mit Material fuer Farbwahl.
  {
    this(kind, length, width, height);
    setMaterial(mat);
  }
  
  protected void drawParametrisierung() //Draw-Funktion, zeichnet alle 6 Seiten.
  {
    for (int i = 0; i < seiten.length; i++) //Laeuft von 0 bis 5.
    {
      seiten[i].draw();
    }
  }
  
  public Point[] oberseite()
  {
    return oberseite;
  }
  
  // @formatter:off
  // this is unused
  protected float x(float u, float v){return 0;}protected float y(float u, float v){return 0;}protected float z(float u, float v){return 0;}void setResolution(){}
  // formatter:on
}

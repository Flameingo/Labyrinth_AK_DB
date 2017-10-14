package basics;

/** Speichert Koordinatentripel in den Werten "x","y","z" und berechnet daraus verschiedene Hilfsmittel */
public class Point
{
  public float x;
  public float y;
  public float z;
  /**
   * Ein dreidimensionaler Vektor
   * 
   * @param x x - Koordinate
   * 
   * @param y y - Koordinate
   * 
   * @param z z - Koordinate
   */
  public Point(float x, float y, float z)
  {
    this.x = x;
    this.y = y;
    this.z = z;
  }
  
  /**
   * andere Art, die Koordinaten abzufragen, zB fuer Schleifen
   * <p>
   * punkt.get(0) fuer Abfrage von x-Koordinate
   * <p>
   * punkt.get(1) fuer Abfrage von y-Koordinate
   * <p>
   * punkt.get(2) fuer Abfrage von z-Koordinate
   * <p>
   */
  public float get(int i) throws IndexOutOfBoundsException
  {
    switch (i)
    {
    case 0:
      return x;
    case 1:
      return y;
    case 2:
      return z;
    }
    throw new IndexOutOfBoundsException();
  }
  
  /** Berechnet die Länge des Ortsvektors */
  public float length()
  {
    return (float) Math.sqrt(x * x + y * y + z * z);
  }
  
  /**
   * Berechnet die Länge einer Projektion auf eine der 3 Standard-Ebenen:
   * <p>
   * zB: punkt.length("xy") berechnet die Länge des 2D-Vektors ( punkt.x , punkt y ) durch folgende Formel:
   * <p>
   * ( x*x + y*y ) ^ (1/2)
   * 
   * @param chosen
   *          A String consisting of two of the letters x,y,z in any order.
   */
  public float length(String chosen)
  {
    float quads = 0;
    // angegebene Quadrate addieren
    if (chosen.contains("x"))
    {
      quads += x * x;
    }
    if (chosen.contains("y"))
    {
      quads += y * y;
    }
    if (chosen.contains("z"))
    {
      quads += z * z;
    }
    // Wurzel ziehen
    return (float) Math.sqrt(quads);
  }
  
  /** Normiert sich selbst, indem durch die Länge geteilt wird */
  public void normalize()
  {
    mult(1 / length());
  }
  
  /** addiert die Punkte "a" und "b" */
  public static Point add(Point a, Point b)
  {
    return new Point(a.x + b.x, a.y + b.y, a.z + b.z);
  }
  
  /** addiert den Punkt "a" und das gegebene Koordinatentripel */
  public static Point add(Point a, float x, float y, float z)
  {
    return new Point(a.x + x, a.y + y, a.z + z);
  }
  
  /** addiert den Punkt "a" zu sich selbst */
  public void add(Point a)
  {
    this.x += a.x;
    this.y += a.y;
    this.z += a.z;
  }
  
  /** multipliziert Punkt "a" mit dem wert "mult" */
  public static Point mult(Point a, float mult)
  {
    return new Point(mult * a.x, mult * a.y, mult * a.z);
  }
  
  /** multipliziert sich selbst mit dem wert "mult" */
  public void mult(float mult)
  {
    x *= mult;
    y *= mult;
    z *= mult;
  }
  
  /** negiert den Punkt "a" koordinatenweise */
  public static Point neg(Point a)
  {
    return mult(a, -1);
  }
  
  /** addiert das gegebene Koordinatentripel zu sich selbst */
  public void add(float x, float y, int z)
  {
    this.x += x;
    this.y += y;
    this.z += z;
  }
  
  @Override
  public String toString()
  {
    return String.format("[x= %+.2f , y= %+.2f , z= %+.2f ]", x, y, z);
  }
  
}

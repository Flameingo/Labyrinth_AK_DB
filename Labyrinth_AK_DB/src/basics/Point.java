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
   * @param x
   *          x - Koordinate
   * 
   * @param y
   *          y - Koordinate
   * 
   * @param z
   *          z - Koordinate
   */
  public Point(float x, float y, float z)
  {
    this.x = x;
    this.y = y;
    this.z = z;
  }
  
  public Point(Point a)
  {
    x = a.x;
    y = a.y;
    z = a.z;
  }
  
  /**
   * Ein zweidimensionaler Vektor
   * 
   * @param x
   *          x - Koordinate
   * 
   * @param y
   *          y - Koordinate
   */
  public Point(float x, float y)
  {
    this(x, y, 0);
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
  public Point normalize()
  {
    mult(1 / length());
    return this;
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
  public Point add(Point a)
  {
    this.x += a.x;
    this.y += a.y;
    this.z += a.z;
    return this;
  }
  
  /** multipliziert Punkt "a" mit dem wert "mult" */
  public static Point mult(Point a, float mult)
  {
    return new Point(mult * a.x, mult * a.y, mult * a.z);
  }
  
  /** multipliziert sich selbst mit dem wert "mult" */
  public Point mult(float mult)
  {
    x *= mult;
    y *= mult;
    z *= mult;
    return this;
  }
  
  /** negiert den Punkt "a" koordinatenweise */
  public static Point neg(Point a)
  {
    return mult(a, -1);
  }
  
  /** addiert das gegebene Koordinatentripel zu sich selbst */
  public Point add(float x, float y, float z)
  {
    this.x += x;
    this.y += y;
    this.z += z;
    return this;
  }
  
  /**
   * rotates the Point araound the Z-Axis at the given Origin
   * 
   * @param angle
   *          Winkel in Grad
   * @param origin
   *          Rotationszentrum
   * @return selbst
   */
  public Point rotateZ(float angle, Point origin)
  {
    add(Point.mult(origin, -1));
    rotateZ(angle);
    add(origin);
    return this;
  }
  
  /**
   * rotates the Point around the z-Axis
   * 
   * @param angle
   *          Winkel in Grad
   * @return selbst
   */
  public Point rotateZ(float angle)
  {
    float len = length("xy");
    int xsign = (int) Math.signum(x);
    float arc = (float) Math.atan(y / Math.abs(x));
    arc += angle * (float) Math.PI / 180;
    x = (float) Math.cos(arc) * len * xsign;
    y = (float) Math.sin(arc) * len;
    return this;
  }
  
  /** Berechnet den Normalenvektor einer Ebene durch 3 Punkte */
  public static Point normalVector(Point p1, Point p2, Point p3)
  {
    // make hardcopys
    p1 = new Point(p1);
    p2 = new Point(p2);
    p3 = new Point(p3);
    // turn into vectors
    p1.mult(-1);
    p2.add(p1);
    p3.add(p1);
    // crossproduct
    Point erg = kreuz(p2, p3);
    // norm
    erg.normalize();
    return erg;
  }
  
  public static Point kreuz(Point p1, Point p2)
  {
    Point erg = new Point(0, 0, 0);
    erg.x = p1.y * p2.z - p1.z * p2.y;
    erg.y = p1.z * p2.x - p1.x * p2.z;
    erg.z = p1.x * p2.y - p1.y * p2.x;
    return erg;
  }
  
  public static Point lip(Point[] p, float ratio1, float ratio2)
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
  
  @Override
  public String toString()
  {
    return String.format("[x= %+.2f , y= %+.2f , z= %+.2f ]", x, y, z);
  }
  
}

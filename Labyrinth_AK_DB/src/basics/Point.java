package basics;

public class Point
{
  // Speichert Koordinatentripel in den Werten "x","y","z" und berechnet daraus verschiedene Hilfsmittel
  public float x;
  public float y;
  public float z;
  
  public Point(float x, float y, float z)
  {
    this.x = x;
    this.y = y;
    this.z = z;
  }
  
  public float get(int i) throws IndexOutOfBoundsException
  {
    // andere Art, die Koordinaten abzufragen, zB fuer Schleifen
    // punkt.get(0) fuer Abfrage von x-Koordinate
    // punkt.get(1) fuer Abfrage von y-Koordinate
    // punkt.get(2) fuer Abfrage von z-Koordinate
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
  
  public float length()
  {
    // Berechnet die Länge des Ortsvektors
    return (float) Math.sqrt(x * x + y * y + z * z);
  }
  
  public float length(String chosen)
  {
    // Berechnet die Länge einer Projektion auf eine der 3 Standard-Ebenen:
    // zB: punkt.length("xy") berechnet die Länge des 2D-Vektors ( punkt.x , punkt y )
    // durch folgende Formel: ( x*x + y*y ) ^ (1/2)
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
  
  public void normalize()
  {
    // Normiert sich selbst, indem durch die Länge geteilt wird
    mult(1 / length());
  }
  
  public static Point add(Point a, Point b)
  {
    // addiert die Punkte "a" und "b"
    return new Point(a.x + b.x, a.y + b.y, a.z + b.z);
  }
  
  public static Point add(Point a, float x, float y, float z)
  {
    // addiert den Punkt "a" und das gegebene Koordinatentripel
    return new Point(a.x + x, a.y + y, a.z + z);
  }
  
  public void add(Point a)
  {
    // addiert den Punkt "a" zu sich selbst
    this.x += a.x;
    this.y += a.y;
    this.z += a.z;
  }
  
  public static Point mult(Point a, float mult)
  {
    // multipliziert Punkt "a" mit dem wert "mult"
    return new Point(mult * a.x, mult * a.y, mult * a.z);
  }
  
  public void mult(float mult)
  {
    // multipliziert sich selbst mit dem wert "mult"
    x *= mult;
    y *= mult;
    z *= mult;
  }
  
  public static Point neg(Point a)
  {
    // negiert den Punkt "a" koordinatenweise
    return mult(a, -1);
  }
}

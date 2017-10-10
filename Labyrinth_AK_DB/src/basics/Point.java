package basics;

public class Point
{
  private float[] koords;
  public float    x;
  public float    y;
  public float    z;
  
  public Point(float x, float y, float z)
  {
    koords = new float[] { x, y, z };
    refresh();
  }
  
  public float get(int i)
  {
    return koords[i];
  }
  
  private void refresh()
  {
    // aktualisiert die Werte x,y,z aus dem Array koords
    x = koords[0];
    y = koords[1];
    z = koords[2];
  }
  
  public static Point add(Point a, Point b)
  {
    return new Point(a.x + b.x, a.y + b.y, a.z + b.z);
  }
  
  public static Point add(Point a, float x, float y, float z)
  {
    return new Point(a.x + x, a.y + y, a.z + z);
  }
  
  public void add(Point a)
  {
    koords[0] += a.x;
    koords[1] += a.y;
    koords[2] += a.z;
    refresh();
  }
  
  public static Point neg(Point a)
  {
    return new Point(-a.x, -a.y, -a.z);
  }
}

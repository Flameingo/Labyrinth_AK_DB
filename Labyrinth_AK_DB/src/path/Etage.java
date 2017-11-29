package path;

public enum Etage
{
  NORMAL(0), HOCH(1), KELLER(-1),KELLERD(-0.03f);
  
  private float e;
  
  Etage(float e)
  {
    this.e = e;
  }
  
  public float wert()
  {
    return e;
  }
}
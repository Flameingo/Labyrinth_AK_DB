package path;

public enum Etage
{
  NORMAL(0), //Auf dem Boden positioniert.
  HOCH(1),  //Direkt darueber mit Abstand 2 zum Boden (z = 0).
  KELLER(-1), // Ebenso, nur unterhalb anstatt oberhalb des Bodens.
  KELLERD(-0.03f); //Knapp unterhalb der Position NORMAL. Fuer die Decke von unterirdischen Bereichen gemacht.
  
  private float e; //Der eingetragene Wert
  
  Etage(float e)
  {
    this.e = e;
  }
  
  public float wert() //Zugriff auf den Wert, der einer Etage zugeordnet ist.
  {
    return e;
  }
}
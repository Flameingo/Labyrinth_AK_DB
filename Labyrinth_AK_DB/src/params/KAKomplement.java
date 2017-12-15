package params;

public class KAKomplement extends Param //Ist das Komplement aus einem Viereck von einem Kreis(abschnitt).
{
  
  float q; //q bestimmt den Gradwert, fuer den der Kreis definiert wird, dessen Komplement wir hier benutzen.
  
  public KAKomplement(float xscl, float yscl, float q) //xscl = yscl fuer einen Kreis, andere Faelle fuer eine Ellipse, zu dieser Form wird das Komplement genommen.
  {
    super(xscl, yscl, 1, 0, (float) Math.PI * q / 180, 0, 1);
    this.q = q;
  }
  
  public KAKomplement(float xscl, float yscl, float q, Material mat)
  {
    this(xscl, yscl, q);
    setMaterial(mat);
  }
  
  @Override
  public float x(float u, float v)                   //Diese Zwei Funktionen zeichnen in einem quadratischen Bereich alles ausser den bestimmten Kreisabschnitt.
  {
    float alpha = (float) Math.cos(u);
    float beta = 1;
    return alpha + v * (beta - alpha);
  }
  
  @Override
  public float y(float u, float v)
  {
    float alpha =  (float) Math.sin(u);
    float beta = 1;
    return alpha + v * (beta - alpha);
  }
  
  @Override
  public float z(float u, float v)
  {
    float alpha = 0;
    float beta = 0;
    return alpha + v * (beta - alpha);
  }
  
  @Override
  void setResolution()
  {
    mfact = (float) (Math.PI * (xscl + yscl));
    minM = 3;
    nfact = (xscl + yscl) / 2;
  }
  
}
package params;

import basics.Point;

public class Vieleck extends Param
{
  private Param[] dreiecke = {};
  
  public Vieleck(Point[] punkte)
  {
    if (punkte.length < 3) return;
    dreiecke = new Param[punkte.length - 2];
    for (int i = 1; i < punkte.length - 1; i++)
      dreiecke[punkte.length - 1] = new Dreieck(punkte[0], punkte[i], punkte[i + 1]);
  }
  
  public Vieleck(Point[] punkte, Material mat)
  {
    this(punkte);
    setMaterial(mat);
  }
  
  @Override
  protected void drawParametrisierung()
  {
    for (Param p : dreiecke)
    {
      p.draw();
    }
  }
  
  @Override
  void setResolution()
  {
    // TODO Auto-generated method stub
    
  }
  
  @Override
  protected float x(float u, float v)
  {
    // TODO Auto-generated method stub
    return 0;
  }
  
  @Override
  protected float y(float u, float v)
  {
    // TODO Auto-generated method stub
    return 0;
  }
  
  @Override
  protected float z(float u, float v)
  {
    // TODO Auto-generated method stub
    return 0;
  }
  
}

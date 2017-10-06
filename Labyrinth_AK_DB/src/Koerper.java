
abstract class Koerper
{
  protected Param[] params = {};
  
  public void draw()
  {
    for (int i = 0; i < params.length; i++)
      params[i].draw();
  }
}

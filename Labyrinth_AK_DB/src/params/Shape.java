package params;

import static org.lwjgl.opengl.GL11.*;
import basics.*;

/** contains an array of Params to simplify draw functions in objects */
public class Shape
{
  
  Param[]   params = {};
  Point[]   pos    = {};
  float[][] rotate = {};
  
  /**
   * Adds a Param to the array. Includes a position and Rotation
   * 
   * @param param
   *          The Param to be added
   * @param pos
   *          Position to place the Param at.
   * @param rotate
   *          Rotation the Param is Placed in: Rotated in this Plane: { X-Y , X-Z , Y-Z } specified in degree
   */
  public void addParam(Param param, Point pos, float[] rotate)
  {
    Param[] newParams = new Param[params.length + 1];
    for (int i = 0; i < params.length; i++)
      newParams[i] = params[i];
    newParams[params.length] = param;
    params = newParams;
    Point[] newpos = new Point[this.pos.length + 1];
    for (int i = 0; i < this.pos.length; i++)
      newpos[i] = this.pos[i];
    newpos[this.pos.length] = pos;
    this.pos = newpos;
    float[][] newrotate = new float[this.rotate.length + 1][];
    for (int i = 0; i < this.rotate.length; i++)
      newrotate[i] = this.rotate[i];
    newrotate[this.rotate.length] = rotate;
    this.rotate = newrotate;
  }
  
  /**
   * Adds a Param to the array. Includes a position. Rotation is 0.
   * 
   * @param param
   *          The Param to be added
   * @param pos
   *          Position to place the Param at.
   */
  public void addParam(Param param, Point pos)
  {
    addParam(param, pos, new float[] { 0, 0, 0 });
  }
  
  /**
   * Adds a Param to the array. Includes a Rotation. Position is 0.
   * 
   * @param param
   *          The Param to be added
   * @param rotation
   *          Rotation the Param is Placed in: Rotated in this Plane: { X-Y , X-Z , Y-Z } specified in degree
   */
  public void addParam(Param param, float[] rotation)
  {
    addParam(param, new Point(0, 0, 0), rotation);
  }
  
  /**
   * Adds a Param to the array. Position and Rotation are 0.
   * 
   * @param param
   *          The Param to be added
   */
  public void addParam(Param param)
  {
    addParam(param, new Point(0, 0, 0));
  }
  
  /** draws all included Params at their pos and Rotation */
  public void draw()
  {
    for (int i = 0; i < params.length; i++)
    {
      glPushMatrix();
      {
        glTranslatef(pos[i].x, pos[i].y, pos[i].z);
        glRotatef(rotate[i][2], 1, 0, 0);
        glRotatef(rotate[i][1], 0, 1, 0);
        glRotatef(rotate[i][0], 0, 0, 1);
        params[i].draw();
      }
      glPopMatrix();
    }
  }
}

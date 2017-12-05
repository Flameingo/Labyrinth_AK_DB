package params;

import static org.lwjgl.opengl.GL11.*;
import basics.*;

/** contains an array of Params to simplify draw functions in objects */
public class Shape
{
  // Koordinaten des Ursprungs und Drehung des kompletten Shapes.
  Point     origin       = new Point(0, 0, 0);
  float[]   rotateAll    = { 0, 0, 0 };
  Material  materialAll  = null;
  
  // Koordinaten der Parametrisierungen relativ zum Ursprung und Rotationen der
  // Parametrisierungen innerhalb des Shapes
  Param[]   params       = {};
  Point[]   pos          = {};
  float[][] rotateParams = {};
  
  /**
   * Adds a Param to the array. Includes a position and Rotation
   * 
   * @param param
   *          The Param to be added
   * @param pos
   *          Position to place the Param at.
   * @param rotate
   *          Rotation the Param is Placed in: Rotated in this Plane: { X-Y ,
   *          X-Z , Y-Z } specified in degree
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
    float[][] newrotate = new float[this.rotateParams.length + 1][];
    for (int i = 0; i < rotateParams.length; i++)
      newrotate[i] = rotateParams[i];
    newrotate[rotateParams.length] = rotate;
    rotateParams = newrotate;
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
   *          Rotation the Param is Placed in: Rotated in this Plane: { X-Y ,
   *          X-Z , Y-Z } specified in degree
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
  
  /**
   * searches a Param in the Shape and returns the int value for the field
   * "params".
   * 
   * @param param
   *          the Param to be searched for
   * @return int value to get the Param out of the field "params"
   */
  private int findParam(Param param)
  {
    for (int i = 0; i < params.length; i++)
    {
      if (params[i] == param) return i;
    }
    throw new IndexOutOfBoundsException(); // TODO make new exeption
  }
  
  /**
   * Verschiebt eine angegebene Param zu einem Punkt, relativ zum Ursprung.
   * 
   * @param param
   *          Die Param, die verschoben werden soll
   * @param newpos
   *          der neue Ort, relativ zum Ursprung der Shape
   */
  public void translateParam(Param param, Point newpos)
  {
    int i = findParam(param);
    pos[i] = newpos;
  }
  
  /**
   * set rotation of a specified param with the given arcs.
   * 
   * @param param
   *          the param that will be rotated
   * @param rotate
   *          Rotation the Param is set to: Rotated in this Plane: { X-Y , X-Z ,
   *          Y-Z } specified in degree
   */
  public void rotateParam(Param param, float[] rotate)
  {
    int i = findParam(param);
    for (int j = 0; j < rotateParams[i].length; j++)
      rotateParams[i][j] = rotate[j];
  }
  
  /**
   * Translates the whole Shape
   * 
   * @param newOrigin
   *          new Place, where the Shape is translated to.
   */
  public void translate(Point newOrigin)
  {
    origin = newOrigin;
  }
  
  /**
   * set rotation of the whole Shape with the given arcs.
   * 
   * @param newRotate
   *          Rotation the Shape is set to: Rotated in this Plane: { X-Y , X-Z ,
   *          Y-Z } specified in degree
   */
  public void rotate(float[] newRotate)
  {
    rotateAll = newRotate;
  }
  
  /** draws all included Params at their pos and Rotation */
  public void draw()
  {
    // Set Material to be used if specified
    if (materialAll != null) materialAll.use();
    // Place the whole Shape according to "origin" and "RotateAll"
    glPushMatrix();
    {
      glTranslatef(origin.x, origin.y, origin.z);
      glRotatef(rotateAll[2], 1, 0, 0);
      glRotatef(rotateAll[1], 0, 1, 0);
      glRotatef(rotateAll[0], 0, 0, 1);
      for (int i = 0; i < params.length; i++)
      {
        // Place each individual Param at their pos and rotate values.
        glPushMatrix();
        {
          glTranslatef(pos[i].x, pos[i].y, pos[i].z);
          glRotatef(rotateParams[i][2], 1, 0, 0);
          glRotatef(rotateParams[i][1], 0, 1, 0);
          glRotatef(rotateParams[i][0], 0, 0, 1);
          params[i].draw();
        }
        glPopMatrix();
      }
    }
    glPopMatrix();
  }
}

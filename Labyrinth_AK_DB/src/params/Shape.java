package params;

import static org.lwjgl.opengl.GL11.*;
import basics.*;

public class Shape
{
  // contains an array of Params to simplify draw functions in objects
  
  Param[]   params = {};
  Point[]   pos    = {};
  float[][] rotate = {};
  
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
  
  public void addParam(Param param, Point pos)
  {
    addParam(param, pos, new float[] { 0, 0, 0 });
  }
  
  public void addParam(Param param)
  {
    addParam(param, new Point(0, 0, 0));
  }
  
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

package params;

import static org.lwjgl.opengl.GL11.*;

public class Shape
{
  // contains an array of Params to simplify draw functions in objects
  
  Param[]   params = {};
  float[][] pos    = {};
  float[][] rotate = {};
  
  public void addParam(Param param, float[] pos, float[] rotate)
  {
    Param[] newParams = new Param[params.length + 1];
    for (int i = 0; i < params.length; i++)
      newParams[i] = params[i];
    newParams[params.length] = param;
    params = newParams;
    float[][] newpos = new float[this.pos.length + 1][];
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
  
  public void draw()
  {
    for (int i = 0; i < params.length; i++)
    {
      glPushMatrix();
      {
        glTranslatef(pos[i][0], pos[i][1], pos[i][2]);
        glRotatef(rotate[i][2], 1, 0, 0);
        glRotatef(rotate[i][1], 0, 1, 0);
        glRotatef(rotate[i][0], 0, 0, 1);
        params[i].draw();
      }
      glPopMatrix();
    }
  }
}

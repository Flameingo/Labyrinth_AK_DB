package basics;

import static org.lwjgl.opengl.GL11.*;

public class GUI_Text
{
  static float[] col  = { 1, 1, 1 };
  static int     size = 100;
  
  private static class Letter
  {
    Point[] points;
    int[][] paths;
    
    public Letter(Point[] points, int[][] paths)
    {
      this.points = points;
      this.paths = paths;
    }
    
    public void draw()
    {
      glColor3fv(GUI_Text.col);
      for (int i = paths.length - 1; i >= 0; i--)
      {
        glBegin(GL_TRIANGLE_STRIP);
        for (int j = 0; j < paths[i].length; j++)
          glVertex3f(points[paths[i][j]-1].x * GUI_Text.size, points[paths[i][j]-1].y * GUI_Text.size, 0);
        glEnd();
      }
    }
  }
  
  private static final Point[] A_POINTS = { new Point(0, 0), new Point(.3f, 1), new Point(.7f, 1), new Point(1, 0),
      new Point(.8f, 0), new Point(.7f, .25f), new Point(.3f, .25f), new Point(.2f, 0), new Point(.35f, .45f),
      new Point(.45f, .8f), new Point(.55f, .8f), new Point(.65f, .45f) };
  private static final int[][] A_PATHS  = { { 1, 8, 2, 7, 2, 9, 2, 10, 3, 11, 4, 12, 4, 6, 4, 5 }, { 9, 7, 12, 6 } };
  private static final Letter  A        = new Letter(A_POINTS, A_PATHS);
  
  public static void draw_test()
  {
    glTranslatef(10, 10, 0);
    A.draw();
  }
}

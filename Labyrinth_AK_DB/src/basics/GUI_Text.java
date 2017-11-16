package basics;

import static org.lwjgl.opengl.GL11.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import main.Settings;

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
    
    private static enum States
    {
      SEARCH_START, BUILD_POINTS, BUILD_PATHS, END;
      
      public States next()
      {
        switch (this)
        {
        case SEARCH_START:
          return BUILD_POINTS;
        case BUILD_POINTS:
          return BUILD_PATHS;
        default:
          return END;
        }
      }
    }
    
    public Letter(char c)
    {
      Path file_path = Paths.get("src/basics/Schrift_POLY_PARTY.txt");
      List<String> lines;
      try
      {
        lines = Files.readAllLines(file_path);
      } catch (IOException e)
      {
        e.printStackTrace();
        return;
      }
      ArrayList<Point> points_list = new ArrayList<Point>();
      Object temp = null;
      ArrayList<int[]> paths_list = new ArrayList<int[]>();
      int[] path;
      ArrayList<Integer> path_list = new ArrayList<Integer>();
      States state = States.SEARCH_START;
      for (String string : lines)
      {
        switch (state)
        {
        case SEARCH_START:
          if (string.equals("l" + c)) state = state.next();
          break;
        case BUILD_POINTS:
          if (string.isEmpty())
            state = state.next();
          else if (temp == null)
            temp = string;
          else
          {
            Point newpoint = new Point(Float.parseFloat(temp.toString()), Float.parseFloat(string));
            points_list.add(newpoint);
            temp = null;
          }
          break;
        case BUILD_PATHS:
          if (!string.isEmpty())
          {
            if (string.equals("end"))
              state = state.next();
            else path_list.add(Integer.parseInt(string));
          } else
          {
            path = new int[path_list.size()];
            for (int i = 0; i < path.length; i++)
              path[i] = path_list.get(i);
            paths_list.add(path);
            path_list = new ArrayList<Integer>();
          }
          break;
        default:
          break;
        }
      }
      points = new Point[points_list.size()];
      for (int i = 0; i < points.length; i++)
        points[i] = points_list.get(i);
      paths = new int[paths_list.size()][];
      for (int i = 0; i < paths.length; i++)
        paths[i] = paths_list.get(i);
    }
    
    @SuppressWarnings("unused")
    public void draw()
    {
      if (Settings.DRAW_FONT_POINTS > 0)
      {
        glColor3f(1, 0, 0);
        glPointSize(Settings.DRAW_FONT_POINTS);
        glBegin(GL_POINTS);
        for (Point p : points)
          glVertex3f(p.x * GUI_Text.size, p.y * GUI_Text.size, 0);
        glEnd();
      }
      glColor3fv(GUI_Text.col);
      for (int i = paths.length - 1; i >= 0; i--)
      {
        glBegin(GL_TRIANGLE_STRIP);
        for (int j = 0; j < paths[i].length; j++)
          glVertex3f(points[paths[i][j] - 1].x * GUI_Text.size, points[paths[i][j] - 1].y * GUI_Text.size, 0);
        glEnd();
      }
    }
  }
  
  private static Letter[] letters = {};
  private static char[]   chars   = {};
  
  public static void init()
  {
    Path file_path = Paths.get("src/basics/Schrift_POLY_PARTY.txt");
    List<String> lines;
    try
    {
      lines = Files.readAllLines(file_path);
    } catch (IOException e)
    {
      e.printStackTrace();
      return;
    }
    
    ArrayList<Character> chars = new ArrayList<Character>();
    for (String string : lines)
    {
      if (string.isEmpty()) break;
      chars.add(string.charAt(0));
    }
    GUI_Text.chars = new char[chars.size()];
    letters = new Letter[chars.size()];
    for (int i = 0; i < chars.size(); i++)
    {
      char c = chars.get(i);
      GUI_Text.chars[i] = c;
      letters[i] = new Letter(c);
    }
  }
  
  public static void draw_test()
  {
    draw_text("AbBb AbbBbAbA", new Point(10, 10), 100);
  }
  
  public static void draw_text(String string, Point pos, int size)
  {
    GUI_Text.size = size;
    glPushMatrix();
    glTranslatef(pos.x, pos.y, pos.z);
    for (int i = 0; i < string.length(); i++)
    {
      draw_char(string.charAt(i));
      glTranslatef(110, 0, 0);
    }
    glPopMatrix();
  }
  
  private static void draw_char(char c)
  {
    for (int i = 0; i < chars.length; i++)
    {
      if (chars[i] == c)
      {
        letters[i].draw();
        break;
      }
    }
  }
}

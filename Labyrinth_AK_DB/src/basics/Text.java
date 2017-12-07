package basics;

import static org.lwjgl.opengl.GL11.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import main.Funktionen;
import main.Settings;

public class Text
{
  static float[]          col     = { 1, 1, 1 };
  
  private static Letter[] letters = {};
  private static char[]   chars   = {};
  private static String[] strings = {};
  
  private static int      size;
  
  public static void init()
  {
    Path file_path = Paths.get("src/basics/Textdata.txt");
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
    ArrayList<String> strings = new ArrayList<String>();
    for (String string : lines)
    {
      if (string.startsWith("l"))
      {
        String temp = string.substring(1);
        if (temp.length() == 1)
          chars.add(temp.charAt(0));
        else strings.add(temp);
      }
    }
    Text.chars = new char[chars.size()];
    letters = new Letter[chars.size() + strings.size()];
    for (int i = 0; i < chars.size(); i++)
    {
      char c = chars.get(i);
      Text.chars[i] = c;
      letters[i] = new Letter(c + "");
    }
    Text.strings = new String[strings.size()];
    int ioff = chars.size();
    for (int i = 0; i < strings.size(); i++)
    {
      String s = strings.get(i);
      Text.strings[i] = s;
      letters[i + ioff] = new Letter(s);
    }
  }
  
  public static void draw_test()
  {
    // draw_text("A/ABCDEFGHIJKLMN/nO/OPQRSTU/UVWXYZ/na/abcdefghijklmn/no/opqrstu/uvwxyz",
    // new Point(10, 200), 50);
//	  int i = 5;
	  String Ausgabe = "Level:" + Funktionen.getLvlX()+ "I"+ Funktionen.getLvlY();
    draw_text(Ausgabe, new Point(10, 30), 30);
  }
  
  public static void draw_text(String string, Point pos, int size)
  {
    Text.size = size;
    int line = 0;
    glPushMatrix();
    glTranslatef(pos.x, pos.y, pos.z);
    for (int i = 0; i < string.length(); i++)
    {
      float charwidth = -.1f; // to cancel the offset when drawing the newline
                              // character /n, this value is set to negative
                              // that offset
      if (string.charAt(i) != '/')
      {
        // handle standard chars
        charwidth = draw_char(string.charAt(i));
      } else if (string.charAt(i + 1) == 'n')
      {
        // handle newline
        glPopMatrix();
        glPushMatrix();
        line++;
        glTranslatef(pos.x, pos.y - size * line * 1.2f, pos.z);
        i++;
      } else
      {
        // handle special chars
        float[] ret = draw_char_ext(string.charAt(i + 1), string.charAt(i + 2));
        charwidth = ret[0];
        i += ret[1];
      }
      glTranslatef(size * charwidth + .1f * size, 0, 0);
    }
    glPopMatrix();
  }
  
  private static float[] draw_char_ext(char c1, char c2)
  {
    int usedchars = 2;
    String searchstring = "";
    switch ("" + c1 + c2)
    {
    default:
      usedchars = 1;
      switch (c1)
      {
      case 'A':
        searchstring = "Ae";
        break;
      case 'O':
        searchstring = "Oe";
        break;
      case 'U':
        searchstring = "Ue";
        break;
      case 'a':
        searchstring = "ae";
        break;
      case 'o':
        searchstring = "oe";
        break;
      case 'u':
        searchstring = "ue";
        break;
      }
    }
    for (int i = 0; i < strings.length; i++)
      if (strings[i].equals(searchstring))
      {
        letters[i + chars.length].draw();
        return new float[] { letters[i + chars.length].width, usedchars };
      }
    return new float[] { SPACE_WIDTH, 0 };
  }
  
  private static float draw_char(char c)
  {
    for (int i = 0; i < chars.length; i++)
      if (chars[i] == c)
      {
        letters[i].draw();
        return letters[i].width;
      }
    return SPACE_WIDTH;
  }
  
  private static final float SPACE_WIDTH = .5f;
  
  private static class Letter
  {
    public float width       = 0;
    
    int          displaylist = -1;
    
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
    
    public Letter(String s)
    {
      Path file_path = Paths.get("src/basics/Textdata.txt");
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
          if (string.equals("l" + s)) state = state.next();
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
      Point[] points = new Point[points_list.size()];
      for (int i = 0; i < points.length; i++)
        points[i] = points_list.get(i);
      int[][] paths = new int[paths_list.size()][];
      for (int i = 0; i < paths.length; i++)
        paths[i] = paths_list.get(i);
      calc_width(points);
      displaylist = glGenLists(1);
      glNewList(displaylist, GL_COMPILE);
      drawfirst(points, paths);
      glEndList();
    }
    
    private void calc_width(Point[] points)
    {
      for (Point p : points)
        width = Math.max(width, p.x);
    }
    
    @SuppressWarnings("unused")
    public void drawfirst(Point[] points, int[][] paths)
    {
      if (Settings.DRAW_FONT_POINTS > 0)
      {
        glColor3f(1, 0, 0);
        glPointSize(Settings.DRAW_FONT_POINTS);
        glBegin(GL_POINTS);
        for (Point p : points)
          glVertex3f(p.x, p.y, 0);
        glEnd();
      }
      for (int i = 0; i < paths.length; i++)
      {
        glBegin(GL_TRIANGLE_STRIP);
        for (int j = 0; j < paths[i].length; j++)
          glVertex3f(points[paths[i][j]].x, points[paths[i][j]].y, 0);
        glEnd();
      }
    }
    
    public void draw()
    {
      glColor3fv(Text.col);
      glPushMatrix();
      {
        glScalef(size, size, size);
        glCallList(displaylist);
      }
      glPopMatrix();
    }
  }
}

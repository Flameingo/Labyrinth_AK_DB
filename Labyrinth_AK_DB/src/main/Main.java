package main;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;
import org.lwjgl.BufferUtils;

import java.nio.IntBuffer;

public class Main
{
  // time is kept track for calculating the framerate
  double               currenttime = System.nanoTime();
  // The window handle
  private long         window;
  // setting the window size
  private int          WIDTH       = (int) (600f * 16f / 9f), HEIGHT = 600;
  public static double fps;
  
  public void run()
  {
    try
    {
      init();
      
      // get the procedures running
      Labyrinth.beginGame();
      
      loop();
      
      // Reset all callbacks for the specified GLFW window to NULL and free all
      // previously set callbacks.
      glfwFreeCallbacks(window);
      
      // Destroy the specified window and its context.
      glfwDestroyWindow(window);
    } finally
    {
      
      // Destroy all remaining windows, free any allocated resources and set the
      // library to an uninitialized state.
      // Once this is called, you must again call glfwInit successfully before
      // you will be able to use most GLFW
      // functions.
      glfwTerminate();
      
      // Free the error callback
      glfwSetErrorCallback(null).free();
    }
  }
  
  private void init()
  {
    
    // Setup an error callback. The default implementation will print the error
    // message in System.err.
    GLFWErrorCallback.createPrint(System.err).set();
    
    // Initialize GLFW. Most GLFW functions will not work before doing this.
    if (!glfwInit()) throw new IllegalStateException("Unable to initialize GLFW");
    
    // Configure our window
    glfwDefaultWindowHints(); // optional, the current window hints are already
                              // the default
    glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden
                                              // after creation
    glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable
    
    // Create the window
    window = glfwCreateWindow(WIDTH, HEIGHT, "Beispiel 1", NULL, NULL);
    if (window == NULL) throw new RuntimeException("Failed to create the GLFW window");
    
    // Setup a key callback. It will be called every time a key is pressed,
    // repeated or released.
    glfwSetKeyCallback(window, (window, key, scancode, action, mods) ->
    {
      // We will detect this in our rendering loop
      if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE) glfwSetWindowShouldClose(window, true);
      Labyrinth.keyboard(key, action); // weitere Auswertung erfolgt in
                                       // Labyrinth
    });
    
    // Get the resolution of the primary monitor
    GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
    
    // Center our window
    glfwSetWindowPos(window, (vidmode.width() - WIDTH) / 2, (vidmode.height() - HEIGHT) / 2);
    
    // Make the OpenGL context of the specified window current on the calling
    // thread.
    glfwMakeContextCurrent(window);
    
    // Set the swap interval for the current OpenGL, i.e. the number of screen
    // updates to wait from the time
    // glfwSwapBuffers was called before swapping the buffers and returning
    glfwSwapInterval(1);
    
    // Make the window visible
    glfwShowWindow(window);
    
    // Create a new GLCapabilities instance for the OpenGL context that is
    // current in the current thread
    GL.createCapabilities();
  }
  
  private int[] keyCheck()
  {
    /// this function returns an array with all pressed key in the current frame
    int[] key = {};
    for (int i = 32; i <= GLFW_KEY_LAST; i++)
    {
      if (glfwGetKey(window, i) == 1)
      {
        int[] temp = new int[key.length + 1];
        for (int j = 0; j < key.length; j++)
          temp[j] = key[j];
        temp[key.length] = i;
        key = temp;
      }
    }
    return key;
  }
  
  private void loop()
  {
    // This line is critical for LWJGL's interoperation with GLFW's OpenGL
    // context, or any context that is managed
    // externally.
    // LWJGL detects the context that is current in the current thread, creates
    // the GLCapabilities instance and makes
    // the OpenGL bindings available for use.
    
    Labyrinth.initGLState();
    
    // Run the rendering loop until the user has attempted to close the window
    // or has pressed the ESCAPE key.
    while (!glfwWindowShouldClose(window))
    {
      
      // Clear the color buffers and depth buffer
      glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
      
      // Refresh pressed keys for the scene
      Labyrinth.keys = keyCheck();
      
      if (Settings.FPS_ON) framerate();
      
      Labyrinth.renderLoop();
      
      // Swap the color buffers
      glfwSwapBuffers(window);
      
      // Poll for window events. The key callback above will only be invoked
      // during this call.
      glfwPollEvents();
      IntBuffer IntWindowWidth = BufferUtils.createIntBuffer(1);
      IntBuffer IntWindowHeight = BufferUtils.createIntBuffer(1);
      
      glfwGetWindowSize(window, IntWindowWidth, IntWindowHeight);
      if (windowSizeChanged(IntWindowWidth, IntWindowHeight))
      {
        glViewport(0, 0, WIDTH, HEIGHT);
      }
      
      IntWindowWidth.clear();
      IntWindowHeight.clear();
    }
  }
  
  /** Calculates the framerate */
  private void framerate()
  {
    double elapsed = System.nanoTime() - currenttime;
    currenttime = System.nanoTime();
    fps = 1000000000 / elapsed;
  }
  
  private boolean windowSizeChanged(IntBuffer w, IntBuffer h)
  {
    if (WIDTH != w.get(0) || HEIGHT != h.get(0))
    {
      WIDTH = w.get(0);
      HEIGHT = h.get(0);
      return true;
    }
    
    return false;
  }
  
  public static void main(String[] args)
  {
    new Main().run();
  }
}
package main;

public final class Settings
{
  // settings that are changeable are collected here, so they can be found and changed easily.
  
  // dev settings
  public final static boolean FPS_ON                  = false;
  public final static boolean DrawPlayerPOS           = false;
  
  /** controls the resolution of all drawn Objects */
  public final static int     RenderSolution          = 10;
  // Player rotation speeds:
  public final static float   PlayerRotationLeftRight = (float) (Math.PI / 60);
  public final static float   PlayerRotationUpDown    = (float) (Math.PI / 180);
  
  public final static float   PlayerMovementSpeed     = .07f;
  public final static float   PlayerSideStepSpeed     = .05f;
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndLine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndLine  extends Actor
{
    /**
     * Act - do whatever the EndLine wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveDown();
        checkLocation();
    }    
    public void moveDown()
    {
       setLocation(getX(), getY()+4);
    }
    public void checkLocation()
    {
       if (getY()>=(getWorld().getHeight()-1))
       {
          Greenfoot.stop();
          getWorld().addObject(new ScoreBoard(),300,300);
          getWorld().removeObject(this);
       }
    }
}

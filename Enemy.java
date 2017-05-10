import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vehicle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Enemy extends Actor
{
    /**Speed of the vehicle in units of pixels per move*/
    protected int speed;
 private Actor collided;

    public Enemy()
    {
        
    }
    
    /**
     * Getter: gets speed
     * @return integer (Speed)
     */
    public int getSpeed()
    {
        return speed;
    }
    
      
    /**
     * Setter: sets speed
     * @param integer (Speed)
     */
    protected void setSpeed(int newSpeed)
    {
        if(newSpeed>=0)
        {
            this.speed = newSpeed;
        }
        else
        {
            this.speed = 0;
        }
    }
    
    
    /**
     * Act - do whatever the Vehicle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveDown();
        check();
    }
    public void moveDown()
    {
       if(((CarWorld) getWorld()).getPause() == false)
       {
          collided = getOneIntersectingObject(PedestrianCrossing.class);
          if (collided == null)
          {
             setLocation(getX(), getY()+Greenfoot.getRandomNumber(3)+5);
          }
          else
          {
             setLocation(getX(), getY()+Greenfoot.getRandomNumber(4));
          }
       }
    }
    
    
    public void check()
    {
        collided = getOneIntersectingObject(Vehicle.class);
        if (collided != null || getY()>=(getWorld().getHeight()-1))
        {
           getWorld().removeObject(this);
        }
    }
    
}

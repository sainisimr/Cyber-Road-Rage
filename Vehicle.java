import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vehicle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Vehicle extends Actor
{
    /**Speed of the vehicle in units of pixels per move*/
    protected int speed;
    /**Turn angle of the vehicle in units of degrees*/
    protected int turnAngle;
    /**Half of the vehicles width in pixels*/
    protected int vehicleWidth;
    /**Half of the vehicles length in pixels*/
    protected int vehicleLength;
    /**IBehaviour object that specifies its behavior*/
    private Actor collided;
    private Actor collidedVehicle;
    public Vehicle()
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
     * Getter: gets width of vehicle
     * @return integer (width in pixels)
     */
    public int getVehicleWidth()
    {
        return vehicleWidth;
    }
    
    /**
     * Getter: gets length of vehicle
     * @return integer (length in pixels)
     */
    public int getVehicleLength()
    {
        return vehicleLength;
    }
    
    /**
     * Getter: gets turn angle
     * @return integer (turn angle in degrees)
     */
    public int getTurnAngle()
    {
        return turnAngle;
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
     * Setter: sets turn angle
     * @param integer (turn angle in degrees)
     */
    protected void setTurnAngle(int t)
    {
        this.turnAngle = t;
    }
    
        /**
     * Method: Turns the vehicle to the left using turnAngle
     */
    protected void turnLeft()
    {
        turn(getTurnAngle()*-1);
    }
    
    /**
     * Method: Turns the vehicle to the right using turnAngle
     */
    protected void turnRight()
    {
        turn(getTurnAngle());
    }
    
    /**
     * Method: Increases speed of the vehicle
     */
    protected void increaseSpeed()
    {
        setSpeed(getSpeed()+1);
    }
    
    /**
     * Method: Decreases speed of the vehicle until it reaches 0
     * 
     * @exception java.lang.IllegalArgumentException
     * Occurs when system was unable to load file.
     */
    protected void decreaseSpeed()
    {
        setSpeed(getSpeed()-1);
    }
    
    /**
     * Method: moves vehicle forward using current speed but checks if it can move first
     * @param Class<?>, 
     * checks surroundings for this type of objects, if it is on the way move() will not be executed
     */
    /*protected void moveForward(Class<?> classType)
    {
        if(canMove(classType))
        {
            move(getSpeed());
        }else
        {
        }
    }
    */
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
    
    /**
     * Method: Checks if this vehicle can move. If there is an object of type Obstacle in its way, the vehicle cannot move.
     * @param System.Type (class type)
     * @return boolean (True if vehicle is able to move, false otherwise)
     */
   /* protected boolean canMove(Class<?> classType)
    {
        Double x = Math.cos(Math.toRadians(getRotation()))*getVehicleLength();
        Double y = Math.sin(Math.toRadians(getRotation()))*getVehicleLength();
        Object obstacle = getOneObjectAtOffset(x.intValue(),y.intValue(), classType);
        if(obstacle==null)
        {
            return true;
        }else
        {
            return false;
        }
    }*/
}

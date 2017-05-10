import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Car here.
 */ 

public class Car extends ConcreteSubject
{
    private Actor collidedVehicle;
    private Actor collidedPerson;
    private Actor collidedEnemy;
    private Actor collidedBackground;
    private Actor collidedFuel;
    static GreenfootImage carImage = null;
    private int counter = 0;
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   
   
    public void act() 
    {
        checkKeyAndMove();
        createBomb();
        checkCollision();
       
    }
    public Car() {
        if(carImage != null)
            this.setImage(carImage);
        
        
    }
    
    
    public void checkKeyAndMove()
    {
       if(((CarWorld) getWorld()).getPause() == false)
       {
          if(getX()<400)
          {
             if (Greenfoot.isKeyDown("right"))    
             {
                setLocation( getX()+2, getY() );
             }
             if (Greenfoot.isKeyDown("left"))    
             {
                setLocation( getX()-2, getY() );
             }
          }
          else
          {
             if (Greenfoot.isKeyDown("right"))    
             {
                //setLocation( getX()+(1/5), getY() );
                setLocation(412,550);
             }
             if (Greenfoot.isKeyDown("left"))    
             {
                setLocation( getX()-(1/5), getY() );
             }
          }
          if(getX()>215)
          {
             if (Greenfoot.isKeyDown("right"))    
             {
                setLocation( getX()+2, getY() );
             }
             if (Greenfoot.isKeyDown("left"))    
             {
                setLocation( getX()-2, getY() );
             }
          }
          else
          {
             if (Greenfoot.isKeyDown("right"))    
             {
                setLocation( getX()+(1/5), getY() );
             }
             if (Greenfoot.isKeyDown("left"))    
             {
                //setLocation( getX()-(1/5), getY() );
                setLocation(200, 550);
             }
          }
       }
    }
    public void createBomb()
    {
       if(((CarWorld) getWorld()).getPause() == false)
       {
          if(counter == 0)
          {
             if (Greenfoot.isKeyDown("space"))
             {
                 Bomb bomb = new Bomb();
                getWorld().addObject(bomb,getX(),getY());
                bomb.attach((Counter) getWorld().getObjects(Counter.class).get(0));
                counter = 30;
             }
          }
          else
          {
             counter--;
          }
       }
   }
    public void checkCollision()
    {
        collidedVehicle = getOneIntersectingObject(Vehicle.class);
        collidedPerson = getOneIntersectingObject(Person.class);
        collidedEnemy = getOneIntersectingObject(Enemy.class);
        collidedBackground = getOneIntersectingObject(Background.class);
        collidedFuel = getOneIntersectingObject(Fuel.class);
        if (collidedVehicle != null)
        {
           setState("Collided");
           getWorld().removeObject(collidedVehicle);
           //((CarWorld) getWorld()).collided();
           Greenfoot.playSound("Explosion.wav");
        }
        if (collidedPerson != null)
        {
           setState("Collided");
           getWorld().removeObject(collidedPerson);
           //((CarWorld) getWorld()).collided();
           Greenfoot.playSound("Explosion.wav");
        }
        if (collidedEnemy != null)
        {
           setState("Collided");
           getWorld().removeObject(collidedEnemy);
           //((CarWorld) getWorld()).collided();
           Greenfoot.playSound("Explosion.wav");
        }
        if(collidedBackground != null)
        {
     
           getWorld().removeObject(collidedBackground);
           //((CarWorld) getWorld()).collided();
           Greenfoot.playSound("Explosion.wav");
        }  
        if(collidedFuel != null)
        {
            setState("CollidedFuel");

           getWorld().removeObject(collidedFuel);
           //Greenfoot.playSound("Explosion.wav");
        }
    }
    
}

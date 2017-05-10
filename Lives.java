import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.lang.*;

import java.awt.Font;

/**
 * Counter that displays a number.
 * 
 * @version 1.0.1
 */
public class Lives extends ConcreteObserver
{
    public static int valueLives = 3;
    private String state="";
    public Lives(ConcreteSubject car)
    {
        super(car);
        this.subject.attach(this);
        valueLives = 3;
    }
    
  
    @Override
    public void update(ConcreteSubject sub)
    {
       
         if(this.subject.getState() == "Collided" && state==""){
            checkValueLives();
             
           
        } 
    }
    
    public void checkValueLives()
    {
       if(valueLives == 3)
       {
          if(getX() == 150)
          {
              valueLives--;
             getWorld().removeObject(this);
             state="done";
          }
       }
       else if(valueLives == 2)
       {
          if(getX() == 100)
          {
              valueLives--;
             getWorld().removeObject(this);
             state="done";
          }
       }
       else if(valueLives == 1)
       {
          if(getX() == 50)
          {
            /* //Greenfoot.mouseClicked
             //getWorld().addObject(new ScoreBoard(),300,300); */
            
             
             
             valueLives--;
             Greenfoot.stop();
             
             GameOver ob = new GameOver((CarWorld)getWorld());
             Greenfoot.setWorld(ob);
          }
       }
   
    }
}

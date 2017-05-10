import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

import java.awt.Font;

/**
 * Counter that displays a number.
 * 
 * @version 1.0.1
 */
public class Counter extends ConcreteObserver
{
    private static int value = 0;
    private static int target = 0;
    private static String text;
    private static int stringLength;
    private static int score =0;
  
    public Counter(ConcreteSubject sub)
    {
        super(sub);
        
        //super(bomb);
        this.subject.attach(this);
        
        value = 0;
        score = 0;
        text = "Score: ";
        stringLength = (text.length() + 2) * 16;

        setImage(new GreenfootImage(stringLength, 24));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        image.setFont(font.deriveFont(24.0F));  // use larger font
        
        updateImage();
    }
   
    @Override
    public void update(ConcreteSubject sub)
    {
        
        //Car car = (Car) getWorld().getObjects(Car.class).get(0);
      
        
        if(sub.getState() == "CollidedFuel"){
                  
            score += 50;

            if(value > score)
            {
                value = 0;
                updateImage();
            }
            updateImage();
        }
       else if(sub.getState() == "CollidedBomb"){
           
           score += 50;

            if(value > score)
            {
                value = 0;
                updateImage();
            }
            updateImage();
        }
    }
    
  
    public void getTarget()
    {
       //target = ((CarWorld) getWorld()).getScore();
       if(value > score)
       {
          value = 0;
          updateImage();
       }
       updateImage();
    }
    
    public int getScore(){
        return score;
    }
    /*public void add(int score)
    {
        target += score;
    }*/
    /*public int getValue()
    {
        return value;
    }
    /**
     * Make the image
     */
    public void updateImage()
    {
        GreenfootImage image = getImage();
        image.clear();
        image.drawString(text + score, 1, 18);
    }
}

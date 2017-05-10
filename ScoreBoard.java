import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

/**
 * The ScoreBoard is used to display results on the screen. It can display some
 * text and several numbers.
 * 
 * @author M Kolling
 * @version 1.0
 */
public class ScoreBoard extends Actor
{
    public static final float FONT_SIZE = 48.0f;
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    
    /**
     * Create a score board with dummy result for testing.
     */
    public ScoreBoard()
    {
      // this(Counter.target, Lives.valueLives);
    }

    /**
     * Create a score board for the final result.
     */
    public ScoreBoard(String s)
    {
       makeImage(s);
    }

    /**
     * Make the score board image.
     */
    public void makeImage(String s)
    {
       
        
        
           GreenfootImage textImage = new GreenfootImage(s, 30, Color.white, null);
           
          /*GreenfootImage image = new GreenfootImage(textImage.getWidth()+12, 36);
          image.setColor(new Color(196, 196, 0));
          image.fill();
          image.setColor(new Color(0, 0, 196));
          image.fillRect(3, 3, image.getWidth()-6, 30);
          image.drawImage(textImage, 6, 6);*/
          setImage(textImage);
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instructions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instructions extends World
{
	   private HomeButton bb;
       private BackCommand bc;

    /**
     * Constructor for objects of class Instructions.
     * 
     */
    public Instructions()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600,600,1);
        bb = new HomeButton("BACK");
        bc = new BackCommand();
        addObject(bb,getWidth()/2,getHeight()-63);
        
    }
    
    public void act() {
        click();
        
        
    }
    
    
    public void click()
    {   
        ReceiverHome hr = new ReceiverHome();
        addObject(hr,0,0);
        bc.setReceiver(hr);        
        bb.setCommand(bc);
    }
    
    
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class ButtonImage extends Actor
{

   
    GreenfootImage bimage;
    
    public ButtonImage(String s) {
        GreenfootImage image1 = new GreenfootImage(s);
        setImage(image1);
        bimage = image1;
      
    }
    public ButtonImage(GreenfootImage s) {
       
        setImage(s);
        bimage = s;
    }
    
    
    
    public GreenfootImage getImage() {
        return bimage;
        
    }
    
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.io.File;

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb  extends ConcreteSubject
{
    private GreenfootImage image1;
    private GreenfootImage image2;
    ButtonImage obj1, obj2, obj3, obj4;
    private Actor collidedVehicle;
    private Actor collidedPerson;
    private Actor collidedEnemy;
    private Actor collidedBackground;
    ExplosionContainer carExplode, treeExplode, manExplode ;
    public Bomb()
    {
        carExplode = new ExplosionContainer();
        List<GreenfootImage> listOfImages = listOfImagesInDirectory("CarExplode");
        for(GreenfootImage i : listOfImages) {
            Item item = new Item(i);
            carExplode.addItem(item);
        }
        treeExplode = new ExplosionContainer();
         listOfImages = listOfImagesInDirectory("treeExplode");
        for(GreenfootImage i : listOfImages) {
            Item item = new Item(i);
            treeExplode.addItem(item);
        }
        manExplode = new ExplosionContainer();
         listOfImages = listOfImagesInDirectory("manExplode");
        for(GreenfootImage i : listOfImages) {
            Item item = new Item(i);
            manExplode.addItem(item);
        }
        
        
        
       
       
    }
    /**
     * Act - do whatever the Bomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       moveUp();
       check();
    }    
     List<GreenfootImage> listOfImagesInDirectory(String directoryName){
         //System.out.println("./images/" + directoryName);
        File directory = new File((".//images//" + directoryName));
       
        File[] listOfFiles = directory.listFiles();
        List<GreenfootImage> fileNames = new ArrayList();
        for(File f : listOfFiles)
          if (f.isFile() && f.getName().endsWith(".png")) 
             fileNames.add( new GreenfootImage( "./" + directoryName + "/"+ f.getName()));

        return fileNames;
    }
    public void moveUp()
    {
       if(((CarWorld) getWorld()).getPause() == false)
       {
          setLocation(getX(), getY()-4);
       }
    }
    public void check()
    {
       collidedVehicle = getOneIntersectingObject(Vehicle.class);
       collidedPerson = getOneIntersectingObject(Person.class);
       collidedEnemy = getOneIntersectingObject(Enemy.class);
       collidedBackground = getOneIntersectingObject(Background.class);
       
       if(collidedVehicle != null || collidedPerson != null || collidedEnemy != null || collidedBackground != null || getY() == 0)
       {
           //Counter counter = new Counter(this);
          setState("CollidedBomb");
          Greenfoot.playSound("Explosion.wav");
          if(collidedVehicle != null)
          {
              Iterator<Item> iter = carExplode.createIterator();
            // ((CarWorld) getWorld()).addScore(50);
              
             int x = collidedVehicle.getX();
             int y = collidedVehicle.getY();
             getWorld().removeObject(collidedVehicle);
             ButtonImage image1 = new ButtonImage(iter.next().getImage());
             getWorld().addObject(image1,x,y);
             Greenfoot.delay(12);
             getWorld().removeObject(image1);
             ButtonImage image2 = new ButtonImage(iter.next().getImage());
             getWorld().addObject(image2,x,y);
              Greenfoot.delay(8);
             getWorld().removeObject(image2);
             
             
          }
          if(collidedEnemy != null)
          {
              Iterator<Item> iter = carExplode.createIterator();
            // ((CarWorld) getWorld()).addScore(100);
              
             int x = collidedEnemy.getX();
             int y = collidedEnemy.getY();
             getWorld().removeObject(collidedEnemy);
             ButtonImage image1 = new ButtonImage(iter.next().getImage());
             getWorld().addObject(image1,x,y);
             Greenfoot.delay(12);
             getWorld().removeObject(image1);
             ButtonImage image2 = new ButtonImage(iter.next().getImage());
             getWorld().addObject(image2,x,y);
              Greenfoot.delay(8);
             getWorld().removeObject(image2);
          }
          
          if(collidedBackground != null)
          {
              Iterator<Item> iter = treeExplode.createIterator();
              //((CarWorld) getWorld()).addScore(75);
             int x = collidedBackground.getX();
             int y = collidedBackground.getY();
             getWorld().removeObject(collidedBackground);
             ButtonImage image1 = new ButtonImage(iter.next().getImage());
             getWorld().addObject(image1,x,y);
             Greenfoot.delay(12);
             getWorld().removeObject(image1);
             ButtonImage image2 = new ButtonImage(iter.next().getImage());
             getWorld().addObject(image2,x,y);
              Greenfoot.delay(8);
             getWorld().removeObject(image2);
             
          }
          if(collidedPerson != null)
          {
             Iterator<Item> iter = manExplode.createIterator();
             //((CarWorld) getWorld()).addScore(100);
             int x = collidedPerson.getX();
             int y = collidedPerson.getY();
             ButtonImage image1 = new ButtonImage(iter.next().getImage());
             getWorld().removeObject(collidedPerson);
             getWorld().addObject(image1,x,y);
             Greenfoot.delay(12);
             getWorld().removeObject(image1);
             ButtonImage image2 = new ButtonImage(iter.next().getImage());
             getWorld().addObject(image2,x,y);
              Greenfoot.delay(8);
             getWorld().removeObject(image2);
            
          }
          getWorld().removeObject(this);
       }
    }
}

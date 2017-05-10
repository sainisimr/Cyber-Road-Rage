import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.File;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;

/**
 * Write a description of class ChooseCar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChooseCar extends World
{

    /**
     * Constructor for objects of class ChooseCar.
     * 
     */
    List<ButtonImage>  obj ;
    //ButtonImage back;
    private HomeButton bb;
    private BackCommand bc;
    public ChooseCar()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        obj = new ArrayList();
        
        /*back = new ButtonImage("back.png");
        ButtonImage ob1 = new ButtonImage("choosecartext.png");
        addObject(ob1, 300, 50);*/
         bb = new HomeButton("BACK");
        bc = new BackCommand();
        addObject(bb,getWidth()/2,getHeight()-300);
        
        List <GreenfootImage> listOfImages = listOfImagesInDirectory("CarImages");
        ImageContainer menu = new ImageContainer();
        for(GreenfootImage i : listOfImages){
            //i = ".//CarImages//" + i;
            GreenfootImage z = new GreenfootImage(i);
            Item ob = new Item(i);
            menu.addItem(ob);

        }




        Iterator<Item> it = menu.createIterator();
        int space = 0;
        while(it.hasNext()){
            GreenfootImage ss = it.next().getImage();
            ButtonImage temp = new ButtonImage(ss);
            obj.add(temp);
            addObject(temp, 80 + space , 345);
            space += 90;
        }
        


    
       
       
        
        //addObject(back, 70, 30);
        
        
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
    
    
    public void act()
    {
        /*if( Greenfoot.mouseClicked(back))
         {
             WelcomeWorld m = new WelcomeWorld();
              Greenfoot.setWorld(m);
         }*/
        ReceiverHome hr = new ReceiverHome();
        addObject(hr,0,0);
        bc.setReceiver(hr);        
        bb.setCommand(bc);
        for(int i = 0; i < obj.size(); i++)
          if( Greenfoot.mouseClicked(obj.get(i)))
              {
                Car.carImage = obj.get(i).getImage();
                JOptionPane.showMessageDialog(new JInternalFrame(), "Car Selected. Return to main main to start the game ","", JOptionPane.INFORMATION_MESSAGE);
            }
            
        
             
             
             
    }
     
}

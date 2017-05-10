import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Graphics;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
    GreenfootImage image2;
    ButtonImage obj;
    ButtonImage mainMenu;
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver(CarWorld car) 
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
         
         int endTime = (int)System.currentTimeMillis();
         int intialTime = (int) car.getStartTime();
         int duration = (endTime - intialTime)/ 1000;
         /*we will see this after code merge*/
         int score =   car.getScore();
         String s = "Your Score: " + Integer.toString(score);
          s += "   Time Taken: " + Integer.toString(duration) + " sec";
         ScoreBoard board = new ScoreBoard(s);
         
       
         
        addObject(new GameOverBackground(),300,200);
        obj = new ButtonImage("retry.png");
        mainMenu = new ButtonImage("gotomainmenu.png");
        addObject(board, 300,300);
        addObject(mainMenu, 450, 25);
        addObject(obj,150, 25);
        File handle = new File("topScore.txt");
        Scanner input = null;
        try {
          input = new Scanner(handle);
        }
        catch(FileNotFoundException io) {
            System.out.println("Sorry file not found");
        }
            
          
        
        
        
        String line = input.nextLine();
        input.close();  
        String[] topScore = line.split(" ");
        if(Integer.parseInt(topScore[0]) < score)
            { board = new ScoreBoard("Congratulations you got the highest Score"); addObject(board, 300,70);
                try {
                    FileWriter writer = new FileWriter("topScore.txt", false);
                    BufferedWriter bufferedWriter = new BufferedWriter(writer);
 
                    bufferedWriter.write("" + score + "  " + duration);
                    bufferedWriter.close();
                    
                    }
                    catch(IOException e) {
                    }
            }
        //System.out.println(line);
        
        
        
        
        
        
        
        
        
        /*GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
        
        image.setColor(new Color(0, 0, 0, 160));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(255, 255, 255, 100));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(title, 60, 100);
        image.drawString(prefix1 + score, 60, 200);
        image.drawString(prefix2 + lives, 60, 250);
        setImage(image);
        */
    }
    
     public void act()
         {
             if( Greenfoot.mouseClicked(obj) ) {
                 
                 CarWorld car = new CarWorld();
                 Greenfoot.setWorld(car);
                 
            }
            if( Greenfoot.mouseClicked(mainMenu)){
                WelcomeWorld menu = new WelcomeWorld();
                Greenfoot.setWorld(menu);
            }
        }
    
    
   
        
   
}

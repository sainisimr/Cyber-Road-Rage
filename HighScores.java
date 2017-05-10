import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Graphics;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Write a description of class HighScores here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HighScores extends World
{

    private HomeButton bb;
    private BackCommand bc;
    ButtonImage obj1;
    public HighScores()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        obj1 = new ButtonImage("highscoreimage.png");
        addObject(obj1,235,55);
        File handle = new File("topScore.txt");
        Scanner input = null;
        try {
          input = new Scanner(handle);
        }
        catch(FileNotFoundException io) {
            System.out.println("Sorry file not found");
        }
        bb = new HomeButton("BACK");
        bc = new BackCommand();
        addObject(bb,getWidth()/2,getHeight()-63);    
          
        
        
        
        String line = input.nextLine();
        input.close();  
        String[] topScore = line.split(" ");
        String s = "Top Score          Time Taken\n";
        String t = topScore[0] +"         " + topScore[topScore.length-1] ;
        ScoreBoard board = new ScoreBoard(s);
        addObject(board,170,130);
        board = new ScoreBoard(t);
        addObject(board,140,170);
        
        
        
        
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

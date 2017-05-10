/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;
import java.io.File;
import java.util.*;

public class Item {
    GreenfootImage image;
   
    public Item(GreenfootImage filename){
        this.image = filename;


    }
    
    
    GreenfootImage getImage() {
        return image;
        
    }
}


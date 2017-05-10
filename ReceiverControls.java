import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ReceiverControls here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ReceiverControls extends ConcreteReceiver
{
    public void doAction() //This is actual action which should happen on click on Play Button
    {
        Instructions info = new Instructions();
        Greenfoot.setWorld(info);
    } 
}

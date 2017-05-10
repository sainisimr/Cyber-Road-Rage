import greenfoot.*;

/**
 * Write a description of class ambulancefact here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Truck extends Vehicle
{
    /**
     * Act - do whatever the ambulancefact wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public Truck()
    {
        setImage("truck.png");
        speed = 8;
        turnAngle = 5;
        vehicleWidth = 27;
        vehicleLength = 51;
        setRotation(90);
    }
   
}

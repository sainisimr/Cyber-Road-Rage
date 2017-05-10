import greenfoot.*;

/**
 * Write a description of class CarOtherFact here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ObstacleCarFactory extends ObstacleCreator
{
    public Vehicle createCar() 
    {
       return new ObstacleCar();
    }
}

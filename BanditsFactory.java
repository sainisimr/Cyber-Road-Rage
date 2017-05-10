import greenfoot.*;

/**
 * Write a description of class CarOtherFact here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BanditsFactory extends EnemyCreator
{
    public Enemy createEnemy() 
    {
       return new Bandits();
    }
}

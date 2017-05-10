/**
 * Write a description of class Obs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class EnemyCreator  
{
  
   public static Enemy makeEnemy( int verticalLaneOneActor )
	{
	    
	    if(verticalLaneOneActor == 0)
        {
           return new AliensFactory().createEnemy();
        }else if(verticalLaneOneActor == 1)
        {
           return new BanditsFactory().createEnemy();
        }else
        {
           return new TerroristsFactory().createEnemy();
        }
	  
	}
	abstract public Enemy createEnemy();

}

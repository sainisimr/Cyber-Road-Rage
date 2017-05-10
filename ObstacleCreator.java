/**
 * Write a description of class Obs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public abstract class ObstacleCreator  
{

   public static Vehicle makeCar(int verticalLaneOneActor)
	{
	
	      if(verticalLaneOneActor == 0)
        {
           return new TruckFactory().createCar();
        }else if(verticalLaneOneActor == 1)
        {
           return new PoliceFactory().createCar();
        }else
        {
           return new ObstacleCarFactory().createCar();
        }
	     
	     
		//return createCar();
		/*if("truck".equals(type))
			return new TruckFactory().createCar();
		else if("police".equals(type))
			return new PoliceFactory().createCar();
		else
			return new ObstacleCarFactory().createCar();*/
	}
	abstract public Vehicle createCar();

}

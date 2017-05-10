import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.*;
import java.util.Random;

/**
 * Write a description of class CarWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CarWorld extends World
{
    private static Random randomGenerator = new Random();
    private int counter;
    //private int lives;
    //private int score;
    private boolean pause;
    private long startTime = 0;
    ScoreBoard board  ;
    private Counter counterOfScore;
    StateContextClass stateContextClass = new StateContextClass();
    
   
     /**
     * Constructor for objects of class CarWorld.
     * 
     */
    
    
    
    public CarWorld()
    {
        super(600, 600, 1);
        
        setPaintOrder(Information.class, ScoreBoard.class, Dot.class, Path.class, Car.class, Bomb.class, Vehicle.class, Enemy.class, Person.class, PedestrianCrossing.class,EndLine.class, Line.class, Counter.class, Lives.class, Background.class, Fuel.class);
        startTime = System.currentTimeMillis() ;
        pause = true;
        Car car = new Car();
        addObject(car,305,550);
        counterOfScore = new Counter(car);
        
        addObject(counterOfScore,100,550);
        addObject(new Lives(car),50,50);
        addObject(new Lives(car),100,50);
        addObject(new Lives(car),150,50);
        addObject(new Dot(), 25, 395);
        addObject(new Path(), 25, 250);
        addObject(new Line(),300,0);
        addObject(new Line(),300,90);
        addObject(new Line(),300,180);
        addObject(new Line(),300,270);
        addObject(new Line(),300,360);
        addObject(new Line(),300,450);
        addObject(new Line(),300,540);
        addObject(new Background(), Greenfoot.getRandomNumber(150), Greenfoot.getRandomNumber(600));
        addObject(new Background(), Greenfoot.getRandomNumber(150), Greenfoot.getRandomNumber(600));
        addObject(new Background(), Greenfoot.getRandomNumber(150), Greenfoot.getRandomNumber(600));
        addObject(new Background(), Greenfoot.getRandomNumber(150), Greenfoot.getRandomNumber(600));
        addObject(new Background(), Greenfoot.getRandomNumber(150), Greenfoot.getRandomNumber(600));
        addObject(new Background(), Greenfoot.getRandomNumber(150)+450, Greenfoot.getRandomNumber(600));
        addObject(new Background(), Greenfoot.getRandomNumber(150)+450, Greenfoot.getRandomNumber(600));
        addObject(new Background(), Greenfoot.getRandomNumber(150)+450, Greenfoot.getRandomNumber(600));
        addObject(new Background(), Greenfoot.getRandomNumber(150)+450, Greenfoot.getRandomNumber(600));
        addObject(new Background(), Greenfoot.getRandomNumber(150)+450, Greenfoot.getRandomNumber(600));
        //addObject(new Information(),300,300);
    }
    public void act()
    {
       
        click();
       if(stateContextClass.getState() == false)
       {
          chanceToEnemy();
          chanceToVehicle();
          chanceToBackground();
          setCounter();
          chanceToPedestrianCrossing();
          chanceToFuel();
       }
    }
    
      public void click()
    {
       if ( Greenfoot.mouseClicked(null)){
           
            if( stateContextClass.getState() ){
                
            stateContextClass.gameResumed();
               //pauseGame(false);
            }
            
           else
               //pauseGame(true);
               stateContextClass.gamePaused();
            }
    }
    
    
    public void chanceToBackground()
    {
       if(Greenfoot.getRandomNumber(50)<1)
       {
          addObject(new Background(), Greenfoot.getRandomNumber(150), 0);
       }
       if(Greenfoot.getRandomNumber(50)<1)
       {
          addObject(new Background(), Greenfoot.getRandomNumber(150)+450, 0);
       }
    }
    
    public void chanceToEnemy()
    {
        Actor actor = EnemyCreator.makeEnemy(randomGenerator.nextInt(3));

       if(Greenfoot.getRandomNumber(100)<1)
       {
           if (getObjects(Enemy.class).size() < 1) { 
          addObject( actor , Greenfoot.getRandomNumber(185)+215, 0);
        }
       }
    }
    public void chanceToVehicle()
    {
        
       Actor actor = ObstacleCreator.makeCar(randomGenerator.nextInt(3));
       if(Greenfoot.getRandomNumber(100)<1)
       {
           if (getObjects(Vehicle.class).size() < 1) { 
          addObject( actor , Greenfoot.getRandomNumber(185)+215, 0);
        }
       }
     
    }
      
    public void chanceToFuel()
    {
       if(Greenfoot.getRandomNumber(100)<1)
       {
          addObject(new Fuel(), Greenfoot.getRandomNumber(185)+215, 0);
       }
    }
    
    public void setCounter()
    {
       counter++;
       if (counter == 23)
       {
         addObject(new Line(),300,0);
         counter = 0;
       }
    }
    public void chanceToPedestrianCrossing()
    {
       if (Greenfoot.getRandomNumber(1000)<1)
       {
          addObject(new PedestrianCrossing(), 220, 0);
          addObject(new PedestrianCrossing(), 280, 0);
          addObject(new PedestrianCrossing(), 340, 0);
          addObject(new PedestrianCrossing(), 400, 0);
          addObject(new Person(), 180, 0);
       }
    }
    public long getStartTime()
    {
        return startTime;
    }
    public int getScore(){
        return counterOfScore.getScore();
        
    }
    
    /*public int getScore()
    {
       return score;
    }
    public void addScore(int scoreToAdd)
    {
       score += scoreToAdd;
       String s = "Score : " + Integer.toString(score);
       board.makeImage(s);
       addObject(board, 500, 50);
       
    }
    public int getLives()
    {
       return lives;
    }
    public void collided()
    {
       lives--;
    }*/
    public boolean getPause()
    {
       return stateContextClass.getState();
    }
    public void pauseGame(boolean paused)
    {
       pause = paused;
    }
    
   
}

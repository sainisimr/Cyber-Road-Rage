/**
 * Write a description of class StateContextClass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class StateContextClass {
	private StateMachine pauseGame;
	private StateMachine resumeGame;
	private StateMachine currentState;
	//private Boolean pause = true;
	public StateContextClass(){
		pauseGame = new PauseGame(this);
		resumeGame = new ResumeGame(this);
		currentState = pauseGame;
		
	}
	public void gamePaused(){
		//currentState.changeGameState();
		pauseGame.changeGameState();
	}
	public void gameResumed(){
		//currentState.changeGameState();
		resumeGame.changeGameState();
	}
	public void setState(Boolean nextState){
		if(nextState)
			currentState = pauseGame;
		else 
			currentState = resumeGame;
			
	}
	public Boolean getState(){
	if(currentState.equals(pauseGame))
			return true;
		else return false;   
}
}



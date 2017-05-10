/**
 * Write a description of class PauseGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class PauseGame implements StateMachine{
	StateContextClass stateManager;
	public PauseGame(StateContextClass stateContextClass){
		this.stateManager = stateContextClass;
	}
	public void changeGameState(){
		stateManager.setState(true);
	}

}

/**
 * Write a description of class ResumeGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class ResumeGame implements StateMachine{
	StateContextClass stateManager;
	public ResumeGame(StateContextClass stateContextClass){
		this.stateManager = stateContextClass;
	}
	public void changeGameState(){
		stateManager.setState(false);
	}

}
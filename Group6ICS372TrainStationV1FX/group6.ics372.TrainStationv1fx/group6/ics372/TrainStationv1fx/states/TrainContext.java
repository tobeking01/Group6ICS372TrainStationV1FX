package group6.ics372.TrainStationv1fx.states;

import group6.ics372.TrainStationv1fx.display.TrainDisplay;

/**
 * The context is an observer for the clock and stores the context info for
 * states
 *
 */
public class TrainContext {
	private TrainDisplay display;
	private TrainState currentState;
	private static TrainContext instance;

	/**
	 * Make it a singleton
	 */
	private TrainContext() {
		instance = this;
		currentState = TrainLeavingState.getInstance();
	}

	/**
	 * Return the instance
	 * 
	 * @return the object
	 */
	public static TrainContext getInstance() {
		if (instance == null) {
			instance = new TrainContext();
		}
		return instance;
	}

	/**
	 * The display could change. So we have to get its reference.
	 * 
	 * @param display The current display object
	 */
	public void setDisplay(TrainDisplay display) {
		this.display = display;
	}

	/**
	 * Lets door closed state be the starting state adds the object as an observable
	 * for clock
	 */
	public void initialize() {
		instance.changeState(TrainLeavingState.getInstance());
	}

	/**
	 * Called from the states to change the current state
	 * 
	 * @param nextState the next state
	 */
	public void changeState(TrainState nextState) {
		currentState.leave();
		currentState = nextState;
		currentState.enter();
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 * 
	 * @param time time left for cooking
	 */
	public void showTimeLeft(int time) {
		display.showTimeLeft(time);
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 * 
	 */
	public void showTrainLeavingOn() {
		display.showTrainLeavingOn();
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 * 
	 */
	public void showTrainAcceleratingOn() {
		display.showTrainAcceleratingOn();
	}

	/**
	 * indicate that cooking has begun
	 */
	public void showTrainAtFullSpeedOn() {
		display.showTrainAtFullSpeedOn();
	}

	/**
	 * Process train deceleration request (showTrainArriveOn next)
	 */
	public void onStationReachingRequest() {
		currentState.onStationReachingRequest();
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 * 
	 */
	public void showTrainDeceleratingOn() {
		display.showTrainDeceleratingOn();
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 * 
	 */
	public void onStationReachedRequest() {
		currentState.onStationReachedRequest();
	}

	/**
	 * indicate that cooking has begun
	 */
	public void showTrainStoppedOn() {
		display.showTrainStoppedOn();
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 * 
	 */
	public void showTrainDoorOpeningOn() {
		display.showTrainDoorOpeningOn();
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 * 
	 */
	public void showTrainDoorOpenCompleteOn() {
		display.showTrainDoorOpenCompleteOn();
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 * 
	 */
	public void showTrainDoorClosingOn() {
		display.showTrainDoorClosingOn();
	}

	/**
	 * Process trainIdle close request
	 */
	public void onDoorObstructingRequest() {
		currentState.onDoorObstructingRequest();
	}

	public void showTrainDoorReOpeningOn() {
		display.showTrainDoorReOpeningOn();
	}

	public void showTrainDoorReOpenCompleteOn() {
		display.showTrainDoorReOpenCompleteOn();
	}

	public void showTrainDoorReClosingOn() {
		display.showTrainDoorReClosingOn();
	}

	public void showTrainDoorCloseCompleteOn() {
		display.showTrainDoorCloseCompleteOn();

	}

}

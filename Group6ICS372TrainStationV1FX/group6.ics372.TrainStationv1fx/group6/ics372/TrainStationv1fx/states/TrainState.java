package group6.ics372.TrainStationv1fx.states;

/**
 * Super class for all states
 * 
 *
 */
public abstract class TrainState {

	/**
	 * Initializes the state
	 */
	public abstract void enter();

	/**
	 * Performs any necessary clean up while leaving the state
	 */
	public abstract void leave();

	/**
	 * Process Train Station reaching Request
	 */
	public void onStationReachingRequest() {

	}

	/**
	 * Process Station Reached State
	 */
	public void onStationReachedRequest() {

	}

	/**
	 * Process Door Obstruction Request
	 */
	public void onDoorObstructingRequest() {

	}

//	/**
//	 * Process clock tick Generates the timer runs out event
//	 */
//	public void onTimerTick(int timerValue) {
//
//	}

	/**
	 * Process clock ticks Generates the timer runs out event
	 */
	public void onTimerRunsOut() {

	}

	/**
	 * Process clock tick event
	 */
	public void OnTimerTick(int timerValue) {

	}

	/**
	 * Process Train Accelerating State
	 */
	public void onTrainAcceleratingState() {
	}

}

//	/**
//	 * Process Train Leaving State
//	 */
//	public void onTrainDoorCloseCompleteState() {
//
//	}
//
//	/**
//	 * Process Train Leaving State
//	 */
//	public void onTrainLeavingState() {
//
//	}
//

//
//	/**
//	 * Process Train at Full Speed State
//	 */
//	public void onTrainAtFullSpeedState() {
//
//	}
//
//	/**
//	 * Process Train Deceleration State
//	 */
//	public void onTrainDecelerationState() {
//
//	}
//
//	/**
//	 * Process Train Deceleration State
//	 */
//	public void onTrainStoppedState() {
//
//	}
//
//	/**
//	 * Process Train Door Opening State
//	 */
//	public void onTrainDoorOpeningState() {
//
//	}
//
//	/**
//	 * Process Train Door Open Complete State
//	 */
//	public void onTrainDoorOpenCompleteState() {
//
//	}
//
//	/**
//	 * Process Train Door Closing State
//	 */
//	public void onTrainDoorClosingState() {
//
//	}
//
//	/**
//	 * handle Train Door ReOpening State
//	 * 
//	 */
//	public void onTrainDoorReOpeningState() {
//
//	}
//
//	/**
//	 * Process Train Door ReOpen Complete
//	 */
//	public void onTrainDoorReOpenComplete() {
//
//	}

//}

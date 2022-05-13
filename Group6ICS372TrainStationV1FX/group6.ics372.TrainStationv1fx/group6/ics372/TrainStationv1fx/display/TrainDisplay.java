package group6.ics372.TrainStationv1fx.display;

public interface TrainDisplay {
	/**
	 * Displays the cook time remaining
	 * 
	 * @param time remaining time
	 */
	public void showTimeLeft(int time);

	/**
	 * Indicate that the train is at the Train Station decelerating is off
	 */
	public void showTrainLeavingOn();

	/**
	 * Indicate that the train is accelerating is on
	 */
	public void showTrainAcceleratingOn();

	/**
	 * indicate that cooking has begun
	 */
	public void showTrainAtFullSpeedOn();

	/**
	 * Indicate that the train is accelerating is on
	 */
	public void showTrainDeceleratingOn();

	public void showTrainStoppedOn();

	/**
	 * Indicate that the Train is idle and door is now open
	 */
	public void showTrainDoorOpeningOn();

	/**
	 * indicate that the Train is idle and door opening has begun
	 */
	public void showTrainDoorOpenCompleteOn();

	/**
	 * indicate that the Train is idle and door closing has ended
	 */
	public void showTrainDoorClosingOn();

	/**
	 * indicate that cooking has begun
	 */
	public void showTrainDoorReOpeningOn();

	/**
	 * indicate that cooking has begun
	 */
	public void showTrainDoorReOpenCompleteOn();

	/**
	 * indicate that cooking has begun
	 */
	public void showTrainDoorReClosingOn();

	/**
	 * indicate that cooking has begun
	 */
	public void showTrainDoorCloseCompleteOn();
}

package group6.ics372.TrainStationv1fx.states;

import group6.ics372.TrainStationv1fx.timer.Notifiable;
import group6.ics372.TrainStationv1fx.timer.Timer;

public class TrainDoorClosingState extends TrainState implements Notifiable {

	private static TrainDoorClosingState instance;
	private Timer timer;

	/**
	 * Private constructor for the singleton pattern
	 */
	private TrainDoorClosingState() {
	}

	/**
	 * returns the instance
	 * 
	 * @return this object
	 */
	public static TrainDoorClosingState getInstance() {
		if (instance == null) {
			instance = new TrainDoorClosingState();
		}
		return instance;
	}

	/**
	 * handle door open event
	 * 
	 */

	@Override
	public void onTrainDoorClosingState() {
		timer.addTimeValue(5);
		TrainContext.getInstance().showTimeLeft(timer.getTimeValue());
	}

	@Override
	public void onDoorObstructingRequest() {
		TrainContext.getInstance().changeState(TrainDoorReOpeningState.getInstance());
	}

	@Override
	public void OnTimerTick(int timerValue) {
		TrainContext.getInstance().showTimeLeft(timerValue);
	}

	/**
	 * Process the timer runs out event
	 */
	@Override
	public void onTimerRunsOut() {
		TrainContext.getInstance().showTimeLeft(0);
		TrainContext.getInstance().changeState(TrainLeavingState.getInstance());
	}

	@Override
	public void enter() {
		timer = new Timer(this, 5);
		TrainContext.getInstance().showTrainDoorClosingOn();
		TrainContext.getInstance().showTimeLeft(timer.getTimeValue());
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
		TrainContext.getInstance().showTrainLeavingOn();
		TrainContext.getInstance().showTimeLeft(0);
	}

}

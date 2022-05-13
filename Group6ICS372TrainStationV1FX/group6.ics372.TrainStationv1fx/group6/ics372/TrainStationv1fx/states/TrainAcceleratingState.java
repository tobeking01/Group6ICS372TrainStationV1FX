package group6.ics372.TrainStationv1fx.states;

import group6.ics372.TrainStationv1fx.timer.Notifiable;
import group6.ics372.TrainStationv1fx.timer.Timer;

public class TrainAcceleratingState extends TrainState implements Notifiable {
	private static TrainAcceleratingState instance;
	private Timer timer;

	/**
	 * Private for the singleton pattern
	 */
	private TrainAcceleratingState() {
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static TrainAcceleratingState getInstance() {
		if (instance == null) {
			instance = new TrainAcceleratingState();
		}
		return instance;
	}

	@Override
	public void onTrainAcceleratingState() {
		timer.addTimeValue(6);
		TrainContext.getInstance().showTimeLeft(timer.getTimeValue());
	}

	@Override
	public void onStationReachingRequest() {
		TrainContext.getInstance().changeState(TrainDeceleratingState.getInstance());
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
		TrainContext.getInstance().changeState(TrainAtFullSpeedState.getInstance());
	}

	@Override
	public void enter() {
		timer = new Timer(this, 6);
		TrainContext.getInstance().showTrainAcceleratingOn();
		TrainContext.getInstance().showTimeLeft(timer.getTimeValue());

	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
		TrainContext.getInstance().showTrainAtFullSpeedOn();
		TrainContext.getInstance().showTimeLeft(0);
	}

}

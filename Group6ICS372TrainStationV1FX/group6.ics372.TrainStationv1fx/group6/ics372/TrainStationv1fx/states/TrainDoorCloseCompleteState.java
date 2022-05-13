package group6.ics372.TrainStationv1fx.states;

import group6.ics372.TrainStationv1fx.timer.Timer;

public class TrainDoorCloseCompleteState extends TrainState {

	private static TrainDoorCloseCompleteState instance;
	private Timer timer;

	/**
	 * Private constructor for the singleton pattern
	 */
	private TrainDoorCloseCompleteState() {
	}

	/**
	 * returns the instance
	 * 
	 * @return this object
	 */
	public static TrainDoorCloseCompleteState getInstance() {
		if (instance == null) {
			instance = new TrainDoorCloseCompleteState();
		}
		return instance;
	}

	@Override
	public void onStationReachedRequest() {
		timer.addTimeValue(3);
		TrainContext.getInstance().showTimeLeft(timer.getTimeValue());
	}

	/**
	 * Process clock tick event
	 */
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
		TrainContext.getInstance().changeState(TrainAcceleratingState.getInstance());
	}

	@Override
	public void enter() {
		TrainContext.getInstance().showTrainDoorCloseCompleteOn();
	}

	@Override
	public void leave() {
		TrainContext.getInstance().showTrainAcceleratingOn();
	}
}

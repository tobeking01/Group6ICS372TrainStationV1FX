package group6.ics372.TrainStationv1fx.states;

import group6.ics372.TrainStationv1fx.timer.Notifiable;
import group6.ics372.TrainStationv1fx.timer.Timer;

public class TrainLeavingState extends TrainState implements Notifiable {

	private static TrainLeavingState instance;
	private Timer timer;

	/**
	 * Private constructor for the singleton pattern
	 */
	private TrainLeavingState() {
	}

	/**
	 * returns the instance
	 * 
	 * @return this object
	 */
	public static TrainLeavingState getInstance() {
		if (instance == null) {
			instance = new TrainLeavingState();
		}
		return instance;
	}

//	@Override
//	public void onTrainLeavingState() {
//		timer.addTimeValue(3);
//		TrainContext.getInstance().showTimeLeft(timer.getTimeValue());
//	}

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

	/**
	 * initialize the state
	 * 
	 */
	@Override
	public void enter() {
		timer = new Timer(this, 3);
		TrainContext.getInstance().showTrainLeavingOn();
		TrainContext.getInstance().showTimeLeft(timer.getTimeValue());
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
		TrainContext.getInstance().showTrainAcceleratingOn();
		TrainContext.getInstance().showTimeLeft(0);
	}

}

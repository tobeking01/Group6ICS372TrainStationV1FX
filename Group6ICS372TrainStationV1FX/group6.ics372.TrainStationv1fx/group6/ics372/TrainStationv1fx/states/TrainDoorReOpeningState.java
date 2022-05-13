package group6.ics372.TrainStationv1fx.states;

import group6.ics372.TrainStationv1fx.timer.Notifiable;
import group6.ics372.TrainStationv1fx.timer.Timer;

public class TrainDoorReOpeningState extends TrainState implements Notifiable {

	private static TrainDoorReOpeningState instance;
	private Timer timer;

	/**
	 * Private constructor for the singleton pattern
	 */
	private TrainDoorReOpeningState() {
	}

	/**
	 * returns the instance
	 * 
	 * @return this object
	 */
	public static TrainDoorReOpeningState getInstance() {
		if (instance == null) {
			instance = new TrainDoorReOpeningState();
		}
		return instance;
	}

	/**
	 * handle door open event
	 * 
	 */

	@Override
	public void onTrainDoorReOpeningState() {
		timer.addTimeValue(6 * (4 / 5));
		TrainContext.getInstance().showTimeLeft(timer.getTimeValue());
	}

	/**
	 * Process the timer runs out event
	 */
	@Override
	public void onTimerRunsOut() {
		TrainContext.getInstance().showTimeLeft(0);
		TrainContext.getInstance().changeState(TrainDoorReOpenCompleteState.getInstance());
	}

	@Override
	public void OnTimerTick(int timerValue) {
		TrainContext.getInstance().showTimeLeft(timerValue);
	}

	@Override
	public void enter() {
		timer = new Timer(this, (5 * (4 / 5)));
		TrainContext.getInstance().showTrainDoorReOpeningOn();
		TrainContext.getInstance().showTimeLeft(timer.getTimeValue());
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
		TrainContext.getInstance().showTrainDoorReOpenCompleteOn();
		TrainContext.getInstance().showTimeLeft(0);
	}

}

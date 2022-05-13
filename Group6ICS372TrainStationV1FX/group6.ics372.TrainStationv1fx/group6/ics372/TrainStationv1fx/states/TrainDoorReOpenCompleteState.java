package group6.ics372.TrainStationv1fx.states;

import group6.ics372.TrainStationv1fx.timer.Notifiable;
import group6.ics372.TrainStationv1fx.timer.Timer;

public class TrainDoorReOpenCompleteState extends TrainState implements Notifiable {
	private static TrainDoorReOpenCompleteState instance;
	private Timer timer;

	/**
	 * Private constructor for the singleton pattern
	 */
	private TrainDoorReOpenCompleteState() {
	}

	/**
	 * returns the instance
	 * 
	 * @return this object
	 */
	public static TrainDoorReOpenCompleteState getInstance() {
		if (instance == null) {
			instance = new TrainDoorReOpenCompleteState();
		}
		return instance;
	}

	/**
	 * handle door open event
	 * 
	 */
	@Override
	public void onTrainDoorReOpenComplete() {
		timer.addTimeValue(8);
		TrainContext.getInstance().showTimeLeft(timer.getTimeValue());
	}

	/**
	 * Process the timer runs out event
	 */
	@Override
	public void onTimerRunsOut() {
		TrainContext.getInstance().showTimeLeft(0);
		TrainContext.getInstance().changeState(TrainDoorClosingState.getInstance());
	}

	@Override
	public void OnTimerTick(int timerValue) {
		TrainContext.getInstance().showTimeLeft(timerValue);
	}

	@Override
	public void enter() {
		timer = new Timer(this, 8);
		TrainContext.getInstance().showTrainDoorReOpenCompleteOn();
		TrainContext.getInstance().showTimeLeft(timer.getTimeValue());
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
		TrainContext.getInstance().showTrainDoorClosingOn();
		TrainContext.getInstance().showTimeLeft(0);
	}
}
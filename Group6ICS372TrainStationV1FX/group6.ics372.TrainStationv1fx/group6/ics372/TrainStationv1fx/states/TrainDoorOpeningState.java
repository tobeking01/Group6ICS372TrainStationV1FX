package group6.ics372.TrainStationv1fx.states;

import group6.ics372.TrainStationv1fx.timer.Notifiable;
import group6.ics372.TrainStationv1fx.timer.Timer;

public class TrainDoorOpeningState extends TrainState implements Notifiable {

	private static TrainDoorOpeningState instance;
	private Timer timer;

	/**
	 * Private constructor for the singleton pattern
	 */
	private TrainDoorOpeningState() {
	}

	/**
	 * returns the instance
	 * 
	 * @return this objectnmmj
	 */
	public static TrainDoorOpeningState getInstance() {
		if (instance == null) {
			instance = new TrainDoorOpeningState();
		}
		return instance;
	}

	/**
	 * handle door open event
	 * 
	 */

	@Override
	public void onTrainDoorOpeningState() {
		timer.addTimeValue(4);
		TrainContext.getInstance().showTimeLeft(timer.getTimeValue());
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
		TrainContext.getInstance().changeState(TrainDoorOpenCompleteState.getInstance());
	}

	@Override
	public void enter() {
		timer = new Timer(this, 4);
		TrainContext.getInstance().showTrainDoorOpeningOn();
		TrainContext.getInstance().showTimeLeft(timer.getTimeValue());
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
		TrainContext.getInstance().showTrainDoorOpenCompleteOn();
		TrainContext.getInstance().showTimeLeft(0);
	}

}

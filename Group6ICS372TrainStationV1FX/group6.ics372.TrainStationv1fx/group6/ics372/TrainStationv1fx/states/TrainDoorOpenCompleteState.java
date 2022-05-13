package group6.ics372.TrainStationv1fx.states;

import group6.ics372.TrainStationv1fx.timer.Notifiable;
import group6.ics372.TrainStationv1fx.timer.Timer;

public class TrainDoorOpenCompleteState extends TrainState implements Notifiable {

	private static TrainDoorOpenCompleteState instance;
	private Timer timer;

	/**
	 * Private for the singleton pattern
	 */
	private TrainDoorOpenCompleteState() {
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static TrainDoorOpenCompleteState getInstance() {
		if (instance == null) {
			instance = new TrainDoorOpenCompleteState();
		}
		return instance;
	}

	@Override
	public void onTrainDoorOpenCompleteState() {
		timer.addTimeValue(30);
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
		TrainContext.getInstance().changeState(TrainDoorClosingState.getInstance());
	}

	@Override
	public void enter() {
		timer = new Timer(this, 30);
		TrainContext.getInstance().showTrainDoorOpenCompleteOn();
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

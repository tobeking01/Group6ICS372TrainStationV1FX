package group6.ics372.TrainStationv1fx.states;

public class TrainAtFullSpeedState extends TrainState {

	private static TrainAtFullSpeedState instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private TrainAtFullSpeedState() {
	}

	/**
	 * returns the instance
	 * 
	 * @return this object
	 */
	public static TrainAtFullSpeedState getInstance() {
		if (instance == null) {
			instance = new TrainAtFullSpeedState();
		}
		return instance;
	}

	@Override
	public void onStationReachingRequest() {
		TrainContext.getInstance().changeState(TrainDeceleratingState.getInstance());
	}

	@Override
	public void enter() {
		TrainContext.getInstance().showTrainAtFullSpeedOn();
	}

	@Override
	public void leave() {
		TrainContext.getInstance().showTrainDeceleratingOn();
	}

}

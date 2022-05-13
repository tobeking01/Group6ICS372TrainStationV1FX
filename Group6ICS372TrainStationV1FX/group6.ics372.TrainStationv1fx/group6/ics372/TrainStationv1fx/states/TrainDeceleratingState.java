package group6.ics372.TrainStationv1fx.states;

public class TrainDeceleratingState extends TrainState {
	private static TrainDeceleratingState instance;

	/**
	 * Private for the singleton pattern
	 */
	private TrainDeceleratingState() {
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static TrainDeceleratingState getInstance() {
		if (instance == null) {
			instance = new TrainDeceleratingState();
		}
		return instance;
	}

	/**
	 * Process Station reached request
	 */
	@Override
	public void onStationReachedRequest() {
		TrainContext.getInstance().changeState(TrainStoppedState.getInstance());
	}

	@Override
	public void enter() {
		TrainContext.getInstance().showTrainDeceleratingOn();
	}

	@Override
	public void leave() {
		TrainContext.getInstance().showTrainStoppedOn();
	}

}

package group6.ics372.TrainStationv1fx.timer;

/**
 * An entity that can be notified of timing events
 * 
 * @author Tobechi Onwenu
 *
 */
public interface Notifiable {
	/**
	 * Process timer ticks
	 */
	public void OnTimerTick(int timerValue);

	/**
	 * Process timer runs out event
	 */
	public void onTimerRunsOut();

}

package group6.ics372.TrainStationv1fx.buttons;

import group6.ics372.TrainStationv1fx.states.TrainContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class StationReachingButton extends GUIButton implements EventHandler<ActionEvent> {
	/**
	 * Crates the button with the required label
	 * 
	 * @param string the label
	 */

	public StationReachingButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		TrainContext.getInstance().onStationReachingRequest();
	}
}

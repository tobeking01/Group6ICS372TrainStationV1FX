package group6.ics372.TrainStationv1fx.buttons;

import group6.ics372.TrainStationv1fx.states.TrainContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class DoorObstructingButton extends GUIButton implements EventHandler<ActionEvent> {
	/**
	 * Create the button with the proper display
	 * 
	 * @param string the text to be put
	 */
	public DoorObstructingButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		TrainContext.getInstance().onDoorObstructingRequest();
	}
}

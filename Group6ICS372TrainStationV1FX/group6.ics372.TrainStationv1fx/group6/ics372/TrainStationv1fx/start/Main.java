package group6.ics372.TrainStationv1fx.start;

import group6.ics372.TrainStationv1fx.display.GUIDisplay;
import group6.ics372.TrainStationv1fx.timer.Clock;
import javafx.application.Application;

public class Main {

	public static void main(String[] args) {
		Clock.getInstance();
		new Thread() {
			@Override
			public void run() {
				Application.launch(GUIDisplay.class, null);
			}
		}.start();
	}
}

//On detection of such obstructions, the doors reopen: the reopening time is dependent on how far the
//door had closed. For example, if 3 seconds had elapsed after the closing process started, the time
//to fully reopen would be 3 * 4 / 5, that is roughly 2 seconds. (We will drop the fractions.) After
//fully reopening, the doors will re-close after 8 seconds. The doors may again encounter
//obstruction and the process could repeat.
//After the doors are fully closed, the train starts moving (accelerating) after 3 seconds.

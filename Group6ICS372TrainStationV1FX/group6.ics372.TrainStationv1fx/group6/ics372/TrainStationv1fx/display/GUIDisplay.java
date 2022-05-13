package group6.ics372.TrainStationv1fx.display;

import group6.ics372.TrainStationv1fx.buttons.DoorObstructingButton;
import group6.ics372.TrainStationv1fx.buttons.GUIButton;
import group6.ics372.TrainStationv1fx.buttons.StationReachedButton;
import group6.ics372.TrainStationv1fx.buttons.StationReachingButton;
import group6.ics372.TrainStationv1fx.states.TrainContext;

/**
 * Group 6
 */

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GUIDisplay extends Application implements TrainDisplay {

	private GUIButton stationReachingButton;
	private GUIButton stationReachedButton;
	private GUIButton doorObstructionButton;
	private Text trainStatus = new Text("Train Ready for departure");
	private Text trainDoorStatus = new Text("Train Door Closed");
	private Text timerValue1 = new Text("            ");

	@Override
	public void start(Stage primaryStage) throws Exception {
		stationReachingButton = new StationReachingButton("station reaching");
		stationReachedButton = new StationReachedButton("station reached");
		doorObstructionButton = new DoorObstructingButton("door obstruction");

		GridPane pane = new GridPane();
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setPadding(new Insets(10, 10, 10, 10));

		pane.add(trainStatus, 0, 0);

		pane.add(timerValue1, 2, 0);
		pane.add(trainDoorStatus, 3, 0);
		pane.add(stationReachingButton, 5, 0);
		pane.add(stationReachedButton, 6, 0);
		pane.add(doorObstructionButton, 7, 0);
		showTrainLeavingOn();
		showTimeLeft(0);

		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Train Version 1");
		TrainContext.getInstance().setDisplay(this);
		primaryStage.show();

		primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent window) {
				System.exit(0);
			}
		});
	}

	@Override
	public void showTimeLeft(int time) {
		timerValue1.setText(" " + time);
	}

	@Override
	public void showTrainLeavingOn() {
		trainStatus.setText("Train departing in");
	}

	@Override
	public void showTrainAcceleratingOn() {
		trainStatus.setText("Train Accelerating");
	}

	@Override
	public void showTrainAtFullSpeedOn() {
		trainStatus.setText("Train at Full Speed");
	}

	@Override
	public void showTrainDeceleratingOn() {
		trainStatus.setText("Train Decelerating");
	}

	@Override
	public void showTrainStoppedOn() {
		trainStatus.setText("Train Stopped");
	}

	@Override
	public void showTrainDoorOpeningOn() {
		trainDoorStatus.setText("seconds to left before Train Door fully Open");
	}

	@Override
	public void showTrainDoorOpenCompleteOn() {
		trainDoorStatus.setText("seconds to left before Train Door closing");
	}

	@Override
	public void showTrainDoorClosingOn() {
		trainDoorStatus.setText("seconds left before Door Closing");
	}

	@Override
	public void showTrainDoorReOpeningOn() {
		trainDoorStatus.setText("seconds left to Train Door ReOpening");
	}

	@Override
	public void showTrainDoorReOpenCompleteOn() {
		trainDoorStatus.setText("Train Door ReOpening Complete");
	}

	@Override
	public void showTrainDoorReClosingOn() {
		trainDoorStatus.setText("seconds left before Train Door ReCloses");
	}

	@Override
	public void showTrainDoorCloseCompleteOn() {
		// TODO Auto-generated method stub

	}

}

module group6.ics372.TrainStationv1fx {
	requires javafx.controls;
	requires javafx.base;
	requires java.desktop;
	requires javafx.graphics;

	exports group6.ics372.TrainStationv1fx.display to javafx.graphics;
	exports group6.ics372.TrainStationv1fx.start to javafx.graphics;
}
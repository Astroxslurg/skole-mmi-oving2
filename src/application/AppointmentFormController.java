package application;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AppointmentFormController {

	
	@FXML TextField purposeField;
	@FXML TextField roomField;
	@FXML DatePicker dateField;
	@FXML TextField startTime;
	@FXML TextField stopTime;
	@FXML CheckBox repetitionCheckbox;
	@FXML TextField antReservations;
	@FXML TextField freqReservations;
	@FXML Label finishedAt;
	
	@FXML
	void roomFieldChange(Event event) {
		boolean isMatch = Pattern.matches("(\\w|\\s|-)+?\\s(\\d)+", roomField.getText());
		if (isMatch) {
			roomField.setStyle("-fx-control-inner-background: #fff");
		} else {
			roomField.setStyle("-fx-control-inner-background: #f55");
		}
	}
	
	@FXML
	void checkBoxChange(Event event) {
		antReservations.setDisable(!repetitionCheckbox.isSelected());
		freqReservations.setDisable(!repetitionCheckbox.isSelected());
	}
	
	@FXML
	void antReservationsFieldChange(Event event) {
		boolean b = Pattern.matches("\\d+", antReservations.getText());
			if (!b) {
				antReservations.setStyle("-fx-control-inner-background: #f55");
			} else {
				antReservations.setStyle("-fx-control-inner-background: #ffffff");
			}
		makeFinishDateVisibleIfValidState();
	}
	
	@FXML
	void freqReservationsFieldChange(Event event) {
		boolean b = Pattern.matches("\\d+", freqReservations.getText());
			if (!b) {
				freqReservations.setStyle("-fx-control-inner-background: #f55");
			} else {
				freqReservations.setStyle("-fx-control-inner-background: #ffffff");
			}
		makeFinishDateVisibleIfValidState();
	}	
	
	@FXML
	void startTimeChange(Event event) {
		String currentTextInField = startTime.getText();
		String pattern = "([0-1][0-9]:[0-5][0-9])|([2][0-1]:[0-5][0-9])";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(currentTextInField);
		if (!m.matches()) {
			startTime.setStyle("-fx-control-inner-background: #ff0000");
		} else {
			startTime.setStyle("-fx-control-inner-background: #ffffff");
		}
	}
	
	@FXML
	void stopTimeChange(Event event) {
		String startTimeString = startTime.getText();
		String stopTimeString = stopTime.getText();
		if (startTimeString.length() == 5 && stopTimeString.length() == 5) {
			int startHours = Integer.parseInt(startTimeString.substring(0,2));
			int startMinutes = Integer.parseInt(startTimeString.substring(3,4));
			LocalTime localStartTime = LocalTime.of(startHours, startMinutes);
			int stopHours = Integer.parseInt(stopTimeString.substring(0,2));
			int stopMinutes = Integer.parseInt(stopTimeString.substring(3,4));
			LocalTime localStopTime = LocalTime.of(stopHours, stopMinutes);
			if (localStartTime.isAfter(localStopTime)) {
				stopTime.setStyle("-fx-control-inner-background: #ff0000");
			} else {
				stopTime.setStyle("-fx-control-inner-background: #ffffff");
			}
		} else {
			stopTime.setStyle("-fx-control-inner-background: #ff0000");
		}
		
	}
	
	@FXML
	void dateFieldChange(Event event){
		LocalDate selectedDate = dateField.getValue();
		LocalDate currentDate = LocalDate.now();
		if (selectedDate.isAfter(currentDate)) {
			dateField.setStyle("-fx-control-inner-background: #fff");
		} else {
			dateField.setStyle("-fx-control-inner-background: #f55");
		}
	}	
	
	void makeFinishDateVisibleIfValidState() {
		String antResFieldValue = antReservations.getText();
		String freqResFieldValue = freqReservations.getText();
		if (antResFieldValue.length() != 0 && freqResFieldValue.length() != 0) {
			finishedAt.setVisible(true);
			finishedAt.setText("Reservasjonen er klar: ");
		} else {
			finishedAt.setVisible(false);
		}
	}
}

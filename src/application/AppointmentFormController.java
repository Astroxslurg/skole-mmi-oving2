package application;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDate;

import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AppointmentFormController {

	
	@FXML TextField purposeField;
	@FXML TextField emailField;
	@FXML DatePicker dateField;
	@FXML TextField startTime;
	@FXML TextField stopTime;
	@FXML CheckBox repetitionCheckbox;
	@FXML TextField antReservations;
	@FXML TextField freqReservations;
	
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
	}
	
	@FXML
	void freqReservationsFieldChange(Event event) {
		boolean b = Pattern.matches("\\d+", freqReservations.getText());
			if (!b) {
				freqReservations.setStyle("-fx-control-inner-background: #f55");
			} else {
				freqReservations.setStyle("-fx-control-inner-background: #ffffff");
			}
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
	void dateFieldChange(Event event){
		LocalDate selectedDate = dateField.getValue();
		LocalDate currentDate = LocalDate.now();
		if (selectedDate.isAfter(currentDate)) {
			dateField.setStyle("-fx-control-inner-background: #fff");
		} else {
			dateField.setStyle("-fx-control-inner-background: #f55");
		}
	}	
	
}

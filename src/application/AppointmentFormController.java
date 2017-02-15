package application;

import java.time.LocalDate;

import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
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
	
	@FXML
	void checkBoxChange(Event event) {
		antReservations.setDisable(!repetitionCheckbox.isSelected());
		freqReservations.setDisable(!repetitionCheckbox.isSelected());
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

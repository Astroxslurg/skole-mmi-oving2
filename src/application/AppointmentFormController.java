package application;

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
	
}

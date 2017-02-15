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
	void nameFieldChange(Event event) {
		boolean b = Pattern.matches("\\d", antReservations.getText());
			if (b) {
				System.out.println(antReservations.getText());
			}
	}
	
	@FXML
	void startTimeChange(Event event) {
		//String currentTextInField = startTime.getText();
		//if(currentTextInField.length() != 5) {
		//	startTime.setStyle("-fx-control-inner-background: #ff0000");
		//} else {
		//startTime.setStyle("-fx-control-inner-background: #ffffff");
		//}
		//System.out.println(startTime.getText());
		
		String currentTextInField = startTime.getText();
		String pattern = "\\d\\d:\\d\\d";
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

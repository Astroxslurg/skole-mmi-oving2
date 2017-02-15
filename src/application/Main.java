package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane page = (GridPane) FXMLLoader.load(Main.class.getResource("AppointmentForm.fxml"));
			Scene scene = new Scene(page,800,800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		Appointment appointment = new Appointment();
		AppointmentFormController controller = new AppointmentFormController();
		launch(args);
	}
}

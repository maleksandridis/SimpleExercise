
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class JavelasApp extends Application {

	private Stage primaryStage;
	private BorderPane root;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("JavelasSpellChecker");

        showMainMenu();

        try {
			Dictionary customDic = new Dictionary();
			Dictionary grDic = new Dictionary("Greek", 73, 974);
			Dictionary enDic = new Dictionary("English", 58, 122);
		} catch (IOException iOException) {
			Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(getPrimaryStage());
	        alert.setTitle("Error");
	        alert.setHeaderText("Error while loading the dictionaries");
	        alert.setContentText("The program was not able to load the dictionary files.");
	        alert.showAndWait();
		}
	}

	public void showEmptyScene() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(JavelasApp.class.getResource("MistakeMenu.fxml"));
			root = (BorderPane) loader.load();

        	Scene scene = new Scene(root);
        	primaryStage.setScene(scene);
            primaryStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showMainMenu() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(JavelasApp.class.getResource("MainMenu.fxml"));
			root = (BorderPane) loader.load();

        	Scene scene = new Scene(root);
        	primaryStage.setScene(scene);
            primaryStage.show();

            MainMenuController controller = loader.getController();
            controller.setJavelasApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showMistakeMenu(String wordStr) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(JavelasApp.class.getResource("MistakeMenu.fxml"));
			root = (BorderPane) loader.load();

        	Scene scene = new Scene(root);
        	primaryStage.setScene(scene);
            primaryStage.show();

            MistakeMenuController controller = loader.getController();
            controller.setJavelasApp(this);
            controller.setWrongWordPanel("The word \"" + wordStr + "\" doesn't exist.\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}

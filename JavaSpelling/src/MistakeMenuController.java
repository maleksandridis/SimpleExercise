import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MistakeMenuController {

	@FXML
	private TextField wrongWordPanel;
	@FXML
	private TextField suggestions;
	@FXML
	private Button skipThis;
	@FXML
	private Button skipSame;
	@FXML
	private Button addToDictionary;

	private JavelasApp javelasApp;

	public MistakeMenuController() {
	}

	@FXML
	public void getSuggestions(ActionEvent event) {

	}

	@FXML
	public void clickSkipThis(ActionEvent event) {

	}

	@FXML
	public void clickSkipSame(ActionEvent event) {

	}

	@FXML
	public void clickAddToDictionary(ActionEvent event) {

	}

	public void setJavelasApp(JavelasApp javelasApp) {
		this.javelasApp = javelasApp;
	}

	public void setWrongWordPanel(String value) {
		wrongWordPanel.setText(value);
	}
}

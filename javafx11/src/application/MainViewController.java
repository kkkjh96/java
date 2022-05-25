package application;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class MainViewController {
	@FXML
	private TextField MainView;

	// Event Listener on TextField[#MainView].onAction
	@FXML
	public void btnOKClicked(ActionEvent event) {

		Stage MainWindow = (Stage)MainView.getScene().getWindow();
		String title = MainView.getText();
		MainWindow.setTitle(title);
	}
}

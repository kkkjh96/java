package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainSceneController {
	@FXML
	private TextField tfTitle;
	
	public void btnOKClicked(ActionEvent envet) {
		Stage MainWindow = (Stage) tfTitle.getScene().getWindow();
		String title = tfTitle.getText();
		MainWindow.setTitle(title);
	}
}

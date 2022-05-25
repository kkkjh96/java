package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
//			BorderPane root = new BorderPane();//layout
	
//			Scene scene = new Scene(root,1400,800);//크기 조절
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());//scene
			
			Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
			Scene scene = new Scene(root);
				
			primaryStage.setTitle("JavafxTableview");//제목
			primaryStage.setScene(scene);
			primaryStage.show();//stage
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

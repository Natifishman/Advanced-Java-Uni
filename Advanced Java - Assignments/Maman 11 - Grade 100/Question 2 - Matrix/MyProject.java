import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Question 2 in Maman11
 * Code written by Natanel Fishman.
 *
 * This JavaFX application displays a drawing consisting of a matrix of lines with a space of 10 pixels between lines
 * The size is 20X20 because of the picture in the Maman.
 * It randomly fills 10% of the cells(slots) ensuring that the random operation does not repeat the same square twice.
 */

public class MyProject extends Application{ 
	
	public void start(Stage stage) throws Exception{ 
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("MyProject.fxml")); 
		Scene scene = new Scene(root); 
		stage.setTitle("MyProject");
		stage.setScene(scene); 
		stage.show(); 
	} 
	
	public static void main(String[] args) { 
		launch(args); 
		System.out.println();
	} 
}
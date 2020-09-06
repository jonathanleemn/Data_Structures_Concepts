package buttonsAndImages;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{

	public static void main(String[] args)
	{
		Main.launch(args);
	}

	//the stage = window
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		ShapeDisplay display = new ShapeDisplay();
		ShapeController control = new ShapeController(display);
		
		primaryStage.setTitle("Shape View");
		primaryStage.setScene(display.getScene());
		
		primaryStage.show();
	}

}

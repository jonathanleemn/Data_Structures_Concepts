package personViewer;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{

	public static void main(String[] args)
	{
		Main.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		PersonViewer view = new PersonViewer();
		Person person = new Person("Jon", "Lee", 22);
		PersonController control = new PersonController(person, view);
		primaryStage.setTitle("Person Tester");
		primaryStage.setScene(view.getScene());
		
		primaryStage.show();
	}

}

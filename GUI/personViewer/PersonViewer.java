package personViewer;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class PersonViewer
{
	BorderPane border;
	GridPane grid;
	FlowPane buttons;
	Button submit, clear;
	TextField fNameField, lNameField, ageField;
	Label fName, age, lName;
	TextArea output;
	Scene scene;
	
	public PersonViewer()
	{
		border = new BorderPane();
		grid = new GridPane();
		buttons = new FlowPane();
		
		submit = new Button("Submit");
		clear = new Button("Clear");
		clear.setStyle("-fx-base: #fefefe");
		submit.setStyle("-fx-base: #fefefe");
		
		border.setTop(grid);
		border.setBottom(buttons);
		grid.setPadding(new Insets(4, 4, 4, 4));
		grid.setVgap(4.0);
		scene = new Scene(border);
		
		fName = new Label("First Name: ");
		grid.add(fName, 0, 0);
		
		lName = new Label("Last Name: ");
		grid.add(lName, 0, 1);
		
		age = new Label("Age: ");
		grid.add(age, 0, 2);
		
		fNameField = new TextField();
		grid.add(fNameField, 1, 0);
		
		lNameField = new TextField();
		grid.add(lNameField, 1, 1);
		
		ageField = new TextField();
		grid.add(ageField, 1, 2);
		
		output = new TextArea();
		border.setCenter(output);
		buttons.getChildren().add(submit);
		buttons.getChildren().add(clear);
	}

	public BorderPane getBorder()
	{
		return border;
	}

	public void setBorder(BorderPane border)
	{
		this.border = border;
	}

	public GridPane getGrid()
	{
		return grid;
	}

	public void setGrid(GridPane grid)
	{
		this.grid = grid;
	}

	public FlowPane getButtons()
	{
		return buttons;
	}

	public void setButtons(FlowPane buttons)
	{
		this.buttons = buttons;
	}

	public Button getSubmit()
	{
		return submit;
	}

	public void setSubmit(Button submit)
	{
		this.submit = submit;
	}

	public Button getClear()
	{
		return clear;
	}

	public void setClear(Button clear)
	{
		this.clear = clear;
	}

	public TextField getfNameField()
	{
		return fNameField;
	}

	public void setfNameField(TextField fNameField)
	{
		this.fNameField = fNameField;
	}

	public TextField getlNameField()
	{
		return lNameField;
	}

	public void setlNameField(TextField lNameField)
	{
		this.lNameField = lNameField;
	}

	public TextField getAgeField()
	{
		return ageField;
	}

	public void setAgeField(TextField ageField)
	{
		this.ageField = ageField;
	}

	public Label getfName()
	{
		return fName;
	}

	public void setfName(Label fName)
	{
		this.fName = fName;
	}

	public Label getAge()
	{
		return age;
	}

	public void setAge(Label age)
	{
		this.age = age;
	}

	public Label getlName()
	{
		return lName;
	}

	public void setlName(Label lName)
	{
		this.lName = lName;
	}

	public TextArea getOutput()
	{
		return output;
	}

	public void setOutput(TextArea output)
	{
		this.output = output;
	}

	public Scene getScene()
	{
		return scene;
	}

	public void setScene(Scene scene)
	{
		this.scene = scene;
	}
	
	
}

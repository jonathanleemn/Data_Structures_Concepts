package buttonsAndImages;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class ShapeDisplay
{
	Scene scene; // holds all gui components
	BorderPane border; //transparent window that can hold gui components in a border format
	FlowPane buttons; //take gui components and have them flow side by side
	Pane drawPane; //standard pane, no layout component
	Circle circ;
	Rectangle rect;
	Button circButton, rectButton;
	
	public ShapeDisplay()
	{
		border = new BorderPane();
		scene = new Scene(border, 500, 500);
		buttons = new FlowPane();
		drawPane = new Pane();
		
		//shapes
		circ = new Circle(250, 250, 200, Color.RED);
		rect = new Rectangle(50, 50, 400, 400);
		rect.setStroke(Color.AQUAMARINE);
		rect.setFill(Color.ORANGERED);
		
		circ.setVisible(false);
		rect.setVisible(false);
		
		drawPane.getChildren().add(circ);
		drawPane.getChildren().add(rect);
		
		border.setCenter(drawPane);
		border.setBottom(buttons);
		
		//buttons
		circButton = new Button("Circle");
		rectButton = new Button("Square");
		
		buttons.getChildren().add(circButton);
		buttons.getChildren().add(rectButton);
	}
	
	//getters and setters
	public Circle getCirc()
	{
		return circ;
	}
	
	public Rectangle getRect()
	{
		return rect;
	}
	
	public Button getCircButton()
	{
		return circButton;
	}
	
	public Button getRectButton()
	{
		return rectButton;
	}
	
	public Scene getScene()
	{
		return scene;
	}
	
}

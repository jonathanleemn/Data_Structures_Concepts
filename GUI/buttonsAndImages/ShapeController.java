package buttonsAndImages;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ShapeController implements EventHandler<ActionEvent>
{
	ShapeDisplay view;

	public ShapeController(ShapeDisplay view)
	{
		this.view = view;

		// register the components to the listener
		view.getCircButton().setOnAction(this);
		view.getRectButton().setOnAction(this);
	}

	@Override
	public void handle(ActionEvent e)
	{
		if (e.getSource().equals(view.getCircButton()))
		{
			view.getCirc().setVisible(true);
			view.getRect().setVisible(false);
		}
		if (e.getSource().equals(view.getRectButton()))
		{
			view.getCirc().setVisible(false);
			view.getRect().setVisible(true);
		}
	}
}

package personViewer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class PersonController implements EventHandler<ActionEvent>
{
	Person person;
	PersonViewer view;
	
	public PersonController(Person p, PersonViewer v)
	{
		person = p;
		view = v;
		
		//register the components to the listener
		view.getSubmit().setOnAction(this);
		view.getClear().setOnAction(this);
	}
	
	@Override
	public void handle(ActionEvent event)
	{		
		if(event.getSource().equals(view.getSubmit()))
		{
			person.setfName(view.getfNameField().getText());
			person.setlName(view.getlNameField().getText());
			person.setAge(Integer.parseInt(view.getAgeField().getText()));
			view.getOutput().appendText(person.toString());
		}
		
		if(event.getSource().equals(view.getClear()))
		{
			view.getOutput().clear();
		}
	}

}

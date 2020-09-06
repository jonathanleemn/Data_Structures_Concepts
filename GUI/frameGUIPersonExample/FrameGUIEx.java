package frameGUIPersonExample;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class FrameGUIEx extends JFrame{
	private JTextArea textArea;
	private JTextField firstNameField, lastNameField, ageField;
	private JButton submit;
	private JLabel firstNameLabel, lastNameLabel, ageLabel;
	private JScrollPane scrollPane;
	private JPanel inputFields;
	private Person myPerson=new Person("","",0);
	/*
	 * Grid layout will make a stable layout for your text fields and labels.  
	 *If the window resizes things will still align properly.
	 */
	private GridLayout grid=new GridLayout(3, 2);//Create grid layout object
	
	public FrameGUIEx(){
		super("GUI Example");
		setLayout(new BorderLayout());//set layout of the JFrame to BorderLayout()
		
		//create the GUI components		
		textArea=new JTextArea(4,20);
		textArea.setLineWrap(true);//word wrap will wrap words when you reach the end of a line
		
		scrollPane= new JScrollPane(textArea);//ScrollPane() will put scrollbars on the text area.
		
		firstNameField=new JTextField(12);
		lastNameField=new JTextField(12);
		ageField=new JTextField(12);
		
		submit=new JButton("Submit");
		
		firstNameLabel=new JLabel("First Name: ");
		lastNameLabel=new JLabel("Last Name: ");
		ageLabel=new JLabel("Age: ");
		
		inputFields=new JPanel();
		inputFields.setLayout(grid);//set layout of the JPanel that holds the input fields to grid
		
		//add the GUI components to the JFrame
		add(inputFields, BorderLayout.CENTER);
		//add input fields to the JPanel
		inputFields.add(firstNameLabel);
		inputFields.add(firstNameField);
		inputFields.add(lastNameLabel);
		inputFields.add(lastNameField);
		inputFields.add(ageLabel);
		inputFields.add(ageField);	
		
		//add the ScrollPane and the JButton to the JFrame
		add(scrollPane, BorderLayout.NORTH);
		add(submit, BorderLayout.SOUTH);		
		
		//Create the event handler and add the ActionListeners
		GUIHandler handler=new GUIHandler();
		submit.addActionListener(handler);
				
	}
	
	private class GUIHandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			
			//setting the Person's name by getting text from the textFields
			myPerson.setFirstName(firstNameField.getText());
			myPerson.setLastName(lastNameField.getText());
			myPerson.setAge(Integer.parseInt(ageField.getText()));
			//Write to the textArea
			textArea.append("First name: "+myPerson.getFirstName()+"\n"+ "Last name: "+myPerson.getLastName()+"\n"+
			"Age: " + myPerson.getAge()+"\n");
		}//end actionPerformed(
		
	}//end GUIHandler
	
}//end FrameGUIEx

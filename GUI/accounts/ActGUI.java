/*
 * This program demonstrates two strategies for layout management, 
 * the null layout and the use of multiple layout managers.
 * 
 * */
package accounts;



import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ActGUI extends JFrame{
	private BorderLayout border=new BorderLayout();
	private GridLayout grid=new GridLayout(4,2);
	private JTextArea textArea;
	private JTextField nameField, depositField, withdrawField;
	private JButton submit;
	private JLabel nameLabel, depositLabel, withdrawLabel;
	private JScrollPane scrollPane;
	private JPanel inputFields;
	private Account myAccount=new Account(5000,"");
	
	
	public ActGUI(){
		super("Bank Account GUI Demo - BorderLayout and GridLayout");		
		
		setLayout(border);
		
		//set up labels and fields for input
		nameLabel=new JLabel("Name: ");
		//nameLabel.setBounds(5,5, 100, 15);
		//add(nameLabel);
		
		depositLabel=new JLabel("Deposit Amount: ");
		//depositLabel.setBounds(5,21, 100, 15);
		//add(depositLabel);
		
		withdrawLabel=new JLabel("Withdraw Amount: ");
		//withdrawLabel.setBounds(5,37, 120, 15);
		//add(withdrawLabel);
		
		nameField=new JTextField(12);
		//nameField.setBounds(125, 5, 75, 15);
		//add(nameField);
		
		depositField=new JTextField(12);
		//depositField.setBounds(125, 21, 75, 15);
		//add(depositField);
		
		withdrawField=new JTextField(12);
		//withdrawField.setBounds(125, 37, 75, 15);
		//add(withdrawField);
		
		//create panel and add labels and fields to panel
		inputFields=new JPanel(grid);
		inputFields.add(nameLabel);
		inputFields.add(nameField);
		inputFields.add(depositLabel);
		inputFields.add(depositField);
		inputFields.add(withdrawLabel);
		inputFields.add(withdrawField);
		
		submit=new JButton("Submit");
		//submit.setBounds(5, 55, 75, 15);
		inputFields.add(submit);
		
		add(inputFields, BorderLayout.NORTH);
		
		textArea=new JTextArea();
		//textArea.setBounds(0, 0, 220, 100);
		
		scrollPane=new JScrollPane(textArea);
		//scrollPane.setBounds(5, 75, 195, 100);
		add(scrollPane, BorderLayout.CENTER);
	
		
		
		
	}//end constructor
	
	/**
	 * @return the textArea
	 */
	public JTextArea getTextArea() {
		return textArea;
	}

	/**
	 * @return the nameField
	 */
	public JTextField getNameField() {
		return nameField;
	}

	/**
	 * @return the depositField
	 */
	public JTextField getDepositField() {
		return depositField;
	}

	/**
	 * @return the withdrawField
	 */
	public JTextField getWithdrawField() {
		return withdrawField;
	}

	/**
	 * @return the submit
	 */
	public JButton getSubmit() {
		return submit;
	}

	/**
	 * @return the inputFields
	 */
	public JPanel getInputFields() {
		return inputFields;
	}

	/**
	 * @param textArea the textArea to set
	 */
	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	/**
	 * @param nameField the nameField to set
	 */
	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
	}

	/**
	 * @param depositField the depositField to set
	 */
	public void setDepositField(JTextField depositField) {
		this.depositField = depositField;
	}

	/**
	 * @param withdrawField the withdrawField to set
	 */
	public void setWithdrawField(JTextField withdrawField) {
		this.withdrawField = withdrawField;
	}

	/**
	 * @param submit the submit to set
	 */
	public void setSubmit(JButton submit) {
		this.submit = submit;
	}

	/**
	 * @param inputFields the inputFields to set
	 */
	public void setInputFields(JPanel inputFields) {
		this.inputFields = inputFields;
	}

	
	
}

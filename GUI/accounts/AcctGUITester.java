package accounts;

import javax.swing.JFrame;

public class AcctGUITester {
	public static void main(String[]args){
	ActGUI myGUI=new ActGUI();
	
	Account acct=new Account("Me");
	AccountController control=new AccountController(myGUI, acct);
	
	myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	myGUI.setSize(250, 250);
	myGUI.setVisible(true);
	}
}

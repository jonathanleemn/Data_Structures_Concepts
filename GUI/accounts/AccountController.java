package accounts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountController implements ActionListener{
	ActGUI view;
	Account model;

	public AccountController(ActGUI v, Account m){
		model=m;
		view=v;
		view.getSubmit().addActionListener(this);
		view.getWithdrawField().addActionListener(this);
		view.getDepositField().addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		model.setName(view.getNameField().getText());
		model.deposit(Double.parseDouble(view.getDepositField().getText()));
		model.withdraw(Double.parseDouble(view.getWithdrawField().getText()));

		view.getTextArea().append(model.toString());

	}

}

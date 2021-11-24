package rec_center_desktop.model;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ProfessorRegister extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public ProfessorRegister() {
		setLayout(null);
		
		JLabel lblProfessorRegister = new JLabel("Professor Register");
		lblProfessorRegister.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblProfessorRegister.setBounds(35, 11, 258, 46);
		add(lblProfessorRegister);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(219, 87, 179, 20);
		add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("Department");
		lblNewLabel_1.setBounds(54, 90, 136, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Office");
		lblNewLabel_1_1.setBounds(54, 129, 136, 14);
		add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(219, 126, 179, 20);
		add(textField_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Research");
		lblNewLabel_1_1_1_1.setBounds(54, 166, 136, 14);
		add(lblNewLabel_1_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(219, 163, 179, 20);
		add(textField_3);
		
		JButton registerButton = new JButton("Register");
		registerButton.setBounds(183, 241, 89, 23);
		add(registerButton);
		
	}

}

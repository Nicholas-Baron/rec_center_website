package rec_center_desktop.model;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ProfessorStudentRegister extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Create the panel.
	 */
	public ProfessorStudentRegister() {
		setLayout(null);
		
		JLabel lblProfessorRegister = new JLabel("Professor Register");
		lblProfessorRegister.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblProfessorRegister.setBounds(35, 11, 258, 46);
		add(lblProfessorRegister);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(221, 165, 179, 20);
		add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("Department");
		lblNewLabel_1.setBounds(56, 168, 136, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Office");
		lblNewLabel_1_1.setBounds(56, 196, 136, 14);
		add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(221, 193, 179, 20);
		add(textField_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Research");
		lblNewLabel_1_1_1_1.setBounds(56, 225, 136, 14);
		add(lblNewLabel_1_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(221, 222, 179, 20);
		add(textField_3);
		
		JButton registerButton = new JButton("Register");
		registerButton.setBounds(183, 253, 89, 23);
		add(registerButton);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(221, 137, 179, 20);
		add(textField_2);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Major");
		lblNewLabel_1_1_1_1_1.setBounds(56, 114, 136, 14);
		add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Minor");
		lblNewLabel_1_1_1.setBounds(56, 140, 136, 14);
		add(lblNewLabel_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(221, 111, 179, 20);
		add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(221, 85, 179, 20);
		add(textField_5);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Grad Date");
		lblNewLabel_1_1_2.setBounds(56, 89, 136, 14);
		add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Enter Date");
		lblNewLabel_1_2.setBounds(56, 61, 136, 14);
		add(lblNewLabel_1_2);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(221, 58, 179, 20);
		add(textField_6);
		
	}

}

package rec_center_desktop.model;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class UserRegister extends JPanel {
	private JTextField textField_4;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_1;
	private JLabel lblAddress;
	private JLabel lblStreet;
	private JTextField textField_3;
	private JTextField textField_5;
	private JLabel lblCity;
	private JLabel lblState;
	private JTextField textField_6;
	private JLabel lblZip;
	private JTextField textField_7;

	/**
	 * Create the panel.
	 */
	public UserRegister() {
		setLayout(null);
		
		textField_4 = new JTextField();
		textField_4.setBounds(127, 157, 43, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(127, 84, 235, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Full Name");
		lblNewLabel.setBounds(77, 87, 53, 14);
		add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(127, 121, 79, 20);
		add(textField_2);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setBounds(77, 124, 53, 14);
		add(lblDob);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(254, 121, 108, 20);
		add(textField_1);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(216, 124, 53, 14);
		add(lblPhone);
		
		lblAddress = new JLabel("No.");
		lblAddress.setBounds(77, 160, 53, 14);
		add(lblAddress);
		
		lblStreet = new JLabel("Street");
		lblStreet.setBounds(180, 160, 53, 14);
		add(lblStreet);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(216, 157, 146, 20);
		add(textField_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(126, 193, 56, 20);
		add(textField_5);
		
		lblCity = new JLabel("City");
		lblCity.setBounds(76, 196, 53, 14);
		add(lblCity);
		
		lblState = new JLabel("State");
		lblState.setBounds(192, 196, 53, 14);
		add(lblState);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(225, 193, 30, 20);
		add(textField_6);
		
		lblZip = new JLabel("Zip");
		lblZip.setBounds(262, 196, 30, 14);
		add(lblZip);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(282, 193, 79, 20);
		add(textField_7);
		
		JButton btnNewButton = new JButton("Student");
		btnNewButton.setBounds(10, 233, 116, 23);
		add(btnNewButton);
		
		JButton btnProfessor = new JButton("Professor");
		btnProfessor.setBounds(324, 233, 116, 23);
		add(btnProfessor);
		
		JButton btnProfessorstudent = new JButton("Professor and Student");
		btnProfessorstudent.setBounds(136, 233, 178, 23);
		add(btnProfessorstudent);
		
		JLabel lblNewLabel_1 = new JLabel("User Registration");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblNewLabel_1.setBounds(35, 11, 291, 46);
		add(lblNewLabel_1);
			
	}
}

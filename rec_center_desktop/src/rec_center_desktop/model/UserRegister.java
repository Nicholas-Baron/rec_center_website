package rec_center_desktop.model;

import javax.swing.JPanel;
import javax.swing.JTextField;

import model.entities.Address;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserRegister extends JPanel {
	private JTextField numberField;
	private JTextField fullnameField;
	private JTextField DOBField;
	private JTextField phoneField;
	private JLabel lblAddress;
	private JLabel lblStreet;
	private JTextField streetField;
	private JTextField city;
	private JLabel lblCity;
	private JLabel lblState;
	private JTextField state;
	private JLabel lblZip;
	private JTextField zip;
	private JPanel thisPanel;

	/**
	 * Create the panel.
	 */
	public UserRegister(JFrame contentFrame) {
		setLayout(null);
		
		thisPanel = this;
		numberField = new JTextField();
		numberField.setBounds(127, 157, 43, 20);
		add(numberField);
		numberField.setColumns(10);
		
		fullnameField = new JTextField();
		fullnameField.setBounds(127, 84, 235, 20);
		add(fullnameField);
		fullnameField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Full Name");
		lblNewLabel.setBounds(77, 87, 53, 14);
		add(lblNewLabel);
		
		DOBField = new JTextField();
		DOBField.setColumns(10);
		DOBField.setBounds(127, 121, 79, 20);
		add(DOBField);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setBounds(77, 124, 53, 14);
		add(lblDob);
		
		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(254, 121, 108, 20);
		add(phoneField);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(216, 124, 53, 14);
		add(lblPhone);
		
		lblAddress = new JLabel("No.");
		lblAddress.setBounds(77, 160, 53, 14);
		add(lblAddress);
		
		lblStreet = new JLabel("Street");
		lblStreet.setBounds(180, 160, 53, 14);
		add(lblStreet);
		
		streetField = new JTextField();
		streetField.setColumns(10);
		streetField.setBounds(216, 157, 146, 20);
		add(streetField);
		
		city = new JTextField();
		city.setColumns(10);
		city.setBounds(126, 193, 56, 20);
		add(city);
		
		lblCity = new JLabel("City");
		lblCity.setBounds(76, 196, 53, 14);
		add(lblCity);
		
		lblState = new JLabel("State");
		lblState.setBounds(192, 196, 53, 14);
		add(lblState);
		
		state = new JTextField();
		state.setColumns(10);
		state.setBounds(225, 193, 30, 20);
		add(state);
		
		lblZip = new JLabel("Zip");
		lblZip.setBounds(262, 196, 30, 14);
		add(lblZip);
		
		zip = new JTextField();
		zip.setColumns(10);
		zip.setBounds(282, 193, 79, 20);
		add(zip);
		
		JButton btnStudent = new JButton("Student");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Address address = new Address(streetField.getText(), Integer.parseInt(numberField.getText()), Integer.parseInt(zip.getText()), city.getText(), state.getText());
				StudentRegister sr = new StudentRegister(fullnameField.getText(), DOBField.getText(), phoneField.getText(), address);
				sr.setVisible(true); thisPanel.setVisible(false);
				contentFrame.remove(thisPanel);
				contentFrame.setContentPane(sr);
				 
			}
		});
		btnStudent.setBounds(10, 233, 116, 23);
		add(btnStudent);
		
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

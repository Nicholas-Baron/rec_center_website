package src.rec_center_desktop.model;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import model.dataccess.ReservationBusiness;
import model.dataccess.UserBusiness;
import model.entities.Address;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class StudentRegister extends JPanel {
	private JTextField enterDateField;
	private JTextField gradDateField;
	private JTextField minorField;
	private JTextField majorField;
	private JTextField broncoId;

	/**
	 * Create the panel.
	 */
	public StudentRegister(String fullname, String DOB, String phone, Address address) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Register");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblNewLabel.setBounds(35, 11, 258, 46);
		add(lblNewLabel);
		
		enterDateField = new JTextField();
		enterDateField.setBounds(210, 78, 179, 20);
		add(enterDateField);
		enterDateField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Date");
		lblNewLabel_1.setBounds(45, 81, 136, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Grad Date");
		lblNewLabel_1_1.setBounds(45, 120, 136, 14);
		add(lblNewLabel_1_1);
		
		gradDateField = new JTextField();
		gradDateField.setColumns(10);
		gradDateField.setBounds(210, 117, 179, 20);
		add(gradDateField);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Minor");
		lblNewLabel_1_1_1.setBounds(45, 193, 136, 14);
		add(lblNewLabel_1_1_1);
		
		minorField = new JTextField();
		minorField.setColumns(10);
		minorField.setBounds(210, 190, 179, 20);
		add(minorField);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Major");
		lblNewLabel_1_1_1_1.setBounds(45, 157, 136, 14);
		add(lblNewLabel_1_1_1_1);
		
		majorField = new JTextField();
		majorField.setColumns(10);
		majorField.setBounds(210, 154, 179, 20);
		add(majorField);
		
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserBusiness ub = UserBusiness.getInstance();
				try {
					ub.createCustomer(Integer.parseInt(broncoId.getText()), Date.valueOf(DOB), fullname, Integer.parseInt(phone), Date.valueOf(enterDateField.getText()), Date.valueOf(gradDateField.getText()), majorField.getText(), minorField.getText(), address);
				} catch (Exception ex) {
					
				}
			}
		});
		registerButton.setBounds(176, 266, 89, 23);
		add(registerButton);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("BroncoID");
		lblNewLabel_1_1_1_2.setBounds(47, 228, 136, 14);
		add(lblNewLabel_1_1_1_2);
		
		broncoId = new JTextField();
		broncoId.setColumns(10);
		broncoId.setBounds(212, 225, 179, 20);
		add(broncoId);
	}
}

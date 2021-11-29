package src.rec_center_desktop.model;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JTextField;

import model.dataccess.UserBusiness;
import model.entities.Address;

import javax.swing.JButton;

public class ProfessorRegister extends JPanel {
	private JTextField departmentField;
	private JTextField broncoId;
	private JTextField officeField;
	private JTextField researchField;

	/**
	 * Create the panel.
	 */
	public ProfessorRegister(String fullname, String dob, String phone, Address address) {
		setLayout(null);
		
		JLabel lblProfessorRegister = new JLabel("Professor Register");
		lblProfessorRegister.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblProfessorRegister.setBounds(35, 11, 258, 46);
		add(lblProfessorRegister);
		
		departmentField = new JTextField();
		departmentField.setColumns(10);
		departmentField.setBounds(219, 87, 179, 20);
		add(departmentField);
		
		JLabel lblNewLabel_1 = new JLabel("Department");
		lblNewLabel_1.setBounds(54, 90, 136, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Office");
		lblNewLabel_1_1.setBounds(54, 129, 136, 14);
		add(lblNewLabel_1_1);
		
		officeField = new JTextField();
		officeField.setColumns(10);
		officeField.setBounds(219, 126, 179, 20);
		add(officeField);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Research");
		lblNewLabel_1_1_1_1.setBounds(54, 166, 136, 14);
		add(lblNewLabel_1_1_1_1);
		
		researchField = new JTextField();
		researchField.setColumns(10);
		researchField.setBounds(219, 163, 179, 20);
		add(researchField);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("BroncoID");
		lblNewLabel_1_1_1_2.setBounds(47, 228, 136, 14);
		add(lblNewLabel_1_1_1_2);
		
		broncoId = new JTextField();
		broncoId.setColumns(10);
		broncoId.setBounds(212, 225, 179, 20);
		add(broncoId);
		
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserBusiness ub = UserBusiness.getInstance();
				try {
					ub.createCustomer(Integer.parseInt(broncoId.getText()), Date.valueOf(dob), fullname, Integer.parseInt(phone), departmentField.getText(), officeField.getText(), researchField.getText(), address);
				} catch (Exception ex) {
					
				}
			}
		});
		registerButton.setBounds(183, 241, 89, 23);
		add(registerButton);
		
	}

}

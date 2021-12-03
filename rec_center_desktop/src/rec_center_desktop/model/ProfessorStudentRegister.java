package src.rec_center_desktop.model;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import model.dataccess.MessageException;
import model.dataccess.UserBusiness;
import model.entities.Address;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class ProfessorStudentRegister extends JPanel {
	private JTextField department;
	private JTextField office;
	private JTextField research;
	private JTextField minor;
	private JTextField major;
	private JTextField gradDate;
	private JTextField enterDate;
	private JTextField broncoId;

	/**
	 * Create the panel.
	 */
	public ProfessorStudentRegister(JFrame contentFrame, String fullname, String dob, String phone, Address address) {
		setLayout(null);
		
		JPanel thisPanel = this;
		
		JLabel lblProfessorRegister = new JLabel("Professor/Student Register");
		lblProfessorRegister.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblProfessorRegister.setBounds(0, 4, 440, 33);
		add(lblProfessorRegister);
		
		department = new JTextField();
		department.setColumns(10);
		department.setBounds(225, 141, 179, 20);
		add(department);
		
		JLabel lblNewLabel_1 = new JLabel("Department");
		lblNewLabel_1.setBounds(60, 144, 136, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Office");
		lblNewLabel_1_1.setBounds(60, 172, 136, 14);
		add(lblNewLabel_1_1);
		
		office = new JTextField();
		office.setColumns(10);
		office.setBounds(225, 169, 179, 20);
		add(office);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Research");
		lblNewLabel_1_1_1_1.setBounds(60, 201, 136, 14);
		add(lblNewLabel_1_1_1_1);
		
		research = new JTextField();
		research.setColumns(10);
		research.setBounds(225, 198, 179, 20);
		add(research);
		
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserBusiness ub = UserBusiness.getInstance();
				try {
					ub.createCustomer(Integer.parseInt(broncoId.getText()), Date.valueOf(dob), fullname, Integer.parseInt(phone), Date.valueOf(enterDate.getText()), Date.valueOf(gradDate.getText()), major.getText(), minor.getText(), department.getText(), office.getText(), research.getText(), address);
					Login login = new Login(contentFrame);
					login.setVisible(true);
					thisPanel.setVisible(false);
					contentFrame.remove(thisPanel);
					contentFrame.setContentPane(login);
				} catch (Exception ex) {
					throw new MessageException("Customer registration failed");
				}
			}
		});
		registerButton.setBounds(183, 253, 89, 23);
		add(registerButton);
		
		minor = new JTextField();
		minor.setColumns(10);
		minor.setBounds(225, 113, 179, 20);
		add(minor);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Major");
		lblNewLabel_1_1_1_1_1.setBounds(60, 90, 136, 14);
		add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Minor");
		lblNewLabel_1_1_1.setBounds(60, 116, 136, 14);
		add(lblNewLabel_1_1_1);
		
		major = new JTextField();
		major.setColumns(10);
		major.setBounds(225, 87, 179, 20);
		add(major);
		
		gradDate = new JTextField();
		gradDate.setColumns(10);
		gradDate.setBounds(225, 61, 179, 20);
		add(gradDate);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Grad Date");
		lblNewLabel_1_1_2.setBounds(60, 65, 136, 14);
		add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Enter Date");
		lblNewLabel_1_2.setBounds(60, 37, 136, 14);
		add(lblNewLabel_1_2);
		
		enterDate = new JTextField();
		enterDate.setColumns(10);
		enterDate.setBounds(225, 34, 179, 20);
		add(enterDate);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("BroncoId");
		lblNewLabel_1_1_1_1_2.setBounds(60, 229, 136, 14);
		add(lblNewLabel_1_1_1_1_2);
		
		broncoId = new JTextField();
		broncoId.setColumns(10);
		broncoId.setBounds(225, 226, 179, 20);
		add(broncoId);
		
	}
}

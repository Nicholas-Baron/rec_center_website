package rec_center_desktop.model;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import model.dataccess.ReservationBusiness;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentRegister extends JPanel {
	private JTextField enterDateField;
	private JTextField gradDateField;
	private JTextField minorField;
	private JTextField majorField;

	/**
	 * Create the panel.
	 */
	public StudentRegister() {
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
				ReservationBusiness resBusiness = ReservationBusiness.getInstance();
				resBusiness.makeReservation("bob", "2021-12-12 09:30:00.000");
			}
		});
		registerButton.setBounds(178, 225, 89, 23);
		add(registerButton);

	}
}

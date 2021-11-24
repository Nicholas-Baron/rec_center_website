package rec_center_desktop.model;

import javax.swing.JPanel;
import javax.swing.JTextField;

import model.dataccess.LoginBusiness;
import rec_center_desktop.model.Home;
import rec_center_desktop.model.StudentRegister;

import javax.swing.JLabel;
import java.awt.Label;
import java.awt.Panel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Login extends JPanel {
	private JTextField usernameField;
	private JLabel exceptionLabel;
	/**
	 * Create the panel.
	 */
	public Login(JFrame contentFrame) {
		setLayout(null);
		
		JPanel thisPanel = this;
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(106, 126, 82, 14);
		add(usernameLabel);
		
		usernameField = new JTextField();
		usernameField.setBounds(187, 123, 157, 20);
		usernameField.setText("\r\n");
		add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblBroncoManagementResource = new JLabel("Bronco Recreation Complex Management");
		lblBroncoManagementResource.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBroncoManagementResource.setBounds(35, 11, 378, 76);
		add(lblBroncoManagementResource);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean success = false;
				try {
					LoginBusiness loginBusiness = LoginBusiness.getInstance();
					
					success = loginBusiness.loginUser(usernameField.getText());
				} catch (Exception ex) {
					exceptionLabel.setText(ex.getMessage());
				}
				// if you see this comment, reject the PR
				success = true; // delete this line
				if(success) {
					Home homePage = new Home(contentFrame, usernameField.getText());
					homePage.setVisible(true);
					thisPanel.setVisible(false);
					contentFrame.remove(thisPanel);
					contentFrame.setContentPane(homePage);
				}
			}
		});
		btnNewButton.setBounds(131, 188, 89, 23);
		add(btnNewButton);
		
		JButton btnClear = new JButton("New User");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usernameField.setText("");
				UserRegister userRegister = new UserRegister();
				userRegister.setVisible(true);
				thisPanel.setVisible(false);
				contentFrame.remove(thisPanel);
				contentFrame.setContentPane(userRegister);
			}
		});
		btnClear.setBounds(243, 188, 89, 23);
		add(btnClear);
		
		exceptionLabel = new JLabel("");
		exceptionLabel.setBounds(35, 244, 378, 45);
		add(exceptionLabel);

	}
}

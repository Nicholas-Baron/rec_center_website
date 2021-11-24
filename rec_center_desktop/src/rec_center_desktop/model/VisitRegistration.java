package rec_center_desktop.model;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.text.DateFormatter;
import javax.swing.text.MaskFormatter;

import javax.swing.JFormattedTextField;
import javax.swing.border.EtchedBorder;
import java.text.Format;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;

public class VisitRegistration extends JPanel {
	private JFormattedTextField dateField;
	private JFormattedTextField timeField;

	/**
	 * Create the panel.
	 */
	public VisitRegistration(String currentUser) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Visit");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(35, 11, 256, 46);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(81, 52, 290, 92);
		add(panel);
		panel.setLayout(null);
		
		JLabel dateLabel = new JLabel("Date: ");
		dateLabel.setBounds(8, 8, 41, 14);
		panel.add(dateLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Time:");
		lblNewLabel_1.setBounds(8, 33, 41, 14);
		panel.add(lblNewLabel_1);
		DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		DateFormatter df = new DateFormatter(format);
		dateField = new JFormattedTextField(df);
		dateField.setBounds(71, 5, 209, 20);
		Calendar cal = Calendar.getInstance();
		cal.set(2021, 01, 01);
		dateField.setValue(cal.getTime());
		
		panel.add(dateField);

		DateFormat tf = new SimpleDateFormat("HH:mm");
		tf.setTimeZone(TimeZone.getTimeZone("GMT"));
		timeField = new JFormattedTextField(tf);
		timeField.setBounds(71, 30, 209, 20);
		panel.add(timeField);
		
		JLabel customerLabel = new JLabel("Customer:");
		customerLabel.setBounds(8, 65, 66, 14);
		panel.add(customerLabel);
		
		Vector<String> comboBoxItems = new Vector<String>();
		comboBoxItems.add(currentUser);
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(comboBoxItems);
		JComboBox<String> comboBox = new JComboBox<String>(model);
		comboBox.setBounds(71, 61, 209, 22);
		panel.add(comboBox);
		
		JLabel lblAddActivities = new JLabel("Add Activities");
		lblAddActivities.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblAddActivities.setBounds(35, 145, 256, 46);
		add(lblAddActivities);
		
		JList list = new JList();
		list.setBounds(378, 202, -296, 61);
		add(list);
		
		JLabel lblNewLabel_2 = new JLabel("Treadmill");
		lblNewLabel_2.setBounds(117, 214, 46, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Pool");
		lblNewLabel_2_1.setBounds(117, 189, 46, 14);
		add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Weightlifting");
		lblNewLabel_2_2.setBounds(117, 239, 92, 14);
		add(lblNewLabel_2_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(85, 189, 10, 10);
		add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1.setBounds(85, 210, 10, 10);
		add(panel_1_1);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1_1.setBounds(85, 236, 10, 10);
		add(panel_1_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("$5");
		lblNewLabel_2_1_1.setBounds(200, 185, 46, 14);
		add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("$2");
		lblNewLabel_2_1_1_1.setBounds(200, 210, 46, 14);
		add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("$3");
		lblNewLabel_2_1_1_1_1.setBounds(200, 235, 46, 14);
		add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("See Price History");
		lblNewLabel_3.setBounds(285, 188, 86, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("See Price History");
		lblNewLabel_3_1.setBounds(285, 210, 86, 14);
		add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("See Price History");
		lblNewLabel_3_2.setBounds(285, 235, 86, 14);
		add(lblNewLabel_3_2);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(282, 266, 89, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Total Price After Discount:");
		lblNewLabel_4.setBounds(35, 270, 128, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("$00");
		lblNewLabel_5.setBounds(200, 270, 46, 14);
		add(lblNewLabel_5);
			
	}
}

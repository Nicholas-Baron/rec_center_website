package src.rec_center_desktop.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.dataccess.ActivityBusiness;
import model.dataccess.ReservationBusiness;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class AnayticsPage extends JPanel {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public AnayticsPage(JFrame contentFrame, String userName) {
		setLayout(null);

		JPanel thisPanel = this;

		textField = new JTextField();
		textField.setBounds(115, 58, 97, 20);
		textField.setText("2019-01-01");
		add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(287, 58, 97, 20);
		textField_1.setText("2022-01-01");
		add(textField_1);

		String[] columnNames = { "Visit Date", "Total" };

		Date start = Date.valueOf(textField.getText());
		Date end = Date.valueOf(textField_1.getText());

		List<Object[]> dataStrings = ReservationBusiness.getInstance().getOrdersBetween(start, end).stream()
				.filter(o -> o.getCustomer().getName().equals(userName))
				.map(o -> new Object[] { o.getDatetime(), o.getTotalAfterDiscount() }).collect(Collectors.toList());

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 259, 341, -197);
		add(scrollPane);

		table = new JTable(Arrays.copyOf(dataStrings.toArray(), dataStrings.size(), Object[][].class), columnNames);
		add(table);
		table.setBounds(56, 111, 328, 151);

		JButton btnReturnHome = new JButton("Return Home");
		btnReturnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home homePage = new Home(contentFrame, userName);
				homePage.setVisible(true);
				thisPanel.setVisible(false);
				contentFrame.remove(thisPanel);
				contentFrame.setContentPane(homePage);
			}
		});
		btnReturnHome.setBounds(271, 11, 148, 23);
		add(btnReturnHome);

		JLabel lblNewLabel = new JLabel("To:");
		lblNewLabel.setBounds(66, 61, 46, 14);
		add(lblNewLabel);

		JLabel lblFrom = new JLabel("From:");
		lblFrom.setBounds(239, 61, 46, 14);
		add(lblFrom);

		JButton btnUpdate = new JButton("Update");
		
		 btnUpdate.addActionListener(new ActionListener() { public void
		 actionPerformed(ActionEvent e) {
		 
		 List<Object[]> data = ReservationBusiness.getInstance().getOrdersBetween(Date.valueOf(textField.
		 getText()), Date.valueOf(textField_1.getText())).stream() .filter(o ->
		 o.getCustomer().getName().equals(userName)) .map(o -> new Object[] {
		 o.getDatetime(), o.getTotalAfterDiscount() }) .collect(Collectors.toList());
		 
		 table = new JTable(Arrays.copyOf(data.toArray(), data.size(),
		 Object[][].class), columnNames); }
		  
		  
		 });
		 
		btnUpdate.setBounds(286, 82, 99, 23);
		add(btnUpdate);

		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(239, 273, 46, 14);
		add(lblTotal);

		JLabel total = new JLabel("");
		total.setBounds(338, 273, 46, 14);
		add(total);
		
		

	}

}

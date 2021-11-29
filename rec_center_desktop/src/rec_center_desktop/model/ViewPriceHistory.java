package src.rec_center_desktop.model;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;

import model.dataccess.ActivityBusiness;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;

public class ViewPriceHistory extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ViewPriceHistory(JFrame contentFrame, String currentUser, String activity) {

			JPanel thisPanel = this;
			setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Price History for: ");
			lblNewLabel.setBounds(10, 11, 216, 54);
			add(lblNewLabel);
			
			String[] columnNames = { "Price", "Date" };

			List<Object[]> priceHistory = ActivityBusiness.getInstance().getPriceHistory(activity)
							.stream().map(p -> new Object[] {}).collect(Collectors.toList());
			
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setBounds(158, 11, 194, 54);
			add(lblNewLabel_1);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(41, 226, 369, -148);
			add(scrollPane);

			table = new JTable(Arrays.copyOf(priceHistory.toArray(), priceHistory.size(),
							Object[][].class), columnNames);
			table.setBounds(41, 226, 369, -148);
			add(table);
			
			JButton btnNewButton = new JButton("Return to Home");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton.setBounds(179, 253, 89, 23);
			add(btnNewButton);
	}

}

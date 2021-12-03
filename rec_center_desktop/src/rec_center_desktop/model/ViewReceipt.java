package src.rec_center_desktop.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
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
import model.dataccess.UserBusiness;
import model.entities.Discount;
import model.entities.Order;
import model.entities.RecreationalActivity;

import javax.swing.JLabel;
import java.awt.Font;

public class ViewReceipt extends JPanel {
	 private JTable table;

	/**
	 * Create the panel.
	 *
	 * @param o
	 */
	public ViewReceipt(JFrame contentFrame, String currentUser, Order o) {
setLayout(null);
		
		JPanel thisPanel = this;

		String[] columnNames = { "Activity", "Price" };

		List<Object[]> dataStrings = o.getActivities().stream()
						.map(a -> new Object[] { a.getName(), a.getPrice().toPlainString() })
						.collect(Collectors.toList());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 259, 341, -197);
		add(scrollPane);
		
		table = new JTable(Arrays.copyOf(dataStrings.toArray(), dataStrings.size(), Object[][].class), columnNames);
		add(table);
		table.setBounds(56, 89, 322, 80);
		
		JButton btnReturnHome = new JButton("Return to View Visits");
		btnReturnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisitsView vv = new VisitsView(contentFrame, currentUser);
				vv.setVisible(true);
				thisPanel.setVisible(false);
				contentFrame.remove(thisPanel);
				contentFrame.setContentPane(vv);
			}
		});
		btnReturnHome.setBounds(220, 248, 200, 23);
		add(btnReturnHome);
		
		JLabel lblNewLabel = new JLabel("Receipt for Visit on:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(10, 21, 273, 23);
		add(lblNewLabel);
		
		JLabel dateLabel = new JLabel("");
		dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		dateLabel.setBounds(199, 21, 241, 22);
		dateLabel.setText(o.getDatetime().toString());
		add(dateLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Visit Total:");
		lblNewLabel_1.setBounds(247, 183, 76, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Discount:");
		lblNewLabel_1_1.setBounds(251, 204, 76, 14);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Total With Discount:");
		lblNewLabel_1_1_1.setBounds(199, 223, 121, 14);
		add(lblNewLabel_1_1_1);
		
		JLabel total = new JLabel("");
		total.setBounds(333, 183, 46, 14);
		BigDecimal cost = new BigDecimal(0);
		for(RecreationalActivity a: o.getActivities()) {
			 cost = cost.add(a.getPrice());
		}
		total.setText(cost.toPlainString());
		add(total);
		
		JLabel discount = new JLabel("");
		discount.setBounds(333, 204, 46, 14);
		BigDecimal d = ReservationBusiness.getInstance().getDiscount(o.getCustomer().getType());
		discount.setText(d.toPlainString() + " %");
		add(discount);
		
		JLabel totalWithDiscount = new JLabel("");
		totalWithDiscount.setBounds(333, 223, 46, 14);
		totalWithDiscount.setText(o.getTotalAfterDiscount().toPlainString());
		add(totalWithDiscount);
		
	}
	
	

}

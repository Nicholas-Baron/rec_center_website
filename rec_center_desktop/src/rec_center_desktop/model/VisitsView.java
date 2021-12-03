package src.rec_center_desktop.model;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;

import model.dataccess.ActivityBusiness;
import model.dataccess.ReservationBusiness;
import model.entities.Order;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;

public class VisitsView extends JPanel {


		public VisitsView(JFrame contentFrame, String userName) {
			JTable table;
			setLayout(null);
			
			JPanel thisPanel = this;

			String[] columnNames = { "Date", "Status" };

			List<Order> data = ReservationBusiness.getInstance().getReservations(userName);
			
			List<Object[]> dataStrings = data.stream()
							.map(a -> new Object[] { a.getDatetime(), a.getStatus() })
							.collect(Collectors.toList());

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(56, 259, 341, -197);
			add(scrollPane);
			
			table = new JTable(Arrays.copyOf(dataStrings.toArray(), dataStrings.size(), Object[][].class), columnNames);
			add(table);
			table.setBounds(56, 89, 322, 80);
			
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
			btnReturnHome.setBounds(145, 259, 148, 23);
			add(btnReturnHome);
			
			JLabel lblNewLabel = new JLabel("Viewing Visits for: ");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel.setBounds(10, 11, 130, 48);
			add(lblNewLabel);
			
			JLabel nameLabel = new JLabel(userName);
			nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			nameLabel.setBounds(145, 11, 263, 48);
			add(nameLabel);
			
			JButton btnViewReceipts = new JButton("View Receipt");
			btnViewReceipts.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (table.getSelectedRowCount() < 1)
						return;
					Order o = data.get(table.getSelectedRow());
					System.out.println(o.getActivities());
					ViewReceipt vr = new ViewReceipt(contentFrame, userName, o);
					vr.setVisible(true);
					thisPanel.setVisible(false);
					contentFrame.remove(thisPanel);
					contentFrame.setContentPane(vr);
				}
			});
			btnViewReceipts.setBounds(56, 221, 148, 23);
			add(btnViewReceipts);
			
			JButton btnViewAnalytics = new JButton("View Analytics");
			btnViewAnalytics.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AnayticsPage vr = new AnayticsPage(contentFrame, userName);
					vr.setVisible(true);
					thisPanel.setVisible(false);
					contentFrame.remove(thisPanel);
					contentFrame.setContentPane(vr);
				}
			});
			btnViewAnalytics.setBounds(230, 55, 148, 23);
			add(btnViewAnalytics);
			
			JButton btnCompleteVisit = new JButton("Complete Visit");
			btnCompleteVisit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (table.getSelectedRowCount() < 1)
						return;
					ReservationBusiness rb = ReservationBusiness.getInstance();
					table.setValueAt("OnlineComplete", table.getSelectedRow(), 1);
				}
			});
			btnCompleteVisit.setBounds(240, 221, 148, 23);
			add(btnCompleteVisit);
		}
		
	}



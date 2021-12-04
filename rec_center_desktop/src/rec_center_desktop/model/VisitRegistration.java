package src.rec_center_desktop.model;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.Vector;
import java.util.stream.Collectors;

import javax.swing.*;
import javax.swing.DefaultListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;

import model.dataccess.ActivityBusiness;
import model.dataccess.ReservationBusiness;
import model.entities.OrderStatus;

/** @see http://stackoverflow.com/questions/4526779 */
public class VisitRegistration extends JPanel {

    private static final int CHECK_COL = 0;
	
    private static final String[] COLUMNS = {"Checked", "Activity", "Price"};
    private DataModel dataModel;
    private DefaultListSelectionModel selectionModel; 
    
    private JFormattedTextField dateField;
	private JFormattedTextField timeField;
	public JLabel TotalPrice;
    private double totalPrice = 0;
	
	private JPanel thisPanel = this;

    public VisitRegistration(JFrame contentFrame, String currentUser) {
        
        List<Object[]> dataStrings = ActivityBusiness.getInstance().getActivities().stream()
				.map(a -> new Object[] { Boolean.FALSE, a.getName(), a.getPrice().toPlainString() })
				.collect(Collectors.toList());
        
        dataModel = new DataModel(Arrays.copyOf(dataStrings.toArray(), dataStrings.size(), Object[][].class), COLUMNS);

        JTable table = new JTable(dataModel);
    	DefaultListSelectionModel selectionModel;
        setLayout(null);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 143, 430, 119);
        this.add(scrollPane);
        this.add(new ControlPanel(), BorderLayout.SOUTH);
        table.setPreferredScrollableViewportSize(new Dimension(250, 175));
        selectionModel = (DefaultListSelectionModel) table.getSelectionModel();
        
        JLabel lblNewLabel = new JLabel("New Visit");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 11, 252, 29);
		add(lblNewLabel);
		JLabel dateLabel = new JLabel("Date: ");
		dateLabel.setBounds(93, 54, 41, 14);
		this.add(dateLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Time:");
		lblNewLabel_1.setBounds(93, 79, 41, 14);
		this.add(lblNewLabel_1);
		DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		DateFormatter df = new DateFormatter(format);
		dateField = new JFormattedTextField(df);
		dateField.setBounds(156, 51, 209, 20);
		Calendar cal = Calendar.getInstance();
		cal.set(2021, 01, 01);
		dateField.setValue(cal.getTime());
		
		this.add(dateField);

		DateFormat tf = new SimpleDateFormat("HH:mm");
		tf.setTimeZone(TimeZone.getTimeZone("GMT"));
		timeField = new JFormattedTextField(tf);
		timeField.setText("12:00");
		timeField.setBounds(156, 76, 209, 20);
		this.add(timeField);
		
		JLabel customerLabel = new JLabel("Customer:");
		customerLabel.setBounds(93, 111, 66, 14);
		this.add(customerLabel);
		
		Vector<String> comboBoxItems = new Vector<String>();
		comboBoxItems.add(currentUser);
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(comboBoxItems);
		JComboBox<String> comboBox = new JComboBox<String>(model);
		comboBox.setBounds(156, 107, 209, 22);
		this.add(comboBox);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReservationBusiness res = ReservationBusiness.getInstance();
				String date = dateField.getText().trim();
				String time = timeField.getText().trim();
				String dateTime = date + "T" + time;
				List<String> activities = new ArrayList<String>();
				for (int i = 0; i < table.getRowCount(); i++) {
					if (table.getValueAt(i, 0).equals(Boolean.TRUE)) {
						activities.add(dataStrings.get(i)[1].toString());
					}
				}
				try {
					res.makeReservation(currentUser, dateTime, activities, OrderStatus.Counter);
					VisitSuccess vs = new VisitSuccess(contentFrame, currentUser);
					vs.setVisible(true);
					thisPanel.setVisible(false);
					contentFrame.remove(thisPanel);
					contentFrame.setContentPane(vs);
				} catch (Exception ex){
					System.out.println(ex.getMessage());
				}
			}
		});
		btnNewButton.setBounds(192, 266, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Return Home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home h = new Home(contentFrame, currentUser);
				h.setVisible(true);
				thisPanel.setVisible(false);
				contentFrame.remove(thisPanel);
				contentFrame.setContentPane(h);
			}
		});
		btnNewButton_1.setBounds(272, 11, 149, 23);
		add(btnNewButton_1);
		
		
		
		
    }

    private class DataModel extends DefaultTableModel {

        public DataModel(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == CHECK_COL) {
                return getValueAt(0, CHECK_COL).getClass();
            }
            return super.getColumnClass(columnIndex);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return column == CHECK_COL;
        }
    }

    private class ControlPanel extends JPanel {

        public ControlPanel() {
            this.add(new JLabel("Selection:"));
            this.add(new JButton(new SelectionAction("Clear", false)));
            this.add(new JButton(new SelectionAction("Check", true)));
        }
    }

    private class SelectionAction extends AbstractAction {

        boolean value;
        public SelectionAction(String name, boolean value) {
            super(name);
            this.value = value;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < dataModel.getRowCount(); i++) {
                if (selectionModel.isSelectedIndex(i)) {
                	totalPrice = totalPrice + Double.parseDouble((String) dataModel.getValueAt(i, 2)) ;
                    dataModel.setValueAt(value, i, CHECK_COL);
                    TotalPrice.setText("$" + totalPrice);
                    TotalPrice.updateUI();
                }
            }
        }
    }
}
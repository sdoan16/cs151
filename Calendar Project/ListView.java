import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ListView implements ChangeListener{
	
	public enum MONTHS {
		January, February, March, April, May, June, July, August, September, October, November, December;
	}
	
	public enum DAYS {
		Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday;
	}
	
	
	private CalendarModel cm;
	//private int maxDays;
	private DAYS[] arrayofDays = DAYS.values();
	private MONTHS[] arrayOfMonths = MONTHS.values();
	private JFrame frame = new JFrame("Calendar");
	private DefaultListModel<String>  lbm = new DefaultListModel<String>();
	private JList list = new JList(lbm);
	private JScrollPane scroller;
	private JLabel dateLabel = new JLabel();
	private int selected;
	//private GregorianCalendar cal = new GregorianCalendar();
	JTextField eventText = new JTextField(25);
	
	
	public ListView(CalendarModel cm)
	{
		
		this.cm = cm;
		//maxDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		JPanel buttonPanel = new JPanel();
		JButton add = new JButton("Add Task");
		JButton delete = new JButton("Delete Task");
		JButton edit = new JButton("Edit Task");
		JButton monthly = new JButton("Monthly Tasks");
		JButton export = new JButton("Export");
		
		buttonPanel.add(add);
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				createEvent();
			}
			
		});
		buttonPanel.add(delete);
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				deleteEvent();
			}	
		});
		buttonPanel.add(edit);
		edit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String str = eventText.getText();
				editEvent(str);
			}
			
		});
		
		buttonPanel.add(monthly);
		monthly.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				showMonth();
			}
			
		});
		
		buttonPanel.add(export);
		export.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					PrintWriter output = new PrintWriter(arrayOfMonths[cm.getCurrentMonth()] + "-" + cm.getDay() + "-" + cm.getCurrentYear()+".txt");
					output.println("Tasks for: " + arrayOfMonths[cm.getCurrentMonth()] + "-" + cm.getDay() + "-" + cm.getCurrentYear() + "\n");
					for(int i = 0; i < lbm.size(); i++) {
						output.println(lbm.get(i));
					}
					output.flush();
					output.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				
			}
			
		});

		frame.setLayout(new FlowLayout());
		list.setLayout(new FlowLayout());
		
		list.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				selected = list.getSelectedIndex();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		dateLabel.setText((arrayOfMonths[cm.getCurrentMonth()] + "-" + cm.getDay() + "-" + cm.getCurrentYear()));
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setPreferredSize(new Dimension(300,200));
		frame.add(dateLabel);
		JScrollPane spane = new JScrollPane();
		spane.setViewportView(list);
		spane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(spane);
		frame.add(panel);
		frame.add(eventText);
		frame.add(buttonPanel);
		frame.setPreferredSize(new Dimension(600, 370));
		frame.setLocation(710, 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		
		
		
	}
	
	private void createEvent() {
		cm.createEvent(eventText.getText());	
		eventText.setText("");
		showDate(cm.getSelectedDay());
		};
		
	private void showMonth() {
		showMonth(cm.getSelectedMonth());
	}
		
	private void deleteEvent() {
		try {
		cm.removeEvent(selected);
		showDate(cm.getSelectedDay());
		}
		catch (Exception e) {};
		
	}
	
	private void editEvent(String str) {
		try {
		cm.editEvent(selected, str);
		showDate(cm.getSelectedDay());
		}
		catch (Exception e) {};
	}
	
	public void showDate(final int d) {
		cm.setDay(d);
		dateLabel.setText((arrayofDays[cm.getDayOfWeek(d) - 1] + ", " + arrayOfMonths[cm.getCurrentMonth()] + "-" + cm.getDay() + "-" + cm.getCurrentYear()));
		String date = (cm.getCurrentMonth() + 1) + "/" + d + "/" + cm.getCurrentYear();
		ArrayList<String> eventsMap = new ArrayList<>();
		ArrayList<CalendarModel.Event> eventMaps = new ArrayList<CalendarModel.Event>();
		lbm.clear();
		if (cm.hasEvent(date)) {
			cm.printEvent(date);
			eventMaps = cm.getEvents(date);
			for(int i = 0; i < eventMaps.size(); i++) {
				eventsMap.add(eventMaps.get(i).toString());
			}
			
			for(int j = 0; j < eventsMap.size(); j++) {
				lbm.addElement(eventsMap.get(j));
			}
		}
	}
	
	public void showMonth(final int d) {
		cm.setMonth(d);
		dateLabel.setText(("Tasks for " + arrayOfMonths[cm.getCurrentMonth()] + " : "));
		//String date = (cm.getCurrentMonth() + 1) + "/" + d + "/" + cm.getCurrentYear();
		ArrayList<String> eventsMap = new ArrayList<>();
		ArrayList<CalendarModel.Event> eventMaps = new ArrayList<CalendarModel.Event>();
		lbm.clear();
		int month = cm.getCurrentMonth() + 1;
		System.out.println(month);
		System.out.println(cm.getCurrentMonth());
		System.out.println(cm.getSelectedDay());
		
		for (int i=1; i <= cm.getMaxDays(); i++)
		{
			String date = (cm.getCurrentMonth() + 1) + "/" + i + "/" + cm.getCurrentYear();
			if (cm.hasEvent(date)) {
				//cm.printEvent(date);
				eventMaps = cm.getEvents(date);
				for(int k = 0; k < eventMaps.size(); k++) {
					eventsMap.add(eventMaps.get(k).toString());
				}
				
				
				
			}
			
			
		}
		
		for(int j = 0; j < eventsMap.size(); j++) {
			lbm.addElement(eventsMap.get(j));
		}
			
				
				
			}
		
			
		
	
	
	
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}


}

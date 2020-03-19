package fitness_tracker;

import java.awt.*;
import javax.swing.*;
import javax.swing.RowSorter.SortKey;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TabExpander;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

public class Gui extends JFrame {

	private JPanel contentPane;
	private JTextField txtTime;
	private JButton btnSaveRec;
	private JButton btnShowRec;
	private JPanel Main;
	private JPanel Records;
	private JComboBox comboBox;
	private JTextField txtShowTotalCal;
	private JTextField txtShowTotalHeart;
	private JButton btnBack;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gui() {
		Activities activity =new Activities();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Fitness tracker");
		setLocationRelativeTo(null);   //Center window 
				
				Main = new JPanel();
				Main.setBounds(0, 0, 434, 261);
				contentPane.add(Main);
				Main.setBorder(new EmptyBorder(5, 5, 5, 5));
				Main.setBackground(new Color(240, 240, 240));
				Main.setLayout(null);
				
				JLabel lblFitnessTracker = new JLabel("Fitness tracker");
				lblFitnessTracker.setHorizontalAlignment(SwingConstants.CENTER);
				lblFitnessTracker.setForeground(Color.RED);
				lblFitnessTracker.setFont(new Font("Tahoma", Font.PLAIN, 21));
				lblFitnessTracker.setBounds(146, 11, 136, 20);
				Main.add(lblFitnessTracker);
				
				JLabel lblNewLabel = new JLabel("Choose activity type :");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblNewLabel.setBounds(10, 68, 136, 19);
				Main.add(lblNewLabel);
				
				comboBox = new JComboBox();
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"Swimming", "Running", "Kick boxing", "Strenth training"}));
				comboBox.setSelectedIndex(0);
				comboBox.setBounds(194, 69, 116, 20);
				Main.add(comboBox);
				
				JLabel lblEnterTimeOf = new JLabel("Enter time of activity :");
				lblEnterTimeOf.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblEnterTimeOf.setBounds(10, 112, 136, 19);
				Main.add(lblEnterTimeOf);
				
				txtTime = new JTextField();
				txtTime.setColumns(10);
				txtTime.setBounds(194, 111, 116, 20);
				Main.add(txtTime);
				
				btnSaveRec = new JButton("Save record");
				btnSaveRec.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int time=0;
						try {
						 time=Integer.parseInt(txtTime.getText());
							if(comboBox.getSelectedIndex()==0)
							{
								activity.swim(time);
							}
							else if(comboBox.getSelectedIndex()==1)
							{
								activity.run(time);
							}
							else if(comboBox.getSelectedIndex()==2)
							{
								activity.boxing(time);
							}
							else if(comboBox.getSelectedIndex()==3)
							{
								activity.strenth_training(time);
							}
							
							JOptionPane.showMessageDialog(btnSaveRec, "Acrivity done");

							txtTime.setText("");
							
							

						 }
						catch(Exception E)
						{
							JOptionPane.showMessageDialog(btnSaveRec, "Wrong input.Please try again");
							txtTime.setText("");

						}
						txtShowTotalCal.setText(String.valueOf((float)activity.getTotalcalories()));
						txtShowTotalHeart.setText(String.valueOf((float)activity.getTotalHeartRate()));
						DefaultTableModel tb1 = (DefaultTableModel) table.getModel(); 
						/*Object Swimdata []= {"Swimming",activity.getSwimCalories(),activity.getSwimHeartRate()};
						Object Rundata []={"Running",activity.getRunCalories(),activity.getRunHeartRate()};
						Object 	Boxdata[]={"Boxing",activity.getBoxCalories(),activity.getBoxHeartRate()};
						Object Traindata[]={"Strenth training",activity.getTrainCalories(),activity.getTrainHeartRate()};
						tb1.addRow(Swimdata); tb1.addRow(Rundata); tb1.addRow(Boxdata); tb1.addRow(Traindata);*/
						tb1.setValueAt(activity.getSwimCalories(), 0, 1);
						tb1.setValueAt(activity.getSwimHeartRate(), 0, 2);
						tb1.setValueAt(activity.getRunCalories(), 1, 1);
						tb1.setValueAt(activity.getRunHeartRate(), 1, 2);
						tb1.setValueAt(activity.getBoxCalories(), 2, 1);
						tb1.setValueAt(activity.getBoxHeartRate(), 2, 2);
						tb1.setValueAt(activity.getTrainCalories(), 3, 1);
						tb1.setValueAt(activity.getTrainHeartRate(), 3, 2);
					
					
					}
				});
				btnSaveRec.setFont(new Font("Tahoma", Font.PLAIN, 12));
				btnSaveRec.setBounds(65, 163, 100, 23);
				Main.add(btnSaveRec);
				
				btnShowRec = new JButton("Show record");
				btnShowRec.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Main.setVisible(false);
						Records.setVisible(true);
						

						
						
						
						
						
						
						
						
					}
				});
				btnShowRec.setFont(new Font("Tahoma", Font.PLAIN, 12));
				btnShowRec.setBounds(248, 163, 116, 23);
				Main.add(btnShowRec);
				
				JLabel lblMinutes = new JLabel("minutes");
				lblMinutes.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblMinutes.setBounds(320, 112, 46, 18);
				Main.add(lblMinutes);
				
					
					Records = new JPanel();
					Records.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
					Records.setBounds(0, 0, 434, 261);
					contentPane.add(Records);
					Records.setLayout(null);
					Records.setVisible(false);
					
					JLabel lbl = new JLabel("Total Calories :");
					lbl.setFont(new Font("Dialog", Font.BOLD, 13));
					lbl.setHorizontalAlignment(SwingConstants.CENTER);
					lbl.setBounds(12, 12, 104, 16);
					Records.add(lbl);
					
					JLabel lbl2 = new JLabel("Total heart rate :");
					lbl2.setHorizontalAlignment(SwingConstants.CENTER);
					lbl2.setFont(new Font("Dialog", Font.BOLD, 13));
					lbl2.setBounds(12, 43, 117, 16);
					Records.add(lbl2);
					
					txtShowTotalCal = new JTextField();
					txtShowTotalCal.setBackground(Color.WHITE);
					txtShowTotalCal.setEditable(false);
					txtShowTotalCal.setHorizontalAlignment(SwingConstants.CENTER);
					txtShowTotalCal.setBounds(158, 10, 86, 20);
					Records.add(txtShowTotalCal);
					txtShowTotalCal.setColumns(10);
					
					txtShowTotalHeart = new JTextField();
					txtShowTotalHeart.setBackground(Color.WHITE);
					txtShowTotalHeart.setEditable(false);
					txtShowTotalHeart.setColumns(10);
					txtShowTotalHeart.setBounds(158, 41, 86, 20);
					Records.add(txtShowTotalHeart);
					
					btnBack = new JButton("Back");
					btnBack.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Records.setVisible(false);
							Main.setVisible(true);
							txtTime.setText("");
						}
					});
					btnBack.setBounds(12, 224, 98, 26);
					Records.add(btnBack);
					
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(12, 70, 412, 119);
					Records.add(scrollPane);
					
					table = new JTable();
					scrollPane.setViewportView(table);
					table.setBorder(new CompoundBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)), null), null));
					table.setFont(new Font("Dialog", Font.BOLD, 13));
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table.setToolTipText("");
					table.setRowSelectionAllowed(false);
					table.setModel(new DefaultTableModel(
						new Object[][] {
							{"Swimming", null, null},
							{"Running", null, null},
							{"Boxing", null, null},
							{"Strenth training", null, null},
						},
						new String[] {
							"Activty name", "Calories", "Heart rate increase"
						}
					) {
						Class[] columnTypes = new Class[] {
							String.class, Float.class, Float.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					});
					table.getColumnModel().getColumn(0).setPreferredWidth(122);
					table.getColumnModel().getColumn(0).setMinWidth(50);
					table.getColumnModel().getColumn(1).setPreferredWidth(122);
					table.getColumnModel().getColumn(2).setPreferredWidth(122);
					table.setAutoCreateRowSorter(true);
					
					JLabel lblBeatminute = new JLabel("beat/minute.");
					lblBeatminute.setFont(new Font("Tahoma", Font.PLAIN, 12));
					lblBeatminute.setBounds(263, 45, 80, 14);
					Records.add(lblBeatminute);
	}
}

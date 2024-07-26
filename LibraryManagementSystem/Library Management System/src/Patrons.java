import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Patrons extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtManagePatrons;
	static JTable table;
	private JTabbedPane tabbedPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtName;
	private JTextField textField_4;
	private JTextField txtEmail;
	private JTextField textField_3;
	private JTextField txtPhoneNumber;
	private JTextField textField_5;
	private JTextField txtPatronid;
	private JTextField textField_7;
	private JTextField textField_6;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patrons frame = new Patrons();
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
	public Patrons() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 10, 774, 639);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 115, 81));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_3.setBackground(new Color(191, 255, 191));
		panel_3.setBounds(0, 1, 199, 601);
		contentPane.add(panel_3);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		btnAdd.setFocusable(false);
		btnAdd.setBorder(null);
		btnAdd.setBackground(new Color(191, 255, 191));
		btnAdd.setBounds(70, 106, 99, 53);
		panel_3.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		btnUpdate.setFocusable(false);
		btnUpdate.setBorder(null);
		btnUpdate.setBackground(new Color(191, 255, 191));
		btnUpdate.setBounds(70, 191, 99, 53);
		panel_3.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		btnDelete.setFocusable(false);
		btnDelete.setBorder(null);
		btnDelete.setBackground(new Color(191, 255, 191));
		btnDelete.setBounds(70, 284, 99, 53);
		panel_3.add(btnDelete);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Patrons.class.getResource("/Images/Add.png")));
		lblNewLabel_1.setBounds(10, 109, 50, 50);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(Patrons.class.getResource("/Images/Update.png")));
		lblNewLabel_1_1.setBounds(10, 194, 50, 50);
		panel_3.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon(Patrons.class.getResource("/Images/Delete.png")));
		lblNewLabel_1_2.setBounds(10, 287, 50, 50);
		panel_3.add(lblNewLabel_1_2);
		
		JButton btnGoBack = new JButton("Go back");
		btnGoBack.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Dashboard d=new Dashboard();
				d.setVisible(true);
				dispose();
			}
		});
		btnGoBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGoBack.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		btnGoBack.setFocusable(false);
		btnGoBack.setBorder(null);
		btnGoBack.setBackground(new Color(191, 255, 191));
		btnGoBack.setBounds(70, 376, 99, 53);
		panel_3.add(btnGoBack);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("");
		lblNewLabel_1_2_1.setIcon(new ImageIcon(Patrons.class.getResource("/Images/Open Pane.png")));
		lblNewLabel_1_2_1.setBounds(10, 379, 50, 50);
		panel_3.add(lblNewLabel_1_2_1);
		
		JButton btnView = new JButton("View");
		btnView.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnView.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnView.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		btnView.setFocusable(false);
		btnView.setBorder(null);
		btnView.setBackground(new Color(191, 255, 191));
		btnView.setBounds(70, 28, 99, 53);
		panel_3.add(btnView);
		
		JLabel lblNewLabel_1_3 = new JLabel("");
		lblNewLabel_1_3.setIcon(new ImageIcon(Patrons.class.getResource("/Images/View.png")));
		lblNewLabel_1_3.setBounds(10, 31, 50, 50);
		panel_3.add(lblNewLabel_1_3);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(197, -92, 563, 694);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 115, 81));
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		
		txtManagePatrons = new JTextField();
		txtManagePatrons.setText("Manage Patrons");
		txtManagePatrons.setHorizontalAlignment(SwingConstants.CENTER);
		txtManagePatrons.setForeground(Color.WHITE);
		txtManagePatrons.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 40));
		txtManagePatrons.setFocusable(false);
		txtManagePatrons.setColumns(10);
		txtManagePatrons.setBorder(null);
		txtManagePatrons.setBackground(new Color(0, 115, 81));
		txtManagePatrons.setBounds(156, 97, 307, 59);
		panel.add(txtManagePatrons);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Patrons.class.getResource("/Images/Crowd big.png")));
		lblNewLabel.setBounds(46, 74, 100, 100);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(191, 255, 191));
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		scrollPane.setBounds(10, 209, 538, 411);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setRowHeight(30);
		table.setGridColor(new Color(0, 115, 81));
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Patron ID", "Name", "Email", "Phone"
				}
			));
		table.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 17));
		table.setBackground(new Color(191, 255, 191));
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table.setBorder(null);
		JTableHeader header=table.getTableHeader();
        header.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 19));
        header.setBackground(new Color(191, 255, 191));
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 115, 81));
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setText("Manage Patrons");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 40));
		textField.setFocusable(false);
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(new Color(0, 115, 81));
		textField.setBounds(156, 97, 307, 59);
		panel_1.add(textField);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Patrons.class.getResource("/Images/Crowd big.png")));
		lblNewLabel_2.setBounds(46, 74, 100, 100);
		panel_1.add(lblNewLabel_2);
		
		txtName = new JTextField();
		txtName.setText("Name:");
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setForeground(Color.WHITE);
		txtName.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		txtName.setFocusable(false);
		txtName.setColumns(10);
		txtName.setBorder(null);
		txtName.setBackground(new Color(0, 115, 81));
		txtName.setBounds(93, 212, 127, 40);
		panel_1.add(txtName);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 27));
		textField_4.setColumns(10);
		textField_4.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		textField_4.setBounds(103, 253, 325, 59);
		panel_1.add(textField_4);
		
		txtEmail = new JTextField();
		txtEmail.setText("Email Address:");
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setForeground(Color.WHITE);
		txtEmail.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		txtEmail.setFocusable(false);
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		txtEmail.setBackground(new Color(0, 115, 81));
		txtEmail.setBounds(93, 344, 209, 40);
		panel_1.add(txtEmail);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 27));
		textField_3.setColumns(10);
		textField_3.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		textField_3.setBounds(103, 384, 325, 59);
		panel_1.add(textField_3);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setText("Phone number:");
		txtPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
		txtPhoneNumber.setForeground(Color.WHITE);
		txtPhoneNumber.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		txtPhoneNumber.setFocusable(false);
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBorder(null);
		txtPhoneNumber.setBackground(new Color(0, 115, 81));
		txtPhoneNumber.setBounds(106, 471, 209, 40);
		panel_1.add(txtPhoneNumber);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 27));
		textField_5.setColumns(10);
		textField_5.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		textField_5.setBounds(103, 515, 325, 59);
		panel_1.add(textField_5);
		
		JButton btnAdd_1 = new JButton("");
		btnAdd_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				String name=textField_4.getText();
				String email=textField_3.getText();
				String phone=textField_5.getText();
				if(name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
					JOptionPane.showMessageDialog(Patrons.this, "Please fill all details.");
				}
				else {
					String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
					if (!email.matches(emailRegex)) {
						JOptionPane.showMessageDialog(Patrons.this, "Invalid email format.");
						return;
					}
					if (!phone.matches("\\d{11}")) {
			    		JOptionPane.showMessageDialog(Patrons.this, "Phone number should contain exactly 11 digits.");
			            return;
			        }
					
					try {
						Database d=new Database();
						d.addPatron(name,email,phone);
			    		JOptionPane.showMessageDialog(Patrons.this, "Patron added successfully.");
			    		d.showPatrons();
					} catch (SQLException e1) {
						 JOptionPane.showMessageDialog(Patrons.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

					}
					
			        
				}


			}
		});
		btnAdd_1.setIcon(new ImageIcon(Patrons.class.getResource("/Images/done.png")));
		btnAdd_1.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		btnAdd_1.setFocusable(false);
		btnAdd_1.setBorder(null);
		btnAdd_1.setBackground(new Color(0, 115, 81));
		btnAdd_1.setBounds(190, 596, 149, 59);
		panel_1.add(btnAdd_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 115, 81));
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setText("Manage Patrons");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 40));
		textField_1.setFocusable(false);
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBackground(new Color(0, 115, 81));
		textField_1.setBounds(156, 97, 307, 59);
		panel_2.add(textField_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Patrons.class.getResource("/Images/Crowd big.png")));
		lblNewLabel_3.setBounds(46, 74, 100, 100);
		panel_2.add(lblNewLabel_3);
		
		txtPatronid = new JTextField();
		txtPatronid.setText("Patron ID:");
		txtPatronid.setHorizontalAlignment(SwingConstants.CENTER);
		txtPatronid.setForeground(Color.WHITE);
		txtPatronid.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		txtPatronid.setFocusable(false);
		txtPatronid.setColumns(10);
		txtPatronid.setBorder(null);
		txtPatronid.setBackground(new Color(0, 115, 81));
		txtPatronid.setBounds(93, 212, 157, 40);
		panel_2.add(txtPatronid);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 27));
		textField_7.setColumns(10);
		textField_7.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		textField_7.setBounds(103, 253, 325, 59);
		panel_2.add(textField_7);
		
		textField_6 = new JTextField();
		textField_6.setText("What you want to update:");
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setForeground(Color.WHITE);
		textField_6.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		textField_6.setFocusable(false);
		textField_6.setColumns(10);
		textField_6.setBorder(null);
		textField_6.setBackground(new Color(0, 115, 81));
		textField_6.setBounds(93, 344, 373, 40);
		panel_2.add(textField_6);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"  Name", "  Email", "  Phone"}));
		comboBox.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 27));
		comboBox.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		comboBox.setBounds(103, 384, 325, 59);
		panel_2.add(comboBox);
		
		textField_8 = new JTextField();
		textField_8.setText("Enter new value:");
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setForeground(Color.WHITE);
		textField_8.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		textField_8.setFocusable(false);
		textField_8.setColumns(10);
		textField_8.setBorder(null);
		textField_8.setBackground(new Color(0, 115, 81));
		textField_8.setBounds(90, 472, 260, 40);
		panel_2.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 27));
		textField_9.setColumns(10);
		textField_9.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		textField_9.setBounds(103, 515, 325, 59);
		panel_2.add(textField_9);
		
		JButton btnAdd_1_1 = new JButton("");
		btnAdd_1_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				String id=textField_7.getText();
				String column=(String) comboBox.getSelectedItem();
				//column=column.toLowerCase().trim();
				String newValue=textField_9.getText();
				if(id.isEmpty() || newValue.isEmpty()) {
					JOptionPane.showMessageDialog(Patrons.this, "Please fill all details.");
				}
				else {
					if(column=="  Email") {
						String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
						if (!newValue.matches(emailRegex)) {
							JOptionPane.showMessageDialog(Patrons.this, "Invalid email format.");
							return;
						}
					}
					if(column=="  Phone") {
						if (!newValue.matches("\\d{11}")) {
				    		JOptionPane.showMessageDialog(Patrons.this, "Phone number should contain exactly 11 digits.");
				            return;
				        }
					}
					try {
						Database d=new Database();
						boolean check=d.checkPID(id);
						if(!check) {
							JOptionPane.showMessageDialog(Patrons.this, "Invalid Patron ID.");
							return;
						}
						d.updatePatron(id, column, newValue);
						JOptionPane.showMessageDialog(Patrons.this, "Patron updated successfully.");
			    		d.showPatrons();
					} catch (SQLException e1) {
						 JOptionPane.showMessageDialog(Patrons.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

					}
				}

			}
		});
		btnAdd_1_1.setIcon(new ImageIcon(Patrons.class.getResource("/Images/done.png")));
		btnAdd_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd_1_1.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		btnAdd_1_1.setFocusable(false);
		btnAdd_1_1.setBorder(null);
		btnAdd_1_1.setBackground(new Color(0, 115, 81));
		btnAdd_1_1.setBounds(190, 596, 149, 59);
		panel_2.add(btnAdd_1_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 115, 81));
		tabbedPane.addTab("New tab", null, panel_4, null);
		panel_4.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setText("Manage Patrons");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 40));
		textField_2.setFocusable(false);
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBackground(new Color(0, 115, 81));
		textField_2.setBounds(156, 97, 307, 59);
		panel_4.add(textField_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Patrons.class.getResource("/Images/Crowd big.png")));
		lblNewLabel_4.setBounds(46, 74, 100, 100);
		panel_4.add(lblNewLabel_4);
		
		textField_10 = new JTextField();
		textField_10.setText("Patron ID:");
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setForeground(Color.WHITE);
		textField_10.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		textField_10.setFocusable(false);
		textField_10.setColumns(10);
		textField_10.setBorder(null);
		textField_10.setBackground(new Color(0, 115, 81));
		textField_10.setBounds(98, 286, 157, 40);
		panel_4.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 27));
		textField_11.setColumns(10);
		textField_11.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		textField_11.setBounds(106, 337, 325, 59);
		panel_4.add(textField_11);
		
		JButton btnAdd_1_1_1 = new JButton("");
		btnAdd_1_1_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				String id=textField_11.getText();
				if(id.isEmpty()) {
					JOptionPane.showMessageDialog(Patrons.this, "Please enter Patron ID.");
				}
				else {
					try {
						Database d=new Database();
						boolean check=d.checkPID(id);
						if(!check) {
							JOptionPane.showMessageDialog(Patrons.this, "Invalid Patron ID.");
							return;
						}
						d.deletePatron(id);
						JOptionPane.showMessageDialog(Patrons.this, "Patron deleted successfully.");
						d.showPatrons();

					} catch (SQLException e1) {
						 JOptionPane.showMessageDialog(Patrons.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnAdd_1_1_1.setIcon(new ImageIcon(Patrons.class.getResource("/Images/done.png")));
		btnAdd_1_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd_1_1_1.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		btnAdd_1_1_1.setFocusable(false);
		btnAdd_1_1_1.setBorder(null);
		btnAdd_1_1_1.setBackground(new Color(0, 115, 81));
		btnAdd_1_1_1.setBounds(179, 497, 149, 59);
		panel_4.add(btnAdd_1_1_1);
		
		try {
			Database d=new Database();
			d.showPatrons();
		} catch (SQLException e1) {
			 JOptionPane.showMessageDialog(Patrons.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

		}
		
	}
}

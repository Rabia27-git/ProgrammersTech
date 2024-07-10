import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;

public class TotalInfo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEnterBelowInformation;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtEmail;
	private JTextField txtCnic;
	private JTextField txtStreet;
	private JTextField txtCity;
	private JTextField txtGender;
	private JTextField txtMaritalStatus;
	private JTextField txtAccountType;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TotalInfo frame = new TotalInfo();
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
	public TotalInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 25, 903, 645);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEnterBelowInformation = new JTextField();
		txtEnterBelowInformation.setText("ENTER BELOW INFORMATION");
		txtEnterBelowInformation.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterBelowInformation.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 50));
		txtEnterBelowInformation.setFocusable(false);
		txtEnterBelowInformation.setColumns(10);
		txtEnterBelowInformation.setBorder(null);
		txtEnterBelowInformation.setBackground(new Color(204, 204, 204));
		txtEnterBelowInformation.setBounds(146, 21, 673, 63);
		contentPane.add(txtEnterBelowInformation);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				LoginPage l=new LoginPage();
				l.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setBackground(new Color(204, 204, 204));
		btnNewButton_3.setBounds(21, 11, 115, 88);
		ImageIcon icon4=new ImageIcon(Dashboard.class.getResource("/Images/back.png"));
		btnNewButton_3.setIcon(icon4);
		contentPane.add(btnNewButton_3);
		
		txtFirstName = new JTextField();
		txtFirstName.setText("First Name:");
		txtFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		txtFirstName.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtFirstName.setFocusable(false);
		txtFirstName.setColumns(10);
		txtFirstName.setBorder(null);
		txtFirstName.setBackground(new Color(204, 204, 204));
		txtFirstName.setBounds(21, 151, 158, 55);
		contentPane.add(txtFirstName);
		
		JTextField fname = new JTextField();
		fname.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		fname.setColumns(10);
		fname.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		fname.setBounds(189, 154, 234, 55);
		contentPane.add(fname);
		
		txtLastName = new JTextField();
		txtLastName.setText("Last Name:");
		txtLastName.setHorizontalAlignment(SwingConstants.LEFT);
		txtLastName.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtLastName.setFocusable(false);
		txtLastName.setColumns(10);
		txtLastName.setBorder(null);
		txtLastName.setBackground(new Color(204, 204, 204));
		txtLastName.setBounds(21, 221, 158, 55);
		contentPane.add(txtLastName);
		
		JTextField lname = new JTextField();
		lname.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lname.setColumns(10);
		lname.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lname.setBounds(189, 224, 234, 55);
		contentPane.add(lname);
		
		txtEmail = new JTextField();
		txtEmail.setText("Email:");
		txtEmail.setHorizontalAlignment(SwingConstants.LEFT);
		txtEmail.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtEmail.setFocusable(false);
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		txtEmail.setBackground(new Color(204, 204, 204));
		txtEmail.setBounds(21, 298, 158, 49);
		contentPane.add(txtEmail);
		
		txtCnic = new JTextField();
		txtCnic.setText("CNIC:");
		txtCnic.setHorizontalAlignment(SwingConstants.LEFT);
		txtCnic.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtCnic.setFocusable(false);
		txtCnic.setColumns(10);
		txtCnic.setBorder(null);
		txtCnic.setBackground(new Color(204, 204, 204));
		txtCnic.setBounds(21, 365, 158, 55);
		contentPane.add(txtCnic);
		
		txtStreet = new JTextField();
		txtStreet.setText("Street:");
		txtStreet.setHorizontalAlignment(SwingConstants.LEFT);
		txtStreet.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtStreet.setFocusable(false);
		txtStreet.setColumns(10);
		txtStreet.setBorder(null);
		txtStreet.setBackground(new Color(204, 204, 204));
		txtStreet.setBounds(21, 436, 158, 65);
		contentPane.add(txtStreet);
		
		JTextField email = new JTextField();
		email.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		email.setColumns(10);
		email.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		email.setBounds(189, 292, 234, 55);
		contentPane.add(email);
		
		JTextField cnic = new JTextField();
		cnic.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		cnic.setColumns(10);
		cnic.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		cnic.setBounds(189, 368, 234, 55);
		contentPane.add(cnic);
		
		JTextField street = new JTextField();
		street.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		street.setColumns(10);
		street.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		street.setBounds(189, 446, 234, 55);
		contentPane.add(street);
		
		txtCity = new JTextField();
		txtCity.setText("City:");
		txtCity.setHorizontalAlignment(SwingConstants.LEFT);
		txtCity.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtCity.setFocusable(false);
		txtCity.setColumns(10);
		txtCity.setBorder(null);
		txtCity.setBackground(new Color(204, 204, 204));
		txtCity.setBounds(21, 512, 158, 65);
		contentPane.add(txtCity);
		
		JTextField city = new JTextField();
		city.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		city.setColumns(10);
		city.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		city.setBounds(189, 516, 234, 55);
		contentPane.add(city);
		
		txtGender = new JTextField();
		txtGender.setText("Gender:");
		txtGender.setHorizontalAlignment(SwingConstants.LEFT);
		txtGender.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtGender.setFocusable(false);
		txtGender.setColumns(10);
		txtGender.setBorder(null);
		txtGender.setBackground(new Color(204, 204, 204));
		txtGender.setBounds(450, 151, 120, 55);
		contentPane.add(txtGender);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBackground(new Color(204, 204, 204));
		rdbtnMale.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnMale.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		rdbtnMale.setBounds(569, 159, 84, 42);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnFemale.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		rdbtnFemale.setBackground(new Color(204, 204, 204));
		rdbtnFemale.setBounds(654, 159, 111, 42);
		contentPane.add(rdbtnFemale);
		
		txtMaritalStatus = new JTextField();
		txtMaritalStatus.setText("Marital Status:");
		txtMaritalStatus.setHorizontalAlignment(SwingConstants.LEFT);
		txtMaritalStatus.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtMaritalStatus.setFocusable(false);
		txtMaritalStatus.setColumns(10);
		txtMaritalStatus.setBorder(null);
		txtMaritalStatus.setBackground(new Color(204, 204, 204));
		txtMaritalStatus.setBounds(450, 221, 203, 55);
		contentPane.add(txtMaritalStatus);
		
		JRadioButton rdbtnMarried = new JRadioButton("Married");
		rdbtnMarried.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnMarried.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		rdbtnMarried.setBackground(new Color(204, 204, 204));
		rdbtnMarried.setBounds(654, 229, 111, 42);
		contentPane.add(rdbtnMarried);
		
		JRadioButton rdbtnUnmarried = new JRadioButton("Unmarried");
		rdbtnUnmarried.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnUnmarried.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		rdbtnUnmarried.setBackground(new Color(204, 204, 204));
		rdbtnUnmarried.setBounds(654, 274, 139, 42);
		contentPane.add(rdbtnUnmarried);
		
		txtAccountType = new JTextField();
		txtAccountType.setText("Account Type:");
		txtAccountType.setHorizontalAlignment(SwingConstants.LEFT);
		txtAccountType.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtAccountType.setFocusable(false);
		txtAccountType.setColumns(10);
		txtAccountType.setBorder(null);
		txtAccountType.setBackground(new Color(204, 204, 204));
		txtAccountType.setBounds(450, 365, 203, 55);
		contentPane.add(txtAccountType);
		
		JRadioButton rdbtnCurrentAccount = new JRadioButton("Current Account");
		rdbtnCurrentAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnCurrentAccount.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		rdbtnCurrentAccount.setBackground(new Color(204, 204, 204));
		rdbtnCurrentAccount.setBounds(441, 418, 186, 42);
		contentPane.add(rdbtnCurrentAccount);
		
		JRadioButton rdbtnSavingAccount = new JRadioButton("Saving Account");
		rdbtnSavingAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnSavingAccount.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		rdbtnSavingAccount.setBackground(new Color(204, 204, 204));
		rdbtnSavingAccount.setBounds(654, 373, 203, 42);
		contentPane.add(rdbtnSavingAccount);
		
		JRadioButton rdbtnFixedDepositAccount = new JRadioButton("Fixed Deposit Account");
		rdbtnFixedDepositAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnFixedDepositAccount.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		rdbtnFixedDepositAccount.setBackground(new Color(204, 204, 204));
		rdbtnFixedDepositAccount.setBounds(629, 418, 254, 42);
		contentPane.add(rdbtnFixedDepositAccount);
		
		JRadioButton rdbtnForeignCurrencyAccount = new JRadioButton("Foreign Currency Account");
		rdbtnForeignCurrencyAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnForeignCurrencyAccount.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		rdbtnForeignCurrencyAccount.setBackground(new Color(204, 204, 204));
		rdbtnForeignCurrencyAccount.setBounds(441, 463, 293, 42);
		contentPane.add(rdbtnForeignCurrencyAccount);
		
		ButtonGroup g1=new ButtonGroup();
		g1.add(rdbtnMale);
		g1.add(rdbtnFemale);
		
		ButtonGroup g2=new ButtonGroup();
		g2.add(rdbtnMarried);
		g2.add(rdbtnUnmarried);
		
		ButtonGroup g3=new ButtonGroup();
		g3.add(rdbtnForeignCurrencyAccount);
		g3.add(rdbtnCurrentAccount);
		g3.add(rdbtnFixedDepositAccount);
		g3.add(rdbtnSavingAccount);
		
		JButton btnDone = new JButton("DONE");
		btnDone.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				String vfname=fname.getText();
				String vlname=lname.getText();
				String vemail=email.getText();
			    String vcnic=cnic.getText();
			    String vstreet=street.getText();
			    String vcity=city.getText();
			    String atype="";
			    String gender="";
			    String maritalStatus="";
			    if(vfname.isEmpty() || vlname.isEmpty() || vemail.isEmpty() || vcnic.isEmpty() || vstreet.isEmpty() || vcity.isEmpty()) {
			    	JOptionPane.showMessageDialog(TotalInfo.this, "Please enter all details.");
			    }
			    else {
			    	if(rdbtnCurrentAccount.isSelected()) {
	                	   atype="Current Account";
	                   }
	                   else if(rdbtnSavingAccount.isSelected()) {
	                	   atype="Saving Account";
	                   }
	                   else if(rdbtnFixedDepositAccount.isSelected()) {
	                	   atype="Fixed Deposit Account";
	                   }
	                   else if(rdbtnForeignCurrencyAccount.isSelected()) {
	                	   atype="Foreign Currency Account";
	                   }
	                   else {
	                	   JOptionPane.showMessageDialog(TotalInfo.this, "Please select account type.");
	                   }
			    	
			    	if(rdbtnMale.isSelected()) {
			    		gender="Male";
			    	}
			    	else if(rdbtnFemale.isSelected()) {
			    		gender="Female";
			    	}
			    	else {
			    		JOptionPane.showMessageDialog(TotalInfo.this, "Please select your gender.");
			    	}
			    	
			    	if(rdbtnMarried.isSelected()) {
			    		maritalStatus="Married";
			    	}
			    	else if(rdbtnUnmarried.isSelected()) {
			    		maritalStatus="Unmarried";
			    	}
			    	else {
			    		JOptionPane.showMessageDialog(TotalInfo.this, "Please select your marital status.");
			    	}
			    	
			        if (!vfname.matches("[a-zA-Z]+")) {
			    		JOptionPane.showMessageDialog(TotalInfo.this, "First name should only contain alphabets.");
			            return;
			        }

			        if (!vlname.matches("[a-zA-Z]+")) {
			    		JOptionPane.showMessageDialog(TotalInfo.this, "Last name should only contain alphabets.");
			            return;
			        }

			        if (!vcity.matches("[a-zA-Z]+")) {
			    		JOptionPane.showMessageDialog(TotalInfo.this, "City should only contain alphabets.");
			            return;
			        }

			        if (!vcnic.matches("\\d{13}")) {
			    		JOptionPane.showMessageDialog(TotalInfo.this, "CNIC should contain exactly 13 digits.");
			            return;
			        }
			        
			        try {
						Database db=new Database();
						db.addAccountCustomer(vfname,vlname,vemail,vcnic,vstreet,vcity,atype,gender,maritalStatus);
						JOptionPane.showMessageDialog(TotalInfo.this, "Your Card No: "+db.getCard()+". Your Pin: "+db.getPin()+". Remember these to Sign In in your account.");
						LoginPage l=new LoginPage();
						l.setVisible(true);
						dispose();
						
					} catch (SQLException e1) {
						 JOptionPane.showMessageDialog(TotalInfo.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

					}
			    }
			}
		});
		btnDone.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDone.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 35));
		btnDone.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnDone.setBackground(new Color(174, 174, 174));
		btnDone.setBounds(569, 520, 151, 55);
		contentPane.add(btnDone);
	}
}

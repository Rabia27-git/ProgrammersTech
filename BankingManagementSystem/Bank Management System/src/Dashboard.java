import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Cursor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDashboard;
	private JTextField txtDeposit;
	private JTextField txtWithdraw;
	private JTextField txtTransfer;
	private JTextField textField;
	private JTextField txtBalance;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	public Dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 25, 903, 645);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtDashboard = new JTextField();
		txtDashboard.setText("DASHBOARD");
		txtDashboard.setHorizontalAlignment(SwingConstants.CENTER);
		txtDashboard.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 50));
		txtDashboard.setFocusable(false);
		txtDashboard.setColumns(10);
		txtDashboard.setBorder(null);
		txtDashboard.setBackground(new Color(204, 204, 204));
		txtDashboard.setBounds(240, 11, 369, 76);
		contentPane.add(txtDashboard);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem()=="  Personal Info") {
					PersonalInfo p=new PersonalInfo();
					p.setVisible(true);
					dispose();
				}
				else {
					Transaction t=new Transaction();
					t.setVisible(true);
					dispose();
				}
			}
		});
		comboBox.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 30));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"  Personal Info", "  Transactions"}));
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox.setBounds(644, 25, 235, 51);
		contentPane.add(comboBox);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Deposit d=new Deposit();
				d.setVisible(true);
			}
		});
		ImageIcon icon1=new ImageIcon(Dashboard.class.getResource("/Images/deposit.jpg"));
		btnNewButton_1.setIcon(icon1);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnNewButton_1.setBounds(51, 268, 228, 237);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Withdraw w=new Withdraw();
				w.setVisible(true);
			}
		});
		btnNewButton_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ImageIcon icon2=new ImageIcon(Dashboard.class.getResource("/Images/withdraw.jpeg"));
		btnNewButton_1_1.setIcon(icon2);
		btnNewButton_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnNewButton_1_1.setBounds(312, 268, 235, 237);
		contentPane.add(btnNewButton_1_1);
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Transfer t=new Transfer();
				t.setVisible(true);
			}
		});
		btnNewButton_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		ImageIcon icon3=new ImageIcon(Dashboard.class.getResource("/Images/transfer.jpeg"));
		btnNewButton_2.setIcon(icon3);
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setBounds(582, 268, 241, 237);
		contentPane.add(btnNewButton_2);
		
		txtDeposit = new JTextField();
		txtDeposit.setText("DEPOSIT");
		txtDeposit.setHorizontalAlignment(SwingConstants.CENTER);
		txtDeposit.setFont(new Font("Times New Roman", Font.BOLD, 35));
		txtDeposit.setFocusable(false);
		txtDeposit.setColumns(10);
		txtDeposit.setBorder(null);
		txtDeposit.setBackground(new Color(204, 204, 204));
		txtDeposit.setBounds(61, 516, 217, 63);
		contentPane.add(txtDeposit);
		
		txtWithdraw = new JTextField();
		txtWithdraw.setText("WITHDRAW");
		txtWithdraw.setHorizontalAlignment(SwingConstants.CENTER);
		txtWithdraw.setFont(new Font("Times New Roman", Font.BOLD, 35));
		txtWithdraw.setFocusable(false);
		txtWithdraw.setColumns(10);
		txtWithdraw.setBorder(null);
		txtWithdraw.setBackground(new Color(204, 204, 204));
		txtWithdraw.setBounds(322, 516, 217, 63);
		contentPane.add(txtWithdraw);
		
		txtTransfer = new JTextField();
		txtTransfer.setText("TRANSFER");
		txtTransfer.setHorizontalAlignment(SwingConstants.CENTER);
		txtTransfer.setFont(new Font("Times New Roman", Font.BOLD, 35));
		txtTransfer.setFocusable(false);
		txtTransfer.setColumns(10);
		txtTransfer.setBorder(null);
		txtTransfer.setBackground(new Color(204, 204, 204));
		txtTransfer.setBounds(606, 516, 217, 63);
		contentPane.add(txtTransfer);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 35));
		textField.setFocusable(false);
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(new Color(204, 204, 204));
		textField.setBounds(30, 101, 836, 51);
		contentPane.add(textField);
		
		txtBalance = new JTextField();
		txtBalance.setHorizontalAlignment(SwingConstants.CENTER);
		txtBalance.setFont(new Font("Times New Roman", Font.BOLD, 35));
		txtBalance.setFocusable(false);
		txtBalance.setColumns(10);
		txtBalance.setBorder(null);
		txtBalance.setBackground(new Color(204, 204, 204));
		txtBalance.setBounds(30, 159, 836, 51);
		contentPane.add(txtBalance);
		
		try {
			Database d=new Database();
			String fname=d.getFName(LoginPage.customerID());
			String lname=d.getLName(LoginPage.customerID());
			double balance=d.getBalance(LoginPage.cardNO());
			String name=fname+" "+lname;
			name=name.toUpperCase();
			textField.setText(name);
			txtBalance.setText("Balance: "+balance);
			
			btnNewButton_3 = new JButton("New button");
			btnNewButton_3.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					LoginPage l=new LoginPage();
					l.setVisible(true);
					dispose();
				}
			});
			btnNewButton_3.setBorder(null);
			btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnNewButton_3.setBackground(new Color(204, 204, 204));
			ImageIcon icon4=new ImageIcon(Dashboard.class.getResource("/Images/back.png"));
			btnNewButton_3.setIcon(icon4);
			btnNewButton_3.setBounds(30, 11, 115, 88);
			contentPane.add(btnNewButton_3);


		} catch (SQLException e) {
			 JOptionPane.showMessageDialog(Dashboard.this, "Exception occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class PartialInfo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtAccountType;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PartialInfo frame = new PartialInfo();
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
	public PartialInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 739, 467);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtId = new JTextField();
		txtId.setText("Enter ID:");
		txtId.setHorizontalAlignment(SwingConstants.CENTER);
		txtId.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 30));
		txtId.setFocusable(false);
		txtId.setColumns(10);
		txtId.setBorder(null);
		txtId.setBackground(new Color(204, 204, 204));
		txtId.setBounds(74, 24, 165, 63);
		contentPane.add(txtId);
		
		txtAccountType = new JTextField();
		txtAccountType.setText("Select Account Type:");
		txtAccountType.setHorizontalAlignment(SwingConstants.CENTER);
		txtAccountType.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 30));
		txtAccountType.setFocusable(false);
		txtAccountType.setColumns(10);
		txtAccountType.setBorder(null);
		txtAccountType.setBackground(new Color(204, 204, 204));
		txtAccountType.setBounds(10, 99, 280, 63);
		contentPane.add(txtAccountType);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		textField_2.setColumns(10);
		textField_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField_2.setBounds(298, 29, 266, 55);
		contentPane.add(textField_2);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				LoginPage l=new LoginPage();
				l.setVisible(true);
				dispose();
			}
		});
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 35));
		btnCancel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnCancel.setBackground(new Color(174, 174, 174));
		btnCancel.setBounds(366, 347, 151, 55);
		contentPane.add(btnCancel);
		
		JRadioButton rdbtnCurrentAccount = new JRadioButton("Current Account");
		rdbtnCurrentAccount.setBackground(new Color(204, 204, 204));
		rdbtnCurrentAccount.setAlignmentY(Component.TOP_ALIGNMENT);
		rdbtnCurrentAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnCurrentAccount.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		rdbtnCurrentAccount.setBounds(298, 113, 236, 36);
		contentPane.add(rdbtnCurrentAccount);
		
		JRadioButton rdbtnSavingAccount = new JRadioButton("Saving Account");
		rdbtnSavingAccount.setBackground(new Color(204, 204, 204));
		rdbtnSavingAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnSavingAccount.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		rdbtnSavingAccount.setBounds(298, 168, 236, 36);
		contentPane.add(rdbtnSavingAccount);
		
		JRadioButton rdbtnFixedDepositAccount = new JRadioButton("Fixed Deposit Account");
		rdbtnFixedDepositAccount.setBackground(new Color(204, 204, 204));
		rdbtnFixedDepositAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnFixedDepositAccount.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		rdbtnFixedDepositAccount.setBounds(297, 224, 313, 36);
		contentPane.add(rdbtnFixedDepositAccount);
		
		JRadioButton rdbtnForeignCurrencyAccount = new JRadioButton("Foreign Currency Account");
		rdbtnForeignCurrencyAccount.setBackground(new Color(204, 204, 204));
		rdbtnForeignCurrencyAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnForeignCurrencyAccount.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		rdbtnForeignCurrencyAccount.setBounds(298, 281, 354, 36);
		contentPane.add(rdbtnForeignCurrencyAccount);
		
		ButtonGroup g=new ButtonGroup();
		g.add(rdbtnForeignCurrencyAccount);
		g.add(rdbtnCurrentAccount);
		g.add(rdbtnFixedDepositAccount);
		g.add(rdbtnSavingAccount);
		
		JButton btnDone = new JButton("DONE");
		btnDone.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				String id=textField_2.getText();
				String atype="";
				if(id.isEmpty()) {
					JOptionPane.showMessageDialog(PartialInfo.this, "Please enter ID.");
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
                	   JOptionPane.showMessageDialog(PartialInfo.this, "Please select account type.");
                   }
                   
                   try {
					Database db=new Database();
					boolean check=db.checkCustomer(id);
					if(!check) {
						JOptionPane.showMessageDialog(PartialInfo.this, "Entered ID doesn't exist.");
						return;
					}
					db.addAccount(id,atype);
					JOptionPane.showMessageDialog(PartialInfo.this, "Your Card No: "+db.getCard()+". Your Pin: "+db.getPin()+". Remember these to Sign In in your account.");
					LoginPage l=new LoginPage();
					l.setVisible(true);
					dispose();
					
				} catch (SQLException e1) {
					 JOptionPane.showMessageDialog(PartialInfo.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				}
                   
				}
			}
		});
		btnDone.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDone.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 35));
		btnDone.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnDone.setBackground(new Color(174, 174, 174));
		btnDone.setBounds(181, 347, 151, 55);
		contentPane.add(btnDone);
	}
}

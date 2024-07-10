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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Transfer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAccountId;
	private JTextField txtAmount;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transfer frame = new Transfer();
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
	public Transfer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 230, 629, 330);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtAccountId = new JTextField();
		txtAccountId.setText("Enter Account ID:");
		txtAccountId.setHorizontalAlignment(SwingConstants.CENTER);
		txtAccountId.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 30));
		txtAccountId.setFocusable(false);
		txtAccountId.setColumns(10);
		txtAccountId.setBorder(null);
		txtAccountId.setBackground(new Color(204, 204, 204));
		txtAccountId.setBounds(46, 24, 239, 63);
		contentPane.add(txtAccountId);
		
		txtAmount = new JTextField();
		txtAmount.setText("Amount to transfer:");
		txtAmount.setHorizontalAlignment(SwingConstants.CENTER);
		txtAmount.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 30));
		txtAmount.setFocusable(false);
		txtAmount.setColumns(10);
		txtAmount.setBorder(null);
		txtAmount.setBackground(new Color(204, 204, 204));
		txtAmount.setBounds(10, 98, 277, 63);
		contentPane.add(txtAmount);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		textField.setColumns(10);
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField.setBounds(297, 29, 266, 55);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField_1.setBounds(297, 103, 266, 55);
		contentPane.add(textField_1);
		
		JButton btnDone = new JButton("DONE");
		btnDone.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				String accID=textField.getText();
			    String amount=textField_1.getText();
			    if(accID.isEmpty() || amount.isEmpty()) {
			    	JOptionPane.showMessageDialog(Transfer.this, "Please enter all details.");
			    }
			    else {
			    	try {
						Database db=new Database();
						double balance=db.getBalance(LoginPage.cardNO());
						int money=Integer.parseInt(amount);
						int aid=Integer.parseInt(accID);
						boolean check=db.checkAccount(aid);
						if(money>balance) {
							JOptionPane.showMessageDialog(Transfer.this, "Amount to transfer is greater than your current balance.");
							return;
						}
						if(!check) {
							JOptionPane.showMessageDialog(Transfer.this, "Invalid Account ID.");
							return;
						}	
						db.transfer(money,aid,LoginPage.cardNO(),LoginPage.accountID());
						JOptionPane.showMessageDialog(Transfer.this, "Amount transferred successfully.");
						Dashboard d=new Dashboard();
						d.setVisible(true);
						dispose();
					} catch (SQLException e1) {
						 JOptionPane.showMessageDialog(Transfer.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
					catch(NumberFormatException ne) {
						 JOptionPane.showMessageDialog(Transfer.this, "Exception occurred: " + ne.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			    }
		});
		btnDone.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDone.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 35));
		btnDone.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnDone.setBackground(new Color(174, 174, 174));
		btnDone.setBounds(141, 195, 151, 55);
		contentPane.add(btnDone);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnCancel.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 35));
		btnCancel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnCancel.setBackground(new Color(174, 174, 174));
		btnCancel.setBounds(326, 195, 151, 55);
		contentPane.add(btnCancel);
	}

}

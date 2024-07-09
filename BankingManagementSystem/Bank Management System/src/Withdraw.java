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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.Cursor;

public class Withdraw extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtHowMuchMoney;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Withdraw frame = new Withdraw();
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
	public Withdraw() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 230, 629, 330);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtHowMuchMoney = new JTextField();
		txtHowMuchMoney.setText("How much money do you want to withdraw?");
		txtHowMuchMoney.setHorizontalAlignment(SwingConstants.CENTER);
		txtHowMuchMoney.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 30));
		txtHowMuchMoney.setFocusable(false);
		txtHowMuchMoney.setColumns(10);
		txtHowMuchMoney.setBorder(null);
		txtHowMuchMoney.setBackground(new Color(204, 204, 204));
		txtHowMuchMoney.setBounds(10, 11, 595, 63);
		contentPane.add(txtHowMuchMoney);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		textField.setColumns(10);
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField.setBounds(110, 100, 386, 55);
		contentPane.add(textField);
		
		JButton btnDone = new JButton("DONE");
		btnDone.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				String amount=textField.getText();
				if(amount.isEmpty()) {
					JOptionPane.showMessageDialog(Withdraw.this, "Please enter amount to withdraw.");
				}
				else {
					try {
						Database db=new Database();
						double balance=db.getBalance(LoginPage.cardNO());
						int money=Integer.parseInt(amount);
						if(money>balance) {
							JOptionPane.showMessageDialog(Withdraw.this, "Amount to withdraw is greater than your current balance.");
							return;
						}
						db.withdraw(money,LoginPage.cardNO(),LoginPage.accountID());
						JOptionPane.showMessageDialog(Withdraw.this, "Amount withdrawed successfully.");
						Dashboard d=new Dashboard();
						d.setVisible(true);
						dispose();
					} catch (SQLException e1) {
						 JOptionPane.showMessageDialog(Withdraw.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
					catch(NumberFormatException ne) {
						 JOptionPane.showMessageDialog(Withdraw.this, "Exception occurred: " + ne.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnDone.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDone.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 35));
		btnDone.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnDone.setBackground(new Color(174, 174, 174));
		btnDone.setBounds(124, 191, 151, 55);
		contentPane.add(btnDone);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 35));
		btnCancel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnCancel.setBackground(new Color(174, 174, 174));
		btnCancel.setBounds(308, 191, 151, 55);
		contentPane.add(btnCancel);
	}

}

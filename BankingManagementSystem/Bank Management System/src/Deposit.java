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
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Deposit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtHowMuchAmount;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposit frame = new Deposit();
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
	public Deposit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 230, 629, 330);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtHowMuchAmount = new JTextField();
		txtHowMuchAmount.setText("How much money do you want to deposit?");
		txtHowMuchAmount.setHorizontalAlignment(SwingConstants.CENTER);
		txtHowMuchAmount.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 30));
		txtHowMuchAmount.setFocusable(false);
		txtHowMuchAmount.setColumns(10);
		txtHowMuchAmount.setBorder(null);
		txtHowMuchAmount.setBackground(new Color(204, 204, 204));
		txtHowMuchAmount.setBounds(10, 11, 595, 63);
		contentPane.add(txtHowMuchAmount);
		
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
					JOptionPane.showMessageDialog(Deposit.this, "Please enter amount to deposit.");
				}
				else {
					try {
						Database db=new Database();
						db.deposit(amount,LoginPage.cardNO(),LoginPage.accountID());
						JOptionPane.showMessageDialog(Deposit.this, "Amount deposited successfully.");
						Dashboard d=new Dashboard();
						d.setVisible(true);
						dispose();
					} catch (SQLException e1) {
						 JOptionPane.showMessageDialog(Deposit.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
					catch(NumberFormatException ne) {
						 JOptionPane.showMessageDialog(Deposit.this, "Exception occurred: " + ne.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
		btnCancel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 35));
		btnCancel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnCancel.setBackground(new Color(174, 174, 174));
		btnCancel.setBounds(308, 191, 151, 55);
		contentPane.add(btnCancel);
	}

}

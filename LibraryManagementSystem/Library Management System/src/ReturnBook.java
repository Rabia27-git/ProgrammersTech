import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ReturnBook extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtReturnBook;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook frame = new ReturnBook();
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
	public ReturnBook() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 10, 913, 639);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 115, 81));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtReturnBook = new JTextField();
		txtReturnBook.setText("Return Book");
		txtReturnBook.setHorizontalAlignment(SwingConstants.CENTER);
		txtReturnBook.setForeground(Color.WHITE);
		txtReturnBook.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 45));
		txtReturnBook.setFocusable(false);
		txtReturnBook.setColumns(10);
		txtReturnBook.setBorder(null);
		txtReturnBook.setBackground(new Color(0, 115, 81));
		txtReturnBook.setBounds(365, 24, 258, 59);
		contentPane.add(txtReturnBook);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ReturnBook.class.getResource("/Images/Return Book big.png")));
		lblNewLabel.setBounds(255, 0, 100, 100);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Dashboard d=new Dashboard();
				d.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setIcon(new ImageIcon(ReturnBook.class.getResource("/Images/Back.png")));
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(new Color(0, 115, 81));
		btnNewButton_1.setBounds(10, 24, 65, 65);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setText("Book ID:");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		textField.setFocusable(false);
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(new Color(0, 115, 81));
		textField.setBounds(10, 157, 155, 35);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 27));
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		textField_1.setBounds(22, 203, 270, 59);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("Patron ID:");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		textField_2.setFocusable(false);
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBackground(new Color(0, 115, 81));
		textField_2.setBounds(22, 293, 155, 40);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 27));
		textField_3.setColumns(10);
		textField_3.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		textField_3.setBounds(22, 344, 270, 59);
		contentPane.add(textField_3);
		
		JButton btnAdd_1 = new JButton("");
		btnAdd_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				String bid=textField_1.getText();
				String pid=textField_3.getText();
				if(bid.isEmpty() || pid.isEmpty()) {
					JOptionPane.showMessageDialog(ReturnBook.this, "Please fill all details.");
				}
				else {
					try {
					Database db=new Database();
					boolean check1=db.checkID(bid);
					boolean check2=db.checkPID(pid);
					boolean check3=db.checkForReturn(bid,pid);
					if(!check1) {
                        JOptionPane.showMessageDialog(ReturnBook.this, "Invalid Book ID.");
                        return;	
					}
					
					if(!check2) {
                        JOptionPane.showMessageDialog(ReturnBook.this, "Invalid Patron ID.");
                        return;	
					}
					
					if(!check3) {
                        JOptionPane.showMessageDialog(ReturnBook.this, "This book is already returned.");
                        return;	
					}
					
					db.returnBook(bid,pid);
					JOptionPane.showMessageDialog(ReturnBook.this, "Book Returned Successfully.");
					ReturnBook r=new ReturnBook();
					r.setVisible(true);
					dispose();
					
					}
					catch (SQLException e1) {
						 JOptionPane.showMessageDialog(ReturnBook.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

					}
				}

			}
		});
		btnAdd_1.setIcon(new ImageIcon(ReturnBook.class.getResource("/Images/btnreturnBook.png")));
		btnAdd_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd_1.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		btnAdd_1.setFocusable(false);
		btnAdd_1.setBorder(null);
		btnAdd_1.setBackground(new Color(0, 115, 81));
		btnAdd_1.setBounds(64, 455, 182, 64);
		contentPane.add(btnAdd_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(191, 255, 191));
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		scrollPane.setBounds(314, 142, 575, 438);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(25);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Book ID", "Patron ID", "Issue Date", "Return Date", "ActRtnDate"
				}
			));
		table.setGridColor(new Color(0, 115, 81));
		table.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 17));
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table.setBackground(new Color(191, 255, 191));
		JTableHeader header=table.getTableHeader();
        header.setFont(new Font("Times New Roman", Font.BOLD, 19));
        header.setBackground(new Color(191, 255, 191));
		scrollPane.setViewportView(table);
		
		try {
			Database d=new Database();
			d.showTransactionsReturnBook();
		} catch (SQLException e1) {
			 JOptionPane.showMessageDialog(ReturnBook.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

		}
	}

}

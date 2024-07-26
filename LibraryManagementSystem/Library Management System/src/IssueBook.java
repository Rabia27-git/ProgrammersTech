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
import java.util.Date;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class IssueBook extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIssueBook;
	private JTextField txtBookId;
	private JTextField textField_1;
	private JTextField txtPatronId;
	private JTextField textField;
	private JTextField txtReturnDate;
	private JDateChooser dateChooser;
	private JScrollPane scrollPane;
	static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssueBook frame = new IssueBook();
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
	public IssueBook() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 0, 911, 639);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 115, 81));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtIssueBook = new JTextField();
		txtIssueBook.setText("Issue Book");
		txtIssueBook.setHorizontalAlignment(SwingConstants.CENTER);
		txtIssueBook.setForeground(Color.WHITE);
		txtIssueBook.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 45));
		txtIssueBook.setFocusable(false);
		txtIssueBook.setColumns(10);
		txtIssueBook.setBorder(null);
		txtIssueBook.setBackground(new Color(0, 115, 81));
		txtIssueBook.setBounds(357, 21, 244, 59);
		contentPane.add(txtIssueBook);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(IssueBook.class.getResource("/Images/issue Book big.png")));
		lblNewLabel.setBounds(265, 0, 100, 100);
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
		btnNewButton_1.setIcon(new ImageIcon(IssueBook.class.getResource("/Images/Back.png")));
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(new Color(0, 115, 81));
		btnNewButton_1.setBounds(10, 21, 65, 65);
		contentPane.add(btnNewButton_1);
		
		txtBookId = new JTextField();
		txtBookId.setText("Book ID:");
		txtBookId.setHorizontalAlignment(SwingConstants.CENTER);
		txtBookId.setForeground(Color.WHITE);
		txtBookId.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		txtBookId.setFocusable(false);
		txtBookId.setColumns(10);
		txtBookId.setBorder(null);
		txtBookId.setBackground(new Color(0, 115, 81));
		txtBookId.setBounds(10, 131, 155, 35);
		contentPane.add(txtBookId);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 27));
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		textField_1.setBounds(31, 170, 270, 59);
		contentPane.add(textField_1);
		
		JButton btnAdd_1 = new JButton("");
		btnAdd_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				String bid=textField_1.getText();
				String pid=textField.getText();
				Date d=dateChooser.getDate();
				if(d==null) {
					JOptionPane.showMessageDialog(IssueBook.this, "Please select a return date.");
				}
				else {
					java.sql.Date date = new java.sql.Date(d.getTime());
                    java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
                    if (date.before(currentDate)) {
                        JOptionPane.showMessageDialog(IssueBook.this, "Invalid date.");
                        return;
                    } 
                    try {
						Database db=new Database();
						boolean check1=db.checkID(bid);
						boolean check2=db.checkPID(pid);
						int check3=db.checkQuantity(bid);
						if(!check1) {
	                        JOptionPane.showMessageDialog(IssueBook.this, "Invalid Book ID.");
	                        return;	
						}
						
						if(!check2) {
	                        JOptionPane.showMessageDialog(IssueBook.this, "Invalid Patron ID.");
	                        return;	
						}
						
						if(check3==0) {
	                        JOptionPane.showMessageDialog(IssueBook.this, "This book is not available.");
	                        return;
						}
  
						db.issueBook(bid,pid,date);
                        JOptionPane.showMessageDialog(IssueBook.this, "Book Issued Successfully.");
						IssueBook i=new IssueBook();
						i.setVisible(true);
						dispose();
						
					} catch (SQLException e1) {
						 JOptionPane.showMessageDialog(IssueBook.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

					}
                    
                    
				}
			}
		});
		btnAdd_1.setIcon(new ImageIcon(IssueBook.class.getResource("/Images/btnIssueBook.png")));
		btnAdd_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd_1.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		btnAdd_1.setFocusable(false);
		btnAdd_1.setBorder(null);
		btnAdd_1.setBackground(new Color(0, 115, 81));
		btnAdd_1.setBounds(87, 504, 160, 65);
		contentPane.add(btnAdd_1);
		
		txtPatronId = new JTextField();
		txtPatronId.setText("Patron ID:");
		txtPatronId.setHorizontalAlignment(SwingConstants.CENTER);
		txtPatronId.setForeground(Color.WHITE);
		txtPatronId.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		txtPatronId.setFocusable(false);
		txtPatronId.setColumns(10);
		txtPatronId.setBorder(null);
		txtPatronId.setBackground(new Color(0, 115, 81));
		txtPatronId.setBounds(20, 251, 155, 40);
		contentPane.add(txtPatronId);
		
		textField = new JTextField();
		textField.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 27));
		textField.setColumns(10);
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		textField.setBounds(31, 291, 270, 59);
		contentPane.add(textField);
		
		txtReturnDate = new JTextField();
		txtReturnDate.setText("Return Date:");
		txtReturnDate.setHorizontalAlignment(SwingConstants.CENTER);
		txtReturnDate.setForeground(Color.WHITE);
		txtReturnDate.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		txtReturnDate.setFocusable(false);
		txtReturnDate.setColumns(10);
		txtReturnDate.setBorder(null);
		txtReturnDate.setBackground(new Color(0, 115, 81));
		txtReturnDate.setBounds(31, 378, 174, 40);
		contentPane.add(txtReturnDate);
		
		dateChooser = new JDateChooser();
		dateChooser.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		dateChooser.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		dateChooser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooser.setBounds(31, 421, 270, 51);
		contentPane.add(dateChooser);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(191, 255, 191));
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		scrollPane.setBounds(311, 153, 575, 438);
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
		table.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		table.setBackground(new Color(191, 255, 191));
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JTableHeader header=table.getTableHeader();
        header.setFont(new Font("Times New Roman", Font.BOLD, 19));
        header.setBackground(new Color(191, 255, 191));
		scrollPane.setViewportView(table);
		
		try {
			Database d=new Database();
			d.showTransactionsIssueBook();
		} catch (SQLException e1) {
			 JOptionPane.showMessageDialog(IssueBook.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

		}
		
	}
}

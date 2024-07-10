import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Transaction extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTransactions;
	static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transaction frame = new Transaction();
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
	public Transaction() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 25, 903, 645);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTransactions = new JTextField();
		txtTransactions.setText("TRANSACTIONS");
		txtTransactions.setHorizontalAlignment(SwingConstants.CENTER);
		txtTransactions.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 50));
		txtTransactions.setFocusable(false);
		txtTransactions.setColumns(10);
		txtTransactions.setBorder(null);
		txtTransactions.setBackground(new Color(204, 204, 204));
		txtTransactions.setBounds(216, 23, 487, 76);
		contentPane.add(txtTransactions);
		
		JButton btnNewButton_3 = new JButton();
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Dashboard d=new Dashboard();
				d.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setBackground(new Color(204, 204, 204));
		btnNewButton_3.setBounds(23, 11, 115, 88);
		ImageIcon icon4=new ImageIcon(Dashboard.class.getResource("/Images/back.png"));
		btnNewButton_3.setIcon(icon4);
		contentPane.add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(148, 124, 625, 435);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Transaction ID", "Transaction DateTime", "Transaction Type", "Amount"
				}
			));
		table.setColumnSelectionAllowed(true);
		table.setRowHeight(25);
		table.setBackground(new Color(211, 211, 211));
		table.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		//customizing table header font
		JTableHeader header=table.getTableHeader();
        header.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		scrollPane.setViewportView(table);
		
		try {
			Database d=new Database();
			d.transaction(LoginPage.accountID());
		} catch (SQLException e) {
			 JOptionPane.showMessageDialog(Transaction.this, "Exception occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

		}
	}
}

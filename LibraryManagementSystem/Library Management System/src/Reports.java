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
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.Cursor;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Reports extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtReports;
	private JTextField textField;
	private JTabbedPane tabbedPane;
	static JTable table;
	static JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reports frame = new Reports();
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
	public Reports() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 10, 805, 639);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 115, 81));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_3.setBackground(new Color(191, 255, 191));
		panel_3.setBounds(0, 0, 239, 600);
		contentPane.add(panel_3);
		
		JButton btnIssuedBooks = new JButton("Issued Books");
		btnIssuedBooks.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnIssuedBooks.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIssuedBooks.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 26));
		btnIssuedBooks.setFocusable(false);
		btnIssuedBooks.setBorder(null);
		btnIssuedBooks.setBackground(new Color(191, 255, 191));
		btnIssuedBooks.setBounds(56, 142, 173, 53);
		panel_3.add(btnIssuedBooks);
		
		JButton btnOverdueBooks = new JButton("Overdue");
		btnOverdueBooks.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnOverdueBooks.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOverdueBooks.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		btnOverdueBooks.setFocusable(false);
		btnOverdueBooks.setBorder(null);
		btnOverdueBooks.setBackground(new Color(191, 255, 191));
		btnOverdueBooks.setBounds(82, 223, 116, 38);
		panel_3.add(btnOverdueBooks);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Reports.class.getResource("/Images/Issued Books.png")));
		lblNewLabel_1.setBounds(10, 145, 50, 50);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(Reports.class.getResource("/Images/overdue.png")));
		lblNewLabel_1_1.setBounds(10, 223, 50, 50);
		panel_3.add(lblNewLabel_1_1);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGoBack.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Dashboard d=new Dashboard();
				d.setVisible(true);
				dispose();
			}
		});
		btnGoBack.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 26));
		btnGoBack.setFocusable(false);
		btnGoBack.setBorder(null);
		btnGoBack.setBackground(new Color(191, 255, 191));
		btnGoBack.setBounds(73, 326, 125, 53);
		panel_3.add(btnGoBack);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(Reports.class.getResource("/Images/Open Pane.png")));
		lblNewLabel_1_1_1.setBounds(10, 329, 50, 50);
		panel_3.add(lblNewLabel_1_1_1);
		
		JButton btnBooks = new JButton("Books");
		btnBooks.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnBooks.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBooks.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		btnBooks.setFocusable(false);
		btnBooks.setBorder(null);
		btnBooks.setBackground(new Color(191, 255, 191));
		btnBooks.setBounds(92, 259, 89, 38);
		panel_3.add(btnBooks);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(238, -86, 553, 686);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 115, 81));
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		
		txtReports = new JTextField();
		txtReports.setBounds(200, 84, 152, 59);
		panel.add(txtReports);
		txtReports.setText("Report");
		txtReports.setHorizontalAlignment(SwingConstants.CENTER);
		txtReports.setForeground(Color.WHITE);
		txtReports.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 40));
		txtReports.setFocusable(false);
		txtReports.setColumns(10);
		txtReports.setBorder(null);
		txtReports.setBackground(new Color(0, 115, 81));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(104, 66, 100, 100);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Reports.class.getResource("/Images/Business Report big.png")));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(191, 255, 191));
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		scrollPane.setBounds(10, 196, 507, 451);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setGridColor(new Color(0, 115, 81));
		table.setBackground(new Color(191, 255, 191));
		table.setRowHeight(30);
		table.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 17));
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JTableHeader header=table.getTableHeader();
        header.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 19));
        header.setBackground(new Color(191, 255, 191));
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Book ID", "Patron ID", "Issue Date", "Return Date"
				}
			));
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 115, 81));
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setText("Report");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 40));
		textField.setFocusable(false);
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(new Color(0, 115, 81));
		textField.setBounds(200, 84, 152, 59);
		panel_1.add(textField);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Reports.class.getResource("/Images/Business Report big.png")));
		lblNewLabel_2.setBounds(104, 66, 100, 100);
		panel_1.add(lblNewLabel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBackground(new Color(191, 255, 191));
		scrollPane_1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		scrollPane_1.setBounds(10, 196, 528, 451);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setBackground(new Color(191, 255, 191));
		table_1.setGridColor(new Color(0, 115, 81));
		table_1.setRowHeight(30);
		table_1.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 17));
		table_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JTableHeader header1=table_1.getTableHeader();
        header1.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 19));
        header1.setBackground(new Color(191, 255, 191));
		table_1.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Book ID", "Patron ID", "Issue Date", "Return Date", "Overdued By"
				}
			));
		scrollPane_1.setViewportView(table_1);
		
		try {
			Database d=new Database();
			d.showIssuedBooks();
			d.showOverdueBook();
		} catch (SQLException e1) {
			 JOptionPane.showMessageDialog(Reports.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

		}
	}
}

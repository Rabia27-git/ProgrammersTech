import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSearchForBooks;
	private JTextField message;
	private DefaultListModel<String> songListModel;
	private JList<String> list;

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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 10, 843, 639);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 115, 81));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel.setBackground(new Color(191, 255, 191));
		panel.setBounds(0, 0, 232, 602);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton =new JButton("Manage Books");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Books b=new Books();
				b.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFocusable(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(191, 255, 191));
		btnNewButton.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 21));
		btnNewButton.setBounds(66, 44, 156, 53);
		panel.add(btnNewButton);
		
		JButton btnManagePatrons = new JButton("Manage Patrons");
		btnManagePatrons.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Patrons p=new Patrons();
				p.setVisible(true);
				dispose();
			}
		});
		btnManagePatrons.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnManagePatrons.setFocusable(false);
		btnManagePatrons.setBackground(new Color(191, 255, 191));
		btnManagePatrons.setBorder(null);
		btnManagePatrons.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 19));
		btnManagePatrons.setBounds(66, 108, 156, 53);
		panel.add(btnManagePatrons);
		
		JButton btnTransactions = new JButton("Issue Book");
		btnTransactions.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				IssueBook i=new IssueBook();
				i.setVisible(true);
				dispose();
			}
		});
		btnTransactions.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTransactions.setFocusable(false);
		btnTransactions.setBorder(null);
		btnTransactions.setBackground(new Color(191, 255, 191));
		btnTransactions.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 21));
		btnTransactions.setBounds(66, 172, 118, 53);
		panel.add(btnTransactions);
		
		JButton btnReports = new JButton("Reports");
		btnReports.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Reports r=new Reports();
				r.setVisible(true);
				dispose();
			}
		});
		btnReports.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReports.setFocusable(false);
		btnReports.setBackground(new Color(191, 255, 191));
		btnReports.setBorder(null);
		btnReports.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 21));
		btnReports.setBounds(64, 294, 90, 53);
		panel.add(btnReports);
		
		JButton btnMyProfile = new JButton("My Profile");
		btnMyProfile.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Profile p=new Profile();
				p.setVisible(true);
				dispose();
			}
		});
		btnMyProfile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMyProfile.setFocusable(false);
		btnMyProfile.setBorder(null);
		btnMyProfile.setBackground(new Color(191, 255, 191));
		btnMyProfile.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 21));
		btnMyProfile.setBounds(64, 358, 107, 53);
		panel.add(btnMyProfile);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				LoginPage l=new LoginPage();
				l.setVisible(true);
				dispose();
			}
		});
		btnLogOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogOut.setBackground(new Color(191, 255, 191));
		btnLogOut.setBorder(null);
		btnLogOut.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 21));
		btnLogOut.setBounds(64, 422, 95, 53);
		panel.add(btnLogOut);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/Books Emoji.png")));
		lblNewLabel.setBounds(6, 47, 50, 50);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/Crowd.png")));
		lblNewLabel_1.setBounds(6, 111, 50, 50);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/issue Book.png")));
		lblNewLabel_2.setBounds(6, 175, 50, 50);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/Business Report.png")));
		lblNewLabel_3.setBounds(6, 297, 50, 50);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/Profile.png")));
		lblNewLabel_4.setBounds(6, 361, 50, 50);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/Open Pane.png")));
		lblNewLabel_5.setBounds(6, 425, 50, 50);
		panel.add(lblNewLabel_5);
		
		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				ReturnBook r=new ReturnBook();
				r.setVisible(true);
				dispose();
			}
		});
		btnReturnBook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReturnBook.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 21));
		btnReturnBook.setFocusable(false);
		btnReturnBook.setBorder(null);
		btnReturnBook.setBackground(new Color(191, 255, 191));
		btnReturnBook.setBounds(66, 236, 135, 53);
		panel.add(btnReturnBook);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/Return Book.png")));
		lblNewLabel_2_1.setBounds(6, 236, 50, 50);
		panel.add(lblNewLabel_2_1);
		
		txtSearchForBooks = new JTextField();
		txtSearchForBooks.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				txtSearchForBooks.setText("");
			}
			public void focusLost(FocusEvent e) {
				txtSearchForBooks.setText("Search for Books or Patrons");
			}
		});
		txtSearchForBooks.setText(" Search for Books or Authors");
		txtSearchForBooks.setForeground(new Color(0, 0, 0));
		txtSearchForBooks.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 25));
		txtSearchForBooks.setColumns(10);
		txtSearchForBooks.setBorder(new MatteBorder(3, 3, 3, 0, (Color) new Color(0, 0, 0)));
		txtSearchForBooks.setBackground(new Color(191, 255, 191));
		txtSearchForBooks.setBounds(285, 23, 424, 55);
		contentPane.add(txtSearchForBooks);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				String search=txtSearchForBooks.getText().toLowerCase();
				if(!search.isEmpty()) {
				  try {
					Database d=new Database();
					boolean check=d.checkBook(search, songListModel);
					if(!check) {
						message.setText("No result found");
					}
					
				} catch (SQLException e1) {
					 JOptionPane.showMessageDialog(Dashboard.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				}
				}
			}
		});
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBorder(new MatteBorder(3, 0, 3, 3, (Color) new Color(0, 0, 0)));
		btnNewButton_1.setBackground(new Color(191, 255, 191));
		btnNewButton_1.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/Search.png")));
		btnNewButton_1.setBounds(708, 23, 50, 55);
		contentPane.add(btnNewButton_1);
		
		message = new JTextField();
		message.setHorizontalAlignment(SwingConstants.CENTER);
		message.setForeground(Color.BLACK);
		message.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 27));
		message.setFocusable(false);
		message.setColumns(10);
		message.setBorder(null);
		message.setBackground(new Color(0, 115, 81));
		message.setBounds(315, 85, 377, 48);
		contentPane.add(message);
		
		songListModel=new DefaultListModel<>();
		list = new JList<>(songListModel);
		list.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		list.setBackground(new Color(191, 255, 191));
		list.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    list.setFont(new Font("Monospaced", Font.BOLD, 20));
	    JScrollPane scrollPane = new JScrollPane(list);
	    scrollPane.setBorder(null);
		scrollPane.setBounds(242, 144, 577, 365);
	    contentPane.add(scrollPane);
		scrollPane.setViewportView(list);
		try {
			Database d=new Database();
			d.showBooks(songListModel);
			
		} catch (SQLException e1) {
			 JOptionPane.showMessageDialog(Dashboard.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

		}
       
      
	}
}

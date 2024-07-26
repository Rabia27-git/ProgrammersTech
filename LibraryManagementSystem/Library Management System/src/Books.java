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
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Books extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtManageBooks;
	private JTextField txtBookTitle;
	private JTextField textField;
	private JTextField txtBookAuthor;
	private JTextField textField_1;
	private JTextField txtBookQuantity;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtBookId;
	private JTextField textField_5;
	private JTextField txtWhatYouWant;
	private JTextField txtEnterNewValue;
	private JTextField textField_6;
	private JComboBox comboBox;
	private JTextField textField_4;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Books frame = new Books();
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
	public Books() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 10, 784, 639);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, -75, 770, 666);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 115, 81));
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		
		txtManageBooks = new JTextField();
		txtManageBooks.setText("Manage Books");
		txtManageBooks.setHorizontalAlignment(SwingConstants.CENTER);
		txtManageBooks.setForeground(new Color(255, 255, 255));
		txtManageBooks.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 40));
		txtManageBooks.setFocusable(false);
		txtManageBooks.setColumns(10);
		txtManageBooks.setBorder(null);
		txtManageBooks.setBackground(new Color(0, 115, 81));
		txtManageBooks.setBounds(387, 71, 288, 59);
		panel.add(txtManageBooks);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Books.class.getResource("/Images/Books Emoji big.png")));
		lblNewLabel.setBounds(282, 53, 100, 100);
		panel.add(lblNewLabel);
		
		txtBookTitle = new JTextField();
		txtBookTitle.setText("Book  Title:");
		txtBookTitle.setHorizontalAlignment(SwingConstants.CENTER);
		txtBookTitle.setForeground(Color.WHITE);
		txtBookTitle.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		txtBookTitle.setFocusable(false);
		txtBookTitle.setColumns(10);
		txtBookTitle.setBorder(null);
		txtBookTitle.setBackground(new Color(0, 115, 81));
		txtBookTitle.setBounds(289, 186, 191, 40);
		panel.add(txtBookTitle);
		
		textField = new JTextField();
		textField.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 27));
		textField.setColumns(10);
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		textField.setBounds(298, 229, 325, 59);
		panel.add(textField);
		
		txtBookAuthor = new JTextField();
		txtBookAuthor.setText("Book Author:");
		txtBookAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		txtBookAuthor.setForeground(Color.WHITE);
		txtBookAuthor.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		txtBookAuthor.setFocusable(false);
		txtBookAuthor.setColumns(10);
		txtBookAuthor.setBorder(null);
		txtBookAuthor.setBackground(new Color(0, 115, 81));
		txtBookAuthor.setBounds(304, 314, 191, 40);
		panel.add(txtBookAuthor);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 27));
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		textField_1.setBounds(298, 355, 325, 59);
		panel.add(textField_1);
		
		txtBookQuantity = new JTextField();
		txtBookQuantity.setText("Book Quantity:");
		txtBookQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		txtBookQuantity.setForeground(Color.WHITE);
		txtBookQuantity.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		txtBookQuantity.setFocusable(false);
		txtBookQuantity.setColumns(10);
		txtBookQuantity.setBorder(null);
		txtBookQuantity.setBackground(new Color(0, 115, 81));
		txtBookQuantity.setBounds(298, 442, 217, 40);
		panel.add(txtBookQuantity);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 27));
		textField_2.setColumns(10);
		textField_2.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		textField_2.setBounds(304, 483, 325, 59);
		panel.add(textField_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_3.setBackground(new Color(191, 255, 191));
		panel_3.setBounds(0, 52, 199, 586);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		btnAdd.setFocusable(false);
		btnAdd.setBorder(null);
		btnAdd.setBackground(new Color(191, 255, 191));
		btnAdd.setBounds(70, 52, 99, 53);
		panel_3.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
			 tabbedPane.setSelectedIndex(1);
			}
		});
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		btnUpdate.setFocusable(false);
		btnUpdate.setBorder(null);
		btnUpdate.setBackground(new Color(191, 255, 191));
		btnUpdate.setBounds(70, 139, 99, 53);
		panel_3.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		btnDelete.setFocusable(false);
		btnDelete.setBorder(null);
		btnDelete.setBackground(new Color(191, 255, 191));
		btnDelete.setBounds(70, 233, 99, 53);
		panel_3.add(btnDelete);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Books.class.getResource("/Images/Add.png")));
		lblNewLabel_1.setBounds(10, 52, 50, 50);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(Books.class.getResource("/Images/Update.png")));
		lblNewLabel_1_1.setBounds(10, 142, 50, 50);
		panel_3.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon(Books.class.getResource("/Images/Delete.png")));
		lblNewLabel_1_2.setBounds(10, 236, 50, 50);
		panel_3.add(lblNewLabel_1_2);
		
		JButton btnGoBack = new JButton("Go back");
		btnGoBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGoBack.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Dashboard d=new Dashboard();
				d.setVisible(true);
				dispose();
			}
		});
		btnGoBack.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		btnGoBack.setFocusable(false);
		btnGoBack.setBorder(null);
		btnGoBack.setBackground(new Color(191, 255, 191));
		btnGoBack.setBounds(74, 332, 99, 53);
		panel_3.add(btnGoBack);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("");
		lblNewLabel_1_2_1.setIcon(new ImageIcon(Books.class.getResource("/Images/Open Pane.png")));
		lblNewLabel_1_2_1.setBounds(10, 335, 50, 50);
		panel_3.add(lblNewLabel_1_2_1);
		
		JButton btnAdd_1 = new JButton("");
		btnAdd_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				String title=textField.getText();
				String author=textField_1.getText();
				String qty=textField_2.getText();
				
				if(title.isEmpty() || author.isEmpty() || qty.isEmpty()) {
					JOptionPane.showMessageDialog(Books.this, "Please fill all details.");
				}
				else {
					
					try {
						Database d= new Database();
						d.addBook(title,author,qty);
						JOptionPane.showMessageDialog(Books.this, "Book added successfully.");

					} catch (SQLException e1) {
						 JOptionPane.showMessageDialog(Books.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

					}
					catch (NumberFormatException n1) {
						 JOptionPane.showMessageDialog(Books.this, "Exception occurred: " + n1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

					}
					
				}
			}
		});
		btnAdd_1.setIcon(new ImageIcon(Books.class.getResource("/Images/done.png")));
		btnAdd_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd_1.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		btnAdd_1.setFocusable(false);
		btnAdd_1.setBorder(null);
		btnAdd_1.setBackground(new Color(0, 115, 81));
		btnAdd_1.setBounds(378, 568, 149, 59);
		panel.add(btnAdd_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 115, 81));
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		textField_3 = new JTextField();
		textField_3.setText("Manage Books");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 40));
		textField_3.setFocusable(false);
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		textField_3.setBackground(new Color(0, 115, 81));
		textField_3.setBounds(387, 71, 288, 59);
		panel_1.add(textField_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Books.class.getResource("/Images/Books Emoji big.png")));
		lblNewLabel_2.setBounds(282, 53, 100, 100);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_3_1.setBackground(new Color(191, 255, 191));
		panel_3_1.setBounds(0, 52, 199, 586);
		panel_1.add(panel_3_1);
		
		JButton btnAdd_2 = new JButton("Add");
		btnAdd_2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnAdd_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd_2.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		btnAdd_2.setFocusable(false);
		btnAdd_2.setBorder(null);
		btnAdd_2.setBackground(new Color(191, 255, 191));
		btnAdd_2.setBounds(70, 52, 99, 53);
		panel_3_1.add(btnAdd_2);
		
		JButton btnUpdate_1 = new JButton("Update");
		btnUpdate_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnUpdate_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate_1.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		btnUpdate_1.setFocusable(false);
		btnUpdate_1.setBorder(null);
		btnUpdate_1.setBackground(new Color(191, 255, 191));
		btnUpdate_1.setBounds(70, 139, 99, 53);
		panel_3_1.add(btnUpdate_1);
		
		JButton btnDelete_1 = new JButton("Delete");
		btnDelete_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnDelete_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete_1.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		btnDelete_1.setFocusable(false);
		btnDelete_1.setBorder(null);
		btnDelete_1.setBackground(new Color(191, 255, 191));
		btnDelete_1.setBounds(70, 233, 99, 53);
		panel_3_1.add(btnDelete_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("");
		lblNewLabel_1_3.setIcon(new ImageIcon(Books.class.getResource("/Images/Add.png")));
		lblNewLabel_1_3.setBounds(10, 52, 50, 50);
		panel_3_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(Books.class.getResource("/Images/Update.png")));
		lblNewLabel_1_1_1.setBounds(10, 142, 50, 50);
		panel_3_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("");
		lblNewLabel_1_2_2.setIcon(new ImageIcon(Books.class.getResource("/Images/Delete.png")));
		lblNewLabel_1_2_2.setBounds(10, 236, 50, 50);
		panel_3_1.add(lblNewLabel_1_2_2);
		
		JButton btnGoBack_1 = new JButton("Go back");
		btnGoBack_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Dashboard d=new Dashboard();
				d.setVisible(true);
				dispose();
			}
		});
		btnGoBack_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGoBack_1.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		btnGoBack_1.setFocusable(false);
		btnGoBack_1.setBorder(null);
		btnGoBack_1.setBackground(new Color(191, 255, 191));
		btnGoBack_1.setBounds(74, 332, 99, 53);
		panel_3_1.add(btnGoBack_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("");
		lblNewLabel_1_2_1_1.setIcon(new ImageIcon(Books.class.getResource("/Images/Open Pane.png")));
		lblNewLabel_1_2_1_1.setBounds(10, 335, 50, 50);
		panel_3_1.add(lblNewLabel_1_2_1_1);
		
		txtBookId = new JTextField();
		txtBookId.setText("Book ID:");
		txtBookId.setHorizontalAlignment(SwingConstants.CENTER);
		txtBookId.setForeground(Color.WHITE);
		txtBookId.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		txtBookId.setFocusable(false);
		txtBookId.setColumns(10);
		txtBookId.setBorder(null);
		txtBookId.setBackground(new Color(0, 115, 81));
		txtBookId.setBounds(275, 187, 168, 40);
		panel_1.add(txtBookId);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 27));
		textField_5.setColumns(10);
		textField_5.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		textField_5.setBounds(298, 229, 325, 59);
		panel_1.add(textField_5);
		
		txtWhatYouWant = new JTextField();
		txtWhatYouWant.setText("What you want to update:");
		txtWhatYouWant.setHorizontalAlignment(SwingConstants.CENTER);
		txtWhatYouWant.setForeground(Color.WHITE);
		txtWhatYouWant.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		txtWhatYouWant.setFocusable(false);
		txtWhatYouWant.setColumns(10);
		txtWhatYouWant.setBorder(null);
		txtWhatYouWant.setBackground(new Color(0, 115, 81));
		txtWhatYouWant.setBounds(282, 310, 373, 40);
		panel_1.add(txtWhatYouWant);
		
		txtEnterNewValue = new JTextField();
		txtEnterNewValue.setText("Enter new value:");
		txtEnterNewValue.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterNewValue.setForeground(Color.WHITE);
		txtEnterNewValue.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		txtEnterNewValue.setFocusable(false);
		txtEnterNewValue.setColumns(10);
		txtEnterNewValue.setBorder(null);
		txtEnterNewValue.setBackground(new Color(0, 115, 81));
		txtEnterNewValue.setBounds(282, 427, 288, 40);
		panel_1.add(txtEnterNewValue);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 27));
		textField_6.setColumns(10);
		textField_6.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		textField_6.setBounds(298, 468, 325, 59);
		panel_1.add(textField_6);
		
		JButton btnAdd_1_1 = new JButton("");
		btnAdd_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd_1_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				String id=textField_5.getText();
				String column=(String) comboBox.getSelectedItem();
				column.trim();
				String newValue=textField_6.getText();
				if(id.isEmpty() || newValue.isEmpty()) {
					JOptionPane.showMessageDialog(Books.this, "Please fill all details.");
				}
				else {
					try {
						Database d= new Database();
						boolean check=d.checkID(id);
						if(!check) {
							JOptionPane.showMessageDialog(Books.this, "Invalid Book ID.");
							return;
						}
						d.updateBook(id,column,newValue);
						JOptionPane.showMessageDialog(Books.this, "Book updated successfully.");

					} catch (SQLException e1) {
						 JOptionPane.showMessageDialog(Books.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
					catch (NumberFormatException n1) {
						 JOptionPane.showMessageDialog(Books.this, "Exception occurred: " + n1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

					}
				}
			}
		});
		btnAdd_1_1.setIcon(new ImageIcon(Books.class.getResource("/Images/done.png")));
		btnAdd_1_1.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		btnAdd_1_1.setFocusable(false);
		btnAdd_1_1.setBorder(null);
		btnAdd_1_1.setBackground(new Color(0, 115, 81));
		btnAdd_1_1.setBounds(378, 568, 149, 59);
		panel_1.add(btnAdd_1_1);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 27));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"  Title", "  Author", "  Quantity"}));
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		comboBox.setBounds(298, 350, 325, 59);
		panel_1.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 115, 81));
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
		
		textField_4 = new JTextField();
		textField_4.setText("Manage Books");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setForeground(Color.WHITE);
		textField_4.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 40));
		textField_4.setFocusable(false);
		textField_4.setColumns(10);
		textField_4.setBorder(null);
		textField_4.setBackground(new Color(0, 115, 81));
		textField_4.setBounds(387, 71, 288, 59);
		panel_2.add(textField_4);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(Books.class.getResource("/Images/Books Emoji big.png")));
		lblNewLabel_2_1.setBounds(282, 53, 100, 100);
		panel_2.add(lblNewLabel_2_1);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setLayout(null);
		panel_3_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_3_1_1.setBackground(new Color(191, 255, 191));
		panel_3_1_1.setBounds(0, 52, 199, 586);
		panel_2.add(panel_3_1_1);
		
		JButton btnAdd_2_1 = new JButton("Add");
		btnAdd_2_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnAdd_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd_2_1.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		btnAdd_2_1.setFocusable(false);
		btnAdd_2_1.setBorder(null);
		btnAdd_2_1.setBackground(new Color(191, 255, 191));
		btnAdd_2_1.setBounds(70, 52, 99, 53);
		panel_3_1_1.add(btnAdd_2_1);
		
		JButton btnUpdate_1_1 = new JButton("Update");
		btnUpdate_1_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnUpdate_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate_1_1.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		btnUpdate_1_1.setFocusable(false);
		btnUpdate_1_1.setBorder(null);
		btnUpdate_1_1.setBackground(new Color(191, 255, 191));
		btnUpdate_1_1.setBounds(70, 139, 99, 53);
		panel_3_1_1.add(btnUpdate_1_1);
		
		JButton btnDelete_1_1 = new JButton("Delete");
		btnDelete_1_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnDelete_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete_1_1.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		btnDelete_1_1.setFocusable(false);
		btnDelete_1_1.setBorder(null);
		btnDelete_1_1.setBackground(new Color(191, 255, 191));
		btnDelete_1_1.setBounds(70, 233, 99, 53);
		panel_3_1_1.add(btnDelete_1_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("");
		lblNewLabel_1_3_1.setIcon(new ImageIcon(Books.class.getResource("/Images/Add.png")));
		lblNewLabel_1_3_1.setBounds(10, 52, 50, 50);
		panel_3_1_1.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1.setIcon(new ImageIcon(Books.class.getResource("/Images/Update.png")));
		lblNewLabel_1_1_1_1.setBounds(10, 142, 50, 50);
		panel_3_1_1.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("");
		lblNewLabel_1_2_2_1.setIcon(new ImageIcon(Books.class.getResource("/Images/Delete.png")));
		lblNewLabel_1_2_2_1.setBounds(10, 236, 50, 50);
		panel_3_1_1.add(lblNewLabel_1_2_2_1);
		
		JButton btnGoBack_1_1 = new JButton("Go back");
		btnGoBack_1_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Dashboard d=new Dashboard();
				d.setVisible(true);
				dispose();
			}
		});
		btnGoBack_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGoBack_1_1.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		btnGoBack_1_1.setFocusable(false);
		btnGoBack_1_1.setBorder(null);
		btnGoBack_1_1.setBackground(new Color(191, 255, 191));
		btnGoBack_1_1.setBounds(74, 332, 99, 53);
		panel_3_1_1.add(btnGoBack_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("");
		lblNewLabel_1_2_1_1_1.setIcon(new ImageIcon(Books.class.getResource("/Images/Open Pane.png")));
		lblNewLabel_1_2_1_1_1.setBounds(10, 335, 50, 50);
		panel_3_1_1.add(lblNewLabel_1_2_1_1_1);
		
		textField_7 = new JTextField();
		textField_7.setText("Book ID:");
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setForeground(Color.WHITE);
		textField_7.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		textField_7.setFocusable(false);
		textField_7.setColumns(10);
		textField_7.setBorder(null);
		textField_7.setBackground(new Color(0, 115, 81));
		textField_7.setBounds(297, 255, 168, 40);
		panel_2.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 27));
		textField_8.setColumns(10);
		textField_8.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		textField_8.setBounds(311, 306, 325, 59);
		panel_2.add(textField_8);
		
		JButton btnAdd_1_1_1 = new JButton("");
		btnAdd_1_1_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				String id=textField_8.getText();
				if(id.isEmpty()) {
					JOptionPane.showMessageDialog(Books.this, "Please enter book ID.");
				}
				else {
					try {
						Database d= new Database();
						boolean check=d.checkID(id);
						if(!check) {
							JOptionPane.showMessageDialog(Books.this, "Invalid Book ID.");
							return;
						}
						d.deleteBook(id);
						JOptionPane.showMessageDialog(Books.this, "Book deleted successfully.");

					} catch (SQLException e1) {
						 JOptionPane.showMessageDialog(Books.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnAdd_1_1_1.setIcon(new ImageIcon(Books.class.getResource("/Images/done.png")));
		btnAdd_1_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd_1_1_1.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		btnAdd_1_1_1.setFocusable(false);
		btnAdd_1_1_1.setBorder(null);
		btnAdd_1_1_1.setBackground(new Color(0, 115, 81));
		btnAdd_1_1_1.setBounds(375, 453, 149, 59);
		panel_2.add(btnAdd_1_1_1);
	}
}

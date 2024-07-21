import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.Cursor;

public class AddPlaylist extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPlaylistName;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPlaylist frame = new AddPlaylist();
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
	public AddPlaylist() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 150, 544, 315);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPlaylistName = new JTextField();
		txtPlaylistName.setText("Playlist Name:");
		txtPlaylistName.setForeground(Color.WHITE);
		txtPlaylistName.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		txtPlaylistName.setFocusable(false);
		txtPlaylistName.setColumns(10);
		txtPlaylistName.setBorder(null);
		txtPlaylistName.setBackground(Color.BLACK);
		txtPlaylistName.setBounds(176, 36, 209, 42);
		contentPane.add(txtPlaylistName);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_1.setBounds(76, 91, 393, 53);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				String pname=textField_1.getText();
				if(pname.isEmpty()) {
					JOptionPane.showMessageDialog(AddPlaylist.this,"Please enter Playlist Name.");
				}
				else {
					try {
						Database d=new Database();
						int uid=d.getUserID(LoginPage.getEmail());
						if(uid==0) {
							uid=d.getLastUserID();
						}
						boolean check=d.checkPlaylist(pname);
						if(check) {
							JOptionPane.showMessageDialog(AddPlaylist.this,"Duplicate Playlist Name. Use another name. ");	
							return;
						}
						d.addPlaylist(uid,pname);
						HomePage h=new HomePage();
						h.setVisible(true);
						dispose();
					} catch (SQLException e1) {
						 JOptionPane.showMessageDialog(AddPlaylist.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

					}
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(AddPlaylist.class.getResource("/Images/done.png")));
		btnNewButton.setFocusable(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(86, 171, 156, 68);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AddPlaylist.class.getResource("/Images/cancel.png")));
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setBounds(274, 171, 156, 68);
		contentPane.add(btnNewButton_1);
	}
}

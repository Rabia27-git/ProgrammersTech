import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class DeleteSong extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtDoubleClickTo;
	private DefaultListModel<String> songListModel11;
	private JList<String> song;
	int pid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteSong frame = new DeleteSong();
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
	public DeleteSong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 5, 755, 661);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 65, 65));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				HomePage h=new HomePage();
				h.setVisible(true);
				dispose();
			}
		});
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setIcon(new ImageIcon(DeleteSong.class.getResource("/Images/back.png")));
		lblNewLabel.setBounds(20, 11, 66, 65);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setText("Spotify");
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		textField.setFocusable(false);
		textField.setColumns(10);
		textField.setCaretColor(Color.WHITE);
		textField.setBorder(null);
		textField.setBackground(new Color(65, 65, 65));
		textField.setBounds(333, 21, 113, 43);
		contentPane.add(textField);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(DeleteSong.class.getResource("/Images/Spotify.png")));
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBackground(new Color(65, 65, 65));
		btnNewButton_2.setBounds(278, 21, 45, 51);
		contentPane.add(btnNewButton_2);
		
		txtDoubleClickTo = new JTextField();
		txtDoubleClickTo.setFocusable(false);
		txtDoubleClickTo.setText("Double click to delete a Song");
		txtDoubleClickTo.setForeground(Color.WHITE);
		txtDoubleClickTo.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		txtDoubleClickTo.setColumns(10);
		txtDoubleClickTo.setCaretColor(Color.WHITE);
		txtDoubleClickTo.setBorder(null);
		txtDoubleClickTo.setBackground(new Color(65, 65, 65));
		txtDoubleClickTo.setBounds(183, 96, 368, 43);
		contentPane.add(txtDoubleClickTo);
		
		songListModel11 = new DefaultListModel<>();
		song = new JList<>(songListModel11);
		song.setForeground(new Color(255, 255, 255));
		song.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		song.setBackground(new Color(65, 65, 65));
		song.setFont(new Font("Monospaced", Font.BOLD, 20));
		song.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(20, 150, 699, 450);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(song);
		
		try {
			Database d=new Database();
			String pname=HomePage.getPname();
			pid=d.getPID(pname);
			d.loadSongs(pid, songListModel11);
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(DeleteSong.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

		}
		
		
		song.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(e.getClickCount()>1) {
					  int index=song.getSelectedIndex();
					  if(index!=-1 && index!=0) {
						 String originalString = songListModel11.getElementAt(index);
	                         String songTitle=originalString.substring(0, 25).trim();
	                         String artist=originalString.substring(26, 46).trim();
	                         try {
								Database d=new Database();
								int sid=d.getSongID(songTitle,artist);
								d.deleteSong(sid,pid);
								JOptionPane.showMessageDialog(DeleteSong.this, "Song deleted Successfully");
								HomePage h=new HomePage();
								h.setVisible(true);
								dispose();
							} catch (SQLException e1) {
								JOptionPane.showMessageDialog(DeleteSong.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

							}
	                         
	                         
						  
					  }
				}
				
			}
		});

	}
}

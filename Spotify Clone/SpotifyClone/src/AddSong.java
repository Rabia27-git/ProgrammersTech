import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.border.LineBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class AddSong extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtWhichSongDo;
	private JLabel lblNewLabel_1;
	private DefaultListModel<String> songListModel10;
	private JList<String> songs;
	private JTextField txtDoubleClickTo;
	private JTextField txtSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSong frame = new AddSong();
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
	public AddSong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 5, 755, 661);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 65, 65));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				HomePage h=new HomePage();
				h.setVisible(true);
				dispose();
			}
		});
		lblNewLabel.setIcon(new ImageIcon(AddSong.class.getResource("/Images/back.png")));
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
		btnNewButton_2.setIcon(new ImageIcon(AddSong.class.getResource("/Images/Spotify.png")));
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBackground(new Color(65, 65, 65));
		btnNewButton_2.setBounds(278, 21, 45, 51);
		contentPane.add(btnNewButton_2);
		
		txtWhichSongDo = new JTextField();
		txtWhichSongDo.setForeground(Color.WHITE);
		txtWhichSongDo.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		txtWhichSongDo.setColumns(10);
		txtWhichSongDo.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txtWhichSongDo.setBackground(new Color(65, 65, 65));
		txtWhichSongDo.setBounds(176, 75, 398, 54);
		contentPane.add(txtWhichSongDo);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				String song=txtWhichSongDo.getText().toLowerCase();
				if(!song.isEmpty()) {
					try {
						Database d=new Database();
						d.searchSong(song,songListModel10);
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(AddSong.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

					}
					
				}
				else {
					JOptionPane.showMessageDialog(AddSong.this, "Please write something to search.");
				}
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(AddSong.class.getResource("/Images/Music search.png")));
		lblNewLabel_1.setBounds(584, 75, 49, 54);
		contentPane.add(lblNewLabel_1);
		
		songListModel10 = new DefaultListModel<>();
		songs = new JList<>(songListModel10);
		songs.setForeground(new Color(255, 255, 255));
		songs.setFont(new Font("Monospaced", Font.BOLD, 20));
		songs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		songs.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		songs.setBackground(new Color(65, 65, 65));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(10, 185, 721, 428);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(songs);
		
		txtDoubleClickTo = new JTextField();
		txtDoubleClickTo.setText("Double click to add a Song");
		txtDoubleClickTo.setForeground(Color.WHITE);
		txtDoubleClickTo.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		txtDoubleClickTo.setColumns(10);
		txtDoubleClickTo.setCaretColor(Color.WHITE);
		txtDoubleClickTo.setBorder(null);
		txtDoubleClickTo.setBackground(new Color(65, 65, 65));
		txtDoubleClickTo.setBounds(176, 132, 349, 43);
		contentPane.add(txtDoubleClickTo);
		
		txtSearch = new JTextField();
		txtSearch.setFocusable(false);
		txtSearch.setText("Search:");
		txtSearch.setForeground(Color.WHITE);
		txtSearch.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		txtSearch.setColumns(10);
		txtSearch.setCaretColor(Color.WHITE);
		txtSearch.setBorder(null);
		txtSearch.setBackground(new Color(65, 65, 65));
		txtSearch.setBounds(60, 83, 100, 43);
		contentPane.add(txtSearch);
		try {
			Database d=new Database();
			d.loadAllSongs(songListModel10);
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(AddSong.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

		}
		
		songs.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(e.getClickCount()>1) {
					  int index=songs.getSelectedIndex();
					  if(index!=-1 && index!=0) {
						 String originalString = songListModel10.getElementAt(index);
	                         String songTitle=originalString.substring(0, 25).trim();
	                         String artist=originalString.substring(26, 46).trim();
	                         try {
								Database d=new Database();
								String pname=HomePage.getPname();
								int sid=d.getSongID(songTitle,artist);
								int pid=d.getPID(pname);
								d.addSong(sid,pid);
								JOptionPane.showMessageDialog(AddSong.this, "Song added Successfully");
								HomePage h=new HomePage();
								h.setVisible(true);
								dispose();
							} catch (SQLException e1) {
								JOptionPane.showMessageDialog(AddSong.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

							}
	                         
	                         
						  
					  }
				}
			}
		});
		
		
		
		

        
	}
}

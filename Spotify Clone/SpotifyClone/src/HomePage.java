import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.border.LineBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JList;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.UIManager;

public class HomePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtH;
	private JTextField txtSearch;
	private JTextField txtYourPlaylist;
	private JTextField txtRecommendedPlaylists;
	private JTextField txtWhatDoYou;
	private JPopupMenu popupMenu;
	private JMenuItem logoutItem;
	private JMenuItem myProfileItem;
	private JTextField playlistName;
	private DefaultListModel<String> songListModel;
	private JList<String> songsList;
	int pid;
	JButton btnNewButton_6;
	private JTextField txtNoResult;
	JButton playlist;
	JLabel lblNewLabel_1_1_1;
	JLabel lblNewLabel_1_1_1_2;
	JLabel lblNewLabel_1_1_1_3;
	JLabel lblNewLabel_1_1_1_4;
	JLabel lblNewLabel_1_1_1_5;
	JLabel lblNewLabel_1_1_1_7;
	JLabel lblNewLabel_1_1_1_8_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private DefaultListModel<String> songListModel1;
	private JList<String> playlistList;
	JPanel contentPane1;
	private JTextField textField_4;
	private DefaultListModel<String> songListModel2;
	private JList<String> list;
	static String nameOfPlaylist;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 5, 1026, 668);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel homeSearch = new JPanel();
		homeSearch.setBackground(new Color(65, 65, 65));
		homeSearch.setBounds(10, 0, 251, 125);
		contentPane.add(homeSearch);
		homeSearch.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(HomePage.class.getResource("/Images/Home.png")));
		lblNewLabel.setBounds(10, 22, 49, 44);
		homeSearch.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(HomePage.class.getResource("/Images/Search.png")));
		lblNewLabel_1.setBounds(10, 77, 49, 44);
		homeSearch.add(lblNewLabel_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(271, -75, 741, 588);
		contentPane.add(tabbedPane);
		
		txtH = new JTextField();
		txtH.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		txtH.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtH.setForeground(new Color(255, 255, 255));
		txtH.setFocusable(false);
		txtH.setBorder(null);
		txtH.setBackground(new Color(65, 65, 65));
		txtH.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		txtH.setText("Home");
		txtH.setBounds(75, 32, 96, 34);
		homeSearch.add(txtH);
		txtH.setColumns(10);
		
		txtSearch = new JTextField();
		txtSearch.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		txtSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtSearch.setForeground(new Color(255, 255, 255));
		txtSearch.setText("Search");
		txtSearch.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		txtSearch.setColumns(10);
		txtSearch.setBorder(null);
		txtSearch.setBackground(new Color(65, 65, 65));
		txtSearch.setBounds(75, 77, 96, 34);
		homeSearch.add(txtSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 136, 251, 374);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(65, 65, 65));
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		txtYourPlaylist = new JTextField();
		txtYourPlaylist.setText("Your Playlists");
		txtYourPlaylist.setForeground(Color.WHITE);
		txtYourPlaylist.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		txtYourPlaylist.setColumns(10);
		txtYourPlaylist.setBorder(null);
		txtYourPlaylist.setBackground(new Color(65, 65, 65));
		txtYourPlaylist.setBounds(10, 11, 181, 34);
		panel.add(txtYourPlaylist);
		
		JLabel lblNewLabel_1_1 = new JLabel("+");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
			AddPlaylist a=new AddPlaylist();
			a.setVisible(true);
			}
		});
		lblNewLabel_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 50));
		lblNewLabel_1_1.setBounds(190, 2, 49, 40);
		panel.add(lblNewLabel_1_1);
		
		songListModel1 = new DefaultListModel<>();
		playlistList = new JList<>(songListModel1);
		playlistList.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		playlistList.setFont(new Font("Segoe UI Black", Font.PLAIN, 23));
		playlistList.setBorder(null);
        playlistList.setForeground(new Color(255, 255, 255));
        playlistList.setBackground(new Color(65, 65, 65));
        
		JScrollPane scrollPane_2 = new JScrollPane(playlistList);
		scrollPane_2.setBorder(null);
		scrollPane_2.setBackground(new Color(65, 65, 65));
		scrollPane_2.setBounds(10, 69, 229, 292);
		panel.add(scrollPane_2);
		scrollPane_2.setViewportView(playlistList);
		try {
			Database d=new Database();
			int uid=d.getUserID(LoginPage.getEmail());
			if(uid==0) {
				uid=d.getLastUserID();
			}
			d.loadPlaylists(uid,songListModel1);
		} catch (SQLException e1) {
			 JOptionPane.showMessageDialog(HomePage.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(65, 65, 65));
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel profile = new JLabel("");
		profile.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				popupMenu.setVisible(true);
		        popupMenu.show(profile, 0, profile.getHeight());
			}
		});
		profile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		profile.setBounds(677, 58, 49, 40);
		panel_1.add(profile);
		profile.setIcon(new ImageIcon(HomePage.class.getResource("/Images/Account.png")));
		profile.setForeground(Color.WHITE);
		profile.setFont(new Font("Segoe UI Black", Font.PLAIN, 50));
		
		txtRecommendedPlaylists = new JTextField();
		txtRecommendedPlaylists.setText("Recommended Playlists");
		txtRecommendedPlaylists.setForeground(Color.WHITE);
		txtRecommendedPlaylists.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		txtRecommendedPlaylists.setFocusable(false);
		txtRecommendedPlaylists.setColumns(10);
		txtRecommendedPlaylists.setBorder(null);
		txtRecommendedPlaylists.setBackground(new Color(65, 65, 65));
		txtRecommendedPlaylists.setBounds(24, 60, 353, 40);
		panel_1.add(txtRecommendedPlaylists);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				pid=1;
				tabbedPane.setSelectedIndex(2);
				btnNewButton_6.setIcon(new ImageIcon(HomePage.class.getResource("/Images/arjit.png")));
	        	playlistName.setText("Arjit Singh");
				try {
					Database d=new Database();
					d.loadSongs(pid,songListModel);
				} catch (SQLException e1) {
					 JOptionPane.showMessageDialog(HomePage.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(HomePage.class.getResource("/Images/arjit.png")));
		btnNewButton.setBackground(new Color(65, 65, 65));
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBounds(10, 128, 230, 210);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				pid=2;
				tabbedPane.setSelectedIndex(2);
				btnNewButton_6.setIcon(new ImageIcon(HomePage.class.getResource("/Images/coke studio.png")));
	        	playlistName.setText("Coke Studio");
	        	try {
					Database d=new Database();
					d.loadSongs(pid,songListModel);
				} catch (SQLException e1) {
					 JOptionPane.showMessageDialog(HomePage.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(HomePage.class.getResource("/Images/coke studio.png")));
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnNewButton_1.setBackground(new Color(65, 65, 65));
		btnNewButton_1.setBounds(254, 128, 230, 210);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				pid=3;
				tabbedPane.setSelectedIndex(2);
				btnNewButton_6.setIcon(new ImageIcon(HomePage.class.getResource("/Images/desi hits.png")));
	        	playlistName.setText("Desi Hits");
	        	try {
					Database d=new Database();
					d.loadSongs(pid,songListModel);
				} catch (SQLException e1) {
					 JOptionPane.showMessageDialog(HomePage.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(HomePage.class.getResource("/Images/desi hits.png")));
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnNewButton_2.setBackground(new Color(65, 65, 65));
		btnNewButton_2.setBounds(496, 128, 230, 210);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				pid=4;
				tabbedPane.setSelectedIndex(2);
				btnNewButton_6.setIcon(new ImageIcon(HomePage.class.getResource("/Images/drama osts.png")));
	        	playlistName.setText("Drama OSTs");
	        	try {
					Database d=new Database();
					d.loadSongs(pid,songListModel);
				} catch (SQLException e1) {
					 JOptionPane.showMessageDialog(HomePage.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(HomePage.class.getResource("/Images/drama osts.png")));
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnNewButton_3.setBackground(new Color(65, 65, 65));
		btnNewButton_3.setBounds(10, 343, 230, 210);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				pid=5;
				tabbedPane.setSelectedIndex(2);
		       	btnNewButton_6.setIcon(new ImageIcon(HomePage.class.getResource("/Images/hot hits.png")));
	        	playlistName.setText("Hot hits");
	        	try {
					Database d=new Database();
					d.loadSongs(pid,songListModel);
				} catch (SQLException e1) {
					 JOptionPane.showMessageDialog(HomePage.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(HomePage.class.getResource("/Images/hot hits.png")));
		btnNewButton_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnNewButton_4.setBackground(new Color(65, 65, 65));
		btnNewButton_4.setBounds(254, 343, 230, 210);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				pid=6;
				tabbedPane.setSelectedIndex(2);
	        	btnNewButton_6.setIcon(new ImageIcon(HomePage.class.getResource("/Images/shaddi hits.png")));
	        	playlistName.setText("Shaddi hits");
	        	try {
					Database d=new Database();
					d.loadSongs(pid,songListModel);
				} catch (SQLException e1) {
					 JOptionPane.showMessageDialog(HomePage.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		btnNewButton_5.setIcon(new ImageIcon(HomePage.class.getResource("/Images/shaddi hits.png")));
		btnNewButton_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnNewButton_5.setBackground(new Color(65, 65, 65));
		btnNewButton_5.setBounds(496, 343, 230, 210);
		panel_1.add(btnNewButton_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(65, 65, 65));
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				popupMenu.setVisible(true);
		        popupMenu.show(lblNewLabel_1_1_1_1, 0, lblNewLabel_1_1_1_1.getHeight());
			}
		});
		lblNewLabel_1_1_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1_1_1_1.setIcon(new ImageIcon(HomePage.class.getResource("/Images/Account.png")));
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 50));
		lblNewLabel_1_1_1_1.setBounds(677, 60, 49, 40);
		panel_2.add(lblNewLabel_1_1_1_1);
		
		txtWhatDoYou = new JTextField();
		txtWhatDoYou.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				txtWhatDoYou.setText("");
			}
		});
		txtWhatDoYou.setBackground(new Color(128, 128, 128));
		txtWhatDoYou.setForeground(new Color(255, 255, 255));
		txtWhatDoYou.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		txtWhatDoYou.setText("What do you want to play?");
		txtWhatDoYou.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txtWhatDoYou.setBounds(29, 65, 418, 54);
		panel_2.add(txtWhatDoYou);
		txtWhatDoYou.setColumns(10);
		
		popupMenu = new JPopupMenu();
		myProfileItem = new JMenuItem("My Profile");
		myProfileItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profile p=new Profile();
				p.setVisible(true);
				dispose();
			}
        });
		
		logoutItem = new JMenuItem("Log Out");
		logoutItem.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent e) {
		           Login l=new Login();
		           l.setVisible(true);
		           dispose(); 
		     }
		 });
		
		popupMenu.add(myProfileItem);
        popupMenu.add(logoutItem);
        profile.setComponentPopupMenu(popupMenu);
        lblNewLabel_1_1_1_1.setComponentPopupMenu(popupMenu);
        
        JLabel lblNewLabel_1_2 = new JLabel("");
        lblNewLabel_1_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblNewLabel_1_2.addMouseListener(new MouseAdapter() {
        	public void mousePressed(MouseEvent e) {
        		int plid;
        		String search=txtWhatDoYou.getText();
        		if(!search.isEmpty()) {
        			try {
						Database d=new Database();
						plid=d.search(search);
						
						if (txtNoResult != null) {
			                panel_2.remove(txtNoResult);
			                txtNoResult = null;
			            }
			            if (playlist != null) {
			                panel_2.remove(playlist);
			                playlist = null;
			            }
			            
						if(plid==0) {
							txtNoResult = new JTextField();
					        txtNoResult.setText("No result found");
					        txtNoResult.setForeground(Color.WHITE);
					        txtNoResult.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
					        txtNoResult.setFocusable(false);
					        txtNoResult.setColumns(10);
					        txtNoResult.setBorder(null);
					        txtNoResult.setBackground(new Color(65, 65, 65));
					        txtNoResult.setBounds(170, 250, 255, 40);
					        panel_2.add(txtNoResult);
						}
						else {
							String address=d.getPicture(plid);
							playlist = new JButton("");
					        playlist.setBorder(new LineBorder(new Color(0, 0, 0), 2));
					        playlist.setBackground(new Color(65, 65, 65));
					        playlist.setIcon(new ImageIcon(HomePage.class.getResource(address)));
					        playlist.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					        playlist.setBounds(245, 184, 230, 210);
					        playlist.addMouseListener(new MouseAdapter() {
					            public void mouseClicked(MouseEvent e) {
					            	try {
					            		tabbedPane.setSelectedIndex(2);
										Database d=new Database();
										d.loadSongs(plid,songListModel);
										btnNewButton_6.setIcon(new ImageIcon(HomePage.class.getResource(address)));
					    	        	playlistName.setText(d.playlistName(plid));
									} catch (SQLException e1) {
										 JOptionPane.showMessageDialog(HomePage.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
									}
								
								}
					        });	
					        panel_2.add(playlist);
						}
						
						panel_2.revalidate();
			            panel_2.repaint();
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(HomePage.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

					}
        		}
        	}
        });
        lblNewLabel_1_2.setIcon(new ImageIcon(HomePage.class.getResource("/Images/Music search.png")));
        lblNewLabel_1_2.setBounds(457, 65, 49, 54);
        panel_2.add(lblNewLabel_1_2);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(65, 65, 65));
        tabbedPane.addTab("New tab", null, panel_3, null);
        panel_3.setLayout(null);
        
        btnNewButton_6 = new JButton("");
        btnNewButton_6.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        btnNewButton_6.setBackground(new Color(65, 65, 65));
        btnNewButton_6.setBounds(99, 62, 230, 210);
        panel_3.add(btnNewButton_6);
        
        playlistName = new JTextField();
        playlistName.setText("name");
        playlistName.setForeground(Color.WHITE);
        playlistName.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
        playlistName.setFocusable(false);
        playlistName.setColumns(10);
        playlistName.setBorder(null);
        playlistName.setBackground(new Color(65, 65, 65));
        playlistName.setBounds(352, 94, 353, 49);
        panel_3.add(playlistName);
        
        songListModel = new DefaultListModel<>();
        songsList = new JList<>(songListModel);
        songsList.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        songsList.setBorder(null);
        songsList.setForeground(new Color(255, 255, 255));
        songsList.setFont(new Font("Monospaced", Font.BOLD, 21));
        songsList.setBackground(new Color(65, 65, 65));
        JScrollPane scrollPane_1 = new JScrollPane(songsList);
        scrollPane_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        scrollPane_1.setBounds(10, 283, 716, 266);
        panel_3.add(scrollPane_1);
        scrollPane_1.setViewportView(songsList);
        
        JPanel panel_5 = new JPanel();
        panel_5.setBackground(new Color(65, 65, 65));
        tabbedPane.addTab("New tab", null, panel_5, null);
        panel_5.setLayout(null);
        
        JButton btnNewButton_6_1 = new JButton("");
        btnNewButton_6_1.setIcon(new ImageIcon(HomePage.class.getResource("/Images/Music.png")));
        btnNewButton_6_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        btnNewButton_6_1.setBackground(new Color(65, 65, 65));
        btnNewButton_6_1.setBounds(35, 63, 230, 210);
        panel_5.add(btnNewButton_6_1);
        
        textField_4 = new JTextField();
        textField_4.setText("name");
        textField_4.setForeground(Color.WHITE);
        textField_4.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
        textField_4.setFocusable(false);
        textField_4.setColumns(10);
        textField_4.setBorder(null);
        textField_4.setBackground(new Color(65, 65, 65));
        textField_4.setBounds(287, 89, 353, 49);
        panel_5.add(textField_4);
        
        JLabel lblNewLabel_1_1_2 = new JLabel();
        lblNewLabel_1_1_2.setToolTipText("Delete playlist");
        lblNewLabel_1_1_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblNewLabel_1_1_2.setIcon(new ImageIcon(HomePage.class.getResource("/Images/Trash Can.png")));
        lblNewLabel_1_1_2.setForeground(Color.WHITE);
        lblNewLabel_1_1_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 50));
        lblNewLabel_1_1_2.setBounds(580, 223, 50, 50);
        panel_5.add(lblNewLabel_1_1_2);
        
        JLabel lblNewLabel_1_1_3 = new JLabel("");
        lblNewLabel_1_1_3.setToolTipText("Edit Playlist Name");
        lblNewLabel_1_1_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblNewLabel_1_1_3.setIcon(new ImageIcon(HomePage.class.getResource("/Images/Edit.png")));
        lblNewLabel_1_1_3.setForeground(Color.WHITE);
        lblNewLabel_1_1_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 50));
        lblNewLabel_1_1_3.setBounds(653, 223, 50, 50);
        panel_5.add(lblNewLabel_1_1_3);
        
        songListModel2 = new DefaultListModel<>();
        list = new JList<>(songListModel2);
        list.setBorder(null);
        list.setForeground(new Color(255, 255, 255));
        list.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        list.setFont(new Font("Monospaced", Font.BOLD, 20));
        list.setBackground(new Color(65, 65, 65));
        JScrollPane scrollPane_3 = new JScrollPane();
        scrollPane_3.setBackground(new Color(65, 65, 65));
        scrollPane_3.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        scrollPane_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        scrollPane_3.setBounds(35, 302, 668, 247);
        panel_5.add(scrollPane_3);
        scrollPane_3.setViewportView(list);
        
        JLabel addSong = new JLabel();
        addSong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addSong.setIcon(new ImageIcon(HomePage.class.getResource("/Images/songAdd.png")));
        addSong.setToolTipText("Add Song");
        addSong.setForeground(Color.WHITE);
        addSong.setFont(new Font("Segoe UI Black", Font.PLAIN, 50));
        addSong.setBounds(277, 223, 50, 50);
        panel_5.add(addSong);
        
        JLabel deleteSong = new JLabel();
        deleteSong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deleteSong.setIcon(new ImageIcon(HomePage.class.getResource("/Images/deleteSng.png")));
        deleteSong.setToolTipText("Delete Song");
        deleteSong.setForeground(Color.WHITE);
        deleteSong.setFont(new Font("Segoe UI Black", Font.PLAIN, 50));
        deleteSong.setBounds(358, 223, 50, 50);
        panel_5.add(deleteSong);
     
        
        lblNewLabel_1_1_1_2 = new JLabel("");
        lblNewLabel_1_1_1_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblNewLabel_1_1_1_2.setToolTipText("Next");
        lblNewLabel_1_1_1_2.setIcon(new ImageIcon(HomePage.class.getResource("/Images/Last.png")));
        lblNewLabel_1_1_1_2.setForeground(Color.WHITE);
        lblNewLabel_1_1_1_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 50));
        lblNewLabel_1_1_1_2.setBounds(541, 528, 50, 50);
        contentPane.add(lblNewLabel_1_1_1_2);
        
        lblNewLabel_1_1_1_3 = new JLabel("");
        lblNewLabel_1_1_1_3.setToolTipText("Previous");
        lblNewLabel_1_1_1_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblNewLabel_1_1_1_3.setIcon(new ImageIcon(HomePage.class.getResource("/Images/Previous.png")));
        lblNewLabel_1_1_1_3.setForeground(Color.WHITE);
        lblNewLabel_1_1_1_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 50));
        lblNewLabel_1_1_1_3.setBounds(421, 528, 50, 50);
        contentPane.add(lblNewLabel_1_1_1_3);
        
        lblNewLabel_1_1_1_4 = new JLabel("");
        lblNewLabel_1_1_1_4.setToolTipText("Shuffle");
        lblNewLabel_1_1_1_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblNewLabel_1_1_1_4.setIcon(new ImageIcon(HomePage.class.getResource("/Images/Shuffle1.png")));
        lblNewLabel_1_1_1_4.setForeground(Color.WHITE);
        lblNewLabel_1_1_1_4.setFont(new Font("Segoe UI Black", Font.PLAIN, 50));
        lblNewLabel_1_1_1_4.setBounds(360, 528, 50, 50);
        contentPane.add(lblNewLabel_1_1_1_4);
        
        lblNewLabel_1_1_1_5 = new JLabel("");
        lblNewLabel_1_1_1_5.setToolTipText("Repeat");
        lblNewLabel_1_1_1_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblNewLabel_1_1_1_5.setIcon(new ImageIcon(HomePage.class.getResource("/Images/Repeat1.png")));
        lblNewLabel_1_1_1_5.setForeground(Color.WHITE);
        lblNewLabel_1_1_1_5.setFont(new Font("Segoe UI Black", Font.PLAIN, 50));
        lblNewLabel_1_1_1_5.setBounds(609, 526, 50, 50);
        contentPane.add(lblNewLabel_1_1_1_5);
        
        lblNewLabel_1_1_1_7 = new JLabel("");
        lblNewLabel_1_1_1_7.setToolTipText("Lyrics");
        lblNewLabel_1_1_1_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblNewLabel_1_1_1_7.setIcon(new ImageIcon(HomePage.class.getResource("/Images/Micro.png")));
        lblNewLabel_1_1_1_7.setForeground(Color.WHITE);
        lblNewLabel_1_1_1_7.setFont(new Font("Segoe UI Black", Font.PLAIN, 50));
        lblNewLabel_1_1_1_7.setBounds(737, 528, 40, 40);
        contentPane.add(lblNewLabel_1_1_1_7);
        
        ImageIcon play= new ImageIcon(HomePage.class.getResource("/Images/Circled Play.png"));
        ImageIcon pause= new ImageIcon(HomePage.class.getResource("/Images/Pause Button.png"));
        
        ImageIcon audio= new ImageIcon(HomePage.class.getResource("/Images/Audio.png"));
        ImageIcon noaudio= new ImageIcon(HomePage.class.getResource("/Images/No Audio.png"));
        
        JLabel btnNewButton_7 = new JLabel("");
        btnNewButton_7.setBackground(new Color(0, 0, 0));
        btnNewButton_7.setBorder(null);
        btnNewButton_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNewButton_7.setBounds(481, 528, 50, 50);
        btnNewButton_7.setIcon(play);
        contentPane.add(btnNewButton_7);
        
        JLabel btnNewButton_7_1 = new JLabel("");
        btnNewButton_7_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNewButton_7_1.setBorder(null);
        btnNewButton_7_1.setBackground(Color.BLACK);
        btnNewButton_7_1.setBounds(797, 528, 40, 40);
        btnNewButton_7_1.setIcon(audio);
        contentPane.add(btnNewButton_7_1);
        
        textField = new JTextField();
        textField.setCaretPosition(0);
        textField.setForeground(Color.WHITE);
        textField.setFont(new Font("Segoe UI Black", Font.PLAIN, 19));
        textField.setColumns(10);
        textField.setBorder(null);
        textField.setBackground(new Color(0, 0, 0));
        textField.setBounds(20, 530, 184, 40);
        contentPane.add(textField);
        
        textField_1 = new JTextField();
        textField_1.setForeground(Color.WHITE);
        textField_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
        textField_1.setColumns(10);
        textField_1.setBorder(null);
        textField_1.setBackground(Color.BLACK);
        textField_1.setBounds(20, 573, 184, 40);
        contentPane.add(textField_1);
        
        textField_2 = new JTextField();
        textField_2.setForeground(Color.WHITE);
        textField_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
        textField_2.setColumns(10);
        textField_2.setBorder(null);
        textField_2.setBackground(Color.BLACK);
        textField_2.setBounds(214, 581, 35, 32);
        contentPane.add(textField_2);
        
        textField_3 = new JTextField();
        textField_3.setCaretPosition(0);
        textField_3.setForeground(Color.WHITE);
        textField_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
        textField_3.setColumns(10);
        textField_3.setBorder(null);
        textField_3.setBackground(Color.BLACK);
        textField_3.setBounds(747, 579, 35, 32);
        contentPane.add(textField_3);
        
        JPanel panel_4 = new JPanel();
        panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        panel_4.setBackground(new Color(240, 240, 240));
        panel_4.setBounds(258, 589, 479, 14);
        contentPane.add(panel_4);
        
        JPanel panel_4_1 = new JPanel();
        panel_4_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        panel_4_1.setBackground(UIManager.getColor("Button.background"));
        panel_4_1.setBounds(847, 547, 155, 14);
        contentPane.add(panel_4_1);
        
        songsList.addMouseListener (new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount()>1){
                	int index=songsList.getSelectedIndex();
                    if (index != -1 && index != 0) {
                    	 String originalString = songListModel.getElementAt(index);
                         String songTitle="";
                         String artist="";
                         songTitle=originalString.substring(0, 21);
                         songTitle=songTitle.toUpperCase();
                         textField.setText(songTitle);
                         textField_2.setText("0:00");
                         artist=originalString.substring(26, 46);
                         artist=artist.toUpperCase();
                         textField_1.setText(artist);
                         textField_3.setText(originalString.substring(47, 51));
                        if (btnNewButton_7.getIcon().equals(play)) {
                        	btnNewButton_7.setIcon(pause);
                        }
                        btnNewButton_7.addMouseListener (new MouseAdapter() {
                            public void mouseClicked(MouseEvent e) {
                            	 if (btnNewButton_7.getIcon().equals(pause)) {
                                 	btnNewButton_7.setIcon(play);
                                 } 
                            	 else {
                            		 btnNewButton_7.setIcon(pause);
                            	 }
                            	
                            }
                        });	
                        
                        btnNewButton_7_1.addMouseListener (new MouseAdapter() {
                            public void mouseClicked(MouseEvent e) {
                            	 if (btnNewButton_7_1.getIcon().equals(audio)) {
                            		 btnNewButton_7_1.setIcon(noaudio);
                                 } 
                            	 else {
                            		 btnNewButton_7_1.setIcon(audio);
                            	 }
                            	
                            }
                        });	
        		        
                    }
                }
            }

        });	
        
        playlistList.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
			  if(e.getClickCount()==1) {
			  int index=playlistList.getSelectedIndex();
			  if(index!=-1) {
				 tabbedPane.setSelectedIndex(3);
				 nameOfPlaylist=songListModel1.getElementAt(index);
				 textField_4.setText(nameOfPlaylist);
				 try {
					Database d=new Database();
					int playlistID=d.getPID(nameOfPlaylist);
					d.loadSongs(playlistID,songListModel2);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(HomePage.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				}
				 
				 lblNewLabel_1_1_2.addMouseListener(new MouseAdapter() {
					 public void mousePressed(MouseEvent e) {
						 int del=JOptionPane.showConfirmDialog(HomePage.this, "Are you sure you want to delete?","Confirm", JOptionPane.YES_OPTION);
						 if(del==JOptionPane.YES_OPTION) {
							 try {
								Database d=new Database();
								d.deletePlaylist(nameOfPlaylist);
								HomePage h=new HomePage();
								h.setVisible(true);
								dispose();
							} catch (SQLException e1) {
								JOptionPane.showMessageDialog(HomePage.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

							}
							
						 }
						
					 }
				 
				 });
				 
				 lblNewLabel_1_1_3.addMouseListener(new MouseAdapter() {
					 public void mousePressed(MouseEvent e) {
						try {
						 String newName=JOptionPane.showInputDialog(HomePage.this, "Write new Playlist Name");
						if(!newName.isEmpty()) {
							try {
								Database d=new Database();
								d.editPlaylist(nameOfPlaylist,newName);
								int userid=d.getUserID(LoginPage.getEmail());
								if(userid==0) {
									userid=d.getLastUserID();
								}
							    d.loadPlaylists(userid,songListModel1);
							    nameOfPlaylist=songListModel1.getElementAt(index);
								textField_4.setText(nameOfPlaylist);
							} catch (SQLException e1) {
								JOptionPane.showMessageDialog(HomePage.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

							}
						}
					 }
						catch (Exception e1) {
							JOptionPane.showMessageDialog(HomePage.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

						}	
						
						 
					 }
				 });
				 
			        addSong.addMouseListener(new MouseAdapter() {
			        	public void mousePressed(MouseEvent e) {
			        	AddSong a=new AddSong();
			        	a.setVisible(true);
			        	dispose();
			        	}
			        });
			        
			        deleteSong.addMouseListener(new MouseAdapter() {
			        	public void mousePressed(MouseEvent e) {
			        	DeleteSong d=new DeleteSong();
			        	d.setVisible(true);
			        	dispose();
			        	}
			        });
				 
			  }
			  }}
			
		});
        
        list.addMouseListener (new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount()>1){
                	int index=list.getSelectedIndex();
                    if (index != -1 && index != 0) {
                    	 String originalString = songListModel2.getElementAt(index);
                         String songTitle="";
                         String artist="";
                         songTitle=originalString.substring(0, 21);
                         songTitle=songTitle.toUpperCase();
                         textField.setText(songTitle);
                         textField_2.setText("0:00");
                         artist=originalString.substring(26, 46);
                         artist=artist.toUpperCase();
                         textField_1.setText(artist);
                         textField_3.setText(originalString.substring(47, 51));
                        if (btnNewButton_7.getIcon().equals(play)) {
                        	btnNewButton_7.setIcon(pause);
                        }
                        btnNewButton_7.addMouseListener (new MouseAdapter() {
                            public void mouseClicked(MouseEvent e) {
                            	 if (btnNewButton_7.getIcon().equals(pause)) {
                                 	btnNewButton_7.setIcon(play);
                                 } 
                            	 else {
                            		 btnNewButton_7.setIcon(pause);
                            	 }
                            	
                            }
                        });	
                        
                        btnNewButton_7_1.addMouseListener (new MouseAdapter() {
                            public void mouseClicked(MouseEvent e) {
                            	 if (btnNewButton_7_1.getIcon().equals(audio)) {
                            		 btnNewButton_7_1.setIcon(noaudio);
                                 } 
                            	 else {
                            		 btnNewButton_7_1.setIcon(audio);
                            	 }
                            	
                            }
                        });	
        		        
                    }
                }
            }

        });	
		
	
        
	}
	
	public static String getPname() {
		return nameOfPlaylist;
	}
}


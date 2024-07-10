import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class AskAccount extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDoYouPossess;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AskAccount frame = new AskAccount();
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
	public AskAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 230, 629, 330);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtDoYouPossess = new JTextField();
		txtDoYouPossess.setText("Do you possess another account?");
		txtDoYouPossess.setHorizontalAlignment(SwingConstants.CENTER);
		txtDoYouPossess.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 30));
		txtDoYouPossess.setFocusable(false);
		txtDoYouPossess.setColumns(10);
		txtDoYouPossess.setBorder(null);
		txtDoYouPossess.setBackground(new Color(204, 204, 204));
		txtDoYouPossess.setBounds(10, 11, 595, 63);
		contentPane.add(txtDoYouPossess);
		
		JButton btnYes = new JButton("YES");
		btnYes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnYes.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				PartialInfo p=new PartialInfo();
				p.setVisible(true);
				dispose();
			}
		});
		btnYes.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 35));
		btnYes.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnYes.setBackground(new Color(174, 174, 174));
		btnYes.setBounds(220, 85, 151, 55);
		contentPane.add(btnYes);
		
		JButton btnNo = new JButton("NO");
		btnNo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNo.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				TotalInfo t=new TotalInfo();
				t.setVisible(true);
				dispose();
			}
		});
		btnNo.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 35));
		btnNo.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnNo.setBackground(new Color(174, 174, 174));
		btnNo.setBounds(220, 151, 151, 55);
		contentPane.add(btnNo);
		
		JButton btnGoBack = new JButton("GO BACK");
		btnGoBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGoBack.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		btnGoBack.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 35));
		btnGoBack.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnGoBack.setBackground(new Color(174, 174, 174));
		btnGoBack.setBounds(220, 219, 151, 55);
		contentPane.add(btnGoBack);
	}
}

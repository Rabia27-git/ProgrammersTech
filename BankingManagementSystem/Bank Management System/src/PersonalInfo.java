import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.border.LineBorder;
import java.awt.Cursor;

public class PersonalInfo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPersonalInformation;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtName_1;
	private JTextField txtAccountType;
	private JTextField txtCardNo;
	private JTextField txtPin;
	private JTextField txtEmail;
	private JTextField txtCnic;
	private JTextField txtStreet;
	private JTextField txtCity;
	private JTextField txtOpenedDate;
	private JTextArea atype;
	private JTextField date;
	private JTextArea email;
	private JTextArea street;
	private JTextArea city;
	private JTextField cuid;
	private JTextField aid;
	private JTextArea name;
	private JTextField cardNo;
	private JTextField pin;
	private JTextField cnic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalInfo frame = new PersonalInfo();
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
	public PersonalInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 25, 903, 645);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPersonalInformation = new JTextField();
		txtPersonalInformation.setText("PERSONAL INFORMATION");
		txtPersonalInformation.setHorizontalAlignment(SwingConstants.CENTER);
		txtPersonalInformation.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 50));
		txtPersonalInformation.setFocusable(false);
		txtPersonalInformation.setColumns(10);
		txtPersonalInformation.setBorder(null);
		txtPersonalInformation.setBackground(new Color(204, 204, 204));
		txtPersonalInformation.setBounds(175, 20, 573, 76);
		contentPane.add(txtPersonalInformation);
		
		JButton btnNewButton_3 = new JButton();
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Dashboard d=new Dashboard();
				d.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBorder(null);
		ImageIcon icon4=new ImageIcon(Dashboard.class.getResource("/Images/back.png"));
		btnNewButton_3.setIcon(icon4);
		btnNewButton_3.setBackground(new Color(204, 204, 204));
		btnNewButton_3.setBounds(11, 12, 115, 88);
		contentPane.add(btnNewButton_3);
		
		txtId = new JTextField();
		txtId.setText("ID:");
		txtId.setHorizontalAlignment(SwingConstants.LEFT);
		txtId.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtId.setFocusable(false);
		txtId.setColumns(10);
		txtId.setBorder(null);
		txtId.setBackground(new Color(204, 204, 204));
		txtId.setBounds(23, 147, 54, 65);
		contentPane.add(txtId);
		
		txtName = new JTextField();
		txtName.setText("Account ID:");
		txtName.setHorizontalAlignment(SwingConstants.LEFT);
		txtName.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtName.setFocusable(false);
		txtName.setColumns(10);
		txtName.setBorder(null);
		txtName.setBackground(new Color(204, 204, 204));
		txtName.setBounds(10, 223, 166, 65);
		contentPane.add(txtName);
		
		txtName_1 = new JTextField();
		txtName_1.setText("Name:");
		txtName_1.setHorizontalAlignment(SwingConstants.LEFT);
		txtName_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtName_1.setFocusable(false);
		txtName_1.setColumns(10);
		txtName_1.setBorder(null);
		txtName_1.setBackground(new Color(204, 204, 204));
		txtName_1.setBounds(10, 300, 88, 65);
		contentPane.add(txtName_1);
		
		txtAccountType = new JTextField();
		txtAccountType.setText("Account Type:");
		txtAccountType.setHorizontalAlignment(SwingConstants.LEFT);
		txtAccountType.setFont(new Font("Times New Roman", Font.BOLD, 28));
		txtAccountType.setFocusable(false);
		txtAccountType.setColumns(10);
		txtAccountType.setBorder(null);
		txtAccountType.setBackground(new Color(204, 204, 204));
		txtAccountType.setBounds(421, 148, 182, 65);
		contentPane.add(txtAccountType);
		
		txtCardNo = new JTextField();
		txtCardNo.setText("Card No:");
		txtCardNo.setHorizontalAlignment(SwingConstants.LEFT);
		txtCardNo.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtCardNo.setFocusable(false);
		txtCardNo.setColumns(10);
		txtCardNo.setBorder(null);
		txtCardNo.setBackground(new Color(204, 204, 204));
		txtCardNo.setBounds(11, 376, 127, 65);
		contentPane.add(txtCardNo);
		
		txtPin = new JTextField();
		txtPin.setText("Pin:");
		txtPin.setHorizontalAlignment(SwingConstants.LEFT);
		txtPin.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtPin.setFocusable(false);
		txtPin.setColumns(10);
		txtPin.setBorder(null);
		txtPin.setBackground(new Color(204, 204, 204));
		txtPin.setBounds(23, 452, 67, 65);
		contentPane.add(txtPin);
		
		txtEmail = new JTextField();
		txtEmail.setText("City:");
		txtEmail.setHorizontalAlignment(SwingConstants.LEFT);
		txtEmail.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtEmail.setFocusable(false);
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		txtEmail.setBackground(new Color(204, 204, 204));
		txtEmail.setBounds(511, 457, 93, 65);
		contentPane.add(txtEmail);
		
		txtCnic = new JTextField();
		txtCnic.setText("CNIC:");
		txtCnic.setHorizontalAlignment(SwingConstants.LEFT);
		txtCnic.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtCnic.setFocusable(false);
		txtCnic.setColumns(10);
		txtCnic.setBorder(null);
		txtCnic.setBackground(new Color(204, 204, 204));
		txtCnic.setBounds(23, 532, 102, 65);
		contentPane.add(txtCnic);
		
		txtStreet = new JTextField();
		txtStreet.setText("Email:");
		txtStreet.setHorizontalAlignment(SwingConstants.LEFT);
		txtStreet.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtStreet.setFocusable(false);
		txtStreet.setColumns(10);
		txtStreet.setBorder(null);
		txtStreet.setBackground(new Color(204, 204, 204));
		txtStreet.setBounds(511, 300, 88, 65);
		contentPane.add(txtStreet);
		
		txtCity = new JTextField();
		txtCity.setText("Street:");
		txtCity.setHorizontalAlignment(SwingConstants.LEFT);
		txtCity.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtCity.setFocusable(false);
		txtCity.setColumns(10);
		txtCity.setBorder(null);
		txtCity.setBackground(new Color(204, 204, 204));
		txtCity.setBounds(503, 376, 96, 65);
		contentPane.add(txtCity);
		
		txtOpenedDate = new JTextField();
		txtOpenedDate.setText("Opened Date:");
		txtOpenedDate.setHorizontalAlignment(SwingConstants.LEFT);
		txtOpenedDate.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtOpenedDate.setFocusable(false);
		txtOpenedDate.setColumns(10);
		txtOpenedDate.setBorder(null);
		txtOpenedDate.setBackground(new Color(204, 204, 204));
		txtOpenedDate.setBounds(421, 228, 181, 65);
		contentPane.add(txtOpenedDate);
		
		atype = new JTextArea();
		atype.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		atype.setColumns(10);
		atype.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		atype.setBounds(607, 152, 272, 55);
		contentPane.add(atype);
		
		date = new JTextField();
		date.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		date.setColumns(10);
		date.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		date.setBounds(612, 228, 267, 55);
		contentPane.add(date);
		
		email = new JTextArea();
		email.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		email.setColumns(10);
		email.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		email.setBounds(609, 305, 270, 55);
		contentPane.add(email);
		
		street = new JTextArea();
		street.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		street.setColumns(10);
		street.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		street.setBounds(612, 381, 267, 55);
		contentPane.add(street);
		
		city = new JTextArea();
		city.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		city.setColumns(10);
		city.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		city.setBounds(614, 462, 265, 55);
		contentPane.add(city);
		
		cuid = new JTextField();
		cuid.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		cuid.setColumns(10);
		cuid.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		cuid.setBounds(177, 157, 234, 55);
		contentPane.add(cuid);
		
		aid = new JTextField();
		aid.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		aid.setColumns(10);
		aid.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		aid.setBounds(177, 228, 234, 55);
		contentPane.add(aid);
		
		name = new JTextArea();
		name.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		name.setColumns(10);
		name.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		name.setBounds(177, 305, 234, 55);
		contentPane.add(name);
		
		cardNo = new JTextField();
		cardNo.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		cardNo.setColumns(10);
		cardNo.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		cardNo.setBounds(177, 381, 234, 55);
		contentPane.add(cardNo);
		
		pin = new JTextField();
		pin.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		pin.setColumns(10);
		pin.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pin.setBounds(177, 457, 234, 55);
		contentPane.add(pin);
		
		cnic = new JTextField();
		cnic.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		cnic.setColumns(10);
		cnic.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		cnic.setBounds(177, 537, 234, 55);
		contentPane.add(cnic);
		
		String card=LoginPage.cardNO();
		int pinn=LoginPage.pin();
		int cid=LoginPage.customerID();
		
		try {
			Database d=new Database();
			atype.setText(d.getAccountType(card));
			atype.setToolTipText(atype.getText());
			date.setText(d.getDate(card));
			email.setText(d.getEmail(cid));
			email.setToolTipText(email.getText());
			street.setText(d.getStreet(cid));
			street.setToolTipText(street.getText());
			city.setText(d.getCity(cid));
			city.setToolTipText(city.getText());
			cuid.setText(cid+"");
			aid.setText(d.getAccountID(card)+"");
			name.setText(d.getNameF(cid)+" "+d.getNameL(cid));
			name.setToolTipText(name.getText());
			cardNo.setText(card);
			pin.setText(pinn+"");
			cnic.setText(d.getCNIC(cid));
			
			
		} catch (SQLException e1) {
			 JOptionPane.showMessageDialog(PersonalInfo.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

		}
	}

}

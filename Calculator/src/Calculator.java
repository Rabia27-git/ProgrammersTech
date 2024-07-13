import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;

public class Calculator extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel division;
	private JLabel multiplication;
	private JLabel minus;
	private JLabel plus;
	private JLabel equal;
	private JLabel nine;
	private JLabel six;
	private JLabel three;
	private JLabel dot;
	private JLabel eight;
	private JLabel five;
	private JLabel two;
	private JLabel seven;
	private JLabel four;
	private JLabel one;
	private JLabel zero;
	private JLabel ac;
	private JLabel zerozero;
	private JLabel dlt;
	private JLabel percentage;
	double var1=0;
	double var2=0;
	String var3;
	double result=0;
	char operation;
	String text;
	int operatorCount=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
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
	public Calculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 3, 420, 667);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(192, 192, 192)));
		textField.setForeground(new Color(255, 255, 255));
		textField.setBackground(new Color(0, 0, 0));
		textField.setFocusable(false);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 40));
		textField.setBounds(0, 11, 406, 141);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		// DIVISION
		division = new JLabel("");
		division.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(operatorCount<1) {
				try {
				var1=Double.parseDouble(textField.getText());
				operation='/';
				text=textField.getText()+"/";
				textField.setText(text);
				operatorCount++;
				}
				catch(Exception e1) {
					 JOptionPane.showMessageDialog(Calculator.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				}
				else {
					JOptionPane.showMessageDialog(Calculator.this, "Only one operation is done at a time.");
				}
			}
		});
		ImageIcon icon1=new ImageIcon(Calculator.class.getResource("/Images/division.png"));
		division.setIcon(icon1);
		division.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		division.setFocusable(false);
		division.setBounds(308, 159, 79, 77);
		contentPane.add(division);
		
		// MULTIPLICATION
		multiplication = new JLabel("");
		multiplication.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(operatorCount<1) {
				try {
				var1=Double.parseDouble(textField.getText());
				operation='*';
				text=textField.getText()+"*";
				textField.setText(text);
				operatorCount++;
				}
				catch(Exception e1) {
					 JOptionPane.showMessageDialog(Calculator.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				}
				else {
					JOptionPane.showMessageDialog(Calculator.this, "Only one operation is done at a time.");
				}
			}
		});
		ImageIcon icon2=new ImageIcon(Calculator.class.getResource("/Images/multiply.png"));
		multiplication.setIcon(icon2);
		multiplication.setBorder(null);
		multiplication.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		multiplication.setFocusable(false);
		multiplication.setBounds(308, 255, 79, 77);
		contentPane.add(multiplication);
		
		// SUBTRACTION
		minus = new JLabel("");
		minus.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(operatorCount<1) {
				try {
				var1=Double.parseDouble(textField.getText());
				operation='-';
				text=textField.getText()+"-";
				textField.setText(text);
				operatorCount++;
				}
				catch(Exception e1) {
					 JOptionPane.showMessageDialog(Calculator.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				}
				else {
					JOptionPane.showMessageDialog(Calculator.this, "Only one operation is done at a time.");
				}
			}
		});
		minus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ImageIcon icon3=new ImageIcon(Calculator.class.getResource("/Images/minus.png"));
		minus.setIcon(icon3);
		minus.setBorder(null);
		minus.setFocusable(false);
		minus.setBounds(308, 351, 79, 77);
		contentPane.add(minus);
		
		// ADDITION
		plus = new JLabel("");
		plus.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(operatorCount<1) {
				try {
				var1=Double.parseDouble(textField.getText());
				operation='+';
				text=textField.getText()+"+";
				textField.setText(text);
				operatorCount++;
				}
				catch(Exception e1) {
					 JOptionPane.showMessageDialog(Calculator.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				}
				else {
					JOptionPane.showMessageDialog(Calculator.this, "Only one operation is done at a time.");
				}
			}
		});
		plus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ImageIcon icon4=new ImageIcon(Calculator.class.getResource("/Images/add.png"));
		plus.setIcon(icon4);
		plus.setBorder(null);
		plus.setFocusable(false);
		plus.setBounds(308, 447, 79, 77);
		contentPane.add(plus);
		
		percentage = new JLabel("");
		percentage.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {	
				if(operatorCount<1) {
				try {
				var1=Double.parseDouble(textField.getText());
				operation='%';
				text=textField.getText()+"%";
				textField.setText(text);
				operatorCount++;
				}
				catch(Exception e1) {
					 JOptionPane.showMessageDialog(Calculator.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				}
				else {
					JOptionPane.showMessageDialog(Calculator.this, "Only one operation is done at a time.");
				}
			}
		});
		ImageIcon icon20=new ImageIcon(Calculator.class.getResource("/Images/percentage.png"));
		percentage.setIcon(icon20);
		percentage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		percentage.setFocusable(false);
		percentage.setBorder(null);
		percentage.setBounds(116, 159, 79, 77);
		contentPane.add(percentage);
		
		// EQUAL
		equal = new JLabel("");
		equal.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(operation==' ') {
					textField.setText(" ");
					operatorCount=0;
					return;
				}
				try {
				if(operation=='+') {
				    var3=textField.getText();
                    if(var3.charAt(var3.length()-1)=='+') {
                    	result=var1+var1;
                    	textField.setText(result+"");
    					var1=result;
    					operatorCount=0;
                    }
                    else {
    					var2 = Double.parseDouble(textField.getText().split("[+\\-*/%]")[1]);
    					result=var1+var2;
    					textField.setText(result+"");
    					var1=result;
    					operatorCount=0;
                    }
				}
				else if(operation=='-') {
				    var3=textField.getText();
				    if(var3.charAt(var3.length()-1)=='-') {
                    	result=var1-var1;
                    	textField.setText(result+"");
    					var1=result;
    					operatorCount=0;
                    }
				    else {
					var2 = Double.parseDouble(textField.getText().split("[+\\-*/%]")[1]);
					result=var1-var2;
					textField.setText(result+"");
					var1=result;
					operatorCount=0;
				}
				}
				else if(operation=='*') {
				    var3=textField.getText();
                    if(var3.charAt(var3.length()-1)=='*') {
                    	result=var1*var1;
                    	textField.setText(result+"");
    					var1=result;
    					operatorCount=0;
                    }
                    else {
    					var2 = Double.parseDouble(textField.getText().split("[+\\-*/%]")[1]);
    					result=var1*var2;
    					textField.setText(result+"");
    					var1=result;
    					operatorCount=0;
                    }
				}
				else if(operation=='/') {
				    var3=textField.getText();
				    if(var3.charAt(var3.length()-1)=='/') {
				    	if(var1==0) {
				    		JOptionPane.showMessageDialog(Calculator.this, "Please enter second number.");
				    		return;
				    	}
				    	else {
					    	result=var1/var1;
					    	textField.setText(result+"");
							var1=result;
							operatorCount=0;
				    	}
				    }
				    else {
						var2 = Double.parseDouble(textField.getText().split("[+\\-*/%]")[1]);
						if (var2 != 0) {
		                    result=var1/var2;
		                    textField.setText(result+"");
							var1=result;
							operatorCount=0;
		                } else {
		                    JOptionPane.showMessageDialog(Calculator.this, "Error: Divide by zero");
		                    return;
		                }	
				    }
				}
				else if (operation=='%') {
				    var3=textField.getText();
				    if(var3.charAt(var3.length()-1)=='%') {
				    	result=var1 * 0.01;
			            textField.setText(result + "");
			            var1=result;
			            operatorCount=0;
				    }
				      else {
						 var2=Double.parseDouble(textField.getText().split("[+\\-*/%]")[1]);
				         result=(var1*var2)/100;
				         textField.setText(result + "");
				         var1=result;
				         operatorCount=0;
				}  
			} 
				
			}
				catch(Exception e1) {
					 JOptionPane.showMessageDialog(Calculator.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}	
		});
		
		equal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ImageIcon icon5=new ImageIcon(Calculator.class.getResource("/Images/equal.png"));
		equal.setIcon(icon5);
		equal.setBorder(null);
		equal.setFocusable(false);
		equal.setBounds(308, 543, 79, 77);
		contentPane.add(equal);
		
		// DOT
		dot = new JLabel("");
		dot.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
			  try {
			  text=textField.getText()+".";
			  textField.setText(text);
			  }
				catch(Exception e1) {
					 JOptionPane.showMessageDialog(Calculator.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		dot.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ImageIcon icon6=new ImageIcon(Calculator.class.getResource("/Images/dot.png"));
		dot.setIcon(icon6);
		dot.setFocusable(false);
		dot.setBorder(null);
		dot.setBounds(212, 543, 79, 77);
		contentPane.add(dot);
		
		// AC
		ac = new JLabel("");
		ac.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
			  try {
			  textField.setText("");
			  var1=0;
			  var2=0;
			  result=0;
			  operation=' ';
			  text="";	
			  operatorCount=0;
			  }
				catch(Exception e1) {
					 JOptionPane.showMessageDialog(Calculator.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		ac.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ImageIcon icon7=new ImageIcon(Calculator.class.getResource("/Images/ac.png"));
		ac.setIcon(icon7);
		ac.setFocusable(false);
		ac.setBorder(null);
		ac.setBounds(20, 159, 79, 77);
		contentPane.add(ac);
		
		// DELETE
		dlt=new JLabel("");
		dlt.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent e) {
		    	try {
		        text=textField.getText();
		        if(text.length()>0) {
		        if(text.charAt(text.length()-1)=='+' || text.charAt(text.length()-1)=='-' || text.charAt(text.length()-1)=='*' || 
		        		text.charAt(text.length()-1)=='/' || text.charAt(text.length()-1)=='%'){
		        	
			           textField.setText(text.substring(0, text.length() - 1));
			           operatorCount=0;
		        	
		        }
		        else {
		           textField.setText(text.substring(0, text.length() - 1));
		        }
		        }
		    }
			catch(Exception e1) {
				 JOptionPane.showMessageDialog(Calculator.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		    }	
		});
		dlt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ImageIcon icon8=new ImageIcon(Calculator.class.getResource("/Images/del.png"));
		dlt.setIcon(icon8);
		dlt.setFocusable(false);
		dlt.setBorder(null);
		dlt.setBounds(212, 159, 79, 77);
		contentPane.add(dlt);
		
		// ZERO
		zero = new JLabel("");
		zero.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
			  try {
			  text=textField.getText()+"0";
			  textField.setText(text);
			  }
				catch(Exception e1) {
					 JOptionPane.showMessageDialog(Calculator.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		zero.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ImageIcon icon9=new ImageIcon(Calculator.class.getResource("/Images/0.png"));
		zero.setIcon(icon9);
		zero.setFocusable(false);
		zero.setBorder(null);
		zero.setBounds(116, 543, 79, 77);
		contentPane.add(zero);
		
		// ONE
		one = new JLabel("");
		one.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				 try {
				  text=textField.getText()+"1";
				  textField.setText(text);
				 }
					catch(Exception e1) {
						 JOptionPane.showMessageDialog(Calculator.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		one.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ImageIcon icon10=new ImageIcon(Calculator.class.getResource("/Images/1.png"));
		one.setIcon(icon10);
		one.setFocusable(false);
		one.setBorder(null);
		one.setBounds(20, 447, 79, 77);
		contentPane.add(one);
		
		// TWO
		two = new JLabel("");
		two.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				  try {
				  text=textField.getText()+"2";
				  textField.setText(text);
				  }
					catch(Exception e1) {
						 JOptionPane.showMessageDialog(Calculator.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		two.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ImageIcon icon11=new ImageIcon(Calculator.class.getResource("/Images/2.png"));
		two.setIcon(icon11);
		two.setFocusable(false);
		two.setBorder(null);
		two.setBounds(116, 447, 79, 77);
		contentPane.add(two);
		
		// THREE
		three = new JLabel("");
		three.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				try {
				  text=textField.getText()+"3";
				  textField.setText(text);
				}
				catch(Exception e1) {
					 JOptionPane.showMessageDialog(Calculator.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		three.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ImageIcon icon12=new ImageIcon(Calculator.class.getResource("/Images/3.png"));
		three.setIcon(icon12);
		three.setFocusable(false);
		three.setBorder(null);
		three.setBounds(212, 447, 79, 77);
		contentPane.add(three);
		
		// FOUR
		four = new JLabel("");
		four.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				  try {
				  text=textField.getText()+"4";
				  textField.setText(text);
				  }
					catch(Exception e1) {
					 JOptionPane.showMessageDialog(Calculator.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		four.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ImageIcon icon13=new ImageIcon(Calculator.class.getResource("/Images/4.png"));
		four.setIcon(icon13);
		four.setFocusable(false);
		four.setBorder(null);
		four.setBounds(20, 351, 79, 77);
		contentPane.add(four);
		
		// FIVE
		five = new JLabel("");
		five.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				try {
				  text=textField.getText()+"5";
				  textField.setText(text);
				}
				catch(Exception e1) {
					 JOptionPane.showMessageDialog(Calculator.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		five.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ImageIcon icon14=new ImageIcon(Calculator.class.getResource("/Images/5.png"));
		five.setIcon(icon14);
		five.setFocusable(false);
		five.setBorder(null);
		five.setBounds(116, 351, 79, 77);
		contentPane.add(five);
		
		// SIX
		six = new JLabel("");
		six.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				try {
				  text=textField.getText()+"6";
				  textField.setText(text);
				}
				catch(Exception e1) {
					 JOptionPane.showMessageDialog(Calculator.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		six.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ImageIcon icon15=new ImageIcon(Calculator.class.getResource("/Images/6.png"));
		six.setIcon(icon15);
		six.setFocusable(false);
		six.setBorder(null);
		six.setBounds(212, 351, 79, 77);
		contentPane.add(six);
		
		// SEVEN
		seven = new JLabel("");
		seven.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				try {
				  text=textField.getText()+"7";
				  textField.setText(text);
				}
				catch(Exception e1) {
					 JOptionPane.showMessageDialog(Calculator.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		seven.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ImageIcon icon16=new ImageIcon(Calculator.class.getResource("/Images/7.png"));
		seven.setIcon(icon16);
		seven.setFocusable(false);
		seven.setBorder(null);
		seven.setBounds(20, 255, 79, 77);
		contentPane.add(seven);
		
		// EIGHT
		eight = new JLabel("");
		eight.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				try {
				  text=textField.getText()+"8";
				  textField.setText(text);
				}
				catch(Exception e1) {
					 JOptionPane.showMessageDialog(Calculator.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		eight.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ImageIcon icon17=new ImageIcon(Calculator.class.getResource("/Images/8.png"));
		eight.setIcon(icon17);
		eight.setFocusable(false);
		eight.setBorder(null);
		eight.setBounds(116, 255, 79, 77);
		contentPane.add(eight);
		
		// NINE
		nine = new JLabel("");
		nine.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				try {
				  text=textField.getText()+"9";
				  textField.setText(text);
				}
				catch(Exception e1) {
					 JOptionPane.showMessageDialog(Calculator.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		nine.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ImageIcon icon18=new ImageIcon(Calculator.class.getResource("/Images/9.png"));
		nine.setIcon(icon18);
		nine.setFocusable(false);
		nine.setBorder(null);
		nine.setBounds(212, 255, 79, 77);
		contentPane.add(nine);
		
		zerozero = new JLabel("");
		zerozero.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				try {
				if(text.length()==0) {
					text="0";
					textField.setText(text);

				}
				else {
					text=textField.getText()+"00";
					textField.setText(text);	
				}
				}
				catch(Exception e1) {
					 JOptionPane.showMessageDialog(Calculator.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		ImageIcon icon19=new ImageIcon(Calculator.class.getResource("/Images/00.png"));
		zerozero.setIcon(icon19);
		zerozero.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		zerozero.setFocusable(false);
		zerozero.setBorder(null);
		zerozero.setBounds(20, 543, 79, 77);
		contentPane.add(zerozero);
		
	
	}
}

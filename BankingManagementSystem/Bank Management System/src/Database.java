import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class Database implements AutoCloseable{

	private Connection con;
    private String username="root";
    private String password="root";

    public Database() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagement", username, password);
    }

    public void close() throws SQLException {
        if (con != null) {
            con.close();
        }
    }

    // LoginPage
	public boolean validate(String card, String pin) throws SQLException {
       String query="SELECT * FROM account WHERE card_no=? AND pin=?";
       try(PreparedStatement statement=con.prepareStatement(query)){
    	   statement.setString(1, card);
    	   statement.setString(2, pin);
    	   try(ResultSet rs=statement.executeQuery()){
    		   if(rs.next()) {
    			   return true;
    		   }
    		   else {
    			   return false;
    		   }
    	   }
       }
       
	}
	
	// LoginPage
	public int customerID(String card) throws SQLException {
	   int cid=0;
       String query="SELECT customer_id FROM account WHERE card_no=?";
       try(PreparedStatement statement=con.prepareStatement(query)){
    	   statement.setString(1,card);
    	   try(ResultSet rs=statement.executeQuery()){
    		   if(rs.next()) {
    			   cid=rs.getInt("customer_id");
    		   }
    	   }
       }
       return cid;
	}

	// Dashboard
	public String getFName(int cid) throws SQLException {
		String fname="";
        String query="SELECT first_name FROM customerr WHERE customer_id=?";
        try(PreparedStatement statement=con.prepareStatement(query)){
        	statement.setInt(1,cid);
        	try(ResultSet rs=statement.executeQuery()){
        		if(rs.next()) {
        			fname=rs.getString("first_name");
        		}
        	}
        }
        return fname;
	}
	
	// Dashboard
	public String getLName(int cid) throws SQLException {
		String lname="";
        String query="SELECT last_name FROM customerr WHERE customer_id=?";
        try(PreparedStatement statement=con.prepareStatement(query)){
        	statement.setInt(1,cid);
        	try(ResultSet rs=statement.executeQuery()){
        		if(rs.next()) {
        			lname=rs.getString("last_name");
        		}
        	}
        }
        return lname;
	}
	
	// Dashboard , Withdraw
	public double getBalance(String cardNO) throws SQLException {
		double balance=0;
        String query="SELECT balance FROM account WHERE card_no=?";
        try(PreparedStatement statement=con.prepareStatement(query)){
        	statement.setString(1,cardNO);
        	try(ResultSet rs=statement.executeQuery()){
        		if(rs.next()) {
        			balance=rs.getInt("balance");
        		}
        	}
        }
        return balance;
	}

	// Deposit
	public void deposit(String amount, String card, int aid) throws SQLException {
		int money=Integer.parseInt(amount);
		String query="UPDATE account SET balance=balance+? WHERE card_no=?";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setInt(1, money);
			statement.setString(2, card);
			statement.executeUpdate();
		}
		
		String query1="INSERT INTO transaction(transaction_type,amount,account_id) VALUES (?,?,?)";
		try(PreparedStatement statement1=con.prepareStatement(query1)){
			statement1.setString(1, "deposit");
			statement1.setInt(2, money);
			statement1.setInt(3, aid);
			statement1.executeUpdate();
		}
		
	}

	// Withdraw
	public void withdraw(int money, String card, int aid) throws SQLException {
		String query="UPDATE account SET balance=balance-? WHERE card_no=?";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setInt(1, money);
			statement.setString(2, card);
			statement.executeUpdate();
		}
		
		String query1="INSERT INTO transaction(transaction_type,amount,account_id) VALUES (?,?,?)";
		try(PreparedStatement statement1=con.prepareStatement(query1)){
			statement1.setString(1, "withdraw");
			statement1.setInt(2, money);
			statement1.setInt(3, aid);
			statement1.executeUpdate();
		}
		
	}

	// Transfer
	public boolean checkAccount(int aid) throws SQLException {
		String query="SELECT * FROM account WHERE account_id=?";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setInt(1, aid);
			try(ResultSet rs=statement.executeQuery()){
				if(rs.next()) {
					return true;
				}
				else {
				   return false;
				}
			}
		}
	}

	// Transfer
	public void transfer(int money, int aid, String card, int aaid) throws SQLException {
		String query1="UPDATE account SET balance=balance+? WHERE account_id=?";
		try(PreparedStatement statement1=con.prepareStatement(query1)){
			statement1.setInt(1, money);
			statement1.setInt(2, aid);
			statement1.executeUpdate();
		}
		
		String query2="UPDATE account SET balance=balance-? WHERE card_no=?";
		try(PreparedStatement statement2=con.prepareStatement(query2)){
			statement2.setInt(1, money);
			statement2.setString(2, card);
			statement2.executeUpdate();
		}
		
		String query3="INSERT INTO transaction(transaction_type,amount,account_id) VALUES (?,?,?)";
		try(PreparedStatement statement3=con.prepareStatement(query3)){
			statement3.setString(1, "transfer");
			statement3.setInt(2, money);
			statement3.setInt(3, aaid);
			statement3.executeUpdate();
		}
		
		
	}
	
	// PersonalInfo
	public String getAccountType(String card) throws SQLException {
		String a="";
		String query="SELECT account_type FROM account WHERE card_no=?";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setString(1, card);
			try(ResultSet rs=statement.executeQuery()){
				if(rs.next()) {
					a=rs.getString("account_type");
				}
			}
		}
		return a;
	}
	
	// PersonalInfo
	public String getDate(String card) throws SQLException {
		Date a = null;
		String b= null; 
		String query="SELECT opened_date FROM account WHERE card_no=?";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setString(1, card);
			try(ResultSet rs=statement.executeQuery()){
				if(rs.next()) {
					a=rs.getDate("opened_date");
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    b = dateFormat.format(a);
				}
			}
		}
		return b;
	}
	
	// PersonalInfo
	public String getEmail(int cid) throws SQLException {
		String a="";
		String query="SELECT email FROM customerr WHERE customer_id=?";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setInt(1, cid);
			try(ResultSet rs=statement.executeQuery()){
				if(rs.next()) {
					a=rs.getString("email");
				}
			}
		}
		return a;
	}
	
	// PersonalInfo
	public String getStreet(int cid) throws SQLException {
		String a="";
		String query="SELECT street FROM customerr WHERE customer_id=?";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setInt(1, cid);
			try(ResultSet rs=statement.executeQuery()){
				if(rs.next()) {
					a=rs.getString("street");
				}
			}
		}
		return a;
	}
	
	// PersonalInfo
	public String getCity(int cid) throws SQLException {
		String a="";
		String query="SELECT city FROM customerr WHERE customer_id=?";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setInt(1, cid);
			try(ResultSet rs=statement.executeQuery()){
				if(rs.next()) {
					a=rs.getString("city");
				}
			}
		}
		return a;
	}
	
	// PersonalInfo
	public int getAccountID(String card) throws SQLException {
		int a=0;
		String query="SELECT account_id FROM account WHERE card_no=?";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setString(1, card);
			try(ResultSet rs=statement.executeQuery()){
				if(rs.next()) {
					a=rs.getInt("account_id");
				}
			}
		}
		return a;
	}
	
	// PersonalInfo
	public String getNameF(int cid) throws SQLException {
		String a="";
		String query="SELECT first_name FROM customerr WHERE customer_id=?";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setInt(1, cid);
			try(ResultSet rs=statement.executeQuery()){
				if(rs.next()) {
					a=rs.getString("first_name");
				}
			}
		}
		return a;
	}
	
	// PersonalInfo
	public String getNameL(int cid) throws SQLException {
		String a="";
		String query="SELECT last_name FROM customerr WHERE customer_id=?";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setInt(1, cid);
			try(ResultSet rs=statement.executeQuery()){
				if(rs.next()) {
					a=rs.getString("last_name");
				}
			}
		}
		return a;
	}
	
	// PersonalInfo
	public String getCNIC(int cid) throws SQLException {
		String a="";
		String query="SELECT cnic FROM customerr WHERE customer_id=?";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setInt(1, cid);
			try(ResultSet rs=statement.executeQuery()){
				if(rs.next()) {
					a=rs.getString("cnic");
				}
			}
		}
		return a;
	}
	
  // Transaction
	public void transaction(int aid) throws SQLException {
	 String query="select distinct t.transaction_id, t.transaction_datetime,t.transaction_type, t.amount from transaction t inner join account a where t.account_id=?";
		 try(PreparedStatement statement=con.prepareStatement(query)){
		    statement.setInt(1, aid);
			try(ResultSet rs=statement.executeQuery()){
			ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData();
			DefaultTableModel dtm=(DefaultTableModel) Transaction.table.getModel();
			 dtm.setRowCount(0);
       // Iterate through the ResultSet to extract data
          while (rs.next()) {
              Object[] rowData = new Object[4];
              for (int i = 0; i < 4; i++) {
                  rowData[i] = rs.getObject(i + 1);
              }
              // Add the row data to the DefaultTableModel
              dtm.addRow(rowData);
          }	
	}

		}
	}

	// PartialInfo
	public boolean checkCustomer(String id) throws SQLException {
     String query="SELECT * FROM customerr WHERE customer_id=?";
     try(PreparedStatement statement=con.prepareStatement(query)){
    	 statement.setString(1, id);
    	 try(ResultSet rs=statement.executeQuery()){
    		 if(rs.next()) {
    			 return true;
    		 }
    		 else {
    			 return false;
    		 }
    	 }
     }
		
	}
	
	// PartialInfo , TotalInfo
	public String setCard() throws SQLException {
		String card="";
		long card1;
		String query1="SELECT card_no FROM account ORDER BY account_id DESC LIMIT 1";
		try(PreparedStatement statement=con.prepareStatement(query1)){
	    	 try(ResultSet rs=statement.executeQuery()){
	    		 if(rs.next()) {
	    			 card=rs.getString("card_no");
	    			 card1=Long.parseLong(card);
	    			 card1=card1+1;
	    			 card=Long.toString(card1);
	    		 }
	    		 else {
	    			 card="1234567891234567";
	    		 }
	    		 
	    	 }
		}
		return card;
	    
	}
	
	// PartialInfo , TotalInfo
	public int setPin() throws SQLException {
		int pin=0;
		String query1="SELECT pin FROM account ORDER BY account_id DESC LIMIT 1";
		try(PreparedStatement statement=con.prepareStatement(query1)){
	    	 try(ResultSet rs=statement.executeQuery()){
	    		 if(rs.next()) {
	    			 pin=rs.getInt("pin");
	    			 pin=pin+1;
	    		 }
	    		 else {
	    			 pin=1234;
	    		 }
	    		 
	    	 }
		}
		return pin;
	}

	// PartialInfo
	public void addAccount(String id, String atype) throws SQLException {
		String query="INSERT INTO account(account_type,customer_id,card_no,pin) VALUES (?,?,?,?)";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setString(1, atype);
			statement.setString(2, id);
			statement.setString(3, setCard());
			statement.setInt(4, setPin());
			statement.executeUpdate();	
		}
		
	}
	
	// PartialInfo
	public String getCard() throws SQLException {
		String card="";
		String query1="SELECT card_no FROM account ORDER BY account_id DESC LIMIT 1";
		try(PreparedStatement statement=con.prepareStatement(query1)){
	    	 try(ResultSet rs=statement.executeQuery()){
	    		 if(rs.next()) {
	    			 card=rs.getString("card_no");
	    		 }
	    		 
	    	 }
		}
		return card;
	    
	}
	
	// PartialInfo
	public int getPin() throws SQLException {
		int pin=0;
		String query1="SELECT pin FROM account ORDER BY account_id DESC LIMIT 1";
		try(PreparedStatement statement=con.prepareStatement(query1)){
	    	 try(ResultSet rs=statement.executeQuery()){
	    		 if(rs.next()) {
	    			 pin=rs.getInt("pin");
	    		 }
	    		 
	    	 }
		}
		return pin;
	}
	
	// TotalInfo
	public int getCustomerID() throws SQLException {
		int cid=0;
		String query1="SELECT customer_id FROM customerr ORDER BY customer_id DESC LIMIT 1";
		try(PreparedStatement statement=con.prepareStatement(query1)){
	    	 try(ResultSet rs=statement.executeQuery()){
	    		 if(rs.next()) {
	    			 cid=rs.getInt("customer_id");
	    		 }
	    		 
	    	 }
		}
		return cid;
	}

	// TotalInfo
	public void addAccountCustomer(String vfname, String vlname, String vemail, String vcnic, String vstreet,
			String vcity, String atype, String gender, String maritalStatus) throws SQLException {
		String query1="INSERT INTO customerr(first_name,last_name,gender,email,marital_status,cnic,street,city) VALUES(?,?,?,?,?,?,?,?)";
		try(PreparedStatement statement1=con.prepareStatement(query1)){
			statement1.setString(1, vfname);
			statement1.setString(2, vlname);
			statement1.setString(3, gender);
			statement1.setString(4, vemail);
			statement1.setString(5, maritalStatus);
			statement1.setString(6, vcnic);
			statement1.setString(7, vstreet);
			statement1.setString(8, vcity);
			statement1.executeUpdate();
		}
		
		String query2="INSERT INTO account(account_type,customer_id,card_no,pin) VALUES(?,?,?,?)";
		try(PreparedStatement statement2=con.prepareStatement(query2)){
			statement2.setString(1, atype);
			statement2.setInt(2, getCustomerID());
			statement2.setString(3, setCard());
			statement2.setInt(4, setPin());
			statement2.executeUpdate();
		}
		
		
	}
	
}

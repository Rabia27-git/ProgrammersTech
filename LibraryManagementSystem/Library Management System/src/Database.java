import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;


public class Database implements AutoCloseable{
  
	Connection con;
	String username="root";
	String password="root";
	
	public Database() throws SQLException {
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagement", username, password);
	}
	
	public void close() throws SQLException {
        if (con != null) {
            con.close();
        }
}

	//LoginPage , SignUp
	public boolean validate(String name, String password2) throws SQLException {
		String query="select * from admin where name=? and password=?";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setString(1, name);
			statement.setString(2, password2);
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

	// SignUp
	public void createAdmin(String name, String password2) throws SQLException {
		String query="insert into admin(name,password) values(?,?)";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setString(1, name);
			statement.setString(2, password2);
			statement.executeUpdate();
		}
		
	}

	// Dashboard
	public boolean checkBook(String search, DefaultListModel<String> songListModel) throws SQLException {
	    songListModel.clear();	
	    String header = String.format("%-4s %-17s %-17s %-4s", "ID", "Title", "Author", "Qty");
	    songListModel.addElement(header);
	    String s="%"+search+"%";
	    boolean check=false;
	    String query="select * from book where title like ? or author like ?"; 
	    try (PreparedStatement statement = con.prepareStatement(query)) {
	        statement.setString(1, s);
	        statement.setString(2, s);
	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	            int id = resultSet.getInt("book_id");
	            String title = resultSet.getString("title");
	            String author = resultSet.getString("author");
	            int quantity = resultSet.getInt("quantity");
	            String songInfo = String.format("%-4s %-17s %-17s %-4s", id, title, author, quantity);
	            songListModel.addElement(songInfo);
	            check=true;
	        }
	    }
		return check;
	}

	// Dashboard
	public void showBooks(DefaultListModel<String> songListModel) throws SQLException {
	    String header = String.format("%-4s %-17s %-17s %-4s", "ID", "Title", "Author", "Qty");
	    songListModel.addElement(header);
	    String query="select * from book"; 
	    try (PreparedStatement statement = con.prepareStatement(query)) {
	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	            int id = resultSet.getInt("book_id");
	            String title = resultSet.getString("title");
	            String author = resultSet.getString("author");
	            int quantity = resultSet.getInt("quantity");
	            String songInfo = String.format("%-4s %-17s %-17s %-4s", id, title, author, quantity);
	            songListModel.addElement(songInfo);
	        }
	    }
		
	}

	// Profile
	public int getAdminID(String getname, String password2) throws SQLException {
		int  aid=0;
		String query="select admin_id from admin where name=? and password=?";
		try(PreparedStatement statement=con.prepareStatement(query)){
		     statement.setString(1, getname);
		     statement.setString(2, password2);
		     try(ResultSet rs=statement.executeQuery()){
		    	 if(rs.next()) {
		    		aid=rs.getInt("admin_id");
		    	 }
		     }
		}
		return aid;
		
	}

	// Books
	public void addBook(String title, String author, String qty) throws SQLException {
		int q=Integer.parseInt(qty);
		String query="insert into book(title,author,quantity) values(?,?,?)";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setString(1, title);
			statement.setString(2, author);
			statement.setInt(3, q);
			statement.executeUpdate();
		}
		
	}

	// Books , IssueBook
	public boolean checkID(String id) throws SQLException {
		String query="select * from book where book_id=?";
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

	// Books
	public void updateBook(String id, String column, String newValue) throws SQLException {
	    String query="update book set "+column+"=? where book_id=?";
	    try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setString(1, newValue);	
			statement.setString(2, id);
			statement.executeUpdate();
		}
		
	}

	// Books
	public void deleteBook(String id) throws SQLException {
		String query="delete from book where book_id=?";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setString(1, id);
			statement.executeUpdate();
		}
		
	}

	// Patrons
	public void showPatrons() throws SQLException {
		 String query="select * from patron";
		 try(PreparedStatement statement=con.prepareStatement(query)){
			try(ResultSet rs=statement.executeQuery()){
			ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData();
			DefaultTableModel dtm=(DefaultTableModel) Patrons.table.getModel();
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

	// Patrons
	public void addPatron(String name, String email, String phone) throws SQLException {
		String query="insert into patron(name,email,phone) values(?,?,?)";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setString(1, name);
			statement.setString(2, email);
			statement.setString(3, phone);
			statement.executeUpdate();
		}
		
	}
	
	// Patrons , IssueBook
		public boolean checkPID(String id) throws SQLException {
			String query="select * from patron where patron_id=?";
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

		// Patrons
		public void updatePatron(String id, String column, String newValue) throws SQLException {
		    String query="update patron set "+column+"=? where patron_id=?";
		    try(PreparedStatement statement=con.prepareStatement(query)){
				statement.setString(1, newValue);	
				statement.setString(2, id);
				statement.executeUpdate();
			}
			
		}

		// Patrons
		public void deletePatron(String id) throws SQLException {
			String query="delete from patron where patron_id=?";
			try(PreparedStatement statement=con.prepareStatement(query)){
				statement.setString(1, id);
				statement.executeUpdate();
			}
			
		}

		// IssueBook
		public void issueBook(String bid, String pid, Date date) throws SQLException {
			java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
			String query="insert into transaction(book_id,patron_id,issue_date,return_date) values(?,?,?,?)";
			try(PreparedStatement statement=con.prepareStatement(query)){
				statement.setString(1, bid);
				statement.setString(2, pid);
				statement.setDate(3, currentDate);
				statement.setDate(4, date);
				statement.executeUpdate();
			}
			
			String query1="update book set quantity=quantity-1 where book_id=?";
			try(PreparedStatement statement1=con.prepareStatement(query1)){
				statement1.setString(1, bid);
				statement1.executeUpdate();
			}
			
		}

		// IssueBook
		public void showTransactionsIssueBook() throws SQLException {
			 String query="select * from transaction";
			 try(PreparedStatement statement=con.prepareStatement(query)){
				try(ResultSet rs=statement.executeQuery()){
				ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData();
				DefaultTableModel dtm=(DefaultTableModel) IssueBook.table.getModel();
				 dtm.setRowCount(0);
	       // Iterate through the ResultSet to extract data
	          while (rs.next()) {
	              Object[] rowData = new Object[6];
	              for (int i = 0; i < 6; i++) {
	                  rowData[i] = rs.getObject(i + 1);
	              }
	              // Add the row data to the DefaultTableModel
	              dtm.addRow(rowData);
	          }	
		}

			}
			
		}
		
		// IssueBook
				public int checkQuantity(String bid) throws SQLException {
					int q=0;
					String query="select quantity from book where book_id=?";
					try(PreparedStatement statement=con.prepareStatement(query)){
						statement.setString(1, bid);
						try(ResultSet rs=statement.executeQuery()){
							if(rs.next()) {
								q=rs.getInt("quantity");
							}

						}

					}
					return q;
				}
		
		// ReturnBook
		public void showTransactionsReturnBook() throws SQLException {
			 String query="select * from transaction";
			 try(PreparedStatement statement=con.prepareStatement(query)){
				try(ResultSet rs=statement.executeQuery()){
				ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData();
				DefaultTableModel dtm=(DefaultTableModel) ReturnBook.table.getModel();
				 dtm.setRowCount(0);
	       // Iterate through the ResultSet to extract data
	          while (rs.next()) {
	              Object[] rowData = new Object[6];
	              for (int i = 0; i < 6; i++) {
	                  rowData[i] = rs.getObject(i + 1);
	              }
	              // Add the row data to the DefaultTableModel
	              dtm.addRow(rowData);
	          }	
		}

			}
			
		}

		// ReturnBook
		public boolean checkForReturn(String bid, String pid) throws SQLException {
			String query="select * from transaction where book_id=? and patron_id=? and actual_return_date is null";
			try(PreparedStatement statement=con.prepareStatement(query)){
				statement.setString(1, bid);
				statement.setString(2, pid);
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

		// ReturnBook
		public void returnBook(String bid, String pid) throws SQLException {
			java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
			String query="update transaction set actual_return_date=? where book_id=? and patron_id=?";
			try(PreparedStatement statement=con.prepareStatement(query)){
				statement.setDate(1, currentDate);
				statement.setString(2, bid);
				statement.setString(3, pid);
				statement.executeUpdate();
			}
			
			String query1="update book set quantity=quantity+1 where book_id=?";
			try(PreparedStatement statement1=con.prepareStatement(query1)){
				statement1.setString(1, bid);
				statement1.executeUpdate();
			}
			
		}

		// Reports
		public void showIssuedBooks() throws SQLException {
			 String query="select book_id,patron_id,issue_date,return_date from transaction";
			 try(PreparedStatement statement=con.prepareStatement(query)){
				try(ResultSet rs=statement.executeQuery()){
				ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData();
				DefaultTableModel dtm=(DefaultTableModel) Reports.table.getModel();
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

		// Reports
		public void showOverdueBook() throws SQLException {
			    String query = "SELECT book_id, patron_id, issue_date, return_date FROM transaction where actual_return_date is null"; 
			    try (PreparedStatement statement = con.prepareStatement(query);
			         ResultSet rs = statement.executeQuery()) {
			        ResultSetMetaData rsmd = rs.getMetaData();
			        DefaultTableModel dtm = (DefaultTableModel) Reports.table_1.getModel();
			        dtm.setRowCount(0); 
			        while (rs.next()) {
			            Object[] rowData = new Object[5];
			            for (int i = 0; i < 4; i++) {
			                rowData[i] = rs.getObject(i + 1); 
			            }
			            Date returnDate = rs.getDate("return_date");
			            java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
			            long diffInMillis = currentDate.getTime()- returnDate.getTime();
			            long diffInDays = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
			            
			            if(returnDate.before(currentDate)) {
			                rowData[4] = diffInDays; 
			                dtm.addRow(rowData); 
			            }
			        }
			    }
			}

	
	
}

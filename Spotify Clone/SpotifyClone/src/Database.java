import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.DefaultListModel;

public class Database implements AutoCloseable{
  
	private Connection con;
    private String username="root";
    private String password="root";

    public Database() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify", username, password);
    }
	
	@Override
	public void close() throws Exception {
		if (con != null) {
            con.close();
        }
		
	}
	
	//  LoginPage
	public boolean validate(String email, String password) throws SQLException {
		String query="select * from user where email=? and password=?";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setString(1, email);
			statement.setString(2, password);
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
    // SignUpPage
	public boolean checkEmail(String email) throws SQLException {
		String query="select * from user where email=?";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setString(1, email);
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

	// SignUpPage
	public void addUser(String email, String password, String name, String dob, String gender) throws SQLException {
		String query="insert into user(username,password,email,date_of_birth,gender) values(?,?,?,?,?)";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setString(1, name);
			statement.setString(2, password);
			statement.setString(3, email);
			statement.setString(4, dob);
			statement.setString(5, gender);
			statement.executeUpdate();
		}
		
	}

	//Profile
	public String getName(String vemail) throws SQLException {
		String name="";
		String query="select username from user where email=?";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setString(1, vemail);
			try(ResultSet rs=statement.executeQuery()){
				if(rs.next()) {
					name=rs.getString("username");
				}
			}
		}
		return name;
	}

	//  Profile
	public String password(String vemail) throws SQLException {
		String password="";
		String query="select password from user where email=?";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setString(1, vemail);
			try(ResultSet rs=statement.executeQuery()){
				if(rs.next()) {
					password=rs.getString("password");
				}
			}
		}
		return password;
	}

	// Profile
	public String dob(String vemail) throws SQLException {
		Date date;
		String dob="";
		String query="select date_of_birth from user where email=?";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setString(1, vemail);
			try(ResultSet rs=statement.executeQuery()){
				if(rs.next()) {
					date=rs.getDate("date_of_birth");
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					dob=dateFormat.format(date);
				}
			}
		}
		return dob;
	}
	
	//  HomePage , DeleteSong
	public void loadSongs(int playlistId, DefaultListModel<String> songListModel) throws SQLException {
	    songListModel.clear();
	    String header = String.format("%-25s %-20s %-8s", "Song", "Artist", "Duration");
	    songListModel.addElement(header);
	    String query = "SELECT s.title, s.artist, s.duration FROM songs s JOIN playlist_songs ps ON s.song_id = ps.song_id WHERE ps.playlist_id = ?";
	    try (PreparedStatement statement = con.prepareStatement(query)) {
	        statement.setInt(1, playlistId);
	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	            String songTitle = resultSet.getString("title");
	            String artist = resultSet.getString("artist");
	            String duration = resultSet.getString("duration");
	            String songInfo = String.format("%-25s %-20s %-8s", songTitle, artist, duration);
	            songListModel.addElement(songInfo);
	        }
	    }
	}

	// HomePage: To search songs
	public int search(String search) throws SQLException {
		String query = "select distinct ps.playlist_id " +
                "from playlist_songs ps " +
                "join songs s on ps.song_id = s.song_id " +
                "join playlist p ON ps.playlist_id = p.playlist_id " +
                "where s.title like ? OR s.artist like ? OR p.playlist_name like ? " +
                "limit 1";
 try (PreparedStatement statement = con.prepareStatement(query)) {
     String searchPattern = "%"+search+"%";
     statement.setString(1, searchPattern);
     statement.setString(2, searchPattern);
     statement.setString(3, searchPattern);
     ResultSet resultSet = statement.executeQuery();
     if (resultSet.next()) {
         return resultSet.getInt("playlist_id");
     }
 }
    return 0; 
}
    //  HomePage
	public String getPicture(int pid) throws SQLException {
		String address="";
		String query="select image_url from playlist where playlist_id=?";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setInt(1, pid);
			try(ResultSet rs=statement.executeQuery()){
				if(rs.next()) {
					address=rs.getString("image_url");
				}
			}
		}
		return address;
	}

	// HomePage
	public String playlistName(int plid) throws SQLException {
		String name="";
		String query="select playlist_name from playlist where playlist_id=?";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setInt(1, plid);
			try(ResultSet rs=statement.executeQuery()){
				if(rs.next()) {
					name=rs.getString("playlist_name");
				}
			}
		}
		return name;
	}

	// HomePage, AddPlaylist
	public int getUserID(String email) throws SQLException {
		int uid=0;
		String query="select user_id from user where email=?";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setString(1, email);
			try(ResultSet rs=statement.executeQuery()){
				if(rs.next()) {
				uid=rs.getInt("user_id");
			}
			}
		}
		return uid;
	}

	// HomePage
	public void loadPlaylists(int uid, DefaultListModel<String> songListModel1) throws SQLException {
		songListModel1.clear();
		String query="select playlist_name from playlist where user_id=?";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setInt(1, uid);
			ResultSet rs=statement.executeQuery();
				  while (rs.next()) {
			            String pname=rs.getString("playlist_name");
			            songListModel1.addElement(pname);
			}
		}
		
	}

	// AddPlaylist
	public void addPlaylist(int uid, String pname) throws SQLException {
		String query="insert into playlist(playlist_name,user_id,image_url) values(?,?,?)";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setString(1,pname);
			statement.setInt(2,uid);
			statement.setString(3,"none");
			statement.executeUpdate();
		}
		
	}

	// AddPlaylist
	public boolean checkPlaylist(String pname) throws SQLException {
		String query="select playlist_name from playlist where playlist_name=?";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setString(1, pname);
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

	//  HomePage
	public void deletePlaylist(String pName) throws SQLException {
		String query="delete from playlist where playlist_name=?";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setString(1, pName);
			statement.executeUpdate();
		}
		
	}

	// HomePage
	public void editPlaylist(String pName, String newName) throws SQLException {
		String query="update playlist set playlist_name=? where playlist_name=?";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setString(1, newName);
			statement.setString(2, pName);
			statement.executeUpdate();
		}
		
	}

	// HomePage , AddSong , DeleteSong
	public int getPID(String pName) throws SQLException {
		int pid=0;
		String query="select playlist_id from playlist where playlist_name=?";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setString(1, pName);
			try(ResultSet rs=statement.executeQuery()){
				if(rs.next()) {
				pid=rs.getInt("playlist_id");
			}
			}
		}
		return pid;
	}

	// AddSong
	public void loadAllSongs(DefaultListModel<String> songListModel10) throws SQLException {
		 songListModel10.clear();
		    String header = String.format("%-25s %-20s %-8s", "Song", "Artist", "Duration");
		    songListModel10.addElement(header);
		    String query = "SELECT title, artist, duration FROM songs";
		    try (PreparedStatement statement = con.prepareStatement(query)) {
		        ResultSet resultSet = statement.executeQuery();
		        while (resultSet.next()) {
		            String songTitle = resultSet.getString("title");
		            String artist = resultSet.getString("artist");
		            String duration = resultSet.getString("duration");
		            String songInfo = String.format("%-25s %-20s %-8s", songTitle, artist, duration);
		            songListModel10.addElement(songInfo);
		        }
		    }
		
	}

	// AddSong
	public void searchSong(String song, DefaultListModel<String> songListModel10) throws SQLException {
		songListModel10.clear();
		String header = String.format("%-25s %-20s %-8s", "Song", "Artist", "Duration");
	    songListModel10.addElement(header);
	    String searchPattern = "%"+song+"%";
	    String query = "SELECT title, artist, duration FROM songs where title like ? limit 1";
	    try (PreparedStatement statement = con.prepareStatement(query)) {
	    	statement.setString(1, searchPattern);
	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	            String songTitle = resultSet.getString("title");
	            String artist = resultSet.getString("artist");
	            String duration = resultSet.getString("duration");
	            String songInfo = String.format("%-25s %-20s %-8s", songTitle, artist, duration);
	            songListModel10.addElement(songInfo);
	        }
	    }
	}

	// AddSong , DeleteSong
	public int getSongID(String songTitle, String artist) throws SQLException {
		int sid=0;
		String query="select song_id from songs where title=? and artist=?";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setString(1, songTitle);
			statement.setString(2, artist);
			try(ResultSet rs=statement.executeQuery()){
				if(rs.next()) {
				sid=rs.getInt("song_id");
			}
			}
		}
		return sid;
	}

	//  AddSong
	public void addSong(int sid, int pid) throws SQLException {
		String query="insert into playlist_songs(playlist_id,song_id) values(?,?)";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setInt(1,pid);
			statement.setInt(2,sid);
			statement.executeUpdate();
		}
		
	}
	
	// DeleteSong
	public void deleteSong(int sid, int pid) throws SQLException {
		String query="delete from playlist_songs where song_id=? and playlist_id=?";
		try(PreparedStatement statement=con.prepareStatement(query)){
			statement.setInt(1, sid);
			statement.setInt(2, pid);
			statement.executeUpdate();
		}
		
	}

	// AddPlaylist
	public int getLastUserID() throws SQLException {
		int uid=0;
		String query="select user_id from user order by user_id desc limit 1";
		try(PreparedStatement statement=con.prepareStatement(query)){
			try(ResultSet rs=statement.executeQuery()){
				if(rs.next()) {
				uid=rs.getInt("user_id");
			}
			}
		}
		return uid;
	}

	// Profile
	public String getLastEmail() throws SQLException {
		String email="";
		String query="select email from user order by user_id desc limit 1";
		try(PreparedStatement statement=con.prepareStatement(query)){
			try(ResultSet rs=statement.executeQuery()){
				if(rs.next()) {
				email=rs.getString("email");
			}
			}
		}
		return email;
	}

		

	
  
}

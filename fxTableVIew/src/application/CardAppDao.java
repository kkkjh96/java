package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CardAppDao {
	
	private static Connection conn;
	private PreparedStatement pstmt;
	private ObservableList<Person> data;
	
	private int num;



public CardAppDao() {
	DBConnection connect = new DBConnection();
	if(conn == null) {
		conn = connect.getConnection();
	}
}

public ObservableList<Person> getData() {
	 try {
	 pstmt = conn.prepareStatement("select * from addressbook");

	 data = FXCollections.observableArrayList();
	 ResultSet rs = pstmt.executeQuery();
	 
	 while (rs.next()) {

		 Person person = new Person();

		 person.setNo(rs.getInt("No"));
		 person.setName(rs.getString("Name"));
		 person.setCom(rs.getString("Company"));
		 person.setAddr(rs.getString("address"));
		 person.setPhone(rs.getString("phone"));
		 person.setEmail(rs.getString("email"));
		 person.setBirthday(rs.getString("birthday"));

		 data.add(person);
	  	}
	 } 
	 	catch (Exception e) {
		 e.printStackTrace();
		 System.out.println("Dao.getData():Error on Building Data");
		 return null;
	 	}
	 	return data;
	}
public boolean deleteData(int no) throws Exception {
		try {
			pstmt = conn.prepareStatement("delete from addressbook where no = ?");
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
			
			conn.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			
			return false;
		}
		return true;
	}
public boolean insertPerson(Person person) throws Exception {
		int no = 0;
		String sql = "SELECT max(no) FROM addressbook";
		
		if(rs.next()) { no = rs.getInt(1); }
		if(rs != null) rs.close();
	
		sql = "insert into addressbook(no, name, company, address, email, phone, birthday) value(?, ?, ?, ?, ?, ?, ?)";
	
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
		
			pstmt.setInt(1, no+1);
			pstmt.setString(2, person.getName());
			pstmt.setString(3, person.getCom());
			pstmt.setString(4, person.getAddr());
			pstmt.setString(5, person.getEmail());
			pstmt.setString(6, person.getPhone());
			pstmt.setString(7, person.getBirthday());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			
			conn.commit();
		
		}
			catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}




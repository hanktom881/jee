package com.tom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLTester {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager
				.getConnection("jdbc:mysql://j.snpy.org/atm?user=j104&password=104jabc&useUnicode=true&characterEncoding=UTF-8");
			//																		useUnicode=true
			//																		characterEncoding=UTF-8
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users");
			while(rs.next()){
				int id = rs.getInt("id");
				String userid = rs.getString("userid");
				String pw = rs.getString("pw");
				float balance = rs.getFloat("balance");
				System.out.println(id+"/"+userid+"/"+pw+"/"+balance);
			}
			rs.close();
			stmt.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}

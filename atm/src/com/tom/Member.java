package com.tom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Member {
	String userid;
	String nickname;
	String password;
	String password2;
	String email;
	String error;

	public boolean check() {
		StringBuilder error = new StringBuilder();
		boolean checked = true;
		if (userid.length() < 4) {
			checked = false;
			error.append("帳號至少4個字元</br>");
		}
		if (password.length() < 4) {
			checked = false;
			error.append("密碼至少4個字元</br>");
		}
		if (!password.equals(password2)) {
			checked = false;
			error.append("密碼不一致</br>");
		}
		if (email.indexOf("@") == -1) {
			checked = false;
			error.append("E-mail格式不符</br>");
		}
		this.error = error.toString();
		return checked;
	}

	public Member() {

	}

	public Member(String userid, String nickname, String password, String password2, String email) {
		super();
		this.userid = userid;
		this.nickname = nickname;
		this.password = password;
		this.password2 = password2;
		this.email = email;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public void save() {
		Connection conn = null;
		String sql = "INSERT INTO member(userid,password,nickname,email) VALUES(?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
				.getConnection("jdbc:mysql://j.snpy.org/j104?user=j104&password=104jabc&useUnicode=true&characterEncoding=UTF-8");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			pstmt.setString(3, nickname);
			pstmt.setString(4, email);
			int rowCount = pstmt.executeUpdate();
			pstmt.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
	}

}

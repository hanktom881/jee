package com.tom;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String pw = request.getParameter("pw");
		if (userid != null && pw != null) {
			Connection conn = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager
					.getConnection("jdbc:mysql://j.snpy.org/j104?user=j104&password=104jabc");
				/*Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from users where "
						+ "userid = '"+userid+"' and pw='"+pw+"'");*/
				String sql = "select * from users where userid = ? and pw = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userid);
				pstmt.setString(2, pw);
				ResultSet rs = pstmt.executeQuery();
				boolean pass = rs.next();
				if (pass){
//					response.getWriter().append("1");
					response.sendRedirect("success.jsp"); 
				}else{
//					response.getWriter().append("0");
					HttpSession session = request.getSession();
					session.setAttribute("error", "登入失敗,請重新登入");
					response.sendRedirect("login.jsp");
				}
				rs.close();
				pstmt.close();
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

			/*
			if (userid.equals("jack") && pw.equals("1234")) {
				response.getWriter().append("1");
			} else {
				response.getWriter().append("0");
			}*/
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.tom;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/reg")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String email = request.getParameter("email");
		boolean checked = true;
		StringBuilder error = new StringBuilder();
		if (userid!=null && nickname!=null){
			if (userid.length()<4){
				checked = false;
				error.append("帳號至少4個字元</br>");
			}
			if (password.length()<4){
				checked = false;
				error.append("密碼至少4個字元</br>");
			}
			if (!password.equals(password2)){
				checked = false;
				error.append("密碼不一致</br>");
			}
			if (email.indexOf("@")==-1){
				checked = false;
				error.append("E-mail格式不符</br>");
			}
			if (checked){
				//insert 
				
			}else {
				// go back to reg.jsp
				HttpSession session = request.getSession();
				session.setAttribute("error", error.toString());
				session.setAttribute("userid", userid);
				session.setAttribute("password", password);
				session.setAttribute("password2", password2);
				session.setAttribute("nickname", nickname);
				session.setAttribute("email", email);
				
				response.sendRedirect("reg.jsp");
			}
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

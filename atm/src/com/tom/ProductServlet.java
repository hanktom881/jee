package com.tom;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/p")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
				.getConnection("jdbc:mysql://j.snpy.org/j104?user=j104&password=104jabc&useUnicode=true&characterEncoding=UTF-8");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from product");
			ArrayList<Product> products = new ArrayList<Product>();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String info = rs.getString("info");
				int stock = rs.getInt("stock");
				Product p = new Product(id, name, price, info, stock);
				products.add(p);
			}
			Gson gson = new Gson();
			String json = gson.toJson(products);
			System.out.println(json);
			
			//
			gson.fromJson(json, ArrayList.class<Product>);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

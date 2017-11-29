package com.ibm.twreed;

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

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection conn = null;
	Driver driver = new Driver(); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		request.setAttribute("names", name);
		request.getRequestDispatcher("/WEB-INF/views/search.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Statement stmt = null;
		ResultSet rs = null;
		
		// retrieve parameters from form
		String name = request.getParameter("name");
		
		try {
			// get the connection to DB
			getConnection();
	    	
	    	stmt = conn.createStatement();
	    	
	    	ArrayList al = null;
	    	ArrayList student = new ArrayList();
	    	
	    	// sql statement to execute
	    	String sql = "SELECT * from STUDENT where firstname = '" + name + "';";
	    	System.out.println("queried: " + sql);
	    	
	    	rs = stmt.executeQuery(sql);
	    	
	    	while (rs.next()) {
	    		al = new ArrayList();
	    		
	    		al.add(rs.getInt(1));
	    		al.add(rs.getString(2));
	    		al.add(rs.getString(3));
	    		
	    		student.add(al);
	    	}
	    	
			request.setAttribute("sList", student);
			request.getRequestDispatcher("/WEB-INF/views/searchResult.jsp").forward(request, response);

	    	conn.close();	    	
    	} catch(Exception e) {
    		System.err.println(e);
    	}	
	}
	
	/**
	 * Establishes connection to database.
	 * 
	 * @throws SQLException 
	 */
	protected void getConnection() throws SQLException {
		try {
			Class.forName(driver.getDRIVER());
			
			conn = DriverManager.getConnection(
					driver.getURL() + driver.getDATABASE_NAME(),
					driver.getUSERNAME(),
					driver.getPASSWORD());

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}

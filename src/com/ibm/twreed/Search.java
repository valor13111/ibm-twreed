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
    }

	/**
	 * Forwards to search.jsp once page is loaded.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/search.jsp").forward(request, response);
	}
	
	/**
	 * Retrieves the 'name' from input form, which is named...'name'.  Establishes the connection, creates
	 * the statement ready to execute the query.  Two ArrayLists are created; first as a new ArrayList
	 * every time the ResultSet is looped, and the second as the final ArrayList consisting of all 
	 * the ArrayLists created.  Now, each ArrayList is accessed through the student ArrayList.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response
	 * 
	 * @throws ServletException, IOException
	 */
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
	    	
	    	// ResultSet executing query
	    	rs = stmt.executeQuery(sql);
	    	
	    	// while going through query, declare ArrayList and add all fields to student ArrayList
	    	while (rs.next()) {
	    		al = new ArrayList();
	    		
	    		al.add(rs.getInt(1));
	    		al.add(rs.getString(2));
	    		al.add(rs.getString(3));
	    		
	    		student.add(al);
	    	}
	    	
	    	// set attribute in searchResult.jsp to the student ArrayList
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

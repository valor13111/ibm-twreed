package com.ibm.twreed;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection conn = null;
	Driver driver = new Driver();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
    }

	/**
	 * Forwards to addStudent.jsp.  Retrieves parameters from jsp file, and creates an
	 * sql query to insert into database using the parameters.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * @throws ServletException, IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/addStudent.jsp").forward(request, response);
		
		Statement stmt = null;
		
		// retrieve parameters from form
		String studentId = request.getParameter("studentid");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		
		try {
			// get the connection to DB
			getConnection();
	    	
	    	stmt = conn.createStatement();
	    	
	    	// sql statement to execute
	    	String sql = "INSERT INTO STUDENT(idstudent, firstname, lastname) "
	    			+ "VALUES('" + studentId + "', '" + firstName + "', '" + lastName + "')";
	    	
	    	stmt.executeUpdate(sql);

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

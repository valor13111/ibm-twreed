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
 * Servlet implementation class DeleteStudent
 */
@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection conn = null;
	Driver driver = new Driver();   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudent() {
        super();
    }

	/**
	 * Forwards to deleteStudent.jsp, once the id parameter has been retrieved from the jsp file.
	 * Creates query based on the id, and executes.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * @throws ServletException, IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		Statement stmt = null;
		ResultSet rs = null;
		
		// retrieve parameters from form
		String studentId = request.getParameter("studentid");
		
		try {
			// get the connection to DB
			getConnection();
	    	
	    	stmt = conn.createStatement();
	    	
	    	// sql statement to execute, int is wrapped with single quotes
	    	String sql = "DELETE from STUDENT where idstudent = '" + studentId + "';";
	    	
	    	stmt.executeUpdate(sql);

	    	conn.close();	    	
	    	
    	} catch(Exception e) {
    		System.err.println(e);
    	}	
		
		request.getRequestDispatcher("/WEB-INF/views/deleteStudent.jsp").forward(request, response);		
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

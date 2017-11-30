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
 * Servlet implementation class ListStudent
 */
@WebServlet("/ListStudent")
public class ListStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection conn = null;
	Driver driver = new Driver();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListStudent() {
        super();
    }

	/**
	 * Forwards to listStudent.jsp once connection is established, and the ResultSet is set.
	 * Creates two ArrayLists; the first one 'list' houses the iteration through each ResultSet
	 * as an ArrayList.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * @throws ServletException, IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {			
			// get the connection to DB
			getConnection();
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM STUDENT;");
			
			ArrayList list = null;
			ArrayList listStudents = new ArrayList();
			
			// iterate through the ResultSet and add the parameters to list
			// then add 'list' ArrayList to 'listStudents'
			while (rs.next()) {
				list = new ArrayList();
				
				int studentid = rs.getInt("idstudent");
				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastname");
				
				list.add(studentid);
				list.add(firstName);
				list.add(lastName);
				
				listStudents.add(list);
			}
			
			// set attribute in listStudent.jsp with ArrayList 'listStudents'
			request.setAttribute("sList", listStudents);
			request.getRequestDispatcher("/WEB-INF/views/listStudent.jsp").forward(request, response);
			
			// close connections
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
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

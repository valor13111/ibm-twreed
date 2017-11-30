/**
 * 
 */
package com.ibm.twreed;

/**
 * Driver class hosts the database information to make connection.
 * 
 * @author Tyler Reed
 */
public class Driver {
	
	private final String URL = "jdbc:mysql://localhost:3306/";
	private final String DATABASE_NAME = "testdb";
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String USERNAME = "root";
	private final String PASSWORD = "password";
	
	public Driver() {}

	/**
	 * @return the URL
	 */
	protected String getURL() {
		return URL;
	}

	/**
	 * @return the Database_Name
	 */
	protected String getDATABASE_NAME() {
		return DATABASE_NAME;
	}

	/**
	 * @return the Driver
	 */
	protected String getDRIVER() {
		return DRIVER;
	}

	/**
	 * @return the Username
	 */
	protected String getUSERNAME() {
		return USERNAME;
	}

	/**
	 * @return the Password
	 */
	protected String getPASSWORD() {
		return PASSWORD;
	}

}

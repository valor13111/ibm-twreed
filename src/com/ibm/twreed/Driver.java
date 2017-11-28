/**
 * 
 */
package com.ibm.twreed;

/**
 * @author Tyler Reed
 *
 */
public class Driver {
	
	private final String URL = "jdbc:mysql://localhost:3306/";
	private final String DATABASE_NAME = "testdb";
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String USERNAME = "root";
	private final String PASSWORD = "password";
	
	public Driver() {}

	/**
	 * @return the uRL
	 */
	protected String getURL() {
		return URL;
	}

	/**
	 * @return the dATABASE_NAME
	 */
	protected String getDATABASE_NAME() {
		return DATABASE_NAME;
	}

	/**
	 * @return the dRIVER
	 */
	protected String getDRIVER() {
		return DRIVER;
	}

	/**
	 * @return the uSERNAME
	 */
	protected String getUSERNAME() {
		return USERNAME;
	}

	/**
	 * @return the pASSWORD
	 */
	protected String getPASSWORD() {
		return PASSWORD;
	}

}

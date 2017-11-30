# ibm-twreed

## There is a starter.sql under /ibm-twreed which creates the database, table, and gives four students with id, firstname, and lastname.

## I used MySQL for the database.  The following properties for the database connection are:
	Database: testdb
	URL: jdbc:mysql://localhost:3306
	root: root
	password: password
	
## If these need changed, they can be in the Driver.java class.

## I had issues in beginning with class path, the mysql-connector is located under Referenced Libraries, and was included as a separate file
## just in case that didn't work.  Had to go to 'Deploy Assembly' and add the connector before it would establish connection.

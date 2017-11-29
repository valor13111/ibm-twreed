<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>

<%@ page import="java.util.*" %>

<!DOCTYPE>
<html>
	<jsp:include page="../include/header.jsp" /> 
<body>
<h1>Home Page</h1>

<div class="container">
	<input type="button" 
		   value="Add Student" 
		   onclick="window.location.href='/ibm-twreed/AddStudent'; return false;"
		   class="btn btn-primary btn-lg"
		   style="margin-bottom: 10px;"
	/>
	
	<input type="button" 
		   value="List Students" 
		   onclick="window.location.href='/ibm-twreed/ListStudent'; return false;"
		   class="btn btn-info btn-lg"
		   style="margin-bottom: 10px;"
	/>
	
	<input type="button" 
		   value="Delete Student" 
		   onclick="window.location.href='/ibm-twreed/DeleteStudent'; return false;"
		   class="btn btn-info btn-lg"
		   style="margin-bottom: 10px;"
	/>
	
	<input type="button" 
		   value="Search for Student" 
		   onclick="window.location.href='/ibm-twreed/Search'; return false;"
		   class="btn btn-info btn-lg"
		   style="margin-bottom: 10px;"
	/>
</div>

</body>
</html>
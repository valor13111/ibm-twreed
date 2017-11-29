<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:include page="../include/header.jsp" /> 
<body>

<h1>Delete a Student by ID:</h1>

<form method="GET" action="ListStudent">
	<div class="container">
		<input type="text" placeholder="Enter a valid ID" name="studentid" />
		<input type="submit" value="Submit" class="btn btn-primary" name="submit" />
	</div>
</form>


</body>
</html>
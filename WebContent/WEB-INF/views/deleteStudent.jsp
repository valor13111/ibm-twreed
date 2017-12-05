<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:include page="../include/header.jsp" /> 
<body>

<h2 class="text-center">Delete a Student by ID</h1>

<form method="GET" action="DeleteStudent">
	<div class="container text-center">
		<input type="number" placeholder="Enter a valid ID" name="studentid" required />
		<input type="submit" value="Submit" class="btn btn-primary" name="submit" />
	</div>
</form>


</body>
</html>
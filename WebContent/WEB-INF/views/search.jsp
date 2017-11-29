<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:include page="../include/header.jsp" /> 
<body>

<h1>HIII</h1>
<form method="POST" action="Search">
	<div class="container">
		<input type="text" placeholder="Enter student first name" name="name" />
		<input type="submit" value="Submit" class="btn btn-primary" name="submit" />
	</div>
</form>

</body>
</html>
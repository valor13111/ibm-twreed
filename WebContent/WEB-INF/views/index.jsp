<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<jsp:include page="../include/header.jsp" /> 
<body>
<h1>Home Page</h1>

<form action="/ibm-twreed/home" method="post">
	<input type="number" name="id" placeholder="student id" /> <input type="submit" />
</form>
<h6>Click here for <a href="Hello">second page</a></h6>
</body>
</html>
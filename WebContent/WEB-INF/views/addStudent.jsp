<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:include page="../include/header.jsp" /> 
<body>

<form method="GET" action="AddStudent">
<div class="container">
	<div class="table-responsive">  
		<table class="table">
			<h2 align="center">Insert Into Database: Student List</h2>
			<tr>
			<td><b>Student ID:</b></td>
			<td><input type="number" name="studentid" required></td>
			</tr>
			<tr>
			<td><b>First Name:</b></td>
			<td><input type="text" name="firstname" required></td>
			</tr>
			<tr>
			<td><b>Last Name:</b></td>
			<td><input type="text" name="lastname" required></td>
			</tr>
			<p>
			   <input type="submit" value="Submit" class="btn btn-primary" name="submit">
			   <input type="reset" value="Reset" class="btn btn-danger" name="reset">
		    </p>
		</table>
	</div>
</div>
</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<!DOCTYPE>
<html>
	<jsp:include page="../include/header.jsp" /> 
<body>

<h2 align="center">List Database: Student List</h2>

<div class="container">
	<div class="table-responsive">  
		<table class="table">
			<tr>
				<td class="info">ID</td>
				<td class="info">First Name</td>
				<td class="info">Last Name</td>
			</tr>
				<%
				int count = 0;
				if (request.getAttribute("sList") != null) {
				    ArrayList studentList = (ArrayList) request.getAttribute("sList");
				    Iterator itr = studentList.iterator();
				    while (itr.hasNext()) {
				        count++;
				        ArrayList list = (ArrayList) itr.next();
	
				%>
		    <tr>
			    <td><%= list.get(0) %></td>
			    <td><%= list.get(1) %></td>
			    <td><%= list.get(2) %></td>
		    </tr>
		    <% 
				    }
				}
			%>

    </table>
  </div>
</div>

</body>
</html>
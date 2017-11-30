<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*" %>

<!DOCTYPE>
<html>
	<jsp:include page="../include/header.jsp" /> 
<body>

<div class="container">
	<div class="table-responsive">  
		<h3 class="text-center">Student Record(s)</h3>
		<table class="table">
			<tr>
				<td class="info"><b>ID</b></td>
				<td class="info"><em>First Name</em></td>
				<td class="info"><em>Last Name</em></td>
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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*" %>

<!DOCTYPE>
<html>
	<jsp:include page="../include/header.jsp" /> 
<body>

<table width="700px" align="center"
               style="border:1px solid #000000;">
            <tr>
                <td colspan=4 align="center"
                    style="background-color:teal">
                    <b>Student Record</b></td>
            </tr>
            <tr style="background-color:lightgrey;">
                <td><b>ID</b></td>
                <td><b>First Name</b></td>
                <td><b>Last Name</b></td>
            </tr>
            <%
                int count = 0;
                String color = "#F9EBB3";
                if (request.getAttribute("sList") != null) {
                    ArrayList al = (ArrayList) request.getAttribute("sList");
                    System.out.println(al);
                    Iterator itr = al.iterator();
                    while (itr.hasNext()) {
 
                        if ((count % 2) == 0) {
                            color = "#eeffee";
                        }
                        count++;
                        ArrayList pList = (ArrayList) itr.next();
            %>
            <tr style="background-color:<%=color%>;">
                <td><%=pList.get(0)%></td>
                <td><%=pList.get(1)%></td>
                <td><%=pList.get(2)%></td>
            </tr>
            <%
                    }
                }
                if (count == 0) {
            %>
            <tr>
                <td colspan=4 align="center"
                    style="background-color:#eeffee"><b>No Record Found..</b></td>
            </tr>
            <%            }
            %>
        </table>

</body>
</html>
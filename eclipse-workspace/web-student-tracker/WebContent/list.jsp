<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Student Tracker</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">



</head>

<body>
	<div id="wrapper">
	<div id="header">
	
		<h2>Platform3Solutions</h2>
	</div>
  </div>
	
	<div id="container">
		<div id="content">
			<input type="button" value="Add Employee" onclick="window.location.href='add-form.jsp';return false;"  class="add-employee-button"/><br>
			
		
			<table>
		
				<tr>
			    	<th>FirstName</th>
			    	<th>LastName</th>
			    	<th>Email</th>
			    	<th>Action</th>
			
				</tr>
			
				<c:forEach var="tempEmployee" items="${EMPLOYEE_LIST}" >
				
					<c:url var="tempLink" value="EmployeeControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="employeeId" value="${tempEmployee.id }"/>
					</c:url>
					
					<c:url var="deleteLink" value="EmployeeControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="employeeId" value="${tempEmployee.id }"/>
					</c:url>
			
					<tr>
						<td> ${tempEmployee.firstName} </td>
						<td> ${tempEmployee.lastName} </td>
						<td> ${tempEmployee.email} </td>
						<td> <a href="${tempLink}">Update</a>
						<td><a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">Delete</a>
					
					
					</tr>
			
			
			  </c:forEach>
				
				
		</table>
		
  </div>
  	</div>
	


</body>

</html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<title>Add</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/add-employee-style.css">
</head>
<body>
   <div id="wrapper">
   	<div id="header">
   		<h1>PLATFORM3SOLUTIONS</h1>
   	</div>
   <div id="container">
   		<h3>Add Employee</h3>
   		
   		<form action="EmployeeControllerServlet" method="get">
   		<input type="hidden"  name="command" value="ADD" />
   		   <table>
   		   
   		   
   		    <tbody>
   		         <td><label>FirstName:</label></td>
   		         <td><input type="text" name="firstName"/></td>
   		     </tr>
   		         
   		        
   		      <tr>
   		         <td><label>LastName:</label></td>
   		         <td><input type="text" name="lastName"/></td>
   		       </tr>
   		       
   		       <tr>
   		         <td><label>Email:</label></td>
   		         <td><input type="text"  name="email"/></td>
   		        </tr>
   		        
   		        <tr>
   		        	<td><label></label></td>
   		        	<td><input type="submit"  value="Save"  class="save" /></td>
   		        </tr>
   		      
   		      
   		      
   		      </tbody>
   		         
   		         
   		   
   		   
   		   </table>
   		
   		
   		
   		</form>
   		<div style="clear:both"></div>
   		
   		<p>
   		   <a href="EmployeeControllerServlet">Back to list</a>
   		</p>
   </div>
   
   
   
   </div>






</body>

</html>
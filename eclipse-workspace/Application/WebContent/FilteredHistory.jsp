<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Renewal History </title>
</head>
<body>




<div id="wrapper">
		<header class="header">
			<div class="viewPort">
				<img src="images/d360.png" alt="P3 SOLUTIONS" align="left"
					width="100px" height="50px" />
				<center>
					<h1>Application History For Admin</h1>
				</center>
			</div>
		</header>
	</div>
	
	</br>
	
	  <form action="Controller" method="get">
         <input type="hidden" name="command" value="ADMINAPPLICATIONS" />
    		<button type="submit" class="link-button">Back</button>
		</form>
		<center>
	
  


	<div id="container">
			<div id="content">
	<table>
		<tr>
			<th>LICENCE ID</th>
			<th>USERNAME</th>
			<th>ApplicationName</th>
			<th>RENEWED DATE</th>
			<th>RENEWAL DATE</th>
		</tr>
		
		 <c:forEach var="tempClient" items="${RenewalDetails}">
                    <!-- set up a link for each student -->
                    
                    <tr>
                        <td>${tempClient.license_Id}</td>
                        <td>${tempClient.userName}</td>
                        <td>${tempClient.applicationName}</td>
                        <td>${tempClient.renewed_Date}</td>
                        <td>${tempClient.renewal_Date}</td>
                        
                    </tr>
                </c:forEach>
		
		
		</div>
	</div>
</center>
</table>
</body>
</html>
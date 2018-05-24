<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<title>Edit/Update Employee</title>
</head>
<body>
	
	<div id="wrapper">
		<div class="header">
			<h2>Employee Directory</h2>
		</div>
	</div>
	
	<div class="container">
		<h3>Edit/Update Employee</h3>
		
		<form action="EmployeeControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />
			
			<input type="hidden" name="employeeId" value="${the_employee.id}" />
			
			
			<table>
				<tbody>
					<tr>
						<td><label>First Name:</label></td>
						<td><input type="text" name="firstName" 
							value="${the_employee.firstName}" /></td>
					</tr>
					
					<tr>
						<td><label>Last Name:</label></td>
						<td><input type="text" name="lastName" 
							value="${the_employee.lastName}"/></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><input type="text" name="email" 
							value="${the_employee.email}"/></td>
					</tr>
					<tr>
						<td><label>Phone Number:</label></td>
						<td><input type="text" name="phoneNumber" 
							value="${the_employee.phoneNumber}"/></td>
					</tr>
					<tr>
						<td><label>Address:</label></td>
						<td><input type="text" name="address" 
							value="${the_employee.address}"/></td>
					</tr>
					<tr>
						<td><label>City:</label></td>
						<td><input type="text" name="city" 
							value="${the_employee.city}"/></td>
					</tr>
					<tr>
						<td><label>State:</label></td>
						<td><input type="text" name="state" 
							value="${the_employee.state}"/></td>
					</tr>
					<tr>
						<td><label>Zip Code:</label></td>
						<td><input type="text" name="zipCode" 
							value="${the_employee.zipCode}"/></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>					
				</tbody>
			</table>
		</form>
		
		<div style="clear:both;"></div>
		
		<p>
			<a href="EmployeeControllerServlet">Back To List</a>
		
	</div>
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
	
</body>
</html>
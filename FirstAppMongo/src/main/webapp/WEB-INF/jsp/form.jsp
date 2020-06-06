<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User details</title>
</head>
<style>
.hidden {display: none;}
input {
	width: 90%;
	    height:30px;
	    color: #2a2a72;
	
	
}
button {
	cursor: pointer;
	background-color: #2a2a72;
	color: white;
	padding: 15px 32px;
	border: none;
	font-size: 16px;
	
}
h2 {
background: #2a2a72}

fieldset {
	font-size: 30px;
	margin-top: 60px;
	text-align: center;
	border: 0a0000;
	background: #e7e7e7;
}

body {
	margin: auto;
  width: 50%;
  color : white;
}
</style>
<body>
	<fieldset>
		<h2>USER DETAILS FORM</h2>
		<form:form action="/user/save" modelAttribute="userForm"
			method="POST">
			<div class="hidden">
				<label>_Id: </label> <br>
				<tr>
					<form:input path="id" />
				</tr>
			</div>
			<br>
			<br>
			<label>Name: </label>
			<br>
			<tr>
				<form:input path="name" />
			</tr>
			<br>
			<br>
			<label>Date OF Birth:</label>
			<br>
			<tr>
				<form:input path="dateOfBirth" />
			</tr>
			<br>
			<br>
			<label>Phone Number:</label>
			<br>
			<tr>
				<form:input path="phoneNum" />
			</tr>
			<br>
			<br>
			<label>Pan/Adhar:</label>
			<br>
			<tr>
				<form:input path="uniqueId" />
			</tr>
			<br>
			<br>
			<button type="submit">Save</button>
		</form:form>
	</fieldset>

</body>
</html>
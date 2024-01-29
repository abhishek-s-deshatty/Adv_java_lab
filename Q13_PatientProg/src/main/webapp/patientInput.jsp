<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="patientServlet" method="get">
		<h2>Patient Information System</h2>
		patient id: <input type="text" name="id">
		<br>
		patient name: <input type="text" name="name">
		<br>
		Patient age: <input type="text" name="age">
		<br>
		Date of admission :  <input type="text" name="doa">
		<br>
		Cause of admission:  <input type="text" name="coa">
		<br>
		Doctor diagnosed: <input type="text" name="doctor">
		<br>
		Treatment proposed: <input type="text" name="treatment">
		<br>
		 <input type="submit" value="submit!">
		<br>
	</form>
</body>
</html>
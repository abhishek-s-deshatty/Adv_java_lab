<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<h1>Tshirt order form</h1>
	
	<form action="Response.jsp">
		select Tshirt accessories:
		<br>
		<label><input type="checkbox" name="accessories" value="belt">belt</label>
		<label><input type="checkbox" name="accessories" value="cap">cap</label>
		<label><input type="checkbox" name="accessories" value="hairband">hairband</label>
		<br>
		Enter tag-line : <input type="text" name="tagline">
		<br>
		Tshirt options:
		<br>
		<label><input type="radio" name="chestpocket">with chest pocket</label>
		<label><input type="radio" name="chestpocket">without chest pocket</label>
		<br>
		
		Tshirt color:
		<br>
		<select name="color">
			<option>Red</option>
			<option>green</option>
			<option>yellow</option>
			<option>pink</option>
		</select>
		<br>
		<input type="submit" value="Submit!">
		
	</form>
</body>
</html>
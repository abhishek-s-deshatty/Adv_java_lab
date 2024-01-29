<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<%
	String[] accessories = request.getParameterValues("accessories");
	String tagLine = request.getParameter("tagline");
	String option = request.getParameter("chestpocket");
	String color = request.getParameter("color");

	// since check boxes can take more than one choosings so all chosen options are populated into array
	// just converting this array into a readable stringbuffer
	//why string buffer? its mutable!
	StringBuilder str = new StringBuilder();
	if (accessories.length > 0) {
		for (String acr : accessories) {
			str.append(acr).append(" , ");
		}
	}
	String accr = str.toString();

	Connection conn = null;
	PreparedStatement stmnt, stmnt1 = null;
	ResultSet rs = null;

	String dburl = "jdbc:mysql://localhost:3306/prgm14";
	String username = "root";
	String password = "password";

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(dburl, username, password);
		stmnt = conn.prepareStatement("INSERT INTO tshirt (accessories, tagline, chestpocket, color) VALUES (?,?,?,?)");

		stmnt.setString(1, accr);
		stmnt.setString(2, tagLine);
		stmnt.setString(3, option);
		stmnt.setString(4, color);

		int eff = stmnt.executeUpdate();
		if (eff > 0) {
			System.out.println("entered");
		}

		stmnt1 = conn.prepareStatement("select * from tshirt");
		rs = stmnt1.executeQuery();
		
		out.println("<table>");
		out.println("<tr><th>id</th><th>accessories</th><th>tagline</th><th>option</th><th>color</th></tr>");

		while (rs.next()) {
			
			int id = rs.getInt(1);
			String accessory = rs.getString(2);
			String tagline = rs.getString(3);
			String optiona = rs.getString(4);
			String colors = rs.getString(5);
			out.println("<tr><td>" + id + "</td><td>" + accessory + "</td>" + "<td>" + tagline + "</td>" + "<td>" + optiona
			+ "</td>" + "<td>" + colors + "</td></tr>");

		}

	} catch (SQLException ex) {
		ex.printStackTrace();
	}
	%>
	
</body>
</html>
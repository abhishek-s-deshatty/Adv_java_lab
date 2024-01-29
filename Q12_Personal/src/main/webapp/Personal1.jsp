<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.sql.DriverManager" %>    
<%@page import="java.sql.*,java.util.*" %>
<%
String fname=request.getParameter("fname");
String lname=request.getParameter("lname");
int age = Integer.parseInt(request.getParameter("age"));
String city=request.getParameter("city");
String email=request.getParameter("email");

try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/person", "root", "password");
		PreparedStatement st=conn.prepareStatement("insert into personal values(?,?,?,?,?)");
		st.setString(1,fname);
		st.setString(2,lname);
		st.setInt(3,age);
		st.setString(4,city);
		st.setString(5,email);
		
		int i=st.executeUpdate();
		out.println("Data is successfully inserted!");
}
catch(Exception e){
	System.out.print(e);
	e.printStackTrace();
}
%>
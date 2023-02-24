<%@page import="member.vo.MemberVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String uId = request.getParameter("userId");
	String uPw = request.getParameter("userPw");
	// JDBC를 사용해서 DB정보 가져오기
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@192.168.35.65:1521:xe";
	Connection conn = DriverManager.getConnection(url, "team4_202208M", "java");
	Statement stmt = conn.createStatement();
	String sql = "SELECT MEM_ID FROM MEMBER WHERE MEM_ID = '" + uId + "' AND MEM_PW = '" + uPw + "'";
	
	stmt.executeQuery(sql);
	ResultSet rs = stmt.executeQuery(sql);

	
	if(rs.next()){
	
%>
		{"rst" : "ok"}
<%
	}else{
%>
		{"rst" : "fail"}		
<%
	}
%>
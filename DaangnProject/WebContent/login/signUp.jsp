<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<% request.setCharacterEncoding("utf-8"); %>
<%-- <%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 

<%
	String uId = request.getParameter("userId");
	String uPw = request.getParameter("userPw");
	String uNic = request.getParameter("userNic");
	String uName = request.getParameter("userName");
	String uTel = request.getParameter("userTel");
	String uAddr1 = request.getParameter("userAddr1");
	String uMail = request.getParameter("userMail");
	
	// JDBC를 사용해서 DB정보 가져오기
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@192.168.35.65:1521:xe";
	Connection conn = DriverManager.getConnection(url, "team4_202208M", "java");
	Statement stmt = conn.createStatement();
// 	String sql = "SELECT MEM_ID FROM MEMBER WHERE MEM_ID = '" + uId + "' AND MEM_PW = '" + uPw + "'";

	
	String sql = "INSERT INTO MEMBER (MEM_ID, MEM_PW, MEM_NIC, MEM_REG, MEM_NAME, MEM_TEL, MEM_ADDR1, MEM_MAIL) VALUES ('" + uId + "', '" + uPw + "', '" + uNic + "', sysdate, '" + uName + "', '" + uTel + "', '" + uAddr1 + "', '" + uMail + "')";
				
	int a = stmt.executeUpdate(sql);
	System.out.println("가입완료 -signUp.jsp");
%>

	console.log(sql);
	console.log(a);

<%
	
	if(a>0){
%>
		{"rst" : "ok"}
<%
	}else{
%>
		{"rst" : "fail"}		
<%
	}
%>
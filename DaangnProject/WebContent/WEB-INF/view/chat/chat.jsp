<%@page import="board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="member.vo.MemberVO"%>
<%
	
	MemberVO mv = (MemberVO)session.getAttribute("memberVO");
	//세션이 없으면
	if(mv==null){
		//URL재요청
		response.sendRedirect("/DaangnProject/login/signUpIn.html");
	}
	
%>

    <!-- Head-->
	<jsp:include page="../comm/head.jsp" />
	
	<!-- CSS -->
	<style></style>
	
    </head>
	
    <body>
   
        <!-- Navigation-->
		<jsp:include page="../comm/header.jsp" />
		
        <!-- Content -->
		<jsp:include page="./chatContent.jsp" />
        
        <!-- Footer-->
        <jsp:include page="../comm/footer.jsp" />

	<!-- JavaScript -->
	<script></script>
    </body>
    
</html>



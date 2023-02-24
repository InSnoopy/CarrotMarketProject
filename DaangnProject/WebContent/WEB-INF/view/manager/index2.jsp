<%@page import="member.vo.MemberVO"%>
<%@page import="manager.vo.ManagerVO"%>
<%@page import="board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
// 	ManagerVO mnv = (ManagerVO) session.getAttribute("managerVO");
	MemberVO mv = (MemberVO) session.getAttribute("memberVO");

	//세션이 없으면
	
// 	if(mnv==null){
	
	if(mv==null) {
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
		<jsp:include page="header2.jsp" />
		
        <!-- Content -->
        <jsp:include page="../mainContent.jsp" />
        
        <!-- Footer-->
        <jsp:include page="../comm/footer.jsp" />

	<!-- JavaScript -->
	<script></script>
    </body>
    
</html>

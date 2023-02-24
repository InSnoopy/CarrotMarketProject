<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- <%@page import="member.vo.MemberVO"%> --%>
<%@page import="board.vo.BoardVO"%>


<%
// 	MemberVO mv = (MemberVO)request.getAttribute("memberVO");
	BoardVO bv = (BoardVO) request.getAttribute("boardVO");
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
        
        <table border="1">
        	<tr>
        		<th></th>
        	
        	</tr>
       	
        
        </table>
        
        
        

     
        <!-- Footer-->
        <jsp:include page="../comm/footer.jsp" />

	<!-- JavaScript -->
	<script></script>
    </body>
    
</html>
    
    
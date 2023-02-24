<%@page import="member.vo.MemberVO"%>
<%@page import="review.vo.ReviewVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//MemberVO mv = (MemberVO) request.getAttribute("memberVO"); 
	List<ReviewVO> reviewList = (List<ReviewVO>) request.getAttribute("reviewList");
	String memId = (String) request.getAttribute("memId");
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
		받은 리뷰 페이지
	<p><%=memId %></p>
	<p><%=reviewList.toString() %></p>
	
	<% 
	if (reviewList.size() > 0) {
		for(int i=0; i<reviewList.size(); i++) {
	
	%>		
	
	<p><%=reviewList.get(i).getMemId() %></p>
	<hr>
	<p><%=reviewList.get(i).getReviewDate() %></p>
	<hr>
	<p><%=reviewList.get(i).getReviewScore() %></p>
	<hr>
	<p><%=reviewList.get(i).getReviewContents() %></p>
		
	<%
		} 
	}
		else {
	%>	
	
	<p>거래 후기가 없습니다.</p>
	
	<%
		
	}
	%>
	
        <!-- Footer-->
        <jsp:include page="../comm/footer.jsp" />

	<!-- JavaScript -->
	<script></script>
    </body>
    
</html>
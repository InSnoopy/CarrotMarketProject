<%@page import="notice.vo.NoticeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!-- Head-->
	<jsp:include page="../comm/head.jsp" />
	
<% 
	NoticeVO nv = (NoticeVO) request.getAttribute("nv");
%>	
	<!-- CSS -->
	<style></style>
	
    </head>
	
    <body>
   
        <!-- Navigation-->
		<jsp:include page="../comm/header.jsp" />
		
        <!-- Content -->

		<section class="notice">
		  <div class="page-title">
		        <div class="container">
		        	<h3>공지사항</h3>
		        </div>
		    </div>
		    
<!-- 공지사항 상세 내용 -->
			<p><%=nv.getNoticeTitle() %></p>
		    <p><%=nv.getNoticeContent() %></p>
<%-- 		    <a href="delete.do?noticeId=<%=nv.getNoticeId() %>">[공지사항 삭제]</a> --%>
<%-- 		    <a href="update.do?noticeId=<%=nv.getNoticeId() %>">[공지사항 수정]</a> --%>
		    <a href="list2.do">[공지사항 목록]</a>
		</section>    
     
        <!-- Footer-->
        <jsp:include page="../comm/footer.jsp" />

	<!-- JavaScript -->
	<script></script>
    </body>
    
</html>
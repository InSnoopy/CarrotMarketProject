<%@page import="notice.vo.NoticeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!-- Head-->
	<jsp:include page="../comm/head.jsp" />
	
<% 
	NoticeVO nv = (NoticeVO) request.getAttribute("nv");
%>	
	<!-- CSS -->
	<style>
	
	section {
		height: 100vh;
		padding: 50px 300px;
	}
	
	.title {
		padding-bottom: 20px;
	}
	
	.table {
/* 		margin-left: auto; */
/* 		margin-right: auto; */
		margin: 20px auto;
	}
	
	.table th {
		width: 150px;
		background-color: #f2f3f6;
	}
	
/* 	td .noticeContent { */
/* 		padding: 10px; */
/* 	} */
	
	.noticeContent {
		height: 500px;
		padding: 20px;
		border-bottom: #eaebee 2px solid;  
		margin: 20px;
		
	}
	
	button {
		background: #4d5159;
		color: #ffffff;
		border: none;
		border-radius: 10px;
		padding: 10px;
		float: right;
		margin-right: 10px;
	}

	</style>
	
    </head>
	
    <body>
   
        <!-- Navigation-->
		<jsp:include page="../manager/header2.jsp" />
		
        <!-- Content -->

		<section class="notice">
		  <div class="page-title">
		        <div class="container">
		        
		        	<div class="title">
			        	<h3>공지사항</h3>
		        	</div>
		        	
<!-- 공지사항 상세 내용 -->
			<div class="display">
			<table class="table">
				<tbody>
					<tr>
						<th>제목</th>
						<td><%=nv.getNoticeTitle() %></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><%=nv.getManagerId() %></td>
					</tr>
					<tr>
						<th>작성일</th>
						<td><%=nv.getNoticeDate() %></td>
					</tr>
<!-- 					<tr> -->
<%-- 						<td colspan="2" class="noticeContent" height="500px" ><%=nv.getNoticeContent() %></td> --%>
<!-- 					</tr> -->
				</tbody>
			</table>
					
					<div class="noticeContent">
						<%=nv.getNoticeContent() %>
					</div>
				
			</div>
			
			<div class="bottombtn">
				<button onclick="location.href='<%=request.getContextPath()%>/notice/update.do?noticeId=<%=nv.getNoticeId() %>'">공지사항 수정</button>
				<button onclick="location.href='<%=request.getContextPath()%>/notice/delete.do?noticeId=<%=nv.getNoticeId() %>'">공지사항 삭제</button>
				<button onclick="location.href='<%=request.getContextPath()%>/notice/list.do'">공지사항 목록</button>
			</div>

		        	
		        </div>
		    </div>
		    
		</section>    
     
        <!-- Footer-->
        <jsp:include page="../comm/footer.jsp" />

	<!-- JavaScript -->
	<script></script>
    </body>
    
</html>
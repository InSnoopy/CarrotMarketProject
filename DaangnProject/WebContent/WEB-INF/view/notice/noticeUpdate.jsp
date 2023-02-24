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
	body {
	  padding-top: 170px;
	  padding-bottom: 170px;
	}
	</style>
	
    </head>
	
    <body>
   
        <!-- Navigation-->
		<jsp:include page="../manager/header2.jsp" />
		
        <!-- Content -->
		
		<article>
		<div class="container" role="main">
			<h2>공지사항</h2>
			<form name="form" id="form" role="form" method="post" action="/DaangnProject/notice/update.do">
			<input type="hidden" name="noticeId" value="<%=nv.getNoticeId() %>">
				<div class="mb-3">
					<label for="noticeTitle">제목</label>
					<input type="text" class="form-control" name="noticeTitle" id="title" placeholder="<%=nv.getNoticeTitle() %>">
				</div>				

			<!-- 	<div class="mb-3">
					<label for="reg_id">작성자</label>
					<input type="text" class="form-control" name="reg_id" id="reg_id" placeholder="이름을 입력해 주세요">
				</div> -->
				
				<div class="mb-3">
					<label for="noticeContent">내용</label>
					<textarea class="form-control" rows="5" name="noticeContent" id="content" placeholder="수정할 공지사항 내용을 입력해 주세요" ></textarea>
				</div>

				
				<!-- <div class="mb-3">
					<label for="tag">TAG</label>
					<input type="text" class="form-control" name="tag" id="tag" placeholder="태그를 입력해 주세요">
				</div> -->

			</form>

			<div >
				<button type="button" class="btn btn-sm btn-primary" id="btnSave">수정</button>
				<button type="button" class="btn btn-sm btn-primary" id="btnList">취소</button>
			</div>
		</div>
	</article>
		
		
     
        <!-- Footer-->
        <jsp:include page="../comm/footer.jsp" />

	<!-- JavaScript -->
	<script>
		$(document).on('click', '#btnSave', function(e){
			e.preventDefault();
			$("#form").submit();
		});
	
		$(document).on('click', '#btnList', function(e){
			e.preventDefault();
			location.href="/DaangnProject/notice/list.do";
		});
	
	</script>
    </body>
    
</html>
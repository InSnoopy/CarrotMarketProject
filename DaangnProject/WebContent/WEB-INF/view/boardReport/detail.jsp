<%@page import="boardReport.vo.BoardReportVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!-- Head-->
	<jsp:include page="../comm/head.jsp" />
	
<% 
	BoardReportVO brv = (BoardReportVO) request.getAttribute("brv");
%>	
	<!-- CSS -->
	<style>
	table {
  border-collapse: collapse;
  border-spacing: 0;
}
section.notice {
  padding: 80px 0;
}

.page-title {
  margin-bottom: 60px;
}
.page-title h3 {
  font-size: 28px;
  color: #333333;
  font-weight: 400;
  text-align: center;
}

#board-search .search-window {
  padding: 15px 0;
  background-color: #f9f7f9;
}
#board-search .search-window .search-wrap {
  position: relative;
/*   padding-right: 124px; */
  margin: 0 auto;
  width: 80%;
  max-width: 564px;
}
#board-search .search-window .search-wrap input {
  height: 40px;
  width: 100%;
  font-size: 14px;
  padding: 7px 14px;
  border: 1px solid #ccc;
}
#board-search .search-window .search-wrap input:focus {
  border-color: #333;
  outline: 0;
  border-width: 1px;
}
#board-search .search-window .search-wrap .btn {
  position: absolute;
  right: 0;
  top: 0;
  bottom: 0;
  width: 108px;
  padding: 0;
  font-size: 16px;
}

.board-table {
  font-size: 13px;
  width: 100%;
  border-top: 1px solid #ccc;
  border-bottom: 1px solid #ccc;
}

.board-table a {
  color: #333;
  display: inline-block;
  line-height: 1.4;
  word-break: break-all;
  vertical-align: middle;
}
.board-table a:hover {
  text-decoration: underline;
}
.board-table th {
  text-align: center;
}

.board-table .th-num {
  width: 100px;
  text-align: center;
}

.board-table .th-date {
  width: 200px;
}

.board-table th, .board-table td {
  padding: 14px 0;
}

.board-table tbody td {
  border-top: 1px solid #e7e7e7;
  text-align: center;
}

.board-table tbody th {
  padding-left: 28px;
  padding-right: 14px;
  border-top: 1px solid #e7e7e7;
  text-align: left;
}

.board-table tbody th p{
  display: none;
}

.btn {
  display: inline-block;
  padding: 0 30px;
  font-size: 15px;
  font-weight: 400;
  background: transparent;
  text-align: center;
  white-space: nowrap;
  vertical-align: middle;
  -ms-touch-action: manipulation;
  touch-action: manipulation;
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
  border: 1px solid transparent;
  text-transform: uppercase;
  -webkit-border-radius: 0;
  -moz-border-radius: 0;
  border-radius: 0;
  -webkit-transition: all 0.3s;
  -moz-transition: all 0.3s;
  -ms-transition: all 0.3s;
  -o-transition: all 0.3s;
  transition: all 0.3s;
}

.btn-dark {
  background: #555;
  color: #fff;
}

.btn-dark:hover, .btn-dark:focus {
  background: #373737;
  border-color: #373737;
  color: #fff;
}

.btn-dark {
  background: #555;
  color: #fff;
}

.btn-dark:hover, .btn-dark:focus {
  background: #373737;
  border-color: #373737;
  color: #fff;
}

/* reset */

* {
  list-style: none;
  text-decoration: none;
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}
.clearfix:after {
  content: '';
  display: block;
  clear: both;
}
.container {
  width: 1100px;
  margin: 0 auto;
}
.blind {
  position: absolute;
  overflow: hidden;
  clip: rect(0 0 0 0);
  margin: -1px;
  width: 1px;
  height: 1px;
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
		        	<h3>신고 게시글 목록</h3>
		        </div>
		    </div>
		    
<!-- 신고 게시글 상세 내용 -->

<%-- 			<p><%=nv.getNoticeTitle() %></p> --%>
<%-- 		    <p><%=nv.getNoticeContent() %></p> --%>
<%-- 		    <a href="delete.do?noticeId=<%=nv.getNoticeId() %>">[공지사항 삭제]</a> --%>
<%-- 		    <a href="update.do?noticeId=<%=nv.getNoticeId() %>">[공지사항 수정]</a> --%>
<!-- 		    <a href="list.do">[공지사항 목록]</a> -->


<!-- board list area -->
		    <div id="board-list">
		        <div class="container">
<!-- 		            <table class="board-table"> -->
<!-- 		                <thead> -->
<!-- 		                <tr> -->
<!-- 		                    <th scope="col" class="th-title">게시글 신고 코드</th> -->
<!-- 		                    <th scope="col" class="th-date">게시글 신고일</th> -->
<!-- 		                    <th scope="col" class="th-date">게시글 회원 ID</th> -->
<!-- 		                    <th scope="col" class="th-date">피신고  ID</th> -->
<!-- 		                    <th scope="col" class="th-title">관리자 처리 여부</th> -->
<!-- 		                </tr> -->
<!-- 		                </thead> -->
		                
<!-- 		                <tbody> -->
<!-- 			                <tr> -->
<%-- 			                    <td><%=mrv.getMemReportId() %></td> --%>
<%-- 			                    <td><%=mrv.getMemReportContent() %></td> --%>
<%-- 			                    <td><%=mrv.getMemReportDate() %></td> --%>
<%-- 			                    <td><a href="<%=request.getContextPath() %>/member/mypage?memId=<%=mrv.getMemId1() %>"><%=mrv.getMemId1() %></a></td> --%>
<%-- 			                    <td><a href="<%=request.getContextPath() %>/member/mypage?memId=<%=mrv.getMemId2() %>"><%=mrv.getMemId2() %></a></td> --%>
<%-- 			                    <td><%=mrv.getReportResult() %></td> --%>
<!-- 			                </tr> -->
		                
<!-- 		                </tbody> -->
		                
		                
<!-- 		            </table> -->



	<p><%=brv.getBoardReportId() %></p> 
	<p><%=brv.getBoardTitle() %></p>
	<p><%=brv.getBoardReportContent() %></p>
	<p><%=brv.getBoardReportDate() %></p>
	<p><%=brv.getBoardReportManagerCheck() %></p>
	<p><%=brv.getMemId() %></p>
	
	
<%--             <a href="delete.do?boardReportId=<%=brv.getBoardReportId()%>">[게시글 신고글 삭제]</a> --%>
            <a href="<%=request.getContextPath()%>/boardReport/list.do">[신고 게시글 목록]</a>
		        </div>
		    </div>

		</section>    
     
        <!-- Footer-->
        <jsp:include page="../comm/footer.jsp" />

	<!-- JavaScript -->
	<script></script>
    </body>
    
</html>
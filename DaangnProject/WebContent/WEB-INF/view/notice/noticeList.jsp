<%@page import="notice.vo.NoticeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!-- Head-->
	<jsp:include page="../comm/head.jsp" />
<%
	List<NoticeVO> noticeList = (List<NoticeVO>) request.getAttribute("noticeList");

%>	
	
		<!-- CSS -->
	<style>
	table {
  border-collapse: collapse;
  border-spacing: 0;
}
section.notice {
  padding: 30px 0;
  height: 100%;
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

.regBtn {
	background: #4d5159;
	color: #ffffff;
	border: none;
	border-radius: 10px;
	padding: 10px;
	float: right;
	margin-right: 50px;
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
  background: #4d5159;
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




/* 추가 */
.maincontainer { 
   display: flex; 
   justify-content: center; 
   padding: 30px 300px;
   
 } 

.leftside {
  width: 300px;
  height: 100vh;
/*   border: 1px solid black; */
  
}

.contents {
  width: 100%;
  height: 100vh;
/*   border: 1px solid black; */
}

ul {
  list-style: none;
  padding: 0;
}

.leftside {
  padding: 10px;
}

.adminpage {
  height: 75px;
  padding: 0px;
  margin: 10px 0px 10px 0px;
  font-weight: 500;
  font-size: 28px;
  line-height: 75px;
}

.sidemenu {
  border: 1px solid rgb(242, 242, 242);
  margin-top: 30px;
}

.sidemenuitems {
  padding: 20px;
}

.title {
  font-weight: 500;
  font-size: 24px;
  line-height: 70px;
  padding: 20px;
}

a {
  text-decoration: none;
  color: black;
}


</style>
    </head>
	
    <body>
   
        <!-- Navigation-->
		<jsp:include page="../manager/header2.jsp" />
		
        <!-- Content -->
		
		
<div class="maincontainer">
		
<!-- 왼쪽 메뉴 -->
		    <div class="leftside">
		      <div class="adminpage">관리자 페이지</div>
		      <div class="sidemenu">
		        <ul>
		          <li class="sidemenuitems"><a href="<%=request.getContextPath()%>/notice/list.do">공지사항</a></li>
		          <li class="sidemenuitems"><a href="<%=request.getContextPath()%>/boardReport/list.do">신고 게시글 관리</a></li>
		          <li class="sidemenuitems"><a href="<%=request.getContextPath()%>/memReport/list.do">신고 회원 관리</a></li>
		          <li class="sidemenuitems"><a href="/DaangnProject/login/logout.jsp">로그아웃</a></li>
		        </ul>
		      </div>
		    </div>

<!-- 게시판 내용 -->
		    <div class="contents">
		  <section class="notice">
		  <div class="page-title">
		        <div class="container">
		            <h3>공지사항</h3>
		        </div>
		    </div>
		
<!-- board search area -->
		    <div id="board-search">
		        <div class="container">
		            <div class="search-window">
		                <form action="<%=request.getContextPath()%>/notice/search.do">
		                    <div class="search-wrap">
		                        <label for="search" class="blind">공지사항 내용 검색</label>
		                        <input id="search" type="search" name="keyword" placeholder="검색어를 입력해주세요." value="">
		                        <button type="submit" class="btn btn-dark">검색</button>
		                    </div>
		                </form>
		            </div>
		        </div>
		    </div>
		    
		    
<!-- board list area -->
		    <div id="board-list">
		        <div class="container">
		            <table class="board-table">
		                <thead>
		                <tr>
		                    <th scope="col" class="th-num">번호</th>
		                    <th scope="col" class="th-title">제목</th>
		                    <th scope="col" class="th-date">작성자</th>
		                    <th scope="col" class="th-date">작성일</th>
		                </tr>
		                </thead>
		                
		                <tbody>
		                
		                <%
		                
		                int noticeSize = noticeList.size();
		                if (noticeSize > 0) {
		                	for (int i=0; i < noticeSize; i++) {
		           
		                %>
		                
		                
		                <tr>
		                    <td><%=noticeList.get(i).getRnum() %></td>
		                    <td><a href="<%=request.getContextPath() %>/notice/detail.do?noticeId=<%=noticeList.get(i).getNoticeId() %>"><%=noticeList.get(i).getNoticeTitle() %></a></td>
		                    <td>관리자</td>
		                    <td><%=noticeList.get(i).getNoticeDate() %></td>
		                </tr>
		                
		                
		                <% 
		                	}
		                
		                } else {
		                %>	
		                	
		                
		                <%
		                }		                
		                
		                %>
		                
		                
		                </tbody>
		                
		                
		                
		          
		              
		                
		            </table>
		        </div>
		    </div>
		    
<%-- 페이지 영역 시작 --%>
<c:set var="currentPage" value="${requestScope.cPage }"></c:set>
	
	<nav aria-label="Page navigation example">
	  <ul class="pagination justify-content-center">
	
	<%-- prev 버튼 시작--%>  
	  <c:choose>
			<c:when test="${cPage eq '1'}">
			    <li class="page-item disabled">
			      <a class="page-link" href="#" aria-label="Previous" tabindex="-1">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			</c:when>
			<c:otherwise>
			    <li class="page-item">
			      <a class="page-link" href="<%=request.getContextPath()%>/notice/list.do?pageNo=${cPage-1}" aria-label="Previous" tabindex="-1">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			</c:otherwise>		
		</c:choose>
	<%-- prev 버튼 끝--%>  
	  
	  <c:forEach var="i" begin="${requestScope.sPage}" end="${requestScope.ePage}">
	  	<c:if test="${currentPage == i }">
		    <li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/notice/list.do?pageNo=${i}">${i}</a></li>
	  	</c:if>
		<c:if test="${currentPage != i }">
		    <li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/notice/list.do?pageNo=${i}">${i}</a></li>
		
		</c:if>	  
	  </c:forEach>
	    
	  <%-- next 버튼 시작--%>    
	      <c:choose>
			<c:when test="${ttPage eq ePage}">
			    <li class="page-item disabled">
			      <a class="page-link" href="#" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			</c:when>
			<c:otherwise>
			     <li class="page-item">
			      <a class="page-link" href="<%=request.getContextPath()%>/notice/list.do?pageNo=${cPage+1}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			</c:otherwise>		
		</c:choose>
		<%-- next 버튼 끝--%> 	
		
	  </ul>
	</nav>

<%-- 페이지 영역 끝 --%>
		    
			<button class="regBtn" type="button" onclick="location.href='<%=request.getContextPath() %>/notice/insert.do'">공지사항 등록</button>
		</section>
		      
		      
		    </div>
	  </div>
		
		
		
		
		
     
        <!-- Footer-->
        <jsp:include page="../comm/footer.jsp" />

	<!-- JavaScript -->
	<script></script>
    </body>
    
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!-- Head-->
	<jsp:include page="../comm/head.jsp" />
	
	<!-- CSS -->
	<style>


 .maincontainer { 
   display: flex; 
   justify-content: center; 
   padding: 50px; 
 } 

.leftside {
  width: 200px;
  height: 100%vh;
  border: 1px solid black;
  
}

.contents {
  width: 820px;
  height: 100vh;
  border: 1px solid black;
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
		<jsp:include page="header2.jsp" />
		
		
		
		
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
		      <div class="title">
		        <!-- 게시글 -->
		        공지사항
		      </div>
		      
		      
		      
		    </div>
	  </div>
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
<!-- 		<div class="container"> -->
		
<!-- 	        Content -->
<!-- 	        <h4>관리자 페이지</h4> -->
<!-- 	        <hr> -->
<%-- 	        <a href="<%=request.getContextPath()%>/memReport/list.do">신고 회원 관리</a> --%>
<!-- 	        <hr> -->
<%-- 	        <a href="<%=request.getContextPath()%>/boardReport/list.do">신고 게시글 관리</a> --%>
<!-- 	        <hr> -->
<%-- 	        <a href="<%=request.getContextPath()%>/notice/list.do">공지사항</a> --%>
<!-- 	        <hr> -->
<%-- <%-- 	        <a href="<%=request.getContextPath()%>/manager/logout.jsp">로그아웃</a> --%> --%>
<!-- 	        <a href="/DaangnProject/login/logout.jsp">로그아웃</a> -->
		
		
<!-- 		</div> -->
		
        <!-- Footer-->
        <jsp:include page="../comm/footer.jsp" />

	<!-- JavaScript -->
	<script></script>
    </body>
    
</html>
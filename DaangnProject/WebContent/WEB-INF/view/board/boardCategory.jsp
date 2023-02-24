<%@page import="board.service.IBoardService"%>
<%@page import="board.service.BoardServiceImpl"%>
<%@page import="java.util.List"%>
<%@page import="board.vo.BoardVO"%>
<%@page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	
// 	MemberVO mv = (MemberVO)session.getAttribute("memberVO");
	String category = (String)request.getAttribute("category");
	System.out.println(category);
	//카테고리 일치하고 mv 동네도 일치하는
	IBoardService boardService = BoardServiceImpl.getInstance();
	List<BoardVO> boardList = boardService.categoryList(category);
	System.out.println(boardList);
	
	
// 	List<BoardVO> boardList = boardService.selectMemBoard(mv.getMemId());
	//boardList에 대상 아이디값 넣어서 select문
// 	System.out.println("***********");
// 	for(BoardVO bv : boardList){
// 		System.out.println("셀렉트보드정보 : " +bv.getBoardTitle());
//  	}
 
%>

    <!-- Head-->
	<jsp:include page="../comm/head.jsp" />
	
	<!-- CSS -->
	<style>
 	 a:link { color: black; text-decoration: none;} 
	 a:visited { color: black; text-decoration: none;}
 	 a:hover { color: black; text-decoration: underline;} 
	 a:hover { text-decoration:none !important }
	 a { text-decoration:none !important }
	</style>
	
    </head>
	
    <body>
   
        <!-- Navigation-->
		<jsp:include page="../comm/header.jsp" />
		
        <!-- Content -->
		<!-- 카테고리별 매물 Section -->
<section class="py-5 bg-light">
      <div class="container px-4 px-lg-5 mt-5">
      <%
      if(category.equals("C001")){
      %>
          <h2 class="fw-bolder mb-4">디지털기기</h2>
      <%
      } else if(category.equals("C002")) {
      %>
      	  <h2 class="fw-bolder mb-4">생활가전</h2>
      <%
      } else if(category.equals("C003")) {
      %>
      	  <h2 class="fw-bolder mb-4">가구/인테리어</h2>
      <%
      } else if(category.equals("C004")) {
      %>
      	  <h2 class="fw-bolder mb-4">생활/주방</h2>
      <%
      } else if(category.equals("C005")) {
      %>
      	  <h2 class="fw-bolder mb-4">유아용품</h2>
      <%
      } else if(category.equals("C006")) {
      %>
      	  <h2 class="fw-bolder mb-4">의류</h2>
      <%
      } else if(category.equals("C007")) {
      %>
      	  <h2 class="fw-bolder mb-4">패션/잡화</h2>
      <%
      } else if(category.equals("C008")) {
      %>
      	  <h2 class="fw-bolder mb-4">뷰티/미용</h2>
      <%
      } else if(category.equals("C009")) {
      %>
      	  <h2 class="fw-bolder mb-4">취미/게임/음반</h2>
      <%
      } else if(category.equals("C010")) {
      %>
      	  <h2 class="fw-bolder mb-4">도서</h2>
      <%
      } else if(category.equals("C011")) {
      %>
      	  <h2 class="fw-bolder mb-4">반려동물용품</h2>
      <%	  
      } else {
      %>
      	  <h2 class="fw-bolder mb-4">기타 중고물품</h2>
      <%
      }
      %>
          <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
          
          <%
   			for(int i=0; i<boardList.size(); i++){
  		   %>
  		   <a href="/DaangnProject/BoardDetail.do?boardId=<%=(boardList.get(i).getBoardId()) %>">
 
	       <div class="col mb-5">
	           <div class="card">
	               <!-- 상품 image-->
	               <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="...">
	               <!-- 상품 details-->
	               <div class="card-body p-4">
	                   <div class="text-center">
	                       <!-- 상품 Title -->
	                       <h5 class="fw-bolder text-lg-start">
								<%=(boardList.get(i).getBoardTitle()) %>
	                       </h5>
	                       <!-- 상품 price, date-->
	                       <div class="x" style="display:flex; justify-content: space-between;">
	                       	<div class="price">&#8361;<%=(boardList.get(i).getPrice()) %></div>
	                       	<div class="time">1시간 전</div>
	                       </div>
	                   </div>
	               </div>
	           </div>
	       </div>
	     </a>
	      <%
	   	}
	      %>
	        </div>
    </div>
</section>
     
        <!-- Footer-->
        <jsp:include page="../comm/footer.jsp" />

	<!-- JavaScript -->
	<script></script>
    </body>
    
</html>
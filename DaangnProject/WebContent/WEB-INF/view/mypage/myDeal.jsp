<%@page import="board.service.IBoardService"%>
<%@page import="board.service.BoardServiceImpl"%>
<%@page import="member.service.IMemberService"%>
<%@page import="member.service.MemberServiceImpl"%>
<%@page import="java.util.List"%>
<%@page import="board.vo.BoardVO"%>
<%@page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	MemberVO mv = (MemberVO)session.getAttribute("memberVO");
	IBoardService boardService = BoardServiceImpl.getInstance();
	IMemberService memberService = MemberServiceImpl.getInstance();
	
	String thisId;
	if(request.getAttribute("yf")==null){
		thisId = mv.getMemId();
	} else{
		thisId = (String)request.getAttribute("yf");
}
	List<BoardVO> boardList = boardService.selectMemBoard(thisId);
	
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
		<!-- 인기매물 Section -->
<section class="py-5 bg-light">
      <div class="container px-4 px-lg-5 mt-5">
          <h2 class="fw-bolder mb-4"><%=memberService.memberInfo(thisId).getMemNic()%>가 판매중인 상품</h2>
          <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
          
          <%
   			for(int i=0; i<boardList.size(); i++){
 		  %>	
		  		   <a href="/DaangnProject/BoardDetail.do?boardId=<%=(boardList.get(i).getBoardId()) %>">
		 
			       <div class="col mb-5">
			           <div class="card">
			               <!-- 상품 image-->
			               <img class="card-img-top"  src="/DaangnProject/download.do?atchFileId=<%=boardList.get(i).getBoardId()%>" alt="...">
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="member.vo.MemberVO"%>
<%@page import="board.vo.BoardVO"%>
<%@page import="trade.vo.TradeVO"%>
<%@page import="member.service.IMemberService"%>
<%@page import="member.service.MemberServiceImpl"%>
<%@page import="java.util.List"%>
<%
	MemberVO mv = (MemberVO)session.getAttribute("memberVO");
	IMemberService memberService = MemberServiceImpl.getInstance();
	TradeVO tv = new TradeVO();
	tv.setSellerId(mv.getMemId());	
	System.out.println(mv.getMemId());
	List<BoardVO> boardList = (List<BoardVO>)memberService.sellList(tv);
%>

    <!-- Head-->
	<jsp:include page="../comm/head.jsp" />
	
	<!-- CSS -->
	
	<style>
 	 a:link { color: black; text-decoration: none;} 
	 a:visited { color: black; text-decoration: none;}
 	 a:hover { color: black; text-decoration: underline;} 
	 a:hover { text-decoration:none !important }
	 a: { text-decoration:none !important }
	</style>
	
    </head>
	
    <body>
   
        <!-- Navigation-->
		<jsp:include page="../comm/header.jsp" />
		
        <!-- Content -->
		판매목록페이지
		
		<table class="table">
		    <thead class="table-light">
		      <tr>
		        <th scope="col">글번호</th>
		        <th scope="col">제목</th>
		        <th scope="col">가격</th>
		        <th scope="col"></th>
		      </tr>
		    </thead>
		    <tbody>
		    
		    <%
				for(BoardVO bv : boardList) {
			%>
			      <tr>
			        <th scope="row"><%=bv.getBoardId() %></th>
			        <td><a href="/DaangnProject/BoardDetail.do?boardId=<%=bv.getBoardId() %>"><%=bv.getBoardTitle() %></a></td>
			        <td>&#8361;<%=bv.getPrice() %></td>
			        <td> </td>
			      </tr>
			<%
				}
			%>
		    
		    </tbody>
 	 </table>
    <!-- <tbody class="table-group-divider"> -->
	
     
        <!-- Footer-->
        <jsp:include page="../comm/footer.jsp" />

	<!-- JavaScript -->
	<script>


	</script>
    </body>
    
</html>
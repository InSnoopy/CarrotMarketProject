<%@page import="follows.vo.FollowsVO"%>
<%@page import="board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="follows.service.FollowsServiceImpl"%>
<%@page import="follows.service.IFollowsService"%>
<%@page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVO mv2 = (MemberVO)session.getAttribute("memberVO");
	List<BoardVO> boardList = (List<BoardVO>)request.getAttribute("interestList");
%>


<!-- Head-->
	<jsp:include page="../comm/head.jsp" />
	
	<!-- CSS -->
	<style>
	 a:link { color: red; text-decoration: none;}
	 a:visited { color: black; text-decoration: none;}
	 a:hover { color: black; text-decoration: underline;}
	</style>
	
<html>
   <body>
   		<!-- Navigation-->
		<jsp:include page="../comm/header.jsp" />
   
         <h3>나의 찜목록</h3>
         <!-- Content -->
		관심목록 페이지입니다.
		
<%
	if(boardList.size() == 0) {
		System.out.println("관심 내역 존재하지 않음");
	}else {
		for(BoardVO bv : boardList) {
	%>
	<br>
	<%=bv.getBoardId() %>
	<%=bv.getBoardTitle() %>
	&#8361;<%=bv.getPrice() %>
	<%
		}
	}
%>		

<table class="table">
  <thead class="table-light">
    <tr>
      <th scope="col">글번호</th>
      <th scope="col">팔로워 ID</th>
      <th scope="col">가격</th>
      <th scope="col">판매자</th>
    </tr>
  </thead>
  <tbody>
  <!-- <tbody class="table-group-divider"> -->
<%
	for(BoardVO bv : boardList) {
%>
      <tr>
        <th scope="row"><%=bv.getBoardId() %></th>
        <td><a href="/DaangnProject/BoardDetail.do?boardId=<%=bv.getBoardId() %>"><%=bv.getBoardTitle() %></td>
        <td>&#8361;<%=bv.getPrice() %></td>
        <td><%=bv.getMemId() %></td>
      </tr>
<%
	}
%>	
      
  </tbody>
</table>
		
		
		
		
        <!-- Footer-->
        <jsp:include page="../comm/footer.jsp" />
        
   </body>
</html>

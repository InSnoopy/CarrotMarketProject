<%@page import="member.service.MemberServiceImpl"%>
<%@page import="member.service.IMemberService"%>
<%@page import="trade.vo.TradeVO"%>
<%@page import="java.util.List"%>
<%@page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	MemberVO mv = (MemberVO) session.getAttribute("memberVO");
	List<TradeVO> tradeList = (List<TradeVO>) request.getAttribute("tradeList");
%>    

    <!-- Head-->
	<jsp:include page="../comm/head.jsp" />
	
	<!-- CSS -->
	<style></style>
	
    </head>
	
    <body>
   
        <!-- Navigation-->
		<jsp:include page="../comm/header.jsp" />
		
        <!-- Content -->
		구매 내역
		
		<table border="1">
			<tr>구매자</tr>
			<tr>판매자</tr>
			<tr>거래 게시글</tr>
			<tr>거래 날짜</tr>
			<tr>판매자</tr>
			<tr>거래 후기 등록</tr>
		<%
		for(int i=0;  i < tradeList.size(); i++) {
		%>
			<td><%=tradeList.get(i).getBuyerId() %></td>
			<td><%=tradeList.get(i).getSellerId() %></td>
			<td><%=tradeList.get(i).getBoardTitle() %></td>
			<td><%=tradeList.get(i).getTradeDate() %></td>
<%-- 			<td><button onclick="location.href='<%=request.getContextPath()%>/review/insert.do?buyId=<%=tradeList.get(i).getBuyId()%>'">거래후기등록</button></td> --%>
			<td><button onclick="location.href='<%=request.getContextPath()%>/review/insert.do?buyId=<%=tradeList.get(i).getBuyId()%>'">거래후기등록</button></td>
			
		</table>
		<%
		}
		%>
		
		
     
        <!-- Footer-->
        <jsp:include page="../comm/footer.jsp" />

	<!-- JavaScript -->
	<script></script>
    </body>
    
</html>
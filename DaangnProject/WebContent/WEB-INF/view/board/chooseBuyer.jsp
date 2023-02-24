<%@page import="chat.service.IChatRoomService"%>
<%@page import="chat.service.ChatRoomServiceImpl"%>
<%@page import="board.service.IBoardService"%>
<%@page import="board.service.BoardServiceImpl"%>
<%@page import="member.service.IMemberService"%>
<%@page import="member.service.MemberServiceImpl"%>
<%@page import="board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	System.out.println("chooseBuyer.jsp에 왓다");
	MemberVO mv = (MemberVO)session.getAttribute("memberVO");
	BoardVO bv = (BoardVO)request.getAttribute("thisBoard");
	System.out.println(mv.getMemId());
// 	List<BoardVO> memList = (List<BoardVO>) request.getAttribute("boardList");
// 	String boardId = (String)request.getAttribute("boardId");
// 	System.out.println("HI"+boardId);
	
	IMemberService memberService = MemberServiceImpl.getInstance();
// 	MemberVO mmv = memberService.memberInfo(bv.getMemId());
	
	System.out.println("choose 전에 불러온bv : "+bv);
	IChatRoomService chatService = ChatRoomServiceImpl.getInstance();
	List<MemberVO> mv2 = chatService.selectChatMember(bv);
	
	System.out.println("챗 멤버 불러온 List<MemberVO> : " + mv2);
	
	
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
        
        
        <article>
	        <div class="container" role="main">
	        	<h2>거래할 상대를 선택해주세요</h2>
				<form action="/DaangnProject/chooseBuyer.do" enctype="multipart/form-data">
					<input type="hidden" class="form-control" name="boardId" value="<%=bv.getBoardId()%>">
					<input type="hidden" class="form-control" name="price" value="<%=bv.getPrice()%>">
					<div class="mb-3">	
						<label for="">거래 상대</label>
			            <select name="buyer" class="form-control">
							<option>거래 상태 선택</option>
							<%
								for(MemberVO mv3 : mv2){
							%>
		       				<option value=<%=mv3.getMemId()%>><%=memberService.memberInfo(mv3.getMemId()).getMemNic()%></option>
							<%
								}
							%>							
		       			</select>
					</div>
					<button type="submit" class="btn btn-sm btn-primary">선택하기</button>
					
				</form>
			</div>
		</article>

		
        <!-- Footer-->
        <jsp:include page="../comm/footer.jsp" />

	<!-- JavaScript -->
	<script>	
	
	</script>
    </body>
    
</html>

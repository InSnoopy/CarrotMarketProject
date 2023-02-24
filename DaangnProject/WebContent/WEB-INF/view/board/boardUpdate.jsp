<%@page import="board.service.IBoardService"%>
<%@page import="board.service.BoardServiceImpl"%>
<%@page import="board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	MemberVO mv = (MemberVO)session.getAttribute("memberVO");
	System.out.println(mv.getMemId());
	List<BoardVO> memList = (List<BoardVO>) request.getAttribute("boardList");
	String boardId = (String)request.getAttribute("boardId");
	System.out.println("HI"+boardId);
	
	IBoardService boardService = BoardServiceImpl.getInstance();
	BoardVO bv = boardService.selectBoard(boardId);
	
	String value = "";
	
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
	        	<h2>게시글 수정</h2>
				<form id="form" action="/DaangnProject/BoardUpdatePage.do" method="post" enctype="multipart/form-data">
					<div class="mb-3">	
						<label for="">제목</label>
						<input type="text" class="form-control" name="boardTitle" value="<%=bv.getBoardTitle() %>" placeholder="입력">
					</div>
					<div class="mb-3">	
<!-- 						<label for="">boardId</label> -->
						<input type="hidden" class="form-control" name="boardId" value="<%=boardId%>">
					</div>
					<div class="mb-3">	
						<label for="">거래 상태</label>
			            <select name="boardStatus" class="form-control">
<!-- 							<option>거래 상태 선택</option> -->
		       				<option value="0">판매중</option>
		       				<option value="1">판매 완료</option>
		       			</select>
					</div>
					<div class="mb-3">	
<!-- 						<label for="">작성자</label> -->
						<input type="hidden" class="form-control" name="memId" value="<%=mv.getMemId()%>">
					</div>
					<div class="mb-3">	
						<label for="">상품 설명</label>
						<textarea rows="10" class="form-control" name="boardContents"><%=bv.getBoardContents() %></textarea>
					</div>										
					<div class="mb-3">	
						<label for="">가격</label>
						<input type="text" name="price" class="form-control" value="<%=bv.getPrice()%>">
					</div>
					<div class="mb-3">	
						<label for="">상품 사진</label>
						<input type="file" id="fileName" name="atchFile" class="form-control" value="">				
					</div>	
					<div class="mb-3">	
						<input type="text" id="fileValue" name="result" class="fileValue" value="no" hidden>
					</div>				
					
			<div class="mb-5" >
				<button type="button" class="btn btn-sm btn-primary" id="btnSave">수정하기</button>
				<button type="button" class="btn btn-sm btn-primary" id="btnList">취소</button>
			</div>
					
				</form>
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
		location.href="/DaangnProject/Main.do";
	});
	
	
	var v_fn = document.getElementById("fileName");
	var v_fv = document.getElementById("fileValue");
	var result = "";
	v_fn.addEventListener("click", function(){

		if(v_fn.value==""){
			result = "no";
		}else{
			result = "yes";
		}

		v_fv.value=result;

	});



	</script>
    </body>
    
</html>

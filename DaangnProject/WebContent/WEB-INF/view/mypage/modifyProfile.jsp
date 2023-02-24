<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="member.vo.MemberVO"%>
<%
	MemberVO mv = (MemberVO)session.getAttribute("memberVO");
	if(mv==null){
		response.sendRedirect("mypage.jsp");
		System.out.println("modifyProfile.jsp => mv = null");
	} else {
%>

<!-- Head-->
<jsp:include page="../comm/head.jsp" />
<!-- Navigation-->
<jsp:include page="../comm/header.jsp" />	
	
<!-- CSS -->
<style>
.wrapper {
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
	background: white;
}

.content {
	font-family: system-ui, serif;
	font-size: 1.5rem;
	padding: 4rem;
	border-radius: 1rem;
	background: #F8F8F8;
	border: 5px solid #ff7e36;
}

.modifyContainer {
	margin-bottom: 10px;
}

button {
    position: absolute;
    background-color:#ff7e36;
    color: #fff;
    border: none;
    border-radius: 10px;
    padding: 7px
}
button:hover {
    background-color:#ffa64c;
    transition: 1s;
}

label { 
	display:inline-block; width:150px; 
}
	
table {
	width: 500px;
}

th{
	background:#ffa64c;
}

th, td {
    border-bottom: 1px solid white;
    padding: 3px;
    text-align: center;
}

input[type=text] {
	border: 0;
	border-radius: 15px;
	outline: none;
	padding-left: 10px;
	background-color: rgb(233, 233, 233);
}

.filebox input[type=file] {
	position: absolute;
	width: 1px;
	height: 1px;
	padding: 0;
    margin: -1px;
	overflow: hidden;
	clip:rect(0,0,0,0);
	border: 0;
}
.filebox {
	display:inline-block; 
	margin: 10px;
}
.filebox label {
    display: inline-block;
    padding: .3em;
    color: #fff;
    font-size: inherit;
    line-height: normal;
    text-align: center;
    vertical-align: middle;
    background-color: #ffa64c;
    cursor: pointer;
    border: 1px solid #ebebeb;
    border-bottom-color: #e2e2e2;
    border-radius: .25em;
}

</style>
	
</head>
	
<body>
	  
   
			<form class="modifyContainer" action="/DaangnProject/modifyProfile_detail.do" method="get">
	<div class="wrapper">
       	<!-- Content -->
       	<div class="content">
			<h3>회원정보 수정 페이지</h3>
			<hr>
			
		        <div class="input-group">
					<%if(mv.getProfile() == null){ %>
					<img src="assets/basicProfile.png" width="500" height="350"/>
					<% }else{ %>
					<img src="assets/<%=mv.getProfile()%>" width="500" height="350"/>
					<%} %>
		        </div>
		        <div class="filebox">
					<label for="modifyProfile">사진첨부</label>
					<input type="file" name="profile" id="modifyProfile" accept="image/*" 
					value="<%=mv.getProfile()%>">
		        </div>
				<table>	
			        <div>
			        	<tr>
							<th><label>닉네임 :</label></th>
							<td><input type="text" name="memNic" id="modifyMemNic" value="<%=mv.getMemNic()%>"></td>
			        	</tr>
			        </div>
			        <div>
			        	<tr>
							<th><label>이름 :</label></th>
							<td><input type="text" name="memName" id="modifyMemName" value="<%=mv.getMemName()%>"></td>
			        	</tr>
			        </div>
			        <div>
			        	<tr>
							<th><label>전화번호 :</label></th>
							<td><input type="text" name="memTel" id="modifyMemTel" value="<%=mv.getMemTel()%>"></td>
			        	</tr>
			        </div>
			        <div>
			        	<tr>
							<th><label>이메일 :</label></th>
							<td><input type="text" name="memMail" id="modifyMemMail" value="<%=mv.getMemMail()%>"></td>
						</tr>
			        </div>
		        </table>
		        <button id="modify" type="submit" onClick="modifyAlert()"> 
					수정하기
		        </button>
		</div>
	</div>
			</form>
    
    <!-- Footer-->
    <jsp:include page="../comm/footer.jsp" />

<!-- JavaScript -->
<script>
function modifyAlert(){
	alert("수정 완료!");
}


</script>
</body>
    
</html>
<%}%>
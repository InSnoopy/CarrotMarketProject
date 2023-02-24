<%@page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
 	MemberVO mv = (MemberVO)session.getAttribute("memberVO"); 
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
</style>

</head>

<body>

	<div class="wrapper">
	       <!-- Content -->
	     <div class="content">
			<h3>정말 탈퇴 하시겠습니까?</h3>
			<img src="assets/punch.jfif" width="650" height="500"/>
			<hr>
<%-- 			<a href="deleteProfile2.do?memId=<%=mv.getMemId() %>">[회원탈퇴]</a> --%>
			<button type="button" class="navyBtn" 
			onClick="location.href='deleteProfile2.do?memId=<%=mv.getMemId() %>'">
			회원탈퇴
			</button>
		</div>
	</div>
  
  
  
     <!-- Footer-->
    <jsp:include page="../comm/footer.jsp" />

<!-- JavaScript -->
<script></script>
   </body>
    
</html>
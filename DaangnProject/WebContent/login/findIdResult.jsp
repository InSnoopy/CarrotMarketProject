<%@page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	MemberVO mv = (MemberVO)request.getAttribute("mv");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find ID Result</title>
<link rel="icon" type="image/x-icon" href="<%=request.getContextPath() %>/assets/favicon.ico" />

<style>
.wrapper {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background: #ff7e36;
}

.content {
  font-family: system-ui, serif;
  font-size: 2rem;
  padding: 3rem;
  border-radius: 1rem;
  background: white;
}
</style>
</head>
<body>
		<%
			if (mv != null && mv.getMemId() != null) {
		%>

		<div class="wrapper">
			<div class="content">
				<div>
					<h4>회원님의 아이디는</h4>
					<div style="color: blue"><%=mv.getMemId()%></div>
					<h4>입니다</h4>
				</div>
				<div>
					<input type="submit" value="로그인" onclick="location.href='login/signUpIn.html'"/>
				</div>
			</div>
		</div>
		<%
			} else {
		%>
		<div class="wrapper">
			<div class="content">
				<div>
					<h4>등록된 정보가 없습니다</h4>
				</div>
				<div>
					<input type="submit" value="다시 찾기"
						onClick="location.href='login/findId.jsp'" /> 
				</div>
			</div>
		</div>

		<%
			}
		%>
</body>
</html>
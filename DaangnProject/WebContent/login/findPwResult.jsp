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
<title>Find PW Result</title>
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
			if (mv != null && mv.getMemPw() != null) {
		%>

		<div class="wrapper">
			<div class="content">
				<div>
					<h4>회원님의 비밀번호는</h4>
					<div style="color: blue"><%=mv.getMemPw()%></div>
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
						onClick="location.href='login/findPw.jsp'" /> 
				</div>
			</div>
		</div>

		<%
			}
		%>
</body>
</html>
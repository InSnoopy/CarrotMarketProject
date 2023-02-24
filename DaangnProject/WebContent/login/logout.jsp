<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	session.invalidate();

	if (request.isRequestedSessionIdValid() == true) {
	    System.out.print("세션 유효");
	}
	else {
	    System.out.print("로그아웃 됨");
	}
%>
<!DOCTYPE html>
<html>
<body>
</body>
<script>
	location.href = "./signUpIn.html";
</script>
</html>
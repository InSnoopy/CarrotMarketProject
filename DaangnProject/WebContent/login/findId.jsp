<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find Id page</title>
<link rel="icon" type="image/x-icon"
	href="<%=request.getContextPath()%>/assets/favicon.ico" />
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

input[type=text] {
	font-size: 20px;
	border: 0;
	border-radius: 15px;
	outline: none;
	padding-left: 10px;
	background-color: rgb(233, 233, 233);
}
</style>
</head>
<body>
	<form method="POST" action="/DaangnProject/findId.do"
		class="wrapper">
		<div class="content">
			<div>
				<h3>휴대폰 본인확인</h3>
			</div>
			<section>
				<div>
					<label>이름</label> <input type="text" name="memName"
						placeholder="등록한 이름"> <br>
				</div>
				<div>
					<label>번호</label> <input type="text" name="memTel"
						placeholder="010-0000-0000">
				</div>
				<br>
			</section>
			<div>
				<input type="submit" name="enter" value="찾기"> <input
					type="button" name="cancle" value="취소"
					onClick="location.href='signUpIn.html'">
			</div>
		</div>
	</form>
</body>
</html>


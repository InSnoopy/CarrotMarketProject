<%@page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	MemberVO mv = (MemberVO)session.getAttribute("memberVO");
%>

<html>

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

.profile{
	margin-bottom: 10px;
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

.listContainer{  
  padding: 0;
  background-color: #ffffff;
  margin-bottom: 10px;
}

.listContainer .item{  
  display: flex;
  align-items: center;
  padding: 16px;
  color: black;
  text-decoration: none;  
  height: 56px;
  box-sizing: border-box;
}
.listContainer .icon{  
  margin-right: 14px;
}
.listContainer .text{
  font-size: 16px;
  position: relative;
}
.listContainer .right{
  margin-left: auto;
}

a:link {
	color: black;
	text-decoration: none;
}

a:visited {
	color: black;
	text-decoration: none;
}

a:hover {
	color: black;
	text-decoration: underline;
}
/* 	 a:hover { text-decoration:none !important } */
/* 	 a { text-decoration:none !important } */
</style>
</head>

<body>
	<div class="wrapper">
		<!-- Content -->
		<div class="content">
			<h3>마이페이지</h3>
			<hr>
			<div class="profile">
				<%
					if (mv.getProfile() == null) {
				%>
				<img src="assets/basicProfile.png" width="500" height="350" />
				<%
					} else {
				%>
				<img src="assets/<%=mv.getProfile()%>" width="500" height="350" />
				<%
					}
				%>
				<table>
					<tr>
						<th>I D:</th>
						<td><%=mv.getMemId()%></td>
					</tr>
					<tr>
						<th>이름:</th>
						<td><%=mv.getMemName()%></td>
					</tr>
					<tr>
						<th>닉네임:</th>
						<td><%=mv.getMemNic()%></td>
					</tr>
					<tr>
						<th>전화번호:</th>
						<td><%=mv.getMemTel()%></td>
					</tr>
					<tr>
						<th>이메일:</th>
						<td><%=mv.getMemMail()%></td>
					</tr>
					<tr>
						<th>주소:</th>
						<td><%=mv.getMemAddr1()%></td>
					</tr>
					<tr>
						<th>매너온도:</th>
						<td><%=mv.getMannersTempNow()%></td>
					</tr>
				</table>
			</div>

			<div class="listContainer">
				<a href="/DaangnProject/modifyProfile.do" class="item">
					<div class="icon">ii</div>
					<div class="text">
						회원 정보 수정<span class="circle"></span>
					</div>
					<div class="right">></div>
				</a>
				<a href="/DaangnProject/followingList.do" class="item">
					<div class="icon">ii</div>
					<div class="text">팔로잉목록</div>
					<div class="right">></div>
				</a> 
				<a href="/DaangnProject/followerList.do" class="item">
					<div class="icon">ii</div>
					<div class="text">팔로워목록</div>
					<div class="right">></div>
				</a> 
				<a href="/DaangnProject/interestList.do" class="item">
					<div class="icon">ii</div>
					<div class="text">찜목록</div>
					<div class="right">></div>
				</a> 
				<a href="/DaangnProject/myDeal.do" class="item">
					<div class="icon">ii</div>
					<div class="text">내가 판매중인 상품</div>
					<div class="right">></div>
				</a> 
				<a href="/DaangnProject/sellList.do" class="item">
					<div class="icon">ii</div>
					<div class="text">판매 내역</div>
					<div class="right">></div>
				</a>
				<a href="/DaangnProject/buyList.do" class="item">
					<div class="icon">ii</div>
					<div class="text">구매 내역</div>
					<div class="right">></div>
				</a>
				<a href="/DaangnProject/cutOffList.do" class="item">
					<div class="icon">ii</div>
					<div class="text">차단 사용자</div>
					<div class="right">></div>
				</a>
				<a href="/DaangnProject/notice/list2.do" class="item">
					<div class="icon">ii</div>
					<div class="text">공지사항</div>
					<div class="right">></div>
				</a>
				<a href="/DaangnProject/login/logout.jsp" class="item">
					<div class="icon">ii</div>
					<div class="text">로그아웃</div>
					<div class="right">></div>
				</a>
				<a href="/DaangnProject/deleteProfile.do" class="item">
					<div class="icon">ii</div>
					<div class="text">탈퇴</div>
					<div class="right">></div>
				</a>
			</div>
		</div>
	</div>
        
   </body>
</html>

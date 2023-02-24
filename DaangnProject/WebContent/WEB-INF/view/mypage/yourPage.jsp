<%@page import="cutOff.service.CutOffServiceImpl"%>
<%@page import="cutOff.service.ICutOffService"%>
<%@page import="cutOff.vo.CutOffVO"%>
<%@page import="member.service.IMemberService"%>
<%@page import="member.service.MemberServiceImpl"%>
<%@page import="follows.vo.FollowsVO"%>
<%@page import="java.util.List"%>
<%@page import="follows.service.FollowsServiceImpl"%>
<%@page import="follows.service.IFollowsService"%>
<%@page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	MemberVO mv = (MemberVO)request.getAttribute("boardMemberVo");
	IFollowsService fs = FollowsServiceImpl.getInstance();
	MemberVO mv2 = (MemberVO)session.getAttribute("memberVO");
	
	List<FollowsVO> fsList = fs.followerList(mv.getMemId());
	
	//차단
	ICutOffService cos = CutOffServiceImpl.getInstance();
// 	MemberVO mv3 = (MemberVO)session.getAttribute("MemberVO");
	
// 	List<CutOffVO> coList = cos.cutOffList(mv.getMemId());
%>

<!-- Head-->
	<jsp:include page="../comm/head.jsp" />
	
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

a:link { color: black; text-decoration: none;}  
a:visited { color: black; text-decoration: none;} 
a:hover { color: black; text-decoration: underline;} 
/* 	 a:hover { text-decoration:none !important } */
/* 	 a { text-decoration:none !important } */
</style>
	
<html>
<body>
	<!-- Navigation-->
	<jsp:include page="../comm/header.jsp" />
	
	<div class="wrapper">
    	<!-- Content -->
		<div class="content">
        	<h3>${boardMemberVo.memNic }의 프로필</h3>
			<hr>
<%-- 		${boardMemberVo.memNic }의 페이지입니다. --%>
			<div class="profile">
				<%if(mv.getProfile() == null){ %>
					<img src="assets/basicProfile.png" width="500" height="350"/>
				<%}else{ %>
					<img src="assets/<%=mv.getProfile()%>" width="500" height="350"/>
				<%} %>	
				<table>
					<tr>
						<th>I D:</th>
						<td>${boardMemberVo.memId}</td>
					</tr>
					<tr>
						<th>이름:</th>
						<td>${boardMemberVo.memName}</td>
					</tr>
					<tr>
						<th>닉네임:</th>
						<td>${boardMemberVo.memNic}</td>
					</tr>
					<tr>
						<th>전화번호:</th>
						<td>${boardMemberVo.memTel}</td>
					</tr>
					<tr>
						<th>이메일:</th>
						<td>${boardMemberVo.memMail}</td>
					</tr>
					<tr>
						<th>주소:</th>
						<td>${boardMemberVo.memAddr1}</td>
					</tr>
					<tr>
						<th>매너온도:</th>
						<td>${boardMemberVo.mannersTempNow}</td>
					</tr>
				</table>
			</div>
    
    		<div class="listContainer">
				<%
				String msg = "";
				for (int i = 0; i < fsList.size(); i++) {
					System.out.println("follower : " + fsList.get(i).getFollower());
					System.out.println("mv2 : " + mv2.getMemId());
			
					if (fsList.get(i).getFollower().equals(mv2.getMemId())) {
						msg = "hi";
					}
				}
			
				if (msg.equals("hi")) {
				%>
			
				<a href="/DaangnProject/cancelFollows.do?following=${boardMemberVo.memId}" class="item">
					<div class="icon">ii</div>
					<div class="text">
						팔로우취소<span class="circle"></span>
					</div>
					<div class="right">></div>
				</a>
				<%
				} else {
				%>
				
				<a href="/DaangnProject/follows.do?following=${boardMemberVo.memId}" class="item">
					<div class="icon">ii</div>
					<div class="text">
						팔로우하기<span class="circle"></span>
					</div>
					<div class="right">></div>
				</a>
				<%
				}
				%>
				<a href="/DaangnProject/followingList.do?yf=${boardMemberVo.memId}" class="item">
					<div class="icon">ii</div>
					<div class="text">
					팔로잉목록<span class="circle"></span>
					</div>
					<div class="right">></div>
				</a>
				<a href="/DaangnProject/followerList.do?yf=${boardMemberVo.memId}" class="item">
					<div class="icon">ii</div>
					<div class="text">
					팔로워목록<span class="circle"></span>
					</div>
					<div class="right">></div>
				</a>
				<a href="/DaangnProject/myDeal.do?yf=${boardMemberVo.memId}" class="item">
					<div class="icon">ii</div>
					<div class="text">
					${boardMemberVo.memNic}의 거래<span class="circle"></span>
					</div>
					<div class="right">></div>
				</a>
				<a href="/DaangnProject/reviewList.do?memId=<%=mv.getMemId() %>" class="item">
					<div class="icon">ii</div>
					<div class="text">
					거래 후기 전체<span class="circle"></span>
					</div>
					<div class="right">></div>
				</a>
	        </div>
		   
		   
		   
   
   <!-- 차단하기 -->
<%
// 			String msg2 = "";
// 		for (int i = 0; i < fsList.size(); i++) {
// 			System.out.println("getMemId1 : " + coList.get(i).getMemId1());
// 			System.out.println("mv2 : " + mv2.getMemId());

// 			if (coList.get(i).getMemId1().equals(mv2.getMemId())) {
// 				msg = "go";
// 			}
// 		}

// 		if (msg.equals("go")) {
		%>
			<div class="listContainer">
				<a href="/DaangnProject/cancelFollows.do?cutoff=${boardMemberVo.memId}" class="item">
					<div class="icon">ii</div>
					<div class="text">
					차단취소<span class="circle"></span>
					</div>
					<div class="right">></div>
				</a>
				<%
				// 			} else {
						%>
				
				<a href="/DaangnProject/follows.do?cutoff=${boardMemberVo.memId}" class="item">
					<div class="icon">ii</div>
					<div class="text">
					차단하기<span class="circle"></span>
					</div>
					<div class="right">></div>
				</a>
				<%
				// 			}
						%>
				<a href="/DaangnProject/cutOffList.do?yf=${boardMemberVo.memId}" class="item">
					<div class="icon">ii</div>
					<div class="text">
					차단목록<span class="circle"></span>
					</div>
					<div class="right">></div>
				</a>
		    </div>
   
		</div>
	</div>
	<!-- Footer-->
	<jsp:include page="../comm/footer.jsp" />
     
</body>
</html>

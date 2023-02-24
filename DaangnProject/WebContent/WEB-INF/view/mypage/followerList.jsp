<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="follows.vo.FollowsVO"%>
<%@page import="member.vo.MemberVO"%>
<%@page import="java.util.List" %>
<%
	List<MemberVO> fv = (List<MemberVO>)request.getAttribute("followerList");
%>
    <!-- Head-->
	<jsp:include page="../comm/head.jsp" />
	
	<!-- CSS -->
	<style>
	 a:link { color: red; text-decoration: none;}
	 a:visited { color: black; text-decoration: none;}
	 a:hover { color: black; text-decoration: underline;}
	</style>
	
    </head>
	
    <body>
   
        <!-- Navigation-->
		<jsp:include page="../comm/header.jsp" />
		
        <!-- Content -->
		팔로워 리스트<br>
<%
	if(fv.size() == 0) {
		System.out.println("팔로워 존재하지 않음");
	}else {
		for(MemberVO fvv : fv) {
	%>
	<%=fvv.getMemNic() %>
	<%
		}
	}
%>


  <table class="table">
    <thead class="table-light">
      <tr>
        <th scope="col">#</th>
        <th scope="col">팔로워 ID</th>
        <th scope="col">Last</th>
        <th scope="col">Handle</th>
      </tr>
    </thead>
    <tbody>
    <!-- <tbody class="table-group-divider"> -->
<%
	for(MemberVO fvv : fv) {
%>
      <tr>
        <th scope="row">1</th>
<%--         <td><%=fvv.getFollower() %></td> --%>
        <td><a href="/DaangnProject/yourPage.do?name=<%=fvv.getMemId() %>"><%=fvv.getMemNic() %></a></td>
        <td>Otto</td>
        <td>@mdo</td>
      </tr>
<%
	}
%>	
      
    </tbody>
  </table>
     
        <!-- Footer-->
        <jsp:include page="../comm/footer.jsp" />

	<!-- JavaScript -->
	<script></script>
    </body>
    
</html>


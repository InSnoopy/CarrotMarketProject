<%@page import="member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<MemberVO> com = (List<MemberVO>)request.getAttribute("cutOffList");
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
		차단 리스트<br>
     
   <%

	if(com.size() == 0) {
		System.out.println("팔로잉 존재하지 않음");
	}else {
		for(MemberVO comm : com) {
	%>
	<%=comm.getMemNic() %>
	<%
		}
	}
%>

<table class="table">
    <thead class="table-light">
      <tr>
        <th scope="col">#</th>
        <th scope="col">차단회원ID</th>
        <th scope="col">Last</th>
        <th scope="col">Handle</th>
      </tr>
    </thead>
    <tbody>
    <!-- <tbody class="table-group-divider"> -->
<%
	for(MemberVO comm : com) {
%>
      <tr>
        <th scope="row">1</th>
        <td><a href="/DaangnProject/yourPage.do?name=<%=comm.getMemId() %>"><%=comm.getMemNic() %></a></td>
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
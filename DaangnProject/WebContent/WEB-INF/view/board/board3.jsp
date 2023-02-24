<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">


    <head>
    
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Home</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Comm Css -->
<%-- 		<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/css/styles.css" /> --%>
<%-- 	    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css" /> --%>
<%-- 	    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/LineIcons.3.0.css" /> --%>
<%-- 	    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/tiny-slider.css" /> --%>
<%-- 	    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/glightbox.min.css" /> --%>
<%-- 	    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css" /> --%>
        <!-- Main Css -->
	    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>./../../css/main/LineIcons.3.0.css" />
	    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>./../../css/main/style.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>./../../css/main/style2.css" />
	    <!-- Content Css -->  
	    
	    <!-- JavaScript -->
    	<script src="https://kit.fontawesome.com/4cb0ee119e.js" crossorigin="anonymous"></script>  
    	
    	<title>중고거래 글쓰기</title>
    </head>
    
    <style>
	  body {
	    padding-top: 70px;
	    padding-bottom: 30px;
	  }
	
	  .content {
	    padding-top: 50px;
	  }
	
	  .mb-3 {
	    padding: 10px 0;
	  }
  </style>
    
    <body>

   
        <!-- Navigation-->
		<jsp:include page="../comm/header.jsp" />
		
		
		
        <!-- Content -->
		<jsp:include page="./boardContent.jsp" />
     	
   
     
        <!-- Footer-->
        <jsp:include page="../comm/footer.jsp" />

        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="./js/scripts.js"></script>
        
    </body>
    
    <script>

	    $(document).on('click', '#btnSave', function(e){
	      e.preventDefault();
	      $("#form").submit();
	      location.href="${pageContext.request.contextPath}/board/getBoardList";
	    });
	  
	    $(document).on('click', '#btnCancel', function(e){
	      e.preventDefault();
	    });
	  
  </script>
    
</html>

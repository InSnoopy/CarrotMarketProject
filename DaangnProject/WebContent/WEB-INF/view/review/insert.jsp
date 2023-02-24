<%@page import="trade.vo.TradeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	TradeVO tv = (TradeVO) request.getAttribute("tv");
%>    

    <!-- Head-->
	<jsp:include page="../comm/head.jsp" />
	
	<!-- CSS -->
	<style>
	 #myform fieldset {
        display: inline-block;
        direction: rtl;
        border: 0;
      }
      #myform fieldset legend {
        text-align: right;
      }
      #myform input[type="radio"] {
        display: none;
      }
      #myform label {
        font-size: 3em;
        color: transparent;
        text-shadow: 0 0 0 #f0f0f0;
      }
      #myform label:hover {
        text-shadow: 0 0 0 #ff7e36;
      }
      #myform label:hover ~ label {
        text-shadow: 0 0 0 #ff7e36;
      }
      #myform input[type="radio"]:checked ~ label {
        text-shadow: 0 0 0 #ff7e36;
      }
      #reviewContents {
        width: 100%;
        height: 150px;
        padding: 10px;
        box-sizing: border-box;
        border: solid 1.5px #d3d3d3;
        border-radius: 5px;
        font-size: 16px;
        resize: none;
      }
	</style>
	
    </head>
	
    <body>
   
        <!-- Navigation-->
		<jsp:include page="../comm/header.jsp" />
		
        <!-- Content -->
		리뷰 입력 페이지
		 <form class="mb-3" name="myform" id="myform" method="post" action="<%=request.getContextPath() %>/review/insert.do">
      <fieldset>
        <span class="text-bold">별점을 선택해주세요</span>
        <input type="radio" name="reviewStar" value="5" id="rate1" /><label
          for="rate1"
          ><i class="fa-solid fa-carrot"></i></label
        >
        <input type="radio" name="reviewStar" value="4" id="rate2" /><label
          for="rate2"
          ><i class="fa-solid fa-carrot"></i></label
        >
        <input type="radio" name="reviewStar" value="3" id="rate3" /><label
          for="rate3"
          ><i class="fa-solid fa-carrot"></i></label
        >
        <input type="radio" name="reviewStar" value="2" id="rate4" /><label
          for="rate4"
          ><i class="fa-solid fa-carrot"></i></label
        >
        <input type="radio" name="reviewStar" value="1" id="rate5" /><label
          for="rate5"
          ><i class="fa-solid fa-carrot"></i></label
        >
      </fieldset>
      <div>
        <textarea
          class="col-auto form-control"
          type="text"
          name="reviewContents"
          placeholder="거래 후기를 남겨주세요"
        ></textarea>
      </div>
      <button type="submit">등록</button>
      <input type="hidden" name="buyerId" value="<%=tv.getBuyerId()%>">
      <p><%=tv.getBuyerId() %></p>
      <p><%=tv.getBuyId() %></p>
      <input type="hidden" name="buyId" value="<%=tv.getBuyId()%>">
      
      
    </form>
     
        <!-- Footer-->
        <jsp:include page="../comm/footer.jsp" />

	<!-- JavaScript -->
	<script></script>
    </body>
    
</html>
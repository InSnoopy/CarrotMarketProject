<%@page import="board.service.IBoardService"%>
<%@page import="board.service.BoardServiceImpl"%>
<%@page import="java.util.List"%>
<%@page import="board.vo.BoardVO"%>
<%@page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    
<%
	MemberVO mv = (MemberVO)session.getAttribute("memberVO");
	IBoardService boardService = BoardServiceImpl.getInstance();
	List<BoardVO> boardList = boardService.selectAllBoard();
	
	List<BoardVO> b1 = (List<BoardVO>)request.getAttribute("bl");

%>
    <style>
 	 a:link { color: black; text-decoration: none;} 
	 a:visited { color: black; text-decoration: none;}
 	 a:hover { color: black; text-decoration: underline;} 
	 a:hover { text-decoration:none !important }
	 a { text-decoration:none !important }
	</style>

    <!-- 인기매물 Section -->
    <jsp:include page="carouselTest.jsp" />
    
	<section class="py-5 bg-light">
            <div class="container px-4 px-lg-5 mt-5">
                <h2 class="fw-bolder mb-4">인기 매물</h2>
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                
                <%
                	for(int i=0; i<4; i++){
                %>
		               	<a href="/DaangnProject/BoardDetail.do?boardId=<%=(boardList.get(i).getBoardId()) %>">
		              
		                    <div class="col mb-5">
		                        <div class="card">
		                            <!-- 상품 image-->
		                            <%
		                            	if(boardList.get(i).getFileStreCours() == null){
		                           	%>
		                  			<div class="card-img-top" style="overflow:hidden; height:12rem;">
										<img class="card-img-top" src="https://dummyimage.com/450x380/dee2e6/6c757d.jpg" alt="...">
		                            </div>
		                            <%
		                            }else{
		                            %>
									<div class="card-img-top" style="overflow:hidden; height:12rem;">
		                           		<img class="card-img-top"  src="/DaangnProject/download.do?atchFileId=<%=boardList.get(i).getBoardId()%>" alt="...">
									</div>
									<%
		                            }
									%> 
		                            <!-- 상품 details-->
		                            <div class="card-body p-4">
		                                <div class="text-center">
		                                    <!-- 상품 Title -->
		                                    <h5 class="fw-bolder text-lg-start">
											<%=(boardList.get(i).getBoardTitle()) %>
		                                    </h5>
		                                    <!-- 상품 price, date-->
		                                    <div class="x" style="display:flex; justify-content: space-between;">
		                                    	<div class="price"><%=(boardList.get(i).getPrice()) %>원</div>
												<div class="date"></div>
<%-- 		                                    	<fmt:formatDate value="<%=(boardList.get(i).getRegiTime()) %>" pattern="yyyy-MM-dd HH:ss"/>  --%>
		                                    </div>
		                                </div>
		                            </div>
		                        </div>
		                    </div>
		                  </a>
                   <%
                	}
                   %>



                </div>
            </div>
        </section>


    <!-- 내 동네 매물 Section -->

        
        
        	<section class="py-5 bg-light">
            <div class="container px-4 px-lg-5 mt-5">
                <h2 class="fw-bolder mb-4">우리동네 매물</h2>
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-left">
                
                <%
                	for(int i=0; i<b1.size(); i++){
                %>
                		
		               	<a href="/DaangnProject/BoardDetail.do?boardId=<%=(b1.get(i).getBoardId()) %>">
		              
		                    <div class="col mb-5">
		                        <div class="card">
		                            <!-- 상품 image-->
		                            <%
		                            	if(b1.get(i).getFileStreCours() == null){
		                           	%>
		                  			<div class="card-img-top" style="overflow:hidden; height:12rem;">
										<img class="card-img-top" src="https://dummyimage.com/450x380/dee2e6/6c757d.jpg" alt="...">
		                            </div>
		                            <%
		                            }else{
		                            %>
									<div class="card-img-top" style="overflow:hidden; height:12rem;">
		                           		<img class="card-img-top"  src="/DaangnProject/download.do?atchFileId=<%=b1.get(i).getBoardId()%>" alt="...">
									</div>
									<%
		                            }
									%> 
		                            <!-- 상품 details-->
		                            <div class="card-body p-4">
		                                <div class="text-center">
		                                    <!-- 상품 Title -->
		                                    <h5 class="fw-bolder text-lg-start" style="white-space: nowrap; text-overflow: ellipsis; overflow: hidden;">
											<%=(b1.get(i).getBoardTitle()) %>
		                                    </h5>
		                                    <!-- 상품 price, date-->
		                                    <div class="x" style="display:flex; justify-content: space-between;">
		                                    	<div class="price">&#8361;<%=(b1.get(i).getPrice()) %></div>
		                                    	<div class="date"></div>
		                                    </div>
		                                </div>
		                            </div>
		                        </div>
		                    </div>
		                  </a>


                   <%
                	}
                   %>

                </div>
            </div>
           
        </section>
        
          
        
        
        
            <%-- 페이지 영역 --%>
            <nav aria-label="Page navigation example">
               <c:set var="currentPage" value="${requestScope.cPage}" />
               <ul class="pagination justify-content-center" style="margin:20px 0">
                  <li class="page-item"><a id="prev" class="page-link" href="#"
                     aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
                  </a></li>
                  <c:forEach var="i" begin="${requestScope.sPage}"
                     end="${requestScope.ePage}">
                     <c:if test="${currentPage == i}">
                        <li class="page-link"><a class="paging" class="page-link" href="#">${i}</a></li>
                     </c:if>
                     <c:if test="${currentPage != i}">
                        <li class="page-link"><a class="paging" class="page-link" href="#">${i}</a></li>
                     </c:if>
                  </c:forEach>
                  <li class="page-item"><a id="next" class="page-link" href="#"
                     aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                  </a></li>
               </ul>
            </nav>
    
    
    
        
        
        <script>
        
  		


        // 페이지번호 클릭이벤트
        $(".paging").on('click',function(){
        	location.href="/DaangnProject/Main.do?pageNo=" + $(this).text(); 
        });

        let currentPage;
        // 이전버튼 클릭이벤트
        $(".prev").on('click',function(){
        	if( ${currentPage} == 1 ){
        		currentPage = ${currentPage};
        	}else{
        		currentPage = ${currentPage} - 1;	
        	}
        	location.href="/DaangnProject/Main.do?pageNo=" + currentPage;
        });

        // 다음버튼 클릭이벤트
        $(".next").on('click',function(){
        	if( ${currentPage} == ${requestScope.ttPage} ){
        		currentPage = ${currentPage};
        	}else{
        		currentPage = ${currentPage} + 1;	
        	}
        	location.href="/DaangnProject/Main.do?pageNo=" + currentPage;
        });
        
        
        function elapsedTime(date) {
        	  const start = new Date(date);
        	  const end = new Date(); // 현재 날짜
        	  
        	  const diff = (end - start); // 경과 시간
        	 
        	  const times = [
        	    {time: "분", milliSeconds: 1000 * 60},
        	    {time: "시간", milliSeconds: 1000 * 60 * 60},
        	    {time: "일", milliSeconds: 1000 * 60 * 60 * 24},
        	    {time: "개월", milliSeconds: 1000 * 60 * 60 * 24 * 30},
        	    {time: "년", milliSeconds: 1000 * 60 * 60 * 24 * 365},
        	  ].reverse();
        	  
        	  // 아래 코드를 위해서는 (년 ~ 분) 순서여야함

        	  // 년 단위부터 알맞는 단위 찾기
        	  for (const value of times) {
        	    const betweenTime = Math.floor(diff / value.milliSeconds);
        			
        	    // 큰 단위는 0보다 작은 소수 단위 나옴
        	    if (betweenTime > 0) {
        	      return `${betweenTime}${value.time} 전`;
        	    }
        	  }
        	  
        	  // 모든 단위가 맞지 않을 시
        	  return "방금 전";
        }
        

		var x = document.getElementsByClassName("date");
        console.log(elapsedTime("2022/11/16"));
// 		for(var j =0; j<x.length; j++){

// 			x[j].innerHTML = elapsedTime("2022/11/18");
// 		}
        
        
        </script>
        
        
        
        
        
        
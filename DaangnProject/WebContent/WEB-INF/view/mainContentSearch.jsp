<%@page import="board.service.IBoardService"%>
<%@page import="board.service.BoardServiceImpl"%>
<%@page import="java.util.List"%>
<%@page import="board.vo.BoardVO"%>
<%@page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	MemberVO mv = (MemberVO)session.getAttribute("memberVO");
	IBoardService boardService = BoardServiceImpl.getInstance();
	List<BoardVO> boardList = (List<BoardVO>)request.getAttribute("searchBoard");
	String keyword = (String)request.getAttribute("searchKeyword");

%>
    
    <!-- 인기매물 Section -->
	<section class="py-5 bg-light">
            <div class="container px-4 px-lg-5 mt-5">
                <h2 class="fw-bolder mb-4">[ <%=keyword %> ] 검색 결과</h2>
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-left">
                
                <%
                	for(int i=0; i<boardList.size(); i++){
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
		                                    	<div class="price"><%=(boardList.get(i).getPrice()) %></div>
		                                    	<div class="time">1시간 전</div>
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
        
        <script></script>
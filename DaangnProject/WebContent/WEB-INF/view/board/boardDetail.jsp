<%@page import="member.service.MemberServiceImpl"%>
<%@page import="board.service.BoardServiceImpl"%>
<%@page import="board.service.IBoardService"%>
<%@page import="interest.service.InterestServiceImpl"%>
<%@page import="interest.service.iInterestService"%>
<%@page import="member.service.MemberServiceImpl"%>
<%@page import="member.service.IMemberService"%>
<%@page import="board.vo.BoardVO"%>
<%@page import="interest.vo.InterestVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="member.vo.MemberVO"%>
<%
	
	MemberVO mv = (MemberVO)session.getAttribute("memberVO");
	IBoardService boardService = BoardServiceImpl.getInstance();
	iInterestService interestService = InterestServiceImpl.getInstance();
	IMemberService memberService = MemberServiceImpl.getInstance();
			
	List<BoardVO> boardList = boardService.selectAllBoard();
	List<BoardVO> boardMemList = (List<BoardVO>)request.getAttribute("boardMemList");
	
	
	
	BoardVO bv = (BoardVO)request.getAttribute("boardVO");
	
	MemberVO mv2 = memberService.memberInfo(bv.getMemId());
	mv2.getMemNic();

	
	List<BoardVO> memIdBoardList = boardService.selectMemBoard(bv.getMemId());
	
	String srcLink = "/DaangnProject/download.do?atchFileId="+bv.getFileStreCours()+ "&fileSn=" + bv.getFileSn();
	
// 	System.out.println(srcLink);	

	InterestVO iv = new InterestVO();
	iv.setBoardId(bv.getBoardId());
	iv.setMemId(mv.getMemId());

	int cnt = interestService.selectOneInter(iv);
	System.out.print("cnt: " + cnt);
	
%>


 
    <!-- Head-->
	<jsp:include page="../comm/head.jsp" />
	
	<!-- CSS -->
 	<style>
 	 a:link { color: black; text-decoration: none;} 
	 a:visited { color: black; text-decoration: none;}
 	 a:hover { color: black; text-decoration: underline;} 
	 a:hover { text-decoration:none !important }
	 a { text-decoration:none !important }
	.map_wrap {position:relative;width:100%;height:350px;}
	.title {font-weight:bold;display:block;}
	.hAddr {position:absolute;left:10px;top:10px;border-radius: 2px;background:#fff;background:rgba(255,255,255,0.8);z-index:1;padding:5px;}
	#centerAddr {display:block;margin-top:2px;font-weight: normal;}
	.bAddr {padding:5px;text-overflow: ellipsis;overflow: hidden;white-space: nowrap;}
	</style>
	
    </head>
	
    <body>
        <!-- Navigation-->
		<jsp:include page="../comm/header.jsp" />
		
        <!-- Content -->

	<section class="py-5 ">
		<div class="container px-4 px-lg-5 my-5">



			<div class="row gx-4 gx-lg-5">
				<!--                     <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="https://dummyimage.com/600x700/dee2e6/6c757d.jpg" alt="..."></div> -->
				<div class="col-md-4">
					<img class="card-img-top mb-5 mb-md-0"
						src="/DaangnProject/download.do?atchFileId=<%=bv.getBoardId()%>">
				</div>

				<div class="col-md-8 d-flex flex-column">
					<div class="col-sm-12 border-bottom h-25 pb-3">
						<!-- 게시글 정보 -->
						<!-- 게시판 아이디 -->
						<%-- 							<div class="small mb-1"><%=(bv.getBoardId())%></div> --%>
						<!-- 게시글 제목 -->
						<div class="col-sm-12 d-flex justify-content-between">
							<h1 class="h4"><%=(bv.getBoardTitle())%></h1>


							<div>
								<%
									if (mv.getMemId().equals(bv.getMemId()) || mv.getMemId().equals("admin")) {
								%>


								<a
									href="/DaangnProject/BoardUpdatePage.do?boardId=<%=bv.getBoardId()%>">
									<button type="button" class="btn btn-primary disabled">수정하기</button>
								</a> <a
									href="/DaangnProject/BoardDelete?boardId=<%=bv.getBoardId()%>">
									<button type="button" class="btn btn-primary disabled">삭제하기</button>
								</a>
								<%
									}
								%>
							</div>
						</div>
						<div class="col-sm-12">
							<!-- 상품 가격 -->
							<span class="h1"><%=bv.getPrice()%></span><span class="h3">원</span>
						</div>
					</div>
					
					
					<!-- 상품 내용 -->
					<div class="col-sm-12 h-50">
						<!-- 판매자 닉네임 -->
						<div class="d-flex pt-3  border-bottom">
			
								<div class="d-inline-block align-middle">
									<div class="d-inline-block w-90">
										<h6><a href="/DaangnProject/yourPage.do?name=<%=bv.getMemId()%>">판매자 : <%=mv2.getMemNic()%></a></h6>
										<p class="text-muted m-b-0"><%=mv2.getMemAddr1() %></p>
									</div>
								</div>
								
	
						</div>
						<div class="d-flex pt-3  border-bottom">
							<p class="lead"><%=bv.getBoardContents()%></p>

						</div>


					</div>



					<!-- 버튼 -->
					<div class="col-sm-12 h-25">


						<div
							class="d-flex flex-row justify-content-between h-100 text-center ">




							<%
								if (bv.getBoardStatus() == 0) {
							%>

							<div class="item w-25 align-self-center h-100">
								<button
									class="btn btn-lg btn-primary item w-100 align-self-center h-100" style="background-color:#ff7e36; border:1px solid #ff7e36;
									type="button">판매중</button>
							</div>
							<%
								}
							%>
							<%
								if (bv.getBoardStatus() == 1) {
							%>

							<div class="item w-25 align-self-center h-100">
								<button
									class="btn btn-lg btn-primary item w-100 align-self-center h-100" style="background-color:gray; border:1px solid gray;
									type="button">판매완료</button>
							</div>
							<%
								} else {
							%>

							<div class="item w-25 align-self-center h-100">
								<button
									class="btn btn-lg btn-primary item w-100 align-self-center h-100" style="background-color:#ff7e36; border:1px solid #ff7e36;"
									type="button">
									<a
										href="/DaangnProject/Chat.do?boardId=<%=bv.getBoardId()%>&memIdBuy=<%=mv.getMemId()%>&memIdSell=<%=bv.getMemId()%>">채팅하기</a>
								</button>
							</div>



							<%
								}
							%>
							<%
// 								if (!mv.getMemId().equals(bv.getMemId())) {
								if (cnt > 0) {
							%>
							<div class="item w-25 align-self-center h-100">
								<button
									class="btn btn-lg btn-primary item w-100 align-self-center h-100"  style="background-color:gray; border:1px solid gray;
									type="button">
									<a
										href="/DaangnProject/deleteInterest.do?boardId=<%=bv.getBoardId()%>">

										찜삭제 </a>
								</button>
							</div>
							<%
								} else {
							%>
							<div class="item w-25 align-self-center h-100">
								<button
									class="btn btn-lg btn-primary item w-100 align-self-center h-100" style="background-color:#ff7e36; border:1px solid #ff7e36;"
									type="button">
									<a
										href="/DaangnProject/insertInterest.do?boardId=<%=bv.getBoardId()%>">찜하기
									</a>
								</button>
							</div>
							<%
								}
// 							}
							%>


						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container px-4 px-lg-5 my-5">
			<div>
				<h5>거래 희망 장소</h5>
			</div>
			<div id="map" style="width:100%;height:350px;"></div>
		</div>
	</section>







	<section class="py-5 bg-light">
            <div class="container px-4 px-lg-5 mt-5">
          
                <h2 class="fw-bolder mb-4">[<%=mv2.getMemNic()%>] 님의 판매 상품</h2>
                
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-left">


				
				 <%

                	for(int i=0; i<memIdBoardList.size(); i++){
                		
                		if(i>=4){
                			break;
                		}

                %>
		               	<a href="/DaangnProject/BoardDetail.do?boardId=<%=(memIdBoardList.get(i).getBoardId()) %>">
		              
		                    <div class="col mb-5">
		                        <div class="card">
		                            <!-- 상품 image-->
		                            <%
		                            	if(memIdBoardList.get(i).getFileStreCours() == null){
		                           	%>
		                  			<div class="card-img-top" style="overflow:hidden; height:12rem;">
										<img class="card-img-top" src="https://dummyimage.com/450x380/dee2e6/6c757d.jpg" alt="...">
		                            </div>
		                            <%
		                            }else{
		                            %>
									<div class="card-img-top" style="overflow:hidden; height:12rem;">
		                           		<img class="card-img-top"  src="/DaangnProject/download.do?atchFileId=<%=memIdBoardList.get(i).getBoardId()%>" alt="...">
									</div>
									<%
		                            }
									%> 
		                            <!-- 상품 details-->
		                            <div class="card-body p-4">
		                                <div class="text-center">
		                                    <!-- 상품 Title -->
		                                    <h5 class="fw-bolder text-lg-start" style="white-space: nowrap; text-overflow: ellipsis; overflow: hidden;">
											<%=(memIdBoardList.get(i).getBoardTitle()) %>
		                                    </h5>
		                                    <!-- 상품 price, date-->
		                                    <div class="x" style="display:flex; justify-content: space-between;">
		                                    	<div class="price">&#8361;<%=(memIdBoardList.get(i).getPrice()) %></div>
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
        

        
        <!-- Footer-->
        <jsp:include page="../comm/footer.jsp" />

	<!-- JavaScript -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e719101244762760ce768ead3d05c1c3"></script>
	<script>
		var lat = 36.32670268817612, // 서대전 농협 위도
		lon = 127.39725784245594; // 경도
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = { 
		        center: new kakao.maps.LatLng(lat, lon), // 지도의 중심좌표
		        level: 1 // 지도의 확대 레벨
		    };
		
		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
		
		// 마커가 표시될 위치입니다 
		var markerPosition  = new kakao.maps.LatLng(lat, lon); 
		
		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({
		    position: markerPosition
		});
		
		// 마커가 지도 위에 표시되도록 설정합니다
		marker.setMap(map);
		
		// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
		// marker.setMap(null); 
	</script>
    </body>
    
</html> 

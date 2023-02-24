<%@page import="board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="member.vo.MemberVO"%>

<%
	MemberVO mv = (MemberVO)session.getAttribute("memberVO");
	System.out.println(mv.getMemId());
	List<BoardVO> memList = (List<BoardVO>) request.getAttribute("boardList");
	
%>

    <!-- Head-->
	<jsp:include page="../comm/head.jsp" />
	
	<!-- CSS -->
	<style>
	
	body {
		padding-top: 170px;
		padding-bottom: 170px;
	}
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
        
        
        
        <article>
	        <div class="container" role="main">
	        	<h2>상품 등록하기</h2>
				<form id="form" action="/DaangnProject/BoardInsert.do" method="post" enctype="multipart/form-data">
					<div class="mb-3">	
						<label for="">제목</label>
						<input type="text" class="form-control" name="boardTitle" value="" placeholder="제목을 입력해 주세요">
					</div>

					<div class="mb-3">	
<!-- 						<label for="">작성자</label> -->
						<input type="hidden" class="form-control" name="memId" value="<%=mv.getMemId()%>">
					</div>
					<div class="mb-3">	
						<label for="">상품 설명</label>
						<textarea rows="10" class="form-control" name="boardContents" value=""></textarea>
					</div>					
					
					<div class="mb-3">	
						<label for="">카테고리</label>
			            <select name="boardKind" class="form-control">
							<option>카테고리 선택</option>
		       			<option value="C001">디지털기기</option>
	       				<option value="C002">생활가전</option>
	       				<option value="C003">가구/인테리어</option>
	       				<option value="C004">생활/주방</option>
	       				<option value="C005">유아용품</option>
	       				<option value="C006">의류</option>
	       				<option value="C007">패션/잡화</option>
	       				<option value="C008">뷰티/미용</option>
	       				<option value="C009">취미/게임/음반</option>
	       				<option value="C010">도서</option>
	       				<option value="C011">반려동물용품</option>
	       				<option value="C012">기타중고물품</option>
		       			</select>
					</div>
					
					<div class="mb-3">	
						<label for="">가격</label>
						<input type="text" name="price" value="" class="form-control">
					</div>
					<div class="mb-3">	
						<label for="">상품 사진</label>
						<input type="file" name="atchFile" class="form-control">
					</div>					
					<!-- hopeLatitude : 위도 -->
					<!-- HOPE_LONGITUDE : 경도 -->
					<div class="map_wrap">
				    	<div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>
					</div>
					<div id="clickLatlng"></div>
					<div class="mb-5">
						<button type="button" class="btn btn-sm btn-primary" id="btnSave">등록</button>
						<button type="button" class="btn btn-sm btn-primary" id="btnList">취소</button>
					</div>
<!-- 					<button type="submit" class="btn btn-sm btn-primary">작성하기</button> -->
					
					
					
				</form>
			</div>
		</article>

		

		
        <!-- Footer-->
        <jsp:include page="../comm/footer.jsp" />

	<!-- JavaScript -->
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.js"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e719101244762760ce768ead3d05c1c3&libraries=services"></script>
	<script>	

		$(document).on('click', '#btnSave', function(e){
			e.preventDefault();
			$("#form").submit();
		});
	
		$(document).on('click', '#btnList', function(e){
			e.preventDefault();
			location.href="/DaangnProject/Main.do";
		});
		
		
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = {
	        center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
	        level: 4 // 지도의 확대 레벨
	    };  

	// 지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption); 

	//HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
	if (navigator.geolocation) {
	    
	    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
	    navigator.geolocation.getCurrentPosition(function(position) {
	        
	        var lat = position.coords.latitude, // 위도
	            lon = position.coords.longitude; // 경도
	        
	        var locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
	            message = '<div style="padding:5px;">여기에 계신가요?!</div>'; // 인포윈도우에 표시될 내용입니다
	        
//	         마커와 인포윈도우를 표시합니다
	        displayMarker(locPosition, message);
	        map.setCenter(locPosition);

			
	        
	        $.ajax({
	    	    type : "get", //디폴트값 get이므로 안써도 됨
	    	    url : "https://dapi.kakao.com/v2/local/geo/coord2regioncode.json?x="+lon+"&y="+lat,
	    	    dataType : "json",
	    	    headers : {'Authorization': 'KakaoAK 056de8a0406ff7a44e6ff2173687b332'},
	    	    success : function(data){
	    	    	
	    	        console.log(data);
	    	        console.log(data.documents); //Array
	    	        console.log(data.documents[0].address_name);
	    	        $('#data1').text('JSON_법정동_address_name값 : ' + data.documents[0].address_name);
	    	        $('#data2').text('JSON_행정동_address_name값 : ' + data.documents[1].address_name);
	    	        
	    	        //B타입(법정동) 쓸지 H타입(행정동) 쓸지 정하기
	    	        
	    	    },
	    	    error : function(){
	    	        console.log('실패');
	    	    }
	    	});
	        
	        
	      });
	    
	} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
	    
	    var locPosition = new kakao.maps.LatLng(33.450701, 126.570667),    
	        message = 'geolocation을 사용할수 없어요..';
	    map.setCenter(locPosition);
//	     displayMarker(locPosition, message);
	}

	// 지도에 마커와 인포윈도우를 표시하는 함수입니다
	function displayMarker(locPosition, message) {

	    // 현재 위치 시작 마커를 생성합니다
//	     var marker = new kakao.maps.Marker({  
//	         map: map, 
//	         position: locPosition
//	     }); 
	    
	    var iwContent = message, // 인포윈도우에 표시할 내용
	        iwRemoveable = true;

	    // 인포윈도우를 생성합니다
//	     var infowindow = new kakao.maps.InfoWindow({
//	         content : iwContent,
//	         removable : iwRemoveable
//	     });
	    
	    // 인포윈도우를 마커위에 표시합니다 
//	     infowindow.open(map, marker);
	    
	    // 지도 중심좌표를 접속위치로 변경합니다
	    map.setCenter(locPosition);      
	} 



	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();

	var marker = new kakao.maps.Marker(), // 클릭한 위치를 표시할 마커입니다
	    infowindow = new kakao.maps.InfoWindow({zindex:1}); // 클릭한 위치에 대한 주소를 표시할 인포윈도우입니다

	// 현재 지도 중심좌표로 주소를 검색해서 지도 좌측 상단에 표시합니다
	// searchAddrFromCoords(map.getCenter(), displayCenterInfo);

	// 지도를 클릭했을 때 클릭 위치 좌표에 대한 주소정보를 표시하도록 이벤트를 등록합니다
	kakao.maps.event.addListener(map, 'click', function(mouseEvent) {
	    searchDetailAddrFromCoords(mouseEvent.latLng, function(result, status) {
	        if (status === kakao.maps.services.Status.OK) {
	            var detailAddr = !!result[0].road_address ? '<div>도로명주소 : ' + result[0].road_address.address_name + '</div>' : '';
	            detailAddr += '<div>지번 주소 : ' + result[0].address.address_name + '</div>';
	            
	            var content = '<div class="bAddr">' +
	                            '<span class="title">법정동 주소정보</span>' + 
	                            detailAddr + 
	                        '</div>';
//	             marker.setMap(null); 
	        	// 클릭한 위도, 경도 정보를 가져옵니다 
	            var latlng = mouseEvent.latLng;   
	            // 마커 위치를 클릭한 위치로 옮깁니다
	            marker.setPosition(latlng); 
	            marker.setMap(map);
	            
// 	            var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
// 	            message += '경도는 ' + latlng.getLng() + ' 입니다';
	            
	            //로그 찍는 방법?
	            console.log('클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, 경도는 ' 
	            			+ latlng.getLng() + ' 입니다');
	            
	            
// 	            var resultDiv = document.getElementById('clickLatlng'); 
// 	            resultDiv.innerHTML = message;
	            
	            // 마커를 클릭한 위치에 표시합니다 
//	             marker.setPosition(mouseEvent.latLng);
//	             marker.setMap(map);
				

	            // 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
	            infowindow.setContent(content);
	            infowindow.open(map, marker);
	        }   
	    });
	});


	function searchAddrFromCoords(coords, callback) {
	    // 좌표로 행정동 주소 정보를 요청합니다
	    geocoder.coord2RegionCode(coords.getLng(), coords.getLat(), callback);         
	}

	function searchDetailAddrFromCoords(coords, callback) {
	    // 좌표로 법정동 상세 주소 정보를 요청합니다
	    geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
	}

	// 지도 좌측상단에 지도 중심좌표에 대한 주소정보를 표출하는 함수입니다
	function displayCenterInfo(result, status) {
	    if (status === kakao.maps.services.Status.OK) {
	        var infoDiv = document.getElementById('centerAddr');

	        for(var i = 0; i < result.length; i++) {
	            // 행정동의 region_type 값은 'H' 이므로
	            if (result[i].region_type === 'H') {
	                infoDiv.innerHTML = result[i].address_name;
	                break;
	            }
	        }
	    }    
	}


	</script>
    </body>
    
</html>

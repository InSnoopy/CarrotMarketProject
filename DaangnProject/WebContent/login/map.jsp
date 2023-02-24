<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
.map_wrap {position:relative;width:100%;height:350px;}
.title {font-weight:bold;display:block;}
.hAddr {position:absolute;left:10px;top:10px;border-radius: 2px;background:#fff;background:rgba(255,255,255,0.8);z-index:1;padding:5px;}
#centerAddr {display:block;margin-top:2px;font-weight: normal;}
.bAddr {padding:5px;text-overflow: ellipsis;overflow: hidden;white-space: nowrap;}
</style>
</head>
<body>

<div class="map_wrap">
    <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>
    <div class="hAddr">
        <span class="title">지도중심기준 행정동 주소정보</span>
        <span id="centerAddr"></span>
    </div>
</div>
<button id="modify" onclick="clickBtn()" >동네등록!</button>
<div id="clickLatlng"></div>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c234da2a33b61d33179e7f77f4550f43&libraries=services"></script>

    <script>
        function clickBtn(){
            // BOM의 navigator객체의 하위에 geolocation객체가 새로 추가되었음.
            window.navigator.geolocation.getCurrentPosition( function(position){ //OK
                var lat= position.coords.latitude;
                var lng= position.coords.longitude;
 
                document.getElementById('target').innerHTML=lat+", "+lng;
            } ,
            function(error){ //error
                switch(error.code){
                    case error.PERMISSION_DENIED:
                        str="사용자 거부";
                        break;
                    case error.POSITION_UNAVAILABLE:
                        str="지리정보 없음";
                        break;
                    case error.TIMEOUT:
                        str="시간 초과";
                        break;
                    case error.UNKNOWN_ERROR:
                        str="알수없는 에러";
                        break;
                }
                document.getElementById('target').innerHTML=str;
            });
        }
 
    </script>


<body>
 
    <button onclick="clickBtn()">my location</button>
    <h3 id="target">location</h3>

    
</body>


<script>




var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
        level: 1 // 지도의 확대 레벨
};  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

//HTML5의 geolocation으로 사용할 수 있는지 확인합니다 


</script>
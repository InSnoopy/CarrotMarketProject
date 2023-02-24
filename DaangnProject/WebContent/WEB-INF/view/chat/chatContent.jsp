<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="chat.service.ChatRoomServiceImpl"%>
<%@page import="chat.service.IChatRoomService"%>
<%@page import="chat.vo.ChatVO"%>
<%@page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- <link href="../WebContent/chat.css" rel="stylesheet" type="text/css"> -->
<link rel="stylesheet" type="text/css"
   href="<%=request.getContextPath()%>/css/chat/chat.css" />

<%

	String boardId = request.getParameter("boardId");
	int intBoardId = Integer.parseInt(request.getParameter("boardId"));
	String memIdBuy = request.getParameter("memIdBuy");
	String memIdSell = request.getParameter("memIdSell");
	
	IChatRoomService chatRoomService = ChatRoomServiceImpl.getInstance();
	
	MemberVO memberVO = (MemberVO)session.getAttribute("memberVO");
	System.out.println("로그인한 사람? " + memberVO);
	String loginUser = memberVO.getMemId();
	
	Map<String, String> map = new HashMap<String, String>();
	map.put("boardId", boardId);
	map.put("loginUser", loginUser);
	
	
	List<ChatVO> chatRoomList = (List<ChatVO>)chatRoomService.chatRoom();
	List<ChatVO> chatVOList = (List<ChatVO>)chatRoomService.chatList(map);	

// 	System.out.println("boardId: " + boardId + " memIdBuy: " + memIdBuy + " memIdSell: " + memIdSell);
// 	out.print("chatVOList : " + chatVOList);
%>
<c:set var="chatRoomList" value="<%=chatRoomList%>" />
<c:set var="chatVOList" value="<%=chatVOList%>" />

	<section class="py-5 bg-light">
            <div class="container px-4 px-lg-5 mt-5">

	<div class="messaging">
		<div class="inbox_msg">
			<div class="inbox_people">
			<div class="headind_srch">
				<div class="recent_heading">
            	<h4>대화목록</h4>
            	</div>
            	 <div class="srch_bar">
            	 <div class="stylish-input-group">
	                <input type="text" class="search-bar"  placeholder="Search" >
	                <span class="input-group-addon">
	                <button type="button"> <i class="fa fa-search" aria-hidden="true"></i> </button>
                </span> </div>
            	 </div>
			</div>
			
			
			<div class="inbox_chat">
<!-- 				<div class="chat_list active_chat"> -->
<!-- 	              <div class="chat_people"> -->
<!-- 	                <div class="chat_img"> <img class="profile" src="/DaangnProject/imgs/carrot.png" alt="sunil"> </div> -->
<!-- 	                <div class="chat_ib"> -->
<!-- 	                  <h5>Sunil Rajput <span class="chat_date">Dec 25</span></h5> -->
<!-- 	                  <p>Test, which is a new approach to have all solutions  -->
<!-- 	                    astrology under one roof.</p> -->
<!-- 	                </div> -->
<!-- 	              </div> -->
<!-- 	            </div> -->
				<c:forEach var="chatRoom" items="${chatRoomList}" varStatus="i">
	            <div class="chat_list" onclick="javascript:location.href='/DaangnProject/Chat.do?boardId=${chatRoom.boardId}&memIdBuy=${param.memIdBuy}&memIdSell=${param.memIdSell}'" style="cursor:pointer;">
<%-- 	            <div class="chat_list${i.index}" onclick="#" style="cursor:pointer;"> --%>
	              <div class="chat_people">
	                <div class="chat_img"> <img class="profile" src="/DaangnProject/imgs/carrot.png" alt="sunil"> </div>
	                <div class="chat_ib">
	                  <h5>${chatRoom.memNic} <span class="chat_date">${chatRoom.chatSendDate}</span></h5>
	                  <p>${chatRoom.chatContents}</p>
	                </div>
	              </div>
	            </div>
	            </c:forEach>
<!-- <script>
  var chatList = document.querySelectorAll('.chat_list');
  console.log(chatList.length)
  
  for(var i=0; i<chatList.length; i++){
	  this.addEventListener('click',function(i){
		  chatList[i].style.background = '#f3f1ed';
	  });
  }
</script> -->
			</div>
			    <div>
       			 <input type="hidden" id="roomName" value="<%=boardId%>">
   				</div>
   				<div>
			        <input type="hidden" id="username" value="${memberVO.memId}">
			    </div>
			
			</div>
			<div class="mesgs">
          <div class="msg_history" id="textArea">
              <div>
		      
          	<c:forEach var="chatVO" items="${chatVOList}">
          		<c:if test="${chatVO.memId!=chatVO.loginUser}">
          	<!-- incoming_msg 시작 -->
          		<div class="incoming_msg">
	              <div class="incoming_msg_img"> <img class="profile" src="/DaangnProject/imgs/carrot.png" alt="sunil"> </div>
	              <div class="received_msg">
	                <div class="received_withd_msg" >
	                  <p>${chatVO.chatContents}</p>
	                  <span class="time_date">
	                  <fmt:formatDate value="${chatVO.chatSendDate}" pattern="yyyy-MM-dd HH:ss"/> 
	                  </span></div>
	              </div>
	            </div>
            <!-- incoming_msg 끝 -->
            	</c:if>
            	<c:if test="${chatVO.memId==chatVO.loginUser}">
            <!-- outgoing_msg 시작 -->
				<div class="outgoing_msg">
	              <div class="sent_msg"  >
	                <p>${chatVO.chatContents}</p>
	                <span class="time_date">
	                <fmt:formatDate value="${chatVO.chatSendDate}" pattern="yyyy-MM-dd HH:ss"/> 
	                </span> </div>
	            </div>
         	<!-- outgoing_msg 끝 -->
         		</c:if>
         	</c:forEach>
         	</div>
         	</div>
          <div class="type_msg">
          <!-- 송신 메시지 텍스트박스 -->
            <div class="input_msg_write">
              <input type="text" id="messageText" class="write_msg" placeholder="메시지를 입력하세요.">
              <!-- 송신 버튼 -->
              <button class="msg_send_btn" id="sendBtn" type="button" disabled><i class="fa fa-paper-plane-o" aria-hidden="true"></i></button>
            </div>
          </div>
        
		</div>
	</div>
			<p class="text-center top_spac">Design by <a target="_blank" href="https://www.linkedin.com/in/sunil-rajput-nattho-singh/">SunilRajput</a></p>
</div>

</div>
</section>
<script type="application/javascript">
    "use strict";

    let Chat = {};

    Chat.socket = null;

    Chat.connect = (function (host) {
        if ('WebSocket' in window) {
            Chat.socket = new WebSocket(host);
        } else if ('MozWebSocket' in window) {
            Chat.socket = new MozWebSocket(host);
        } else {
            Console.log('Error: WebSocket을 지원하지 않는 브라우저입니다');
            return;
        }
		
        Chat.socket.onopen = function () {
            Console.log('Info: WebSocket이 연결되었습니다.');
            document.getElementById('username').onkeyup = function (event) {
                if (event.keyCode === 13) {
                    Chat.socket.send(document.getElementById('username').value);
                }
            };
            document.getElementById('messageText').onkeyup = function (event) {
                if (event.keyCode === 13) {
                    Chat.sendMessage();
                    location.href="/DaangnProject/Chat.do?boardId=${param.boardId}&memIdBuy=${param.memIdBuy}&memIdSell=${param.memIdSell}";
                }
            };
            document.getElementById('sendBtn').disabled = false;
            document.getElementById('sendBtn').onclick = function () {
                Chat.sendMessage();
                location.href="/DaangnProject/Chat.do?boardId=${param.boardId}&memIdBuy=${param.memIdBuy}&memIdSell=${param.memIdSell}";
            };
        };
		
        Chat.socket.onclose = function () {
            document.getElementById('username').onkeyup = null;
            document.getElementById('messageText').onkeyup = null;
            document.getElementById('sendBtn').disabled = true;
            Console.log('Info: WebSocket이 닫혔습니다.');
        };

        Chat.socket.onmessage = function (message) {
            console.log(message.data);
        };
    });
	
    Chat.initialize = function () {
        let roomName = document.getElementById('roomName').value;
        let username = document.getElementById('username').value;
        Chat.connect('ws' + '://' + window.location.host + '/DaangnProject/chat/' + roomName + '/' + username);
        console.log('initialize')
    };
	
    Chat.sendMessage = function () {
        let message = document.getElementById('messageText').value;
        if (message !== '') {
            console.log(message);
        	
            Chat.socket.send(message);
            
            document.getElementById('messageText').value = '';
        }
    };
	
    let Console = {};
	
    // 메세지 보여주는 메소드
    Console.log = (function (message) {
        let console = document.getElementById('textArea');
//         console.value += message + '\n';
//         console.log(message);
        // 화면이 가장 아래로 내려갔을 때 대화 화면을 위로 올려준다.
        console.scrollTop = console.scrollHeight;
    });
	
    Chat.initialize();
	
</script>

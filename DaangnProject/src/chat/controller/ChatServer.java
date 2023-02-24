package chat.controller;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import chat.service.ChatRoomServiceImpl;
import chat.service.IChatRoomService;
import chat.vo.ChatVO;

import java.io.IOException;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/chat/{roomName}/{userId}")
public class ChatServer {
    private static final Set<ChatServer> connections = new CopyOnWriteArraySet<>();

    private int roomName;
    private int boardId;
    private String userId;
    private String filteredMessage;
    private Date chatSendDate;
    private Session session;
    private IChatRoomService chatService = ChatRoomServiceImpl.getInstance();

    // 웹소켓 연결시 호출
    @OnOpen
    public void start(Session session, @PathParam("roomName") int roomName, @PathParam("userId") String userId) {
        this.session = session;
        this.roomName = roomName;
        this.userId = userId;
        connections.add(this);
        String message = String.format("%s%s", userId, "님이 입장하셨습니다.");
        System.out.println(roomName);
        broadcast(message);
    }
    
    // 웹 소켓이 닫힐 때 세션 제거
    @OnClose
    public void end() {
        connections.remove(this);
        String message = String.format("%s%s", userId, "님이 나가셨습니다.");
        System.out.println(message);
        broadcast(message);
    }
    
    // 웹소켓 메시지 수신시 호출
    @OnMessage
    public void incoming(String message) {
        String filteredMessage = String.format("%s: %s", userId, message);
        System.out.println(filteredMessage);
        broadcast(filteredMessage);
        int cnt = chatService.insertChat(new ChatVO(userId, roomName, message));
        System.out.println(cnt);
    }
    
    // 웹 소켓이 에러가 나면 호출되는 이벤트
    @OnError
    public void onError(Throwable t) {
        t.printStackTrace();
    }

    // 같은 방으로 접속했을 때만 전달되도록
    private void broadcast(String msg) {
        for (ChatServer client : connections) {
            if (client.roomName == this.roomName) {
                try {
                    synchronized (client) {
                        client.session.getBasicRemote().sendText(msg);
                    }
                } catch (IOException e) {
                	e.printStackTrace();
                    connections.remove(client);
                    try {
                        client.session.close();
                    } catch (IOException e1) {
                    	e1.printStackTrace();
                    }
                    String message = String.format("%s %s", client.userId, "님 연결이 해제되었습니다.");
                    broadcast(message);
                }
            }
        }
    }
}

package chat.service;	
	
import java.util.List;
import java.util.Map;

import board.vo.BoardVO;
import chat.dao.ChatRoomDaoImpl;
import chat.dao.IChatRoomDao;
import chat.vo.ChatVO;
import member.vo.MemberVO;
	
public class ChatRoomServiceImpl implements IChatRoomService{
	
	private static IChatRoomService chatRoomService;
	private IChatRoomDao chatRoomDao = ChatRoomDaoImpl.getInstance();
	
	private ChatRoomServiceImpl() {};
	public static IChatRoomService getInstance() {
		if(chatRoomService==null) {
			chatRoomService = new ChatRoomServiceImpl();
		}
		return chatRoomService;
	}
	
	@Override
	public int insertChat(ChatVO cv) {
		
		return chatRoomDao.insertChat(cv);
	}
	
	@Override
	public List<ChatVO> listChat() {

		return null;
	}
	
	@Override
	public ChatVO searchChat(ChatVO cv) {

		return chatRoomDao.searchChat(cv);
	}
	
	@Override
	public int deleteChat(String boardId) {

		return chatRoomDao.deleteChat(boardId);
	}
	
	//대화목록 방 정보
	@Override
	public List<ChatVO> chatRoom() {
		return chatRoomDao.chatRoom();
	}
	
	//대화목록 상세
	@Override
	public List<ChatVO> chatList(Map<String, String> map) {
		return chatRoomDao.chatList(map);
	}
	@Override
	public List<MemberVO> selectChatMember(BoardVO bv) {
		return chatRoomDao.selectChatMember(bv);
	}
}

package chat.dao;

import java.util.List;
import java.util.Map;

import board.vo.BoardVO;
import chat.vo.ChatVO;
import comm.dao.MyBatisDAO;
import member.vo.MemberVO;


public class ChatRoomDaoImpl extends MyBatisDAO implements IChatRoomDao{


	private static IChatRoomDao chatRoom;
	private ChatRoomDaoImpl() {}
	public static IChatRoomDao getInstance() {
		if(chatRoom == null) {
			chatRoom = new ChatRoomDaoImpl();
		}return chatRoom;
	}
	
	@Override
	public int insertChat(ChatVO cv) {
		return insert("chatRoom.insertChatRoom", cv);
	}

	//대화목록 방 정보
	@Override
	public List<ChatVO> chatRoom() {
		return selectList("chatRoom.chatRoom", null);
	}
	
	//대화목록 상세
	@Override
	public List<ChatVO> chatList(Map<String, String> map) {
		return selectList("chatRoom.chatList", map);
	}

	@Override
	public ChatVO searchChat(ChatVO cv) {
		// TODO Auto-generated method stub
		return selectOne("chatRoom.searchChatRoom", cv);
	}

	@Override
	public int deleteChat(String boardId) {
		return delete("chatRoom.deleteChatRoom", boardId);
	}
	@Override
	public List<MemberVO> selectChatMember(BoardVO bv) {
		return selectList("chatRoom.selectChatMember",bv);
	}

}

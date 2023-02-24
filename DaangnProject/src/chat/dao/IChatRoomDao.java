package chat.dao;

import java.util.List;
import java.util.Map;

import board.vo.BoardVO;
import chat.vo.ChatVO;
import member.vo.MemberVO;

public interface IChatRoomDao {
	
	/**
	 * ChatVO에 담겨진 데이터를 DB에 insert하는 메서드
	 * @param mv DB에 insert할 데이터가 저장된 ChatVO객체
	 * @return DB작업이 성공하면 1이상의 값이 반환됨.
	 */
	public int insertChat(ChatVO cv);
	
	/**
	 * DB에 테이블에 존재하는 전체 채팅방를 조회하기 위한 메서드
	 * @return 채팅방 정보를 담고있는 List타입의 객체
	 */
	public List<ChatVO> chatList(Map<String, String> map);
	
	/**
	 * ChatVO에 담긴 데이터를 이용하여 회원정보를 검색하는 메서드
	 * @param cv 채팅방을 검색하기 위한 데이터
	 * @return 검색된 결과를 담고 있는 List타입의 객체
	 */
	public ChatVO searchChat(ChatVO cv);
	
	
	/**
	 * ChatVO에 담겨진 데이터를 DB에 delete하는 메서드
	 * @param mv DB에 delete할 데이터가 저장된 ChatVO객체
	 * @return DB작업이 성공하면 1이상의 값이 반환됨.
	 */
	public int deleteChat(String boardId);

	//대화목록 방 정보
	public List<ChatVO> chatRoom();
	
	public List<MemberVO> selectChatMember(BoardVO bv);
}

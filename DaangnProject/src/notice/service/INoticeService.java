package notice.service;

import java.util.List;

import notice.vo.NoticeVO;

public interface INoticeService {

	public int insertNotice(NoticeVO nv);
	
	public int updateNotice(NoticeVO nv);
	
	public int deleteNotice(String noticeId);
	
	public List<NoticeVO> selectAllNotice();
	
	public NoticeVO getNotice(String noticeId);
	
	public List<NoticeVO> searchNotice(NoticeVO nv);
	
	public int countNotice();
	
	public List<NoticeVO> pagingListNotice(NoticeVO nv);
}

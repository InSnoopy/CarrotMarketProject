package notice.dao;

import java.util.List;

import comm.dao.MyBatisDAO;
import notice.vo.NoticeVO;

public class NoticeDaoImpl extends MyBatisDAO implements INoticeDao {
	
	private static INoticeDao noticeDao;
	
	private NoticeDaoImpl() {
	}
	
	public static INoticeDao getInstance() {
		if(noticeDao == null) {
			noticeDao = new NoticeDaoImpl();
		}
		return noticeDao;
	}

	@Override
	public int insertNotice(NoticeVO nv) {
		return insert("notice.insertNotice", nv);
	}

	@Override
	public int updateNotice(NoticeVO nv) {
		return update("notice.updateNotice", nv);
	}

	@Override
	public int deleteNotice(String noticeId) {
		return delete("notice.deleteNotice", noticeId);
	}

	@Override
	public List<NoticeVO> selectAllNotice() {
		return selectList("notice.selectAllNotice", null);
	}

	@Override
	public NoticeVO getNotice(String noticeId) {
		return selectOne("notice.getNotice", noticeId);
	}

	@Override
	public List<NoticeVO> searchNotice(NoticeVO nv) {
		return selectList("notice.searchNotice", nv);
	}

	@Override
	public int countNotice() {
		int cnt = selectOne("notice.countNotice", null);
		return cnt;
	}

	@Override
	public List<NoticeVO> pagingListNotice(NoticeVO nv) {
		return selectList("notice.pagingListNotice", nv);
	}
	
	

}

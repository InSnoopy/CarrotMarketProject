package notice.service;

import java.util.List;

import notice.dao.INoticeDao;
import notice.dao.NoticeDaoImpl;
import notice.vo.NoticeVO;

public class NoticeServiceImpl implements INoticeService {
	
	private static INoticeService noticeService;
	private INoticeDao noticeDao;
	
	private NoticeServiceImpl() {
		noticeDao = NoticeDaoImpl.getInstance();
	}
	
	public static INoticeService getInstance() {
		if(noticeService == null) {
			noticeService = new NoticeServiceImpl();
		}
		return noticeService;
	}

	@Override
	public int insertNotice(NoticeVO nv) {
		return noticeDao.insertNotice(nv);
	}

	@Override
	public int updateNotice(NoticeVO nv) {
		return noticeDao.updateNotice(nv);
	}

	@Override
	public int deleteNotice(String noticeId) {
		return noticeDao.deleteNotice(noticeId);
	}

	@Override
	public List<NoticeVO> selectAllNotice() {
		List<NoticeVO> noticeList = noticeDao.selectAllNotice();
		return noticeList;
	}

	@Override
	public NoticeVO getNotice(String noticeId) {
		return noticeDao.getNotice(noticeId);
	}

	@Override
	public List<NoticeVO> searchNotice(NoticeVO nv) {
		List<NoticeVO> noticeList = noticeDao.searchNotice(nv);
		return noticeList;
	}

	@Override
	public int countNotice() {
		return noticeDao.countNotice();
	}

	@Override
	public List<NoticeVO> pagingListNotice(NoticeVO nv) {
		return noticeDao.pagingListNotice(nv);
	}

	

	
}

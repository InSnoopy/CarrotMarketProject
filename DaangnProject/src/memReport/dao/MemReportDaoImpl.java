package memReport.dao;

import java.util.List;

import comm.dao.MyBatisDAO;
import memReport.vo.MemReportVO;
import notice.vo.NoticeVO;

public class MemReportDaoImpl extends MyBatisDAO implements IMemReportDao {
	
	private static IMemReportDao memReportDao;
	
	private MemReportDaoImpl() {
	}
	
	public static IMemReportDao getInstance() {
		if(memReportDao == null) {
			memReportDao = new MemReportDaoImpl();
		}
		return memReportDao;
	}

	@Override
	public List<MemReportVO> selectAllMemReport() {
		return selectList("memReport.selectAllMemReport", null);
	}

	@Override
	public MemReportVO getMemReport(String memReportId) {
		return selectOne("memReport.getMemReport", memReportId);
	}

	@Override
	public int deleteMemReport(String memReportId) {
		return delete("memReport.deleteMemReport", memReportId);
	}

	@Override
	public List<MemReportVO> searchMemReport(MemReportVO mrv) {
		return selectList("memReport.searchMemReport", mrv);
	}

	

}

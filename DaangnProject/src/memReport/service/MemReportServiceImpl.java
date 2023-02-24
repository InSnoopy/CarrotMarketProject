package memReport.service;

import java.util.List;

import memReport.dao.IMemReportDao;
import memReport.dao.MemReportDaoImpl;
import memReport.vo.MemReportVO;

public class MemReportServiceImpl implements IMemReportService {
	
	private static IMemReportService memReportService;
	private IMemReportDao memReportDao;
	
	private MemReportServiceImpl() {
		memReportDao = MemReportDaoImpl.getInstance();
	}
	
	public static IMemReportService getInstance() {
		if(memReportService == null) {
			memReportService = new MemReportServiceImpl();
		}
		return memReportService;
	}

	@Override
	public List<MemReportVO> selectAllMemReport() {
		List<MemReportVO> memReportList = memReportDao.selectAllMemReport();
		return memReportList;
	}

	@Override
	public MemReportVO getMemReport(String memReportId) {
		return memReportDao.getMemReport(memReportId);
	}

	@Override
	public int deleteMemReport(String memReportId) {
		return memReportDao.deleteMemReport(memReportId);
	}

	@Override
	public List<MemReportVO> searchMemReport(MemReportVO mrv) {
		List<MemReportVO> memReportList = memReportDao.searchMemReport(mrv);
		return memReportList;
	}


	
	

}

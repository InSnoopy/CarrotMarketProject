package memReport.service;

import java.util.List;

import memReport.vo.MemReportVO;

public interface IMemReportService {
	
	public List<MemReportVO> selectAllMemReport();
	
	public MemReportVO getMemReport(String memReportId);
	
	public int deleteMemReport(String memReportId);
	
	public List<MemReportVO> searchMemReport(MemReportVO mrv);
	

}

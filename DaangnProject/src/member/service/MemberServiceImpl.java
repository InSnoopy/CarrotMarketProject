package member.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import board.vo.BoardVO;
import follows.vo.FollowsVO;
import member.dao.IMemberDao;
import member.dao.MemberDaoImpl;
import member.vo.MemberVO;
import trade.vo.TradeVO;

public class MemberServiceImpl implements IMemberService{

	private static final String UPLOAD_DIR = "upload_files";
	
	private static IMemberService memService;
	private IMemberDao memDao;
	
	private MemberServiceImpl() {
		memDao = MemberDaoImpl.getInstance();
	}
	
	public static IMemberService getInstance() {
		if(memService==null) {
			memService = new MemberServiceImpl();
		}
		return memService;
	}

	@Override
	public int registMember(MemberVO mv) {
		int cnt = memDao.insertMember(mv);
		
		// 데이터 관련된건 memDao에 다 시키고 그 외에 
		// 비즈니스 로직은 Service가 한다.
		
		//if(cnt > 0) {
		//	//메일발송 기능 호출...
		//}
		
		return cnt;
	}

	@Override
	public boolean checkMember(String memId) {
		boolean exist = memDao.checkMember(memId);
		return exist;
	}

	@Override
	public int modifyMember(MemberVO mv) {
		int cnt = memDao.updateMember(mv);
		return cnt;
	}

	@Override
	public int removeMember(String memId) {
		int cnt = memDao.deleteMember(memId);
		return cnt;
	}

	//아이디로 voList
	@Override
	public List<MemberVO> listMember(String memId) {
		List<MemberVO> memList = memDao.listMember(memId); 
		return memList;
	}

	@Override
	public List<MemberVO> searchMember(MemberVO mv) {
		List<MemberVO> memList = memDao.searchMember(mv); 
		return memList;
	}

	@Override
	public MemberVO getMember(String memId) {
		return memDao.getMember(memId);
	}

	@Override
	public MemberVO memberInfo(String memId) {

		return memDao.memberInfo(memId);
	}

	@Override
	public int memberLogin(MemberVO mv) {

		return memDao.memberLogin(mv);
	}

	@Override
	public MemberVO findUser(MemberVO mv) {
		return this.memDao.findUser(mv);
	}

	@Override
	public int registerRegion1(MemberVO mv) {
		int cnt = memDao.registerRegion1(mv);
		return cnt;
	}

	@Override
	public MemberVO insertProfile(HttpServletRequest req) {
		
		//업로드 경로 설정하기
		String uploadPath = UPLOAD_DIR;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		
		MemberVO memberVO = null;
		
		try {
			String fileName = "";
			
			boolean isFirstFile = true; // 첫번째 파일여부
			
			for(Part part : req.getParts()) {
				
				//파일명 추출
				fileName = getFileName(part);
				
				if(fileName != null && !fileName.equals("")) {
					// 첨부파일인 경우...
					if(isFirstFile) { // 첫번째 파일이 맞다면...
						isFirstFile = false;
						
						// 기본 파일정보 저장하기
						memberVO = new MemberVO();
						
						memDao.insertProfile(memberVO);
					}
					
					String saveFileName = ""; // 저장파일명
					String saveFilePath = ""; // 저장파일경로
					
					saveFileName = UUID.randomUUID().toString().replace("-", "");
					saveFilePath = uploadPath + File.separator + saveFileName;
					
					
					// 업로드 파일(원본파일) 저장
					part.write(saveFilePath);
					
					memberVO.setProfile(saveFilePath);
					
					memDao.insertProfile(memberVO);
					
					part.delete();
				}
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return memberVO;
	}

	/**
	 * Part 객체를 파싱하여 파일이름 추출하기
	 * @param part 파싱할 Part객체
	 * @return 파일명: 존재하지 않으면 NULL 리턴함(폼필드인 경우)
	 */
	private String getFileName(Part part) {
		/*
		Content-Disposition 헤더에 대하여...
		
		multipart body를 위해 사용되는 경우 ex)파일업로드
		
		Content-Disposition: form-data
		Content-Disposition: form-data; name="fieldName"
		Content-Disposition: form-data; name="fieldName"; 
		                     filename="a.jpg"
	 */
		for(String content : part.getHeader("Content-Disposition").split(";")) {
			if(content.trim().startsWith("filename")) {
				return content.substring(
						content.indexOf("=") + 1).trim().replace("\"", "");
			}
		}
		return null; // filename이 존재하지 않을 경우...(폼필드)
	}

	//아이디 찾기 메소드
	@Override
	public MemberVO findId(MemberVO mv) {
		return memDao.findId(mv);
	}
	
	//비밀번호 찾기 메소드
	@Override
	public MemberVO findPw(MemberVO mv) {
		return memDao.findPw(mv);
	}

	@Override
	public List<BoardVO> sellList(TradeVO tv) {
		return memDao.sellList(tv);
	}
}

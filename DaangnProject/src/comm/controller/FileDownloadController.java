package comm.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;
import comm.service.AtchFileServiceImpl;
import comm.service.IAtchFileService;
import comm.vo.AtchFileVO;


@WebServlet("/download.do")
public class FileDownloadController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		doPost(request, response);
		
		String atchFileId = req.getParameter("atchFileId");

		
//		String fileSn = req.getParameter("fileSn");
		
		IBoardService boardService = BoardServiceImpl.getInstance();
		BoardVO bv = boardService.selectBoard(atchFileId);

		
//		System.out.println("hi22222222 : " + fileSn);
//		
//		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
//		
//		AtchFileVO atchFileVO = new AtchFileVO();
//		atchFileVO.setAtchFileId(Long.parseLong(atchFileId));
//		atchFileVO.setFileSn(Integer.parseInt(fileSn));
//		
//		atchFileVO = fileService.getAtchFileDetail(atchFileVO);
		
		// 파일 다운로드 처리를 위한 응답헤더 정보 설정하기
		resp.setContentType("application/octet-stream");
		// URLEncdoer -> 파일 한글 깨지지 않기 + 공백처리
		// URL에는 공백문자를 포함할 수 없다. URLEncoding을 이용하여 인코딩 작업을 하면
		// 공백은 (+)로 표시되기 때문에 +문자를 공백문자인 %20으로 바꿔준다.
//		resp.setHeader("Content-Disposition", "attachment; filename=\""+ URLEncoder.encode("HHH", "UTF-8").replaceAll("\\+", "%20") +"\""); // 파일 이름을 안붙이면 서블릿 이름으로 지정된다.
//		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:/A_TeachingMaterial/03_HighJava/workspace/DaangnProject/WebContent/imgs/8cffb202f9004809bed2209c426751c7.png"));
//		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(atchFileId));
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(bv.getFileStreCours()));
		BufferedOutputStream bos = new BufferedOutputStream(resp.getOutputStream());
		System.out.println(bv.getFileStreCours());

		
//		resp.setHeader("Content-Disposition", "attachment; filename=\""+ URLEncoder.encode(atchFileVO.getOrignlFileNm(), "UTF-8").replaceAll("\\+", "%20") +"\""); // 파일 이름을 안붙이면 서블릿 이름으로 지정된다.
//		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(atchFileVO.getFileStreCours()));
//		BufferedOutputStream bos = new BufferedOutputStream(resp.getOutputStream());
		
		int data = 0;
		while((data = bis.read()) != -1) {
			bos.write(data);
		}

		
		bis.close();
		bos.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
		
	}

}

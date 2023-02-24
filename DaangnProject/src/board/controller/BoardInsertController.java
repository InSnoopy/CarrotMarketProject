package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;
import comm.service.AtchFileServiceImpl;
import comm.service.IAtchFileService;
import comm.vo.AtchFileVO;
import member.vo.MemberVO;

@MultipartConfig
@WebServlet("/BoardInsert.do")
public class BoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
      
      request.setCharacterEncoding("UTF-8");
      HttpSession session = request.getSession();
      MemberVO mv = (MemberVO)session.getAttribute("memberVO");
      
      String boardTitle = request.getParameter("boardTitle");
      String memId = request.getParameter("memId");
      String boardContents = request.getParameter("boardContents");      
      String categoryId = request.getParameter("boardKind");
      String atchFile = request.getParameter("atchFile");
      String regRange = mv.getMemAddr1();
      int price = Integer.parseInt(request.getParameter("price"));

      
      
      BoardVO bv = new BoardVO();
      bv.setMemId(memId);
      bv.setCategoryId(categoryId);
      bv.setBoardTitle(boardTitle);
      bv.setBoardContents(boardContents);
      bv.setPrice(price);
      bv.setRegRange(regRange);
      
      System.out.println("서블릿에서 bv넣고 찍어보기 : " + bv);
      
      // 서비스 객체 생성하기
      IBoardService boardService = BoardServiceImpl.getInstance();
      IAtchFileService fileService = AtchFileServiceImpl.getInstance();
      
      AtchFileVO atchFileVO = new AtchFileVO();
      
      atchFileVO = fileService.saveAtchFileList(request);
      
//      System.out.println(atchFileVO.getFileStreCours());

      bv.setFileStreCours(atchFileVO.getFileStreCours());
      
      
      int cnt = boardService.insertBoard(bv);
      
      if(cnt>0) {
         System.out.println("성공");
//         request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
         response.sendRedirect("/DaangnProject/Main.do");
// 		 request.getRequestDispatcher("/WEB-INF/view/mypage/followerList.jsp").forward(request, response);
      }else {         
         System.out.println("실패");
         response.sendRedirect("/DaangnProject/Main.do");
      }
   }

}
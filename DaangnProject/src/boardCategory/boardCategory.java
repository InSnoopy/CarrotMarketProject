package boardCategory;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;

@WebServlet("/boardCategory.do")
public class boardCategory extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
//		IBoardService boardService = BoardServiceImpl.getInstance();
		String category = req.getParameter("category");
//		System.out.println("category parameter : " + category);
//		List<BoardVO> cateList = boardService.categoryList(category);
//		System.out.println(category);
		req.setAttribute("category", category);
		
		
		
//		for(BoardVO bv : cateList) {
//			System.out.println("cateList : " + bv.getBoardTitle());
//		}
		
		
		//categoryList
		
		
		req.getRequestDispatcher("/WEB-INF/view/board/boardCategory.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

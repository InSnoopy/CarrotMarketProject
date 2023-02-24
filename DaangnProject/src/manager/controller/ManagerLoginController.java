package manager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manager.service.IManagerService;
import manager.service.ManagerServiceImpl;
import manager.vo.ManagerVO;

@WebServlet("")
public class ManagerLoginController extends HttpServlet {
	
	private static final long SerialVersionUID = 1L;
	
	IManagerService managerService = ManagerServiceImpl.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		HttpSession session = req.getSession(true);
//		ManagerVO managerVO = (ManagerVO) session.getAttribute("managerVO");
		
		String managerId = req.getParameter("memId");
		String managerPw = req.getParameter("memPw");
		System.out.println("getParameter : " + managerId + "/" + managerPw);
		
		ManagerVO mngv = new ManagerVO();
		mngv.setManagerId(managerId);
		mngv.setManagerPw(managerPw);
		
		mngv = managerService.managerLogin(mngv);
		
		if(mngv == null) {
			System.out.println("매니저객체가 null");
		} else if(managerId.equals("admin")){
			HttpSession session = req.getSession();
			session.setAttribute("managerVO", mngv);
			System.out.println("managerVO : " + mngv.toString());
			
			req.getRequestDispatcher("/WEB-INF/view/manager.jsp").forward(req, resp);
			
		}
		
	}
}

package manager.service;

import manager.dao.IManagerDao;
import manager.dao.ManagerDaoImpl;
import manager.vo.ManagerVO;

public class ManagerServiceImpl implements IManagerService {
	
	private static IManagerService managerService;
	private IManagerDao managerDao;
	
	private ManagerServiceImpl() {
		managerDao = ManagerDaoImpl.getInstance();
	}
	
	public static IManagerService getInstance() {
		if(managerService == null) {
			managerService = new ManagerServiceImpl();
		}
		return managerService;
	}

	/**
	 * 관리자 로그인 메서드
	 */
	@Override
	public ManagerVO managerLogin(ManagerVO mnv) {
		return managerDao.managerLogin(mnv);
	}
	

}

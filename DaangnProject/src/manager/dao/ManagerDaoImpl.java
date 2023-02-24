package manager.dao;

import comm.dao.MyBatisDAO;
import manager.vo.ManagerVO;

public class ManagerDaoImpl extends MyBatisDAO implements IManagerDao {
	
	private static IManagerDao managerDao;
	
	private ManagerDaoImpl() {
	}
	
	public static IManagerDao getInstance() {
		if(managerDao == null) {
			managerDao = new ManagerDaoImpl();
		}
		return managerDao;
	}

	/**
	 * 관리자 로그인 메서드
	 */
	@Override
	public ManagerVO managerLogin(ManagerVO mnv) {
		return selectOne("manager.loginManager", mnv);
	}
	

}

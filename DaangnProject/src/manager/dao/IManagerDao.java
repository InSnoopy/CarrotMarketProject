package manager.dao;

import manager.vo.ManagerVO;

public interface IManagerDao {
	
	/**
	 * 관리자 로그인 메서드
	 * @param mngv
	 * @return
	 */
	public ManagerVO managerLogin(ManagerVO mnv);

}

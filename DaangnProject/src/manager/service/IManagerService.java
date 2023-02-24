package manager.service;

import manager.vo.ManagerVO;

public interface IManagerService {
	
	/**
	 * 관리자 로그인 메서드
	 * @param mngv
	 * @return
	 */
	public ManagerVO managerLogin(ManagerVO mnv);
	
}

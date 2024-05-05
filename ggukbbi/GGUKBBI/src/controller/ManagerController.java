package controller;

import model.Session;
import model.dao.ManagerDAO;
import model.dto.ManagerDTO;

public class ManagerController {

	/**
	 * 매니저 로그인
	 * 	로그인시 세션에 "loginManager" 키값으로 manager 객체 저장
	 * @param managerid
	 * @param managerpw
	 * @return
	 */
	public boolean login(String managerid, String managerpw) {
		ManagerDAO mdao = new ManagerDAO();

		ManagerDTO manager = mdao.findManagerById(managerid);

		if (manager != null) {
			if (manager.getManagerpw().equals(managerpw)) {
				Session.setData("loginManager", manager);
				return true;
			}
		}
		return false;
	}
}

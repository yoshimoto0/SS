package admin.svc;

import vo.AdminDAO;

public class MemberUpgradeService {

	public int excute(String id) {
		int res = 0;
		AdminDAO dao = new AdminDAO();
		res = dao.memberUpgrade(id);
		
		return res;
	}

}

package admin.svc;

import vo.AdminDAO;

public class RequestRemoveService {

	public int excute(int num) {
		AdminDAO dao = new AdminDAO();
		int res = dao.removeRequest(num);
		
		return res;
	}

}

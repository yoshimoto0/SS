package admin.svc;

import vo.AdminDAO;

public class AddKindService {

	public int excute(String kind) {
		int res = 0;
		AdminDAO dao = new AdminDAO();
		res = dao.addKind(kind);
		
		return res;
	}

}

package admin.svc;

import vo.AdminDAO;

public class RemoveKindService {

	public int excute(String kind) {
		int res = 0;
		AdminDAO dao = new AdminDAO();
		res = dao.removeKind(kind);
		
		return 0;
	}

}

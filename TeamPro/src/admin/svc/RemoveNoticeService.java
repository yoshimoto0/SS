package admin.svc;

import vo.AdminDAO;

public class RemoveNoticeService {

	public int excute(int num) {
		int res = 0;
		AdminDAO dao = new AdminDAO(); 
		res = dao.RemoveNotice(num);
		
		
		return res;
		
	}

}

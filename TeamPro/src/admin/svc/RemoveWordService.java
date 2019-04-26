package admin.svc;

import vo.AdminDAO;

public class RemoveWordService {

	public int excute(int num) {
		
		int res = 0;
		AdminDAO dao = new AdminDAO(); 
		res = dao.RemoveWord(num);
		
		
		
		
		
		return res;
	}

}

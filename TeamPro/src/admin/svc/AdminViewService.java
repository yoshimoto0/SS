package admin.svc;

import java.util.ArrayList;

import vo.AdminDAO;

public class AdminViewService {

	public ArrayList excute(String table, String attribute, String keyword) {		
		ArrayList list =null;
		AdminDAO dao = new AdminDAO();
		list = dao.adminView(table,attribute,keyword);
		
		
		return list;
	}

}

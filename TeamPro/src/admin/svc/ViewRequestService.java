package admin.svc;

import java.util.ArrayList;

import vo.AdminDAO;
import vo.QnADTO;

public class ViewRequestService {

	public ArrayList<QnADTO> excute() {
		AdminDAO dao = new AdminDAO();
		ArrayList<QnADTO> list = dao.viewRequest();
		return list;
	}

}

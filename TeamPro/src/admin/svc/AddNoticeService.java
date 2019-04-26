package admin.svc;

import vo.AdminDAO;
import vo.NoticeDTO;

public class AddNoticeService {

	public int excute(NoticeDTO dto) {
		int res = 0;
		AdminDAO dao = new AdminDAO();
		res = dao.AddNotice(dto);
		return res;
	}

}

package svc;

import vo.MemberDAO;
import vo.MemberDTO;

public class UpdateService {

	public int excute(MemberDTO dto) {
		MemberDAO dao = new MemberDAO();
		int res = dao.UpdateMember(dto);
		return res;
	}

}

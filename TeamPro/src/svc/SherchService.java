package svc;

import vo.MemberDAO;
import vo.MemberDTO;

public class SherchService {

	public MemberDTO excute(String email) {
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.shechMember(email);
		return dto;
	}
	
}

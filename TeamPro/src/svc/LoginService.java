package svc;

import vo.MemberDAO;
import vo.MemberDTO;

public class LoginService {

	public MemberDTO excute(String id) {
		MemberDTO dto = null;
		MemberDAO dao = new MemberDAO();
		dto = dao.Login(id);
		
		return dto;
		
	}
	
}

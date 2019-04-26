package member.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import member.svc.UpdateService;
import member.vo.ActionForward;
import member.vo.MemberDTO;

public class UpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UpdateService svc = new UpdateService();
		HttpSession session = request.getSession();
		
		String user_id = request.getParameter("user_name");
		String user_pass = request.getParameter("user_pass");
		String user_name = request.getParameter("user_name");
		String email = request.getParameter("e-mail");
		
		ServletContext ctx = request.getServletContext();
		String path = "/images";
		String savePath = ctx.getRealPath(path);
		int maxSize = 10*1024*1024;
		String encType = "utf-8";
		
		MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, encType, new DefaultFileRenamePolicy());
		
		String image = multi.getFilesystemName("image");
		int favor = Integer.parseInt(request.getParameter("favor"));
		
		
		
		ActionForward af = null;
		MemberDTO dto = (MemberDTO) session.getAttribute("login_user");
		if(user_pass != null)dto.setUser_pass(user_pass);
		if(user_name != null)dto.setUser_name(user_name);
		if(email != null)dto.setEmail(email);
		if(image != null)dto.setImage(image);
		if(favor != dto.getFavor())dto.setFavor(favor);
		//if(isAdmin != dto.set)dto.setPass(pass); 관리자계정으로의 변환은 개인정보 수정에서 지원하지 않는다.
			
		int res = svc.execute(dto);
		
		if(res > 0) {
			af = new ActionForward("#", false);//수정.jsp
			session.removeAttribute("member");
			session.setAttribute("member", dto);
		}else {
			
			session.setAttribute("ErrorMessage", "일치하는 아이디를 찾지 못하였습니다.");
		}
		return af;
	}

}

package action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import svc.UpdateService;
import vo.ActionForward;
import vo.MemberDTO;

public class UpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UpdateService svc = new UpdateService();
		HttpSession session = request.getSession();
		
		String id = (String) request.getAttribute("id");
		String pass = (String) request.getAttribute("pass");
		String username = (String) request.getAttribute("nickname");
		String email = (String) request.getAttribute("email");
		
		ServletContext ctx = request.getServletContext();
		String path = "/images";
		String savePath = ctx.getRealPath(path);
		int maxSize = 10*1024*1024;
		String encType = "utf-8";
		
		MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, encType, new DefaultFileRenamePolicy());
		
		String image = multi.getFilesystemName("image");
		int favor = Integer.parseInt((String) request.getAttribute("favor"));
		
		
		
		ActionForward af = null;
		MemberDTO dto = (MemberDTO) session.getAttribute("member");
		if(pass != null)dto.setPass(pass);
		if(username != null)dto.setUserName(username);
		if(email != null)dto.setEmail(email);
		if(image != null)dto.setImage(image);
		if(favor != dto.getFavor())dto.setFavor(favor); 
		//if(isAdmin != dto.set)dto.setPass(pass); 관리자계정으로의 변환은 개인정보 수정에서 지원하지 않는다.
			
		int res = svc.excute(dto);
		
		if(res > 0) {
			af = new ActionForward("#", false);
			session.removeAttribute("member");
			session.setAttribute("member", dto);
		}
		return null;
	}

}

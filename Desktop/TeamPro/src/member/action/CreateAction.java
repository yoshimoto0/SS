package member.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import member.svc.CreateActionService;
import member.vo.ActionForward;
import member.vo.MemberDTO;

public class CreateAction implements Action{

	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("user_id");
		String pass = request.getParameter("user_pass");
		String nickname = request.getParameter("user_name");
		String email = request.getParameter("email");
		ServletContext ctx = request.getServletContext();
		String path = "/images";
		String savePath = ctx.getRealPath(path);
		int maxSize = 10*1024*1024;
		String encType = "utf-8";
		
		//MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, encType, new DefaultFileRenamePolicy());
		
		//String image = multi.getFilesystemName("image");

		int favor = Integer.parseInt(request.getParameter("favor"));		
		MemberDTO dto = new MemberDTO(id,pass,nickname,email,"123",favor,0);
		CreateActionService svc = new CreateActionService();
		int res = svc.execute(dto);
		HttpSession session = request.getSession();
		
		
		ActionForward af = null;
		if(res>0) {
			af = new ActionForward("home.jsp",true);	
			session.setAttribute("succesemessage","가입이 성공적으로 처리되었습니다.");
		}else {
			af = new ActionForward("home.jsp",true);
			session.setAttribute("ErrorMessage", "가입에 실패하였습니다.");
		
		}return af;
	}

}

package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.MemberDAO;
import vo.MemberDTO;

/**
 * Servlet implementation class RemoveServlet
 */
@WebServlet("/remove")
public class RemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login_user");
		String id = dto.getId();
		String resUrl = null;
		//2
		MemberDAO dao = new MemberDAO();
		int rs = dao.deleteMember(id);
		
		if(rs == 1) {
			session.invalidate();
			resUrl = "view/login.jsp";
		}else {
			session.setAttribute("error_message", "파일삭제에 실패하였습니다.");
			resUrl = "view/main.jsp";			
		}		
		//3
		RequestDispatcher rdp = request.getRequestDispatcher(resUrl);
		rdp.forward(request, response);
	}

}

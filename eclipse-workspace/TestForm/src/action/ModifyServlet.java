package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.MemberDAO;
import vo.MemberDTO;

/**
 * Servlet implementation class ModifyServlet
 */
@WebServlet("/modify")
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rdp = request.getRequestDispatcher("veiw/modify.jsp");
		rdp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		int admin = Integer.parseInt(request.getParameter("admin"));
	
		MemberDTO dto = new MemberDTO(id,pass,name,email,phone,admin);
		MemberDAO dao = new MemberDAO();
		int res = dao.modifyMember(id);
		String resUrl = null;
		
		if(res == 1) {
			resUrl = "view/main.jsp";
			request.setAttribute("massesy", "변경이 성공적으로 수행되었습니다.");
		}else {
			resUrl = "view/modify.jsp";
			request.setAttribute("massesy", "변경이 실패하었습니다.");
		}
		RequestDispatcher rdp = request.getRequestDispatcher(resUrl);
		rdp.forward(request, response);
	}

}

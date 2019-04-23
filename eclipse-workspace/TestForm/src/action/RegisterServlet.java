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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/join")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher rdp = request.getRequestDispatcher("view/join.jsp");
		rdp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//1. 요청 파라미터 조회
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		int admin = Integer.parseInt(request.getParameter("admin"));
		
		//2. 비즈니스 로직
		MemberDTO member = new MemberDTO(id, pass, name, email, phone, admin);
		MemberDAO dao = new MemberDAO();
		int res = dao.insertMember(member);
		String resUrl = null;
		
		//3. 응답 처리
		if(res > 0) {
			// 회원가입에 성공한 경우 - redirect
			resUrl = "view/login.jsp";			
		}else {
			// 회원가입에 실패한 경우
			request.setAttribute("error_message", "회원 가입에 실패하였습니다.");
			resUrl = "view/join.jsp";
		}
		
		RequestDispatcher rdp = request.getRequestDispatcher(resUrl);
		rdp.forward(request, response);		
	}

}

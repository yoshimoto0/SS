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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
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
		System.out.println(id + pass);
		
		//2. 비즈니스 로직
		MemberDAO dao = new MemberDAO();
		int res = dao.loginCheck(id, pass);
		String resUrl = null;
		
		//3. 응답 처리
		if(res == 1) { // 로그인에 성공했다면
			HttpSession session = request.getSession();
			MemberDTO login_user = dao.selectOneMember(id);
			session.setAttribute("login_user", login_user);
			resUrl = "view/main.jsp";
		}else if(res == 0) { // 비밀번호가 일치하지 않는다면
			request.setAttribute("error_message", "비밀번호가 일치하지 않습니다.");
			resUrl = "view/login.jsp";			
		}else if(res == -1) { // 회원이 아닐경우
			request.setAttribute("error_message", "회원이 존재하지 않습니다.");
			resUrl = "view/login.jsp";	
		}
		
		RequestDispatcher rdp = request.getRequestDispatcher(resUrl);
		rdp.forward(request, response);
	}

}

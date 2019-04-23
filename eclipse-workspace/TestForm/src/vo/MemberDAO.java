package vo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static db.JdbcUtils.*;

public class MemberDAO {
	
	/** 
	 * 회원가입을 처리하는 메서드
	 * @param MemberDTO
	 * */
	public int insertMember(MemberDTO member) {
		String sql = "insert into member values(?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPass());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getPhone());
			pstmt.setInt(6, member.getAdmin());
			res = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, pstmt, null);
		}
		
		return res;
	}
	
	/** 
	 * 아이디 중복체크를 위한 메서드
	 * @param id
	 * @return result
	 * */
	public int confirmId(String id) {
		int result = -1; // 아이디가 존재하지 않는다.
		String sql = "select id from member where id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1; // 아이디가 존재한다.
			}/*else {
				result = -1;
			}*/
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	/** 
	 * 회원인증을 위한 메서드
	 * @param id, pass
	 * @return res -1(비회원), 0(비밀번호가 일치않는다.), 1(회원)
	 * */
	public int loginCheck(String id, String pass) {
		int res = -1;
		String sql = "select * from member where id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  id);			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("pass").equals(pass)) {
					// 로그인에 성공했다면
					res = 1;
				}else {
					// 비밀번호가 일치하지 않는상황
					res = 0;
				}
			}else {
				// 회원이 아닐경우
				res = -1;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, pstmt, rs);
		}
		
		return res;
	}
	
	/** 
	 * id가 일치하는 회원의 정보를 가져오는 메서드
	 * @param id
	 * @return MemberDTO
	 * */
	public MemberDTO selectOneMember(String id) {
		String sql = "select * from member where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDTO dto = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  id);			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new MemberDTO(rs.getString("id"),
									rs.getString("pass"),
									rs.getString("name"),
									rs.getString("email"),
									rs.getString("phone"),
									rs.getInt("admin"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, pstmt, rs);
		}
		
		return dto;
	}
	/**@param id
	 * @return int
	 * */
	public int deleteMember(String id) {
		int rs = 0;
		String sql = "delete from member where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  id);			
			rs = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, pstmt, null);
		}
		
		return rs;
	}

	public int modifyMember(String id) {
		int rs = 0;
		String sql = "update from member where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  id);			
			rs = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, pstmt, null);
		}
		
		return rs;
	}
}

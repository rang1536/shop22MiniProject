package shop.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import shop.member.db.Member;

public class MemberDao {
	DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<Member> alm;
	Member m;
	int rowCount;
	public MemberDao(){
		System.out.println("---생성자메서드 Mdao---");
		try{
			Context init = new InitialContext();
			System.out.println("db접속중 : "+init);
		  	   ds = (DataSource) init.lookup("java:comp/env/jdbc/KsmartDB");
		  	System.out.println("db접속중 : "+ds);
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	
	//04 한명의 회원조회
	public Member mSelectOneByKey(String memberId) throws SQLException{
		System.out.println("04 한명의 회원조회");
		
		conn=ds.getConnection();
		pstmt = conn.prepareStatement(
				"select * from member where member_id = ?");
		pstmt.setString(1, memberId);
		rs = pstmt.executeQuery();
		if(rs.next()){
			m = new Member();
			m.setMemberId(rs.getString("member_id"));
			m.setMemberPw(rs.getString("member_pw"));
			m.setMemberName(rs.getString("member_name"));
			m.setMemberLevel(rs.getString("member_level"));
			m.setMemberSex(rs.getString("member_sex"));
			m.setMemberAddn(rs.getString("member_addn"));
			m.setMemberAdd(rs.getString("member_add"));
			m.setMemberAdds(rs.getString("member_adds"));
			m.setMemberEmail(rs.getString("member_email"));
			m.setMemberPhone(rs.getString("member_phone"));
			m.setMemberMobile(rs.getString("member_mobile"));
			m.setMemberMileage(rs.getString("member_mileage"));
		
		}
		if (rs != null) try { rs.close(); } catch(SQLException ex) {}
		if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
		if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		return m;
	}
	
	//03 회원검색
	public ArrayList<Member> mSelectSearch(String sk, String sv) throws SQLException{
		System.out.println("03 회원검색");
		System.out.println("MemberDao sk값 : "+sk);
		System.out.println("MemberDao sv값 : "+sv);
		alm = new ArrayList<Member>();
		conn=ds.getConnection();
		String sql = "select * from member";
		
		if(sk == null & sv == null){
			System.out.println("01조건 sk와 sv 둘다 null");
			pstmt = conn.prepareStatement(sql);
		}else if(sk != null & sv.equals("")){
			System.out.println("02조건 sk 있고 sv 공백");
			pstmt = conn.prepareStatement(sql);
		}else if(sk != null & sv != null){
			System.out.println("03조건 sk 있고 sv 있다");
			pstmt = conn.prepareStatement(sql+" where "+sk+"=?");
			pstmt.setString(1, sv);
		}
		rs = pstmt.executeQuery();
		while(rs.next()){
			m = new Member();
			m.setMemberId(rs.getString("member_id"));
			m.setMemberPw(rs.getString("member_pw"));
			m.setMemberName(rs.getString("member_name"));
			m.setMemberLevel(rs.getString("member_level"));
			m.setMemberSex(rs.getString("member_sex"));
			m.setMemberAddn(rs.getString("member_addn"));
			m.setMemberAdd(rs.getString("member_add"));
			m.setMemberAdds(rs.getString("member_adds"));
			m.setMemberEmail(rs.getString("member_email"));
			m.setMemberPhone(rs.getString("member_phone"));
			m.setMemberMobile(rs.getString("member_mobile"));
			m.setMemberMileage(rs.getString("member_mileage"));
			alm.add(m);
		}
		if (rs != null) try { rs.close(); } catch(SQLException ex) {}
		if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
		if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		return alm;
	}
	
	
	//02 전체회원조회 !!
	public ArrayList<Member> mSelectAll() throws SQLException{
		System.out.println("02 전체회원조회");
		
		conn=ds.getConnection();
		pstmt = conn.prepareStatement(
				"select * from member");
		
		rs = pstmt.executeQuery();
		alm = new ArrayList<Member>();
		while(rs.next()){
			m = new Member();
			m.setMemberId(rs.getString("member_id"));
			m.setMemberPw(rs.getString("member_pw"));
			m.setMemberName(rs.getString("member_name"));
			m.setMemberLevel(rs.getString("member_level"));
			m.setMemberSex(rs.getString("member_sex"));
			m.setMemberAddn(rs.getString("member_addn"));
			m.setMemberAdd(rs.getString("member_add"));
			m.setMemberAdds(rs.getString("member_adds"));
			m.setMemberEmail(rs.getString("member_email"));
			m.setMemberPhone(rs.getString("member_phone"));
			m.setMemberMobile(rs.getString("member_mobile"));
			m.setMemberMileage(rs.getString("member_mileage"));
			alm.add(m);
		}
		if (rs != null) try { rs.close(); } catch(SQLException ex) {}
		if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
		if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		
		return alm;
	}
	
		
	//01 회원가입
	public int mInsert(Member m) throws SQLException{
		System.out.println("01_02입력처리메서드 선언 Mdao.java");
		conn=ds.getConnection();
		pstmt = conn.prepareStatement(
				"insert into member values(?,?,?,?,?,?,?,?,?,?,?,?)");
		pstmt.setString(1, m.getMemberId());
		pstmt.setString(2, m.getMemberPw());
		pstmt.setString(3, m.getMemberName());
		pstmt.setString(4, m.getMemberLevel());
		pstmt.setString(5, m.getMemberSex());
		pstmt.setString(6, m.getMemberAddn());
		pstmt.setString(7, m.getMemberAdd());
		pstmt.setString(8, m.getMemberAdds());
		pstmt.setString(9, m.getMemberEmail());
		pstmt.setString(10, m.getMemberPhone());
		pstmt.setString(11, m.getMemberMobile());
		pstmt.setString(12, m.getMemberMileage());
		rowCount = pstmt.executeUpdate();
		
		if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
		if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		return rowCount;
	}
}

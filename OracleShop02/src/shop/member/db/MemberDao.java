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
		System.out.println("---�����ڸ޼��� Mdao---");
		try{
			Context init = new InitialContext();
			System.out.println("db������ : "+init);
		  	   ds = (DataSource) init.lookup("java:comp/env/jdbc/KsmartDB");
		  	System.out.println("db������ : "+ds);
		}catch(Exception ex){
			System.out.println("DB ���� ���� : " + ex);
			return;
		}
	}
	
	//04 �Ѹ��� ȸ����ȸ
	public Member mSelectOneByKey(String memberId) throws SQLException{
		System.out.println("04 �Ѹ��� ȸ����ȸ");
		
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
	
	//03 ȸ���˻�
	public ArrayList<Member> mSelectSearch(String sk, String sv) throws SQLException{
		System.out.println("03 ȸ���˻�");
		System.out.println("MemberDao sk�� : "+sk);
		System.out.println("MemberDao sv�� : "+sv);
		alm = new ArrayList<Member>();
		conn=ds.getConnection();
		String sql = "select * from member";
		
		if(sk == null & sv == null){
			System.out.println("01���� sk�� sv �Ѵ� null");
			pstmt = conn.prepareStatement(sql);
		}else if(sk != null & sv.equals("")){
			System.out.println("02���� sk �ְ� sv ����");
			pstmt = conn.prepareStatement(sql);
		}else if(sk != null & sv != null){
			System.out.println("03���� sk �ְ� sv �ִ�");
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
	
	
	//02 ��üȸ����ȸ !!
	public ArrayList<Member> mSelectAll() throws SQLException{
		System.out.println("02 ��üȸ����ȸ");
		
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
	
		
	//01 ȸ������
	public int mInsert(Member m) throws SQLException{
		System.out.println("01_02�Է�ó���޼��� ���� Mdao.java");
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

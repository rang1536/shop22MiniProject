package shop.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shop.driver.driverDb.DriverDb;
import shop.member.db.Member;

public class MemberDao {
	DriverDb db;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<Member> memberList;
	Member m;
	int rowCount;
	public MemberDao(){}
	
		
	//08 ȸ������ó��
	public int mDelete(String memberId) throws Exception{
		System.out.println("ȸ������ó��mDelete() ");
		try{
			db = new DriverDb();
			conn=db.driverDbcon();
			
			pstmt = conn.prepareStatement(
					"delete from member where member_id=?");
			pstmt.setString(1,memberId);
			rowCount = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return rowCount;
	}
	
	//07 ȸ����������
	public int mUpdate(Member m) throws Exception{
		System.out.println("ȸ������ó��mUpdate() ");
		try{
			db = new DriverDb();
			conn=db.driverDbcon();
			
			pstmt = conn.prepareStatement(
					"update member set member_name=?,member_addn=?,member_add=?,"
					+ "member_adds=?,member_email=?,member_phone=?,member_mobile=?"
					+ " where member_id = ?");
			pstmt.setString(1, m.getMemberName());
			pstmt.setString(2,m.getMemberAddn());
			pstmt.setString(3, m.getMemberAdd());
			pstmt.setString(4, m.getMemberAdds());
			pstmt.setString(5, m.getMemberEmail());
			pstmt.setString(6, m.getMemberPhone());
			pstmt.setString(7, m.getMemberMobile());
			pstmt.setString(8, m.getMemberId());
			rowCount = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return rowCount;
	}
	
	//06ȸ���˻� �������϶�!
	public ArrayList<Member> mSearchAdmin(Member m) throws Exception{
		System.out.println("06 �������϶� ȸ���˻�");
		
		try{
			memberList = new ArrayList<Member>();
			db = new DriverDb();
			conn=db.driverDbcon();
			
			//ȸ���������� �Է����� �ʾ����� ������ ���Ǿ��� ��ȸ�ϴ� ���������ϰ� ������ ���� ������ ���ǿ� �־� �˻��Ѵ�.
			if(m.getStartDay().equals("") || m.getEndDay().equals("")){
				if(m.getMemberSex() != null){
					pstmt = conn.prepareStatement("select * from member"
							+ " where member_name like ? and member_sex like ?"
							+ " and member_add like ?");
					pstmt.setString(1, "%"+m.getMemberName()+"%");
					pstmt.setString(2, "%"+m.getMemberSex()+"%");
					pstmt.setString(3, "%"+m.getMemberAdd()+"%");
				}else if(m.getMemberSex() == null){
					pstmt = conn.prepareStatement("select * from member"
							+ " where member_name like ?"
							+ " and member_add like ?");
					pstmt.setString(1, "%"+m.getMemberName()+"%");
					pstmt.setString(2, "%"+m.getMemberAdd()+"%");
				}
			}else if(m.getStartDay() != ""){
				if(m.getMemberSex() != null){
					pstmt = conn.prepareStatement("select * from member"
							+ " where member_name like ? and member_sex like ?"
							+ " and member_date between ? and ? and member_add like ?");
					pstmt.setString(1, "%"+m.getMemberName()+"%");
					pstmt.setString(2, "%"+m.getMemberSex()+"%");
					pstmt.setString(3, m.getStartDay());
					pstmt.setString(4, m.getEndDay());
					pstmt.setString(5, "%"+m.getMemberAdd()+"%");
				}else if(m.getMemberSex() == null){
					pstmt = conn.prepareStatement("select * from member"
							+ " where member_name like ?"
							+ " and member_date between ? and ?"
							+ " and member_add like ?");
					pstmt.setString(1, "%"+m.getMemberName()+"%");
					pstmt.setString(2, m.getStartDay());
					pstmt.setString(3, m.getEndDay());
					pstmt.setString(4, "%"+m.getMemberAdd()+"%");
				}
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
				m.setMemberDate(rs.getString("member_date"));
				memberList.add(m);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return memberList;
	}
	//05 �α��� üũ
	public Member mSelectLogin(String memberId,String memberPw) throws Exception{
		System.out.println("05 �α���üũ");
		try{
			db = new DriverDb();
			conn=db.driverDbcon();
			pstmt = conn.prepareStatement(
					"select * from member where member_id = ? and member_pw = ?");
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			rs = pstmt.executeQuery();
			if(rs.next()){
				m = new Member();
				m.setMemberId(rs.getString("member_id"));
				m.setMemberPw(rs.getString("member_pw"));
				m.setMemberLevel(rs.getString("member_level"));
			}else{
				m=new Member();
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		
		return m;
	}
	
	//04 �Ѹ��� ȸ����ȸ
	public Member mSelectOneByKey(String memberId) throws Exception{
		System.out.println("04 �Ѹ��� ȸ����ȸ");
		try{
			db = new DriverDb();
			conn=db.driverDbcon();
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
				m.setMemberDate(rs.getString("member_date"));
			
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return m;
	}
	
	//03 ȸ���˻�
	public ArrayList<Member> mSearchNotAdmin(String memberName, String memberId) throws Exception{
		System.out.println("������ �ƴҶ� ȸ���˻�");
		System.out.println("MemberDao memberName�� : "+memberName);
		System.out.println("MemberDao memberId�� : "+memberId);
		try{
			memberList = new ArrayList<Member>();
			db = new DriverDb();
			conn=db.driverDbcon();
			pstmt = conn.prepareStatement("select * from member"
					+ " where member_name like ? and member_id like ?");
			pstmt.setString(1, "%"+memberName+"%");
			pstmt.setString(2, "%"+memberId+"%");
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
				m.setMemberDate(rs.getString("member_date"));
				memberList.add(m);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return memberList;
	}

	//02 ��üȸ����ȸ !!
	public ArrayList<Member> mSelectAll() throws Exception{
		System.out.println("02 ��üȸ����ȸ");
		try{
			db = new DriverDb();
			conn=db.driverDbcon();
			pstmt = conn.prepareStatement(
					"select * from member");
			
			rs = pstmt.executeQuery();
			memberList = new ArrayList<Member>();
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
				m.setMemberDate(rs.getString("member_date"));
				memberList.add(m);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return memberList;
	}
			
	//01 ȸ������
	public int mInsert(Member m) throws Exception{
		System.out.println("01_02�Է�ó���޼��� ���� Mdao.java");
		try{
			db = new DriverDb();
			conn=db.driverDbcon();
			
			pstmt = conn.prepareStatement(
					"insert into member(member_id,member_pw,member_name,"
					+ "member_level,member_sex,member_addn,member_add,member_adds,"
					+ "member_email,member_phone,member_mobile,member_mileage,member_date)"
					+ " values(?,?,?,?,?,?,?,?,?,?,?,?,now())");
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
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return rowCount;
	}
}

package shop.order.db;

import java.sql.*;

import shop.driver.driverDb.DriverDb;
import shop.member.db.Member;

public class OrderDao {
	DriverDb db;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	Order o;
	
	//01 ������ ���̵�� �ֹ�������ȸ
	public Member oSelectMemberGoods(String memberId) throws Exception{
		System.out.println("01 �ֹ����� ������,��ǰ������ȸ OrderDao!");
		o = new Order();
		try{
			db = new DriverDb();
			conn=db.driverDbcon();
			pstmt = conn.prepareStatement("select * from  "
					+ "where orderMemberId = ?");
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			
			
		}catch(Exception e){
			
		}finally{
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return null;
	}

}

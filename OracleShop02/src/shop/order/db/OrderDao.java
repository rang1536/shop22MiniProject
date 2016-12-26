package shop.order.db;

import java.sql.*;
import java.util.ArrayList;

import shop.driver.driverDb.DriverDb;
import shop.member.db.Member;

public class OrderDao {
	DriverDb db;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	Order order;
	ResultSet imgRs;
	
	//03주문내용 입력하는 매서드(마일리지 적립시)
	public int oInsertSaveMileage(Order order) throws Exception{
		System.out.println("02 주문정보등록 OrderDao");
		int result = 0;
		//System.out.println("OrderDao값 확인 : "+order.getOrderMemberAdd());
		try{
			db = new DriverDb();
			conn=db.driverDbcon();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(
					"insert into orders(order_member_id,order_memo, order_goods_num, order_amount, order_size, order_color, order_sum,order_trade_type, order_trade_date, order_pay_date, order_mileage,order_pay_final, order_member_name, order_member_mobile, order_member_add) values(?,?,?,?,?,?,?,?,now(),now(),?,?,?,?,?)");
			pstmt.setString(1, order.getOrderMemberId());
			pstmt.setString(2, order.getOrderMemo());
			pstmt.setInt(3, order.getOrderGoodsNum());
			pstmt.setInt(4, order.getOrderAmount());
			pstmt.setString(5, order.getOrderSize());
			pstmt.setString(6, order.getOrderColor());
			pstmt.setInt(7, order.getOrderSum());
			pstmt.setString(8, order.getOrderTradeType());
			pstmt.setInt(9, order.getOrderMileage());
			pstmt.setInt(10, order.getOrderPayFinal());
			pstmt.setString(11, order.getOrderMemberName());
			pstmt.setString(12, order.getOrderMemberMobile());
			pstmt.setString(13, order.getOrderMemberAdd());
			result = pstmt.executeUpdate();
			
			//입력 성공시 마일리지+ 하는걸로 구매자정보수정.
			if(result == 1){
				pstmt = conn.prepareStatement(
						"update member set member_mileage = ? where member_id = ?");
				pstmt.setInt(1, order.getOrderMileage());
				pstmt.setString(2, order.getOrderMemberId());
				result = pstmt.executeUpdate();
			}
			conn.commit();
			conn.setAutoCommit(true);
		}catch(Exception e){
			try{conn.rollback();}catch(Exception ignore){};
		}finally{
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return result;
	}
	
	//02 주문내용 입력하는 매서드(마일리지적용시)
	public int oInsertUseMileage(Order order) throws Exception{
		System.out.println("02 주문정보등록 OrderDao");
		int result = 0;
		//System.out.println("OrderDao값 확인 : "+order.getOrderMemberAdd());
		try{
			db = new DriverDb();
			conn=db.driverDbcon();
			pstmt = conn.prepareStatement(
					"insert into orders(order_member_id,order_memo, order_goods_num, order_amount, order_size, order_color, order_sum,order_trade_type, order_trade_date, order_pay_date, order_mileage,order_pay_final, order_member_name, order_member_mobile, order_member_add) values(?,?,?,?,?,?,?,?,now(),now(),?,?,?,?,?)");
			pstmt.setString(1, order.getOrderMemberId());
			pstmt.setString(2, order.getOrderMemo());
			pstmt.setInt(3, order.getOrderGoodsNum());
			pstmt.setInt(4, order.getOrderAmount());
			pstmt.setString(5, order.getOrderSize());
			pstmt.setString(6, order.getOrderColor());
			pstmt.setInt(7, order.getOrderSum());
			pstmt.setString(8, order.getOrderTradeType());
			pstmt.setInt(9, order.getOrderMileage());
			pstmt.setInt(10, order.getOrderPayFinal());
			pstmt.setString(11, order.getOrderMemberName());
			pstmt.setString(12, order.getOrderMemberMobile());
			pstmt.setString(13, order.getOrderMemberAdd());
			result = pstmt.executeUpdate();
			
		}catch(Exception e){
			
		}finally{
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return result;
	}

	
	//01 구매자 아이디로 주문내역조회
	public ArrayList<Order> oSelectOrderByMemberId(String memberId) throws Exception{
		System.out.println("01 구매자 아이디로 주문내역조회 OrderDao!");
		ArrayList<Order> orderList = new ArrayList<Order>();
		try{
			db = new DriverDb();
			conn=db.driverDbcon();
			pstmt = conn.prepareStatement("select * from orders "
					+ "where order_member_id = ?");
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				order = new Order();
				order.setOrderAmount(rs.getInt("order_amount"));
				order.setOrderColor(rs.getString("order_color"));
				order.setOrderGoodsNum(rs.getInt("order_goods_num"));
				order.setOrderMemberMobile(rs.getString("order_member_mobile"));
				order.setOrderMemberAdd(rs.getString("order_member_add"));
				order.setOrderTradeType(rs.getString("order_trade_type"));
				order.setOrderPayFinal(rs.getInt("order_pay_final"));
				order.setOrderSize(rs.getString("order_size"));
				//이미지파일 불러오기!
				pstmt = conn.prepareStatement("select goods_img from goods "
						+ "where goods_num = ? and order_member_id=?");
				imgRs = pstmt.executeQuery();
				order.setOrderImg(imgRs.getString("order_img"));
				orderList.add(order);
			}
			
		}catch(Exception e){
			
		}finally{
			if (imgRs != null) try { rs.close(); } catch(SQLException ex) {}
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return orderList;
	}

}

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
	
	//06 관리자로그인시 처리상태 업데이트 매서드
	public int oUpdateTradeState(int orderNum, String orderTradeState) throws Exception{
		System.out.println("06 처리상태 업데이트 OrderDao!");
		int result=0;
		try{
			db = new DriverDb();
			conn=db.driverDbcon();
			pstmt = conn.prepareStatement("update orders set order_trade_state = ? where order_num = ?");
			pstmt.setString(1, orderTradeState);
			pstmt.setInt(2, orderNum);
			result = pstmt.executeUpdate();
			System.out.println("수정결과 확인 : "+result);
		}catch(Exception e){
			
		}finally{
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return result;
	}
	
	//05 모든 주문정보 검색 매서드
	public ArrayList<Order> oSelectAllOrder() throws Exception{
		System.out.println("05 모든 주문내역조회 OrderDao!");
		ArrayList<Order> orderList = new ArrayList<Order>();
		try{
			db = new DriverDb();
			conn=db.driverDbcon();
			pstmt = conn.prepareStatement("select * from orders");
			rs = pstmt.executeQuery();
			while(rs.next()){
				order = new Order();
				order.setOrderNum(rs.getInt("order_num"));
				order.setOrderAmount(rs.getInt("order_amount"));
				order.setOrderColor(rs.getString("order_color"));
				order.setOrderGoodsNum(rs.getInt("order_goods_num"));
				order.setOrderMemberMobile(rs.getString("order_member_mobile"));
				order.setOrderMemberAdd(rs.getString("order_member_add"));
				order.setOrderTradeType(rs.getString("order_trade_type"));
				order.setOrderPayFinal(rs.getInt("order_pay_final"));
				order.setOrderSize(rs.getString("order_size"));
				order.setOrderMemberId(rs.getString("order_member_id"));
				order.setOrderMemberName(rs.getString("order_member_name"));
				order.setOrderMemo(rs.getString("order_memo"));
				order.setOrderTradeDate(rs.getString("order_trade_date"));
				order.setOrderTradeState(rs.getString("order_trade_state"));
				
				orderList.add(order);
			}
		}catch(Exception e){
			
		}finally{
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return orderList;
	}
	
	//04 주문번호로 주문정보 검색 매서드
	public Order oSelectOrderByOrderNum(int orderNum) throws Exception{
		System.out.println("04 주문번호로 주문내역조회 OrderDao!");
		// System.out.println("주문번호값 넘어온거 확인: "+orderNum);
		try{
			db = new DriverDb();
			conn=db.driverDbcon();
			pstmt = conn.prepareStatement("select * from orders where order_num = ?");
			pstmt.setInt(1, orderNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				order = new Order();
				order.setOrderNum(rs.getInt("order_num"));
				order.setOrderAmount(rs.getInt("order_amount"));
				order.setOrderColor(rs.getString("order_color"));
				order.setOrderGoodsNum(rs.getInt("order_goods_num"));
				order.setOrderMemberMobile(rs.getString("order_member_mobile"));
				order.setOrderMemberAdd(rs.getString("order_member_add"));
				order.setOrderTradeType(rs.getString("order_trade_type"));
				order.setOrderPayFinal(rs.getInt("order_pay_final"));
				order.setOrderSize(rs.getString("order_size"));
				order.setOrderMemberId(rs.getString("order_member_id"));
				order.setOrderMemberName(rs.getString("order_member_name"));
				order.setOrderMemo(rs.getString("order_memo"));
				order.setOrderTradeDate(rs.getString("order_trade_date"));
				
			}
		}catch(Exception e){
			
		}finally{
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return order;
	}
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
		// System.out.println("맴버아이디값 넘어온거 확인: "+memberId);
		ArrayList<Order> orderList = new ArrayList<Order>();
		try{
			db = new DriverDb();
			conn=db.driverDbcon();
			pstmt = conn.prepareStatement("select * from orders where order_member_id = ?");
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			/*rs.last();
			System.out.println("첫쿼리 실행결과 확인 : "+rs.getRow());
			아이디 rang2일때 5개 조회결과 확인.*/
			while(rs.next()){
				order = new Order();
				order.setOrderNum(rs.getInt("order_num"));
				order.setOrderAmount(rs.getInt("order_amount"));
				order.setOrderColor(rs.getString("order_color"));
				order.setOrderGoodsNum(rs.getInt("order_goods_num"));
				order.setOrderMemberMobile(rs.getString("order_member_mobile"));
				order.setOrderMemberAdd(rs.getString("order_member_add"));
				order.setOrderTradeType(rs.getString("order_trade_type"));
				order.setOrderPayFinal(rs.getInt("order_pay_final"));
				order.setOrderSize(rs.getString("order_size"));
				
				//System.out.println(order);
				orderList.add(order);
			}
		}catch(Exception e){
			
		}finally{
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return orderList;
	}

}

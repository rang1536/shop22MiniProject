package shop.order.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.goods.db.Goods;
import shop.goods.db.GoodsDao;
import shop.order.db.Order;
import shop.order.db.OrderDao;

public class OList implements Action {

	@Override
	public OActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Order order = new Order();
		OrderDao orderDao = new OrderDao();
		ArrayList<Order> orderList = new ArrayList<Order>();
		HttpSession session =request.getSession();
		String sessionLevel = (String)session.getAttribute("sessionLevel");
		
		//관리자일때와 구매자일때 분기문을 만들어준다. 관리자일때는 모든 주문내역조회, 구매자일때는 구매자로 검색되는 주문내역만 조회.
		// 1. 관리자일때
		
		if(sessionLevel.equals("관리자")){
		//모든 주문내역을 조회하는 매서드 호출!
			orderList = orderDao.oSelectAllOrder();
			System.out.println("주문내역 리턴값 사이즈 관리자모드 : "+orderList.size());
			
		}else{
		//2. 관리자가 아닐때!
		// 주문확인을 위해 세션에 구매자 아이디를 가져온다
			String sessionId = (String)session.getAttribute("sessionId");
			//System.out.println("새션아이디확인 : "+sessionId);
			
			//주문정보를 가져온다.
			orderList = orderDao.oSelectOrderByMemberId(sessionId);
			//System.out.println("주문내역 리턴값 사이즈 : "+orderList.size());
		}
		
		//이미지파일 불러오기~
		Goods goods = new Goods();
		GoodsDao goodsDao = new GoodsDao();
		for(int i=0; i< orderList.size(); i++){
			goods = goodsDao.gSelectOne(orderList.get(i).getOrderGoodsNum());
			orderList.get(i).setOrderImg(goods.getGoodsImg());
			orderList.get(i).setOrderGoodsName(goods.getGoodsName());
			// System.out.println(orderList.get(i).getOrderImg());
		}
		
		// 주문정보 리퀘스트에 세팅함.
		request.setAttribute("orderList", orderList);
		
		// view로 이동경로 세팅함.
		
		OActionForward oforward = new OActionForward();
		oforward.setRedirect(false);
		oforward.setPath("/order/oList.jsp");
		return oforward;
	}

}

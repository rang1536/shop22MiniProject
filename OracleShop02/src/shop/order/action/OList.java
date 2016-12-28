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
		// 주문확인을 위해 세션에 구매자 아이디를 가져온다
		HttpSession session = request.getSession();
		String sessionId = (String)session.getAttribute("sessionId");
		System.out.println("새션아이디확인 : "+sessionId);
		
		//주문정보를 가져온다.
		Order order = new Order();
		OrderDao orderDao = new OrderDao();
		ArrayList<Order> orderList = new ArrayList<Order>();
		
		orderList = orderDao.oSelectOrderByMemberId(sessionId);
		System.out.println("주문내역 리턴값 사이즈 : "+orderList.size());
		
		//이미지파일 불러오기~
		Goods goods = new Goods();
		GoodsDao goodsDao = new GoodsDao();
		for(int i=0; i< orderList.size(); i++){
			goods = goodsDao.gSelectOne(orderList.get(i).getOrderGoodsNum());
			orderList.get(i).setOrderImg(goods.getGoodsImg());
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

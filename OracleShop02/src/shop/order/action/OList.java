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
		// �ֹ�Ȯ���� ���� ���ǿ� ������ ���̵� �����´�
		HttpSession session = request.getSession();
		String sessionId = (String)session.getAttribute("sessionId");
		System.out.println("���Ǿ��̵�Ȯ�� : "+sessionId);
		
		//�ֹ������� �����´�.
		Order order = new Order();
		OrderDao orderDao = new OrderDao();
		ArrayList<Order> orderList = new ArrayList<Order>();
		
		orderList = orderDao.oSelectOrderByMemberId(sessionId);
		System.out.println("�ֹ����� ���ϰ� ������ : "+orderList.size());
		
		//�̹������� �ҷ�����~
		Goods goods = new Goods();
		GoodsDao goodsDao = new GoodsDao();
		for(int i=0; i< orderList.size(); i++){
			goods = goodsDao.gSelectOne(orderList.get(i).getOrderGoodsNum());
			orderList.get(i).setOrderImg(goods.getGoodsImg());
			// System.out.println(orderList.get(i).getOrderImg());
		}
		
		// �ֹ����� ������Ʈ�� ������.
		request.setAttribute("orderList", orderList);
		
		// view�� �̵���� ������.
		
		OActionForward oforward = new OActionForward();
		oforward.setRedirect(false);
		oforward.setPath("/order/oList.jsp");
		return oforward;
	}

}

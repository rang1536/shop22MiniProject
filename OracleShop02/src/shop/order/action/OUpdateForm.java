package shop.order.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.goods.db.Goods;
import shop.goods.db.GoodsDao;
import shop.order.db.Order;
import shop.order.db.OrderDao;

public class OUpdateForm implements Action {

	@Override
	public OActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Order order = new Order();
		OrderDao orderDao = new OrderDao();
		
		//�ŷ�ó�����°� �Ѿ�Դ��� Ȯ���Ͽ� �Ѿ�Դٸ� �ֹ������� ������Ʈó�� ���ش�.
		if(request.getParameter("tradeState") != null){
			
		}
		
		//�ֹ���ȣ Ȯ���ϰ� �ֹ���ȣ�� �ֹ������� �ҷ��´�.	
		System.out.println("�ֹ���ȣ Ȯ�� : "+request.getParameter("orderNum"));
		int orderNum = Integer.parseInt(request.getParameter("orderNum"));
		
		
		
		order = orderDao.oSelectOrderByOrderNum(orderNum);
		
		//��ǰ���� �ҷ�����~
		Goods goods = new Goods();
		GoodsDao goodsDao = new GoodsDao();
		goods = goodsDao.gSelectOne(order.getOrderGoodsNum());
		
		
		//������Ʈ�� order, ��ǰ��������
		request.setAttribute("order", order);
		request.setAttribute("goods", goods);
		
		//viewȭ������ �������Ѵ�.
		OActionForward oforward = new OActionForward();
		oforward.setRedirect(false);
		oforward.setPath("/order/oUpdateForm.jsp");
		return oforward;
	}

}

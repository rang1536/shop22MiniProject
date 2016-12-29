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
		OActionForward oforward = new OActionForward();
		
		//�ŷ�ó�����°� �Ѿ�Դ��� Ȯ���Ͽ� �Ѿ�Դٸ� �ֹ������� ������Ʈó�� ���ش�.
		if(request.getParameter("tradeState") != null){
			int orderNum = Integer.parseInt(request.getParameter("orderNum"));
			System.out.println("ó������Ȯ�� �ֹ��ѹ��� : " + orderNum);
			
			String orderTradeState =request.getParameter("tradeState"); 
			System.out.println("ó������ �Ѿ�°� Ȯ�� :"+orderTradeState);
			int result = orderDao.oUpdateTradeState(orderNum, orderTradeState);
			//System.out.println("�ŷ�ó������ ������Ʈ ���ϰ� Ȯ�� : "+result);
			
			//�ٽ� ����Ʈ�� �����̷�Ʈ�Ѵ�.
			oforward.setRedirect(true);
			oforward.setPath("/OList.ord");
		}else{
			
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
			oforward.setRedirect(false);
			oforward.setPath("/order/oUpdateForm.jsp");
		}
		return oforward;
	}

}

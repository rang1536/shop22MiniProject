package shop.order.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.goods.db.Goods;
import shop.order.db.Order;
import shop.order.db.OrderDao;

public class OInsertAction implements Action {

	@Override
	public OActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// ������ �Էµ� �� �޾ƿ���. ȸ�������� ������������� �����Ƿ� �Է°� �������� ��ǰ������ ����,�÷��� ���û��� ���� ������������ ��ǰ ��ȣ�� �����´�.
		
		int orderGoodsNum = Integer.parseInt(request.getParameter("goodsNum"));
		String orderMemberId = request.getParameter("orderMemberId");
		String orderMemberName = request.getParameter("orderMemberName");
		String orderMemberAdd = request.getParameter("orderMemberAdds")
			+request.getParameter("orderMemberAdd")
			+request.getParameter("orderMemberAdds");
		String orderMemberMobile = request.getParameter("orderMemberMobile");
		String orderMemo = request.getParameter("orderMemo");
		String orderTradeType = request.getParameter("tradeType");
		int orderSum = Integer.parseInt(request.getParameter("goodsPrice"))
			* Integer.parseInt(request.getParameter("goodsAmount"));
		String orderSize = request.getParameter("orderGoodsSize");
		String orderColor = request.getParameter("orderGoodsColor");
		int orderAmount = Integer.parseInt(request.getParameter("goodsAmount"));
		int orderPrice = Integer.parseInt(request.getParameter("goodsPrice"));
		int orderMileage = orderPrice / 10;
		
		/* ���������ݾ��� ���ϸ���"����","����"���� �����ͼ� ���ǹ����� "����"��  orderSum���� ���ϸ��� �ݾ��� ���ݾ����� �ϰ� "����"�� orderSum�� ���������ݾ��̸�, 
		 * ���ϸ����� ���� �ɹ����̺� �ش籸���ڿ��� updateó�����ش�.
		 */
		String choiceMileage = request.getParameter("choiceMileage");
		
		// OrderŸ�� ��ü�� ����� �Է¹��� ���� �������ش�.
		
		Order order = new Order();
		OrderDao orderDao = new OrderDao();
		int orderPayFinal = 0;
		
		order.setOrderGoodsNum(orderGoodsNum);
		order.setOrderMemberId(orderMemberId);
		order.setOrderMemberName(orderMemberName);
		order.setOrderMemberAdd(orderMemberAdd);
		order.setOrderMemberMobile(orderMemberMobile);
		order.setOrderMemo(orderMemo);
		order.setOrderTradeType(orderTradeType);
		order.setOrderSum(orderSum);
		order.setOrderSize(orderSize);
		order.setOrderColor(orderColor);
		order.setOrderAmount(orderAmount);
		order.setOrderPrice(orderPrice);
		order.setOrderMileage(orderMileage);
		
		// ���ϸ��� ���ÿ��ε��� �����ݾ��� ����Ͽ� �������ְ� ���� �������ش�.
		if(choiceMileage.equals("����")){
			orderPayFinal = orderSum - orderMileage;
		}else if(choiceMileage.equals("����")){
			orderPayFinal = orderSum;
		}
		order.setOrderPayFinal(orderPayFinal);
		
		// ������ ������ DB�� �Է��Ѵ�.
		
		
		return null;
	}

}

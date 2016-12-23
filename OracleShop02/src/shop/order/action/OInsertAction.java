package shop.order.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.goods.db.Goods;
import shop.member.db.Member;
import shop.member.db.MemberDao;
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
		int orderMileage = orderSum / 10;
		
		/*System.out.println("�Է°�Ȯ�� : " +orderGoodsNum+","+orderMemberId+","+orderMemberName+","+orderMemberAdd+","+
				orderMemberMobile+","+orderMemo+","+orderTradeType+","+orderSum+","+orderSize+","+orderColor+","+orderAmount
				+","+orderPrice+","+orderMileage);*/
		
		/* ���������ݾ��� ���ϸ���"����","����"���� �����ͼ� ���ǹ����� "����"��  orderSum���� ���ϸ��� �ݾ��� ���ݾ����� �ϰ� "����"�� orderSum�� ���������ݾ��̸�, 
		 * ���ϸ����� ���� �ɹ����̺� �ش籸���ڿ��� updateó�����ش�.
		 */
		String choiceMileage = request.getParameter("choiceMileage");
		// System.out.println(choiceMileage);
		// OrderŸ�� ��ü�� ����� �Է¹��� ���� �������ش�.
		
		Order order = new Order();
		Member member = new Member();
		OrderDao orderDao = new OrderDao();
		MemberDao memberDao = new MemberDao();
		
		// ���ϸ��� ������ ���� ���űݾ��� ���ϸ��� ������ ���� �������� ���� ���ϸ��� �����ݾ��� Ȯ���� ���´�
		member = memberDao.mSelectOneByKey(orderMemberId);
		int memberMileage = Integer.parseInt(member.getMemberMileage());
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
				
		// ���ϸ��� ���ÿ��ε��� �����ݾ��� ����Ͽ� �������ְ� ���� �������ش�.
		
		// ���ϸ��� ���뼱�ý� �����ݾ׿��� ���ϸ��� ���ݾ����� ����Ͽ� �������ϰ� �ֹ�ó��
		if(choiceMileage.equals("����")){
			orderPayFinal = orderSum - orderMileage;
			order.setOrderPayFinal(orderPayFinal);
			order.setOrderMileage(orderMileage);
			
			//System.out.println("���������ݾ� : "+orderPayFinal);
			int result = orderDao.oInsertUseMileage(order);
			
		// �������ý� ������ ���̵� ���ϸ��� ���������ش�
		}else if(choiceMileage.equals("����")){
			orderPayFinal = orderSum;
			order.setOrderPayFinal(orderPayFinal);
			order.setOrderMileage(orderMileage+memberMileage);
			
			//System.out.println("���������ݾ� : "+orderPayFinal);
			int result = orderDao.oInsertSaveMileage(order);
		}
	
		// �ֹ��Ϸ� �������� ���������ݾװ� ���ϸ����ݾ� ����,���� ���� üũ ���� �����ϰ� view�� �������Ѵ�.
		request.setAttribute("orderPayFinal", orderPayFinal);
		request.setAttribute("choiceMileage", choiceMileage);
		request.setAttribute("memberId", orderMemberId);
		
		OActionForward oforward = new OActionForward();
		oforward.setRedirect(false);
		oforward.setPath("/order/OrderInsertResult.jsp");
		return oforward;
	}

}

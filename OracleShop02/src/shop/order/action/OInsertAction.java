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
		
		// 폼에서 입력된 값 받아오기. 회원정보는 변경사항있을수 있으므로 입력값 가져오고 상품정보는 수량,컬러등 선택사항 제외 변동없음으로 상품 번호만 가져온다.
		
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
		
		/*System.out.println("입력값확인 : " +orderGoodsNum+","+orderMemberId+","+orderMemberName+","+orderMemberAdd+","+
				orderMemberMobile+","+orderMemo+","+orderTradeType+","+orderSum+","+orderSize+","+orderColor+","+orderAmount
				+","+orderPrice+","+orderMileage);*/
		
		/* 최종결제금액은 마일리지"적용","적립"으로 가져와서 조건문으로 "적용"시  orderSum에서 마일리지 금액을 뺀금액으로 하고 "적립"시 orderSum이 최종결제금액이며, 
		 * 마일리지는 따로 맴버테이블에 해당구매자에게 update처리해준다.
		 */
		String choiceMileage = request.getParameter("choiceMileage");
		// System.out.println(choiceMileage);
		// Order타입 객체를 만들어 입력받은 값을 세팅해준다.
		
		Order order = new Order();
		Member member = new Member();
		OrderDao orderDao = new OrderDao();
		MemberDao memberDao = new MemberDao();
		
		// 마일리지 적립시 현재 구매금액의 마일리지 적립을 위해 구매자의 현재 마일리지 적립금액을 확인해 놓는다
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
				
		// 마일리지 선택여부따라 최종금액을 계산하여 대입해주고 값을 세팅해준다.
		
		// 마일리지 적용선택시 최종금액에서 마일리지 뺀금액으로 계산하여 값세팅하고 주문처리
		if(choiceMileage.equals("적용")){
			orderPayFinal = orderSum - orderMileage;
			order.setOrderPayFinal(orderPayFinal);
			order.setOrderMileage(orderMileage);
			
			//System.out.println("최종결제금액 : "+orderPayFinal);
			int result = orderDao.oInsertUseMileage(order);
			
		// 적립선택시 구매자 아이디에 마일리지 적립시켜준다
		}else if(choiceMileage.equals("적립")){
			orderPayFinal = orderSum;
			order.setOrderPayFinal(orderPayFinal);
			order.setOrderMileage(orderMileage+memberMileage);
			
			//System.out.println("최종결제금액 : "+orderPayFinal);
			int result = orderDao.oInsertSaveMileage(order);
		}
	
		// 주문완료 페이지에 최종결제금액과 마일리지금액 적립,적용 여부 체크 위해 세팅하고 view로 포워딩한다.
		request.setAttribute("orderPayFinal", orderPayFinal);
		request.setAttribute("choiceMileage", choiceMileage);
		request.setAttribute("memberId", orderMemberId);
		
		OActionForward oforward = new OActionForward();
		oforward.setRedirect(false);
		oforward.setPath("/order/OrderInsertResult.jsp");
		return oforward;
	}

}

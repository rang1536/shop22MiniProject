package shop.order.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.goods.db.Goods;
import shop.goods.db.GoodsColor;
import shop.goods.db.GoodsDao;
import shop.goods.db.GoodsSize;
import shop.member.db.Member;
import shop.member.db.MemberDao;
import shop.order.db.Order;
import shop.order.db.OrderDao;

public class OInsert implements Action {

	@Override
	public OActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("�ֹ���� execute�ż���!");
		
		// ������ ������ Ȯ���ϱ� ���� session�� �α������� ������� ���̵��� �޾ƿ´�.
		
		HttpSession session = request.getSession();
		String sessionId = (String)session.getAttribute("sessionId");
		System.out.println("���� ���ŵ���ҷ��� ������ ���̵� : "+sessionId);
		
		// ��ǰ ������ Ȯ���ϱ� ���� ��ǰ�󼼺��⿡�� �����ϱ� �������� ���õ� ��ǰ��ȣ�� �޾ƿ´�
		
		int goodsNum = Integer.parseInt(request.getParameter("goodsNum"));
		System.out.println("���ż����� ��ǰ��ȣ : "+goodsNum);
		
		// ���Ž�û ���� ������ ������ ��ǰ������ �ѷ��ֱ� ���� �� ������ ��ȸ�ϴ� �ż��带 ȣ���Ѵ�.
		
			//1.���������� ��ȸ�� request������ ������.
		MemberDao mdao = new MemberDao();
		Member member = new Member();
		member = mdao.mSelectOneByKey(sessionId);
		request.setAttribute("member", member);
		
			//2.��ǰ���� ��ȸ
		GoodsDao gDao = new GoodsDao();
		Goods goods = new Goods();
		goods = gDao.gSelectOne(goodsNum);
		request.setAttribute("goods", goods);
			
			//3.��ǰ�÷�,������ ��ȸ
		ArrayList<GoodsColor> goodsColor = new ArrayList<GoodsColor>();
		ArrayList<GoodsSize> goodsSize = new ArrayList<GoodsSize>();
		goodsColor = gDao.selectColor();
		goodsSize = gDao.selectSize(goods.getGoodsCate());
		
		request.setAttribute("goodsColor", goodsColor);
		request.setAttribute("goodsSize", goodsSize);
		
		
		// ��ȸ������ �ѷ���� �ϹǷ� oinsertForm.jsp�� �������Ѵ�.
		
		OActionForward oforward = new OActionForward();
		oforward.setRedirect(false);
		oforward.setPath("/order/oInsertForm.jsp");
		return oforward;
		
	}

}

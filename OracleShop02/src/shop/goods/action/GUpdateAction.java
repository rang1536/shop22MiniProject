package shop.goods.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.goods.db.Goods;
import shop.goods.db.GoodsDao;

public class GUpdateAction implements Action{
	@Override
	public GActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(request.getParameter("goodsNum"));
		int goodsNum = Integer.parseInt(request.getParameter("goodsNum"));
		String goodsMemberId = request.getParameter("goodsMemberId");
		String goodsName = request.getParameter("goodsName");
		String goodsCate = request.getParameter("goodsCate");
		int goodsPrice = Integer.parseInt(request.getParameter("goodsPrice"));
		String goodsColor = request.getParameter("goodsColor");
		String goodsSize = request.getParameter("goodsSize");
		int goodsAmount = Integer.parseInt(request.getParameter("goodsAmount"));
		String goodsImg = request.getParameter("goodsImg");
		String goodsDetail = request.getParameter("goodsDetail");
		System.out.println("������Ʈ���� �� �޾ƿ°� Ȯ�� goodsDetail : "+goodsDetail);
		System.out.println("������Ʈ���� �� �޾ƿ°� Ȯ�� goodsAmount : "+goodsAmount);
		System.out.println("������Ʈ���� �� �޾ƿ°� Ȯ�� goodsCate : "+goodsCate);
		
		Goods g = new Goods();
		g.setGoodsNum(goodsNum);
		g.setGoodsMemberId(goodsMemberId);
		g.setGoodsName(goodsName);
		g.setGoodsCate(goodsCate);
		g.setGoodsPrice(goodsPrice);
		g.setGoodsColor(goodsColor);
		g.setGoodsSize(goodsSize);
		g.setGoodsAmount(goodsAmount);
		g.setGoodsImg(goodsImg);
		g.setGoodsDetail(goodsDetail);
		System.out.println("goods ��ü�� �� ���� Ȯ�� : "+goodsMemberId);
		System.out.println("goods ��ü�� �� ���� Ȯ�� : "+goodsPrice);
		System.out.println("goods ��ü�� �� ���� Ȯ�� : "+goodsDetail);
		
		GoodsDao dao = new GoodsDao();
		int rowCount = dao.gUpdate(g);
		System.out.println("������Ʈ Ȯ�� :"+ rowCount);

		GActionForward gforward = new GActionForward();
		gforward.setRedirect(true);
		gforward.setPath(request.getContextPath()+"/goods/gList.goo");
		
		
		
		
		return gforward;
	}

}

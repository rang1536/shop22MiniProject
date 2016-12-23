package shop.goods.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import shop.goods.db.Goods;
import shop.goods.db.GoodsDao;

public class GUpdateAction implements Action{
	@Override
	public GActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("GUpdateAction.java ����");
		
		Part part = request.getPart("goodsImg");
		String filename = part.getSubmittedFileName();
		System.out.println("filename Ȯ�� :"+ filename);
		System.out.println(request.getParameter("goodsNum"));
		int goodsNum = Integer.parseInt(request.getParameter("goodsNum"));
		String goodsMemberId = request.getParameter("goodsMemberId");
		String goodsName = request.getParameter("goodsName");
		int goodsPrice = Integer.parseInt(request.getParameter("goodsPrice"));
		int goodsColor = Integer.parseInt(request.getParameter("goodsColor"));
		int goodsSize = Integer.parseInt(request.getParameter("goodsSize"));
		int goodsAmount = Integer.parseInt(request.getParameter("goodsAmount"));
		String goodsDetail = request.getParameter("goodsDetail");
		System.out.println("������Ʈ���� �� �޾ƿ°� Ȯ�� goodsDetail : "+goodsDetail);
		System.out.println("������Ʈ���� �� �޾ƿ°� Ȯ�� goodsAmount : "+goodsAmount);
		
		Goods g = new Goods();
		g.setGoodsNum(goodsNum);
		g.setGoodsMemberId(goodsMemberId);
		g.setGoodsName(goodsName);
		g.setGoodsPrice(goodsPrice);
		g.setGoodsColor(goodsColor);
		g.setGoodsSize(goodsSize);
		g.setGoodsAmount(goodsAmount);
		g.setGoodsImg(filename);
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

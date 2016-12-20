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
		System.out.println("리퀘스트에서 값 받아온거 확인 goodsDetail : "+goodsDetail);
		System.out.println("리퀘스트에서 값 받아온거 확인 goodsAmount : "+goodsAmount);
		System.out.println("리퀘스트에서 값 받아온거 확인 goodsCate : "+goodsCate);
		
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
		System.out.println("goods 객체에 값 세팅 확인 : "+goodsMemberId);
		System.out.println("goods 객체에 값 세팅 확인 : "+goodsPrice);
		System.out.println("goods 객체에 값 세팅 확인 : "+goodsDetail);
		
		GoodsDao dao = new GoodsDao();
		int rowCount = dao.gUpdate(g);
		System.out.println("업데이트 확인 :"+ rowCount);

		GActionForward gforward = new GActionForward();
		gforward.setRedirect(true);
		gforward.setPath(request.getContextPath()+"/goods/gList.goo");
		
		
		
		
		return gforward;
	}

}

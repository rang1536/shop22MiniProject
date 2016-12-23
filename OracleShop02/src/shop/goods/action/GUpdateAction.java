package shop.goods.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import shop.goods.db.Goods;
import shop.goods.db.GoodsDao;

public class GUpdateAction implements Action{
	@Override
	public GActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("GUpdateAction.java 실행");
		
		Part part = request.getPart("goodsImg");
		String filename = part.getSubmittedFileName();
		System.out.println("filename 확인 :"+ filename);
		System.out.println(request.getParameter("goodsNum"));
		int goodsNum = Integer.parseInt(request.getParameter("goodsNum"));
		String goodsMemberId = request.getParameter("goodsMemberId");
		String goodsName = request.getParameter("goodsName");
		int goodsPrice = Integer.parseInt(request.getParameter("goodsPrice"));
		int goodsColor = Integer.parseInt(request.getParameter("goodsColor"));
		int goodsSize = Integer.parseInt(request.getParameter("goodsSize"));
		int goodsAmount = Integer.parseInt(request.getParameter("goodsAmount"));
		String goodsDetail = request.getParameter("goodsDetail");
		System.out.println("리퀘스트에서 값 받아온거 확인 goodsDetail : "+goodsDetail);
		System.out.println("리퀘스트에서 값 받아온거 확인 goodsAmount : "+goodsAmount);
		
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

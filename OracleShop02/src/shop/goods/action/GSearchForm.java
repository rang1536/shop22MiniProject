package shop.goods.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.goods.db.Goods;
import shop.goods.db.GoodsDao;

public class GSearchForm implements Action{
	
	@Override
	public GActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String goodsCate = request.getParameter("goodsCate");
		String goodsName = request.getParameter("goodsName");
		
		GoodsDao dao = new GoodsDao();
		ArrayList<Goods> goods = dao.gSearch(goodsCate, goodsName);
		System.out.println("조회결과 확인 : "+goods);
		request.setAttribute("searchGoods", goods);
		
		
		
		GActionForward gforward = new GActionForward();
		gforward.setRedirect(false);
		gforward.setPath("/goods/gSearchList.jsp");
		
		return gforward;
	}

}

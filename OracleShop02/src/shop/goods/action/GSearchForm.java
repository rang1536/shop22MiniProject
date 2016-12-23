package shop.goods.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.goods.db.Goods;
import shop.goods.db.GoodsCate;
import shop.goods.db.GoodsDao;

public class GSearchForm implements Action{
	
	@Override
	public GActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int goodsCate = Integer.parseInt(request.getParameter("goodsCate"));
		String goodsName = request.getParameter("goodsName");
		
		GoodsDao dao = new GoodsDao();
		ArrayList<Goods> goods = dao.gSearch(goodsCate, goodsName);
		ArrayList<GoodsCate> arrayListgoodsCate = dao.selectCate();
		
		System.out.println("조회결과 확인 : "+goods);
		
		request.setAttribute("goodsList", goods);
		request.setAttribute("goodsCate", arrayListgoodsCate);
		
		GActionForward gforward = new GActionForward();
		gforward.setRedirect(false);
		gforward.setPath("/goods/gList.jsp");
		
		return gforward;
	}

}

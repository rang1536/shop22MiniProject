package shop.goods.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.goods.db.GoodsCate;
import shop.goods.db.GoodsColor;
import shop.goods.db.GoodsDao;
import shop.goods.db.GoodsSize;

public class GInsertForm implements Action{

	@Override
	public GActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		GoodsDao dao = new GoodsDao();
		ArrayList<GoodsCate> cate = dao.selectCate();
		ArrayList<GoodsColor> color = dao.selectColor();
		ArrayList<GoodsSize> size = dao.selectSize();
	
		request.setAttribute("cate", cate);
		request.setAttribute("color", color);
		request.setAttribute("size", size);
		

		GActionForward gforward = new GActionForward();
		gforward.setRedirect(false);
		gforward.setPath("/goods/gInsertForm.jsp");
		
		
		
		return gforward;
	}
}

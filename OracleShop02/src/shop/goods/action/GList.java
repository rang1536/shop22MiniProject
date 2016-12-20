package shop.goods.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.goods.db.Goods;
import shop.goods.db.GoodsDao;

public class GList implements Action {
	
	@Override
	public GActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		

		
		System.out.println("GLIST EXECUTE ����");
		GoodsDao dao = new GoodsDao();
		ArrayList<Goods> goodsList = dao.gAllSelect();
		request.setAttribute("goodsList", goodsList);
		
		GActionForward gforward = new GActionForward();
		gforward.setRedirect(false);
		gforward.setPath("/goods/gList.jsp");
		
		
		
		return gforward;
	}
	
}

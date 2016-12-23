package shop.goods.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.goods.db.Goods;
import shop.goods.db.GoodsCate;
import shop.goods.db.GoodsColor;
import shop.goods.db.GoodsDao;
import shop.goods.db.GoodsSize;

public class GUpdateForm implements Action{
	@Override
	public GActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int goodsNum = Integer.parseInt(request.getParameter("goodsNum"));
		System.out.println("상품수정 클릭시 수정화면에 넘어가는 넘버값 :"+ goodsNum);

		GoodsDao dao = new GoodsDao();
		Goods g = dao.gSelectOne(goodsNum);
		
		
		ArrayList<GoodsColor> color = dao.selectColor();
		ArrayList<GoodsSize> size = dao.selectSizeName(g.getGoodsCate());
		System.out.println("update폼으로 넘어오는 Goods g :" + g);
		request.setAttribute("goods", g);
	
		request.setAttribute("color", color);
		request.setAttribute("size", size);
		
		
		
		GActionForward gforward = new GActionForward();
		gforward.setRedirect(false);
		gforward.setPath("/goods/GUpdateForm.jsp");
		
		return gforward;
	}
}

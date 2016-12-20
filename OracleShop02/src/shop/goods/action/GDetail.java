
package shop.goods.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.goods.db.Goods;
import shop.goods.db.GoodsCate;
import shop.goods.db.GoodsColor;
import shop.goods.db.GoodsDao;
import shop.goods.db.GoodsSize;

public class GDetail implements Action{
	@Override
	public GActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int goodsNum = Integer.parseInt(request.getParameter("goodsNum"));
		System.out.println("�󼼺���� �Ѱܹ��� num�� : "+goodsNum);
		GoodsDao dao = new GoodsDao();
		Goods g = dao.gSelectOne(goodsNum);
		System.out.println("update������ �Ѿ���� Goods g :" + g);
		
		System.out.println("update������ �Ѿ���� Goods g :" + g);
		request.setAttribute("goods", g);
		
		
		
		
		
		GActionForward gforward = new GActionForward();
		gforward.setRedirect(false);
		gforward.setPath("/goods/gDetailForm.jsp");
		
		return gforward;
	}

}

package shop.goods.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import shop.goods.db.Goods;
import shop.goods.db.GoodsCate;
import shop.goods.db.GoodsColor;
import shop.goods.db.GoodsDao;
import shop.goods.db.GoodsSize;

public class GDetail implements Action{
	@Override
	public GActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int goodsNum = Integer.parseInt(request.getParameter("goodsNum"));
		System.out.println("상세보기시 넘겨받은 num값 : "+goodsNum);
		GoodsDao dao = new GoodsDao();
		Goods g = dao.gSelectOne(goodsNum);
		System.out.println("update폼으로 넘어오는 Goods g :" + g);
		request.setAttribute("goods", g);
		
		String goodsSizeName = dao.useDetailselectSize(goodsNum);
		System.out.println("리턴된 goodsSizeName값 확인 : "+ goodsSizeName);
		request.setAttribute("goodsSizeName", goodsSizeName);
		
		GActionForward gforward = new GActionForward();
		gforward.setRedirect(false);
		gforward.setPath("/goods/gDetailForm.jsp");
		
		return gforward;
	}

}

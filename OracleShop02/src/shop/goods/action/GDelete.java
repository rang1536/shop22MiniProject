package shop.goods.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.goods.db.GoodsDao;

public class GDelete implements Action {
	@Override
	public GActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("delete execute메소드 실행");
		int goodsNum = Integer.parseInt(request.getParameter("goodsNum"));
		
		GoodsDao dao = new GoodsDao();
		int rowCount= dao.gDelete(goodsNum);
		System.out.println("delete 확인 : "+rowCount);
	
		GActionForward gforward = new GActionForward();
		gforward.setRedirect(true);
		gforward.setPath(request.getContextPath()+"/goods/gList.goo");
		
		
		return gforward;
	}

}

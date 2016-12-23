package shop.goods.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import shop.goods.db.Goods;
import shop.goods.db.GoodsDao;

public class GInsertAction implements Action {
	
	@Override
	
	public GActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("상품 입력 execute 실행");
		System.out.println("값확인"+request.getParameter("goodsName"));
		System.out.println("값확인"+request.getParameter("goodsCate"));
		
		Part part = request.getPart("goodsImg");
		String dir = "D:/eclipse/Miniproject/shop22MiniProject/OracleShop02/WebContent/imgFile/";
		String filename = part.getSubmittedFileName();
		System.out.println("filename확인 :"+filename);
		part.write(dir+filename);
	   
		
		Goods g = new Goods();
		g.setGoodsMemberId(request.getParameter("goodsMemberId"));
		g.setGoodsName(request.getParameter("goodsName"));
		g.setGoodsCate(Integer.parseInt(request.getParameter("goodsCate")));
		g.setGoodsPrice(Integer.parseInt(request.getParameter("goodsPrice")));
		g.setGoodsColor(Integer.parseInt(request.getParameter("goodsColor")));
		g.setGoodsSize(Integer.parseInt(request.getParameter("goodsSize")));
		g.setGoodsImg(filename);
		g.setGoodsDetail(request.getParameter("goodsDetail"));
		g.setGoodsAmount(Integer.parseInt(request.getParameter("goodsAmount")));
		
		System.out.println("goods insert값 잘 넘겨받아서 세팅됫는지 확인");
		System.out.println(g.getGoodsDetail());
	
		GoodsDao dao = new GoodsDao();
		int rowCount = dao.gInsert(g);
		System.out.println("입력후 rowCount 확인 : "+ rowCount);
		
		GActionForward gforward = new GActionForward();
		gforward.setRedirect(true);
		gforward.setPath(request.getContextPath()+"/goods/gList.goo");
	
		return gforward;
	}
}

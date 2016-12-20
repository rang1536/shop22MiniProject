package shop.goods.action;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import shop.goods.db.Goods;
import shop.goods.db.GoodsDao;

public class GInsert implements Action {
	
	@Override
	
	public GActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("��ǰ �Է� execute ����");
		System.out.println("��Ȯ��"+request.getParameter("goodsName"));
		System.out.println("��Ȯ��"+request.getParameter("goodsCate"));
		 Part part = request.getPart("goodsImg");
		 String dir = request.getContextPath()+"/imgFile";
		 String filename = UUID.randomUUID().toString().replace("-", "");
	   
		
		Goods g = new Goods();
		g.setGoodsMemberId(request.getParameter("goodsMemberId"));
		g.setGoodsName(request.getParameter("goodsName"));
		g.setGoodsCate(Integer.parseInt(request.getParameter("goodsCate")));
		g.setGoodsPrice(Integer.parseInt(request.getParameter("goodsPrice")));
		g.setGoodsColor(request.getParameter("goodsColor"));
		g.setGoodsSize(Integer.parseInt(request.getParameter("goodsSize")));
		g.setGoodsImg(request.getParameter("goodsImg"));
		g.setGoodsDetail(request.getParameter("goodsDetail"));
		g.setGoodsAmount(Integer.parseInt(request.getParameter("goodsAmount")));
		System.out.println("goods insert�� �� �Ѱܹ޾Ƽ� ���õ̴��� Ȯ��");
		System.out.println(g.getGoodsDetail());
		
		
		
		GoodsDao dao = new GoodsDao();
		
		int rowCount = dao.gInsert(g);
		System.out.println("�Է��� rowCount Ȯ�� : "+ rowCount);
		
		GActionForward gforward = new GActionForward();
		gforward.setRedirect(true);
		gforward.setPath(request.getContextPath()+"/goods/gList.goo");
	
		return gforward;
	}
	
}
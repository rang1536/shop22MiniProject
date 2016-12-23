package shop.goods.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import shop.goods.db.Goods;
import shop.goods.db.GoodsDao;

public class GInsertAction implements Action {
	
	@Override
	
	public GActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("��ǰ �Է� execute ����");
		System.out.println("��Ȯ��"+request.getParameter("goodsName"));
		System.out.println("��Ȯ��"+request.getParameter("goodsCate"));
		
		Part part = request.getPart("goodsImg");
		String dir = "D:/eclipse/Miniproject/shop22MiniProject/OracleShop02/WebContent/imgFile/";
		String filename = part.getSubmittedFileName();
		System.out.println("filenameȮ�� :"+filename);
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

package shop.order.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.goods.db.Goods;
import shop.goods.db.GoodsColor;
import shop.goods.db.GoodsDao;
import shop.goods.db.GoodsSize;
import shop.member.db.Member;
import shop.member.db.MemberDao;
import shop.order.db.Order;
import shop.order.db.OrderDao;

public class OInsert implements Action {

	@Override
	public OActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("주문등록 execute매서드!");
		
		// 구매자 정보를 확인하기 위해 session에 로그인중인 사용자의 아이디값을 받아온다.
		
		HttpSession session = request.getSession();
		String sessionId = (String)session.getAttribute("sessionId");
		System.out.println("현재 구매등록할려는 구매자 아이디 : "+sessionId);
		
		// 상품 정보를 확인하기 위해 상품상세보기에서 구매하기 눌럿을때 선택된 상품번호를 받아온다
		
		int goodsNum = Integer.parseInt(request.getParameter("goodsNum"));
		System.out.println("구매선택한 상품번호 : "+goodsNum);
		
		// 구매신청 폼에 구매자 정보와 상품정보를 뿌려주기 위해 위 내용을 조회하는 매서드를 호출한다.
		
			//1.구매자정보 조회후 request영역에 세팅함.
		MemberDao mdao = new MemberDao();
		Member member = new Member();
		member = mdao.mSelectOneByKey(sessionId);
		request.setAttribute("member", member);
		
			//2.상품정보 조회
		GoodsDao gDao = new GoodsDao();
		Goods goods = new Goods();
		goods = gDao.gSelectOne(goodsNum);
		request.setAttribute("goods", goods);
			
			//3.상품컬러,사이즈 조회
		ArrayList<GoodsColor> goodsColor = new ArrayList<GoodsColor>();
		ArrayList<GoodsSize> goodsSize = new ArrayList<GoodsSize>();
		goodsColor = gDao.selectColor();
		goodsSize = gDao.selectSize(goods.getGoodsCate());
		
		request.setAttribute("goodsColor", goodsColor);
		request.setAttribute("goodsSize", goodsSize);
		
		
		// 조회내용을 뿌려줘야 하므로 oinsertForm.jsp로 포워드한다.
		
		OActionForward oforward = new OActionForward();
		oforward.setRedirect(false);
		oforward.setPath("/order/oInsertForm.jsp");
		return oforward;
		
	}

}

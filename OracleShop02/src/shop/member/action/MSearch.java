package shop.member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.member.db.Member;
import shop.member.db.MemberDao;

public class MSearch implements Action {
	MemberDao mdao;
	Member m;
	ArrayList<Member> list;
	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("euc-kr");
		System.out.println("sk°ª : " +request.getParameter("sk"));
		System.out.println("sv°ª : " +request.getParameter("sv"));
		mdao = new MemberDao();
		m = new Member();
		list = new ArrayList<Member>();
		MActionForward mforward = new MActionForward();
		
		list = mdao.mSelectSearch(request.getParameter("sk"),request.getParameter("sv"));
		System.out.println(list);
		request.setAttribute("list", list);
		
		mforward.setRedirect(false);
		mforward.setPath("/member/mList.jsp");
		return mforward;
	
	}

}

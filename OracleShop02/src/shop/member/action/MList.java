package shop.member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.member.db.Member;
import shop.member.db.MemberDao;

public class MList implements Action {
	MemberDao mdao;
	Member m;
	ArrayList<Member> list;
	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("전체회원조회 execute 시작!");
		request.setCharacterEncoding("euc-kr");
		
		mdao = new MemberDao();
		m = new Member();
		
		list = mdao.mSelectAll();
		request.setAttribute("list", list);
		
		MActionForward mforward = new MActionForward();
		mforward.setRedirect(false);
		mforward.setPath("/member/mList.jsp");
		return mforward;

	}

}

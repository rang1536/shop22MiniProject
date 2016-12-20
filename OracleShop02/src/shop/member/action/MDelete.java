package shop.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.member.db.Member;
import shop.member.db.MemberDao;

public class MDelete implements Action {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("회원삭제 execute 시작!");
		System.out.println("삭제할 아이디: "+ request.getParameter("memberId"));
		request.setCharacterEncoding("euc-kr");
		MemberDao mdao= new MemberDao();
		Member m =new Member();
		MActionForward mforward = new MActionForward();
		
		//넘어온 아이디값으로 회원검색하여 비번체크 위해 request영역에 세팅하고 포워드 한다.
		m = mdao.mSelectOneByKey(request.getParameter("memberId"));
		request.setAttribute("memberList", m);
	
		mforward.setRedirect(false);
		mforward.setPath("member/mDeleteCheck.jsp");
		return mforward;
	}
}


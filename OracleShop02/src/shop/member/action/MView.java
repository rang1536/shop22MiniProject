package shop.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.member.db.Member;
import shop.member.db.MemberDao;

public class MView implements Action {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("euc-kr");
		MActionForward mforward = new MActionForward();
		MemberDao mdao = new MemberDao();
		Member m = new Member();
		if(request.getParameter("memberId") == null){
			mforward.setRedirect(true);
			mforward.setPath("/MList.mem");
		}else{
			String memberId = request.getParameter("memberId");
			m = mdao.mSelectOneByKey(memberId);
			request.setAttribute("memberList", m);
			mforward.setRedirect(false);
			mforward.setPath("/member/mListView.jsp");
		}
		
		return mforward;
	}

}

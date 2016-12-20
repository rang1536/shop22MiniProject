package shop.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.member.db.Member;
import shop.member.db.MemberDao;

public class MUpdateForm implements Action {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("euc-kr");
		MActionForward mforward = new MActionForward();
		MemberDao mdao = new MemberDao();
		Member m = new Member();
		
		// 리스트화면에서 수정요청시 아이디(PK)값이 넘어왓는지 확인하고 없으면 리스트화면으로 다시 리다이렉트 시킨다
		if(request.getParameter("memberId") == null){
			mforward.setRedirect(true);
			mforward.setPath("/MList.mem");
			
		// 넘어온 값이 있으면 아이디값으로 회원정보를 조회하여 결과값을 request영역에 세팅하고 수정화면으로 포워드시켜준다.
		}else{
			String memberId = request.getParameter("memberId");
			m = mdao.mSelectOneByKey(memberId);
			request.setAttribute("memberList", m);
			mforward.setRedirect(false);
			mforward.setPath("/member/mUpdateForm.jsp");
		}
		return mforward;
	}
}

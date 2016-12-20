package shop.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.member.db.Member;
import shop.member.db.MemberDao;

public class MDeleteAction implements Action {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("euc-kr");
		/*System.out.println(request.getParameter("memberId"));
		System.out.println(request.getParameter("memberPw"));*/
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		MemberDao mdao = new MemberDao();
		Member m = new Member();
		MActionForward mforward = new MActionForward();
		
		m = mdao.mSelectOneByKey(request.getParameter("memberId"));
		
		//mDeleteCheck.jsp에서 넘어온 비번과 id로 조회하여 나온 비번일치여부 확인하여 일치하면 삭제처리하고 아니면 경고창띄운후 다시 비번 입력화면으로 보낸다.
		if(memberPw.equals(m.getMemberPw())){
			int result = mdao.mDelete(memberId);
			System.out.println("삭제처리 결과 : "+result);
			mforward.setRedirect(true);
			mforward.setPath("/MList.mem");
			return mforward;
		}else{
			response.setContentType("text/html; charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return null;
		}
		
	}

}

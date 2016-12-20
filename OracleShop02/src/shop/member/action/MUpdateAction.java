package shop.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.member.db.Member;
import shop.member.db.MemberDao;

public class MUpdateAction implements Action {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("회원수정처리 execute!");
		request.setCharacterEncoding("euc-kr");
		MemberDao mdao = new MemberDao();
		Member m = new Member();
		MActionForward mforward = new MActionForward();
		
		//입력된 id값으로 한명의 회원조회하는 select쿼리 실행후 결과값의 비밀번호와 입력된 비밀번호 일치여부를 확인함
		m = mdao.mSelectOneByKey(request.getParameter("memberId"));
		
		// 1. 비번이 일치하면 값세팅후 수정처리하는 매서드 호출
		if(request.getParameter("memberPw").equals(m.getMemberPw())){
			// mUpdateForm.jsp의 입력값을 세팅해준다
			m= new Member();
			m.setMemberId(request.getParameter("memberId"));
			m.setMemberPw(request.getParameter("memberPw"));
			m.setMemberName(request.getParameter("memberName"));
			m.setMemberLevel(request.getParameter("memberLevel"));
			m.setMemberSex(request.getParameter("memberSex"));
			m.setMemberAddn(request.getParameter("memberAddn"));
			m.setMemberAdd(request.getParameter("memberAdd"));
			m.setMemberAdds(request.getParameter("memberAdds"));
			m.setMemberEmail(request.getParameter("memberEmail"));
			m.setMemberPhone(request.getParameter("memberPhone"));
			m.setMemberMobile(request.getParameter("memberMobile"));
			m.setMemberMileage(request.getParameter("memberMileage"));
			int result = mdao.mUpdate(m);
			System.out.println("수정처리 결과 : "+result);
			mforward.setRedirect(true);
			mforward.setPath("/MList.mem");
			return mforward;
			
		// 2. 비번 불일치시 경고창 띄운후 다시 수정화면으로 !
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

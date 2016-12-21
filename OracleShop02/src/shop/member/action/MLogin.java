package shop.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.member.db.Member;
import shop.member.db.MemberDao;

public class MLogin implements Action {
	MemberDao mdao;
	Member m;
	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("euc-kr");
		/*System.out.println(request.getParameter("memberId"));
		System.out.println(request.getParameter("memberPw"));*/
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		mdao = new MemberDao();
		m = new Member();
		MActionForward mforward = new MActionForward();
		
		// mLogin.jsp에서 입력한 아이디 패스워드 값이 있는지 확인하고 없으면 다시 로그인화면으로 리다이렉트 시킨다.
		if(memberId ==null || memberPw ==null){
			mforward.setRedirect(true);
			mforward.setPath("/index.jsp");
			return mforward;
		}
		
		// 입력된 아이디값으로 회원정보 조회하여 결과가 없으면 경고창띄우고 입력화면으로 다시 돌아가게 한다
		m = mdao.mSelectOneByKey(memberId);
		if(m == null){
			response.setContentType("text/html; charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('아이디가 일치하지 않습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		
		// 입력된 아이디와 패스워드로 회원정보 조회하는 매서드를 호출하고 결과값이 있으면 새션에 권한과 아이디를 세팅하고 리스트 화면으로 리다이렉트시킨다.
		Member member= new Member();
		member = mdao.mSelectLogin(memberId, memberPw);
		if(member != null){
			System.out.println("로그인성공");
			HttpSession session = request.getSession();
			session.setAttribute("sessionLevel",m.getMemberLevel());
			session.setAttribute("sessionId",m.getMemberId());
			mforward.setRedirect(true);
			mforward.setPath("/index.jsp");
			return mforward;
			
		// 조회 결과값이 없으면 비번 불일치 상황으로 경고창을 띄운후 입력화면으로 다시 돌아가게 한다.
		}else{
			response.setContentType("text/html; charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		return null;		
	}

}

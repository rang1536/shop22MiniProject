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
		
		// mLogin.jsp���� �Է��� ���̵� �н����� ���� �ִ��� Ȯ���ϰ� ������ �ٽ� �α���ȭ������ �����̷�Ʈ ��Ų��.
		if(memberId ==null || memberPw ==null){
			mforward.setRedirect(true);
			mforward.setPath("/index.jsp");
			return mforward;
		}
		
		// �Էµ� ���̵����� ȸ������ ��ȸ�Ͽ� ����� ������ ���â���� �Է�ȭ������ �ٽ� ���ư��� �Ѵ�
		m = mdao.mSelectOneByKey(memberId);
		if(m == null){
			response.setContentType("text/html; charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('���̵� ��ġ���� �ʽ��ϴ�.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		
		// �Էµ� ���̵�� �н������ ȸ������ ��ȸ�ϴ� �ż��带 ȣ���ϰ� ������� ������ ���ǿ� ���Ѱ� ���̵� �����ϰ� ����Ʈ ȭ������ �����̷�Ʈ��Ų��.
		Member member= new Member();
		member = mdao.mSelectLogin(memberId, memberPw);
		if(member != null){
			System.out.println("�α��μ���");
			HttpSession session = request.getSession();
			session.setAttribute("sessionLevel",m.getMemberLevel());
			session.setAttribute("sessionId",m.getMemberId());
			mforward.setRedirect(true);
			mforward.setPath("/index.jsp");
			return mforward;
			
		// ��ȸ ������� ������ ��� ����ġ ��Ȳ���� ���â�� ����� �Է�ȭ������ �ٽ� ���ư��� �Ѵ�.
		}else{
			response.setContentType("text/html; charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('��й�ȣ�� ��ġ���� �ʽ��ϴ�.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		return null;		
	}

}

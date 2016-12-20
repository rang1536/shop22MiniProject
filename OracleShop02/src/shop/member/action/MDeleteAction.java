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
		
		//mDeleteCheck.jsp���� �Ѿ�� ����� id�� ��ȸ�Ͽ� ���� �����ġ���� Ȯ���Ͽ� ��ġ�ϸ� ����ó���ϰ� �ƴϸ� ���â����� �ٽ� ��� �Է�ȭ������ ������.
		if(memberPw.equals(m.getMemberPw())){
			int result = mdao.mDelete(memberId);
			System.out.println("����ó�� ��� : "+result);
			mforward.setRedirect(true);
			mforward.setPath("/MList.mem");
			return mforward;
		}else{
			response.setContentType("text/html; charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('��й�ȣ�� ��ġ���� �ʽ��ϴ�.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return null;
		}
		
	}

}

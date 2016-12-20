package shop.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.member.db.Member;
import shop.member.db.MemberDao;

public class MUpdateAction implements Action {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ȸ������ó�� execute!");
		request.setCharacterEncoding("euc-kr");
		MemberDao mdao = new MemberDao();
		Member m = new Member();
		MActionForward mforward = new MActionForward();
		
		//�Էµ� id������ �Ѹ��� ȸ����ȸ�ϴ� select���� ������ ������� ��й�ȣ�� �Էµ� ��й�ȣ ��ġ���θ� Ȯ����
		m = mdao.mSelectOneByKey(request.getParameter("memberId"));
		
		// 1. ����� ��ġ�ϸ� �������� ����ó���ϴ� �ż��� ȣ��
		if(request.getParameter("memberPw").equals(m.getMemberPw())){
			// mUpdateForm.jsp�� �Է°��� �������ش�
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
			System.out.println("����ó�� ��� : "+result);
			mforward.setRedirect(true);
			mforward.setPath("/MList.mem");
			return mforward;
			
		// 2. ��� ����ġ�� ���â ����� �ٽ� ����ȭ������ !
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

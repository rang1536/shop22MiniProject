package shop.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.member.db.Member;
import shop.member.db.MemberDao;

public class MInsert implements Action {
	MemberDao mdao;
	Member m;
	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ȸ������ execute ����!");
		System.out.println(request.getParameter("memberId"));
		request.setCharacterEncoding("euc-kr");
		mdao = new MemberDao();
		m = new Member();
		
		// mInsertForm.jsp���� �Ѿ�°��� �����ϰ� mInsert�ż��� ȣ���Ͽ� DB�� �Է��Ѵ�
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
		
		int result = mdao.mInsert(m);
		System.out.println("�Է� ��� : "+result);
		
		// �Է�ó�� Ȯ���� ����Ʈȭ������ �����̷�Ʈ ��Ų��.
		MActionForward mforward = new MActionForward();
		mforward.setRedirect(true);
		mforward.setPath("/MList.mem");
		
		return mforward;
	}

}

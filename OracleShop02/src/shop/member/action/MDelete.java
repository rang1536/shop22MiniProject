package shop.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.member.db.Member;
import shop.member.db.MemberDao;

public class MDelete implements Action {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ȸ������ execute ����!");
		System.out.println("������ ���̵�: "+ request.getParameter("memberId"));
		request.setCharacterEncoding("euc-kr");
		MemberDao mdao= new MemberDao();
		Member m =new Member();
		MActionForward mforward = new MActionForward();
		
		//�Ѿ�� ���̵����� ȸ���˻��Ͽ� ���üũ ���� request������ �����ϰ� ������ �Ѵ�.
		m = mdao.mSelectOneByKey(request.getParameter("memberId"));
		request.setAttribute("memberList", m);
	
		mforward.setRedirect(false);
		mforward.setPath("member/mDeleteCheck.jsp");
		return mforward;
	}
}


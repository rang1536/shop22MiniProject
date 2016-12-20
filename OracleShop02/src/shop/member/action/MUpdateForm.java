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
		
		// ����Ʈȭ�鿡�� ������û�� ���̵�(PK)���� �Ѿ�Ӵ��� Ȯ���ϰ� ������ ����Ʈȭ������ �ٽ� �����̷�Ʈ ��Ų��
		if(request.getParameter("memberId") == null){
			mforward.setRedirect(true);
			mforward.setPath("/MList.mem");
			
		// �Ѿ�� ���� ������ ���̵����� ȸ�������� ��ȸ�Ͽ� ������� request������ �����ϰ� ����ȭ������ ����������ش�.
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

package shop.member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.member.db.Member;
import shop.member.db.MemberDao;

public class MSearch implements Action {
	MemberDao mdao;
	Member m;
	ArrayList<Member> memberList;
	HttpSession session;
	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("euc-kr");
		
		// ���ǿ��� �α��ν� �����س� ���ѹ� ���̵� ��������!
		session = request.getSession();
		String sessionLevel = (String)session.getAttribute("sessionLevel");
		System.out.println("sessionLevel�� : " +sessionLevel);
		
		mdao= new MemberDao();
		m= new Member();
		memberList = new ArrayList<Member>();
		MActionForward mforward = new MActionForward();
		
		/* ������ �������϶��� �ƴҶ� �������� �Է°� �޾Ƽ� �� �Է����ǿ� �´� select�Ҽ��ִ� �ż��� ȣ��
		     1. �����ڰ� �ƴҶ� ����! */
		if(sessionLevel.equals("�Ǹ���") || sessionLevel.equals("������")){ 
			String memberName = request.getParameter("memberName");
			String memberId = request.getParameter("memberId");
			System.out.println("�����ھƴҶ� �Է°� Ȯ�� �̸�+���̵�:" +memberName+"  "+ memberId);
			memberList = mdao.mSearchNotAdmin(memberName, memberId);
			// System.out.println(memberList.get(0).getMemberId());
			
			// �Էµ� �̸��� ���̵�� �˻��Ͽ� ���ϰ��� memberlist�� ��� request������ ����. view�������� ������ �Ѵ�
			request.setAttribute("memberlist", memberList);
					
		//   2. �������϶� ����!
		}else if(sessionLevel.equals("������")){
			String memberName = request.getParameter("memberName");
			String memberSex = request.getParameter("memberSex");
			String startDay = request.getParameter("startDay");
			String endDay = request.getParameter("endDay");
			String memberAdd = request.getParameter("memberAdd");
			
		//�޾ƿ°� MemberŸ�� ���� m�� ������Ƽ ����.
			m.setMemberName(memberName);
			m.setMemberSex(memberSex);
			m.setStartDay(startDay);
			m.setEndDay(endDay);
			m.setMemberAdd(memberAdd);
			memberList = mdao.mSearchAdmin(m);
			
			//�Է°����� ���Ǻ��Ͽ� ��ġ�ϴ� ���� ���Ϲ޾� request������ ����. view�������� ������ �Ѵ�
			request.setAttribute("memberlist", memberList);
		}
		mforward.setRedirect(false);
		mforward.setPath("/member/mList.jsp");
		return mforward;
	}
}

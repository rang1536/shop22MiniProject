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
		
		// 새션에서 로그인시 저장해논 권한및 아이디값 가져오기!
		session = request.getSession();
		String sessionLevel = (String)session.getAttribute("sessionLevel");
		System.out.println("sessionLevel값 : " +sessionLevel);
		
		mdao= new MemberDao();
		m= new Member();
		memberList = new ArrayList<Member>();
		MActionForward mforward = new MActionForward();
		
		/* 권한이 관리자일때와 아닐때 조건으로 입력값 받아서 각 입력조건에 맞는 select할수있는 매서드 호출
		     1. 관리자가 아닐때 조건! */
		if(sessionLevel.equals("판매자") || sessionLevel.equals("구매자")){ 
			String memberName = request.getParameter("memberName");
			String memberId = request.getParameter("memberId");
			System.out.println("관리자아닐때 입력값 확인 이름+아이디:" +memberName+"  "+ memberId);
			memberList = mdao.mSearchNotAdmin(memberName, memberId);
			// System.out.println(memberList.get(0).getMemberId());
			
			// 입력된 이름과 아이디로 검색하여 리턴값을 memberlist에 담아 request영역에 세팅. view페이지로 포워드 한다
			request.setAttribute("memberlist", memberList);
					
		//   2. 관리자일때 조건!
		}else if(sessionLevel.equals("관리자")){
			String memberName = request.getParameter("memberName");
			String memberSex = request.getParameter("memberSex");
			String startDay = request.getParameter("startDay");
			String endDay = request.getParameter("endDay");
			String memberAdd = request.getParameter("memberAdd");
			
		//받아온값 Member타입 변수 m에 프로퍼티 세팅.
			m.setMemberName(memberName);
			m.setMemberSex(memberSex);
			m.setStartDay(startDay);
			m.setEndDay(endDay);
			m.setMemberAdd(memberAdd);
			memberList = mdao.mSearchAdmin(m);
			
			//입력값으로 조건비교하여 일치하는 값만 리턴받아 request영역에 세팅. view페이지로 포워드 한다
			request.setAttribute("memberlist", memberList);
		}
		mforward.setRedirect(false);
		mforward.setPath("/member/mList.jsp");
		return mforward;
	}
}

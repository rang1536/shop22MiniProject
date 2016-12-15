package shop.member.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shop.member.db.Member;

public interface Action {
	
	// Member클래스타입의 추상메서드
	public MActionForward execute(HttpServletRequest request,HttpServletResponse response)throws Exception;
	
}

package shop.member.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shop.member.db.Member;

public interface Action {
	
	// MemberŬ����Ÿ���� �߻�޼���
	public MActionForward execute(HttpServletRequest request,HttpServletResponse response)throws Exception;
	
}

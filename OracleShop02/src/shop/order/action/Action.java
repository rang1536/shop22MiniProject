package shop.order.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public interface Action {
	public OActionForward execute(HttpServletRequest request,HttpServletResponse response)throws Exception;
	
}



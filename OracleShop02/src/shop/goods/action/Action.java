package shop.goods.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.goods.db.Goods;


public interface Action {

	
	public GActionForward execute(HttpServletRequest request,HttpServletResponse response)throws Exception;
	
}

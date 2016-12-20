package shop.order.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.member.action.MDelete;


@WebServlet("/OFrontController")
public class OFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doAction(HttpServletRequest request, HttpServletResponse response) 
		 	throws ServletException, IOException {
    	System.out.println("OFrontController 시작 !!");
    	request.setCharacterEncoding("euc-kr");
    	String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		System.out.println("URI : "+ RequestURI);
		System.out.println("contextPath : "+ contextPath);
		System.out.println("command : "+ command);
		OActionForward oforward = null;
		Action action;
		
		switch(command){
		case("/OInsert.ord"):
			System.out.println("01주문 입력!");
			action = new OInsert();
			try{
				oforward = action.execute(request, response);
				
			}catch(Exception e){
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
		if(oforward != null){
			if(oforward.isRedirect()){
				response.sendRedirect(request.getContextPath()+oforward.getPath());
			}else{
				RequestDispatcher dispatcher=
					request.getRequestDispatcher(oforward.getPath());
				System.out.println("OFrontController 포워드경로 : "+oforward.getPath());
				System.out.println();
				dispatcher.forward(request, response);
			}
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OFrontController 시작 -get요청!!");
		doAction(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OFrontController 시작 -post요청!!");
		request.setCharacterEncoding("euc-kr");
		doAction(request,response);
	}

}

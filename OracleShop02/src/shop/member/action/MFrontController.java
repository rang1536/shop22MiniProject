package shop.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.member.action.MActionForward;
import shop.member.action.Action;


@WebServlet("/MFrontController")
public class MFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doAction(HttpServletRequest request, HttpServletResponse response) 
		 	throws ServletException, IOException {
    	System.out.println("MFrontController ���� !!");
    	request.setCharacterEncoding("euc-kr");
    	String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		System.out.println("URI : "+ RequestURI);
		System.out.println("contextPath : "+ contextPath);
		System.out.println("command : "+ command);
		MActionForward mforward = null;
		Action action = null ;
		
		switch (command) {
		case ("/MInsert.mem"):
			mforward = new MActionForward();
			mforward.setRedirect(false);
			mforward.setPath("/member/mInsertForm.jsp");
			break;
		case ("/mInsertAction.mem"):
			System.out.println("01 ȸ������!!");
			action = new MInsert();
			try{
				mforward = action.execute(request, response);
				
			}catch(Exception e){
				e.printStackTrace();
			}
			break;
		case ("/MList.mem"):
			System.out.println("02��üȸ������Ʈ");
			action = new MList();
			try{
				mforward = action.execute(request, response);
				
			}catch(Exception e){
				e.printStackTrace();
			}
			break;
		case ("/MSearch.mem"):
			System.out.println("03ȸ���˻�");
			action = new MSearch();
			try{
				mforward = action.execute(request, response);
				
			}catch(Exception e){
				e.printStackTrace();
			}
			break;
		case ("/MemberView.mem"):
			System.out.println("03ȸ���˻�");
			action = new MView();
			try{
				mforward = action.execute(request, response);
				
			}catch(Exception e){
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
		if(mforward != null){
			if(mforward.isRedirect()){
				response.sendRedirect(request.getContextPath()+mforward.getPath());
			}else{
				RequestDispatcher dispatcher=
					request.getRequestDispatcher(mforward.getPath());
				System.out.println("MFrontController �������� : "+mforward.getPath());
				System.out.println();
				dispatcher.forward(request, response);
			}
		}
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MFrontController ���� -get��û!!");
		doAction(request,response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MFrontController ���� -post��û!!");
		request.setCharacterEncoding("euc-kr");
		doAction(request,response);
	}

}

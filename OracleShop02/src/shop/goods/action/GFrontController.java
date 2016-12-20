package shop.goods.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GFrontController")
@MultipartConfig
public class GFrontController extends HttpServlet {
	
	protected void doPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("dopro ���ӵ�");
		request.setCharacterEncoding("euc-kr");
		String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		System.out.println("������ URI�ּ� : " +RequestURI);
		System.out.println("command : "+ command);
		
		GActionForward gforward = null;
		Action action = null;
		
		
		
		if(command.equals("/goods/gSearchForm.goo")){
			System.out.println("�˻����� �Է��� ��ư Ŭ��");
			action = new GSearchForm();
			try{
				gforward = action.execute(request, response);
			}catch(Exception e){
				
			}
			
		}
		
		
		
		
		//�˻�ȭ��
		if(command.equals("/goods/gSearch.goo")){
			System.out.println("�˻���ư Ŭ���� �˻�ȭ������ �̵�");
			gforward = new GActionForward();
			gforward.setRedirect(true);
			gforward.setPath(request.getContextPath()+"/goods/gSearchForm.jsp");
		}
		
		
		
		
		
		
		
		
		
		//�󼼺���
		if(command.equals("/goods/gDetailForm.goo")){
			System.out.println("��ǰ�̹��� Ŭ�� ->��ǰ�󼼺���");
			action = new GDetail();
			try{
				gforward = action.execute(request, response);
			}catch(Exception e){
				
			}
		}
		
		
		
		
		
		//��ǰ ����
		if(command.equals("/goods/gDelete.goo")){
			System.out.println("��ǰ���� ��ư Ŭ��");
			action = new GDelete();
			try{
				gforward = action.execute(request, response);
			}catch(Exception e){
				
			}
		}
		
		
		
		
		//��ǰ�����Է� �� ����
		if(command.equals("/goods/GUpdateAction.goo")){
			System.out.println("��ǰ���� �Է� �� ����");
			action = new GUpdateAction();
			try{
				gforward = action.execute(request, response);
			}catch(Exception e){
				
			}
			
		}
		
		
		
		//��ǰ����
		if(command.equals("/goods/GUpdateForm.goo")){
			System.out.println("��ǰ���� Ŭ��");
			action = new GUpdateForm();
			try{
				
			gforward = action.execute(request, response);
				
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		
			
			//��ǰ �Է¿Ϸ� �� ��������
		
		if(command.equals("/goods/gInsertAction.goo")){
			System.out.println("��ǰ�Է�ȭ�鿡�� �� �Է����� �Է¿�û");
			action = new GInsert();
			try{
				
				gforward = action.execute(request, response);
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
		}
		
		
		
		//��ǰ�Է��ϰ������ ��ǰ�Է�ȭ������ ��
		if(command.equals("/goods/gInsert.goo")){
			System.out.println("��ǰ�Է�ȭ������ ��");
			action = new GInsertForm();
			try{
				gforward = action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
				
			
		}
		
		
		
		//����Ʈ
		if(command.equals("/goods/gList.goo")){
			System.out.println("����Ʈ�� ���ϴ�");
			action = new GList();
			try{
				gforward = action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
				
			}
			
			
			
		}
		
		if(gforward != null){
			if(gforward.isRedirect()){
				response.sendRedirect(gforward.getPath());
			}else{
				RequestDispatcher dispatcher=
					request.getRequestDispatcher(gforward.getPath());
				System.out.println(gforward.getPath() + "<--- mforward.getPath()[jsp �̵����]  BoardFrontController.java");
				System.out.println();
				dispatcher.forward(request, response);
			}
		}
		
		
		
		
	}
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get������� ��Ʈ�ѷ�����");
		doPro(request , response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post������� ��Ʈ�ѷ� ����");
		doPro(request , response);
	}

}

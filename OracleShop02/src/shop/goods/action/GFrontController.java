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
		
		System.out.println("dopro 접속됨");
		request.setCharacterEncoding("euc-kr");
		String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		System.out.println("가져온 URI주소 : " +RequestURI);
		System.out.println("command : "+ command);
		
		GActionForward gforward = null;
		Action action = null;
		
		
		
		if(command.equals("/goods/gSearchForm.goo")){
			System.out.println("검색조건 입력후 버튼 클릭");
			action = new GSearchForm();
			try{
				gforward = action.execute(request, response);
			}catch(Exception e){
				
			}
			
		}
		
		
		
		
		//검색화면
		if(command.equals("/goods/gSearch.goo")){
			System.out.println("검색버튼 클릭시 검색화면으로 이동");
			gforward = new GActionForward();
			gforward.setRedirect(true);
			gforward.setPath(request.getContextPath()+"/goods/gSearchForm.jsp");
		}
		
		
		
		
		
		
		
		
		
		//상세보기
		if(command.equals("/goods/gDetailForm.goo")){
			System.out.println("상품이미지 클릭 ->상품상세보기");
			action = new GDetail();
			try{
				gforward = action.execute(request, response);
			}catch(Exception e){
				
			}
		}
		
		
		
		
		
		//상품 삭제
		if(command.equals("/goods/gDelete.goo")){
			System.out.println("상품삭제 버튼 클릭");
			action = new GDelete();
			try{
				gforward = action.execute(request, response);
			}catch(Exception e){
				
			}
		}
		
		
		
		
		//상품수정입력 후 실행
		if(command.equals("/goods/GUpdateAction.goo")){
			System.out.println("상품수정 입력 후 실행");
			action = new GUpdateAction();
			try{
				gforward = action.execute(request, response);
			}catch(Exception e){
				
			}
			
		}
		
		
		
		//상품수정
		if(command.equals("/goods/GUpdateForm.goo")){
			System.out.println("상품수정 클릭");
			action = new GUpdateForm();
			try{
				
			gforward = action.execute(request, response);
				
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		
			
			//상품 입력완료 후 쿼리실행
		
		if(command.equals("/goods/gInsertAction.goo")){
			System.out.println("상품입력화면에서 값 입력했음 입력요청");
			action = new GInsert();
			try{
				
				gforward = action.execute(request, response);
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
		}
		
		
		
		//상품입력하고싶을때 상품입력화면으로 감
		if(command.equals("/goods/gInsert.goo")){
			System.out.println("상품입력화면으로 감");
			action = new GInsertForm();
			try{
				gforward = action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
				
			
		}
		
		
		
		//리스트
		if(command.equals("/goods/gList.goo")){
			System.out.println("리스트로 갑니다");
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
				System.out.println(gforward.getPath() + "<--- mforward.getPath()[jsp 이동경로]  BoardFrontController.java");
				System.out.println();
				dispatcher.forward(request, response);
			}
		}
		
		
		
		
	}
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get방식으로 컨트롤러접속");
		doPro(request , response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post방식으로 컨트롤러 접속");
		doPro(request , response);
	}

}

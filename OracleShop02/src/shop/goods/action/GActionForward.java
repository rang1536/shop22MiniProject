package shop.goods.action;

public class GActionForward {
	//전역변수 하나는 포워드할것인가?리다이렉트할것인가?
		//전역변수 두번째는 경로
		private boolean isRedirect=false;
		private String path=null;
		
		public boolean isRedirect() {
			return isRedirect;
		}
		public void setRedirect(boolean isRedirect) {
			System.out.println("isRedirect에 값 세팅 : "+isRedirect);
			this.isRedirect = isRedirect;
		}
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			System.out.println("path에 입력된경로 세팅 "+path);
			this.path = path;
		}
}

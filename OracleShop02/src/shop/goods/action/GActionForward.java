package shop.goods.action;

public class GActionForward {
	//�������� �ϳ��� �������Ұ��ΰ�?�����̷�Ʈ�Ұ��ΰ�?
		//�������� �ι�°�� ���
		private boolean isRedirect=false;
		private String path=null;
		
		public boolean isRedirect() {
			return isRedirect;
		}
		public void setRedirect(boolean isRedirect) {
			System.out.println("isRedirect�� �� ���� : "+isRedirect);
			this.isRedirect = isRedirect;
		}
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			System.out.println("path�� �ԷµȰ�� ���� "+path);
			this.path = path;
		}
}

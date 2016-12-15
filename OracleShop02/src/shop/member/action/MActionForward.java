package shop.member.action;

public class MActionForward {
	private boolean isRedirect=false;
	private String path=null;
	
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		System.out.println("isRedirect setRedirect MActionForward.java : "+ isRedirect);
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		System.out.println("setPath MActionForward.java : "+path);
		this.path = path;
	}
}

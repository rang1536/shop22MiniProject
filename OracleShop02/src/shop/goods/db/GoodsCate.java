package shop.goods.db;

public class GoodsCate {
	private int goodsCateNum;
	private String goodsCateName;
	public GoodsCate() {
		super();
	}
	public int getGoodsCateNum() {
		return goodsCateNum;
	}
	public void setGoodsCateNum(int goodsCateNum) {
		this.goodsCateNum = goodsCateNum;
	}
	public String getGoodsCateName() {
		return goodsCateName;
	}
	public void setGoodsCateName(String goodsCateName) {
		this.goodsCateName = goodsCateName;
	}
	@Override
	public String toString() {
		return "GoodsCate [goodsCateNum=" + goodsCateNum + ", goodsCateName=" + goodsCateName + "]";
	}
	
	
	

}

package shop.goods.db;

public class GoodsSize {

	private int goodsSizeNum;
	private int goodsCateNum;
	private String goodsSizeName;
	
	public GoodsSize() {
		super();
	}
	public int getGoodsSizeNum() {
		return goodsSizeNum;
	}
	public void setGoodsSizeNum(int goodsSizeNum) {
		this.goodsSizeNum = goodsSizeNum;
	}
	public int getGoodsCateNum() {
		return goodsCateNum;
	}
	public void setGoodsCateNum(int goodsCateNum) {
		this.goodsCateNum = goodsCateNum;
	}
	public String getGoodsSizeName() {
		return goodsSizeName;
	}
	public void setGoodsSizeName(String goodsSizeName) {
		this.goodsSizeName = goodsSizeName;
	}
	@Override
	public String toString() {
		return "GoodsSize [goodsSizeNum=" + goodsSizeNum + ", goodsCateNum=" + goodsCateNum + ", goodsSizeName="
				+ goodsSizeName + "]";
	}

	
}

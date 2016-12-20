package shop.goods.db;

public class GoodsColor {
	private int goodsColorNum;
	private String goodsColorName;
	public GoodsColor() {
		super();
	}
	public int getGoodsColorNum() {
		return goodsColorNum;
	}
	public void setGoodsColorNum(int goodsColorNum) {
		this.goodsColorNum = goodsColorNum;
	}
	public String getGoodsColorName() {
		return goodsColorName;
	}
	public void setGoodsColorName(String goodsColorName) {
		this.goodsColorName = goodsColorName;
	}
	@Override
	public String toString() {
		return "GoodsColor [goodsColorNum=" + goodsColorNum + ", goodsColorName=" + goodsColorName + "]";
	}
	
	
	
}

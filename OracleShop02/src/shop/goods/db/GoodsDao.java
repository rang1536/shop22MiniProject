package shop.goods.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import shop.driver.driverDb.DriverDb;

public class GoodsDao {
	DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<Goods> alm;
	Goods g;
	
	//생성자
	public GoodsDao(){
	
	}
	
	
	public ArrayList<Goods> gSearch(int goodsCate, String goodsName){
		ArrayList<Goods> goods = new ArrayList<Goods>();
		try{
		String sql = "select goods_name,goods_cate,goods_price,goods_color,goods_size,goods_img from goods where goods_cate like ? AND goods_name like ?";
		conn = DriverDb.driverDbcon();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%"+goodsCate+"%");
		pstmt.setString(2, "%"+goodsName+"%");
		rs = pstmt.executeQuery();
		while(rs.next()){
			g = new Goods();
			g.setGoodsName(rs.getString("GOODS_NAME"));
			g.setGoodsCate(rs.getInt("GOODS_CATE"));
			g.setGoodsPrice(rs.getInt("GOODS_PRICE"));
			g.setGoodsColor(rs.getInt("GOODS_COLOR"));
			g.setGoodsSize(rs.getInt("GOODS_SIZE"));
			g.setGoodsImg(rs.getString("GOODS_IMG"));
			goods.add(g);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return goods;
	}
	
	
	
	
	public int gDelete(int goodsNum){
		System.out.println("상품 삭제 쿼리문 메소드");
		int rowCount = 0;
		try{
			String sql="delete from goods where goods_num=?";
			conn = DriverDb.driverDbcon();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, goodsNum);
			rowCount = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close(conn, pstmt, rs);
		}
		
		return rowCount;
	}
	
	
	
	
	
	public int gUpdate(Goods g){
		System.out.println("상품 업데이트 쿼리문 메소드");
		int rowCount = 0;
		try{
			String sql="update goods set goods_member_id=?,goods_name=?,goods_cate=?,goods_price=?,goods_color=?,goods_size=?,goods_img=?,goods_date=now(),goods_detail=?,goods_amount=? where goods_num=?";
			conn = DriverDb.driverDbcon();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, g.getGoodsMemberId());
			pstmt.setString(2, g.getGoodsName());
			pstmt.setInt(3, g.getGoodsCate());
			pstmt.setInt(4, g.getGoodsPrice());
			pstmt.setInt(5, g.getGoodsColor());
			pstmt.setInt(6, g.getGoodsSize());
			pstmt.setString(7, g.getGoodsImg());
			pstmt.setString(8, g.getGoodsDetail());
			pstmt.setInt(9, g.getGoodsAmount());
			pstmt.setInt(10, g.getGoodsNum());
			rowCount = pstmt.executeUpdate();
			}catch(Exception e){
			
		}finally{
			this.close(conn, pstmt, rs);
		}
		return rowCount;
	}
	
	
	public Goods gSelectOne(int goodsNum){
		System.out.println("하나의 상품조회 메서드");
		Goods g = null;
		
		try{
			
			conn=DriverDb.driverDbcon();
			
			pstmt = conn.prepareStatement("select goods_num,goods_member_id,goods_name,goods_cate,goods_price,goods_color,goods_size,goods_img,goods_detail,goods_amount,goods_date FROM Goods WHERE goods_num = ? ");
			pstmt.setInt(1, goodsNum);
			rs = pstmt.executeQuery();
			System.out.println("rs값 확인 : "+rs);
			if(rs.next()){
				g = new Goods();
				g.setGoodsNum(rs.getInt("GOODS_NUM"));
				g.setGoodsMemberId(rs.getString("GOODS_MEMBER_ID"));
				g.setGoodsName(rs.getString("GOODS_NAME"));
				g.setGoodsCate(rs.getInt("GOODS_CATE"));
				g.setGoodsPrice(rs.getInt("GOODS_PRICE"));
				g.setGoodsColor(rs.getInt("GOODS_COLOR"));
				g.setGoodsSize(rs.getInt("GOODS_SIZE"));
				g.setGoodsDate(rs.getString("goods_date"));
				g.setGoodsImg(rs.getString("GOODS_IMG"));
				g.setGoodsDetail(rs.getString("GOODS_DETAIL"));
				g.setGoodsAmount(rs.getInt("GOODS_AMOUNT"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close(conn, pstmt, rs);
			
		}
		return g;
		
	}
	
	public int gInsert(Goods g){
		System.out.println("상품입력 쿼리문 메소드");
		int rowCount = 0;
		try{
		conn=DriverDb.driverDbcon();
		pstmt = conn.prepareStatement("insert into GOODS(goods_member_id,"
				+ "goods_name,goods_cate,goods_price,goods_color,goods_size,"
				+ "goods_img,goods_detail,goods_amount,goods_date)"
				+ " values(?,?,?,?,?,?,?,?,?,now())");
		pstmt.setString(1, g.getGoodsMemberId());
		pstmt.setString(2, g.getGoodsName());
		pstmt.setInt(3, g.getGoodsCate());
		pstmt.setInt(4, g.getGoodsPrice());
		pstmt.setInt(5, g.getGoodsColor());
		pstmt.setInt(6, g.getGoodsSize());
		pstmt.setString(7, g.getGoodsImg());
		pstmt.setString(8, g.getGoodsDetail());
		pstmt.setInt(9, g.getGoodsAmount());

		rowCount = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close(conn, pstmt, null);
			}
		return rowCount;
		}

	
	public ArrayList<Goods> gAllSelect(){
		
		System.out.println("상품 조회 메서드 선언");
		alm = new ArrayList<Goods>();
		System.out.println(alm + "<-- alm 111");
		try{
		conn=DriverDb.driverDbcon();
		
		pstmt = conn.prepareStatement(
				"select * from GOODS");
		
	
		rs = pstmt.executeQuery();	
		
		while(rs.next()){
			g = new Goods();
			g.setGoodsNum(rs.getInt("GOODS_NUM"));
			g.setGoodsMemberId(rs.getString("GOODS_MEMBER_ID"));
			g.setGoodsName(rs.getString("GOODS_NAME"));
			g.setGoodsCate(rs.getInt("GOODS_CATE"));
			g.setGoodsPrice(rs.getInt("GOODS_PRICE"));
			g.setGoodsColor(rs.getInt("GOODS_COLOR"));
			g.setGoodsSize(rs.getInt("GOODS_SIZE"));
			g.setGoodsDate(rs.getString("GOODS_DATE"));
			g.setGoodsImg(rs.getString("GOODS_IMG"));
			g.setGoodsDetail(rs.getString("GOODS_DETAIL"));
			g.setGoodsAmount(rs.getInt("GOODS_AMOUNT"));
			alm.add(g);		//ArrayList객체내에 Member객체 주소값을 index 0번 부터 추가
			System.out.println(alm + "<-- alm 222");	
		}
		}catch(Exception e){
			
		}finally{
		this.close(conn, pstmt, rs);
		}
		return alm;
	}	
	
	// 사이즈테이블전체조회
	
			public ArrayList<GoodsSize> selectSize(){
				
				ArrayList<GoodsSize> size = new ArrayList<GoodsSize>();
				try{
					conn = DriverDb.driverDbcon();
					String sql = "select goods_size_no,goods_cate_no, goods_size_name from goodssize";
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					System.out.println("상품색상조회 확인 : "+rs);
					while(rs.next()){
						GoodsSize s = new GoodsSize();
						s.setGoodsSizeNum(rs.getInt("goods_size_no"));
						s.setGoodsCateNum(rs.getInt("goods_cate_no"));
						s.setGoodsSizeName(rs.getString("goods_size_name"));
						size.add(s);
					}
				}catch(Exception e){
					
				}finally{
					this.close(conn, pstmt, rs);
				}
				return size;
			}
	
		//상세보기 할때 입력시 선택한 size 조회
		public String useDetailselectSize(int goodsNum){
			int goodsSizeNum = 0;
			String goodsSizeName = null;
			try{
				
				conn = DriverDb.driverDbcon();
				String sql = "select goods_size from goods where goods_num = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, goodsNum);
				rs = pstmt.executeQuery();
				if(rs.next()){
					goodsSizeNum = rs.getInt("goods_size");
					System.out.println("goodsSizeNum 확인 : "+ goodsSizeNum);
					sql = "select goods_size_name from goodssize where goods_size_no = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, goodsSizeNum);
					rs = pstmt.executeQuery();
					if(rs.next()){
						goodsSizeName= rs.getString("goods_size_name");
						System.out.println("goodsSizeName 확인 : "+ goodsSizeName);
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				this.close(conn, pstmt, rs);
			}
			
			return goodsSizeName;
		}
	
	// 카테고리 넘버 입력시 카테고리 조회
		public GoodsCate selectCategory(int goodsCateNum){
				GoodsCate cate = new GoodsCate();
			try{
				conn = DriverDb.driverDbcon();
				String sql = "select goods_cate_no,goods_cate_name from goodscate where coods_cate_no = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, goodsCateNum);
				rs = pstmt.executeQuery();
				if(rs.next()){
					cate.setGoodsCateNum(rs.getInt("goods_cate_no"));
					cate.setGoodsCateName(rs.getString("goods_cate_name"));
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				this.close(conn, pstmt, rs);
			}
			return cate;
		}
		
			
	// 카테고리별 상품 사이즈 이름 조회
		public ArrayList<GoodsSize> selectSizeName(int goodsCateNum){
			
			ArrayList<GoodsSize> size = new ArrayList<GoodsSize>();
			try{
				conn = DriverDb.driverDbcon();
				String sql = "select goods_size_no,goods_cate_no, goods_size_name"
						+ " from goodssize where goods_cate_no = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, goodsCateNum);
				rs = pstmt.executeQuery();
				System.out.println("상품색상조회 확인 : "+rs);
				while(rs.next()){
					GoodsSize s = new GoodsSize();
					s.setGoodsSizeNum(rs.getInt("goods_size_no"));
					s.setGoodsCateNum(rs.getInt("goods_cate_no"));
					s.setGoodsSizeName(rs.getString("goods_size_name"));
					size.add(s);
				}
			}catch(Exception e){
				
			}finally{
				this.close(conn, pstmt, rs);
			}
			return size;
		}

	
	//상품 색상 조회
	public ArrayList<GoodsColor> selectColor(){
		
		ArrayList<GoodsColor> color = new ArrayList<GoodsColor>();
		try{
			conn = DriverDb.driverDbcon();
			String sql = "select goods_color_no, goods_color_name from goodscolor";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("상품색상조회 확인 : "+rs);
			while(rs.next()){
				 GoodsColor col = new GoodsColor();
				 col.setGoodsColorNum(rs.getInt("goods_color_no"));
				 col.setGoodsColorName(rs.getString("goods_color_name"));
				 color.add(col);
			}
		}catch(Exception e){
			
		}finally{
			this.close(conn, pstmt, rs);
		}
		return color;
	}

		//상품 카테고리 조회
	public ArrayList<GoodsCate> selectCate(){
		
		ArrayList<GoodsCate> cate = new ArrayList<GoodsCate>();
		try{
			conn = DriverDb.driverDbcon();
			String sql = "select goods_cate_no,goods_cate_name from goodscate";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("상품카테고리조회 확인 : "+rs);
			while(rs.next()){
				 GoodsCate c = new GoodsCate();
				 c.setGoodsCateNum(rs.getInt("goods_cate_no"));
				 c.setGoodsCateName(rs.getString("goods_cate_name"));
				 cate.add(c);
			}
		}catch(Exception e){
			
		}finally{
			this.close(conn, pstmt, rs);
		}
		return cate;
	}
	
	protected void close(Connection conn , Statement pstmt, ResultSet rs){
			
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
			
		}

	}

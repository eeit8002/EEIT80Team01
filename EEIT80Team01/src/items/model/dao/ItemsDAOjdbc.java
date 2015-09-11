package items.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import global.GlobalService;
import items.model.ItemsBean;
import items.model.ItemsDAO;


public class ItemsDAOjdbc implements ItemsDAO{
	private DataSource ds = null;
	
	//DriverManager用
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=EEIT80TEAM01";
	private static final String USER = "sa";
	private static final String PASSWORD = "sa123456";
	
	//DataSource用
//	public ItemsDAOjdbc(){
//		Context ctx;
//		try {
//			ctx = new InitialContext();
//			ds = (DataSource)ctx.lookup(GlobalService.JNDI_DB_NAME);
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//	}
	private static final String SELECT_BY_ID = "SELECT * FROM ITEMS WHERE ITEM_ID = ?";

	/* (non-Javadoc)
	 * @see items.model.dao.ItemsDAO#selectId(int)
	 */
	@Override
	public ItemsBean selectId(int itemId){
		ItemsBean result=null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
//			conn = ds.getConnection();
			stmt = conn.prepareStatement(SELECT_BY_ID);
			stmt.setInt(1, itemId);
			rset = stmt.executeQuery();
			if(rset.next()){
				result = new ItemsBean();
				result.setItemId(rset.getInt("ITEM_ID"));
				result.setSeller(rset.getString("SELLER"));
				result.setBuyer(rset.getString("BUYER"));
				result.setItemCategory(rset.getInt("ITEM_CATEGORY"));
				result.setTitle(rset.getString("TITLE"));
				result.setStartPrice(rset.getDouble("START_PRICE"));
				result.setDirectPrice(rset.getDouble("DIRECT_PRICE"));
				result.setBid(rset.getInt("BID"));
				result.setEndTime(rset.getDate("END_TIME"));
				result.setItemDiscribe(rset.getString("ITEM_DISCRIBE"));
				result.setItemStatus(rset.getInt("ITEM_STATUS"));
				result.setThreadLock(rset.getInt("THREAD_LOCK"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rset!=null){
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt!=null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
	private static final String SELECT_BY_CATEGORY = "SELECT * FROM ITEMS WHERE ITEM_CATEGORY = ?";

	/* (non-Javadoc)
	 * @see items.model.dao.ItemsDAO#selectCategory(int)
	 */
	@Override
	public ItemsBean selectCategory(int itemCategory){
		ItemsBean result=null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
//			conn = ds.getConnection();
			stmt = conn.prepareStatement(SELECT_BY_CATEGORY);
			stmt.setInt(1, itemCategory);
			rset = stmt.executeQuery();
			if(rset.next()){
				result = new ItemsBean();
				result.setItemId(rset.getInt("ITEM_ID"));
				result.setSeller(rset.getString("SELLER"));
				result.setBuyer(rset.getString("BUYER"));
				result.setItemCategory(rset.getInt("ITEM_CATEGORY"));
				result.setTitle(rset.getString("TITLE"));
				result.setStartPrice(rset.getDouble("START_PRICE"));
				result.setDirectPrice(rset.getDouble("DIRECT_PRICE"));
				result.setBid(rset.getInt("BID"));
				result.setEndTime(rset.getDate("END_TIME"));
				result.setItemDiscribe(rset.getString("ITEM_DISCRIBE"));
				result.setItemStatus(rset.getInt("ITEM_STATUS"));
				result.setThreadLock(rset.getInt("THREAD_LOCK"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rset!=null){
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt!=null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
	private static final String SELECT_ALL = "SELECT * FROM ITEMS ";

	/* (non-Javadoc)
	 * @see items.model.dao.ItemsDAO#selectAll()
	 */
	@Override
	public List<ItemsBean> selectAll(){
		List<ItemsBean> result=null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
//			conn = ds.getConnection();
			stmt = conn.prepareStatement(SELECT_ALL);
			rset = stmt.executeQuery();
			result = new ArrayList<ItemsBean>();
			while(rset.next()){
				ItemsBean item = new ItemsBean();
				item.setItemId(rset.getInt("ITEM_ID"));
				item.setSeller(rset.getString("SELLER"));
				item.setBuyer(rset.getString("BUYER"));
				item.setItemCategory(rset.getInt("ITEM_CATEGORY"));
				item.setTitle(rset.getString("TITLE"));
				item.setStartPrice(rset.getDouble("START_PRICE"));
				item.setDirectPrice(rset.getDouble("DIRECT_PRICE"));
				item.setBid(rset.getInt("BID"));
				item.setEndTime(rset.getDate("END_TIME"));
				item.setItemDiscribe(rset.getString("ITEM_DISCRIBE"));
				item.setItemStatus(rset.getInt("ITEM_STATUS"));
				item.setThreadLock(rset.getInt("THREAD_LOCK"));
				result.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rset!=null){
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt!=null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
	private static final String INSERT = "INSERT INTO ITEMS(SELLER, BUYER, ITEM_CATEGORY, TITLE, "
			+ "STARTPRICE, DIRECTPRICE, BID, END_TIME,ITEM_DISCRIBE, ITEM_STATUS,THREAD_LOCK) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

	/* (non-Javadoc)
	 * @see items.model.dao.ItemsDAO#insert(items.model.ItemsBean)
	 */
	@Override
	public ItemsBean insert(ItemsBean bean){
		ItemsBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
//			conn = ds.getConnection();
			stmt = conn.prepareStatement(INSERT);
			if(bean!=null){
				stmt.setString(1, bean.getSeller());
				stmt.setString(2, bean.getBuyer());
				stmt.setInt(3, bean.getItemCategory());
				stmt.setString(4, bean.getTitle());
				stmt.setDouble(5, bean.getStartPrice());
				stmt.setDouble(6, bean.getDirectPrice());
				stmt.setInt(7, bean.getBid());
				java.util.Date endTime = bean.getEndTime();
				if(endTime!=null){
					long time = endTime.getTime();
					stmt.setDate(8, new java.sql.Date(time));
				}else
					stmt.setDate(8, null);
				stmt.setString(9, bean.getItemDiscribe());
				stmt.setInt(10, bean.getItemStatus());
				stmt.setInt(11, bean.getThreadLock());
				int i = stmt.executeUpdate();
				if(i == 1){
					result = bean;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(stmt!=null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	private static final String UPDATE ="UPDATE ITEMS SET SELLER=?, BUYER=?,ITEM_CATEGORY=?,TITLE=?, "
			+ "STARTPRICE=?, DIRECTPRICE=?, BID=?, END_TIME=?,ITEM_DISCRIBE=?, ITEM_STATUS=?,THREAD_LOCK=? WHERE ITEM_ID=?";

	/* (non-Javadoc)
	 * @see items.model.dao.ItemsDAO#update(java.lang.String, java.lang.String, int, java.lang.String, double, double, int, java.util.Date, java.lang.String, int, int, int)
	 */
	@Override
	public ItemsBean update(String seller, String buyer,int itemCategory, String title, 
			double startPrice, double directPrice, int bid, java.util.Date endTime ,
			String itemDiscribe,int itemStatus, int threadLock, int itemId){
		ItemsBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
//			conn = ds.getConnection();
			stmt = conn.prepareStatement(UPDATE);
			stmt.setString(1, seller);
			stmt.setString(2, buyer);
			stmt.setInt(3, itemCategory);
			stmt.setString(4, title);
			stmt.setDouble(5, startPrice);
			stmt.setDouble(6, directPrice);
			stmt.setInt(7, bid);
			if(endTime!=null){
				long time = endTime.getTime();
				stmt.setDate(8, new java.sql.Date(time));
			}else{
				stmt.setDate(8, null);
			}
			stmt.setString(9, itemDiscribe);
			stmt.setInt(10, itemStatus);
			stmt.setInt(11, threadLock);
			stmt.setInt(12, itemId);
			int i = stmt.executeUpdate();
			if(i == 1){
				result = this.selectId(itemId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(stmt!=null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	private static final String DELETE = "DELETE FROM ITEMS WHERE ITEM_ID=?";

	/* (non-Javadoc)
	 * @see items.model.dao.ItemsDAO#delete(int)
	 */
	@Override
	public boolean delete(int itemId){
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
//			conn = ds.getConnection();
			stmt = conn.prepareStatement(DELETE);
			stmt.setInt(1, itemId);
			int i = stmt.executeUpdate();
			if(i == 1){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(stmt!=null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	
	
	
	
	public static void main(String[] args){
		ItemsDAOjdbc dao = new ItemsDAOjdbc();
		//新增
		ItemsBean bean = new ItemsBean();
		bean.setSeller("aaaaa");
		bean.setBuyer("");
		bean.setItemCategory(1);
		bean.setTitle("杯子");
		bean.setStartPrice(new Double(10));
		bean.setDirectPrice(new Double(1000));
		bean.setBid(10);
		bean.setEndTime(java.sql.Date.valueOf("2015-09-11"));
		bean.setItemDiscribe("這是一個杯子");
		bean.setItemStatus(0);
		bean.setThreadLock(0);
		dao.insert(bean);
		System.out.println("執行新增");
		
		//修改
//		ItemsBean bean2 = new ItemsBean();
//		bean2.setSeller("a1234");
//		bean2.setBuyer("b1234");
//		bean2.setTitle("茶杯");
//		bean2.setStartPrice(new Double(15));
//		bean2.setDirectPrice(new Double(1500));
//		bean2.setBid(10);
//		bean2.setEndTime(java.sql.Date.valueOf("2011-01-01"));
//		bean2.setItemStatus("xxxxxxxxxxxxxx");
//		bean2.setThreadLock(0);
//		bean2.setItemId(4);
//		dao.update(bean2.getSeller(), bean2.getBuyer(), bean2.getTitle(), bean2.getStartPrice(),
//				bean2.getDirectPrice(), bean2.getBid(), bean2.getEndTime(), bean2.getItemStatus(),
//				bean2.getThreadLock(), bean2.getItemId());
//		System.out.println("執行修改");
		
		//刪除
//		dao.delete(5);
//				System.out.println("執行刪除");
		
		//查詢一筆
//		ItemsBean bean3 = dao.select(4);
//		System.out.println(bean3.getItemId()+","+bean3.getSeller()+","+bean3.getBuyer()
//		+","+bean3.getTitle()+","+bean3.getStartPrice()+","+bean3.getDirectPrice()+","
//		+bean3.getBid()+","+bean3.getEndTime()+","+bean3.getItemStatus()+","
//		+bean3.getThreadLock());
//		System.out.println("查詢一筆");
		
		//查詢全部
//		List<ItemsBean> bean4 = dao.selectAll();
//		for(ItemsBean list : bean4){
//			System.out.println(list.getItemId()+","+list.getSeller()+","+list.getBuyer()
//			+","+list.getTitle()+","+list.getStartPrice()+","+list.getDirectPrice()+","
//			+list.getBid()+","+list.getEndTime()+","+list.getItemStatus()+","
//			+list.getThreadLock());
//		}
//		System.out.println("查詢全部");
	}
	
	
	
}

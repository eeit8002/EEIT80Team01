package items.model.dao;

import java.sql.Connection;
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

public class ItemsDAOjdbc implements ItemsDAO {
	private DataSource ds = null;
	public ItemsDAOjdbc(){
		Context ctx;
		try {
			ctx = new InitialContext();
			ds = (DataSource)ctx.lookup(GlobalService.JNDI_DB_NAME);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	private static final String SELECT_BY_ID = "SELECT * FROM ITEMS WHERE ITEM_ID = ?";
	/* (non-Javadoc)
	 * @see items.model.dao.ItemsDAO#select(int)
	 */
	@Override
	public ItemsBean select(int itemId){
		ItemsBean result=null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(SELECT_BY_ID);
			stmt.setInt(1, itemId);
			rset = stmt.executeQuery();
			if(rset.next()){
				result = new ItemsBean();
				result.setItemId(rset.getInt("itemId"));
				result.setSeller(rset.getString("seller"));
				result.setBuyer(rset.getString("buyer"));
				result.setTitle(rset.getString("title"));
				result.setStartPrice(rset.getDouble("startPrice"));
				result.setDirectPrice(rset.getDouble("directPrice"));
				result.setBid(rset.getInt("bid"));
				result.setEndTime(rset.getDate("endtime"));
				result.setItemStatus(rset.getString("itemStatus"));
				result.setThreadLock(rset.getInt("threadLock"));
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
			conn = ds.getConnection();
			stmt = conn.prepareStatement(SELECT_ALL);
			rset = stmt.executeQuery();
			result = new ArrayList<ItemsBean>();
			while(rset.next()){
				ItemsBean item = new ItemsBean();
				item.setItemId(rset.getInt("itemId"));
				item.setSeller(rset.getString("seller"));
				item.setBuyer(rset.getString("buyer"));
				item.setTitle(rset.getString("title"));
				item.setStartPrice(rset.getDouble("startPrice"));
				item.setDirectPrice(rset.getDouble("directPrice"));
				item.setBid(rset.getInt("bid"));
				item.setEndTime(rset.getDate("endTime"));
				item.setItemStatus(rset.getString("itemStatus"));
				item.setThreadLock(rset.getInt("thresdLock"));
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
	private static final String INSERT = "INSERT INTO ITEMS(ITEM_ID, SELLER, BUYER,TITLE, "
			+ "STARTPRICE, DIRECTPRICE, BID, END_TIME, ITEM_STATUS,THREAD_LOCK) VALUES(?,?,?,?,?,?,?,?,?,?)";
	/* (non-Javadoc)
	 * @see items.model.dao.ItemsDAO#insert(items.model.ItemsBean)
	 */
	@Override
	public ItemsBean insert(ItemsBean bean){
		ItemsBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(INSERT);
			if(bean!=null){
				stmt.setInt(1, bean.getItemId());
				stmt.setString(2, bean.getSeller());
				stmt.setString(3, bean.getBuyer());
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
				stmt.setString(9, bean.getItemStatus());
				stmt.setInt(10, bean.getThreadLock());
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
	private static final String UPDATE ="UPDATE ITEMS SET SELLER=?, BUYER=?,TITLE=?, "
			+ "STARTPRICE=?, DIRECTPRICE=?, BID=?, END_TIME=?, ITEM_STATUS=?,THREAD_LOCK=? WHERE ITEM_ID=?";
	/* (non-Javadoc)
	 * @see items.model.dao.ItemsDAO#update(java.lang.String, java.lang.String, java.lang.String, double, double, int, java.util.Date, java.lang.String, int, int)
	 */
	@Override
	public ItemsBean update(String seller, String buyer, String title, 
			double startPrice, double directPrice, int bid, java.util.Date endTime ,
			String itemStatus, int threadLock, int itemId){
		ItemsBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(UPDATE);
			stmt.setString(1, seller);
			stmt.setString(2, buyer);
			stmt.setString(3, title);
			stmt.setDouble(4, startPrice);
			stmt.setDouble(5, directPrice);
			stmt.setInt(6, bid);
			if(endTime!=null){
				long time = endTime.getTime();
				stmt.setDate(7, new java.sql.Date(time));
			}else{
				stmt.setDate(7, null);
			}
			stmt.setString(8, itemStatus);
			stmt.setInt(9, threadLock);
			stmt.setInt(10, itemId);
			int i = stmt.executeUpdate();
			if(i == 1){
				result = this.select(itemId);
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
			conn = ds.getConnection();
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
}

package kr.itedu.boardmvc.common;

import java.sql.Connection;

import static kr.itedu.boardmvc.common.DBConnector.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import kr.itedu.boardmvc.BoardVO;
//import kr.itedu.test1.DBConnector;


public class BoardDAO {
	private static BoardDAO dao;
	
	
	private BoardDAO() {}
	
	public static BoardDAO getInstance() { //싱글톤
		if(dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}
	
	public ArrayList<BoardVO> getBoardList(int btype) {
		ArrayList<BoardVO> result = new ArrayList<BoardVO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getConn();
			String query = String.format(" select " + " bid, btitle, "
					+ " to_char(bregdate, 'YYYY-MM-DD hh24:mi') as bregdate " + " from t_board%d ORDER BY bid desc ", btype);
			
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				int bid = rs.getInt("bid");
				String btitle = rs.getString("btitle");
				String bregdate = rs.getString("bregdate");

				BoardVO bv = new BoardVO();
				bv.setBid(bid);
				bv.setBtitle(btitle);
				bv.setBregdate(bregdate);

				result.add(bv);
				
			}
			
		} catch(SQLException e) {
			//TODO : 예외처리
		} catch(Exception e) {
			//TODO : 예외처리
		} finally {
			close(con, ps, rs);
		}
		
		return result;
	}
	
	public static BoardVO getBoardDetail(int bid, int btype) {
		BoardVO result = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			String query = String.format(" select " + 
					" bid, btitle, bcontent, " + 
					" to_char(bregdate, 'YYYY-MM-DD hh24:mi') as bregdate " + 
					" from t_board%d where bid = ? ", btype);
			ps = conn.prepareStatement(query);
			ps.setInt(1, bid);
			rs = ps.executeQuery();
			if(rs.next()) {				
				result = new BoardVO();
				String btitle = rs.getString("btitle");
				String bregdate = rs.getString("bregdate");
				String bcontent = rs.getString("bcontent");
				
				result.setBid(bid);
				result.setBtitle(btitle);
				result.setBcontent(bcontent);
				result.setBregdate(bregdate);
			}			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, ps, rs);	
		}
		return result;
	}
	
	public static BoardVO Insert(String btitle, String bcontent, int btype) {
		
		BoardVO result = null;
		try {

			Connection conn = DBConnector.getConn();
			String query = String.format(" INSERT INTO T_BOARD%d " + 
					" (BID, BTITLE, BCONTENT) " + 
					" VALUES " + 
					" ((select nvl(max(bid+1), 1) from t_board%d),?,?) ", btype, btype);
			PreparedStatement ps = conn.prepareStatement(query);
			ps = conn.prepareStatement(query);
			ps.setString(1, btitle);
			ps.setString(2, bcontent);
			
			result = (BoardVO) ps.executeQuery();
	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	
		
}


















/*public static ArrayList<BoardVO> getAllBoardList() {
	ArrayList<BoardVO> list = new ArrayList<BoardVO>();
	try {
		Connection conn = DBConnector.getConn();
		String query = " select " + " bid, btitle, bcontent, "
				+ " to_char(bregdate, 'YYYY-MM-DD hh24:mi') as bregdate" + " from t_board ORDER BY bid desc ";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int bid = rs.getInt("bid");
			String btitle = rs.getString("btitle");
			String bregdate = rs.getString("bregdate");

			BoardVO bv = new BoardVO();
			bv.setBid(bid);
			bv.setBtitle(btitle);
			bv.setBregdate(bregdate);

			list.add(bv);

		}
		DBConnector.close(ps, rs);
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}

public static BoardVO getdetailBoardList(int bid) {
	BoardVO detail = new BoardVO();
	try {
		Connection conn = DBConnector.getConn();
		String query = " select " + " bid, btitle, bcontent, "
				+ " to_char(bregdate, 'YYYY-MM-DD hh24:mi') as bregdate" + " from t_board where bid = ? ";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, bid);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			bid = rs.getInt("bid");
			String btitle = rs.getString("btitle");
			String bregdate = rs.getString("bregdate");
			String bcontent = rs.getString("bcontent");

			detail.setBid(bid);
			detail.setBtitle(btitle);
			detail.setBregdate(bregdate);
			detail.setBcontent(bcontent);

		}
		DBConnector.close(ps, rs);
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return detail;
}

public static void Write(String btitle, String bcontent) {
	try {
		Connection conn = DBConnector.getConn();

		String query = "INSERT INTO t_board" + "(bid,btitle,bcontent)"
				+ "VALUES((select nvl(max(bid+1),1) from t_board), ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, btitle);
		ps.setString(2, bcontent);
		ps.executeQuery();
		System.out.println("정상적으로 입력되었습니다.");
		DBConnector.close(ps, null);

	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

public static void upDate(int insertOrUpdate, String btitle, String bcontent) {
	try {
		Connection conn = DBConnector.getConn();

		String query = "UPDATE t_board SET " + "BTITLE = ?, BCONTENT = ? where BID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, btitle);
		ps.setString(2, bcontent);
		ps.setInt(3, insertOrUpdate);
		ps.executeQuery();
		System.out.println("정상적으로 수정되었습니다.");
		DBConnector.close(ps, null);

	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static void delete(int bid) {
	try {
		Connection conn = DBConnector.getConn();

		String query = "DELETE FROM t_board WHERE bid = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, bid);
		ps.executeQuery();
		System.out.println("정상적으로 삭제되었습니다.");
		DBConnector.close(ps, null);

	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
*/
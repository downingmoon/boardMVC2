package kr.itedu.boardmvc.common;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnector {
	
	public static Connection getConn() throws SQLException {
		Context init;
		DataSource ds = null;
		
		try {
			init = new InitialContext();
			ds = (DataSource)init.lookup("java:comp/env/oracleDB");
			System.out.println("연결완료");
		} catch(NamingException e) {
			//TODO : 예외처리
		} catch(Exception e) {
			
		}
		return ds.getConnection();

	}

	public static void close(Connection c, PreparedStatement ps, ResultSet rs) {
		if (rs != null) {try {rs.close();} catch (SQLException e)
		{e.printStackTrace();}}

		if (ps != null) {try {ps.close();} catch (SQLException e) 
		{e.printStackTrace();}}

		if (c != null) {try {c.close();} catch (SQLException e) 
		{e.printStackTrace();}}
		
	}

	public static void close(Connection c) {
		close(c, null, null);
	}

	public static void close(PreparedStatement p) {
		close(null, p, null);
	}

	public static void close(ResultSet r) {
		close(null, null, r);
	}

	public static void close(PreparedStatement p, ResultSet r) {
		close(null, p, r);
	}

	/*
	 * Connection conn; String url = "jdbc:oracle:thin:@localhost:1521:XE"; String
	 * id = "hr"; String pw = "hkitedu";
	 * 
	 * Class.forName("oracle.jdbc.OracleDriver"); conn =
	 * DriverManager.getConnection(url, id, pw); return conn;
	 */
}

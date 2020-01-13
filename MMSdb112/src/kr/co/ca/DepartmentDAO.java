package kr.co.ca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.TreeMap;

public class DepartmentDAO {

	private static final String DRIVER ="oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "ca";
	private static final String PASSWORD = "ca";

	public DepartmentDAO() {
		try {
			Class.forName(DRIVER);
			System.out.println("DB driver loaded ");
		}
		catch (Exception e) {
			e.printStackTrace();
		};
	}
	
	public Map<String,String> getAllDepartments() {
		Map<String,String> mapSorted = new TreeMap<String,String>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select did, dName from depart" ;

		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				String did = rs.getString("did");
				String dname= rs.getString("dName");
				mapSorted.put(did,dname);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if (pstmt!=null) {pstmt.close();}
				if (conn!=null) {conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return mapSorted;

	}
}

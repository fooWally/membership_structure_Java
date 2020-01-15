package com.naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class MemberDAO{

	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER="ca2";
	private static final String PASSWORD ="ca2";

	public MemberDAO() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	
	
	public void insert(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into member2 (id, name, age) values( ?, ?, ?)";
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getAge());			
			pstmt.executeUpdate(); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) {pstmt.close();}
				if (conn!=null) {conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}	
		}
	}
	
}




//		// PreparedStatement VS Statement: the later is inconvenient
//		public void insert2(MemberDTO dto) {
//			Connection conn = null;
//			Statement stmt = null;
//			String sql = "insert into member2 (id, name, age ) values(' "+dto.getId()+" ', ' "+dto.getName()+" ',  "+dto.getAge()+")";
//			try {
//				conn = DriverManager.getConnection(URL, USER, PASSWORD);
//				System.out.println("connection is created");
//				stmt = conn.createStatement(sql);
//				stmt.setString(1, dto.getId());
//				stmt.setString(2, dto.getName());
//				stmt.setInt(3, dto.getAge());			
//				stmt.executeUpdate(); 
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			}finally {
//				try {
//					if(pstmt!=null) {pstmt.close();}
//					if (conn!=null) {conn.close();}
//				} catch (Exception e2) {
//					e2.printStackTrace();
//				}	
//			}
//
//	
//	}


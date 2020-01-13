package kr.co.ca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO{

	private static final String DRIVER ="oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "ca";
	private static final String PASSWORD = "ca";

	public MemberDAO() {
		try {
			Class.forName(DRIVER);
			System.out.println("DB driver loaded ");
		}
		catch (Exception e) {
			e.printStackTrace();
		};
	}

	public void insert(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into member values( ?, ?, ?, ? )";
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("connection is created");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getDid());
			pstmt.setInt(4, dto.getAge());			
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

	// list all members of DB
	public ArrayList<MemberDTO> select() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
//		String sql = "select id, name, age,  d.dName from depart d natural join member order by id";
//		String sql = "select m.id, m.name, m.age, d.dName from depart d full outer join member m on m.did=d.did" ;
		String sql = "select m.id, m.name, m.age, d.dName from depart d right outer join member m on m.did=d.did order by id" ;
		
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String dname= rs.getString("dName");
				list.add(new MemberDTO(id, name, dname, age));
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
		return list;
	}

	public MemberDTO selectById(String id){
		MemberDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select m.id, m.name, m.age, d.dName from depart d full outer join member m on m.did=d.did where m.id=?";
//		String sql = "select * member m where m.id=?";
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				id = rs.getString("id");
				String name = rs.getString("name");
				String did = rs.getString("dName");
				int age = rs.getInt("age");
				dto = new MemberDTO(id, name, did, age);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs!=null) {	rs.close();}
				if (pstmt!=null) {pstmt.close();}
				if (conn!=null) {conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}

	public void update(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update member set name=?, age=?, did=? where id=?";
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			pstmt.setString(3, dto.getDid());
			pstmt.setString(4, dto.getId());

			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt!=null) {pstmt.close();}
				if (conn!=null) {conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void delete(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql ="delete from member where id=?";
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt!=null) {pstmt.close();}
				if (conn!=null) {conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	

}





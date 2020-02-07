package com.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class MemberDAO {
	private DataSource dataFactory; 
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public MemberDTO login(MemberDTO dto) {
		MemberDTO login = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member3 where id=? and pw=?";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			rs = pstmt.executeQuery(); 
			if (rs.next()) {
				String name = rs.getString("name");
				String birth = rs.getString("birth");
				String email = rs.getString("email");
				login = new MemberDTO(dto.getId(), name, dto.getPw(), birth, email);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return login;
	}

	public void update(MemberDTO dto) {
		System.out.println("dto ="+dto);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "update member3 set name=?, birth=?, email=?  where id=? and pw =?";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getBirth());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getId());
			pstmt.setString(5, dto.getPw());
			pstmt.executeUpdate();//
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
	}

	public List<MemberDTO> list(){
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection conn= null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		String sql = "select * from member3 order by id";
		try {
			conn = dataFactory.getConnection();// use connection pool instead of Driver
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String pw = rs.getString("pw");
				String birth = rs.getString("birth");
				String email = rs.getString("email");
				list.add(new MemberDTO(id, name, pw, birth, email));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		return list;
	}
	
	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if (rs!=null) rs.close();
			if (pstmt!=null) pstmt.close();
			if (conn!=null) conn.close(); //connection pool을 dataFactory에 connection 반납
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public MemberDTO read(String id) {
		MemberDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member3 where id=?";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				String  pw = rs.getString("age");
				String birth = rs.getString("birth");
				String  email = rs.getString("email");
				dto = new MemberDTO(id, name, pw, birth, email);
			}
		} catch (Exception e) {
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return dto;
	}
	

//	updateUI : only display old data and update : real update action
	public MemberDTO updateui(String id) {
		return read(id);
	}
	
	public void delete(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "delete from member2 where id=?";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
	}


	public MemberDTO searchIDnPW(String name, String birth, String email) {
		MemberDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member3 where name=? and email=? and birth=? ";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, birth);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String id = rs.getString("id");
				String  pw = rs.getString("pw");
				dto = new MemberDTO(id, name, pw, birth, email);
			}
		} catch (Exception e) {
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return dto;
	}

	
	
}

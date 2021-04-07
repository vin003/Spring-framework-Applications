package com.durgasoft.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.core.support.AbstractLobStreamingResultSetExtractor;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.util.FileCopyUtils;

import com.durgasoft.dto.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private JdbcTemplate jdbcTemplate ; 
	private LobHandler lobHandler ;
	
	
	
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	public LobHandler getLobHandler() {
		return lobHandler;
	}

	public void setLobHandler(LobHandler lobHandler) {
		this.lobHandler = lobHandler;
	}

	@Override
	public void insertEmploye(Employee emp) {
		String query = "insert into emp20 values(?,?,?,?)" ;
		jdbcTemplate.execute(query , new AbstractLobCreatingPreparedStatementCallback(lobHandler) {
			
			@Override
			protected void setValues(PreparedStatement pst, LobCreator lobCreator) throws SQLException, DataAccessException {
			try {
				
				pst.setInt(1 , emp.getEno());
				pst.setString(2, emp.getEname());
				FileInputStream fis = new FileInputStream(emp.getEmp_image()) ; 
				FileReader fr = new FileReader(emp.getEmp_resume()) ; 
			lobCreator.setBlobAsBinaryStream(pst, 3	, fis, (int) emp.getEmp_image().length());
			lobCreator.setClobAsCharacterStream(pst, 4, fr,(int) emp.getEmp_resume().length());
			
				
			} catch (Exception e) {
				
			}	
				
			}
		});
	
		
		
	}

	@Override
	public Employee readEmployee(int eno) {
	Employee emp  =null ;
	String query = "";
	try {
		query="select * from app20 where ENO="+eno ; 
		jdbcTemplate.query(query,new AbstractLobStreamingResultSetExtractor() {

			@Override
			protected void streamData(ResultSet rs) throws SQLException, IOException, DataAccessException {
			emp.setEno(rs.getInt("ENAME"));
			emp.setEname(rs.getString("ENAME"));
			File file1 = new File("D:/Vineet-1.jpg");
			FileOutputStream fos = new FileOutputStream(file1) ;
			
			FileCopyUtils.copy(lobHandler.getBlobAsBinaryStream(rs, 3), fos);
			emp.setEmp_image(file1);
			
			File file2 = new File("D:/Yuva-demo.txt");
			FileWriter fw = new FileWriter(file2);
				FileCopyUtils.copy(lobHandler.getClobAsCharacterStream(rs, 4), fw);
				
			emp.setEmp_resume(file2);
				
			}
			
			
		}) ; 
		
		
		
	} catch (Exception e) {
	e.printStackTrace();
	}
		return emp;
	}
	
	

}

package com.durgasoft.dao;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.durgasoft.dto.Student;



public class StudentDaoImpl implements StudentDao {
	
	//JdbcTemplate jdbcTemplate = 
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate ;
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	@Override
	public String add(Student std) {
		
	//checking exist or now 
		String status = "";
		String query =" ";
		try {
			query="select *  from student where SID= :sid";
			
			Map<String, Object> paramMap = new HashMap<String, Object>() ; 
		 
			paramMap.put("sid", std.getSid());
			
		List<Student> stdList = namedParameterJdbcTemplate.query(query, paramMap, ( rs, index) -> {
				Student std1 = new Student() ;
				std1.setSid(rs.getString("SID"));
				std1.setSname(rs.getString("SNAME"));
				std1.setSaddr(rs.getString("SADDR"));
				return std1 ; 
			} ) ; 
			
			if (stdList.isEmpty() == true)
			{  
				paramMap  = new HashMap<String,Object>() ;
			
				paramMap.put("sid", std.getSid());
				paramMap.put("sname", std.getSname());
				paramMap.put("saddr", std.getSaddr());
				
				query = "insert into student values(:sid,:sname,:saddr)";
				int rowCount = namedParameterJdbcTemplate.update(query, paramMap);
				
				if(rowCount ==1)
				{
					status ="Student Added Successfully" ; 
				}
				else
				{
					status = "Student Addition Failure";
				}
				
				
			}else
			{
				status = "Student Already Exist" ;
			}
		} catch (Exception e) {
			status ="Student Addition Failure" ; 
			e.printStackTrace();
		}
		return status ;
	}

	@Override
	public Student search(String sid) {
		Student std = null ;
		String query="";
		try {
			query="select * from student where SID=:sid";
			Map<String, Object> map = new HashMap<String , Object>() ;
			map.put("sid", sid);
			
			List<Student> stdList= 	namedParameterJdbcTemplate.query(query, map,( rs, index) -> {
				Student std1 = new Student();
				std1.setSid(rs.getString("SID"));
				std1.setSname(rs.getString("SNAME"));
				std1.setSaddr(rs.getString("SADDR"));
				return std1 ; 
			} );
			
			if (stdList.isEmpty() == true)
			{
			std = null ; 	
			}
			else
			{
			return 	stdList.get(0);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return std;
	}

	@Override
	public String update(Student std) {
		String status = "";
	
	
		String query = "update student set SNAME=:sname, SADDR=:saddr where SID=:sid";
		Map<String, Object> map = new HashMap<>() ;
		map.put("sid", std.getSid());
		map.put("sname",std.getSname());
		map.put("saddr",std.getSaddr());
		
		 int rowCount = namedParameterJdbcTemplate.update(query, map);
		 if (rowCount ==1)
		 {
			 status ="Student Updated Successfully";
		 }else{
			 status = "Student Updation Failure" ; 
		 }
		 	
	
	
		return status;
	}

	@Override
	public String delete(String sid) {
	String status = "";
	{
			String query="delete from student where SID=:sid";
			Map<String , Object> paramMap = new HashMap<String,Object>(); 
			paramMap.put("sid", sid);
			
			int rowCount = namedParameterJdbcTemplate.update(query, paramMap);
			if (rowCount ==1)
			{
				status= "Student Record Deleted Successfully";
			}
			else{
				status= " Student Recored Failure..";
			}
		}
	
		return status;
	}

}


package com.durgasoft.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.durgasoft.dto.Employee;

public class EmployeeRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		//Fetching the taking the user provided data  provided in the test class
		//sorry it is not fetching data from user that we re doing in test class , here
		// we will convert the exsiting data and supply to DaoImpl clss
		Employee emp = new Employee() ; 
		emp.setEno(rs.getInt("ENO"));
		emp.setEname(rs.getString("ENAME"));
		emp.setEsal(rs.getInt("ESAL"));
		emp.setEaddr(rs.getString("EADDR"));
		
		return emp;
	}
	

}

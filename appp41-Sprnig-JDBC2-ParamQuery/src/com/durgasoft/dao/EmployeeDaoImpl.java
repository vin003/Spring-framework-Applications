package com.durgasoft.dao;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
//DriverManagerDataSource 
import com.durgasoft.dto.Employee;
import com.durgasoft.mapper.EmployeeRowMapper;

public class EmployeeDaoImpl  implements EmployeeDao
{
private JdbcTemplate jdbcTemplate ; 

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public String add(Employee emp) {
		String status = null ;
		try {
			
	List<Employee> empList=jdbcTemplate.query("select * from employee", new EmployeeRowMapper());
	
	if (empList.isEmpty() == true)
	
	{
		
		int rowCount = jdbcTemplate.update("insert into employee values(?,?,?,?)",new Object[]{emp.getEno() ,emp.getEname(),emp.getEsal(),emp.getEaddr()});
		
		
		if (rowCount == 1) //means cursor position has been change to 1 
		{
			status ="Employee Inserted  Succesfully" ; 
		}
		else
		{
			status = "Employee insertion Failure ";
		}
	}
		
	else {
		status ="Employee  Existed Already" ; 
	}
					
		} catch (Exception e) {
			status= "Employee Status failure" ; 
		e.printStackTrace(); 
		}
		return status ; 
	}
	
	@Override
	public Employee search(int eno) {
		String status = "" ;
		Employee emp = null ;
		try {
			 List<Employee> empList = jdbcTemplate.query("select * from employee where ENO =?",new Object[] {eno }  , (ResultSet rs ,int index ) -> {
				 Employee emp1 = new Employee() ;
				 emp1.setEno(rs.getInt("ENO"));
				 emp1.setEname(rs.getString("ENAME"));
				 emp1.setEsal(rs.getInt("ESAL"));
				 emp1.setEaddr(rs.getString("EADDR"));
				 
				 return emp1 ; 
			 }) ; 
			 
			 if (empList.isEmpty() == true)
			 {
				emp = null ;  
			 }else{
				 emp = empList.get(0);
			 }
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return emp ;
	}

	@Override
	public String delete(int eno) {
		String status = "" ; 
		try {
			
			Employee emp = search(eno) ; 
			if (emp ==null)
			{
				status ="Employee not existed" ; 
			}else{
				int rowCount = jdbcTemplate.update("delete from employee where ENO=?",new Object[] {eno}) ;
				if (rowCount ==1)
				{
					status="Emplyoee record deleted successfully";
				}
				else{
					status ="Employee record deletion failure " ;
				}
				
				
			}
			
		} catch (Exception e) {
			status ="Employee delete failure" ; 
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String update(Employee emp) {
		String status = ""  ;
		
		try {
			
		/*	Employee emp2 =search(emp.getEno()) ;
			if (emp2==null),
			{
				status="Employee do not exist.." ; 
			}
		*/	
			int rowCount  = jdbcTemplate.update("update employee SET  ENAME=?"+","+"ESAL=?"+",EADDR=?"+"WHERE ENO=?",new Object[] {emp.getEname(),emp.getEsal(),emp.getEaddr(),emp.getEno()} ) ; 
			if ( rowCount==1)
			{
				 status = "Employee Updated Successfully" ; 
 			}
			else{
				status ="Employee Updation Failure" ; 
			}

			
			
			}catch (Exception e) {
			e.printStackTrace(); 
		}
				
		return status;
	}

}

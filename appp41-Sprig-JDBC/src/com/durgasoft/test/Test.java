package com.durgasoft.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.durgasoft.dao.EmployeeDaoImpl;
import com.durgasoft.dto.Employee;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/durgasoft/resources/applicationContext.xml") ;
		EmployeeDaoImpl employeeDao =(EmployeeDaoImpl)context.getBean("employeeDao");
		Employee emp = new Employee();
		emp.setEno(111);
		emp.setEname("AAA");
		emp.setEaddr("HYD");
		emp.setEsal(25000);
		
	
/*	String status = employeeDao.add(emp);
	System.out.println(status);
*/	
	


		/*Employee emp1 = employeeDao.search(111);
		if (emp ==null ) 
		{
			System.out.println("Employee not existed...");
		}
		else{
			System.out.println("Employee Details.");
			System.out.println("-----------------------------------------");
			System.out.println("Employee Id  				             : "+emp1.getEno());
			System.out.println("Employee Name         				     : "+emp1.getEname());
			System.out.println("Employee Salary           				 : "+emp1.getEsal());
			System.out.println("Employee Address			             : "+emp1.getEaddr());
			System.out.println();
		}
		*/
	
 // Deletion operations....
		/*String status = employeeDao.delete(221) ;
		System.out.println("Employee status >>>>>>>>>>>>>>> "+status);*/
		

 
//	String status = employeeDao.update(emp3) ; 
/*	 
	
System.out.println("Update on the Employee.....");
Employee  emp2   = employeeDao.search(111);
System.out.println("Before Update.... ");
System.out.println("Employee Id  				             : "+emp2.getEno());
System.out.println("Employee Name         				     : "+emp2.getEname());
System.out.println("Employee Salary           				 : "+emp2.getEsal());
System.out.println("Employee Address			             : "+emp2.getEaddr());
System.out.println( ) ;*/

		Employee emp1 =   new Employee();
		emp1.setEno(111);
	emp1.setEname("RAW");	
	emp1.setEaddr("INDIA");
	emp1.setEsal(6500);
	String status  = employeeDao.update(emp1);
	System.out.println("Employee Detail After the updation....");
	System.out.println("New Status ..."+status);
	System.out.println("Employee Id  				             : "+emp1.getEno());
	System.out.println("Employee Name         				     : "+emp1.getEname());
	System.out.println("Employee Salary           				 : "+emp1.getEsal());
	System.out.println("Employee Address			             : "+emp1.getEaddr());
	
	
	
	}

}

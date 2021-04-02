package com.durgasoft.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.durgasoft.dao.EmployeeDaoImpl;
import com.durgasoft.dto.Employee;

public class Test {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/durgasoft/resources/applicationContext.xml") ;
		EmployeeDaoImpl employeeDao =(EmployeeDaoImpl)context.getBean("employeeDao");
		while(true){
			
		
		System.out.println("Employee Menu");
		System.out.println("---------------------------------");
		System.out.println("1. Add Employee");
		System.out.println("2. Search Employee");
		System.out.println("3. Update Employee");
		System.out.println("4. Delete  Employee");
		System.out.println("5. EXIT");
		System.out.println();
		
		System.out.print("Enter your option from [1,2,3,4,5] : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int option =Integer.parseInt(br.readLine());
		Employee emp = null ; 
		String status ="" ; 
		int eno,esal;
		String ename , eaddr ; 
		
		switch (option) {
		case 1:
			System.out.println("=======ADD MODULE=======");
			
			//
				
				//emp = employeeDao.search(eno);
				
					System.out.print("Employee number  : ");
					eno =Integer.parseInt(br.readLine());
					
					System.out.print("Employee Name   : ");
					ename = br.readLine();
					System.out.print("Employee Salary   : ");
					esal = Integer.parseInt(br.readLine());
					System.out.print("Employee Address         : ");
					eaddr= br.readLine(); 
					emp = new Employee();
					emp.setEno(eno);
					emp.setEname(ename);
					emp.setEsal(esal);
					emp.setEaddr(eaddr);
					status = employeeDao.add(emp) ;
					
					System.out.println(status);
				
					System.out.print("Employee number  : ");
					eno =Integer.parseInt(br.readLine());
					
			break;
		case 2:
			System.out.println("============SEARCH MODULE============");
			System.out.print("Employee Number    : ");
			eno = Integer.parseInt(br.readLine());
			emp = employeeDao.search(eno);
			if (emp !=null){
			System.out.println("Employee Number             : "+emp.getEno());
			System.out.println("Employee Name               : "+emp.getEname());
			System.out.println("Employee Salary             : "+emp.getEsal());
			System.out.println("Employee Address            : "+emp.getEaddr());
			System.out.println();	
			}
			else{
				System.out.println("Employee Not Existed.");
			}
			
			break; 
		case 3:
			System.out.println("==========UPDATE MODULE=========");
			System.out.print("Employee No.          :");
			eno =Integer.parseInt(br.readLine());
			emp = employeeDao.search(eno);
			
			if (emp != null)
			{
				System.out.println("Employee No        :"+emp.getEno());
				System.out.print("Employee [Old Name :"+emp.getEname() +"]   : ");
				String ename_new = br.readLine() ; 
				System.out.print("Employee [Old Sal" +emp.getEsal() +"] :");
				int esal_new = Integer.parseInt(br.readLine());
				System.out.print("Employee [Old Address:" +emp.getEaddr() +"]  :");
				String eaddr_new =br.readLine(); 
				
				Employee emp1 = new Employee() ; 
				emp1.setEno(eno);
				emp1.setEname(ename_new);
				emp1.setEsal(esal_new);
				emp1.setEaddr(eaddr_new);
				status = employeeDao.update(emp1);
				System.out.println(status);
			}
			else
			{
				System.out.println("Employee Do not Exist ") ; 
			}
			
			break ;
			
		case 4 :
			
			System.out.println("==============DELETE MODULE================");
			System.out.print("Employee No..            : ");
			eno = Integer.parseInt(br.readLine());
			status = employeeDao.delete(eno);
			System.out.println(status);
			
			break; 
			
		case 5:
			
			System.out.println("************Thanq for using for this App");
			System.exit(0);
			break;
		default:
			System.out.println("Plese select option from the provided list [1,2,3,4,5");
			break;
		}
		
		}
		
		/*Employee emp = new Employee();
		emp.setEno(111);
		emp.setEname("AAA");
		emp.setEaddr("HYD");
		emp.setEsal(25000);
		*/
	
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
/*
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
	
*/	
	
	}

}

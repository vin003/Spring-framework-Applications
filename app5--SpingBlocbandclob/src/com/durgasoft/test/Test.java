package com.durgasoft.test;

import java.io.File;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.durgasoft.dao.EmployeeDao;
import com.durgasoft.dao.EmployeeDaoImpl;
import com.durgasoft.dto.Employee;

public class Test {

	public static void main(String[] args) {
	
		ApplicationContext  context = new ClassPathXmlApplicationContext("/com/durgasoft/resources/applicationContext.xml");
		EmployeeDao employeeDao =(EmployeeDaoImpl)context.getBean("employeeDao");
		
		Employee emp= new Employee();
		emp.setEno(111);
		emp.setEname("APP01");
		emp.setEmp_image(new File("D:/vineet.jpg"));
		emp.setEmp_resume(new File("D:/Yuva.txt"));
		employeeDao.insertEmploye(emp);
		System.out.println("Employee Inserted Sucessfully.....");
		
		
		/*
		Employee emp2 = employeeDao.readEmployee(111)  ; 
		System.out.println("Employee Details");
		System.out.println("----------------------------");
		System.out.println();
		System.out.println("Employee Number         : "+emp2.getEno());
		
		System.out.println("Employee  Name          :  "+emp2.getEname());
		System.out.println("Employee Image            : "+emp2.getEmp_image());
		System.out.println("Employee Resume            :  "+emp2.getEmp_resume());
		
	
		
*/
	}

}

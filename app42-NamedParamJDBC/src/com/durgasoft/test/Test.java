package com.durgasoft.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.durgasoft.dao.StudentDaoImpl;
import com.durgasoft.dto.Student;

public class Test {

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		ApplicationContext context= new ClassPathXmlApplicationContext("/com/durgasoft/resources/applicationContext.xml");
		StudentDaoImpl studentDao = (StudentDaoImpl)context.getBean("studentDao");
		while(true)
		{
		System.out.println("Student Menu Application");
		System.out.println("--------------------------------");
		System.out.println("1. Add Student");
		System.out.println("2. Search Student");
		System.out.println("3. Update Student");
		System.out.println("4. Delete Student");
		System.out.println("5. EXIT");
		System.out.print("Your choice             : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int option = Integer.parseInt(br.readLine());
		System.out.println();
		String sid="";
		String sname="";
		Student std = null ; 
		String saddr = "";
		String status = "";
		switch(option)
		{
		case 1 :
			System.out.println("==========ADD MODULE===========");
			System.out.print("Sutdent Id   : ");
			sid=br.readLine();
			System.out.print("Student Name          : ");
			sname= br.readLine() ;
			System.out.print("Student Address      : ");
			saddr= br.readLine() ;
			std = new Student();
			std.setSid(sid);
			std.setSname(sname);
			std.setSaddr(saddr);;
			status = studentDao.add(std);
			System.out.println("Student Status >>>>>>>>>>>>>>"+status);
			/*std= studentDao.search(sid);
			if (std == null)
			{	
				std = studentDao.add(std);
			}
			else {
				System.out.println("Student already exist");
			}*/
			break ;
			
		case 2 :
			System.out.println("===============SEARCH MODULE============");
			System.out.print("Student ID            : ");
			sid = br.readLine() ; 
			std = studentDao.search(sid);
			if (std == null)
			{
				System.out.println("Student Do not Exsit");
				
			}
			else
			{
				System.out.println("Student Details");
				System.out.println("------------------------------");
				System.out.println("Student ID              : "+std.getSid());
				System.out.println("Student Name            : "+std.getSname());
				System.out.println("Student Address         : "+std.getSaddr());;
				System.out.println();
			}
			
			break; 
			
		case 3 :
			System.out.println("===========UPDATE MODULE===============");
			System.out.print("Student ID                : ");
			sid  = br.readLine() ; 
			std = studentDao.search(sid);
			if (std ==null)
			{
				System.out.println("Student Do not exist");
			}
			
			else{
				System.out.print("Student Name [Old Name : "+std.getSname() +" ]        : ");
				sname = br.readLine(); 
				System.out.print("Student Address [Old Address : "+std.getSaddr() +" ]               : ");
				saddr = br.readLine() ; 
				std.setSid(sid);
				std.setSname(sname);
				std.setSaddr(saddr);
				status = studentDao.update(std);
				System.out.println(status);
				
			}
			break ; 
			
		case 4 :
			System.out.println("=============DELETE MODULE ==============");
			System.out.print("Student Id              : ");
			sid = br.readLine()  ;
			std = studentDao.search(sid);
			if (std ==null)
			{
				System.out.println("Student Do not exist");
			}
			else
			{
				status = studentDao.delete(sid);
				System.out.println(status);
			}
			
			break ; 
			
		case 5 : 
			System.out.println("***********Thanq for using application***********");
			System.exit(0);
			break ; 
			
		default :
			System.out.println("Enter your choice either from 1,2,3,4,5");
			break ; 
		}
		}
		
		/*Student std = new Student();
		std.setSid("S-111");
		std.setSname("AAA");
		std.setSaddr("Hyd");
		
		String status = studentDao.add(std);
		System.out.println(status);
		*/
		
		
	/*	//update operation
		Student std = new Student();
		std.setSid("S-111");
		std.setSname("XXX");
		std.setSaddr("CHN");
		String status = studentDao.update(std);
		System.out.println(status);
*/
		//Deletion Operation
		/*Student std = new Student() ; 
		std.setSid("S-111");
		String status = studentDao.delete(std.getSid());
		System.out.println(status);
		*/	
	}

}

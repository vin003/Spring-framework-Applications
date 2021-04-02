package com.durgasoft.dao;

import com.durgasoft.dto.Employee;

public interface EmployeeDao {

	public String add(Employee emp);
	public Employee search(int eno) ; 
	public String delete(int eno);
	public String update(Employee emp);
//i am  still confuse regarding the return type
	}


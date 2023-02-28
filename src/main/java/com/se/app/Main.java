package com.se.app;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.se.daoImpl.AssignmentDaoImpl;
import com.se.daoImpl.EmployeeDaoImpl;
import com.se.daoImpl.ProjectDaoImpl;
import com.se.entity.Assignment;
import com.se.entity.Employee;
import com.se.entity.Project;


public class Main {

	public static void main(String[] args) throws RemoteException {
		EmployeeDaoImpl iml= new EmployeeDaoImpl();
		Employee emp1= new Employee("to", "hieu", "Nam", new Date(2002-1900, 9-1, 19));
		ProjectDaoImpl piml= new ProjectDaoImpl();
		Project pro1= new Project(50, "aaa", "bbb", "ccc",new Date(2022-1900, 5-1, 29));
		
		Employee emp2= new Employee("to", "hieu", "Nam", new Date(2002-1900, 9-1, 19));
		Project pro2= new Project(50, "aaa", "bbb", "ccc",new Date(2022-1900, 5-1, 29));
		
		System.out.println("hello1");
		if(iml.addEmployee(emp1)) {
			System.out.println("Insert successful");
		} else {
			System.err.println("Insert fail");
		}
		
		//iml.searchEmployee("hieu");
				
		if ( piml.addProject(pro1)) {
			System.out.println("Insert successfull");
		} else {
			System.out.println("Insert fail");
		}
		iml.addEmployee(emp2);
		piml.addProject(pro2);
	
		AssignmentDaoImpl aiml= new AssignmentDaoImpl();
		Assignment ass1= new Assignment(emp1, pro1, 20);
		Assignment ass2= new Assignment(emp1, pro2, 20);
		Assignment ass3= new Assignment(emp2, pro1, 20);
		if ( aiml.addAssignment(ass1)) {
			System.out.println("Insert successfull");
		} else {
			System.out.println("Insert fail");
		}
		aiml.addAssignment(ass2);
		aiml.addAssignment(ass3);
		List<Employee> employees= iml.getAllEmployee();
		for(Employee Employee : employees) {
			System.out.println(Employee.toString());
		}
		List<Employee> employee= iml.searchEmployee("hieu");
		for(Employee Employee : employee) {
			System.out.println(Employee.toString());
		}
		
		List<Assignment> Assignments = aiml.getAllAssignment();
		
		for(Assignment Assignment : Assignments) {
			System.out.println(Assignment.toString());
		}

	}

}

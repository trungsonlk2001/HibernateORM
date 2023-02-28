package com.se.server;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Date;
import java.util.List;

import javax.naming.NamingException;

import com.se.dao.AssignmentDao;
import com.se.dao.EmployeeDao;
import com.se.dao.ProjectDao;
import com.se.daoImpl.AssignmentDaoImpl;
import com.se.daoImpl.EmployeeDaoImpl;
import com.se.daoImpl.ProjectDaoImpl;
import com.se.entity.Assignment;
import com.se.entity.Employee;
import com.se.entity.Project;




public class App {
	public static void main(String[] args) throws RemoteException, NamingException {
	
		SecurityManager securityManager = System.getSecurityManager();
		if(securityManager == null) {
			System.setProperty("java.security.policy","rmi/quanLyProject.policy");
			System.setSecurityManager(new SecurityManager());
		}
		try {
			LocateRegistry.createRegistry(9999);
			EmployeeDao employeeDao = new EmployeeDaoImpl();
			ProjectDao projectDao = new ProjectDaoImpl();
			AssignmentDao assignmentDao = new AssignmentDaoImpl();
			

			String ip ="192.168.1.248:9999/securityManager";
			try {
				ip = InetAddress.getLocalHost().getHostAddress();
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			}

			Naming.bind("rmi://localhost:9999/employeeDao", employeeDao);
			Naming.bind("rmi://localhost:9999/projectDao", projectDao);
			Naming.bind("rmi://localhost:9999/assignmentDao", assignmentDao);

			System.out.println("Ready...");
			
//			Employee emp1= new Employee("to", "hieu", "Nam", new Date(2002-1900, 9-1, 19));
//			Employee emp2= new Employee("to", "hieu", "Nam", new Date(2002-1900, 9-1, 19));
//			
//			Project pro1= new Project(50, "aaa", "bbb", "ccc",new Date(2022-1900, 5-1, 29));
//			Project pro2= new Project(50, "aaa", "bbb", "ccc",new Date(2022-1900, 5-1, 29));
//			
//			System.out.println("hello1");
//			if(employeeDao.addEmployee(emp1)) {
//				System.out.println("Insert successful");
//			} else {
//				System.err.println("Insert fail");
//			}
//					
//			if ( projectDao.addProject(pro1)) {
//				System.out.println("Insert successfull");
//			} else {
//				System.out.println("Insert fail");
//			}
//			employeeDao.addEmployee(emp2);
//			projectDao.addProject(pro2);
//		
//			Assignment ass1= new Assignment(emp1, pro1, 20);
//			Assignment ass2= new Assignment(emp1, pro2, 20);
//			Assignment ass3= new Assignment(emp2, pro1, 20);
//			if ( assignmentDao.addAssignment(ass1)) {
//				System.out.println("Insert successfull");
//			} else {
//				System.out.println("Insert fail");
//			}
//			assignmentDao.addAssignment(ass2);
//			assignmentDao.addAssignment(ass3);
//			List<Employee> employees= employeeDao.getAllEmployee();
//			for(Employee Employee : employees) {
//				System.out.println(Employee.toString());
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}

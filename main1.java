package emp_payroll;

import java.util.ArrayList;

import java.util.*;

abstract class Employee{
	private String name;
	private int id;
	
	
	public Employee(String name,int id){
		this.name=name; //this assigns value to corrosponidng local value
		this.id=id;
	}
	
	public String getName() { //getter method for user access without accesing variables directly
		//for securty pourpose
		return name;
	}
	public int getId() {//getter for id 
		return id;
	}
	
	public abstract double cal_sal();//abstract method dosnt have body dont implement it just delrae it and leave it and use abstract keyword
		//iski implementation vaha se denge jis class se isko extend ya inherit karayenge 
	
	//polymorphism
	@Override
	public String toString() {
		return "Employee [name="+name+",id="+id+",salary="+cal_sal()+"]";
	}
	
	
}
class fullTimeEmployee extends Employee{
	private double monthlySal;
	//Implicit super constructor Employee() is undefined for default constructor. Must define an explicit constructor
	//error occured because entended class is abstract and have abstract method 
	//so implement body of abstract method
	//so contrcutor has me made
	public fullTimeEmployee(String name, int id,double monthlySal) {
		//wehave to call values formt this fulltime emp constructor
		//of EMployee construct so we use keyword/method means 
		//to use super class's constructor
		//so we use super
		super(name,id);
		this.monthlySal=monthlySal;
	}
	@Override
	public double cal_sal() {//ovverriding cal_sal
		return monthlySal;
	}
	
}

class partTimeEmployee extends Employee{
	
	private int hoursWorked;
	private double hourlyRate;
	
	public partTimeEmployee(String name,int id,int hoursWorked,double hourlyRate) {
		
		super(name,id);
		this.hoursWorked=hoursWorked;
		this.hourlyRate=hourlyRate;
		
	}
	@Override
	public double cal_sal() {
		return hoursWorked*hourlyRate;//salary calculated
	}
	
}

class payRollSystem{
	//creatting list of employee type
	//multiple employee
	//employee is datatype like structure we use in C
	//every employee will be treated as objeect
	
	//so every employee obj will hvae name id and salary attribute
	//like linked list has multiple boxes or chember like wise
	//no definite size so we use arraylist dynamic 
	//it will double itself as soon as it gets filled
	
	private ArrayList<Employee> employeeList;
	public payRollSystem() {
		employeeList=new ArrayList<>();//mnew allocated new memory
		
	}
	public void addEmployee(Employee employee) {//emplopyee type of object will be passed here
		employeeList.add(employee);//object added to arraylist
		//employee is passed in addEmployee method and then it is added to list
		//using listName.add(); method
	}
	//to remove employee we made method
	public void removeEmployee(int id) {
		//its id weill be primary and using that we weill remove it
		Employee employeeToRemove=null;
		//we have to remove employe type of variable/object
		//but we will find out that object/var using int type of id
		for(Employee employee:employeeList) {
			//for each loop
			
			//here we have 3 attribute in each employee object present in list
			//emp-name,id,sal
			//we hvae to remove whole emp obejct
			//not only id
			//so we created employeeToRemove variable assigning wiht null
			//we used foreach loop
			//the datatyle we want to use ie Employee type we 
			//iterate it with array list we made it before 
			//for each loop iterates list eeasily
			//iterate till the legth of list auto iterate
			//employye type of var ie. employee is iterating in employeeList 
			
			
			if(employee.getId()==id){
			//if employee.id that is id of employe 
			//is matched with the id wich i want to remove
			//i will assign that employee to employeeToRemove
			//	
				
				employeeToRemove=employee;
				break;
			}
		}
		
		//if i find the employee matching with id then it must contain 
		//some info because we assigned it on line 125
		//so it is not null
		//so it will be removed using remove(); function
		if(employeeToRemove !=null) {
			employeeList.remove(employeeToRemove);
			
			//remove fucntion dlts the obj in list
			
		}
	}
	
	
	public void displayEmployees() 
	{
		for(Employee employee:employeeList) {
			System.out.println(employee);//just printing elements in arraylist
		}
		
	}
}

public class main1 {

	public static void main(String[] args) {
		
		payRollSystem ps=new payRollSystem();
		
		fullTimeEmployee emp1=new fullTimeEmployee("Pranav",1,150000.0);
		partTimeEmployee emp2=new partTimeEmployee("Sanket",2,40,200);
	
		ps.addEmployee(emp1);
		ps.addEmployee(emp2);
		
		//using getter method
		System.out.println("Initital Employee Details");
		ps.displayEmployees();
		
		System.out.println("Removing employees");
		ps.removeEmployee(2);
		System.out.println("Remaining employee details");
		ps.displayEmployees();
		
	}

}

package payroll_system;

import java.util.ArrayList;

abstract class Employee{
    String name;
    int id;

    public Employee(String name,int id ){
        this.name = name;
        this.id = id;


    }

    public String getName(){
        return name;

    }
    public int getId(){
        return id;

    }

     public abstract double calculateSalary();
    @Override

     public String toString(){
        return "Employee [name="+name+"  id="+id+",slary = "+calculateSalary()+"]";

}
}

class FullTimeEmployee extends Employee{
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary){
        super(name,id);
        this.monthlySalary = monthlySalary;
    }
    @Override
    public double calculateSalary(){
        return monthlySalary;
    }

}


class PartTimeEmployee extends Employee{
    private int hourWorked;
    private double hourRate;

    public PartTimeEmployee(String name ,int id, int hourWorked, double hourRate){
        super(name, id);
        this.hourWorked = hourWorked;
        this.hourRate = hourRate;
    }
    @Override
    public double calculateSalary(){
        return hourWorked*hourRate;
    }
}

class PayrollSystem{

    ArrayList<Employee> employeeList = new ArrayList();

    public PayrollSystem(){
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);

    }

    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for( Employee employee2:employeeList){

            if(employee2.getId() == id){
                employeeToRemove = employee2;
                break;


            }
        }
        if(employeeToRemove !=null){
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployee(){
        for(Employee employee:employeeList){
            System.out.println(employee);
        }

    }
}


public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();

          FullTimeEmployee e1 = new FullTimeEmployee("Sunny", 101, 50000);
        PartTimeEmployee e2 = new PartTimeEmployee("Raju", 102, 40, 500);

        payrollSystem.addEmployee(e1);
        payrollSystem.addEmployee(e2);
        System.err.println("initial employee details");
        payrollSystem.displayEmployee();

        System.out.println("removing employee");
        payrollSystem.removeEmployee(102);

        System.out.println("remaining employee details");
        payrollSystem.displayEmployee();



    }
}
